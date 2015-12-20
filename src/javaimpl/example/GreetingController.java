package javaimpl.example;

import javaimpl.HttpRequest;
import javaimpl.TemplateController;
import javaimpl.View;

import java.util.*;

public class GreetingController extends TemplateController {

    private Random random;

    public GreetingController(final View view) {
        super(view);
        random = new Random();
    }

    @Override
    public Map<String, List<String>> doRequest(final HttpRequest request) {
        final Map<String, List<String>> model = new HashMap<>();
        model.put("greetings", generateGreetings(request.getBody()));
        return model;
    }

    private List<String> generateGreetings(final String namesCommaSeperated) {
        final String[] names = namesCommaSeperated.split(",");
        final List<String> greetings = new ArrayList<>();
        for (final String name : names) {
            greetings.add(makeGreeting(name));
        }
        return greetings;
    }

    private String makeGreeting(final String name) {
        final String[] greetings = { "Hello", "Greetings", "Salutations", "Hola" };
        final String greetingPrefix = greetings[random.nextInt(4)];

        return String.format("%s, %s", greetingPrefix, name);
    }
}
