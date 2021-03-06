package com.summer.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.summer.pojo.Equipment;
import com.summer.pojo.User;
import com.summer.service.IEquipmentService;

@RestController
public class EquipmentListController {

	@Autowired
	private IEquipmentService equipmentService;
	
	@Autowired
	private HttpSession session;
	
	// 设备列表
	@RequestMapping(value = "/equipmentList")
	public ModelAndView EquipmentList() {
		ModelAndView mv = new ModelAndView();
		String userName = (String) session.getAttribute("uName");
		int creatUserId = equipmentService.findIdByUserName(userName);
		int equipmentCount = equipmentService.findEquipmentCount(creatUserId);
		List<Equipment> allEquipment = equipmentService.findAllEquipment(creatUserId);
		mv.addObject("equipmentCount", equipmentCount);
		mv.addObject("allEquipment", allEquipment);
		mv.setViewName("equipment-list");
		return mv;
	}
	

	// 跳转到添加设备页面
	@RequestMapping(value = "/goToEquipmentAdd")
	public ModelAndView goToEquipmentAdd() {
		ModelAndView mv = new ModelAndView();
		String userName = (String) session.getAttribute("uName");
		System.out.println(userName);
		User user = equipmentService.findfactoryIdByUserId(userName);
		System.out.println(user.getId());
		if(user.getId()!=null) {
			mv.addObject("factoryId",user.getId());
		}
		mv.setViewName("equipment-add");
		return mv;
	}
	
	// 跳转到修改设备
	@GetMapping(value = "/goToEquipmentUpdate")
	public ModelAndView goToEquipmentUpdate(@RequestParam(value = "id") int id,@RequestParam(value = "equipmentSeq")String equipmentSeq,@RequestParam(value = "factoryId")String factoryId) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("equipment-update");
		mv.addObject("equipmentSeq", equipmentSeq);
		mv.addObject("id", id);
		mv.addObject("factoryId",factoryId);
		return mv;
	}
	
	// 通过id修改设备的有效标识，设备名称，设备状态等
	@PostMapping(value = "/modifyEquipmentById")
	public ModelAndView modifyEquipmentById(int id,int flag,String equipmentName,int equipmentStatus,String equipmentImgUrl,int factoryId,String equipmentSeq) {
		ModelAndView mv =new ModelAndView();
		boolean b = equipmentService.replaceEuqipmentById(id, flag, equipmentName, equipmentStatus, equipmentImgUrl);
		if(b) {
			mv.addObject("msg", "添加成功");
			mv.addObject("id",id);
			mv.addObject("equipmentSeq", equipmentSeq);
			mv.addObject("factoryId",factoryId);
			mv.setViewName("equipment-update");
		} else {
			mv.addObject("msg", "添加失败");
			mv.setViewName("equipment-update");
		}
		return mv;
	}
	
	// 通过id删除设备
	@GetMapping(value = "/removeEquipmentById")
	public ModelAndView removeEquipmentById(int id) {
		ModelAndView mv= new ModelAndView();
		boolean b = equipmentService.removeEquipmentById(id);
		if(b) {
			mv.addObject("msg", "删除成功");
			String userName = (String) session.getAttribute("uName");
			int creatUserId = equipmentService.findIdByUserName(userName);
			int equipmentCount = equipmentService.findEquipmentCount(creatUserId);
			List<Equipment> allEquipment = equipmentService.findAllEquipment(creatUserId);
			mv.addObject("equipmentCount", equipmentCount);
			mv.addObject("allEquipment", allEquipment);
			mv.setViewName("equipment-list");
		} else {
			mv.addObject("msg", "删除失败");
			String userName = (String) session.getAttribute("uName");
			int creatUserId = equipmentService.findIdByUserName(userName);
			int equipmentCount = equipmentService.findEquipmentCount(creatUserId);
			List<Equipment> allEquipment = equipmentService.findAllEquipment(creatUserId);
			mv.addObject("equipmentCount", equipmentCount);
			mv.addObject("allEquipment", allEquipment);
			mv.setViewName("equipment-list");
		}
		return mv;
	}
	
	// 通过id批量删除
	@GetMapping(value = "/removeEquipmentByMoreId")
	public ModelAndView removeEquipmentByMoreId(String checkedId) {
		ModelAndView mv= new ModelAndView();
		String[] id = checkedId.split(",");
		boolean b = false;
		for (String string : id) {
			int equipmentId = Integer.parseInt(string);
			b = equipmentService.removeEquipmentById(equipmentId);
		}
		if(b) {
			mv.addObject("msg", "删除成功");
			String userName = (String) session.getAttribute("uName");
			int creatUserId = equipmentService.findIdByUserName(userName);
			int equipmentCount = equipmentService.findEquipmentCount(creatUserId);
			List<Equipment> allEquipment = equipmentService.findAllEquipment(creatUserId);
			mv.addObject("equipmentCount", equipmentCount);
			mv.addObject("allEquipment", allEquipment);
			mv.setViewName("equipment-list");
		} else {
			mv.addObject("msg", "删除失败");
			String userName = (String) session.getAttribute("uName");
			int creatUserId = equipmentService.findIdByUserName(userName);
			int equipmentCount = equipmentService.findEquipmentCount(creatUserId);
			List<Equipment> allEquipment = equipmentService.findAllEquipment(creatUserId);
			mv.addObject("equipmentCount", equipmentCount);
			mv.addObject("allEquipment", allEquipment);
			mv.setViewName("equipment-list");
		}
		return mv;
	}
	
	// 通过设备名称模糊查询设备
	@GetMapping(value = "/findEquipmentByLikeName")
	public ModelAndView findEquipmentByLikeName(String equipmentName) {
		ModelAndView mv = new ModelAndView();
		List<Equipment> allEquipment = equipmentService.findEquipmentLikeName(equipmentName);
		mv.addObject("equipmentCount", allEquipment.size());
		mv.addObject("allEquipment", allEquipment);
		mv.setViewName("equipment-list");
		return mv;
	}
}
