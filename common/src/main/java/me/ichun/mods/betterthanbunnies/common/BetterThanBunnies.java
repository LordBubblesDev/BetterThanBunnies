package me.ichun.mods.betterthanbunnies.common;

import com.mojang.logging.LogUtils;
import me.ichun.mods.betterthanbunnies.common.core.EventHandlerClient;
import com.teamresourceful.resourcefulconfig.api.loader.Configurator;
import org.slf4j.Logger;

public abstract class BetterThanBunnies
{
    public static final String MOD_ID = "betterthanbunnies";
    public static final String MOD_NAME = "Better Than Bunnies";

    public static final Logger LOGGER = LogUtils.getLogger();

    public static BetterThanBunnies modProxy;

    public static final Configurator CONFIGURATOR = new Configurator(MOD_ID);

    public static EventHandlerClient eventHandlerClient;
}
