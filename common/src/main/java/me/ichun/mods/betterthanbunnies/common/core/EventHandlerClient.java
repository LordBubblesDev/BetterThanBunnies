package me.ichun.mods.betterthanbunnies.common.core;

import me.ichun.mods.betterthanbunnies.client.render.BunnyFancyLayer;
import me.ichun.mods.betterthanbunnies.mixin.client.LivingEntityRendererAccessorMixin;
import net.minecraft.client.model.animal.rabbit.RabbitModel;
import net.minecraft.client.renderer.entity.RabbitRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.RabbitRenderState;
import net.minecraft.world.entity.animal.rabbit.Rabbit;

public abstract class EventHandlerClient
{
    @SuppressWarnings("unchecked")
    public void addFancyLayer(RabbitRenderer rabbitRenderer)
    {
        boolean hasLayer = false;
        for(RenderLayer<RabbitRenderState, RabbitModel> layer : ((LivingEntityRendererAccessorMixin<Rabbit, RabbitRenderState, RabbitModel>)rabbitRenderer).getLayers())
        {
            if(layer instanceof BunnyFancyLayer)
            {
                hasLayer = true;
                break;
            }
        }

        if(!hasLayer)
        {
            ((LivingEntityRendererAccessorMixin<Rabbit, RabbitRenderState, RabbitModel>)rabbitRenderer).invokeAddLayer(new BunnyFancyLayer(rabbitRenderer));
        }
    }
}
