package com.netease.course.web.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.netease.course.meta.User;
import com.netease.course.service.impl.BoughtDaoServiceImpl;
import com.netease.course.service.impl.PDaoServiceImpl;
import com.netease.course.service.impl.UserDaoServiceImpl;

@Controller
@RequestMapping("/api")
public class ApiController {
	@Autowired
	private UserDaoServiceImpl userDaoServiceImpl;
	@Autowired
	private PDaoServiceImpl pDaoServiceImpl;
	@Autowired
	private BoughtDaoServiceImpl boughtDaoServiceImpl;
	@RequestMapping(path="/login",method=RequestMethod.POST)
	public String login(@RequestParam("userName")String userName,
									 @RequestParam("password")String password,
									 HttpServletRequest req,ModelMap map){
		User user=null;
		if(userName.equals("")){
			 
			user=(User) req.getSession().getAttribute("user");
		}
		if(user==null){
			user=userDaoServiceImpl.hasUser(userName, password);
			req.getSession().setAttribute("user", user);
		}
		if(user==null){
			map.addAttribute("code", 401);
			map.addAttribute("message","用户名或密码错误");
			map.addAttribute("result", false);
			
		}else{
			map.addAttribute("code", 200);
			map.addAttribute("message","成功");
			map.addAttribute("result", true);
		}
		return "json";
	}
	
	@RequestMapping(path="/delete",method=RequestMethod.POST)
	public String delete(@RequestParam("id") int id,ModelMap map){
		int i=pDaoServiceImpl.delProduct(id);
		if(i>0){
			map.addAttribute("code", 200);
			map.addAttribute("message","成功");
			map.addAttribute("result", true);
		}else{
			map.addAttribute("code", 503);
			map.addAttribute("message","失败");
			map.addAttribute("result", false);	
		}
		return "json";
	}
	@RequestMapping(path="/buy",method=RequestMethod.POST)
	public String buy(@RequestParam("id")int id,ModelMap map,HttpServletRequest req){
		User user= (User) req.getSession().getAttribute("user");
		int j=boughtDaoServiceImpl.addBought(id, user);
		if(j>0){
			map.addAttribute("code", 200);
			map.addAttribute("message","成功");
			map.addAttribute("result", true);
		}else{
			map.addAttribute("code", 503);
			map.addAttribute("message","失败");
			map.addAttribute("result", false);	
		}
		
		return "json";
	}

}
