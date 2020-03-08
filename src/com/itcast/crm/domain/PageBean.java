package com.itcast.crm.domain;

import java.util.List;

public class PageBean<Customer> {
	private Integer currPage;
	private Integer pageSize;
	private Integer totalCount;
	public Integer getCurrPage() {
		return currPage;
	}
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List<Customer> getList() {
		return list;
	}
	public void setList(List<Customer> list) {
		this.list = list;
	}
	private Integer totalPage;
	private List<Customer> list;
}
