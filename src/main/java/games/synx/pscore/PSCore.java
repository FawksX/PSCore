package games.synx.pscore;

import com.google.inject.Inject;
import games.synx.pscore.config.ConfigManager;
import org.slf4j.Logger;
import org.spongepowered.api.event.game.state.GameAboutToStartServerEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.plugin.Dependency;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;

@Plugin(
        id = PSCoreInfo.ID,
        name = PSCoreInfo.NAME,
        authors = PSCoreInfo.AUTHORS,
        version = PSCoreInfo.VERSION,
        description = PSCoreInfo.DESCRIPTION,
        dependencies = {
                @Dependency(id="nucleus")
        })
public class PSCore {

    private static PSCore instance;

    private static ConfigManager configManager;

    @Inject
    private Logger logger;

    @Inject
    private PluginContainer pluginContainer;

    @Listener
    public void onAboutToStart(GameAboutToStartServerEvent event) {
        instance = this;

        configManager = new ConfigManager();
    }

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
    }


    // ----------------------------------------------- //
    // GETTERS AND SETTERS
    // ----------------------------------------------- //

    public static PSCore get() {
        return instance;
    }

    public Logger getLogger() {
        return logger;
    }

    public PluginContainer getPluginContainer() {
        return this.pluginContainer;
    }

    public static ConfigManager getConfigManager() {
        return configManager;
    }


}
