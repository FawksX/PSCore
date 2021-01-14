package games.synx.pscore.util;

import games.synx.pscore.PSCore;
import net.minecraft.entity.player.EntityPlayerMP;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.EventContext;
import org.spongepowered.api.event.cause.EventContextKeys;
import org.spongepowered.api.service.economy.EconomyService;
import org.spongepowered.api.service.economy.account.UniqueAccount;
import org.spongepowered.api.service.economy.transaction.TransactionResult;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

/**
 * Utilities Class for EconomyService
 */
public class EconomyUtil {

    /**
     * Gets an instance of the EconomyService provided to Sponge
     * @return EconomyService
     */
    private static EconomyService getEconomyService() {
        Optional<EconomyService> economyServiceOptional = Sponge.getServiceManager().provide(EconomyService.class);
        if (!economyServiceOptional.isPresent()) {
            PSCore.get().getLogger().error("Could not find an EconomyService!");
            return null;
        }
        return economyServiceOptional.get();
    }

    private static Cause getEconomyCause() {
        return Cause.builder().build(EventContext.builder().add(EventContextKeys.PLUGIN, PSCore.get().getPluginContainer()).build());
    }

    /**
     * Gets the Balance of a Player
     * @param player EntityPlayerMP
     * @return BigDecimal Balance
     */
    public static BigDecimal getBalance(EntityPlayerMP player) {
        return getBalance(player.getUniqueID());
    }

    /**
     * Gets the Balance of a Player
     * @param player SpongePlayer
     * @return BigDecimal Balance
     */
    public static BigDecimal getBalance(Player player) {
        return getBalance(player.getUniqueId());
    }

    /**
     * Gets the Balance of a Player
     * @param uuid UUID of Player
     * @return BigDecimal Balance
     */
    public static BigDecimal getBalance(UUID uuid) {
        EconomyService economyService = getEconomyService();
        return getUserAccount(uuid).getBalance(economyService.getDefaultCurrency());
    }

    /**
     * Adds money to a user account
     * @param player player
     * @param amount Amount to add to the user
     */
    public static void addBalance(EntityPlayerMP player, BigDecimal amount) {
        addBalance(player.getUniqueID(), amount);
    }

    /**
     * Adds money to a user account
     * @param player player
     * @param amount Amount to add to the user
     */
    public static void addBalance(Player player, BigDecimal amount) {
        addBalance(player.getUniqueId(), amount);
    }

    /**
     * Adds money to a user account
     * @param uuid UUID of a user
     * @param amount Amount to add to the user
     */
    public static void addBalance(UUID uuid, BigDecimal amount) {
        EconomyService economyService = getEconomyService();
        getUserAccount(uuid).deposit(economyService.getDefaultCurrency(), amount, getEconomyCause());
    }

    /**
     * Take money away from a Users' Balance
     * @param player Player to be deducted
     * @param amount Amount to be deducted
     * @return TransactionResult
     */
    public static TransactionResult withdrawBalance(EntityPlayerMP player, BigDecimal amount) {
        return withdrawBalance(player.getUniqueID(), amount);
    }

    /**
     * Take money away from a Users' Balance
     * @param player Player to be deducted
     * @param amount Amount to be deducted
     * @return TransactionResult
     */
    public static TransactionResult withdrawBalance(Player player, BigDecimal amount) {
        return withdrawBalance(player.getUniqueId(), amount);
    }

    /**
     * Take money away from a Users' Balance
     * @param uuid UUID of player to be deducted
     * @param amount Amount to be deducted
     * @return TransactionResult
     */
    public static TransactionResult withdrawBalance(UUID uuid, BigDecimal amount) {
        return getUserAccount(uuid).withdraw(getEconomyService().getDefaultCurrency(), amount, getEconomyCause());
    }

    /**
     * Gets a users account
     * @param uuid PlayerUUID
     * @return UniqueAccount
     */
    private static UniqueAccount getUserAccount(UUID uuid) {
        return getEconomyService().getOrCreateAccount(uuid).get();
    }


}
