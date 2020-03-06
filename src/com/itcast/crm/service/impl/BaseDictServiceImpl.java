package com.itcast.crm.service.impl;

import java.util.List;

import com.itcast.crm.dao.BaseDictDao;
import com.itcast.crm.domain.BaseDict;
import com.itcast.crm.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService {

	//注入dao
	private BaseDictDao basedictDao;

	public void setBasedictDao(BaseDictDao basedictDao) {
		this.basedictDao = basedictDao;
	}

	@Override
	public List<BaseDict> findByTypeCode(String dict_type_code) {
		
		List<BaseDict> list = this.basedictDao.findByDict_type_code(dict_type_code);
		return list;
	}
	
	
	
}
