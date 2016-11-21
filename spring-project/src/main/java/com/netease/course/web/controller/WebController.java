package com.netease.course.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.netease.course.meta.Bought;
import com.netease.course.meta.Product;
import com.netease.course.meta.User;
import com.netease.course.service.impl.BoughtDaoServiceImpl;
import com.netease.course.service.impl.PDaoServiceImpl;

@Controller
public class WebController {
	@Autowired
	private PDaoServiceImpl pDaoServiceImpl;
	@Autowired
	private BoughtDaoServiceImpl boughtDaoServiceImpl;
	
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String login(){
		
		return "login";
	}
	@RequestMapping(path="/logout", method=RequestMethod.GET)
	public void logout(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		req.getSession().invalidate();
		resp.sendRedirect("/login");
		
	}
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String homepage(HttpServletRequest req,ModelMap map){
		
		User user=(User) req.getSession().getAttribute("user");
		List<Product> productList=pDaoServiceImpl.getProductList();
		map.addAttribute("user", user);
		map.addAttribute("productList", productList);
		return "index";
	}
	@RequestMapping(path="/show", method=RequestMethod.GET)
	public String show(HttpServletRequest req,@RequestParam("id")int id,ModelMap map){
		User user=(User)req.getSession().getAttribute("user");
		Product product=pDaoServiceImpl.getOneProduct(id);
		map.addAttribute("user", user);
		map.addAttribute("product", product);
		return "show";
		
	}
	@RequestMapping(path="/account", method=RequestMethod.GET)
	public String account(HttpServletRequest req,ModelMap map){
		User user=(User)req.getSession().getAttribute("user");
		List<Bought> buyList=boughtDaoServiceImpl.getBuyList();
		map.addAttribute("user", user);
		map.addAttribute("buyList", buyList);
		
		return "account";
		
	}
	@RequestMapping(path="/public", method=RequestMethod.GET)
	public String toPublic(HttpServletRequest res,ModelMap map){
		User user=(User) res.getSession().getAttribute("user");
		map.addAttribute("user", user);
		
		return "public";
		
	}
	@RequestMapping(path="/publicSubmit", method=RequestMethod.POST)
	public String submit(@RequestParam("title") String title,
			@RequestParam("detail") String detail,
			@RequestParam("price") double price,
			@RequestParam("summary") String summary,
			@RequestParam("image")String image,HttpServletRequest res,ModelMap map){
		User user=(User) res.getSession().getAttribute("user");
		Product product=new Product();
		product.setTitle(title);
		product.setDetail(detail);
		product.setPrice(price);
		product.setSummary(summary);
		product.setImage(image);
		product=pDaoServiceImpl.addProduct(product);
		map.addAttribute("user", user);
		if(product!=null){
			map.addAttribute("product", product);
		}
		
		return "publicSubmit";
	}
	@RequestMapping(path="/edit", method=RequestMethod.GET)
	public String edit(@RequestParam("id") int id,HttpServletRequest res,ModelMap map){
		User user=(User) res.getSession().getAttribute("user");
		Product product=pDaoServiceImpl.getOneProduct(id);
		map.addAttribute("user", user);
		map.addAttribute("product", product);
		return "edit";
	}
	@RequestMapping(path="/editSubmit", method=RequestMethod.POST)
	public String editSubmit(@RequestParam("title") String title,
			@RequestParam("detail") String detail,
			@RequestParam("price") double price,
			@RequestParam("summary") String summary,
			@RequestParam("image")String image,
			@RequestParam("id")int id,HttpServletRequest res,ModelMap map){
		User user=(User) res.getSession().getAttribute("user");
		Product product=new Product();
		product.setId(id);
		product.setTitle(title);
		product.setImage(image);
		product.setDetail(detail);
		product.setSummary(summary);
		product.setPrice(price);
		int k=pDaoServiceImpl.editProduct(product);
		map.addAttribute("user", user);
		if(k>0){
			map.addAttribute("product", product);
		}
		
		return "editSubmit";
	}
	
}
