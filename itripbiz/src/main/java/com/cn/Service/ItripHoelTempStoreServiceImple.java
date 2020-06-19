package com.cn.Service;

import com.Dao.ItripHotelTempStoreMapper;
import com.Pojo.ItripHotelOrder;
import com.Pojo.ItripHotelTempStore;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItripHoelTempStoreServiceImple implements ItripHoelTempStoreServiceInter {
    @Resource(name="itripHotelTempStoreMapper")
    private ItripHotelTempStoreMapper itripHotelTempStoreMapper;

    @Override
    public List<ItripHotelTempStore> getItripHotelTempStores(ItripHotelOrder itripHotelOrder) {
         return itripHotelTempStoreMapper.getItripHotelTempStores(itripHotelOrder);
    }

    @Override
    public void flushStore(ItripHotelOrder itripHotelOrder) {
        itripHotelTempStoreMapper.flushStore(itripHotelOrder);
    }
}
