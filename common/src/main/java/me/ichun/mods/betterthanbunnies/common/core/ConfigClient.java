package me.ichun.mods.betterthanbunnies.common.core;

import com.teamresourceful.resourcefulconfig.api.annotations.Category;
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigEntry;
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigOption;

@Category("client")
public final class ConfigClient
{
    @ConfigEntry(id = "fancy_chance", translation = "config.betterthanbunnies.fancy_chance")
    @ConfigOption.Range(min = 0, max = 100)
    public static int fancyChance = 80;

    @ConfigEntry(id = "hat_chance", translation = "config.betterthanbunnies.hat_chance")
    @ConfigOption.Range(min = 0, max = 100)
    public static int hatChance = 50;

    @ConfigEntry(id = "monocle_chance", translation = "config.betterthanbunnies.monocle_chance")
    @ConfigOption.Range(min = 0, max = 100)
    public static int monocleChance = 50;

    @ConfigEntry(id = "pipe_chance", translation = "config.betterthanbunnies.pipe_chance")
    @ConfigOption.Range(min = 0, max = 100)
    public static int pipeChance = 50;

    @ConfigEntry(id = "suit_chance", translation = "config.betterthanbunnies.suit_chance")
    @ConfigOption.Range(min = 0, max = 100)
    public static int suitChance = 50;
}
