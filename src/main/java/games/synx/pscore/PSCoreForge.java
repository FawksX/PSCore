package games.synx.pscore;

import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(
        modid = PSCoreInfo.ID + "forge",
        name = PSCoreInfo.NAME + "forge",
        version = PSCoreInfo.VERSION,
        acceptableRemoteVersions = "*")
public class PSCoreForge {

    private static MinecraftServer server;
    private static PSCoreForge instance;

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        instance = this;
    }

    @Mod.EventHandler
    public void onServerStarting(FMLServerStartingEvent event) {
        server = event.getServer();
    }

    public static PSCoreForge get() {
        return instance;
    }

    public static MinecraftServer getServer() {
        return server;
    }
}
