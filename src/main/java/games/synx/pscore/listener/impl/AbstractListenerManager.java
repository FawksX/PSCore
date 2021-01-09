package games.synx.pscore.listener.impl;

import com.pixelmonmod.pixelmon.Pixelmon;
import games.synx.pscore.manager.AbstractManager;
import games.synx.pscore.manager.IManager;
import net.minecraftforge.common.MinecraftForge;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.plugin.PluginContainer;

public class AbstractListenerManager extends AbstractManager implements IManager, IListenerManager {

    private final PluginContainer pluginContainer;

    public AbstractListenerManager(Logger logger, PluginContainer pluginContainer) {
        super(logger);
        logger.info("Registering Listener Manager");
        this.pluginContainer = pluginContainer;
    }

    @Override
    public void registerPixelmonEvent(Object T) {
        registerForgeEvent(T);
        Pixelmon.EVENT_BUS.register(T);
    }

    @Override
    public void registerForgeEvent(Object T) {
        MinecraftForge.EVENT_BUS.register(T);
    }

    @Override
    public void registerSpongeEvent(Object T) {
        Sponge.getEventManager().registerListeners(pluginContainer, T);
    }

}
