package cn.xustars.myblog.service.impl;

import cn.xustars.myblog.dao.BlogArticleMapper;
import cn.xustars.myblog.entity.BlogArticle;
import cn.xustars.myblog.service.BlogArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class BlogArticleServiceImpl implements BlogArticleService {

	@Autowired
	private BlogArticleMapper blogArticleMapper;

	public BlogArticle queryById(Integer blogId) {
		return blogArticleMapper.queryById(blogId);
	}

	public Integer queryTotal() {
		return blogArticleMapper.queryTotal();
	}

	public void add(BlogArticle blogArticle) {
		// 转化时间格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = dateFormat.format(new Date());
		ParsePosition pos = new ParsePosition(8);
		Date currentTime = dateFormat.parse(dateString, pos);

		blogArticle.setCreateDate(currentTime);
		blogArticle.setState(1);
		
		blogArticleMapper.insert(blogArticle);
	}

	public void updateById(Integer blogId) {
		blogArticleMapper.updateById(blogId);
	}

	public void deleteBatch(List<Integer> blogIds) {
		
	}

	public List<BlogArticle> queryList(Map<String, Object> map) {
		
		return blogArticleMapper.queryList(map);
	}

	public List<BlogArticle> queryListByCondition(Map<String, Object> map) {
		
		return blogArticleMapper.queryListByCondition(map);
	}


	
}
