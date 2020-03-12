package com.itcast.crm.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itcast.crm.dao.LinkManDao;
import com.itcast.crm.domain.LinkMan;
import com.itcast.crm.domain.PageBean;
import com.itcast.crm.service.LinkManService;

public class LinkManServiceImpl implements LinkManService{
	
	//注入dao
	private LinkManDao linkManDao;
	

	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}


	@Override
	public PageBean<LinkMan> findAll(DetachedCriteria criteria, Integer currPage, Integer pageSize) {
		PageBean<LinkMan> pageBean = new PageBean<LinkMan>();
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(pageSize);
		Integer findCount = linkManDao.findCount(criteria);
		pageBean.setTotalCount(findCount);
		Double total = findCount.doubleValue();
		Double page = Math.ceil(total/pageSize);
		pageBean.setTotalPage(page.intValue());
		System.out.println(currPage);
		System.out.println(pageSize);
		Integer start = (currPage-1) * pageSize;
		List<LinkMan> findAll = linkManDao.findAll(criteria,start,pageSize);
		pageBean.setList(findAll);
		return pageBean;
		
	}

}
