package cn.xustars.myblog.service.impl;

import cn.xustars.myblog.dao.BlogCommentMapper;
import cn.xustars.myblog.entity.BlogComment;
import cn.xustars.myblog.service.BlogCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by user on 2017/7/17.
 */
@Service
public class BlogCommentServiceImpl implements BlogCommentService {

    @Autowired
    private BlogCommentMapper blogCommentMapper;

    public List<BlogComment> queryList(Map<String, Object> map) {
        return blogCommentMapper.queryList(map);
    }

    public List<BlogComment> queryListByCondition(Map<String, Object> map) {
        return blogCommentMapper.queryListByCondition(map);
    }

    public void reviewComment(int comId) {
        BlogComment blogComment = blogCommentMapper.queryById(comId);
        // state 0: 审核中 1 已通过 2 审核失败(不展示)
        blogComment.setState(1);
        blogCommentMapper.update(blogComment);
    }

    public Integer queryTotal() {
        return blogCommentMapper.queryTotal();
    }

}
