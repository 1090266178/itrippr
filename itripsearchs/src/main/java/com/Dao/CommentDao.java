package com.Dao;

import com.Pojo.ItripComment;
import com.Pojo.ItripHotelRoom;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
@Repository
public class CommentDao {
    private String url="http://localhost:8080/solr/comment";
    private BaseDaoSolr<ItripComment> baseDaoSolr = new BaseDaoSolr<ItripComment>(url);

    public List<ItripComment> getCommentPage(Integer hotelId,Integer productId, Integer start, Integer rows) throws IOException, SolrServerException {
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery("hotelId:"+hotelId);
        solrQuery.setFilterQueries("productId:"+productId);
        solrQuery.setStart(start);
        solrQuery.setRows(rows);
        List<ItripComment> list = baseDaoSolr.getSolrResult(solrQuery,ItripComment.class);
        return list;
    }

     public static void main(String[] ags){   //测试
         CommentDao dd = new CommentDao();
        try {
            List<ItripComment> d =  dd.getCommentPage(1,1,0,5);
            for(ItripComment hotel:d){
                System.out.println(hotel.getId()+"   "+hotel.getUserId());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
    }
}
