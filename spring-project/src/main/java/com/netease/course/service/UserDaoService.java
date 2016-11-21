package com.netease.course.service;

import com.netease.course.meta.User;

public interface UserDaoService {
	public User hasUser(String userName,String password);
}
