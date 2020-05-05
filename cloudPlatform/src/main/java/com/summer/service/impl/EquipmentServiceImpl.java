package com.summer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summer.dao.IEquipmentDao;
import com.summer.pojo.Equipment;
import com.summer.pojo.User;
import com.summer.service.IEquipmentService;

@Service
public class EquipmentServiceImpl implements IEquipmentService{
	
	@Autowired
	private IEquipmentDao equipmentDao;
	
	@Override
	public List<Equipment> findAllEquipment(int creatUserId) {
		
		return equipmentDao.selectAll(creatUserId);
	}
	
	// 插入设备
	@Override
	public Equipment selectEquipmentById(Integer id) {
		
		return equipmentDao.selectEquipmentById(id);
	}
	
	// 查询设备数量
	@Override
	public int findEquipmentCount(int creatUserId) {
			
			return equipmentDao.selectEquipmentCount(creatUserId);
		}

	@Override
	public boolean removeEquipmentById(int id) {
		
		return equipmentDao.deleteEquipmentById(id);
	}

	@Override
	public boolean addEquipment(Equipment equipment) {
			boolean b = equipmentDao.insertEquipment(equipment);
		return b;
	}

	@Override
	public boolean updateEquipment(Equipment equipment) {
		// TODO Auto-generated method stub
		return false;
	}

	// 通过id修改设备有效标识，设备名称，设备状态等
	@Override
	public boolean replaceEuqipmentById(int id, int flag, String equipmentName, int equipmentStatus,
			String equipmentImgUrl) {
		return equipmentDao.updateEuqipmentById(id, flag, equipmentName, equipmentStatus, equipmentImgUrl);
	}

	@Override
	public List<Equipment> findEquipmentLikeName(String equipmentName) {
		
		return equipmentDao.selectEquipmentLikeName(equipmentName);
	}

	@Override
	public int findIdByUserName(String userName) {
		return equipmentDao.selectIdByUserName(userName);
	}

	@Override
	public User findfactoryIdByUserId(String userName) {
		return equipmentDao.selectfactoryIdByUserId(userName);
	}

	

}
