package com.Dao;

import com.Pojo.ItripHotelOrder;
import org.apache.ibatis.annotations.Param;

public interface ItripHotelOrderMapper {
    /**
     * 添加订单
     * @param itripHotelOrder
     * @return
     */
    int addOrder(ItripHotelOrder itripHotelOrder);

    /**
     * 刷新未支付并超时的订单状态
     * @return
     */
    int updateFlushOrderStatus();

    /**
     * 刷新支付成功并且消到退房时间
     * @return
     */
    int updateSuccessOrderStatus();

    /**
     * 按订单号修改支付状态 订单号必须唯一
     * @return
     */
    int updateOrderStatus(@Param("orderNo")String orderNo,@Param("orderStatus")int orderStatus,@Param("tradeNo")String tradeNo);
}
