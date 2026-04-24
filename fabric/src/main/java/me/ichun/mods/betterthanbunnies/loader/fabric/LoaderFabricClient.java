package me.ichun.mods.betterthanbunnies.loader.fabric;

import me.ichun.mods.betterthanbunnies.common.BetterThanBunnies;
import me.ichun.mods.betterthanbunnies.common.core.Config;
import net.fabricmc.api.ClientModInitializer;

public class LoaderFabricClient extends BetterThanBunnies
    implements ClientModInitializer
{
    @Override
    public void onInitializeClient()
    {
        modProxy = this;

        CONFIGURATOR.register(Config.class);

        //Create event handler
        eventHandlerClient = new EventHandlerClientFabric();
    }
}
