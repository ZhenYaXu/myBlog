package cn.xustars.myblog.service.impl;

import cn.xustars.myblog.dao.BlogLinkMapper;
import cn.xustars.myblog.entity.BlogLink;
import cn.xustars.myblog.service.BlogLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by user on 2017/7/17.
 */
@Service
public class BlogLinkServiceImpl implements BlogLinkService {

    @Autowired
    private BlogLinkMapper blogLinkMapper;

    public void save(BlogLink blogLink) {
        blogLink.setState(1);
        blogLinkMapper.save(blogLink);
    }

    public void update(BlogLink blogLink) {
        blogLinkMapper.update(blogLink);
    }

    public Integer queryTotal() {
        return blogLinkMapper.queryTotal();
    }

    public List<BlogLink> queryList(Map<String, Object> map) {
        return blogLinkMapper.queryList(map);
    }

    public List<BlogLink> queryListByCondition(Map<String, Object> map) {
        return blogLinkMapper.queryListByCondition(map);
    }
}
