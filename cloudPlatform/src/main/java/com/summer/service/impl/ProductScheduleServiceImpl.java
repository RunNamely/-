package com.summer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summer.dao.IproductScheduleDao;
import com.summer.pojo.ProductSchedule;
import com.summer.service.IProductScheduleService;

@Service
public class ProductScheduleServiceImpl implements IProductScheduleService{

	@Autowired
	private IproductScheduleDao productScheduleDao;
	
	@Override
	public List<ProductSchedule> AllProductSchedule(Integer id) {
		List<ProductSchedule> list = productScheduleDao.selectProductSchedule(id);
		System.out.println(list);
		return list;
	}

	@Override
	public boolean InsertProductSchedule(ProductSchedule productSchedule) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boolean UpdateProductSchedule(List<ProductSchedule> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean romoveProductSchedule(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}
	



}
