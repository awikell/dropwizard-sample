package org.netlight.com.dw.dao;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.netlight.com.dw.model.BlogPost;

public class BlogPostDao {
	
	private List<BlogPost> blogPostList;
	private long idCounter = 1;
	
	public BlogPostDao() {
		blogPostList = new ArrayList<BlogPost>();
		blogPostList.add(new BlogPost(idCounter, "Hello World", "This is a test post", new DateTime()));
		idCounter++;
	}

	public List<BlogPost> getAll() {
		return blogPostList;
	}

	public BlogPost get(long id) {
		for(BlogPost post : blogPostList) {
			if(post.getId() == id) {
				return post;
			}
		}
		return null;
	}

	public void addBlogPost(String title, String text) {
		blogPostList.add(new BlogPost(idCounter, title, text, new DateTime()));
		idCounter++;
	}
	
	public boolean isConnected() {
		return false;
	}

}
