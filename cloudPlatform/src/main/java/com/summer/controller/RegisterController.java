package com.summer.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.summer.pojo.User;
import com.summer.service.IUserService;
@Controller
public class RegisterController {
	
	@Autowired
	IUserService service;
	
	//表单提交跳转到登录界面
	@RequestMapping(value = "/registerUser",method = RequestMethod.POST)
	public String registerUser(User user)  {
		service.insertUser(user);
		return "login";
	}
	
	//校验用户名是否可用
	@ResponseBody
	@RequestMapping(value = "/checkUserName",method = RequestMethod.POST)
	public boolean CheckUserName(String userName) {
		User name = service.selectUserByUserName(userName);
		if(name!=null) {
			return false;
		}
		return true;
	}
	
}
