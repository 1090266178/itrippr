package com.Dao;

import com.Pojo.ItripComment;
import org.apache.ibatis.annotations.Param;
import solr.ItripHotel;

public interface ItripCommentMapper {

    /**
     * 新增酒店评论
     * @param itripComment
     * @return
     */
    int addComment(ItripComment itripComment);

}
