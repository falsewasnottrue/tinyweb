package javaimpl;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private final String body;
    private final String path;
    private final Map<String, String> headers;

    public String getBody() {
        return body;
    }

    public String getPath() {
        return path;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    private HttpRequest(final Builder builder) {
        this.body = builder.body;
        this.path = builder.path;
        this.headers = builder.headers;
    }

    public final static class Builder {
        private String body;
        private String path;
        private Map<String, String> headers;

        public Builder body(final String body) {
            this.body = body;
            return this;
        }

        public Builder path(final String path) {
            this.path = path;
            return this;
        }

        public Builder addHeader(final String name, final String value) {
            if (headers == null) {
                this.headers = new HashMap<>();
            }
            headers.put(name, value);
            return this;
        }

        public HttpRequest build() {
            return new HttpRequest(this);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public static Builder builderFrom(final HttpRequest request) {
            Builder builder = new Builder();
            builder.body(request.getBody());
            builder.path(request.getPath());
            Map<String, String> headers = request.getHeaders();

            for (String name : headers.keySet()) {
                builder.addHeader(name, headers.get(name));
            }

            return builder;
        }
    }
}
