package games.synx.pscore.config.impl;

import games.synx.pscore.manager.AbstractManager;
import games.synx.pscore.manager.IManager;
import org.slf4j.Logger;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class AbstractConfigManager extends AbstractManager implements IManager, IConfigManager {

    private Path configDir;

    public AbstractConfigManager(Logger logger, Path configDir) {
        super(logger);
        this.configDir = configDir;

        logger.info("Initialising Config Manager");
    }

    public Path getFilePath(String fileName) {
        return Paths.get(configDir + File.separator + fileName);
    }

    public Path getGUIPath(String fileName) {
        return Paths.get(configDir + File.separator + "gui" + File.separator + fileName);
    }

}
