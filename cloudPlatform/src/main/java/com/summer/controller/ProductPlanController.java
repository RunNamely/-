package com.summer.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.summer.pojo.ProductPlan;
import com.summer.service.IProductPlanService;

@Controller
public class ProductPlanController<T> {

	@Autowired
	private IProductPlanService iProductPlanService;
		
	//启动计划
		@ResponseBody
		@RequestMapping(value = "/start",method = RequestMethod.GET)
		public boolean startHandler(@RequestParam(value = "id")Integer id) {
			return iProductPlanService.qidong(id);
		}
	
	//查看所有的计划
	@ResponseBody
	@RequestMapping(value = "/productPlan",method = RequestMethod.GET)
	public ModelAndView seleteAllProductPlan(ProductPlan productPlan,@RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum,Integer pageStatr){	
		//分页 
		   PageHelper.startPage(pageNum, 5); 
		   List<ProductPlan> plan = iProductPlanService.selectProductPlan(productPlan);

		 //把对象传进去
		 PageInfo<ProductPlan> info = new PageInfo<ProductPlan>(plan);
		 ModelAndView view = new ModelAndView();
		 int size = plan.size(); 
		 view.setViewName("startplan-list");
		 view.addObject("size", size);
		 view.addObject("info", info);
		 System.out.println(plan);
		return view;
	}
	
	//删除计划(启动的计划的不能删除)
	@ResponseBody
	@GetMapping(value = "/deleteaction")
	public 	boolean delete(@RequestParam(value = "id")Integer id) {
		boolean delete = iProductPlanService.deleteProductPlan(id);
		return delete;
	}
	
	//添加计划跳转界面
	@RequestMapping(value = "/addlist")
	public String gotoaddlist() {
		return "addplan";
		
	}
	//添加把数据填充到界面上
	@RequestMapping(value = "/adddata",method = RequestMethod.POST)
	public String  adddata(ProductPlan productPlan,Model model) {
	    boolean plan = iProductPlanService.insertProductPlan(productPlan);
		model.addAttribute("data", plan);
		return "startplan-list";
	} 
	
	
}
