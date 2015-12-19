package javaimpl;

import java.util.List;
import java.util.Map;

public abstract class TemplateController implements Controller {

    private final View view;

    public TemplateController(final View view) {
        this.view = view;
    }

    @Override
    public HttpResponse handle(final HttpRequest request) {
        Integer responseCode = 200;
        String body = "";

        try {
            Map<String, List<String>> model = doRequest(request);
            body = view.render(model);
        } catch (final ControllerException e) {
            responseCode = e.getResponseCode();
        } catch (final RenderingException e) {
            responseCode = 500;
            body = "Error while rendering";
        } catch (final Exception e) {
            responseCode = 500;
        }

        return HttpResponse.Builder.newBuilder().
                body(body).responseCode(responseCode).build();
    }

    public abstract Map<String, List<String>> doRequest(final HttpRequest request);
}
