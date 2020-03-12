package com.itcast.crm.web.action;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.itcast.crm.domain.Customer;
import com.itcast.crm.domain.LinkMan;
import com.itcast.crm.domain.PageBean;
import com.itcast.crm.service.LinkManService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{

	//模型驱动
	private LinkMan linkMan;
	@Override
	public LinkMan getModel() {
		// TODO Auto-generated method stub
		return linkMan;
	}
	
	//注入service
	private LinkManService linkManService;
	
	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
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
			DetachedCriteria criteria = DetachedCriteria.forClass(LinkMan.class);

			
			PageBean pageBean = linkManService.findAll(criteria,this.currPage,this.pageSize);
			System.out.print(pageBean);
			ActionContext.getContext().getValueStack().push(pageBean);
			return "findAll";
		}
	
	

}
