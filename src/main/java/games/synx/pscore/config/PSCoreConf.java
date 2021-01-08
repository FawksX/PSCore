package games.synx.pscore.config;

import games.synx.pscore.config.impl.AbstractConfiguration;

import java.io.IOException;
import java.nio.file.Path;

public class PSCoreConf extends AbstractConfiguration<PSCoreSettings> {

    public PSCoreConf(Path configFile) throws IOException {
        super(configFile, PSCoreSettings.class);
    }

}
