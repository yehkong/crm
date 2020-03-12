package com.itcast.crm.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itcast.crm.dao.LinkManDao;
import com.itcast.crm.domain.LinkMan;

public class LinkManDaoImpl extends HibernateDaoSupport implements LinkManDao {

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
	public List<LinkMan> findAll(DetachedCriteria criteria, Integer currPage, Integer pageSize) {
		criteria.setProjection(null);
		
		return (List<LinkMan>) this.getHibernateTemplate().findByCriteria(criteria, currPage, pageSize);
	}


}
