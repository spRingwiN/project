package com.netease.course.dao;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.netease.course.meta.User;

public interface UserDao {
	
	@Results({
		@Result(property="id",column="id"),
		@Result(property="username",column="userName"),
		@Result(property="password",column="password"),
		@Result(property="nickName",column="nickName"),
		@Result(property="usertype",column="userType")
	})
	
	@Select("select * from person where userName=#{username}")	
	public User getUser(String username);

}
