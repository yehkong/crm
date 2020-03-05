package com.itcast.crm.web.action;

import com.itcast.crm.domain.Customer;
import com.itcast.crm.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Model驱动
	private Customer customer = new Customer();
	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}
	
	//注入service
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	//增加客户
	public String saveUI() {
		
		return "saveUI";
	}
	
	
	
	

}
