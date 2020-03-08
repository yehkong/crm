package com.itcast.crm.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.itcast.crm.dao.CustomerDao;
import com.itcast.crm.domain.Customer;
import com.itcast.crm.domain.PageBean;
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

	@Override
	public PageBean<Customer> findAll(DetachedCriteria criteria, Integer currPage, Integer pageSize) {
		PageBean<Customer> pageBean = new PageBean<Customer>();
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(pageSize);
		Integer findCount = customerDao.findCount(criteria);
		pageBean.setTotalCount(findCount);
		Double total = findCount.doubleValue();
		Double page = Math.ceil(total/pageSize);
		pageBean.setTotalPage(page.intValue());
		Integer start = (currPage-1) * pageSize;
		List<Customer> findAll = customerDao.findAll(criteria,start,pageSize);
		pageBean.setList(findAll);
		return pageBean;
		
	}
	

}
