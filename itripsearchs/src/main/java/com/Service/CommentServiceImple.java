package com.Service;

import com.Dao.CommentDao;
import com.Pojo.ItripComment;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
@Service
public class CommentServiceImple implements CommentServiceInter {
    @Resource(name="commentDao")
    private CommentDao commentDao;
    @Override
    public List<ItripComment> getCommentPage(Integer hotelId, Integer productId, Integer start, Integer rows) throws IOException, SolrServerException {
        return commentDao.getCommentPage(hotelId, productId, start, rows);
    }
}
