package com.itcast.crm.dao;

import com.itcast.crm.domain.User;

public interface UserDao {

	
	void save(User user);

	void regist(User user);

	User login(User user);
}
