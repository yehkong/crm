package com.itcast.crm.service;

import java.util.List;

import com.itcast.crm.domain.BaseDict;

public interface BaseDictService {

	List<BaseDict> findByTypeCode(String dict_type_code);

	
	
	 
}
