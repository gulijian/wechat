package com.my.weixin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.weixin.dao.LoginUserDao;
import com.my.weixin.entity.LoginUser;

@Service
public class LoginUserService {
	
	@Autowired
	private LoginUserDao loginUserDao;
	
	/**
	 * 增加用户
	 * @param loginUser
	 */
	public void addLoginUser(LoginUser loginUser){
		
		loginUserDao.addLoginUser(loginUser);
	}
	
	/**
	 * 根据手机号码查询用户
	 * @param mobile 手机号码 
	 */
	public LoginUser queryLoignUserByMobile(String mobile){
		
		return loginUserDao.queryLoignUserByMobile(mobile);
		
	}
	

}
