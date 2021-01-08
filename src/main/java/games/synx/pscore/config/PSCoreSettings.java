package games.synx.pscore.config;

import org.spongepowered.configurate.objectmapping.ConfigSerializable;
import org.spongepowered.configurate.objectmapping.meta.Setting;

@ConfigSerializable
public class PSCoreSettings {

    @Setting
    public String server = "Lightning";

}
