package com.controller;

import com.Dto.Dto;
import com.MD5.MD5;
import com.Pojo.ItripUserBean;
import com.Redis.RedisTool;
import com.Utils.DtoUtils;
import com.VO.itripTokenVo;
import com.common.ErrorCode;
import com.service.ItripUserServiceInter;
import com.service.MailserviceInter;
import com.service.SDKServiceInter;
import com.service.TokenServiceInter;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/user")
@Api(value="Controller_User",description = "用户类" , basePath = "www.baidu.com")
public class Controller_User {
    @Autowired
    @Qualifier("itripUserServiceImple")
    private ItripUserServiceInter itripUserServiceInter;

    @Resource(name="mailserviceImple")
    private MailserviceInter Mailservice;

    @Resource(name="redisTool")
    RedisTool redisTool;    //操作redis缓存数据库的工具类

    @Resource(name="tokenServiceImple")
    private TokenServiceInter tokenService;

    @Resource()
    private SDKServiceInter SDKService;

    @ApiOperation(value="用户登录",notes = "使用账号密码登录")
    @ResponseBody
    @RequestMapping("/login")
    public Dto Login(@ApiParam(name="itripUserBean",value="用于登录的用户类 账号密码必须有",required=true) ItripUserBean itripUserBean, HttpServletRequest request){
        Dto dto = null;
        try{
            itripUserBean.setUserPassword(MD5.getMd5(itripUserBean.getUserPassword(),32)); //密码加密登录
            ItripUserBean userBean = itripUserServiceInter.Login(itripUserBean);
            if(userBean!=null){
                String userAgent =  request.getHeader("user-agent");     //获取头信息中的userAgent的信息
                String token = tokenService.getGenerateToken(userAgent,userBean);   //放入用户对象和userAgent信息生成新的Token
                tokenService.saveToken(token,userBean);    //保存token信息 根据生成的token前缀判断是移动端还是pc端 用户信息转为json字符串作为token对应的键值保存
                itripTokenVo tokenvo = new itripTokenVo(token,
                        Calendar.getInstance().getTimeInMillis()+2*60*60*1000,
                        Calendar.getInstance().getTimeInMillis());   //把token 、token的创建时间
                dto =DtoUtils.returnSuccess("获取token成功",tokenvo);
            }else{
                dto = DtoUtils.returnFail("获取token失败,用户账号密码不正确",ErrorCode.AUTH_ILLEGAL_USERCODE);
            }
        }catch (Exception e){
            dto = DtoUtils.returnFail("获取token失败,用户账号密码不正确"+e.getMessage(),ErrorCode.AUTH_PARAMETER_ERROR);
        }
        return dto;
    }



    @ApiOperation(value="用户注册",notes="根据用户信息注册 并生成激活码 0成功 1失败",produces = "application/json",response = Map.class,protocols = "http")
    @ResponseBody
    @RequestMapping("/register")
    public Dto register(ItripUserBean itripUserBean,@ApiParam(name="choose",value="前端使用邮箱或手机发送验证码 1表示手机 2表示邮箱 其他数字表示自注册也就是没有验证码发送",required = true)@RequestParam("choose") Integer choose){  //choose表示选择的是邮箱验证还是手机短信验证还是自注册
        Dto dto =null;
        itripUserBean.setUserPassword(MD5.getMd5(itripUserBean.getUserPassword(),32));   //md5加密 保存密码
        if(itripUserServiceInter.addUser(itripUserBean)>=0){
            String code = new Date().getTime()+"_"+"888";    //随机生成验证码
            String key =itripUserBean.getUserCode();             //验证码在Redis中的key值
            redisTool.set(key,code,60);  //把验证码的key和值保存进redis 60秒后失效
            if(choose==1){  //表示手机
                try {
                    String result = SDKService.phoneActivation(itripUserBean.getUserCode(),key);
                    dto = DtoUtils.returnSuccess(result);  //返回发送短信的状态提示信息
                } catch (Exception e) {
                    e.printStackTrace();
                    //返回发送短信的状态提示信息
                    dto = DtoUtils.returnFail(e.getMessage(),ErrorCode.AUTH_ACTIVATE_FAILED);
                }
            }else if(choose==2){  //表示邮箱
                Mailservice.sendActiveationMail(itripUserBean.getUserCode(),code);
                dto = DtoUtils.returnSuccess("邮件已发送，60秒后激活码失效");
            }else{  //表示自注册

            }
        }else{
            dto = DtoUtils.returnSuccess("注册账号失败",ErrorCode.AUTH_AUTHENTICATION_FAILED);
        }
        return dto;
    }







    @ApiOperation(value="已有账号激活",protocols = "http",response = Map.class,produces = "application/json",notes = "根据选择发送验证码 1手机发送验证 其他值发送邮件")
    @ResponseBody
    @RequestMapping("/accountActivation")
    public Dto  accountActivation(@ApiParam(value="必须要账号才能发送验证 手机的填手机账号选择choose值为1 邮箱的填邮箱账号选择choose值为其他整数",required = true,name = "userCode")@RequestParam("userCode")String userCode,
                                  @ApiParam(value="值为1发送短信验证 值为其他整数表示邮箱验证",name="choose",required = true)@RequestParam("choose") Integer choose){ //已有账号激活
        Dto dto = null;
        String code = new Date()+"_"+"888";    //随机生成验证码
        String key =userCode;             //验证码在Redis中的key值
        redisTool.set(key,code,60);  //把验证码的key和值保存进redis 60秒后失效
        if(choose==1){ //表示手机短信验证
            try {
                String result = SDKService.phoneActivation(userCode,key);
                 //返回发送短信的状态提示信息
                dto = DtoUtils.returnSuccess(result);
            } catch (Exception e) {
                e.printStackTrace();
                dto = DtoUtils.returnFail(e.getMessage(),ErrorCode.AUTH_ACTIVATE_FAILED);  //返回发送短信的状态提示信息
            }
        }else{//表示邮箱验证
            Mailservice.sendActiveationMail(userCode,code);
            dto = DtoUtils.returnSuccess("邮件已发送，60秒后激活码失效");
        }
        return dto;
    }


/*    @ApiImplicitParams({@ApiImplicitParam(required = true,name = "userBean",paramType = "ItripUserBean",value = "描述"),
            @ApiImplicitParam(required = false,name = "dds",paramType = "form",value = "描述")})*/
    @ApiOperation(value="唯一账号验证 用于注册时保证账号唯一",notes = "账号必填，会验证数据库",produces = "application/json",response = Map.class,protocols = "http")
    @ResponseBody
    @RequestMapping("/UserCodeUnique")
    public Dto getUserCodeUnique(@ApiParam(value="参数必须要有账号字段",name = "userCode",required = true) ItripUserBean userBean){  //账号唯一验证
        ItripUserBean user = itripUserServiceInter.Login(userBean);
        if(user==null){
            return DtoUtils.returnSuccess();
        }else{
            return DtoUtils.returnFail("用户已经存在",ErrorCode.AUTH_USER_ALREADY_EXISTS);
        }
    }

    @ApiOperation(value="更新激活状态字段",notes = "0表示false 1表示true",protocols = "http",response = Map.class,produces ="application/json" )
    @ResponseBody
    @RequestMapping("/updateActivated")
    public Dto updateActivated(@ApiParam(value="获取用户账号必须给userCode",required = true,name = "userCode") ItripUserBean userBean,
                               @ApiParam(value="表示用户输入的验证码,拿来对比Redis,验证码过期不会修改",required = true,name="code")@RequestParam("code")String code){ //code是输入的验证码
        String value = redisTool.get(userBean.getUserCode());  //获取验证码值
        if(value!=null && code.equalsIgnoreCase(redisTool.get(userBean.getUserCode()))){   //当能获取redis的value时比较用户输入的验证码
            ItripUserBean user = itripUserServiceInter.Login(userBean);    //获取用户信息
            if(user!=null){   //判断用户信息是否存在
                if(itripUserServiceInter.updateActivated(user.getId(),1)>0){
                    return DtoUtils.returnSuccess();
                }else{
                    return DtoUtils.returnFail("修改验证状态失败",ErrorCode.AUTH_AUTHENTICATION_FAILED);
                }
            }else{
                return DtoUtils.returnFail("账号不存在",ErrorCode.AUTH_ILLEGAL_USERCODE);
            }
        }else{
            return DtoUtils.returnFail("验证码超时，不存在",ErrorCode.AUTH_AUTHENTICATION_FAILED);
        }
    }

    /**
     * 验证token是否有效
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/validateToken")
    public Dto validate(HttpServletRequest request){
            boolean bo = tokenService.validate(request.getHeader("user-agent"),request.getHeader("token"));
            if(bo){
                return DtoUtils.returnSuccess("token有效");
            }else {
                return DtoUtils.returnFail("token失效",ErrorCode.AUTH_TOKEN_INVALID);
            }
    }

    /**
     * 退出 并删除token
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/logout",produces = "application/json;charset=utf-8",headers = "token" ,method = RequestMethod.GET)
    public Dto logout(HttpServletRequest request){
        String token = request.getHeader("token");
        try {
            if(tokenService.validate(request.getHeader("user-agent"),token)){
                tokenService.deleteToken(token);
                return DtoUtils.returnSuccess();
            }else{
                return DtoUtils.returnFail("token无效", ErrorCode.AUTH_TOKEN_INVALID);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return DtoUtils.returnFail("退出失败", ErrorCode.AUTH_TOKEN_INVALID);
        }
    }

    /**
     * 由前端来置换token 给前端新的token 旧的token2分钟后失效
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/reloadToken",produces = "application/json;charset=utf-8",headers = "token" ,method = RequestMethod.GET)
    public Dto reloadToken(HttpServletRequest request){
        String token = null;
        try {
            token = tokenService.reloadToken(request.getHeader("user-agent"),request.getHeader("token"));   //置换新的token 如token还在设定的替换时间之前会抛出错
            itripTokenVo tokenvo = new itripTokenVo(token,
                    Calendar.getInstance().getTimeInMillis()+2*60*60*1000,
                    Calendar.getInstance().getTimeInMillis());   //把token 、token的创建时间
            return DtoUtils.returnDataSuccess(tokenvo);
        } catch (Exception e) {
            e.printStackTrace();
            return DtoUtils.returnFail(e.getLocalizedMessage(),ErrorCode.AUTH_UNKNOWN);
        }


    }

}
