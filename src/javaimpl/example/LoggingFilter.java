package javaimpl.example;

import javaimpl.Filter;
import javaimpl.HttpRequest;

public class LoggingFilter implements Filter {

    @Override
    public HttpRequest doFilter(final HttpRequest request) {
        System.out.println("In Logging Filter - request for path: " + request.getPath());

        return request;
    }
}
