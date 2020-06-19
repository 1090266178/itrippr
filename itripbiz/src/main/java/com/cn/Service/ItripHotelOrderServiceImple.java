package com.cn.Service;

import com.Dao.ItripHotelOrderMapper;
import com.Pojo.ItripHotelOrder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class ItripHotelOrderServiceImple implements ItripHotelOrderServiceInter{

    @Resource(name="itripHotelOrderMapper")
    private ItripHotelOrderMapper itripHotelOrderMapper;
    @Override
    public int addOrder(ItripHotelOrder itripHotelOrder) {
        return itripHotelOrderMapper.addOrder(itripHotelOrder);
    }

    @Override
    public int updateFlushOrderStatus() {
        return itripHotelOrderMapper.updateFlushOrderStatus();
    }

    @Override
    public int updateSuccessOrderStatus() {
        return itripHotelOrderMapper.updateSuccessOrderStatus();
    }
}
