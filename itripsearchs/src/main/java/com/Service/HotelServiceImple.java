package com.Service;

import com.Dao.ItripHotelDao;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.stereotype.Service;
import solr.ItripHotel;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
@Service
public class HotelServiceImple implements HotelServiceInter {

    @Resource(name="itripHotelDao")
    ItripHotelDao hoteDao;

    @Override
    public List<ItripHotel> getHotelList(String keyword,Integer start,Integer rows) throws IOException, SolrServerException {
        return hoteDao.getHotelList(keyword,start,rows);
    }
}
