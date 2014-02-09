package org.netlight.com.dw;

import org.netlight.com.dw.dao.BlogPostDao;
import org.netlight.com.dw.dao.CommentDao;
import org.netlight.com.dw.resource.BlogResource;
import org.netlight.com.dw.resource.CommentResource;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

/**
 * The Service class responsible for the bootstrapping of the resource classes
 *
 */
public class BlogService extends Service<BlogServiceConfiguration> 
{
	public static void main(String[] args) throws Exception {
        new BlogService().run(args);
    }
	
	@Override
	public void initialize(Bootstrap<BlogServiceConfiguration> bootstrap) {
		bootstrap.setName("blog");
		
	}

	@Override
	public void run(BlogServiceConfiguration configuration, Environment env)
			throws Exception {
		BlogPostDao blogPostDao = new BlogPostDao();
		CommentDao commentDao = new CommentDao();
		BlogResource blogResource = new BlogResource(commentDao, blogPostDao);
		CommentResource commentResource = new CommentResource(commentDao);
		env.addResource(blogResource);
		env.addResource(commentResource);
	}
}