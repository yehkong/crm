package com.itcast.crm.dao;

import java.util.List;

import com.itcast.crm.domain.BaseDict;

public interface BaseDictDao {

	List<BaseDict> findByDict_type_code(String dict_type_code);

}
