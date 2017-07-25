package cn.xustars.myblog.dao;

import cn.xustars.myblog.entity.BloggerInfo;

public interface BloggerInfoMapper {

	BloggerInfo queryByUserName(String userName);

	void updatePassWord(String username,String password,String newPassWord);
}