package com.netease.course.service;

import java.util.List;


import com.netease.course.meta.Product;

public interface ProductDaoService {
	
	public List<Product> getProductList();
	public Product getOneProduct(int id);
	public Product addProduct(Product product);
	public int editProduct(Product product);
	public int delProduct(int id);

}
