package com.summer.service;

import java.util.List;

import com.summer.pojo.Equipment;
import com.summer.pojo.User;

public interface IEquipmentService {

	// 插入设备
	public boolean addEquipment(Equipment equipment);

	// 查询设备数量
	public int findEquipmentCount(int creatUserId);

	// 查全部信息
	public List<Equipment> findAllEquipment(int creatUserId);

	// 通过id修改设备有效标识，设备名称，设备状态等
	boolean replaceEuqipmentById(int id, int flag, String equipmentName, int equipmentStatus, String equipmentImgUrl);

	// 通过id删除记录
	public boolean removeEquipmentById(int id);

	// 通过设备名称模糊查询设备
	public List<Equipment> findEquipmentLikeName(String equipmentName);

	// 查询该用户名查询用户id
	public int findIdByUserName(String userName);

	// 通过查询到的userId查询工厂id
	public User findfactoryIdByUserId(String userName);

	// 通过id查询单条记录
	public Equipment selectEquipmentById(Integer id);

	// 更新记录
	public boolean updateEquipment(Equipment equipment);
}
