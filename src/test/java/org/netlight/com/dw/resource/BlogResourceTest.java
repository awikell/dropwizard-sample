package org.netlight.com.dw.resource;

import com.yammer.dropwizard.jersey.params.LongParam;
import com.yammer.dropwizard.testing.ResourceTest;
import org.joda.time.DateTime;
import org.junit.Test;
import org.netlight.com.dw.dao.BlogPostDao;
import org.netlight.com.dw.model.BlogPost;
import org.netlight.com.dw.model.BlogPostTest;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BlogResourceTest extends ResourceTest{


    private static final int POST_ID = 4711;
    private final BlogPostDao blogPostDao = mock(BlogPostDao.class);
    private final BlogPost blogPost = new BlogPost(POST_ID, "Hello World", "Let's open up a Unicorn farm!", new DateTime());

    @Override
    protected void setUpResources() throws Exception {
        when(blogPostDao.get(POST_ID)).thenReturn(blogPost);
        addResource(new BlogResource(blogPostDao));
    }

    @Test
    public void testGetBlogPosts() throws Exception {
        BlogPost post = client().resource("/blog/" + POST_ID).get(BlogPost.class);

        verify(blogPostDao).get(POST_ID);
        BlogPostTest.assertPostsAreEqual(blogPost, post);
    }

    @Test
    public void testGetBlogPostNotFound() throws Exception {
        BlogResource resource = new BlogResource(blogPostDao);

        Response response = resource.getBlogPost(new LongParam("1337"));
        assertEquals(404, response.getStatus());
    }
}

