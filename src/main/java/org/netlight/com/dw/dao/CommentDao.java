package org.netlight.com.dw.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.joda.time.DateTime;
import org.netlight.com.dw.model.BlogPost;
import org.netlight.com.dw.model.Comment;

public class CommentDao {
	
	private List<Comment> commentList;
	private long idCounter = 1;
	
	public CommentDao() {
		commentList = new ArrayList<Comment>();
		commentList.add(new Comment(idCounter, "First!", "The UnicorN", new DateTime(), 1));
		idCounter++;
	}

	public List<Comment> getAll() {
		return commentList;
	}

	public Comment get(long id) {
		for(Comment comment : commentList) {
			if(comment.getId() == id) {
				return comment;
			}
		}
		return null;
	}
	
	public List<Comment> getAllCommentsForBlogPost(long blogPostId) {
		List<Comment> results = new ArrayList<Comment>();
		for(Comment comment : commentList) {
			if(comment.getBlogPostId() == blogPostId) {
				results.add(comment);
			}
		}
		return results;
	}

	public void addComment(String comment, String author, long blogPostId) {
		commentList.add(new Comment(idCounter, comment, author, new DateTime(), blogPostId));
		idCounter++;
	}
	
	public boolean deleteComment(long commentId) {
		Iterator<Comment> iter = commentList.iterator();
		while(iter.hasNext()) {
			if(iter.next().getId() == commentId) {
				iter.remove();
				return true;
			}
		}
		return false;
	}

}
