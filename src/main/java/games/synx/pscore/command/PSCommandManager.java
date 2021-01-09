package games.synx.pscore.command;

import co.aikar.commands.SpongeCommandManager;
import org.slf4j.Logger;
import org.spongepowered.api.plugin.PluginContainer;

public abstract class PSCommandManager {

    private Logger logger;
    SpongeCommandManager spongeCommandManager;

    public PSCommandManager(Logger logger, PluginContainer pluginContainer) {
        this.logger = logger;
        logger.info("Registering CommandManager for " + pluginContainer.getName());

        spongeCommandManager = new SpongeCommandManager(pluginContainer);

        registerPlayerCommands();
        registerAdminCommands();

    }

    public abstract void registerPlayerCommands();
    public abstract void registerAdminCommands();

    public SpongeCommandManager getCommandManager() {
        return this.spongeCommandManager;
    }

    public Logger getLogger() {
        return this.logger;
    }

}
