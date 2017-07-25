package cn.xustars.myblog.service;

import cn.xustars.myblog.entity.BlogType;

import java.util.List;
import java.util.Map;

/**
 * Created by user on 2017/7/17.
 */
public interface BlogTypeService {

    void save(BlogType blogType);

    void update(BlogType blogType);

    void deleteBatch(List<Integer> typeIds);

    Integer queryTotal();

    List<BlogType> queryList(Map<String, Object> map);

    List<BlogType> queryListByCondition(Map<String, Object> map);
}
