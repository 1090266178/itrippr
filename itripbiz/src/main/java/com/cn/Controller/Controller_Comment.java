package com.cn.Controller;

import com.Dto.Dto;
import com.Pojo.ItripComment;
import com.Pojo.ItripUserBean;
import com.Redis.RedisTool;
import com.Utils.DtoUtils;
import com.alibaba.fastjson.JSON;
import com.cn.Service.ItripCommentServiceInter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import solr.ItripHotel;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/comment")
@Api(value = "Controller_Comment",description = "添加评论")
public class Controller_Comment {
    @Resource(name="itripCommentServiceImple")
    private ItripCommentServiceInter itripCommentServiceInter;
    @Resource(name="redisTool")
    private RedisTool redisTool;


    @ApiOperation(value = "订单待评价状态可以添加评价",notes = "生成评价\" +\n" +
            "            \"<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>\" +\n" +
            "            \"<p>错误码：</p>\" +\n" +
            "            \"<p>100505 : 添加评价失败 </p>\" +\n" +
            "            \"<p>100506 : 不能提交空，请填写评价信息 </p>\" +\n" +
            "            \"<p>100000 : token失效，请重登录</p>")
    @ResponseBody
    @RequestMapping("/addComment")
    public Dto addComment(@ApiParam(value = "itripComment",name = "必须由前端传入酒店id，房型id，订单id，卫生评论也是必填")
                                      ItripComment itripComment, HttpServletRequest request){
        String token = request.getHeader("token");
        String value = redisTool.get(token);
        if(value==null){
            return DtoUtils.returnFail("token失效，请重登录","100000");
        }
        ItripUserBean user = JSON.parseObject(value, ItripUserBean.class);
        itripComment.setProductType(1);
        itripComment.setIsHavingImg(0);
        itripComment.setUserId(user.getId());
        itripComment.setCreationDate(new Date());
        return itripCommentServiceInter.addComment(itripComment)>0?DtoUtils.returnSuccess("添加评论成功"):DtoUtils.returnFail("添加评论失败","100505");
    }
}
