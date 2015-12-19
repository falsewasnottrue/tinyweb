package javaimpl;

import org.junit.Test;
import static org.junit.Assert.*;

public class HttpResponseTest {

    @Test
    public void testBuild() {
        HttpResponse response = HttpResponse.Builder.newBuilder().
                body("body").responseCode(200).build();

        assertEquals("body", response.getBody());
        assertEquals(Integer.valueOf(200), response.getResponseCode());
    }
}
