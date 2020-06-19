package com.Service;

import com.Pojo.ItripHotelRoom;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;
import java.util.List;

public interface RoomServiceInter {
    List<ItripHotelRoom> getRoomPage(Integer id,Integer start,Integer rows) throws IOException, SolrServerException;
}
