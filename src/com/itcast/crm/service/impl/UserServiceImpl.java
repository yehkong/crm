package com.itcast.crm.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.itcast.crm.dao.UserDao;
import com.itcast.crm.dao.impl.UserDaoImpl;
import com.itcast.crm.domain.User;
import com.itcast.crm.service.UserService;
import com.itcast.crm.utils.MD5Utils;
@Transactional
public class UserServiceImpl implements UserService {

	//注入UserDao
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void regist(User user) {
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		this.userDao.regist(user);
	}

	@Override
	public User login(User user) {
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		User exitUser = userDao.login(user);
		return exitUser;
	}

}
