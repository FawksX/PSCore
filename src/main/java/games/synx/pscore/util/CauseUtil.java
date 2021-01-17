package games.synx.pscore.util;

import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.EventContext;
import org.spongepowered.api.event.cause.EventContextKeys;
import org.spongepowered.api.plugin.PluginContainer;

public class CauseUtil {

    public static Cause getCause(PluginContainer pluginContainer) {
        return Cause.builder().append(pluginContainer).build(EventContext.builder().add(EventContextKeys.PLUGIN, pluginContainer).build());
    }

}
