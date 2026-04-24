package me.ichun.mods.betterthanbunnies.mixin.client;

import me.ichun.mods.betterthanbunnies.client.model.BunnyFancyModel;
import me.ichun.mods.betterthanbunnies.client.render.RabbitRenderDataStore;
import net.minecraft.client.model.animal.rabbit.RabbitModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.state.RabbitRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RabbitModel.class)
public abstract class RabbitTailMixin
{
    @Inject(method = "setupAnim", at = @At("TAIL"))
    private void updateVanillaTailVisibility(RabbitRenderState renderState, CallbackInfo ci)
    {
        if((Object)this instanceof BunnyFancyModel)
        {
            return;
        }
        RabbitModel self = (RabbitModel)(Object)this;
        ModelPart tail = self.root().getChild("body").getChild("tail");
        RabbitRenderDataStore.RenderData renderData = RabbitRenderDataStore.peek(renderState);
        boolean hasSuit = renderData != null && renderData.style().suit();
        tail.visible = !hasSuit;
    }
}
