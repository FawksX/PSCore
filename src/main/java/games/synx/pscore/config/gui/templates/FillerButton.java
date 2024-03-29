package games.synx.pscore.config.gui.templates;

import ca.landonjw.gooeylibs.inventory.api.Button;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;
import org.spongepowered.configurate.objectmapping.meta.Setting;

@ConfigSerializable
public class FillerButton {

    @Setting
    public String item = "minecraft:stained_glass_pane";

    @Setting
    public int damage = 15;

    @Setting
    public String displayName = "§7";

    public ItemStack getItemStack() {
        return new ItemStack(Item.getByNameOrId(item), 1, damage);
    }

    public Button getFillerButton() {
        return Button.builder().item(getItemStack()).displayName(displayName).build();
    }

}