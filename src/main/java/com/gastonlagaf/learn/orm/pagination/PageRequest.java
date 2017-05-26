package com.gastonlagaf.learn.orm.pagination;

public class PageRequest {
	
	private Integer pageCapacity;
	
	private Integer page;
	
	public PageRequest() {
		super();
	}

	public PageRequest(Integer page, Integer pageCapacity) {
		super();
		this.pageCapacity = pageCapacity;
		this.page = page;
	}

	public Integer getPageCapacity() {
		return pageCapacity;
	}

	public Integer getPage() {
		return page;
	}
	
}
