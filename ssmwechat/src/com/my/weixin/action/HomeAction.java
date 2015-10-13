package com.my.weixin.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeAction {
	
	
	@RequestMapping("/home")
	public ModelAndView goHomePage(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	
	
	@RequestMapping("/personal")
	public ModelAndView goPersonal(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("personal");
		return mv;
	}
	
}
