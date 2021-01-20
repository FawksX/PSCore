package games.synx.pscore.listener.gameplay;

import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.cause.entity.damage.DamageTypes;
import org.spongepowered.api.event.cause.entity.damage.source.DamageSource;
import org.spongepowered.api.event.entity.DamageEntityEvent;
import org.spongepowered.api.event.filter.cause.Root;

public class AntiFallDamageListener {

    /**
     * Prevents Users from Taking Damage on PixelmonSkyblock
     * @param event
     * @param dmgSrc
     */
    @Listener
    public void onItemDrop(DamageEntityEvent event, @Root DamageSource dmgSrc) {
        if(dmgSrc.getType().equals(DamageTypes.FALL)) {
            event.setCancelled(true);
        }
    }

}
