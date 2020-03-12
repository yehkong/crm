package com.itcast.crm.service;

import org.hibernate.criterion.DetachedCriteria;

import com.itcast.crm.domain.Customer;
import com.itcast.crm.domain.PageBean;

public interface CustomerService {

	void save(Customer customer);

	PageBean<Customer> findAll(DetachedCriteria criteria, Integer currPage, Integer pageSize);

    Customer findByCustid(Long cust_id);

	void update(Customer customer);

	void delete(Customer customer);
}
