package me.ichun.mods.betterthanbunnies.client.model;

import net.minecraft.client.model.geom.PartPose;

/**
 * Baby-only local transform tuning for fancy accessories.
 * <p>
 * Scale is multiplicative (1 = unchanged). Position is additive model-space offset.
 * Rotation values are additive degrees (converted to radians in model code).
 */
public final class BabyAccessoryTuning
{
    public static final PartPose BODY_POSE = PartPose.offset(0.0F, 23.0F, 1.6F);
    public static final PartPose HEAD_POSE = PartPose.offset(0.0F, -5.0F, -2.6F);
    public static final PartPose FRONT_LEGS_POSE = PartPose.offset(0.0F, -0.5F, -2.0F);
    public static final PartPose RIGHT_FRONT_LEG_POSE = PartPose.offsetAndRotation(-1.0F, 1.0F, -0.5F, 0.3927F, 0.0F, 0.0F);
    public static final PartPose LEFT_FRONT_LEG_POSE = PartPose.offsetAndRotation(1.0F, 1.0F, -0.5F, 0.3927F, 0.0F, 0.0F);
    public static final PartPose RIGHT_FRONT_LEG_GROUP_POSE = PartPose.offset(0.0F, 0.0F, 0.0F);
    public static final PartPose LEFT_FRONT_LEG_GROUP_POSE = PartPose.offset(0.0F, 0.0F, 0.0F);

    // Baby-only absolute base poses for main accessory parent groups.
    public static final Pose HEAD_GROUP_BASE = new Pose(0.0F, -15.004F, 1.478F, 0.0F, 0.0F, 0.0F);
    public static final Pose BODY_GROUP_BASE = new Pose(0.0F, -19.70F, -12.25F, 0.414F, 0.0F, 0.0F);
    public static final PartPose HEAD_GROUP_POSE = PartPose.offset(HEAD_GROUP_BASE.x(), HEAD_GROUP_BASE.y(), HEAD_GROUP_BASE.z());
    public static final PartPose BODY_GROUP_POSE = PartPose.offsetAndRotation(
        BODY_GROUP_BASE.x(),
        BODY_GROUP_BASE.y(),
        BODY_GROUP_BASE.z(),
        BODY_GROUP_BASE.rotX(),
        BODY_GROUP_BASE.rotY(),
        BODY_GROUP_BASE.rotZ()
    );

    // head anchor group - parent for hat/monocle/pipe.
    public static final float HEAD_GROUP_SCALE_X = 0.9F;
    public static final float HEAD_GROUP_SCALE_Y = 0.9F;
    public static final float HEAD_GROUP_SCALE_Z = 0.9F;
    public static final float HEAD_GROUP_OFFSET_X = 0F;
    public static final float HEAD_GROUP_OFFSET_Y = 1.5F;
    public static final float HEAD_GROUP_OFFSET_Z = 0F;
    public static final float HEAD_GROUP_ROT_X = 0F;
    public static final float HEAD_GROUP_ROT_Y = 0F;
    public static final float HEAD_GROUP_ROT_Z = 0F;

    // monocle
    public static final float MONOCLE_SCALE_X = 1F;
    public static final float MONOCLE_SCALE_Y = 1F;
    public static final float MONOCLE_SCALE_Z = 1F;
    public static final float MONOCLE_OFFSET_X = 0F;
    public static final float MONOCLE_OFFSET_Y = 0F;
    public static final float MONOCLE_OFFSET_Z = 0.5F;
    public static final float MONOCLE_ROT_X = 0F;
    public static final float MONOCLE_ROT_Y = 0F;
    public static final float MONOCLE_ROT_Z = 0F;

    // pipe
    public static final float PIPE_SCALE_X = 1F;
    public static final float PIPE_SCALE_Y = 1F;
    public static final float PIPE_SCALE_Z = 1F;
    public static final float PIPE_OFFSET_X = 0F;
    public static final float PIPE_OFFSET_Y = 0F;
    public static final float PIPE_OFFSET_Z = 1.5F;
    public static final float PIPE_ROT_X = 0F;
    public static final float PIPE_ROT_Y = 0F;
    public static final float PIPE_ROT_Z = 0F;

    // hat (applied to hatGroup parent so scale does not pull rim and top apart)
    public static final float HAT_SCALE_X = 0.8F;
    public static final float HAT_SCALE_Y = 0.8F;
    public static final float HAT_SCALE_Z = 0.8F;
    public static final float HAT_OFFSET_X = 0F;
    public static final float HAT_OFFSET_Y = 0F;
    public static final float HAT_OFFSET_Z = 0.5F;
    public static final float HAT_ROT_X = 0F;
    public static final float HAT_ROT_Y = 0F;
    public static final float HAT_ROT_Z = 0F;

    // bow tie
    public static final float BOW_TIE_SCALE_X = 1F;
    public static final float BOW_TIE_SCALE_Y = 1F;
    public static final float BOW_TIE_SCALE_Z = 1F;
    public static final float BOW_TIE_OFFSET_X = 0F;
    public static final float BOW_TIE_OFFSET_Y = 0F;
    public static final float BOW_TIE_OFFSET_Z = 0F;
    public static final float BOW_TIE_ROT_X = 0F;
    public static final float BOW_TIE_ROT_Y = 0F;
    public static final float BOW_TIE_ROT_Z = 0F;

    // suit
    public static final float SUIT_SCALE_X = 0.5F;
    public static final float SUIT_SCALE_Y = 0.5F;
    public static final float SUIT_SCALE_Z = 0.5F;
    public static final float SUIT_OFFSET_X = 0F;
    public static final float SUIT_OFFSET_Y = 1.58F;
    public static final float SUIT_OFFSET_Z = -2.05F;
    public static final float SUIT_ROT_X = -31.5F;
    public static final float SUIT_ROT_Y = 0F;
    public static final float SUIT_ROT_Z = 0F;

    // coat tails (scales multiply with SUIT on parent bodyTux in the part hierarchy)
    public static final float TAILS_SCALE_X = 0.5F;
    public static final float TAILS_SCALE_Y = 0.5F;
    public static final float TAILS_SCALE_Z = 0.5F;
    public static final float TAILS_OFFSET_X = 0F;
    public static final float TAILS_OFFSET_Y = 0F;
    public static final float TAILS_OFFSET_Z = 0F;
    public static final float TAILS_ROT_X = 0F;
    public static final float TAILS_ROT_Y = 0F;
    public static final float TAILS_ROT_Z = 0F;

    public static final Transform MONOCLE = new Transform(
        MONOCLE_SCALE_X, MONOCLE_SCALE_Y, MONOCLE_SCALE_Z,
        MONOCLE_OFFSET_X, MONOCLE_OFFSET_Y, MONOCLE_OFFSET_Z,
        MONOCLE_ROT_X, MONOCLE_ROT_Y, MONOCLE_ROT_Z
    );
    public static final Transform HEAD_GROUP = new Transform(
        HEAD_GROUP_SCALE_X, HEAD_GROUP_SCALE_Y, HEAD_GROUP_SCALE_Z,
        HEAD_GROUP_OFFSET_X, HEAD_GROUP_OFFSET_Y, HEAD_GROUP_OFFSET_Z,
        HEAD_GROUP_ROT_X, HEAD_GROUP_ROT_Y, HEAD_GROUP_ROT_Z
    );
    public static final Transform PIPE = new Transform(
        PIPE_SCALE_X, PIPE_SCALE_Y, PIPE_SCALE_Z,
        PIPE_OFFSET_X, PIPE_OFFSET_Y, PIPE_OFFSET_Z,
        PIPE_ROT_X, PIPE_ROT_Y, PIPE_ROT_Z
    );
    public static final Transform BOW_TIE = new Transform(
        BOW_TIE_SCALE_X, BOW_TIE_SCALE_Y, BOW_TIE_SCALE_Z,
        BOW_TIE_OFFSET_X, BOW_TIE_OFFSET_Y, BOW_TIE_OFFSET_Z,
        BOW_TIE_ROT_X, BOW_TIE_ROT_Y, BOW_TIE_ROT_Z
    );
    public static final Transform HAT = new Transform(
        HAT_SCALE_X, HAT_SCALE_Y, HAT_SCALE_Z,
        HAT_OFFSET_X, HAT_OFFSET_Y, HAT_OFFSET_Z,
        HAT_ROT_X, HAT_ROT_Y, HAT_ROT_Z
    );
    public static final Transform SUIT = new Transform(
        SUIT_SCALE_X, SUIT_SCALE_Y, SUIT_SCALE_Z,
        SUIT_OFFSET_X, SUIT_OFFSET_Y, SUIT_OFFSET_Z,
        SUIT_ROT_X, SUIT_ROT_Y, SUIT_ROT_Z
    );
    public static final Transform SUIT_TAIL = new Transform(
        TAILS_SCALE_X, TAILS_SCALE_Y, TAILS_SCALE_Z,
        TAILS_OFFSET_X, TAILS_OFFSET_Y, TAILS_OFFSET_Z,
        TAILS_ROT_X, TAILS_ROT_Y, TAILS_ROT_Z
    );

    public record Transform(
        float scaleX,
        float scaleY,
        float scaleZ,
        float offsetX,
        float offsetY,
        float offsetZ,
        float rotX,
        float rotY,
        float rotZ
    ) { }

    public record Pose(
        float x,
        float y,
        float z,
        float rotX,
        float rotY,
        float rotZ
    ) { }
}
