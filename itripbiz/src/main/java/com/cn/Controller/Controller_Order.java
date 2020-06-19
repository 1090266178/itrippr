package com.cn.Controller;

import com.Dto.Dto;
import com.Pojo.ItripHotelOrder;
import com.Pojo.ItripHotelTempStore;
import com.Pojo.ItripUserBean;
import com.Redis.RedisTool;
import com.Utils.DtoUtils;
import com.alibaba.fastjson.JSON;
import com.cn.Service.ItripHoelTempStoreServiceInter;
import com.cn.Service.ItripHotelOrderServiceInter;
import com.common.ErrorCode;
import io.swagger.annotations.ApiOperation;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/order")
public class Controller_Order {

    @Resource(name="redisTool")
    private RedisTool redisTool;
    @Resource(name="itripHoelTempStoreServiceImple")
    private ItripHoelTempStoreServiceInter ItripHoelTempStoreService;
    @Resource(name="itripHotelOrderServiceImple")
    private ItripHotelOrderServiceInter itripHotelOrderService;

    @ApiOperation(value="下单 并刷新插入实时表",notes = "下单添加用户表 必传房间id、酒店id、消耗数量即订购房间数量、入住时间、退房时间",protocols = "http",response = Dto.class,produces = "application/json;charset=utf-8")
    @ResponseBody
    @RequestMapping("/ord")
    public Dto order(ItripHotelOrder itripHotelOrder, HttpServletRequest request){
        String token = request.getHeader("token");
        String userstr = redisTool.get(token);
        if(userstr==null){
            return DtoUtils.returnFail("用户不存在,token失效", ErrorCode.AUTH_TOKEN_INVALID);
        }else{
            ItripUserBean user = JSON.parseObject(userstr, ItripUserBean.class);
            itripHotelOrder.setUserId(user.getId());
            itripHotelOrder.setOrderNo("001_"+System.currentTimeMillis());
            itripHotelOrder.setOrderStatus(0);
            itripHotelOrder.setCreationDate(new Date());
            itripHotelOrder.setCreatedBy(user.getId());
            ItripHoelTempStoreService.flushStore(itripHotelOrder);   //给实时表没有生成库存的当天添加实体
            List<ItripHotelTempStore> store = ItripHoelTempStoreService.getItripHotelTempStores(itripHotelOrder); //获取去除未支付订单数量的库存列表 按升序排列
            //store.get(0);   //取第一个最小库存比较下单数量是否符合
            if(store.get(0).getStore()>=itripHotelOrder.getCount()){  //大于下单数量就能正常下单支付
                if(itripHotelOrderService.addOrder(itripHotelOrder)>0){
                    return DtoUtils.returnSuccess();
                }else{
                    return DtoUtils.returnFail("添加失败","100580");
                }
            }else{
                return DtoUtils.returnFail("下单失败,当前下单房间数量超过最小库存数"+store.get(0).getStore(),"100580");
            }
        }
    }

    @Scheduled(cron = "* 0/15 * * * ?")
    public void updateFlushOrderStatus(){  //定时器修改订单状态 把未付款的订单改为已取消
        itripHotelOrderService.updateFlushOrderStatus();
    }

    @Scheduled(cron = "* 0/15 * * * ?")
    public void updateSuccessOrderStatus(){ //定时器 把已付款的用户 并且已经到了退房时间的订单 改为3已消费状态
        itripHotelOrderService.updateSuccessOrderStatus();
    }
}
