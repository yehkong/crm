package com.itcast.crm.web.action;

import com.itcast.crm.domain.BaseDict;
import com.itcast.crm.service.BaseDictService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseDictAction extends ActionSupport implements ModelDriven<BaseDict> {

	//模型驱动
	private BaseDict basedict = new BaseDict();
	@Override
	public BaseDict getModel() {
		// TODO Auto-generated method stub
		return basedict;
	}
	
	//注入service
	private BaseDictService basedictService;
	public void setBasedictService(BaseDictService basedictService) {
		this.basedictService = basedictService;
	}
	

}
