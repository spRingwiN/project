package com.netease.course.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.netease.course.meta.Bought;

public interface BoughtDao {
	
	@Results({
		@Result(property="id", column="contentId"),
		@Result(property="dbPrice", column="price"),
		@Result(property="buyTime", column="time"),
		@Result(property="title", column="title"),
		@Result(property="icon", column="icon")
	})
	@Select("select contentId,trx.price as price,time,title,icon from trx left join content on content.id=trx.contentId")
	public List<Bought> getBuyList();
	
	@Insert("insert into trx (contentId,personId,price,time) values (#{contentId},#{personId},#{dbPrice},#{time})")
	public int addBoughtProduct(@Param("contentId")int contentId,@Param("personId")int personId,@Param("dbPrice")long dbPrice,@Param("time")long time);

}
