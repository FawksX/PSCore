package games.synx.pscore.modules.broadcast;

import games.synx.pscore.modules.impl.module.AbstractModule;
import games.synx.pscore.modules.impl.module.IModule;
import org.slf4j.Logger;

import java.io.IOException;
import java.nio.file.Path;

public class BroadcastModule extends AbstractModule implements IModule {

    private BroadcastConfiguration conf;

    public BroadcastModule(Logger logger, Path dir) {
        super(logger, dir);

        try {
            conf = new BroadcastConfiguration(getFilePath("config.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public BroadcastConfiguration.BroadcastConf getConf() {
        return conf.getSettings();
    }

    @Override
    public void setup() {

    }

    @Override
    public void shutdown() {

    }
}
