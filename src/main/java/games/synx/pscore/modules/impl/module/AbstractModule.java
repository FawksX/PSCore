package games.synx.pscore.modules.impl.module;

import games.synx.pscore.config.impl.AbstractConfigManager;
import org.slf4j.Logger;

import java.nio.file.Path;

public abstract class AbstractModule extends AbstractConfigManager implements IModule {

    public AbstractModule(Logger logger, Path dir) {
        super(logger, dir);

    }

}
