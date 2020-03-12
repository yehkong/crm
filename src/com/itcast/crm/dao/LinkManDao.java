package com.itcast.crm.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itcast.crm.domain.LinkMan;

public interface LinkManDao {

	  Integer findCount(DetachedCriteria criteria);

	List<LinkMan> findAll(DetachedCriteria criteria, Integer currPage, Integer pageSize);
}
