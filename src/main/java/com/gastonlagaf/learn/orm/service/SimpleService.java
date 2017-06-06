package com.gastonlagaf.learn.orm.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.gastonlagaf.learn.orm.annotation.TransactionalOperation;
import com.gastonlagaf.learn.orm.annotation.processor.TransactionalOperationAnnotationProcessor;
import com.gastonlagaf.learn.orm.entity.Comment;
import com.gastonlagaf.learn.orm.entity.News;
import com.gastonlagaf.learn.orm.entity.Tag;
import com.gastonlagaf.learn.orm.repositories.GenericRepository;
import com.gastonlagaf.learn.orm.repositories.JpaRepository;
import com.gastonlagaf.pwsf.annotation.Suppress;

public class SimpleService implements Service {
	
	@Suppress
	public static Service getInstance() {
		return (Service)TransactionalOperationAnnotationProcessor.newInstance(new SimpleService(), SimpleService.class.getInterfaces());
	}

	@Suppress
	@TransactionalOperation
	public void performOperation() {
		GenericRepository<Tag, Long> tagRepo = new JpaRepository<>(Tag.class);
		Tag tag = new Tag("Politics");
		tagRepo.save(tag);
		
		List<Tag> tags = new ArrayList<>();
		tags.add(tag);
		
		Comment comment = new Comment();
		comment.setCommentText("Nice)");
		comment.setCreated(LocalDateTime.now());
		List<Comment> comments = new ArrayList<>();
		comments.add(comment);
		
		GenericRepository<News, Long> newsRepo = new JpaRepository<>(News.class);
		News news = new News();
		news.setShortText("awdw");
		news.setFullText("dawfaewfawef");
		news.setCreationDate(LocalDateTime.now());
		news.setModificationDate(LocalDateTime.now());
		news.setTitle("Opa");
		news.setTags(tags);
		news.setComments(comments);
		newsRepo.save(news);
	}
	
}
