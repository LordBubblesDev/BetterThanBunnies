package me.ichun.mods.betterthanbunnies.mixin.client;

import me.ichun.mods.betterthanbunnies.client.render.FancyRabbitStyle;
import me.ichun.mods.betterthanbunnies.client.render.RabbitRenderDataStore;
import net.minecraft.client.renderer.entity.RabbitRenderer;
import net.minecraft.client.renderer.entity.state.RabbitRenderState;
import net.minecraft.world.entity.animal.rabbit.Rabbit;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RabbitRenderer.class)
public abstract class RabbitStyleCaptureMixin
{
    @Inject(
        method = "extractRenderState(Lnet/minecraft/world/entity/animal/rabbit/Rabbit;Lnet/minecraft/client/renderer/entity/state/RabbitRenderState;F)V",
        at = @At("TAIL")
    )
    private void captureFancyDataOnState(Rabbit entity, RabbitRenderState state, float tickDelta, CallbackInfo ci)
    {
        FancyRabbitStyle style = FancyRabbitStyle.roll(entity);
        String rabbitName = entity.hasCustomName() ? entity.getName().getString() : "";
        RabbitRenderDataStore.putForExtract(state, style, entity.getId(), "iChun".equals(rabbitName), entity.isInvisible());
    }
}
