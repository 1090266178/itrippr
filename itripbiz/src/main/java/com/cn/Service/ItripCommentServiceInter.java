package com.cn.Service;

import com.Pojo.ItripComment;

public interface ItripCommentServiceInter {
    /**
     * 新增酒店评论
     * @param itripComment
     * @return
     */
    int addComment(ItripComment itripComment);
}
