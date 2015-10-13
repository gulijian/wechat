package com.my.weixin.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.weixin.entity.SideBar;

@Repository
public class SideBarDao {
	
	@Autowired
	public SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询左侧的菜单
	 * @return
	 */
	public List<SideBar> querySideBarAll(){
		List<SideBar>  lstBar =sqlSessionTemplate.selectList("com.my.home.entity.SideBar.querySidebar");
		return lstBar;
	}
	
	
}
