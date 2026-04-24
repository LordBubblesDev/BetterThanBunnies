package me.ichun.mods.betterthanbunnies.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import me.ichun.mods.betterthanbunnies.client.model.BunnyFancyModel;
import net.minecraft.client.color.ColorLerper;
import net.minecraft.client.model.animal.rabbit.RabbitModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RabbitRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.RabbitRenderState;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ARGB;
import net.minecraft.util.Mth;
import net.minecraft.world.item.DyeColor;

public class BunnyFancyLayer extends RenderLayer<RabbitRenderState, RabbitModel>
{
    public static final Identifier TEX_FANCY_BUNNY = Identifier.fromNamespaceAndPath("betterthanbunnies", "textures/model/fancybunny.png");
    public static final Identifier TEX_FANCY_BUNNY_COLORIZER = Identifier.fromNamespaceAndPath("betterthanbunnies", "textures/model/fancybunnycolorizer.png");
    private static final int BOW_TIE_GRAY_TINT = 0xFF7F7F7F;
    private static final int MONOCLE_LENS_PACKED_COLOR = 0xFFFFFFFF;

    public BunnyFancyLayer(RabbitRenderer renderer)
    {
        super(renderer);
    }

    @Override
    public void submit(PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int packedLight, RabbitRenderState renderState, float yRot, float xRot)
    {
        RabbitRenderDataStore.RenderData renderData = RabbitRenderDataStore.peek(renderState);
        if(renderData == null)
        {
            return;
        }

        if(renderData.invisible())
        {
            return;
        }

        FancyRabbitStyle style = renderData.style();
        if(!style.any())
        {
            return;
        }

        boolean renderHat = style.hat();
        boolean renderMonocle = style.monocle();
        boolean renderPipe = style.pipe();
        boolean renderSuit = style.suit();

        int jacketTint;
        if(renderData.iChunRabbit())
        {
            int i = Mth.floor(renderState.ageInTicks) / 25 + renderData.rabbitId();
            int j = DyeColor.values().length;
            int k = i % j;
            int l = (i + 1) % j;
            float f = ((float)(Mth.floor(renderState.ageInTicks) % 25) + Mth.frac(renderState.ageInTicks)) / 25.0F;
            int c1j = ColorLerper.Type.SHEEP.getColor(DyeColor.byId(k));
            int c2j = ColorLerper.Type.SHEEP.getColor(DyeColor.byId(l));
            jacketTint = ARGB.srgbLerp(f, c1j, c2j);
        }
        else
        {
            DyeColor bowDye = DyeColor.byId(Math.floorMod(renderData.rabbitId() * 1234, DyeColor.values().length));
            jacketTint = ColorLerper.Type.SHEEP.getColor(bowDye);
        }

        int packedOverlay = LivingEntityRenderer.getOverlayCoords(renderState, 0.0F);

        poseStack.pushPose();
        if(renderHat || renderMonocle || renderPipe)
        {
            poseStack.pushPose();
            BunnyFancyModel headBaseModel = createAnimatedModel(renderState);
            if(renderMonocle)
            {
                setHeadVisibility(headBaseModel, renderHat, true, renderPipe, false, true);
            }
            else
            {
                setHeadVisibility(headBaseModel, renderHat, false, renderPipe, false, false);
            }
            submitNodeCollector.submitModel(headBaseModel, renderState, poseStack, RenderTypes.entityCutout(TEX_FANCY_BUNNY, false), packedLight, packedOverlay, 0xffffffff, null);
            if(renderMonocle)
            {
                BunnyFancyModel lensModel = createAnimatedModel(renderState);
                setMonocleLensOnlyVisible(lensModel);
                submitNodeCollector.submitModel(lensModel, renderState, poseStack, RenderTypes.entityTranslucent(TEX_FANCY_BUNNY, false), packedLight, packedOverlay, MONOCLE_LENS_PACKED_COLOR, null);
            }
            if(renderHat)
            {
                BunnyFancyModel headColorModel = createAnimatedModel(renderState);
                setHeadVisibility(headColorModel, true, false, false, true, false);
                submitNodeCollector.submitModel(headColorModel, renderState, poseStack, RenderTypes.entityCutout(TEX_FANCY_BUNNY_COLORIZER, false), packedLight, packedOverlay, 0xFFFFFFFF, null);
            }
            poseStack.popPose();
        }

        if(renderSuit)
        {
            BunnyFancyModel bodyBaseModel = createAnimatedModel(renderState);
            setBodyVisibility(bodyBaseModel, false, renderState.isBaby);
            submitNodeCollector.submitModel(bodyBaseModel, renderState, poseStack, RenderTypes.entityCutout(TEX_FANCY_BUNNY, false), packedLight, packedOverlay, 0xffffffff, null);

            BunnyFancyModel bowModel = createAnimatedModel(renderState);
            setSuitBowGrayPass(bowModel);
            submitNodeCollector.submitModel(bowModel, renderState, poseStack, RenderTypes.entityCutout(TEX_FANCY_BUNNY_COLORIZER, false), packedLight, packedOverlay, BOW_TIE_GRAY_TINT, null);

            BunnyFancyModel jacketColorModel = createAnimatedModel(renderState);
            setSuitJacketColorPass(jacketColorModel);
            submitNodeCollector.submitModel(jacketColorModel, renderState, poseStack, RenderTypes.entityCutout(TEX_FANCY_BUNNY_COLORIZER, false), packedLight, packedOverlay, jacketTint, null);
        }
        poseStack.popPose();
    }

    private BunnyFancyModel createAnimatedModel(RabbitRenderState renderState)
    {
        BunnyFancyModel model = new BunnyFancyModel(renderState.isBaby);
        model.setupAnim(renderState);
        return model;
    }

    private void setHeadVisibility(BunnyFancyModel modelFancyBunny, boolean hat, boolean monocle, boolean pipe, boolean colorPass, boolean cutoutOmitMonocleLens)
    {
        hideBody(modelFancyBunny);
        hideHead(modelFancyBunny);
        modelFancyBunny.hatTop.visible = hat;
        modelFancyBunny.hatRim.visible = hat && !colorPass;
        if(monocle && !colorPass)
        {
            if(cutoutOmitMonocleLens)
            {
                setVisible(true, modelFancyBunny.monocle, modelFancyBunny.monocle2, modelFancyBunny.monocle3, modelFancyBunny.monocle4, modelFancyBunny.monocle5, modelFancyBunny.monocle6, modelFancyBunny.monocle7, modelFancyBunny.monocle8, modelFancyBunny.monocleChain1, modelFancyBunny.monocleChain2, modelFancyBunny.monocleChain3, modelFancyBunny.monocleChain4);
            }
            else
            {
                setVisible(true, modelFancyBunny.monocle, modelFancyBunny.monocle1, modelFancyBunny.monocle2, modelFancyBunny.monocle3, modelFancyBunny.monocle4, modelFancyBunny.monocle5, modelFancyBunny.monocle6, modelFancyBunny.monocle7, modelFancyBunny.monocle8, modelFancyBunny.monocleChain1, modelFancyBunny.monocleChain2, modelFancyBunny.monocleChain3, modelFancyBunny.monocleChain4);
            }
        }
        setVisible(pipe && !colorPass, modelFancyBunny.pipe, modelFancyBunny.pipe2, modelFancyBunny.pipe3, modelFancyBunny.pipe4);
    }

    private static void setMonocleLensOnlyVisible(BunnyFancyModel modelFancyBunny)
    {
        hideBody(modelFancyBunny);
        hideHead(modelFancyBunny);
        modelFancyBunny.monocle1.visible = true;
    }

    private void setBodyVisibility(BunnyFancyModel modelFancyBunny, boolean colorPass, boolean isBaby)
    {
        hideHead(modelFancyBunny);
        modelFancyBunny.bodyTux.visible = true;
        modelFancyBunny.bodyTux.skipDraw = false;
        modelFancyBunny.frontLegRightTux.visible = !colorPass && !isBaby;
        modelFancyBunny.frontLegLeftTux.visible = !colorPass && !isBaby;
        modelFancyBunny.bodyTuxTail1.visible = !colorPass;
        modelFancyBunny.bodyTuxTail2.visible = !colorPass;
        setVisible(!colorPass, modelFancyBunny.bowtie1, modelFancyBunny.bowtie2, modelFancyBunny.bowtie3, modelFancyBunny.bowtie4, modelFancyBunny.bowtie5);
    }

    private void setSuitJacketColorPass(BunnyFancyModel modelFancyBunny)
    {
        hideHead(modelFancyBunny);
        modelFancyBunny.bodyTux.visible = true;
        modelFancyBunny.bodyTux.skipDraw = false;
        modelFancyBunny.frontLegRightTux.visible = false;
        modelFancyBunny.frontLegLeftTux.visible = false;
        modelFancyBunny.bodyTuxTail1.visible = false;
        modelFancyBunny.bodyTuxTail2.visible = false;
        setVisible(false, modelFancyBunny.bowtie1, modelFancyBunny.bowtie2, modelFancyBunny.bowtie3, modelFancyBunny.bowtie4, modelFancyBunny.bowtie5);
    }

    private static void setSuitBowGrayPass(BunnyFancyModel modelFancyBunny)
    {
        hideHead(modelFancyBunny);
        // Bow tie parts are children of bodyTux.
        modelFancyBunny.bodyTux.visible = true;
        modelFancyBunny.bodyTux.skipDraw = true;
        modelFancyBunny.frontLegRightTux.visible = false;
        modelFancyBunny.frontLegLeftTux.visible = false;
        modelFancyBunny.bodyTuxTail1.visible = false;
        modelFancyBunny.bodyTuxTail2.visible = false;
        setVisible(true, modelFancyBunny.bowtie1, modelFancyBunny.bowtie2, modelFancyBunny.bowtie3, modelFancyBunny.bowtie4, modelFancyBunny.bowtie5);
    }

    private static void hideHead(BunnyFancyModel modelFancyBunny)
    {
        setVisible(false, modelFancyBunny.hatTop, modelFancyBunny.hatRim, modelFancyBunny.monocle, modelFancyBunny.monocle2, modelFancyBunny.monocle3, modelFancyBunny.monocle4, modelFancyBunny.monocle5, modelFancyBunny.monocle6, modelFancyBunny.monocle7, modelFancyBunny.monocle8, modelFancyBunny.monocle1, modelFancyBunny.monocleChain1, modelFancyBunny.monocleChain2, modelFancyBunny.monocleChain3, modelFancyBunny.monocleChain4, modelFancyBunny.pipe, modelFancyBunny.pipe2, modelFancyBunny.pipe3, modelFancyBunny.pipe4);
    }

    private static void hideBody(BunnyFancyModel modelFancyBunny)
    {
        setVisible(false, modelFancyBunny.bodyTux, modelFancyBunny.frontLegRightTux, modelFancyBunny.frontLegLeftTux, modelFancyBunny.bodyTuxTail1, modelFancyBunny.bodyTuxTail2, modelFancyBunny.bowtie1, modelFancyBunny.bowtie2, modelFancyBunny.bowtie3, modelFancyBunny.bowtie4, modelFancyBunny.bowtie5);
    }

    private static void setVisible(boolean visible, ModelPart... parts)
    {
        for(ModelPart part : parts)
        {
            part.visible = visible;
        }
    }
}
