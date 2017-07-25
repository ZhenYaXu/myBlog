package cn.xustars.myblog.dao;


import cn.xustars.myblog.entity.BlogComment;

import java.util.List;
import java.util.Map;

public interface BlogCommentMapper {

    // 查询全部评论
    List<BlogComment> queryList(Map<String, Object> map);

    //根据条件查询评论
    List<BlogComment> queryListByCondition(Map<String, Object> map);

    //根据评论编号查询评论
    BlogComment queryById(int comId);

    void update(BlogComment blogComment);

    Integer queryTotal();
}