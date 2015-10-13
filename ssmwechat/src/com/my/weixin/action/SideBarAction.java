package com.my.weixin.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.weixin.entity.SideBar;
import com.my.weixin.service.SideBarService;

@Controller
public class SideBarAction extends BaseAction {

	@Autowired
	private SideBarService sideBarService;
	
	/**
	 * 查询左侧所有的菜单
	 */
	@RequestMapping("loadsidebar")
	@ResponseBody
	public List<SideBar> loadsidebar(){
		List<SideBar> lstSideBar  = sideBarService.loadsidebar();
		if(lstSideBar!=null){
			return lstSideBar;
		}else{
			return null;
		}
		
	}
	
	
}
