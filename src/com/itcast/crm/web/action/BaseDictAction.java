package com.itcast.crm.web.action;



import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.itcast.crm.domain.BaseDict;
import com.itcast.crm.service.BaseDictService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

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
	
	//找来源
	public String findByTypeCode() throws IOException {
		System.out.println(basedict.getDict_type_code());
		List<BaseDict> list = basedictService.findByTypeCode(basedict.getDict_type_code());
		//转json
		JsonConfig jsonConfig= new JsonConfig();
		jsonConfig.setExcludes(new String[] {"dict_sort","dict_enable","dict_memo"});
		JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
		System.out.println(jsonArray.toString());
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().println(jsonArray.toString());
		return NONE;
	}
	

}
