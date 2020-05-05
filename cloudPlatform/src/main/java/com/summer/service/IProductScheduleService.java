package com.summer.service;

import java.util.List;

import com.summer.pojo.ProductSchedule;

public interface IProductScheduleService {

	     //查询所有的根据ID来查询
		 public List<ProductSchedule> AllProductSchedule(Integer id);
		 //添加
		 public boolean InsertProductSchedule(ProductSchedule productSchedule);
		 //更新
		 public Boolean UpdateProductSchedule(List<ProductSchedule> list);
		 //删除
		 public boolean romoveProductSchedule(Integer id); 
}