package com.gastonlagaf.learn.orm.entity;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TAGS")
@SequenceGenerator(name = "DOMAIN_SEQ", sequenceName = "TAG_SEQ", allocationSize = 1)
@AttributeOverrides(value = {
	@AttributeOverride(name = "id", column = @Column(name = "TAG_ID"))
})
public class Tag extends DomainEntity<Long> {
	
	@Column(name = "TAG_NAME", columnDefinition = "nvarchar2")
	private String name;
	
	@ManyToMany(mappedBy = "tags")
	private List<News> news;

	public Tag() {
		super();
	}

	public Tag(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<News> getNews() {
		return news;
	}

	public void setNews(List<News> news) {
		this.news = news;
	}
	
}
