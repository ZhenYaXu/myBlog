package cn.xustars.myblog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xustars.myblog.dao.BloggerInfoMapper;
import cn.xustars.myblog.entity.BloggerInfo;
import cn.xustars.myblog.service.BloggerService;

@Service
public class BloggerServiceImpl implements BloggerService {

	@Autowired
	private BloggerInfoMapper bloggerInfoMapper;

	public BloggerInfo queryByUserName(String userName) {
		return bloggerInfoMapper.queryByUserName(userName);
	}

	public void updatePassWord(BloggerInfo blogger, String newPassWord) {
		bloggerInfoMapper.updatePassWord(blogger.getUsername(), blogger.getPassword(), newPassWord);
	}

}
