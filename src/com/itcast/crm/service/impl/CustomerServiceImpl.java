package com.itcast.crm.service.impl;

import com.itcast.crm.dao.CustomerDao;
import com.itcast.crm.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	
	//注入serviceDao
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	

}
