package com.itcast.crm.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itcast.crm.domain.Customer;

public interface CustomerDao {

	void save(Customer customer);

    Integer findCount(DetachedCriteria criteria);

	List<Customer> findAll(DetachedCriteria criteria, Integer currPage, Integer pageSize);

	Customer findByCustid(Long cust_id);

	void update(Customer customer);

	void delete(Customer customer);


}
