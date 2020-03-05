package com.itcast.crm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itcast.crm.dao.UserDao;
import com.itcast.crm.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void regist(User user) {
		// TODO Auto-generated method stub
		//this.getHibernateTemplate().setCheckWriteOperations(false);
		this.getHibernateTemplate().save(user);
	}


	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where user_code = ? and user_password = ?", user.getUser_code(),user.getUser_password());
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
