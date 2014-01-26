package org.netlight.com.dw.model;

import org.hibernate.validator.constraints.NotEmpty;

public class AddBlogPostJson {
	@NotEmpty
	private String title;
	@NotEmpty
	private String text;
	
	public String getTitle() {
		return title;
	}
	public String getText() {
		return text;
	}
	
	
}
