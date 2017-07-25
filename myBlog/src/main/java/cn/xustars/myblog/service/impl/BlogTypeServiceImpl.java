package cn.xustars.myblog.service.impl;

import cn.xustars.myblog.dao.BlogTypeMapper;
import cn.xustars.myblog.entity.BlogType;
import cn.xustars.myblog.service.BlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by user on 2017/7/17.
 */
@Service
public class BlogTypeServiceImpl implements BlogTypeService {

    @Autowired
    private BlogTypeMapper blogTypeMapper;

    public void save(BlogType blogType) {
        blogType.setState(1);
        blogTypeMapper.save(blogType);
    }

    public void update(BlogType blogType) {
        blogTypeMapper.update(blogType);
    }

    public void deleteBatch(List<Integer> typeIds) {
        blogTypeMapper.deleteBatch(typeIds);
    }

    public Integer queryTotal() {
        return blogTypeMapper.queryTotal();
    }

    public List<BlogType> queryList(Map<String, Object> map) {
        return blogTypeMapper.queryList(map);
    }

    public List<BlogType> queryListByCondition(Map<String, Object> map) {
        return blogTypeMapper.queryListByCondition(map);
    }
}
