package com.gastonlagaf.learn.orm.entity;

import java.time.LocalDateTime;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "COMMENTS")
@SequenceGenerator(name = "DOMAIN_SEQ", sequenceName = "NWS_SEQ", allocationSize = 1)
@AttributeOverrides(value = {
	@AttributeOverride(name = "id", column = @Column(name = "CMT_COMMENT_ID"))
})
public class Comment extends DomainEntity<Long> {
	
	@Column(name = "CMT_COMMENT_TEXT", columnDefinition = "nvarchar2")
	private String commentText;
	
	@Column(name = "CMT_CREATION_DATE")
	private LocalDateTime created;
	
	@ManyToOne
	@JoinColumn(name = "CMT_NEWS_ID")
	private News news;

	public Comment() {
		super();
	}

	public Comment(String commentText, LocalDateTime created, News news) {
		super();
		this.commentText = commentText;
		this.created = created;
		this.news = news;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}
	
}
