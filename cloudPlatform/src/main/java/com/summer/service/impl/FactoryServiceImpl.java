package com.summer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summer.dao.IFactoryDao;
import com.summer.pojo.Factory;
import com.summer.pojo.User;
import com.summer.service.IFactoryService;

@Service
public class FactoryServiceImpl implements IFactoryService {

	@Autowired
	private IFactoryDao factoryDao;

	@Override
	public boolean insertFactory(Factory factory) {
		return factoryDao.insertFactory(factory);
	}

	@Override
	public boolean deltetFactoryById(Integer id) {
		return factoryDao.deltetFactoryById(id);
	}

	@Override
	public boolean updateFactory(Factory factory) {
		return factoryDao.updateFactory(factory);
	}

	@Override
	public List<Factory> getAllFactory() {
		return factoryDao.selectAll();
	}

	@Override
	public List<Factory> getFactory(Factory factory) {
		return factoryDao.selectFactroy(factory);
	}
	
	@Override
	public User findfactoryIdByUserId(String userName) {
		return factoryDao.selectfactoryIdByUserId(userName);
	}

	@Override
	public boolean updateFactoryIdByUserName(String userName, int factoryId) {
		return factoryDao.updateFactoryIdByUserName(userName, factoryId);
	}

	@Override
	public int findIdByUserName(String userName) {
		return factoryDao.selectIdByUserName(userName);
	}

	@Override
	public int findIsExcitFactoryByCreatId(int creatUserId) {
		return factoryDao.selectIsExcitFactoryByCreatId(creatUserId);
	}


}
