package me.ichun.mods.betterthanbunnies.client.model;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;

/**
 * Baked per-cube layout for the shared fancy rig (used for baby and adult in {@link BunnyFancyModel}).
 * Change this when you reshape a mesh, UVs, or relative part placement. Day-to-day accessory nudges:
 * {@link AdultAccessoryTuning} (adults) or {@link BabyAccessoryTuning} (babies).
 */
final class BakedAccessoryMesh
{
    private BakedAccessoryMesh()
    {
    }

    // -- hat: mesh under a shared hatGroup so HAT scale/offset/rot applies to rim + top together --
    public static final PartPose HAT_GROUP_POSE = PartPose.offset(0.0F, 11.5F, -3.18F);
    public static final CubeDeformation HAT_RIM_DEFORMATION = new CubeDeformation(-1.35F, 0.025F, -1.35F);
    public static final CubeDeformation HAT_TOP_DEFORMATION = new CubeDeformation(-1.4F, -1.8F, -1.4F);
    public static final PartPose HAT_RIM_POSE = PartPose.offset(0.0F, 0.0F, 0.0F);
    public static final PartPose HAT_TOP_POSE = PartPose.offset(0.0F, -3.0F, 0.0F);

    // -- monocle (rotations in radians) --
    public static final CubeDeformation MONOCLE_BAR_DEFORMATION = new CubeDeformation(-1.05F, -0.35F, -0.35F);
    public static final CubeDeformation MONOCLE_POST_DEFORMATION = new CubeDeformation(-0.35F, -1.4F, -0.35F);
    public static final CubeDeformation MONOCLE_DOT_DEFORMATION = new CubeDeformation(-0.35F, -0.35F, -0.35F);
    public static final CubeDeformation MONOCLE_GLASS_DEFORMATION = new CubeDeformation(-2.45F, -2.8F, 0.0F);
    public static final CubeDeformation MONOCLE_CHAIN1_DEFORMATION = new CubeDeformation(-1.4F, -0.35F, -0.35F);
    public static final PartPose MONOCLE_POSE = PartPose.offset(1.0F, 12.9F, -5.9F);
    public static final PartPose MONOCLE2_POSE = PartPose.offset(1.0F, 15.0F, -5.9F);
    public static final PartPose MONOCLE3_POSE = PartPose.offset(0.1F, 13.95F, -5.9F);
    public static final PartPose MONOCLE4_POSE = PartPose.offset(1.9F, 13.95F, -5.9F);
    public static final PartPose MONOCLE5_POSE = PartPose.offset(0.4F, 13.2F, -5.9F);
    public static final PartPose MONOCLE6_POSE = PartPose.offset(0.4F, 14.7F, -5.9F);
    public static final PartPose MONOCLE7_POSE = PartPose.offset(1.6F, 13.2F, -5.9F);
    public static final PartPose MONOCLE8_POSE = PartPose.offset(1.6F, 14.7F, -5.9F);
    public static final PartPose MONOCLE1_POSE = PartPose.offset(1.0F, 13.95F, -5.9F);
    public static final PartPose MONOCLE_CHAIN1_POSE = PartPose.offsetAndRotation(2.25F, 13.6F, -6.3F, 0.0F, -0.0799003F, 0.8822937F);
    public static final PartPose MONOCLE_CHAIN2_POSE = PartPose.offsetAndRotation(2.6F, 14.0F, -6.3F, -1.5263477F, -0.8136065F, 1.5096725F);
    public static final PartPose MONOCLE_CHAIN3_POSE = PartPose.offsetAndRotation(2.683918F, 15.3712F, -4.846462F, -1.5867012F, -0.8144203F, 1.5926617F);
    public static final PartPose MONOCLE_CHAIN4_POSE = PartPose.offsetAndRotation(2.65391F, 16.74345F, -3.391807F, -2.501873F, -0.6680762F, 2.6430418F);

    // -- pipe --
    public static final CubeDeformation PIPE4_DEFORMATION = new CubeDeformation(-0.335F, -0.335F, -1.34F);
    public static final CubeDeformation PIPE2_DEFORMATION = new CubeDeformation(-0.335F, -0.335F, -1.005F);
    public static final CubeDeformation PIPE3_DEFORMATION = new CubeDeformation(-0.335F, -0.67F, -1.005F);
    public static final CubeDeformation PIPE_DEFORMATION = new CubeDeformation(-1.005F, -1.34F, -1.005F);
    public static final PartPose PIPE4_POSE = PartPose.offsetAndRotation(-0.5F, 16.55F, -6.2F, 0.3689549F, 0.3528234F, 0.0869134F);
    public static final PartPose PIPE2_POSE = PartPose.offsetAndRotation(-0.863904F, 17.02034F, -7.073644F, 0.6067749F, 0.3528234F, 0.0869134F);
    public static final PartPose PIPE3_POSE = PartPose.offsetAndRotation(-1.09568F, 17.60841F, -7.562072F, 0.8521354F, 0.3528233F, 0.0869134F);
    public static final PartPose PIPE_POSE = PartPose.offsetAndRotation(-1.326135F, 17.80624F, -8.138918F, 0.2627141F, 0.3528234F, 0.0869134F);

    // -- suit, tails, bow, sleeves (rotations in radians) --
    public static final PartPose BODY_TUX_POSE = PartPose.offsetAndRotation(0.0F, 20.5F, 6.72F, -0.395F, 0.0F, 0.0F);
    public static final CubeDeformation BODY_TUX_DEFORMATION = new CubeDeformation(1.05F, 0.6F, 1.50F);
    public static final PartPose BODY_TUX_TAIL1_POSE = PartPose.offsetAndRotation(1.6F, -2.72F, 1.62F, -1.1550761F, 0.0783855F, -0.1755566F);
    public static final PartPose BODY_TUX_TAIL2_POSE = PartPose.offsetAndRotation(-1.6F, -2.72F, 1.62F, -1.1550189F, -0.0783511F, 0.1755257F);
    public static final CubeDeformation BOW_KNOT_DEFORMATION = new CubeDeformation(0.08F, -0.3F, 0.02F);
    public static final CubeDeformation BOW_WING_TALL_DEFORMATION = new CubeDeformation(0.08F, -0.34F, 0.02F);
    public static final CubeDeformation BOW_WING_TALLER_DEFORMATION = new CubeDeformation(0.08F, -0.38F, 0.02F);
    public static final PartPose BOWTIE5_POSE = PartPose.offset(0.0F, 0.95F, -11.55F);
    public static final PartPose BOWTIE3_POSE = PartPose.offset(0.75F, 0.95F, -11.55F);
    public static final PartPose BOWTIE4_POSE = PartPose.offset(1.5F, 0.95F, -11.55F);
    public static final PartPose BOWTIE1_POSE = PartPose.offset(-0.75F, 0.95F, -11.55F);
    public static final PartPose BOWTIE2_POSE = PartPose.offset(-1.5F, 0.95F, -11.55F);
    public static final CubeDeformation SLEEVE_DEFORMATION = new CubeDeformation(0.15F, 0.06F, 0.05F);
    public static final PartPose RIGHT_SLEEVE_POSE = PartPose.offsetAndRotation(-0.55F, 19.42F, -1.55F, 0.02F, 0.0F, 0.0F);
    public static final PartPose LEFT_SLEEVE_POSE = PartPose.offsetAndRotation(0.55F, 19.42F, -1.55F, 0.02F, 0.0F, 0.0F);
}
