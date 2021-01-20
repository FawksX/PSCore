package games.synx.pscore.listener;

import games.synx.pscore.PSCore;
import games.synx.pscore.listener.gameplay.AntiEnderpearlListener;
import games.synx.pscore.listener.gameplay.AntiFallDamageListener;
import games.synx.pscore.listener.impl.AbstractListenerManager;
import games.synx.pscore.listener.impl.IListenerManager;
import games.synx.pscore.manager.IManager;

public class PSListenerManager extends AbstractListenerManager implements IListenerManager, IManager {

    public PSListenerManager() {
        super(PSCore.get().getLogger(), PSCore.get().getPluginContainer());

        registerSpongeEvent(new AntiFallDamageListener());

        registerForgeEvent(new AntiEnderpearlListener());
    }
}
