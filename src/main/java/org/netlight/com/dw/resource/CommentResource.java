package org.netlight.com.dw.resource;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.netlight.com.dw.dao.CommentDao;
import org.netlight.com.dw.model.AddCommentJson;

import com.yammer.dropwizard.jersey.params.LongParam;

@Path("/comment")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {

	private CommentDao commentDao;
	
	public CommentResource(CommentDao commentDao) {
		this.commentDao = commentDao;
	}
		
	@DELETE
	@Path("/{id}")
    public Response deleteComment(@PathParam("id") LongParam id) {
		if(commentDao.deleteComment(id.get())) {
			return Response.status(Status.OK).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
    }
	
	@POST
	@Path("/{blogId}")
    public Response addComment(@PathParam("blogId") LongParam blogId, @Valid AddCommentJson addCommentJson) {
		commentDao.addComment(addCommentJson.getComment(), addCommentJson.getAuthor(), blogId.get());
		return Response.ok().build();
    }
}
