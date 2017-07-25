package cn.xustars.myblog.service;

import cn.xustars.myblog.entity.BlogLink;

import java.util.List;
import java.util.Map;

/**
 * Created by user on 2017/7/17.
 */
public interface BlogLinkService {

    void save(BlogLink blogLink);

    void update(BlogLink blogLink);

    Integer queryTotal();

    List<BlogLink> queryList(Map<String, Object> map);

    List<BlogLink> queryListByCondition(Map<String, Object> map);
}
