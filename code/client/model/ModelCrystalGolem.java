package com.dreamcritting.ror.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
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

// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelCrystalGolem<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("ror", "model_crystal_golem"), "main");
	public final ModelPart head;
	public final ModelPart body;
	public final ModelPart arm1;
	public final ModelPart arm2;
	public final ModelPart leg1;
	public final ModelPart leg2;

	public ModelCrystalGolem(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.arm1 = root.getChild("arm1");
		this.arm2 = root.getChild("arm2");
		this.leg1 = root.getChild("leg1");
		this.leg2 = root.getChild("leg2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(28, 8)
				.addBox(0.0F, -16.0F, -4.0F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(16, 38).addBox(-4.0F, -16.0F, 0.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 16).addBox(-5.0F, -23.0F, -1.0F, 10.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, 0.0F));
		PartDefinition arm1 = partdefinition.addOrReplaceChild("arm1",
				CubeListBuilder.create().texOffs(32, 0).addBox(-5.0F, 3.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(22, 26).addBox(-6.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-5.0F, 1.0F, 1.0F));
		PartDefinition cube_r1 = arm1.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(16, 38).addBox(-6.0F, -8.0F, 3.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(28, 8).addBox(-2.0F, -8.0F, -1.0F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, -3.0F, -3.0F, 0.0F, 0.0F, -0.1745F));
		PartDefinition arm2 = partdefinition.addOrReplaceChild("arm2", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(1.0F, 3.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(22, 26).mirror()
				.addBox(0.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 1.0F, 1.0F));
		PartDefinition cube_r2 = arm2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(16, 38).addBox(-2.0F, -8.0F, 3.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -3.0F, -3.0F, 0.0F, 0.0F, 0.1745F));
		PartDefinition cube_r3 = arm2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(28, 8).mirror().addBox(0.0F, -8.0F, -1.0F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(3.0F, -3.0F, -3.0F, 0.0F, 0.0F, 0.1745F));
		PartDefinition leg1 = partdefinition.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 32).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 12.0F, 0.0F));
		PartDefinition leg2 = partdefinition.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(-2.0F, 0.0F, -1.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 12.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		arm1.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		arm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.leg1.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.leg2.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.arm1.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.arm2.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
	}
}