package com.summer.service;

import java.util.List;



import com.summer.pojo.ProductPlan;

public interface IProductPlanService {

	 //查询所有的根据ID来查询
	 public List<ProductPlan> selectProductPlan(ProductPlan productPlan);
	 //添加
	 public boolean insertProductPlan(ProductPlan ProductPlan);
	 //更新
	 public boolean updateProductPlan(ProductPlan ProductPlan);
	 //删除
	 public boolean deleteProductPlan(Integer id); 
	 
	 //启动计划方法
	 public  boolean qidong(Integer id);
	
}
