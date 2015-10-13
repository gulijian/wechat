package com.my.weixin.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.weixin.entity.LoginUser;

@Repository
public class LoginUserDao {
	
	@Autowired
	public SqlSessionTemplate sqlSessionTemplate;
	
//	String statementname;
//	public LoginUserDao(){
//		statementname = "com.my.home.entity.LoginUser.";
//	}
	
	/**
	 * 增加用户
	 * @param loginUser
	 */
	public void addLoginUser(LoginUser loginUser){
		
		sqlSessionTemplate.insert("com.my.home.entity.LoginUser.addLoginUser", loginUser);
	}
	
	/**
	 * 根据手机号码查询用户
	 * @param mobile 手机号码 
	 */
	public LoginUser queryLoignUserByMobile(String mobile){
		
		return sqlSessionTemplate.selectOne("com.my.home.entity.LoginUser.queryLoginUserByMobile", mobile);
		
	}
	

}
