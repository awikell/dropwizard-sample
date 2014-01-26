package org.netlight.com.dw.model;

import org.joda.time.DateTime;

public class Comment {
	private final long id;
	private final String comment;
	private final String author;
	private final DateTime createdDate;
	private final long blogPostId;
	
	public Comment(long id, String comment, String author, DateTime createdDate, long blogPostId) {
		this.id = id;
		this.comment = comment;
		this.author = author;
		this.createdDate = createdDate;
		this.blogPostId = blogPostId;
	}

	public long getId() {
		return id;
	}

	public String getComment() {
		return comment;
	}

	public String getAuthor() {
		return author;
	}

	public DateTime getCreatedDate() {
		return createdDate;
	}

	public long getBlogPostId() {
		return blogPostId;
	}
	
	
	
}
