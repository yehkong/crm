package com.itcast.crm.web.action;

import org.hibernate.criterion.DetachedCriteria;

import com.itcast.crm.domain.Customer;
import com.itcast.crm.domain.PageBean;
import com.itcast.crm.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Model驱动
	private Customer customer = new Customer();

	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}

	// 注入service
	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	// 增加客户UI
	public String saveUI() {
		return "saveUI";
	}
	
	//新增客户
	public String save(){
		customerService.save(customer);
		return NONE;
	}
	
	private Integer currPage = 1;
	
	private Integer pageSize = 3;

	public void setCurrPage(Integer currPage) {
		if (currPage==null) {
			this.currPage = 1;
		}
		this.currPage = currPage;
	}

	public void setPageSize(Integer pageSize) {
		if (pageSize==null) {
			this.pageSize = 3;
		}
		this.pageSize = pageSize;
	}
	
	//查询所有客户
	public String findAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		PageBean pageBean = customerService.findAll(criteria,currPage,pageSize);
		return "findAll";
	}

}
