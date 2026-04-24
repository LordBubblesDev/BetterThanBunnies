package me.ichun.mods.betterthanbunnies.client.model;

import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.animation.definitions.BabyRabbitAnimation;
import net.minecraft.client.animation.definitions.RabbitAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.state.RabbitRenderState;
import net.minecraft.util.Mth;

public class BunnyFancyModel extends EntityModel<RabbitRenderState>
{
    //hat
    public ModelPart hatRim;
    public ModelPart hatTop;
    private final ModelPart hatGroup;

    //bowtie
    public ModelPart bowtie5;
    public ModelPart bowtie3;
    public ModelPart bowtie4;
    public ModelPart bowtie1;
    public ModelPart bowtie2;

    //monocle
    public ModelPart monocle;
    public ModelPart monocle2;
    public ModelPart monocle3;
    public ModelPart monocle4;
    public ModelPart monocle5;
    public ModelPart monocle6;
    public ModelPart monocle7;
    public ModelPart monocle8;
    public ModelPart monocle1;
    public ModelPart monocleChain1;
    public ModelPart monocleChain2;
    public ModelPart monocleChain3;
    public ModelPart monocleChain4;

    //suit
    public ModelPart bodyTux;
    public ModelPart frontLegRightTux;
    public ModelPart bodyTuxTail1;
    public ModelPart bodyTuxTail2;
    public ModelPart frontLegLeftTux;

    //pipe
    public ModelPart pipe4;
    public ModelPart pipe2;
    public ModelPart pipe3;
    public ModelPart pipe;
    public ModelPart headGroup;
    public ModelPart bodyGroup;
    public ModelPart rightFrontLegGroup;
    public ModelPart leftFrontLegGroup;
    private final ModelPart bodyAnchor;
    private final ModelPart headAnchor;
    private final KeyframeAnimation hopAnimationAdult;
    private final KeyframeAnimation idleHeadTiltAnimationAdult;
    private final KeyframeAnimation hopAnimationBaby;
    private final KeyframeAnimation idleHeadTiltAnimationBaby;

    public BunnyFancyModel()
    {
        this(false);
    }

    public BunnyFancyModel(boolean babyRig)
    {
        super(createModel(babyRig).bakeRoot());

        bodyAnchor = root.getChild("body");
        headAnchor = bodyAnchor.getChild("head");
        var frontLegsAnchor = bodyAnchor.getChild("frontlegs");
        var rightFrontLegAnchor = frontLegsAnchor.getChild("right_front_leg");
        var leftFrontLegAnchor = frontLegsAnchor.getChild("left_front_leg");

        headGroup = headAnchor.getChild("headGroup");
        bodyGroup = bodyAnchor.getChild("bodyGroup");
        rightFrontLegGroup = rightFrontLegAnchor.getChild("rightFrontLegGroup");
        leftFrontLegGroup = leftFrontLegAnchor.getChild("leftFrontLegGroup");

        hatGroup = headGroup.getChild("hatGroup");
        hatRim = hatGroup.getChild("hat_rim");
        hatTop = hatGroup.getChild("hat_top");

        bodyTux = bodyGroup.getChild("bodyTux");
        bowtie5 = bodyTux.getChild("bowtie5");
        bowtie3 = bodyTux.getChild("bowtie3");
        bowtie4 = bodyTux.getChild("bowtie4");
        bowtie1 = bodyTux.getChild("bowtie1");
        bowtie2 = bodyTux.getChild("bowtie2");

        monocle = headGroup.getChild("monocle");
        monocle2 = headGroup.getChild("monocle2");
        monocle3 = headGroup.getChild("monocle3");
        monocle4 = headGroup.getChild("monocle4");
        monocle5 = headGroup.getChild("monocle5");
        monocle6 = headGroup.getChild("monocle6");
        monocle7 = headGroup.getChild("monocle7");
        monocle8 = headGroup.getChild("monocle8");
        monocle1 = headGroup.getChild("monocle1");

        monocleChain1 = headGroup.getChild("monocleChain1");
        monocleChain2 = headGroup.getChild("monocleChain2");
        monocleChain3 = headGroup.getChild("monocleChain3");
        monocleChain4 = headGroup.getChild("monocleChain4");

        frontLegRightTux = rightFrontLegGroup.getChild("frontLegRightTux");
        bodyTuxTail1 = bodyTux.getChild("bodyTuxTail1");
        bodyTuxTail2 = bodyTux.getChild("bodyTuxTail2");
        frontLegLeftTux = leftFrontLegGroup.getChild("frontLegLeftTux");

        pipe4 = headGroup.getChild("pipe4");
        pipe2 = headGroup.getChild("pipe2");
        pipe3 = headGroup.getChild("pipe3");
        pipe = headGroup.getChild("pipe");

        hopAnimationAdult = RabbitAnimation.HOP.bake(root);
        idleHeadTiltAnimationAdult = RabbitAnimation.IDLE_HEAD_TILT.bake(root);
        hopAnimationBaby = BabyRabbitAnimation.HOP.bake(root);
        idleHeadTiltAnimationBaby = BabyRabbitAnimation.IDLE_HEAD_TILT.bake(root);
    }

    public static LayerDefinition createModel()
    {
        return createModel(false);
    }

    public static LayerDefinition createModel(boolean babyRig)
    {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create(), pickPose(babyRig, BabyAccessoryTuning.BODY_POSE, AdultAccessoryTuning.BODY_POSE));
        body.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, -4.9916F, 0.0125F));
        body.addOrReplaceChild("body_r1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -2.0F, -1.6F, -0.5236F, 0.0F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create(), pickPose(babyRig, BabyAccessoryTuning.HEAD_POSE, AdultAccessoryTuning.HEAD_POSE));
        head.addOrReplaceChild("left_ear", CubeListBuilder.create(), PartPose.offset(1.5F, -3.7071F, -0.8787F));
        head.addOrReplaceChild("right_ear", CubeListBuilder.create(), PartPose.offset(-1.5F, -3.7071F, -0.8787F));
        PartDefinition frontLegs = body.addOrReplaceChild("frontlegs", CubeListBuilder.create(), pickPose(babyRig, BabyAccessoryTuning.FRONT_LEGS_POSE, AdultAccessoryTuning.FRONT_LEGS_POSE));
        PartDefinition rightFrontLeg = frontLegs.addOrReplaceChild("right_front_leg", CubeListBuilder.create(), pickPose(babyRig, BabyAccessoryTuning.RIGHT_FRONT_LEG_POSE, AdultAccessoryTuning.RIGHT_FRONT_LEG_POSE));
        PartDefinition leftFrontLeg = frontLegs.addOrReplaceChild("left_front_leg", CubeListBuilder.create(), pickPose(babyRig, BabyAccessoryTuning.LEFT_FRONT_LEG_POSE, AdultAccessoryTuning.LEFT_FRONT_LEG_POSE));

        PartDefinition headGroup = head.addOrReplaceChild(
            "headGroup",
            CubeListBuilder.create(),
            pickPose(babyRig, BabyAccessoryTuning.HEAD_GROUP_POSE, AdultAccessoryTuning.HEAD_GROUP_POSE)
        );
        
        PartDefinition bodyGroup = body.addOrReplaceChild(
            "bodyGroup",
            CubeListBuilder.create(),
            pickPose(babyRig, BabyAccessoryTuning.BODY_GROUP_POSE, AdultAccessoryTuning.BODY_GROUP_POSE)
        );
        PartDefinition rightFrontLegGroup = rightFrontLeg.addOrReplaceChild("rightFrontLegGroup", CubeListBuilder.create(), pickPose(babyRig, BabyAccessoryTuning.RIGHT_FRONT_LEG_GROUP_POSE, AdultAccessoryTuning.RIGHT_FRONT_LEG_GROUP_POSE));
        PartDefinition leftFrontLegGroup = leftFrontLeg.addOrReplaceChild("leftFrontLegGroup", CubeListBuilder.create(), pickPose(babyRig, BabyAccessoryTuning.LEFT_FRONT_LEG_GROUP_POSE, AdultAccessoryTuning.LEFT_FRONT_LEG_GROUP_POSE));

        addHeadAccessories(headGroup);
        addSuitAndSleeves(bodyGroup, rightFrontLegGroup, leftFrontLegGroup, babyRig);
        PartDefinition backLegs = root.addOrReplaceChild("backlegs", CubeListBuilder.create(), PartPose.offset(0.0F, 23.0F, 4.0F));
        PartDefinition rightHindLeg = backLegs.addOrReplaceChild("right_hind_leg", CubeListBuilder.create(), PartPose.offset(-3.0F, 0.5F, 0.0F));
        rightHindLeg.addOrReplaceChild("right_haunch", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.3927F, 0.0F));
        PartDefinition leftHindLeg = backLegs.addOrReplaceChild("left_hind_leg", CubeListBuilder.create(), PartPose.offset(3.0F, 0.5F, 0.0F));
        leftHindLeg.addOrReplaceChild("left_haunch", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, -0.3927F, 0.0F));

        return LayerDefinition.create(mesh, 64, 64);
    }

    private static void addHeadAccessories(PartDefinition headGroup)
    {
        PartDefinition hat = headGroup.addOrReplaceChild("hatGroup", CubeListBuilder.create(), BakedAccessoryMesh.HAT_GROUP_POSE);
        hat.addOrReplaceChild("hat_rim", CubeListBuilder.create().texOffs(1, 34).addBox(-4.5F, -0.5F, -4.5F, 9, 1, 9, BakedAccessoryMesh.HAT_RIM_DEFORMATION), BakedAccessoryMesh.HAT_RIM_POSE);
        hat.addOrReplaceChild("hat_top", CubeListBuilder.create().texOffs(1, 47).addBox(-3.5F, -4.5F, -3.5F, 7, 9, 7, BakedAccessoryMesh.HAT_TOP_DEFORMATION), BakedAccessoryMesh.HAT_TOP_POSE);
        headGroup.addOrReplaceChild("monocle", CubeListBuilder.create().texOffs(0, 35).addBox(-1.5F, -0.5F, -0.5F, 3, 1, 1, BakedAccessoryMesh.MONOCLE_BAR_DEFORMATION), BakedAccessoryMesh.MONOCLE_POSE);
        headGroup.addOrReplaceChild("monocle1", CubeListBuilder.create().texOffs(44, 34).addBox(-3.5F, -4F, -0.005F, 7, 8, 0.01F, BakedAccessoryMesh.MONOCLE_GLASS_DEFORMATION), BakedAccessoryMesh.MONOCLE1_POSE);
        headGroup.addOrReplaceChild("monocle2", CubeListBuilder.create().texOffs(0, 35).addBox(-1.5F, -0.5F, -0.5F, 3, 1, 1, BakedAccessoryMesh.MONOCLE_BAR_DEFORMATION), BakedAccessoryMesh.MONOCLE2_POSE);
        headGroup.addOrReplaceChild("monocle3", CubeListBuilder.create().texOffs(0, 35).addBox(-0.5F, -2F, -0.5F, 1, 4, 1, BakedAccessoryMesh.MONOCLE_POST_DEFORMATION), BakedAccessoryMesh.MONOCLE3_POSE);
        headGroup.addOrReplaceChild("monocle4", CubeListBuilder.create().texOffs(0, 35).addBox(-0.5F, -2F, -0.5F, 1, 4, 1, BakedAccessoryMesh.MONOCLE_POST_DEFORMATION), BakedAccessoryMesh.MONOCLE4_POSE);
        headGroup.addOrReplaceChild("monocle5", CubeListBuilder.create().texOffs(0, 35).addBox(-0.5F, -0.5F, -0.5F, 1 ,1 ,1, BakedAccessoryMesh.MONOCLE_DOT_DEFORMATION), BakedAccessoryMesh.MONOCLE5_POSE);
        headGroup.addOrReplaceChild("monocle6", CubeListBuilder.create().texOffs(0, 35).addBox(-0.5F, -0.5F, -0.5F, 1 ,1 ,1, BakedAccessoryMesh.MONOCLE_DOT_DEFORMATION), BakedAccessoryMesh.MONOCLE6_POSE);
        headGroup.addOrReplaceChild("monocle7", CubeListBuilder.create().texOffs(0, 35).addBox(-0.5F, -0.5F, -0.5F, 1 ,1 ,1, BakedAccessoryMesh.MONOCLE_DOT_DEFORMATION), BakedAccessoryMesh.MONOCLE7_POSE);
        headGroup.addOrReplaceChild("monocle8", CubeListBuilder.create().texOffs(0, 35).addBox(-0.5F, -0.5F, -0.5F, 1 ,1 ,1, BakedAccessoryMesh.MONOCLE_DOT_DEFORMATION), BakedAccessoryMesh.MONOCLE8_POSE);
        headGroup.addOrReplaceChild("monocleChain1", CubeListBuilder.create().texOffs(0, 35).addBox(-2F, -0.5F, -0.5F, 4, 1, 1, BakedAccessoryMesh.MONOCLE_CHAIN1_DEFORMATION), BakedAccessoryMesh.MONOCLE_CHAIN1_POSE);
        headGroup.addOrReplaceChild("monocleChain2", CubeListBuilder.create().texOffs(8, 32).addBox(-0.16666666666F * 0.3F, -0.5F * 0.3F, -0.5F * 0.3F, 7 * 0.3F, 1 * 0.3F, 1 * 0.3F), BakedAccessoryMesh.MONOCLE_CHAIN2_POSE);
        headGroup.addOrReplaceChild("monocleChain3", CubeListBuilder.create().texOffs(8, 32).addBox(-0.16666666666F * 0.3F, -0.5F * 0.3F, -0.5F * 0.3F, 7 * 0.3F, 1 * 0.3F, 1 * 0.3F), BakedAccessoryMesh.MONOCLE_CHAIN3_POSE);
        headGroup.addOrReplaceChild("monocleChain4", CubeListBuilder.create().texOffs(8, 32).addBox(-0.16666666666F * 0.3F, -0.5F * 0.3F, -0.5F * 0.3F, 7 * 0.3F, 1 * 0.3F, 1 * 0.3F), BakedAccessoryMesh.MONOCLE_CHAIN4_POSE);
        headGroup.addOrReplaceChild("pipe4", CubeListBuilder.create().texOffs(22, 46).addBox(-0.5F, -0.5F, -2F, 1, 1, 4, BakedAccessoryMesh.PIPE4_DEFORMATION), BakedAccessoryMesh.PIPE4_POSE);
        headGroup.addOrReplaceChild("pipe2", CubeListBuilder.create().texOffs(52, 44).addBox(-0.5F, -0.5F, -1.5F, 1, 1, 3, BakedAccessoryMesh.PIPE2_DEFORMATION), BakedAccessoryMesh.PIPE2_POSE);
        headGroup.addOrReplaceChild("pipe3", CubeListBuilder.create().texOffs(52, 44).addBox(-0.5F, -1F, -1.5F, 1, 2, 3, BakedAccessoryMesh.PIPE3_DEFORMATION), BakedAccessoryMesh.PIPE3_POSE);
        headGroup.addOrReplaceChild("pipe", CubeListBuilder.create().texOffs(41, 42).addBox(-1.5F, -2F, -1.5F, 3, 4, 3, BakedAccessoryMesh.PIPE_DEFORMATION), BakedAccessoryMesh.PIPE_POSE);
    }

    private static void addSuitAndSleeves(PartDefinition bodyGroup, PartDefinition rightFrontLegGroup, PartDefinition leftFrontLegGroup, boolean babyRig)
    {
        PartDefinition bodyTux = bodyGroup.addOrReplaceChild(
            "bodyTux",
            CubeListBuilder.create().texOffs(32, 49).addBox(-3F, -2.02380952381F, -9.7619047619F, 6, 5, 10, BakedAccessoryMesh.BODY_TUX_DEFORMATION),
            BakedAccessoryMesh.BODY_TUX_POSE
        );
        
        bodyTux.addOrReplaceChild("bodyTuxTail1", CubeListBuilder.create().texOffs(28, 53).addBox(-1.5F, 0.5F, -0.5F, 3, 0, 5), BakedAccessoryMesh.BODY_TUX_TAIL1_POSE);
        bodyTux.addOrReplaceChild("bodyTuxTail2", CubeListBuilder.create().texOffs(28, 48).addBox(-1.5F, 0.5F, -0.5F, 3, 0, 5), BakedAccessoryMesh.BODY_TUX_TAIL2_POSE);

        CubeDeformation bowKnot = BakedAccessoryMesh.BOW_KNOT_DEFORMATION;
        CubeDeformation bowWingTall = BakedAccessoryMesh.BOW_WING_TALL_DEFORMATION;
        CubeDeformation bowWingTaller = BakedAccessoryMesh.BOW_WING_TALLER_DEFORMATION;

        bodyTux.addOrReplaceChild("bowtie5", CubeListBuilder.create().texOffs(36, 36).addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, bowKnot), BakedAccessoryMesh.BOWTIE5_POSE);
        bodyTux.addOrReplaceChild("bowtie3", CubeListBuilder.create().texOffs(36, 36).addBox(-0.5F, -1F, -0.5F, 1, 2, 1, bowWingTall), BakedAccessoryMesh.BOWTIE3_POSE);
        bodyTux.addOrReplaceChild("bowtie4", CubeListBuilder.create().texOffs(36, 36).addBox(-0.5F, -1.5F, -0.5F, 1, 3, 1, bowWingTaller), BakedAccessoryMesh.BOWTIE4_POSE);
        bodyTux.addOrReplaceChild("bowtie1", CubeListBuilder.create().texOffs(36, 36).addBox(-0.5F, -1F, -0.5F, 1, 2, 1, bowWingTall), BakedAccessoryMesh.BOWTIE1_POSE);
        bodyTux.addOrReplaceChild("bowtie2", CubeListBuilder.create().texOffs(36, 36).addBox(-0.5F, -1.5F, -0.5F, 1, 3, 1, bowWingTaller), BakedAccessoryMesh.BOWTIE2_POSE);

        CubeDeformation sleeveDef = BakedAccessoryMesh.SLEEVE_DEFORMATION;
        rightFrontLegGroup.addOrReplaceChild("frontLegRightTux", CubeListBuilder.create().texOffs(50, 22).addBox(-1F, -0.16666666666F, -1F, 2, 3, 2, sleeveDef), BakedAccessoryMesh.RIGHT_SLEEVE_POSE);
        leftFrontLegGroup.addOrReplaceChild("frontLegLeftTux", CubeListBuilder.create().texOffs(50, 13).addBox(-1F, -0.16666666666F, -1F, 2, 3, 2, sleeveDef), BakedAccessoryMesh.LEFT_SLEEVE_POSE);
    }

    private static PartPose pickPose(boolean babyRig, PartPose babyPose, PartPose adultPose)
    {
        return babyRig ? babyPose : adultPose;
    }

    @Override
    public void setupAnim(RabbitRenderState renderState)
    {
        super.setupAnim(renderState);
        if(!renderState.idleHeadTiltAnimationState.isStarted())
        {
            headAnchor.yRot = renderState.yRot * ((float)Math.PI / 180.0F);
            headAnchor.xRot = renderState.xRot * ((float)Math.PI / 180.0F);
        }
        if(renderState.isBaby)
        {
            hopAnimationBaby.apply(renderState.hopAnimationState, renderState.ageInTicks);
            idleHeadTiltAnimationBaby.apply(renderState.idleHeadTiltAnimationState, renderState.ageInTicks);
        }
        else
        {
            hopAnimationAdult.apply(renderState.hopAnimationState, renderState.ageInTicks);
            idleHeadTiltAnimationAdult.apply(renderState.idleHeadTiltAnimationState, renderState.ageInTicks);
        }

        float jumpRotation = Mth.sin(renderState.jumpCompletion * (float)Math.PI);
        bodyTuxTail1.xRot = (-1.108972F + jumpRotation * 0.8F);
        bodyTuxTail2.xRot = (-1.108972F + jumpRotation * 0.8F);

        if(renderState.isBaby)
        {
            applyBabyAccessoryTuning();
        }
        else
        {
            applyAdultAccessoryTuning();
        }
    }

    private void applyAdultAccessoryTuning()
    {
        applyTransform(headGroup, AdultAccessoryTuning.HEAD_GROUP);
        applyTransform(bodyTux, AdultAccessoryTuning.SUIT);
        applyTransform(bodyTuxTail1, AdultAccessoryTuning.SUIT_TAIL);
        applyTransform(bodyTuxTail2, AdultAccessoryTuning.SUIT_TAIL);
        applyTransform(hatGroup, AdultAccessoryTuning.HAT);
        applyTransform(monocle, AdultAccessoryTuning.MONOCLE);
        applyTransform(monocle2, AdultAccessoryTuning.MONOCLE);
        applyTransform(monocle3, AdultAccessoryTuning.MONOCLE);
        applyTransform(monocle4, AdultAccessoryTuning.MONOCLE);
        applyTransform(monocle5, AdultAccessoryTuning.MONOCLE);
        applyTransform(monocle6, AdultAccessoryTuning.MONOCLE);
        applyTransform(monocle7, AdultAccessoryTuning.MONOCLE);
        applyTransform(monocle8, AdultAccessoryTuning.MONOCLE);
        applyTransform(monocle1, AdultAccessoryTuning.MONOCLE);
        applyTransform(monocleChain1, AdultAccessoryTuning.MONOCLE);
        applyTransform(monocleChain2, AdultAccessoryTuning.MONOCLE);
        applyTransform(monocleChain3, AdultAccessoryTuning.MONOCLE);
        applyTransform(monocleChain4, AdultAccessoryTuning.MONOCLE);
        applyTransform(pipe, AdultAccessoryTuning.PIPE);
        applyTransform(pipe2, AdultAccessoryTuning.PIPE);
        applyTransform(pipe3, AdultAccessoryTuning.PIPE);
        applyTransform(pipe4, AdultAccessoryTuning.PIPE);
        applyTransform(bowtie1, AdultAccessoryTuning.BOW_TIE);
        applyTransform(bowtie2, AdultAccessoryTuning.BOW_TIE);
        applyTransform(bowtie3, AdultAccessoryTuning.BOW_TIE);
        applyTransform(bowtie4, AdultAccessoryTuning.BOW_TIE);
        applyTransform(bowtie5, AdultAccessoryTuning.BOW_TIE);
        applyTransform(frontLegRightTux, AdultAccessoryTuning.SLEEVES);
        applyTransform(frontLegLeftTux, AdultAccessoryTuning.SLEEVES);
    }

    private void applyBabyAccessoryTuning()
    {
        applyAbsolutePose(headGroup, BabyAccessoryTuning.HEAD_GROUP_BASE);
        applyAbsolutePose(bodyGroup, BabyAccessoryTuning.BODY_GROUP_BASE);

        applyTransform(headGroup, BabyAccessoryTuning.HEAD_GROUP);

        applyTransform(bodyTux, BabyAccessoryTuning.SUIT);

        applyTransform(bodyTuxTail1, BabyAccessoryTuning.SUIT_TAIL);
        applyTransform(bodyTuxTail2, BabyAccessoryTuning.SUIT_TAIL);

        applyTransform(hatGroup, BabyAccessoryTuning.HAT);

        applyTransform(monocle, BabyAccessoryTuning.MONOCLE);
        applyTransform(monocle2, BabyAccessoryTuning.MONOCLE);
        applyTransform(monocle3, BabyAccessoryTuning.MONOCLE);
        applyTransform(monocle4, BabyAccessoryTuning.MONOCLE);
        applyTransform(monocle5, BabyAccessoryTuning.MONOCLE);
        applyTransform(monocle6, BabyAccessoryTuning.MONOCLE);
        applyTransform(monocle7, BabyAccessoryTuning.MONOCLE);
        applyTransform(monocle8, BabyAccessoryTuning.MONOCLE);
        applyTransform(monocle1, BabyAccessoryTuning.MONOCLE);
        applyTransform(monocleChain1, BabyAccessoryTuning.MONOCLE);
        applyTransform(monocleChain2, BabyAccessoryTuning.MONOCLE);
        applyTransform(monocleChain3, BabyAccessoryTuning.MONOCLE);
        applyTransform(monocleChain4, BabyAccessoryTuning.MONOCLE);

        applyTransform(pipe, BabyAccessoryTuning.PIPE);
        applyTransform(pipe2, BabyAccessoryTuning.PIPE);
        applyTransform(pipe3, BabyAccessoryTuning.PIPE);
        applyTransform(pipe4, BabyAccessoryTuning.PIPE);

        applyTransform(bowtie1, BabyAccessoryTuning.BOW_TIE);
        applyTransform(bowtie2, BabyAccessoryTuning.BOW_TIE);
        applyTransform(bowtie3, BabyAccessoryTuning.BOW_TIE);
        applyTransform(bowtie4, BabyAccessoryTuning.BOW_TIE);
        applyTransform(bowtie5, BabyAccessoryTuning.BOW_TIE);
    }

    private static void applyTransform(ModelPart part, BabyAccessoryTuning.Transform transform)
    {
        part.xScale *= transform.scaleX();
        part.yScale *= transform.scaleY();
        part.zScale *= transform.scaleZ();
        part.x += transform.offsetX();
        part.y += transform.offsetY();
        part.z += transform.offsetZ();
        part.xRot += transform.rotX() * ((float)Math.PI / 180.0F);
        part.yRot += transform.rotY() * ((float)Math.PI / 180.0F);
        part.zRot += transform.rotZ() * ((float)Math.PI / 180.0F);
    }

    private static void applyAbsolutePose(ModelPart part, BabyAccessoryTuning.Pose pose)
    {
        part.setPos(pose.x(), pose.y(), pose.z());
        part.setRotation(pose.rotX(), pose.rotY(), pose.rotZ());
    }

}