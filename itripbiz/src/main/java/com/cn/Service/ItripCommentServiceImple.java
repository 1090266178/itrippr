package com.cn.Service;

import com.Dao.ItripCommentMapper;
import com.Pojo.ItripComment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class ItripCommentServiceImple implements  ItripCommentServiceInter{
    @Resource(name="itripCommentMapper")
    private ItripCommentMapper itripCommentMapper;

    @Override
    public int addComment(ItripComment itripComment) {
        return itripCommentMapper.addComment(itripComment);
    }
}
