package com.my.weixin.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.weixin.entity.LoginUser;
import com.my.weixin.service.LoginUserService;

@Controller
public class LoginUserAction extends BaseAction {
	
	@Autowired
	private LoginUserService loginUserService;
	
	@RequestMapping("/queryLoginUserByMobile")
	public void  queryLoginUserByMobile(){
		
		LoginUser loginUser = loginUserService.queryLoignUserByMobile("15295059075");
		
		System.out.println(loginUser.getAddress()+loginUser.getUsername()+loginUser.getMobile());
	}
	
	@RequestMapping("/addLoginUser")
	public void addLoginUser(){
		LoginUser loginUser = new LoginUser();
		loginUser.setId(65);
		loginUser.setUsername("用户一");
		loginUser.setPassword("123456");
		loginUser.setMobile("15295059071");
		loginUser.setAddress("江苏宿迁");
		loginUserService.addLoginUser(loginUser);
	}
	
	
	

}
