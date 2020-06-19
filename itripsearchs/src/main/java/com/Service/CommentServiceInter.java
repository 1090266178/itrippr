package com.Service;

import com.Pojo.ItripComment;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;
import java.util.List;

public interface CommentServiceInter {

    List<ItripComment> getCommentPage(Integer hotelId, Integer productId, Integer start, Integer rows) throws IOException, SolrServerException;
}
