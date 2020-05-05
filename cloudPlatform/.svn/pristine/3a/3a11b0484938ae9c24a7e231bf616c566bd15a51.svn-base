package com.summer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summer.dao.IProductDao;
import com.summer.pojo.Product;
import com.summer.pojo.User;
import com.summer.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService{
	@Autowired
	private IProductDao productDao;
	
	@Override
	public boolean addProduct(Product product) {
		boolean addProduct = productDao.addProduct(product);
		return addProduct;
	}

	@Override
	public boolean removeProduct(int id) {
		boolean removeProduct = productDao.removeProduct(id);
		return removeProduct;
	}

	@Override
	public boolean updateProduct(Product product) {
		boolean updateProduct = productDao.updateProduct(product);
		return updateProduct;
	}

	@Override
	public List<Product> findProduct(Product product) {
		List<Product> findProduct = productDao.findProduct(product);
		return findProduct;
	}

	@Override
	public boolean deleteProduct(List<String> list) {
		boolean deleteProduct = productDao.deleteProduct(list);
		return deleteProduct;
	}

	@Override
	public User selectUserByUserName(String userName) {
		User user = productDao.selectUserByUserName(userName);
		return user;
	}

	@Override
	public int countOrder(Integer orderStatus) {
		int countOrder = productDao.countOrder(orderStatus);
		return countOrder;
	}
	
}
