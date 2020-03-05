package com.itcast.crm.web.action;

import org.apache.struts2.ServletActionContext;

import com.itcast.crm.domain.User;
import com.itcast.crm.service.UserService;
import com.itcast.crm.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user = new User();

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	//注入UserService
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	//注册
	public String regist() {
		userService.regist(user);
		return LOGIN;
	}
	
	//登录
	public String login() {
		User myUser = userService.login(user);
		if (myUser != null) {
			ServletActionContext.getRequest().getSession().setAttribute("existUser", myUser);
			return SUCCESS;
		}else {
			this.addActionError("用户名或者密码错误");
			return LOGIN;
		}
		
	}
	
}
