package games.synx.pscore.command;

import co.aikar.commands.BaseCommand;
import games.synx.pscore.util.MessageUtil;
import org.slf4j.Logger;
import org.spongepowered.api.entity.living.player.Player;

public class AbstractPSCommand extends BaseCommand {

    private final Logger logger;

    public AbstractPSCommand(Logger logger) {
        this.logger = logger;
    }

    public void msg(Player player, String message) {
        MessageUtil.msg(player, message);
    }

    public void formatMsg(Player player, String message, Object ... replacements) {
        MessageUtil.msg(player, message, replacements);
    }

    public Logger getLogger() {
        return this.logger;
    }

}
