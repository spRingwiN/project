package com.netease.course.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netease.course.dao.UserDao;
import com.netease.course.meta.User;
import com.netease.course.service.UserDaoService;

@Service
public class UserDaoServiceImpl implements UserDaoService {
	@Autowired
	private UserDao userDao;
	@Override
	public User hasUser(String userName, String password) {
		
		User user=null;
		User result=userDao.getUser(userName);
		if(result!=null){
			if(result.getPassword().equals(password)){
				
				user=result;
			}
		}
		
		return user;
	}

}
