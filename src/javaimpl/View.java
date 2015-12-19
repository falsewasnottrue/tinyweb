package javaimpl;

import java.util.List;
import java.util.Map;

public interface View {
    String render(final Map<String, List<String>> model);
}
