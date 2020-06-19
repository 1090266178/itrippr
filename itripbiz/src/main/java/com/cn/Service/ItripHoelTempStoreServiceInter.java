package com.cn.Service;

import com.Pojo.ItripHotelOrder;
import com.Pojo.ItripHotelTempStore;

import java.util.List;

public interface ItripHoelTempStoreServiceInter {
    /**
     * 根据房型id 入住时间 退房时间 获取库存列表 取最小库存可比较库存是否满足当前订单数量
     * @param itripHotelOrder
     * @return
     */
    List<ItripHotelTempStore> getItripHotelTempStores(ItripHotelOrder itripHotelOrder);
    /**
     * 通过存储过程 实现每天还没来得及生成的实时库存表的实体的插入 插入的库存是按原始表的库存来的 原始表的库存代表酒店实际存在的房间数
     * @return
     */
    void flushStore(ItripHotelOrder itripHotelOrder);
}
