package me.ichun.mods.betterthanbunnies.client.render;

import me.ichun.mods.betterthanbunnies.common.BetterThanBunnies;
import me.ichun.mods.betterthanbunnies.common.core.ConfigClient;
import net.minecraft.world.entity.animal.rabbit.Rabbit;

import java.util.Random;

/**
 * Fancy accessory rolls for a rabbit. Rolled once per frame in {@code RabbitRenderer#extractRenderState} and stored
 * on {@link RabbitRenderDataStore} so {@link BunnyFancyLayer} and tail logic share the same result.
 */
public record FancyRabbitStyle(boolean hat, boolean monocle, boolean pipe, boolean suit)
{
    public static final FancyRabbitStyle NONE = new FancyRabbitStyle(false, false, false, false);

    public boolean any()
    {
        return hat || monocle || pipe || suit;
    }

    public static FancyRabbitStyle roll(Rabbit rabbit)
    {
        String rabbitName = rabbit.hasCustomName() ? rabbit.getName().getString() : "";
        boolean iChunRabbit = "iChun".equals(rabbitName);

        Random rand = new Random();
        if(iChunRabbit)
        {
            rand.setSeed(Math.abs("iChun".hashCode() + (rabbit.getId() * 63268L) * 5642L));
        }
        else
        {
            rand.setSeed(Math.abs((rabbitName.isEmpty() ? rabbit.getUUID().hashCode() : rabbitName.hashCode()) * 5642L));
        }

        if(!(iChunRabbit || rand.nextFloat() < (ConfigClient.fancyChance / 100F)))
        {
            return NONE;
        }

        if(iChunRabbit)
        {
            return new FancyRabbitStyle(
                rand.nextBoolean(),
                rand.nextBoolean(),
                rand.nextBoolean(),
                rand.nextBoolean()
            );
        }
        return new FancyRabbitStyle(
            rand.nextFloat() < ConfigClient.hatChance / 100F,
            rand.nextFloat() < ConfigClient.monocleChance / 100F,
            rand.nextFloat() < ConfigClient.pipeChance / 100F,
            rand.nextFloat() < ConfigClient.suitChance / 100F
        );
    }
}
