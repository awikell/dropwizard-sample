package org.netlight.com.dw.health;

import org.netlight.com.dw.dao.BlogPostDao;

import com.yammer.metrics.core.HealthCheck;

public class BlogPostDaoHealthCheck extends HealthCheck {

	private BlogPostDao blogPostDao;
	
	public BlogPostDaoHealthCheck(BlogPostDao blogPostDao) {
		super("blogPostDao");
		this.blogPostDao = blogPostDao;
	}

	@Override
	public Result check() throws Exception {
		if(!blogPostDao.isConnected()) {
			return Result.unhealthy("BlogPostDao is not connected!");
		}
		return Result.healthy();
	}
}
