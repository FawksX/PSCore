package games.synx.pscore.util;

import net.minecraft.entity.player.EntityPlayerMP;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.serializer.TextSerializers;

public class MessageUtil {

    public static void msg(EntityPlayerMP entityPlayerMP, String message) {
        msg(Sponge.getServer().getPlayer(entityPlayerMP.getUniqueID()).get(), message);
    }

    public static void msg(EntityPlayerMP entityPlayerMP, String message, Object ... replacements) {
        msg(Sponge.getServer().getPlayer(entityPlayerMP.getUniqueID()).get(), message, replacements);
    }

    public static void msg(Player player, String message) {
        player.sendMessage(deserialize(message));
    }

    public static void msg(Player player, String message, Object ... replacements) {
        player.sendMessage(deserialize(format(message, replacements)));
    }

    private static Text deserialize(String message) {
        return TextSerializers.FORMATTING_CODE.deserialize(message);
    }

    private static String format(String message, Object ... replacements) {
        return String.format(message, replacements);
    }

}
