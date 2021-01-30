package games.synx.pscore.command;

import co.aikar.commands.MessageType;
import co.aikar.commands.SpongeCommandManager;
import co.aikar.commands.apachecommonslang.ApacheCommonsLangUtil;
import com.google.common.collect.Lists;
import games.synx.pscore.manager.AbstractManager;
import games.synx.pscore.manager.IManager;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.text.format.TextColors;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public abstract class PSCommandManager extends AbstractManager implements IManager {

    SpongeCommandManager spongeCommandManager;

    public PSCommandManager(Logger logger, PluginContainer pluginContainer) {
        super(logger);
        logger.info("Registering CommandManager for " + pluginContainer.getName());

        spongeCommandManager = new SpongeCommandManager(pluginContainer);

        registerCompletions();

        registerPlayerCommands();
        registerAdminCommands();

        registerFormats();


    }

    public abstract void registerPlayerCommands();
    public abstract void registerAdminCommands();

    public SpongeCommandManager getCommandManager() {
        return this.spongeCommandManager;
    }

    public void registerFormats() {
        getCommandManager().setFormat(MessageType.HELP, TextColors.DARK_GREEN, TextColors.GRAY, TextColors.DARK_GRAY, TextColors.AQUA, TextColors.YELLOW, TextColors.DARK_AQUA);
        getCommandManager().getLocales().addMessageBundle("acf-pscore_en.properties", Locale.ENGLISH);
    }

    public void registerCompletions() {

        getCommandManager().getCommandCompletions().registerCompletion("spongeplayers", p -> {
            List<String> igns = Lists.newArrayList();
            for (Player player : Sponge.getServer().getOnlinePlayers()) {
                String name = player.getName();
                if (ApacheCommonsLangUtil.startsWithIgnoreCase(name, p.getInput())) {
                    igns.add(player.getName());
                }
            }
            igns.sort(String.CASE_INSENSITIVE_ORDER);
            return igns;
        });

    }

}
