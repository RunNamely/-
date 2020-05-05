package com.summer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.summer.pojo.Product;
import com.summer.pojo.User;

@Mapper
public interface IProductDao {

	// 增加产品
	public boolean addProduct(Product product);

	// 删除产品
	public boolean removeProduct(int id);

	// 更改产品
	public boolean updateProduct(Product product);

	// 查询产品
	public List<Product> findProduct(Product product);
	
	//批量删除
	public boolean deleteProduct(List<String> list);
	
	// 通过userName查询工厂user
	public User selectUserByUserName(String userName);
	
	//统计工厂订单状态
	public int countOrder(Integer orderStatus);
	
}