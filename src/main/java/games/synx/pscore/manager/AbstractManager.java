package games.synx.pscore.manager;

import org.slf4j.Logger;

public class AbstractManager implements IManager {

    private final Logger logger;

    public AbstractManager(Logger logger) {
        this.logger = logger;
        logger.info("Registering " + getClass().getName());
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }
}
