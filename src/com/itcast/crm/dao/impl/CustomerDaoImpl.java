package com.itcast.crm.dao.impl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itcast.crm.dao.CustomerDao;
import com.itcast.crm.domain.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	@Override
	public void save(Customer customer) {
		this.getHibernateTemplate().save(customer);
		
	}

}
