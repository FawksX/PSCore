package games.synx.pscore.config.impl;

import org.slf4j.Logger;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class AbstractConfigManager implements IConfigManager {

    private Logger logger;
    private Path configDir;

    public AbstractConfigManager(Logger logger, Path configDir) {
        this.logger = logger;
        this.configDir = configDir;

        logger.info("Initialising Config Manager");
    }

    public Path getFilePath(String fileName) {
        return Paths.get(configDir + File.separator + fileName);
    }

    public Logger getLogger() {
        return this.logger;
    }

}
