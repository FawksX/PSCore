package games.synx.pscore.util;

import games.synx.pscore.PSCore;
import org.spongepowered.api.Sponge;

public class AsyncUtil {

    public static void async(Runnable run) {
        Sponge.getScheduler().createTaskBuilder().async().execute(run).submit(PSCore.get());
    }

}
