package com.dreamcritting.ror.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelTitania<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("ror", "model_titania"), "main");
	public final ModelPart main;
	public final ModelPart R_wing;
	public final ModelPart R_top_wing;
	public final ModelPart R_bottom_wing;
	public final ModelPart L_wing;
	public final ModelPart L_top_wing;
	public final ModelPart L_bottom_wing;
	public final ModelPart torso;
	public final ModelPart dress;
	public final ModelPart R_arm;
	public final ModelPart L_arm;
	public final ModelPart R_leg;
	public final ModelPart L_leg;
	public final ModelPart head;
	public final ModelPart glow;

	public ModelTitania(ModelPart root) {
		this.main = root.getChild("main");
		this.R_wing = this.main.getChild("R_wing");
		this.R_top_wing = this.R_wing.getChild("R_top_wing");
		this.R_bottom_wing = this.R_wing.getChild("R_bottom_wing");
		this.L_wing = this.main.getChild("L_wing");
		this.L_top_wing = this.L_wing.getChild("L_top_wing");
		this.L_bottom_wing = this.L_wing.getChild("L_bottom_wing");
		this.torso = this.main.getChild("torso");
		this.dress = this.main.getChild("dress");
		this.R_arm = this.main.getChild("R_arm");
		this.L_arm = this.main.getChild("L_arm");
		this.R_leg = this.main.getChild("R_leg");
		this.L_leg = this.main.getChild("L_leg");
		this.head = this.main.getChild("head");
		this.glow = this.head.getChild("glow");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, 0.0F));
		PartDefinition R_wing = main.addOrReplaceChild("R_wing", CubeListBuilder.create(), PartPose.offsetAndRotation(5.5F, -9.0F, 4.0F, 0.0F, -0.7854F, 0.0F));
		PartDefinition R_top_wing = R_wing.addOrReplaceChild("R_top_wing", CubeListBuilder.create().texOffs(0, 0).addBox(11.5F, -16.0F, 4.0F, 48.0F, 29.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.5F, -6.0F, -4.0F));
		PartDefinition R_bottom_wing = R_wing.addOrReplaceChild("R_bottom_wing", CubeListBuilder.create().texOffs(60, 54).addBox(0.0F, -3.0F, 4.0F, 28.0F, 26.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -4.0F));
		PartDefinition L_wing = main.addOrReplaceChild("L_wing", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.5F, -9.0F, 4.0F, 0.0F, 0.7854F, 0.0F));
		PartDefinition L_top_wing = L_wing.addOrReplaceChild("L_top_wing", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-47.5F, -16.0F, 4.0F, 48.0F, 29.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(-0.5F, -6.0F, -4.0F));
		PartDefinition L_bottom_wing = L_wing.addOrReplaceChild("L_bottom_wing", CubeListBuilder.create().texOffs(60, 54).mirror().addBox(-28.0F, -3.0F, 4.0F, 28.0F, 26.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(0.0F, 1.0F, -4.0F));
		PartDefinition torso = main.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 82).addBox(-5.5F, -39.0F, -3.0F, 11.0F, 15.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(60, 80)
				.addBox(-6.5F, -46.0F, -5.0F, 13.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(96, 0).addBox(-6.5F, -39.0F, -5.0F, 13.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 28.0F, 0.0F));
		PartDefinition dress = main.addOrReplaceChild("dress",
				CubeListBuilder.create().texOffs(0, 29).addBox(-9.5F, -2.0F, -7.0F, 19.0F, 10.0F, 15.0F, new CubeDeformation(0.0F)).texOffs(3, 123).addBox(-8.5F, -1.0F, -6.0F, 17.0F, 19.0F, 13.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 2.0F, 0.0F));
		PartDefinition R_arm = main.addOrReplaceChild("R_arm", CubeListBuilder.create().texOffs(56, 97).mirror().addBox(-0.6014F, -2.0926F, -2.0F, 5.0F, 21.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(6.5F, -16.0F, 0.0F, 0.0F, 0.0F, -0.3054F));
		PartDefinition L_arm = main.addOrReplaceChild("L_arm", CubeListBuilder.create().texOffs(56, 97).addBox(-4.3986F, -2.0926F, -2.0F, 5.0F, 21.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-6.5F, -16.0F, 0.0F, 0.0F, 0.0F, 0.3054F));
		PartDefinition R_leg = main.addOrReplaceChild("R_leg", CubeListBuilder.create().texOffs(36, 82).mirror().addBox(-2.0F, 0.0F, -2.0F, 5.0F, 24.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(3.5F, 4.0F, 0.0F, 0.0F, 0.0F, 0.0436F));
		PartDefinition L_leg = main.addOrReplaceChild("L_leg", CubeListBuilder.create().texOffs(36, 82).addBox(-3.0F, 0.0F, -2.0F, 5.0F, 24.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 4.0F, 0.0F, 0.0F, 0.0F, -0.0436F));
		PartDefinition head = main.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(68, 29).addBox(-5.0F, -11.0F, -6.0F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(96, 12).addBox(-3.0F, -15.0F, -6.0F, 7.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-0.5F, -18.0F, 0.5F));
		PartDefinition glow = head.addOrReplaceChild("glow", CubeListBuilder.create().texOffs(118, 38).addBox(-2.0F, -2.0F, -4.5F, 8.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -4.0F, -1.0F));
		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		main.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.glow.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.glow.xRot = headPitch / (180F / (float) Math.PI);
	}
}