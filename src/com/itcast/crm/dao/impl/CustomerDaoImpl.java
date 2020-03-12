package com.itcast.crm.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itcast.crm.dao.CustomerDao;
import com.itcast.crm.domain.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	@Override
	public void save(Customer customer) {
		this.getHibernateTemplate().save(customer);
		
	}

	@Override
	public Integer findCount(DetachedCriteria criteria) {
		criteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(criteria);
		if (list.size() > 0) {
			return list.get(0).intValue();
		}
		return null;
	}

	@Override
	public List<Customer> findAll(DetachedCriteria criteria, Integer currPage, Integer pageSize) {
		criteria.setProjection(null);
		
		return (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria, currPage, pageSize);
	}

	@Override
	public Customer findByCustid(Long cust_id) {
		Customer customer = (Customer) this.getHibernateTemplate().get(Customer.class, cust_id);
		return customer;
	}

	@Override
	public void update(Customer customer) {
		this.getHibernateTemplate().update(customer);
		
	}

	@Override
	public void delete(Customer customer) {
		this.getHibernateTemplate().delete(customer);
		
	}

}
