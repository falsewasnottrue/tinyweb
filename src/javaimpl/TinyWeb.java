package javaimpl;

import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class TinyWeb {

    private final Map<String, Controller> controllers;
    private final List<Filter> filters;

    public TinyWeb(final Map<String, Controller> controllers, final List<Filter> filters) {
        this.controllers = controllers;
        this.filters = filters;
    }

    public HttpResponse handleRequest(final HttpRequest request) {
        HttpRequest currentRequest = request;
        for (Filter filter : filters) {
            currentRequest = filter.doFilter(currentRequest);
        }

        final Controller controller = controllers.get(currentRequest.getPath());

        if (null == controller) {
            return null;
        }

        return controller.handle(currentRequest);
    }
}
