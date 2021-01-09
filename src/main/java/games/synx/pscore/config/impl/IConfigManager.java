package games.synx.pscore.config.impl;

import org.slf4j.Logger;

import java.nio.file.Path;

public interface IConfigManager {

    Path getFilePath(String fileName);
    Logger getLogger();
    Object getConf();

}
