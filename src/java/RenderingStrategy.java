package java;

import java.util.List;
import java.util.Map;

public interface RenderingStrategy {
    String renderView(final Map<String, List<String>> model);
}
