package com.Dao;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.stereotype.Repository;
import solr.ItripHotel;

import java.io.IOException;
import java.util.List;
@Repository
public class ItripHotelDao {
    private String url = "http://localhost:8080/solr/test/"; //访问solr中配置的core 每个core代表一个表的查询
    private BaseDaoSolr<ItripHotel> baseDao = new BaseDaoSolr<ItripHotel>(url);

    public List<ItripHotel> getHotelList(String keyword,Integer start,Integer rows) throws IOException, SolrServerException {
        SolrQuery solrQuery = new SolrQuery();     //新建查询 用于设置查询的对象 创建的同时可以通过构造方法给查询条件
        solrQuery.setQuery("keyword:"+keyword);         //查询条件
       /* solrQuery.setSort("id",SolrQuery.ORDER.desc);*/
        solrQuery.setStart(start);
        solrQuery.setRows(rows);
        List<ItripHotel> list = baseDao.getSolrResult(solrQuery,ItripHotel.class);
        return list;
    }
  /*  public static void main(String[] ags){   //测试
        ItripHotelDao dd = new ItripHotelDao();
        try {
            List<ItripHotel> d =  dd.getHotelList("北京");
            for(ItripHotel hotel:d){
                System.out.println(hotel.getId()+"   "+hotel.getHotelName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
    }*/

}
