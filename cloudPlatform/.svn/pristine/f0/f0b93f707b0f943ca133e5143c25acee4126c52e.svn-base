package com.summer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AdminController {
	
	@RequestMapping(value = "/adminList", method = RequestMethod.GET)
	public ModelAndView adminList() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin-list");
		return mv;
	}
	
	@RequestMapping(value = "/adminPermission", method = RequestMethod.GET)
	public ModelAndView adminPermission() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin-permission");
		return mv;
	}
	
	@RequestMapping(value = "/adminRole", method = RequestMethod.GET)
	public ModelAndView adminRole() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin-role");
		return mv;
	}
	
}
