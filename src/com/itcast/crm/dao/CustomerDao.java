package com.itcast.crm.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itcast.crm.domain.Customer;

public interface CustomerDao {

	void save(Customer customer);

    Integer findCount(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	List<Customer> findAll(DetachedCriteria criteria, Integer currPage, Integer pageSize);


}
