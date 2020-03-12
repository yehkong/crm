package com.itcast.crm.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itcast.crm.domain.LinkMan;
import com.itcast.crm.domain.PageBean;

public interface LinkManService {

	PageBean<LinkMan> findAll(DetachedCriteria criteria, Integer currPage, Integer pageSize);

}
