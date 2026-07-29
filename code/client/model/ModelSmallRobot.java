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
public class ModelSmallRobot<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("ror", "model_small_robot"), "main");
	public final ModelPart bone;
	public final ModelPart leg1;
	public final ModelPart leg2;
	public final ModelPart head;
	public final ModelPart arm1;
	public final ModelPart arm2;

	public ModelSmallRobot(ModelPart root) {
		this.bone = root.getChild("bone");
		this.leg1 = root.getChild("leg1");
		this.leg2 = root.getChild("leg2");
		this.head = root.getChild("head");
		this.arm1 = root.getChild("arm1");
		this.arm2 = root.getChild("arm2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bone = partdefinition.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(0, 48).addBox(-4.0F, -15.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(19, 25).addBox(1.0F, -10.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(19, 25)
						.addBox(1.0F, -14.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(19, 25).addBox(-3.0F, -14.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(19, 25)
						.addBox(-3.0F, -10.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(12, 37).addBox(4.0F, -15.0F, -5.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 37).mirror()
						.addBox(-5.0F, -15.0F, -5.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(12, 37).mirror().addBox(-5.0F, -15.0F, 4.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(12, 37)
						.addBox(4.0F, -15.0F, 4.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-5.0F, -16.0F, -5.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(26, 47).addBox(-2.0F, -19.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 20.0F, 0.0F));
		PartDefinition leg1 = partdefinition.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 26).addBox(-1.0F, -1.25F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(48, 58)
				.addBox(-2.0F, 8.75F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(48, 47).addBox(-2.0F, 3.75F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 13.25F, 0.0F));
		PartDefinition leg2 = partdefinition.addOrReplaceChild("leg2",
				CubeListBuilder.create().texOffs(0, 26).mirror().addBox(-1.0F, -1.25F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(48, 58).mirror()
						.addBox(-2.0F, 8.75F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(48, 47).mirror().addBox(-2.0F, 3.75F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(-5.0F, 13.25F, 0.0F));
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(40, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 0.0F));
		PartDefinition arm1 = partdefinition.addOrReplaceChild("arm1",
				CubeListBuilder.create().texOffs(35, 40).addBox(-1.0F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(31, 0).addBox(3.0F, 1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(48, 33)
						.addBox(2.0F, 7.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(48, 17).addBox(2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(5.0F, 4.0F, 0.0F));
		PartDefinition arm2 = partdefinition.addOrReplaceChild("arm2",
				CubeListBuilder.create().texOffs(48, 17).mirror().addBox(-5.0F, -4.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(48, 33).mirror().addBox(-5.0F, 5.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
						.mirror(false).texOffs(31, 0).mirror().addBox(-4.0F, -1.0F, 0.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(35, 40).mirror().addBox(-2.0F, -3.0F, 0.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
						.mirror(false),
				PartPose.offset(-6.0F, 6.0F, -1.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		arm1.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		arm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.leg1.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.leg2.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.arm1.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.arm2.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
	}
}