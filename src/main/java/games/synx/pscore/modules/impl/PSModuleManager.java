package games.synx.pscore.modules.impl;

import com.google.common.collect.Sets;
import games.synx.pscore.modules.broadcast.BroadcastModule;
import games.synx.pscore.modules.impl.manager.AbstractModuleManager;
import games.synx.pscore.modules.impl.manager.IModuleManager;
import games.synx.pscore.modules.impl.module.IModule;
import org.slf4j.Logger;

import java.nio.file.Path;
import java.util.Set;

public class PSModuleManager extends AbstractModuleManager implements IModuleManager {

    private final Set<IModule> modules = Sets.newHashSet();

    public PSModuleManager(Logger logger, Path pixelmonSkyblockDir) {
        super(logger, pixelmonSkyblockDir);
    }

    @Override
    public void registerModules() {
        modules.add(new BroadcastModule(getLogger(), getModuleFolder("broadcast")));


        for(IModule module : modules) {
            module.setup();
        }

    }

    @Override
    public void onServerClose() {

        for(IModule module : modules) {
            module.shutdown();
        }

    }
}
