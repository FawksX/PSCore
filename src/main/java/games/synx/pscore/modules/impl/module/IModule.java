package games.synx.pscore.modules.impl.module;

import org.slf4j.Logger;

public interface IModule {

    Logger getLogger();

    void setup();
    void shutdown();
}
