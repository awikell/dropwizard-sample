package org.netlight.com.dw.resource;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.netlight.com.dw.dao.BlogPostDao;
import org.netlight.com.dw.model.AddBlogPostJson;
import org.netlight.com.dw.model.BlogPost;

import com.yammer.dropwizard.jersey.params.LongParam;

@Path("/blog")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BlogResource {

	private BlogPostDao blogPostDao;
	
	public BlogResource(BlogPostDao blogPostDao) {
		this.blogPostDao = blogPostDao;
	}
	
	@GET
    public List<BlogPost> getAllBlogPosts() {
		return blogPostDao.getAll();
    }
	
	@GET
	@Path("/{id}")
    public Response getAllBlogPosts(@PathParam("id") LongParam id) {
		BlogPost result = blogPostDao.get(id.get());
		if(result == null) {
			return Response.status(Status.NOT_FOUND).build();
		} else {
			return Response.ok(result).build();
		}
    }
	
	@POST
    public Response addBlogPost(@Valid AddBlogPostJson addPostJson) {
		blogPostDao.addBlogPost(addPostJson.getTitle(), addPostJson.getText());
		return Response.ok().build();
    }
}
