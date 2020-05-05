package com.summer.controller;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.summer.pojo.User;
import com.summer.service.IFactoryService;
import com.summer.service.IUserService;

@Controller
public class LoginController {

	@Autowired
	IUserService userService;
	

	@Autowired
	private HttpSession session;
	
	@Autowired
	private IFactoryService factoryService;

	//跳转到登录界面
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String toLogin() {
		return "login";
	}

	//跳转到注册界面
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "register";
	}
	
	//拦截welcome页面
	@RequestMapping("/welcome")
	public String welcome(HttpServletRequest request) {
		if(request.getSession().getAttribute("uName")==null) {
			return "login";
		}
		return "welcome";
	}
	
	// 去主页
	@RequestMapping(value = "/toIndex")
	public ModelAndView toIndex() {
		
		User user = (User) session.getAttribute("user");
		ModelAndView mv =new ModelAndView();
		if(session.getAttribute("uName")==null) {
			mv.setViewName("login");
			return mv;
		}
		mv.addObject("user", user);
		mv.setViewName("index");
		return mv;
	}
	
	
	@RequestMapping("/factory")
	public ModelAndView factory(){
		ModelAndView mv = new ModelAndView();
		String userName = (String) session.getAttribute("uName");
		// 获取用户id
		int userId = factoryService.findIdByUserName(userName);
		// 通过判断在工厂表中是否存在该用户id 如果已存在 表示已经注册过 不存在就注册工厂
		int i = factoryService.findIsExcitFactoryByCreatId(userId);
		System.out.println(i);
		if(i==0) {
			mv.setViewName("factory");
			return mv;
		} else{
			mv.addObject("msg","您已创建了您的工厂");
			mv.setViewName("welcome");
			return mv;
		}
	}
	
	@RequestMapping("/forgotPwd")
	public String forgetPwd() {
		return "forgot-password";
	}
	
	//拦截index页面
	@RequestMapping("/")
	public String indexHandler() {
		return "login";
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginHandler(@RequestParam("userName") String username,
			@RequestParam("userPasswd") String userPasswd,HttpSession session) {
		session.setAttribute("uName",username);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		if(username!=null) {
			User user = userService.selectUserByUserName(username);
			session.setAttribute("userId",user.getId());
			mav.addObject("user",user);
			session.setAttribute("user", user);
			if (user == null) {
				mav.addObject("error","用户不存在,立即注册");
				return mav;
			} else{
				if (user.getUserPasswd().equals(userPasswd.trim())) {
					//判断用户是否创建工厂
					int i = userService.selectIsExistCreatFactory(username);
					mav.addObject("i",i);
					//如果已创建把
					if(i!=0) {
						String userName = (String) session.getAttribute("uName");
						User user2 = factoryService.findfactoryIdByUserId(userName);
						System.out.println(user2.getId());
						// 获取工厂id
						int factoryId = user2.getId();
						// 把工厂id插入user表中
						boolean b = factoryService.updateFactoryIdByUserName(userName, factoryId);
					}
					mav.setViewName("index");
					return mav;
				}else {
					mav.addObject("pwdError","密码输入有误");
					return mav; 	
				}
			}  
		}
		return mav;
	}
}
