package com.itcast.crm.dao.impl;

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
		this.getHibernateTemplate().setCheckWriteOperations(false);
		this.getHibernateTemplate().save(user);
	}

}
