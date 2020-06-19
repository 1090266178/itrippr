package com.Service;

import com.Dao.RoomDao;
import com.Pojo.ItripHotelRoom;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Service
public class RoomServiceImple implements RoomServiceInter {

    @Resource(name="roomDao")
    private RoomDao roomDao;
    @Override
    public List<ItripHotelRoom> getRoomPage(Integer id, Integer start, Integer rows) throws IOException, SolrServerException {
        return roomDao.getRoomPage(id,start,rows);
    }
}
