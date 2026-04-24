package me.ichun.mods.betterthanbunnies.client.render;

import net.minecraft.client.renderer.entity.state.RabbitRenderState;

import java.util.IdentityHashMap;

public final class RabbitRenderDataStore
{
    private static final IdentityHashMap<RabbitRenderState, RenderData> RENDER_DATA_BY_STATE = new IdentityHashMap<>();

    private RabbitRenderDataStore()
    {
    }

    public static void putForExtract(RabbitRenderState state, FancyRabbitStyle style, int rabbitId, boolean iChunRabbit, boolean invisible)
    {
        synchronized(RENDER_DATA_BY_STATE)
        {
            RENDER_DATA_BY_STATE.put(state, new RenderData(style, rabbitId, iChunRabbit, invisible));
        }
    }

    public static RenderData peek(RabbitRenderState state)
    {
        synchronized(RENDER_DATA_BY_STATE)
        {
            return RENDER_DATA_BY_STATE.get(state);
        }
    }

    public record RenderData(FancyRabbitStyle style, int rabbitId, boolean iChunRabbit, boolean invisible)
    {
    }
}
