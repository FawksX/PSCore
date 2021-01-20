package games.synx.pscore.modules.impl.manager;

import org.slf4j.Logger;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class AbstractModuleManager implements IModuleManager {

    private final Logger logger;
    private final Path pixelmonSkyblockDir;

    public AbstractModuleManager(Logger logger, Path pixelmonSkyblockDir) {
        this.logger = logger;
        this.pixelmonSkyblockDir = pixelmonSkyblockDir;
    }

    @Override
    public Logger getLogger() {
        return logger;
    }

    @Override
    public Path getModuleFolder(String moduleName) {
        return Paths.get(pixelmonSkyblockDir + File.separator + moduleName);
    }
}
