package com.summer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.summer.pojo.Equipment;
import com.summer.pojo.User;

@Mapper
public interface IEquipmentDao {
	
	// 添加设备
	boolean insertEquipment(Equipment equipment);
	
	// 查询共有多少条数据
	int selectEquipmentCount(int creatUserId);
	
	// 全查询该用户
	List<Equipment> selectAll(int creatUserId);
	
	// 通过id修改设备有效标识，设备名称，设备状态等
	boolean updateEuqipmentById(int id,int flag,String equipmentName,int equipmentStatus,String equipmentImgUrl);
	
	// 通过id删除记录
	boolean deleteEquipmentById(int id);
	
	// 通过设备名称模糊查询设备
	List<Equipment> selectEquipmentLikeName(@Param("equipmentName") String equipmentName);
	
	// 查询该用户名查询用户id
	public int selectIdByUserName(String userName);
	
	// 通过查询到的userId查询工厂id
	public User selectfactoryIdByUserId(String userName);
	
	// 通过id查询单条记录
	Equipment selectEquipmentById(Integer id);
	// 更新某条记录
	boolean updateEquipment(Equipment equipment);
	
}
