package com.summer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.summer.pojo.ProductSchedule;
import com.summer.service.IProductScheduleService;

@Controller
public class productScheduleController {

	@Autowired
	private IProductScheduleService iproductScheduleService;
	 
	@RequestMapping(value = "/productSchedule",method = RequestMethod.GET)
	public ModelAndView  index(Integer id) {
		List<ProductSchedule> productSchedule = iproductScheduleService.AllProductSchedule(id);
		ModelAndView view = new ModelAndView();
		//view.setViewName("ProductSchedule");
		view.addObject("select", productSchedule);
		return view;
	}
}
