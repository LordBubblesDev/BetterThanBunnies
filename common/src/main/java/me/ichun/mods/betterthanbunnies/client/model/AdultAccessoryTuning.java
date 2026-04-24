package me.ichun.mods.betterthanbunnies.client.model;

import net.minecraft.client.model.geom.PartPose;

/**
 * Adult fancy accessory tuning. Layout matches {@link BabyAccessoryTuning}: one block per logical item,
 * with scale, position (model-space), and rotation in degrees. Those values are applied on top of the
 * baked mesh in {@link BakedAccessoryMesh} each frame (see {@link BunnyFancyModel}).
 * <p>
 * Edit the float constants; the {@link BabyAccessoryTuning.Transform} fields are built from them.
 */
public final class AdultAccessoryTuning
{
    private AdultAccessoryTuning()
    {
    }

    // -- vanilla rabbit skeleton (adult rig); radians, same as PartPose APIs --

    public static final PartPose BODY_POSE = PartPose.offsetAndRotation(0.0F, 23.0F, 4.0F, -0.3927F, 0.0F, 0.0F);
    public static final PartPose HEAD_POSE = PartPose.offsetAndRotation(0.0F, -5.2929F, -8.1213F, 0.3927F, 0.0F, 0.0F);
    public static final PartPose FRONT_LEGS_POSE = PartPose.offset(0.0F, -1.5349F, -6.3108F);
    public static final PartPose RIGHT_FRONT_LEG_POSE = PartPose.offsetAndRotation(-2.0F, 1.9239F, 0.3827F, 0.3927F, 0.0F, 0.0F);
    public static final PartPose LEFT_FRONT_LEG_POSE = PartPose.offsetAndRotation(2.0F, 1.9239F, 0.4827F, 0.3927F, 0.0F, 0.0F);
    public static final PartPose RIGHT_FRONT_LEG_GROUP_POSE = PartPose.offset(0.6F, -21.091F, 1.624F);
    public static final PartPose LEFT_FRONT_LEG_GROUP_POSE = PartPose.offset(-0.6F, -21.129F, 1.533F);

    // -- outfit parent groups (baked pose under vanilla bones) — radians in record --

    public static final BabyAccessoryTuning.Pose HEAD_GROUP_BASE = new BabyAccessoryTuning.Pose(0.0F, -15.004F, 1.478F, 0.0F, 0.0F, 0.0F);
    public static final PartPose HEAD_GROUP_POSE = PartPose.offset(HEAD_GROUP_BASE.x(), HEAD_GROUP_BASE.y(), HEAD_GROUP_BASE.z());

    public static final BabyAccessoryTuning.Pose BODY_GROUP_BASE = new BabyAccessoryTuning.Pose(0.0F, -19.70F, -12.25F, 0.414F, 0.0F, 0.0F);
    public static final PartPose BODY_GROUP_POSE = PartPose.offsetAndRotation(
        BODY_GROUP_BASE.x(),
        BODY_GROUP_BASE.y(),
        BODY_GROUP_BASE.z(),
        BODY_GROUP_BASE.rotX(),
        BODY_GROUP_BASE.rotY(),
        BODY_GROUP_BASE.rotZ()
    );

    // Parent for hat, monocle, and pipe; multiplicative scale and additive offset/rot (degrees).
    public static final float HEAD_GROUP_SCALE_X = 1.0F;
    public static final float HEAD_GROUP_SCALE_Y = 1.0F;
    public static final float HEAD_GROUP_SCALE_Z = 1.0F;
    public static final float HEAD_GROUP_OFFSET_X = 0.0F;
    public static final float HEAD_GROUP_OFFSET_Y = 0.0F;
    public static final float HEAD_GROUP_OFFSET_Z = 0.0F;
    public static final float HEAD_GROUP_ROT_X = 0.0F;
    public static final float HEAD_GROUP_ROT_Y = 0.0F;
    public static final float HEAD_GROUP_ROT_Z = 0.0F;

    public static final float HAT_SCALE_X = 0.8F;
    public static final float HAT_SCALE_Y = 0.8F;
    public static final float HAT_SCALE_Z = 0.8F;
    public static final float HAT_OFFSET_X = 0.0F;
    public static final float HAT_OFFSET_Y = 0.0F;
    public static final float HAT_OFFSET_Z = 0.0F;
    public static final float HAT_ROT_X = 0.0F;
    public static final float HAT_ROT_Y = 0.0F;
    public static final float HAT_ROT_Z = 0.0F;

    public static final float MONOCLE_SCALE_X = 1.0F;
    public static final float MONOCLE_SCALE_Y = 1.0F;
    public static final float MONOCLE_SCALE_Z = 1.0F;
    public static final float MONOCLE_OFFSET_X = 0.0F;
    public static final float MONOCLE_OFFSET_Y = 0.0F;
    public static final float MONOCLE_OFFSET_Z = 0.0F;
    public static final float MONOCLE_ROT_X = 0.0F;
    public static final float MONOCLE_ROT_Y = 0.0F;
    public static final float MONOCLE_ROT_Z = 0.0F;

    public static final float PIPE_SCALE_X = 1.0F;
    public static final float PIPE_SCALE_Y = 1.0F;
    public static final float PIPE_SCALE_Z = 1.0F;
    public static final float PIPE_OFFSET_X = 0.0F;
    public static final float PIPE_OFFSET_Y = 0.0F;
    public static final float PIPE_OFFSET_Z = 0.0F;
    public static final float PIPE_ROT_X = 0.0F;
    public static final float PIPE_ROT_Y = 0.0F;
    public static final float PIPE_ROT_Z = 0.0F;

    public static final float BOW_TIE_SCALE_X = 1.0F;
    public static final float BOW_TIE_SCALE_Y = 1.0F;
    public static final float BOW_TIE_SCALE_Z = 1.0F;
    public static final float BOW_TIE_OFFSET_X = 0.0F;
    public static final float BOW_TIE_OFFSET_Y = 0.0F;
    public static final float BOW_TIE_OFFSET_Z = 0.0F;
    public static final float BOW_TIE_ROT_X = 0.0F;
    public static final float BOW_TIE_ROT_Y = 0.0F;
    public static final float BOW_TIE_ROT_Z = 0.0F;

    public static final float SUIT_SCALE_X = 1.0F;
    public static final float SUIT_SCALE_Y = 1.0F;
    public static final float SUIT_SCALE_Z = 1.0F;
    public static final float SUIT_OFFSET_X = 0.0F;
    public static final float SUIT_OFFSET_Y = 0.0F;
    public static final float SUIT_OFFSET_Z = 0.0F;
    public static final float SUIT_ROT_X = 0.0F;
    public static final float SUIT_ROT_Y = 0.0F;
    public static final float SUIT_ROT_Z = 0.0F;

    // Coat tails: parented to bodyTux; scale multiplies with SUIT on bodyTux in the hierarchy
    public static final float TAILS_SCALE_X = 1.0F;
    public static final float TAILS_SCALE_Y = 1.0F;
    public static final float TAILS_SCALE_Z = 1.0F;
    public static final float TAILS_OFFSET_X = 0.0F;
    public static final float TAILS_OFFSET_Y = 0.0F;
    public static final float TAILS_OFFSET_Z = 0.0F;
    public static final float TAILS_ROT_X = 0.0F;
    public static final float TAILS_ROT_Y = 0.0F;
    public static final float TAILS_ROT_Z = 0.0F;

    // Front leg sleeves; applied to each leg’s sleeve
    public static final float SLEEVES_SCALE_X = 1.0F;
    public static final float SLEEVES_SCALE_Y = 1.0F;
    public static final float SLEEVES_SCALE_Z = 1.0F;
    public static final float SLEEVES_OFFSET_X = 0.0F;
    public static final float SLEEVES_OFFSET_Y = 0.0F;
    public static final float SLEEVES_OFFSET_Z = 0.0F;
    public static final float SLEEVES_ROT_X = 0.0F;
    public static final float SLEEVES_ROT_Y = 0.0F;
    public static final float SLEEVES_ROT_Z = 0.0F;

    public static final BabyAccessoryTuning.Transform HEAD_GROUP = new BabyAccessoryTuning.Transform(
        HEAD_GROUP_SCALE_X, HEAD_GROUP_SCALE_Y, HEAD_GROUP_SCALE_Z,
        HEAD_GROUP_OFFSET_X, HEAD_GROUP_OFFSET_Y, HEAD_GROUP_OFFSET_Z,
        HEAD_GROUP_ROT_X, HEAD_GROUP_ROT_Y, HEAD_GROUP_ROT_Z
    );
    public static final BabyAccessoryTuning.Transform HAT = new BabyAccessoryTuning.Transform(
        HAT_SCALE_X, HAT_SCALE_Y, HAT_SCALE_Z, HAT_OFFSET_X, HAT_OFFSET_Y, HAT_OFFSET_Z, HAT_ROT_X, HAT_ROT_Y, HAT_ROT_Z
    );
    public static final BabyAccessoryTuning.Transform MONOCLE = new BabyAccessoryTuning.Transform(
        MONOCLE_SCALE_X, MONOCLE_SCALE_Y, MONOCLE_SCALE_Z,
        MONOCLE_OFFSET_X, MONOCLE_OFFSET_Y, MONOCLE_OFFSET_Z, MONOCLE_ROT_X, MONOCLE_ROT_Y, MONOCLE_ROT_Z
    );
    public static final BabyAccessoryTuning.Transform PIPE = new BabyAccessoryTuning.Transform(
        PIPE_SCALE_X, PIPE_SCALE_Y, PIPE_SCALE_Z, PIPE_OFFSET_X, PIPE_OFFSET_Y, PIPE_OFFSET_Z, PIPE_ROT_X, PIPE_ROT_Y, PIPE_ROT_Z
    );
    public static final BabyAccessoryTuning.Transform BOW_TIE = new BabyAccessoryTuning.Transform(
        BOW_TIE_SCALE_X, BOW_TIE_SCALE_Y, BOW_TIE_SCALE_Z,
        BOW_TIE_OFFSET_X, BOW_TIE_OFFSET_Y, BOW_TIE_OFFSET_Z, BOW_TIE_ROT_X, BOW_TIE_ROT_Y, BOW_TIE_ROT_Z
    );
    public static final BabyAccessoryTuning.Transform SUIT = new BabyAccessoryTuning.Transform(
        SUIT_SCALE_X, SUIT_SCALE_Y, SUIT_SCALE_Z, SUIT_OFFSET_X, SUIT_OFFSET_Y, SUIT_OFFSET_Z, SUIT_ROT_X, SUIT_ROT_Y, SUIT_ROT_Z
    );
    public static final BabyAccessoryTuning.Transform SUIT_TAIL = new BabyAccessoryTuning.Transform(
        TAILS_SCALE_X, TAILS_SCALE_Y, TAILS_SCALE_Z, TAILS_OFFSET_X, TAILS_OFFSET_Y, TAILS_OFFSET_Z, TAILS_ROT_X, TAILS_ROT_Y, TAILS_ROT_Z
    );
    public static final BabyAccessoryTuning.Transform SLEEVES = new BabyAccessoryTuning.Transform(
        SLEEVES_SCALE_X, SLEEVES_SCALE_Y, SLEEVES_SCALE_Z,
        SLEEVES_OFFSET_X, SLEEVES_OFFSET_Y, SLEEVES_OFFSET_Z, SLEEVES_ROT_X, SLEEVES_ROT_Y, SLEEVES_ROT_Z
    );
}
