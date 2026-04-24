package me.ichun.mods.betterthanbunnies.loader.neoforge;

import com.teamresourceful.resourcefulconfig.api.client.ResourcefulConfigScreen;
import me.ichun.mods.betterthanbunnies.common.BetterThanBunnies;
import me.ichun.mods.betterthanbunnies.common.core.Config;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

import java.util.function.Supplier;

@Mod(value = BetterThanBunnies.MOD_ID, dist = Dist.CLIENT)
public class LoaderNeoForge extends BetterThanBunnies
{
    public LoaderNeoForge(IEventBus modEventBus, ModContainer container)
    {
        modProxy = this;
        initClient(modEventBus, container);
    }

    @OnlyIn(Dist.CLIENT)
    private void initClient(IEventBus modEventBus, ModContainer container)
    {
        CONFIGURATOR.register(Config.class);

        eventHandlerClient = new EventHandlerClientNeoForge(modEventBus);

        container.registerExtensionPoint(
            IConfigScreenFactory.class,
            (Supplier<IConfigScreenFactory>)() -> (modContainer, screen) -> ResourcefulConfigScreen.getFactory(MOD_ID).apply(screen)
        );
    }
}
