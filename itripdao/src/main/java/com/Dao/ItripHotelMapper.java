package com.Dao;

import org.apache.ibatis.annotations.Param;
import solr.ItripHotel;

public interface ItripHotelMapper {

    /**
     * 根据酒店id获取酒店详情
     * @param id
     * @return
     */
    ItripHotel getHotelDetails(@Param("id") int id);
}
