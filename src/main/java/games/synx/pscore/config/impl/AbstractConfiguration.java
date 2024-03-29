package games.synx.pscore.config.impl;

import games.synx.pscore.PSCore;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.spongepowered.configurate.ConfigurateException;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.gson.GsonConfigurationLoader;
import org.spongepowered.configurate.objectmapping.ObjectMapper;
import org.spongepowered.configurate.serialize.SerializationException;

import java.io.IOException;
import java.nio.file.Path;

public abstract class AbstractConfiguration<T> implements IConfiguration {

    private Class<T> clazz;

    private final ConfigurationNode node;
    private final GsonConfigurationLoader loader;
    private final Path configFile;

    private final ObjectMapper<T> MAPPER;

    private T settings;

    // ----------------------------------------------- //
    // SUPERCLASSES
    // ----------------------------------------------- //

    public AbstractConfiguration(Path configFile, Class<T> clazz) throws IOException {
        this.clazz = clazz;
        this.configFile = configFile;

        loader = GsonConfigurationLoader.builder().path(configFile).build();

        this.node = loader.load();

        MAPPER = ObjectMapper.factory().get(clazz);

        setup();

    }

    public void saveConfiguration(final Object configuration, final ConfigurationNode node) throws SerializationException {
        MAPPER.save((T) configuration, node);
    }

    public @NonNull Object loadConfiguration(ObjectMapper<?> objectMapper, final ConfigurationNode node) throws ConfigurateException {
        return objectMapper.load(node);
    }

    public void setup() {
        try {
            // loading

            this.settings = (T) loadConfiguration(MAPPER, getRawNode());

            // saving
            saveConfiguration(this.settings, getRawNode());
            saveRawNode();

        } catch (ConfigurateException e) {
            e.printStackTrace();
        }
    }


    // ----------------------------------------------- //
    // GETTERS
    // ----------------------------------------------- //

    public ConfigurationNode getRawNode() {
        return this.node;
    }

    public GsonConfigurationLoader getLoader() {
        return this.loader;
    }

    public void saveRawNode() {
        try {
            getLoader().save(getRawNode());
        } catch (IOException e) {
            PSCore.get().getLogger().error("Could not save configuration file!");
        }
    }

    public Path getConfigFile() {
        return this.configFile;
    }

    public T getSettings() {
        return this.settings;
    }

}