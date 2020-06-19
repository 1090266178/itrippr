package com.Controller;

import com.Dto.Dto;
import com.Service.CommentServiceInter;
import com.Service.HotelServiceInter;
import com.Service.RoomServiceInter;
import com.Utils.DtoUtils;
import com.common.ErrorCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
@Api(value="HotelSearch",description = "搜索层",basePath = "www.baidu.com")
@Controller
@RequestMapping("/hotel")
public class HotelSearch {

    @Resource
    private HotelServiceInter hotelService;


    @ApiOperation(value="按条件查询酒店列表 分页",notes = "根据查询的值 搜索酒店 根据传入的页码实现分页")
    @RequestMapping("/getHotelList")
    @ResponseBody
    public Dto getHotelListLike(
            @ApiParam(value = "必填的查询条件,根据条件实现查询酒店列表",required = true,name="keyword")
            @RequestParam(value="keyword",required = true) String keyword,
            @ApiParam(value="查询出来的表的当前页码 不是必填但是不填无法跳转列表",name="start")
            @RequestParam(value="start",defaultValue = "1") Integer start,
            @ApiParam(value="给前端填的每页页数 不是必填",name="rows")
            @RequestParam(value = "rows",defaultValue = "10")Integer rows){  //查询酒店列表
        try {
           return DtoUtils.returnDataSuccess(hotelService.getHotelList(keyword,start-1,rows));
        } catch (IOException e) {
            e.printStackTrace();
            return  DtoUtils.returnFail(e.getMessage(), ErrorCode.AUTH_UNKNOWN);
        } catch (SolrServerException e) {
            e.printStackTrace();
            return  DtoUtils.returnFail(e.getMessage(), ErrorCode.AUTH_UNKNOWN);
        }
    }

    @Resource(name="commentServiceImple")
    private CommentServiceInter commentService;
    @Resource(name="roomServiceImple")
    private RoomServiceInter roomService;

    @ApiOperation(value="酒店房间列表",notes="根据酒店id获取酒店房间列表\\\" +\\n\" +\n" +
            "            \"            \\\"<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>\\\" +\\n\" +\n" +
            "            \"            \\\"<p>错误码：</p>\\\" +\\n\" +\n" +
            "            \"            \\\"<p>100509 : 程序错误 </p>\\\" +\\n\" +\n")
    @ResponseBody
    @RequestMapping("/getRoomPage")
    public Dto getRoomPage(@RequestParam("hotelId")Integer hotelId,@RequestParam(value = "start",defaultValue = "1")Integer start,
                           @RequestParam(value = "rows",defaultValue = "10")Integer rows){
        try {
           return DtoUtils.returnDataSuccess( roomService.getRoomPage(hotelId,start,rows));
        } catch (IOException e) {
            e.printStackTrace();
            return  DtoUtils.returnFail(e.getMessage(),"100509");
        } catch (SolrServerException e) {
            e.printStackTrace();
            return DtoUtils.returnFail(e.getMessage(),"100509");
        }
    }

    @ApiOperation(value="酒店房间评价",notes="根据酒店id房间id获取房间详情评价\\\" +\\n\" +\n" +
            "            \"            \\\"<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>\\\" +\\n\" +\n" +
            "            \"            \\\"<p>错误码：</p>\\\" +\\n\" +\n" +
            "            \"            \\\"<p>100509 : 程序错误 </p>\\\" +\\n\" +\n")
    @ResponseBody
    @RequestMapping("/getCommentPage")
    public Dto getCommentPage(@RequestParam(value="hotelId",required = true) Integer hotelId,
                              @RequestParam(value="productId",required = true) Integer productId,@RequestParam(value = "start",defaultValue = "1")Integer start,
                              @RequestParam(value = "rows",defaultValue = "10")Integer rows){
        try {
            return DtoUtils.returnDataSuccess(commentService.getCommentPage(hotelId,productId,start ,rows));
        } catch (IOException e) {
            e.printStackTrace();
            return DtoUtils.returnFail(e.getMessage(),"100509");
        } catch (SolrServerException e) {
            e.printStackTrace();
            return DtoUtils.returnFail(e.getMessage(),"100509");
        }

    }

}
