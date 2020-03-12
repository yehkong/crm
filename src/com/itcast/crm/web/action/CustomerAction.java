package com.itcast.crm.web.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.itcast.crm.domain.Customer;
import com.itcast.crm.domain.PageBean;
import com.itcast.crm.service.CustomerService;
import com.itcast.crm.utils.UploadUtils;
import com.opensymphony.xwork2.ActionContext;
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
		
	private String uploadImageFileName;
	private String uploadImageContentType;
	private File uploadImage;

	public void setUploadImageFileName(String uploadImageFileName) {
		this.uploadImageFileName = uploadImageFileName;
	}

	public void setUploadImageContentType(String uploadImageContentType) {
		this.uploadImageContentType = uploadImageContentType;
	}

	public void setUploadImage(File uploadImage) {
		this.uploadImage = uploadImage;
	}

	//新增客户
	public String save() throws IOException{
		if (uploadImage != null) {
			String filename = UploadUtils.getUuidFileName(uploadImageFileName);
			String path = "./" + "upload" + UploadUtils.getPath(filename) + "/" + filename;
			File file = new File(path);
			FileUtils.copyFile(uploadImage, file);
			//保存图片链接
			customer.setCust_Image(path);
			
		}
		
		customerService.save(customer);
		return "saveSuccess";
	}
	
	private Integer currPage = 1;
	
	private Integer pageSize = 3;

	public void setCurrPage(Integer currPage) {
		if (currPage==null) {
			this.currPage = 1;
		}else {
		this.currPage = currPage;
		}
	}

	public void setPageSize(Integer pageSize) {
		if (pageSize==null) {
			this.pageSize = 3;
		}else {
		this.pageSize = pageSize;
		}
	}
	
	//查询所有客户
	public String findAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		
		if (customer.getCust_name() != null && !"".equals(customer.getCust_name())) {
			criteria.add(Restrictions.like("cust_name", "%" + customer.getCust_name() + "%"));
		}
		
		if (customer.getBasedictLevel() != null) {
			if (customer.getBasedictLevel().getDict_id() != null && !"".equals(customer.getBasedictLevel().getDict_id()))
			criteria.add(Restrictions.eq("basedictLevel.dict_id",customer.getBasedictLevel().getDict_id() ));
		}
		
		if (customer.getBasedictSource() != null) {
			if (customer.getBasedictSource().getDict_id() != null && !"".equals(customer.getBasedictSource().getDict_id()))
			criteria.add(Restrictions.eq("basedictSource.dict_id",customer.getBasedictSource().getDict_id() ));
		}
		
		if (customer.getBasedictIndustry() != null) {
			if (customer.getBasedictIndustry().getDict_id() != null && !"".equals(customer.getBasedictIndustry().getDict_id()))
			criteria.add(Restrictions.eq("basedictIndustry.dict_id",customer.getBasedictIndustry().getDict_id() ));
		}
		
		PageBean pageBean = customerService.findAll(criteria,this.currPage,this.pageSize);
		System.out.print(pageBean);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	//编辑客户
	public String edit() {
		customer = customerService.findByCustid(customer.getCust_id());
		ActionContext.getContext().getValueStack().push(customer);
		return "editSuccess";
	}
	
	//修改客户
	public String update() throws IOException {
		if (uploadImage != null) {
			String custImage = customer.getCust_Image();
			if (custImage != null && !"".equals(custImage)) {
				File existFile = new File(custImage);
				if (existFile.exists()) {
					existFile.delete();
				}
			}

			String filename = UploadUtils.getUuidFileName(uploadImageFileName);
			String path = "./" + "upload" + UploadUtils.getPath(filename) + "/" + filename;
			File file = new File(path);
			FileUtils.copyFile(uploadImage, file);
			//保存图片链接
			customer.setCust_Image(path);
		}
		System.out.println(customer.toString());
		customerService.update(customer);
		return "updateSuccess";
	}

	//删除客户
	public String delete() {
		customer = customerService.findByCustid(customer.getCust_id());
		if (uploadImage != null) {
			String custImage = customer.getCust_Image();
			if (custImage != null && !"".equals(custImage)) {
				File existFile = new File(custImage);
				if (existFile.exists()) {
					existFile.delete();
				}
			}
		}
		customerService.delete(customer);
		return "deleteSuccess";
	}
	
	

}
