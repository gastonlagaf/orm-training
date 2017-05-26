package com.gastonlagaf.learn.orm.entity;

import java.time.LocalDateTime;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "NEWS")
@SequenceGenerator(name = "DOMAIN_SEQ", sequenceName = "NWS_SEQ", allocationSize = 1)
@AttributeOverrides(value = {
	@AttributeOverride(name = "id", column = @Column(name = "NWS_NEWS_ID"))
})
public class News extends DomainEntity<Long> {
	
	@Column(name = "NWS_TITLE", columnDefinition = "nvarchar2")
	private String title;
	
	@Column(name = "NWS_SHORT_TEXT", columnDefinition = "nvarchar2")
	private String shortText;
	
	@Column(name = "NWS_FULL_TEXT", columnDefinition = "nvarchar2")
	private String fullText;
	
	@Column(name = "NWS_CREATION_DATE")
	private LocalDateTime creationDate;
	
	@Column(name = "NWS_MODIFICATION_DATE")
	private LocalDateTime modificationDate;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortText() {
		return shortText;
	}

	public void setShortText(String shortText) {
		this.shortText = shortText;
	}

	public String getFullText() {
		return fullText;
	}

	public void setFullText(String fullText) {
		this.fullText = fullText;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(LocalDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}
	
}
