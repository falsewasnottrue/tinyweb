package javaimpl;

import java.util.List;
import java.util.Map;

public class StrategyView implements View {

    private final RenderingStrategy renderingStrategy;

    public StrategyView(final RenderingStrategy renderingStrategy) {
        this.renderingStrategy = renderingStrategy;
    }

    @Override
    public String render(Map<String, List<String>> model) {
        try {
            return renderingStrategy.renderView(model);
        } catch (final Exception e) {
            throw new RenderingException(e);
        }
    }
}
