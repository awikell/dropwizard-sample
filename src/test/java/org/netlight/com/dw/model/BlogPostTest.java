package org.netlight.com.dw.model;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import static com.yammer.dropwizard.testing.JsonHelpers.*;
import static org.junit.Assert.assertEquals;

public class BlogPostTest {

    @Test
    public void serializeToJSON() throws Exception {
        final BlogPost blogPost = new BlogPost(4711L, "Test Post Title", "Some text", new DateTime(1392561096938L));
        Assert.assertEquals(jsonFixture("blogpost.json"), asJson(blogPost));
    }

    @Test
    public void deserializeFromJSON() throws Exception {
        final BlogPost blogPost = new BlogPost(4711L, "Test Post Title", "Some text", new DateTime(1392561096938L));
        assertPostsAreEqual(blogPost, fromJson(jsonFixture("blogpost.json"), BlogPost.class));
    }

    public static void assertPostsAreEqual(BlogPost expected, BlogPost actual) {
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getTitle(), actual.getTitle());
        assertEquals(expected.getText(), actual.getText());
        assertEquals(expected.getCreatedDate().getMillis(), actual.getCreatedDate().getMillis());
    }

}
