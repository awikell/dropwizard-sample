//package org.netlight.com.dw.resource;
//
//import com.yammer.dropwizard.testing.ResourceTest;
//import org.junit.Test;
//import org.netlight.com.dw.dao.BlogPostDao;
//
//import javax.ws.rs.core.Response;
//
//import static org.junit.Assert.assertEquals;
//
//public class BlogResourceTest extends ResourceTest{
//
//
//    @Override
//    protected void setUpResources() throws Exception {
//        addResource(new BlogResource(new BlogPostDao()));
//    }
//
//    @Test
//    public void testGetAllBlogPosts() throws Exception {
//        Response response = client().resource("/blog").get(Response.class);
//
//        assertEquals(200, response.getStatus());
//    }
//}
//
