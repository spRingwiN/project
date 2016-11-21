package com.netease.course.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.netease.course.dao.BoughtDao;
import com.netease.course.dao.ProductDao;
import com.netease.course.meta.Bought;
import com.netease.course.meta.Product;
import com.netease.course.meta.User;
import com.netease.course.service.BoughtDaoService;
import com.netease.course.util.GeneralTool;

@Service
public class BoughtDaoServiceImpl implements BoughtDaoService {
	@Autowired
	private BoughtDao boughtDao;
	@Autowired
	private ProductDao productDao;
	//获取buyList，交易记录表和产品表结合
	@Override
	public List<Bought> getBuyList() {
		
		List<Bought> boughts= boughtDao.getBuyList();
		if(boughts!=null)
		{
			for(Bought bought:boughts){
				bought.setImage(GeneralTool.byteToStr(bought.getIcon()));
				bought.setBuyPrice(GeneralTool.lonToDou(bought.getDbPrice()));
			}
		}
		return boughts;
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public int addBought(int id,User user) {
		// TODO Auto-generated method stub
		long time=System.currentTimeMillis();
		Product product=productDao.getProduct(id);
		int k=boughtDao.addBoughtProduct(product.getId(), user.getId(), product.getDbPrice(), time);
		return k;
	}
}
