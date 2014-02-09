package org.netlight.com.dw.model;

import org.hibernate.validator.constraints.NotEmpty;

public class AddCommentJson {
	
	@NotEmpty
	private String comment;
	@NotEmpty
	private String author;
	
	public String getComment() {
		return comment;
	}
	public String getAuthor() {
		return author;
	}
	
	
}
