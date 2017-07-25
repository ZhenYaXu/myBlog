package cn.xustars.myblog.service;

import cn.xustars.myblog.entity.BloggerInfo;

public interface BloggerService {

	BloggerInfo queryByUserName(String userName);

	void updatePassWord(BloggerInfo blogger,String newPassWord);
}
