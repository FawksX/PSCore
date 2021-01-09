package games.synx.pscore.command;

import co.aikar.commands.SpongeCommandManager;
import games.synx.pscore.manager.AbstractManager;
import games.synx.pscore.manager.IManager;
import org.slf4j.Logger;
import org.spongepowered.api.plugin.PluginContainer;

public abstract class PSCommandManager extends AbstractManager implements IManager {

    SpongeCommandManager spongeCommandManager;

    public PSCommandManager(Logger logger, PluginContainer pluginContainer) {
        super(logger);
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

}
