package games.synx.pscore.util;

import games.synx.pscore.PSCoreForge;
import net.minecraft.entity.player.EntityPlayerMP;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.service.user.UserStorageService;

import java.util.Optional;
import java.util.UUID;

public class PlayerUtil {

    public static UUID getOfflineSpongeUserUUID(String user) {
        return getOfflineSpongeUser(user).getUniqueId();
    }

    public static User getOfflineSpongeUser(String user) {
        Optional<UserStorageService> userStorage = Sponge.getServiceManager().provide(UserStorageService.class);
        User offlinePlayer = userStorage.get().get(user).get();
        return offlinePlayer;
    }

    public static Player getOnlineSpongePlayer(UUID uuid) {
        return Sponge.getServer().getPlayer(uuid).get();
    }

    public static EntityPlayerMP getForgePlayer(UUID uuid) {
        return PSCoreForge.getServer().getPlayerList().getPlayerByUUID(uuid);
    }

}
