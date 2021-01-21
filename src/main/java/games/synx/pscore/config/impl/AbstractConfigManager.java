package games.synx.pscore.config.impl;

import games.synx.pscore.manager.AbstractManager;
import games.synx.pscore.manager.IManager;
import org.slf4j.Logger;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class AbstractConfigManager extends AbstractManager implements IManager, IConfigManager {

    private Path dir;

    public AbstractConfigManager(Logger logger, Path dir) {
        super(logger);
        this.dir = dir;

    }

    public AbstractConfigManager(Logger logger) {
        super(logger);
    }

    public Path getFilePath(String fileName) {
        return Paths.get(dir + File.separator + fileName);
    }

    public Path getGUIPath(String fileName) {
        return Paths.get(dir + File.separator + "gui" + File.separator + fileName);
    }

}
