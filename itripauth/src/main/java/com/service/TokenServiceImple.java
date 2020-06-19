package com.service;

import com.MD5.MD5;
import com.Pojo.ItripUserBean;
import com.Redis.RedisTool;
import com.alibaba.fastjson.JSON;
import nl.bitwalker.useragentutils.UserAgent;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
@Service
public class TokenServiceImple implements TokenServiceInter{


    @Resource(name="redisTool")
    RedisTool redisTool;    //操作redis缓存数据库的工具类

    /**
     * 生成Token键
     * 前缀:PC-用户账号-用户id-创建时间-heraders头信息加密后取6位
     * @param userAgent
     * @param userBean
     * @return
     */
    @Override
    public String getGenerateToken(String userAgent, ItripUserBean userBean) {
        StringBuilder str = new StringBuilder();
        str.append("token:");
        UserAgent agent = UserAgent.parseUserAgentString(userAgent);   //将headers头信息中的userAgent转换为UserAgent类型 里面的方法可以判断登录的终端 如pc终端或手机终端
        if(agent.getOperatingSystem().isMobileDevice()){  //getOperatingSystem表示操作的终端，isMobileDevice表示手机终端
            str.append("MOBILE-");
        }else{
            str.append("PC-");
        }
        str.append(MD5.getMd5(userBean.getUserCode(),32)+"-");   //这里是用户账号使用MD5加密
        str.append(userBean.getId()+"-");                         //这里是用户的id
        str.append(new SimpleDateFormat("yyyyMMddHHmmsss").format(new Date())+"-");    //这里是Token创建的时间
        str.append(MD5.getMd5(userAgent,6));      //这里是使用header头信息中的userAgent的信息字符串使用md5加密成6位的字符
        return str.toString();
    }

    /**
     * 保存Token进入Redis
     * @param token 键
     * @param userBean 值 把用户类转成json字符串
     */
    @Override
    public void saveToken(String token, ItripUserBean userBean) {
        if(token.startsWith("token:PC-")){   //判断token的前缀为token:PC-的为网页pc端登录
            redisTool.set(token, JSON.toJSONString(userBean),60*60*2);    //网页版的token设置2小时后失效
        }else{
            redisTool.set(token,JSON.toJSONString(userBean));    //手机版的token永久保存方便下次访问
        }
    }

    /**
     * 删除redis中的token信息
     * @param token
     */
    @Override
    public void deleteToken(String token){
        redisTool.del(token);
    }

    /**
     * 验证token是否存在
     * @param userAgent
     * @param token
     * @return
     * @throws Exception
     */
    @Override
    public boolean validate(String userAgent, String token) {
        if(!redisTool.exists(token)){
            return false;
        }

        String userAgentMD5=token.split("-")[4];
        if(!MD5.getMd5(userAgent,6).equals(userAgentMD5)){
            return false;
        }
        return true;
    }

    private long protectedTime=30*60*1000;
    private int delay=2*60;
    @Override
    public String reloadToken(String userAgent, String token) throws Exception {
        //验证token是否有效
        if(!redisTool.exists(token)){
            throw new Exception("token无效");
        }
        //能不能置换
        Date genTime=new SimpleDateFormat("yyyyMMddHHmmsss").parse(token.split("-")[3]);
        long getTime2 = genTime.getTime();
        long caTime=Calendar.getInstance().getTimeInMillis();
        long passed= caTime-getTime2;    //这里的时间是当前系统时间和创建token的时间相减得出的过去了几分钟的时间
        if(passed<protectedTime){    //这里是离创建token过去了几分钟的时间是否大于半小时
            throw new Exception("token置换保护期，不能置换，剩余"+(protectedTime-passed)/1000);
        }
        //进行置换
        String user = redisTool.get(token);  //获取到用户对象的json字符串
        ItripUserBean userBean = JSON.parseObject(user,ItripUserBean.class);
        String newToken = getGenerateToken(userAgent,userBean);  //生成新的token
        //老的token延时过期
        redisTool.set(token,user,delay);
        //新的token保存至Redis
        saveToken(newToken,userBean);
        return newToken;
    }


}
