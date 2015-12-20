package javaimpl.example;

import javaimpl.RenderingStrategy;

import java.util.List;
import java.util.Map;

public class GreetingRenderingStrategy implements RenderingStrategy {

    @Override
    public String renderView(final Map<String, List<String>> model) {
        final List<String> greetings = model.get("greetings");
        final StringBuffer responseBody = new StringBuffer();

        responseBody.append("<h1>Friendly Greetings:</h1>\n");
        for (final String greeting : greetings) {
            responseBody.append(String.format("<h2>%s</h2>\n", greeting));
        }

        return responseBody.toString();
    }
}
