package com.netease.course.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.netease.course.dao.ProductDao;
import com.netease.course.meta.Bought;
import com.netease.course.meta.Product;
import com.netease.course.service.ProductDaoService;
import com.netease.course.util.GeneralTool;
@Service
public class PDaoServiceImpl implements ProductDaoService {
	@Autowired
	private ProductDao productDao;
	@Autowired
	private BoughtDaoServiceImpl boughtDaoServiceImpl;

	//获取产品列表，并和交易记录表对比，将已售出的产品状态更改，并返回产品列表
	@Override
	public List<Product> getProductList() {
		List<Product> products=productDao.getAllProduct();
		List<Bought> boughts=boughtDaoServiceImpl.getBuyList();

			for(Product product:products){
					product.setImage(GeneralTool.byteToStr(product.getIcon()));
					product.setDetail(GeneralTool.byteToStr(product.getText()));
					product.setPrice(GeneralTool.lonToDou(product.getDbPrice()));
				for(Bought bought:boughts){
					if(product.getId()==bought.getId()){
						product.buy();
						product.setBuyPrice(bought.getBuyPrice());
					}
				}
			}			
		
		return products;
	}
	//根据Id获取单个产品信息
	@Override
	public Product getOneProduct(int id) {
		Product product=productDao.getProduct(id);
			product.setImage(GeneralTool.byteToStr(product.getIcon()));
			product.setDetail(GeneralTool.byteToStr(product.getText()));
			product.setPrice(GeneralTool.lonToDou(product.getDbPrice()));
		List<Bought> boughts=boughtDaoServiceImpl.getBuyList();
		for(Bought bought:boughts){
			if(bought.getId()==product.getId()){
				product.setBuyPrice(bought.getBuyPrice());
				product.buy();
			}
		}
		return product;
	}
	//插入产品，并获得自增主键
	@Transactional(propagation=Propagation.REQUIRED)
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		Product result=null;
		product.setDbPrice(GeneralTool.douToLon(product.getPrice()));
		product.setIcon(GeneralTool.strToByte(product.getImage()));
		product.setText(GeneralTool.strToByte(product.getDetail()));
		int k=productDao.addProduct(product);
		if(k>0){
			product.setId(product.getId());
			result=product;
		}
		return result;
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public int editProduct(Product product) {
		
		product.setDbPrice(GeneralTool.douToLon(product.getPrice()));
		product.setIcon(GeneralTool.strToByte(product.getImage()));
		product.setText(GeneralTool.strToByte(product.getDetail()));
		return productDao.updateProduct(product);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public int delProduct(int id) {
	
		return productDao.delProduct(id);
	}
	

}
