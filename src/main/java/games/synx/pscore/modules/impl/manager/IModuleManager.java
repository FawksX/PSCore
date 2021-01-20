package games.synx.pscore.modules.impl.manager;

import org.slf4j.Logger;

import java.nio.file.Path;

public interface IModuleManager {

    Logger getLogger();

    void registerModules();

    void onServerClose();

    Path getModuleFolder(String moduleName);

}
