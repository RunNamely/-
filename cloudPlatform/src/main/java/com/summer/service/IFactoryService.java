package com.summer.service;

import java.util.List;

import com.summer.pojo.Factory;
import com.summer.pojo.User;

public interface IFactoryService {

	// 插入工厂数据
	boolean insertFactory(Factory factory);

	// 根据id删除工厂数据
	boolean deltetFactoryById(Integer id);

	// 修改工厂数据
	boolean updateFactory(Factory factory);

	// 全查询
	List<Factory> getAllFactory();

	// 按条件查询
	List<Factory> getFactory(Factory factory);

	// 通过查询到的userId查询工厂id
	public User findfactoryIdByUserId(String userName);

	// 把工厂id插入user表中
	boolean updateFactoryIdByUserName(String userName, int factoryId);

	// 查询该用户名查询用户id
	public int findIdByUserName(String userName);
	
	// 通过creatId查询用户是否注册工厂
	int findIsExcitFactoryByCreatId(int creatUserId);
}
