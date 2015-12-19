package javaimpl;

import org.junit.*;
import static org.junit.Assert.*;

public class HttpRequestTest {

    @Test
    public void testBuilder() throws Exception {
        HttpRequest request = HttpRequest.Builder.newBuilder().
                body("body").path("path").
                addHeader("name1", "value1").
                addHeader("name2", "value2").
                build();

        assertEquals("body", request.getBody());
        assertEquals("path", request.getPath());
        assertEquals("value1", request.getHeaders().get("name1"));
        assertEquals("value2", request.getHeaders().get("name2"));
    }

    @Test
    public void testBuilderFrom() throws Exception {
        HttpRequest request = HttpRequest.Builder.newBuilder().
                body("body").path("path").
                addHeader("name1", "value1").
                addHeader("name2", "value2").
                build();

        HttpRequest request2 = HttpRequest.Builder.builderFrom(request).
                body("body2").build();

        assertEquals("body2", request2.getBody());
        assertEquals("path", request2.getPath());
        assertEquals("value1", request2.getHeaders().get("name1"));
        assertEquals("value2", request2.getHeaders().get("name2"));
    }
}
