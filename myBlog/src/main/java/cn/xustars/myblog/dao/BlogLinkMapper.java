package cn.xustars.myblog.dao;

import cn.xustars.myblog.entity.BlogLink;

import java.util.List;
import java.util.Map;

public interface BlogLinkMapper {

    void save(BlogLink blogLink);

    void update(BlogLink blogLink);

    Integer queryTotal();

    List<BlogLink> queryList(Map<String, Object> map);

    List<BlogLink> queryListByCondition(Map<String, Object> map);
}