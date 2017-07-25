package cn.xustars.myblog.dao;

import cn.xustars.myblog.entity.BlogType;

import java.util.List;
import java.util.Map;

public interface BlogTypeMapper {

    void save(BlogType blogType);

    void update(BlogType blogType);

    void deleteBatch(List<Integer> typeIds);

    Integer queryTotal();

    List<BlogType> queryList(Map<String, Object> map);

    List<BlogType> queryListByCondition(Map<String, Object> map);
}