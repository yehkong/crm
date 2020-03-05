package com.itcast.crm.service.impl;

import com.itcast.crm.dao.BaseDictDao;
import com.itcast.crm.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService {

	//注入dao
	private BaseDictDao basedictDao;

	public void setBasedictDao(BaseDictDao basedictDao) {
		this.basedictDao = basedictDao;
	}
	
	
}
