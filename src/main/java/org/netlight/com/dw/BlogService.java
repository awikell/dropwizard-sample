package org.netlight.com.dw;

import org.netlight.com.dw.dao.BlogPostDao;
import org.netlight.com.dw.resource.BlogResource;

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
		BlogResource blogResource = new BlogResource(blogPostDao);
		env.addResource(blogResource);
	}
}