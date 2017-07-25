package cn.xustars.myblog.service;

import cn.xustars.myblog.entity.BlogComment;

import java.util.List;
import java.util.Map;

/**
 * Created by user on 2017/7/17.
 */
public interface BlogCommentService {

    // 查询全部评论
    List<BlogComment> queryList(Map<String, Object> map);

    //根据条件查询评论
    List<BlogComment> queryListByCondition(Map<String, Object> map);

    //审核评论
    void reviewComment(int comId);

    Integer queryTotal();
}
