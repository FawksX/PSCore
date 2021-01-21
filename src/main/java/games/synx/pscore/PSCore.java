package games.synx.pscore;

import com.google.inject.Inject;
import games.synx.pscore.config.ConfigManager;
import games.synx.pscore.listener.PSListenerManager;
import games.synx.pscore.modules.impl.PSModuleManager;
import org.slf4j.Logger;
import org.spongepowered.api.event.game.state.GameAboutToStartServerEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStoppingServerEvent;
import org.spongepowered.api.plugin.Dependency;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;

import java.nio.file.Path;
import java.nio.file.Paths;

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

    private static Path pixelmonSBDir;

    private static ConfigManager configManager;
    private static PSModuleManager moduleManager;

    @Inject
    private Logger logger;

    @Inject
    private PluginContainer pluginContainer;

    @Listener
    public void onAboutToStart(GameAboutToStartServerEvent event) {
        instance = this;

        pixelmonSBDir = Paths.get("PixelmonSkyblock");

        if (!pixelmonSBDir.toFile().exists()) {
            pixelmonSBDir.toFile().mkdir();
        }

        configManager = new ConfigManager();
        moduleManager = new PSModuleManager(logger, pixelmonSBDir);



    }

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        new PSListenerManager();
        moduleManager.registerModules();
    }

    @Listener
    public void onServerClose(GameStoppingServerEvent event) {
        moduleManager.onServerClose();
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

    public static Path getPixelmonSkyblockDir() {
        return pixelmonSBDir;
    }


}
