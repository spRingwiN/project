package com.netease.course.service;

import java.util.List;

import com.netease.course.meta.Bought;
import com.netease.course.meta.User;

public interface BoughtDaoService {
	
	public List<Bought> getBuyList();
	public int addBought(int id,User user);

}
