package games.synx.pscore.config;

import games.synx.pscore.PSCore;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigManager {

    private Path pixelmonskyblockDir;
    private Path psCoreDir;
    private PSCoreConf psCoreConf;

    public ConfigManager() {
        PSCore.get().getLogger().info("Initialising ConfigManager");
        setupConfigDirectories();

        try {
            psCoreConf = new PSCoreConf(Paths.get(psCoreDir + "config.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void setupConfigDirectories() {
        this.pixelmonskyblockDir = Paths.get("PixelmonSkyblock");

        if (!this.pixelmonskyblockDir.toFile().exists()) {
            this.pixelmonskyblockDir.toFile().mkdir();
        }

        this.psCoreDir = setupDirectory("PSCore");

    }

    public Path setupDirectory(String directoryName) {
        PSCore.get().getLogger().info("Creating directory " + directoryName);

        Path directory = Paths.get(pixelmonskyblockDir + File.separator + directoryName);

        if (!directory.toFile().exists()) {
            directory.toFile().mkdir();
        }

        return directory;
    }

    public PSCoreSettings getPSCoreSettings() {
        return this.psCoreConf.getSettings();
    }

}
