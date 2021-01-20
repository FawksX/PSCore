package games.synx.pscore.modules.broadcast;

import games.synx.pscore.config.impl.AbstractConfiguration;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;

import java.io.IOException;
import java.nio.file.Path;

public class BroadcastConfiguration extends AbstractConfiguration<BroadcastConfiguration.BroadcastConf> {

    public BroadcastConfiguration(Path configFile) throws IOException {
        super(configFile, BroadcastConf.class);
    }

    @ConfigSerializable
    public static class BroadcastConf {

    }

}
