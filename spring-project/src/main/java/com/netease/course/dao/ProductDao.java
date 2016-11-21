package com.netease.course.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.netease.course.meta.Product;

public interface ProductDao {
	
	@Results({
		@Result(property="id",column="id"),
		@Result(property="title",column="title"),
		@Result(property="summary",column="abstract"),
		@Result(property="text",column="text"),
		@Result(property="icon",column="icon"),
		@Result(property="dbPrice",column="price"),
	})
	
	@Select("select * from content")
	public List<Product> getAllProduct();
	
	@Results({
		@Result(property="id",column="id"),
		@Result(property="title",column="title"),
		@Result(property="summary",column="abstract"),
		@Result(property="text",column="text"),
		@Result(property="icon",column="icon"),
		@Result(property="dbPrice",column="price"),
	})
	@Select("select * from content where id=#{id}")
	public Product getProduct(int id);
	
	@Options(useGeneratedKeys=true,keyProperty="id")
	@Insert("insert into content (price,title,icon,abstract,text) values (#{dbPrice},#{title},#{icon},#{summary},#{text})")
	public int addProduct(Product product);
	@Delete("delete from content where id=#{id}")
	public int delProduct(int id);
	@Update("update content set price=#{dbPrice},title=#{title},icon=#{icon},abstract=#{summary},text=#{text} where id=#{id}")
//	public int updateProduct(@Param("id")int productId,@Param("price") int price,@Param("title")String title,@Param("image")String image,@Param("summary")String summary,@Param("detail")String detail);
	public int updateProduct(Product product);
}
