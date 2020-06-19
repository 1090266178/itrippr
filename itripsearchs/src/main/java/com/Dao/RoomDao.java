package com.Dao;

import com.Pojo.ItripComment;
import com.Pojo.ItripHotelRoom;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.stereotype.Repository;
import solr.ItripHotel;

import java.io.IOException;
import java.util.List;
@Repository
public class RoomDao {

    private String url="http://localhost:8080/solr/room";
    private BaseDaoSolr<ItripHotelRoom> baseDaoSolr = new BaseDaoSolr<ItripHotelRoom>(url);

    public List<ItripHotelRoom> getRoomPage(Integer id,Integer start,Integer rows) throws IOException, SolrServerException {
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery("hotelId:"+id);
        solrQuery.setStart(start);
        solrQuery.setRows(rows);
        List<ItripHotelRoom> list = baseDaoSolr.getSolrResult(solrQuery,ItripHotelRoom.class);
        return list;
    }

    public static void main(String[] ags){   //测试
        RoomDao dd = new RoomDao();
        try {
            List<ItripHotelRoom> d =  dd.getRoomPage(1,0,5);
            for(ItripHotelRoom hotel:d){
                System.out.println(hotel.getId()+"   "+hotel.getRoomPrice());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
    }
}
