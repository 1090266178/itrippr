package com.Service;

import org.apache.ibatis.annotations.Param;

public interface ItripHotelOrderInter {
    /**
     * 按订单号修改支付状态 订单号必须唯一
     * @return
     */
    int updateOrderStatus(@Param("orderNo")String orderNo, @Param("orderStatus")int orderStatus, @Param("tradeNo")String tradeNo);
}
