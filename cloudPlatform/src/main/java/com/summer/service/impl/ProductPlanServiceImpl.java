package com.summer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.summer.dao.IProductPlanDao;
import com.summer.pojo.ProductPlan;
import com.summer.service.IProductPlanService;
@Service
public class ProductPlanServiceImpl implements IProductPlanService{
	
	@Autowired
	private IProductPlanDao iProductPlanDao;

	@Override
	public List<ProductPlan> selectProductPlan(ProductPlan productPlan) {
		List<ProductPlan> productPlan1 = iProductPlanDao.selectProductPlan(productPlan);
		return productPlan1;
	}

	@Override
	public boolean insertProductPlan(ProductPlan ProductPlan) {
		return iProductPlanDao.insertProductPlan(ProductPlan);
	}

	@Override
	public boolean updateProductPlan(ProductPlan ProductPlan) {
		return iProductPlanDao.updateProductPlan(ProductPlan);
	}

	@Override
	public boolean deleteProductPlan(Integer id) {
		return iProductPlanDao.deleteProductPlan(id);
	}

	//启动计划
	@Override
	public boolean qidong(Integer id) {	
		return iProductPlanDao.qidong(id);
	}


}
