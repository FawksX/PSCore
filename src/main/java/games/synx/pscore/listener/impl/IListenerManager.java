package games.synx.pscore.listener.impl;

public interface IListenerManager {

    void registerPixelmonEvent(Object T);
    void registerForgeEvent(Object T);
    void registerSpongeEvent(Object T);

}
