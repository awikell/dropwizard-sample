package org.netlight.com.dw.model;
import org.joda.time.DateTime;

public class BlogPost {
	private final long id;
	private String title;
	private String text;
	private final DateTime createdDate;
	
	public BlogPost(long id, String title, String text, DateTime createdDate) {
		this.id = id;
		this.title = title;
		this.text = text;
		this.createdDate = createdDate;
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public DateTime getCreatedDate() {
		return createdDate;
	}
}