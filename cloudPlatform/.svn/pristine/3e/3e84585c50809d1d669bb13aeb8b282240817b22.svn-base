package com.summer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.summer.pojo.ProductSchedule;

@Mapper
public interface IproductScheduleDao {
     //查询所有的根据ID来查询
	 public List<ProductSchedule> selectProductSchedule(@Param("id")Integer id);
	 //添加
	 public boolean insertProductSchedule(ProductSchedule productSchedule);
	 //更新
	 public boolean updateProductSchedule(Integer id);
	 //删除
	 public boolean deleteProductSchedule(Integer id); 
	 
}
