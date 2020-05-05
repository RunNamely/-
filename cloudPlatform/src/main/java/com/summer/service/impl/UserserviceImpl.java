package com.summer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summer.dao.IUserDao;
import com.summer.pojo.User;
import com.summer.service.IUserService;

@Service
public class UserserviceImpl implements IUserService {

	@Autowired
	private IUserDao iUser;
	
	@Override
	public List<User> selectAllUser(Integer id) {
		return iUser.selectAllUser(id);
	}

	@Override
	public boolean deleteUserById(Integer id) {
		return false;
	}

	@Override
	public Boolean updateUserById(Integer id) {
		return null;
	}

	@Override
	public Boolean insertUser(User user) {
		
		return iUser.insertUser(user);
	}

	@Override
	public User selectUserByUserName(String userName) {
		return iUser.selectUserByUserName(userName);
	}

	@Override
	public int selectIsExistCreatFactory(String userName) {
		return iUser.selectIsExistCreatFactory(userName);
	}

}
