package com.itcast.crm.service.impl;

import com.itcast.crm.dao.UserDao;
import com.itcast.crm.dao.impl.UserDaoImpl;
import com.itcast.crm.domain.User;
import com.itcast.crm.service.UserService;

public class UserServiceImpl implements UserService {

	//注入UserDao
	private UserDao userDao = new UserDaoImpl();
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void regist(User user) {
		this.userDao.regist(user);
	}

}
