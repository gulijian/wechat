package com.my.weixin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.weixin.dao.SideBarDao;
import com.my.weixin.entity.SideBar;

@Service
public class SideBarService {

	@Autowired
	private SideBarDao sidebardao;
	
	
	/**
	 *  查询左侧菜单
	 * @return
	 */
	public List<SideBar> loadsidebar(){
		return sidebardao.querySideBarAll();
	}
	
	
	
}
