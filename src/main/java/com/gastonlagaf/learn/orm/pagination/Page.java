package com.gastonlagaf.learn.orm.pagination;

import java.util.List;

public class Page<T> {
	
	private List<T> content;
	
	private Integer page;
	
	private Long totalElements;
	
	private Integer totalPages;

	public Page() {
		super();
	}

	public Page(List<T> content, Integer page, Long totalElements, Integer totalPages) {
		super();
		this.content = content;
		this.page = page;
		this.totalElements = totalElements;
		this.totalPages = totalPages;
	}

	public List<T> getContent() {
		return content;
	}

	public Integer getPage() {
		return page;
	}

	public Long getTotalElements() {
		return totalElements;
	}

	public Integer getTotalPages() {
		return totalPages;
	}
	
}
