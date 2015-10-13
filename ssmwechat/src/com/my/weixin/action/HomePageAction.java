package com.my.weixin.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageAction {
	
	
	@RequestMapping("/goHomePage")
	public ModelAndView goHomePage(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
}
