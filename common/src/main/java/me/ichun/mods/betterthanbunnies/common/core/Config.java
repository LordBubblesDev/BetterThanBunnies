package me.ichun.mods.betterthanbunnies.common.core;

import com.teamresourceful.resourcefulconfig.api.annotations.ConfigInfo;
import me.ichun.mods.betterthanbunnies.common.BetterThanBunnies;

@ConfigInfo(
    title = BetterThanBunnies.MOD_NAME,
    description = "Better Than Bunnies!"
)
@com.teamresourceful.resourcefulconfig.api.annotations.Config(
    value = BetterThanBunnies.MOD_ID,
    categories = ConfigClient.class
)
public final class Config
{
}
