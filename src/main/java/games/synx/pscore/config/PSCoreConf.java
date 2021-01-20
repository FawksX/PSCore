package games.synx.pscore.config;

import games.synx.pscore.config.impl.AbstractConfiguration;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;
import org.spongepowered.configurate.objectmapping.meta.Setting;

import java.io.IOException;
import java.nio.file.Path;

public class PSCoreConf extends AbstractConfiguration<PSCoreConf.PSCoreSettings> {

    public PSCoreConf(Path configFile) throws IOException {
        super(configFile, PSCoreSettings.class);
    }

    @ConfigSerializable
    public static class PSCoreSettings {

        @Setting
        public String server = "Lightning";

    }

}
