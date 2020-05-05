package com.summer.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summer.dao.IProductOrderDao;
import com.summer.pojo.ProductOrder;
import com.summer.service.IProductOrderService;

@Service
public class ProductOrderServiceImpl implements IProductOrderService {

	@Autowired
	private IProductOrderDao productOrderDao;

	@Override
	public boolean insertProductOrder(ProductOrder productOrder) {
		// 自动生成订单编号(当前时间的年月日时分秒毫秒)
		String orderSeq = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		productOrder.setOrderSeq(orderSeq);
		if (productOrder.getProductId() != null) {
			// 通过产品id查找工厂id并插入订单表
			Integer factoryId = productOrderDao.selectFactoryIdByProductId(productOrder.getProductId());
			productOrder.setFactoryId(factoryId);
		}
		return productOrderDao.insertProductOrder(productOrder);
	}

	@Override
	public boolean deltetProductOrderById(Integer id) {
		return productOrderDao.deltetProductOrderById(id);
	}

	@Override
	public boolean updateProductOrder(ProductOrder productOrder) {
		return productOrderDao.updateProductOrder(productOrder);
	}

	@Override
	public List<ProductOrder> getAll() {
		return productOrderDao.selectAll();
	}

	@Override
	public List<ProductOrder> getProductOrder(ProductOrder productOrder) {
		return productOrderDao.selectProductOrder(productOrder);
	}

	@Override
	public List<Integer> getAllProductId() { 
		return productOrderDao.selectAllProductId();
	}

}
