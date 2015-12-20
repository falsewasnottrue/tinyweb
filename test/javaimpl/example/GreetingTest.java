package javaimpl.example;

import javaimpl.*;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GreetingTest {

    @Test
    public void testAll() {
        final Map<String, Controller> controllers = new HashMap<>();
        controllers.put("greetings/", new GreetingController(new StrategyView(new GreetingRenderingStrategy())));

        final List<Filter> filters = new ArrayList<>();
        filters.add(new LoggingFilter());

        final TinyWeb tw = new TinyWeb(controllers, filters);

        final HttpRequest request = HttpRequest.Builder.newBuilder().
                body("Mike,Joe,John,Steve").path("greetings/").build();

        final HttpResponse response = tw.handleRequest(request);
        System.out.println(response.getBody());

        assertEquals(Integer.valueOf(200), response.getResponseCode());
    }
}
