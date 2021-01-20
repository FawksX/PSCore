package games.synx.pscore.listener.gameplay;

import net.minecraft.init.Items;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AntiEnderpearlListener {

    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onEnderpearlThrow(PlayerInteractEvent.RightClickItem event) {
        event.setCanceled(event.getItemStack().getItem() == Items.ENDER_PEARL);
    }

}
