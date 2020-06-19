package com.Service;

import com.Dao.ItripHotelOrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ItripHotelOrderImple implements ItripHotelOrderInter{

    @Resource(name="itripHotelOrderMapper")
    private ItripHotelOrderMapper itripHotelOrderMapper;

    @Override
    public int updateOrderStatus(String orderNo, int orderStatus, String tradeNo) {
        return itripHotelOrderMapper.updateOrderStatus(orderNo, orderStatus, tradeNo);
    }
}
