package com.summer.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.summer.pojo.Equipment;
import com.summer.pojo.User;
import com.summer.service.IEquipmentService;
import com.summer.utils.Fileutils;

@Controller
public class EquipmentAddController {

	@Autowired
	private IEquipmentService equipmentService;
	
	@Value("${web.upload-path}")
	private String path;
	
	@Autowired
	private HttpSession session;

	// 添加设备
	@RequestMapping(value = "/addEquipment", method = RequestMethod.POST)
	public ModelAndView addEquipment(Equipment equipment,@RequestParam("picture") MultipartFile file) {
		ModelAndView mv = new ModelAndView();
		// 获取当前用户名
		String userName = (String) session.getAttribute("uName");
		int userid = equipmentService.findIdByUserName(userName);
		equipment.setCreateUserId(userid);
		equipment.setUpdateUserId(userid);
		User user = equipmentService.findfactoryIdByUserId(userName);
		equipment.setFactoryId(user.getId());
		
		// 获取文件名字
		String fileName = file.getOriginalFilename();
		// 获取改文件的上传路径
		String realPath = path + fileName;
		equipment.setEquipmentImgUrl(realPath);
		// 文件上传
		boolean upload = Fileutils.upload(file, fileName);
		
		
		if(equipmentService.addEquipment(equipment)) {
			if(upload) {
				mv.addObject("msg","文件上传成功");
			} else {
				mv.addObject("msg","文件上传失败");
			}
			mv.addObject("factoryId",equipment.getFactoryId());
			mv.addObject("msg","添加成功");
			mv.setViewName("equipment-add");
		} else {
			mv.addObject("msg","添加出现问题");
			mv.setViewName("equipment-add");
		}
		return mv;
	}
	
}
