package me.ichun.mods.betterthanbunnies.loader.fabric;

import com.teamresourceful.resourcefulconfig.api.client.ResourcefulConfigScreen;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.ichun.mods.betterthanbunnies.common.BetterThanBunnies;

public class BetterThanBunniesModMenu implements ModMenuApi
{
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory()
    {
        return parent -> ResourcefulConfigScreen.getFactory(BetterThanBunnies.MOD_ID).apply(parent);
    }
}
