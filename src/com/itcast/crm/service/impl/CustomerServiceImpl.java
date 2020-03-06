package com.itcast.crm.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.itcast.crm.dao.CustomerDao;
import com.itcast.crm.domain.Customer;
import com.itcast.crm.service.CustomerService;
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	//注入serviceDao
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void save(Customer customer) {
		customerDao.save(customer);
		
	}
	

}
