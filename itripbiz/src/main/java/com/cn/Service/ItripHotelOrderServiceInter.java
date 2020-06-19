package com.cn.Service;

import com.Pojo.ItripHotelOrder;

public interface ItripHotelOrderServiceInter {
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
}
