package com.summer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.summer.pojo.Factory;
import com.summer.pojo.User;

@Mapper
public interface IFactoryDao {

	// 插入工厂数据
	boolean insertFactory(Factory factory);

	// 根据id删除工厂数据
	boolean deltetFactoryById(Integer id);

	// 修改工厂数据
	boolean updateFactory(Factory factory);

	// 全查询
	List<Factory> selectAll();

	// 按条件查询
	List<Factory> selectFactroy(Factory factory);

	// 通过查询到的userId查询工厂id
	User selectfactoryIdByUserId(String userName);

	// 查询该用户名查询用户id
	int selectIdByUserName(String userName);

	// 把工厂id插入user表中
	boolean updateFactoryIdByUserName(String userName, int factoryId);

	// 通过creatId查询用户是否注册工厂
	int selectIsExcitFactoryByCreatId(int creatUserId);
	
}
