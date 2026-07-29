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

// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelMox4<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("ror", "model_mox_4"), "main");
	public final ModelPart wing1;
	public final ModelPart wing2;
	public final ModelPart bone2;
	public final ModelPart bone;
	public final ModelPart body;
	public final ModelPart head;
	public final ModelPart head2;
	public final ModelPart arm1;
	public final ModelPart arm2;
	public final ModelPart lenny_face;

	public ModelMox4(ModelPart root) {
		this.wing1 = root.getChild("wing1");
		this.wing2 = root.getChild("wing2");
		this.bone2 = root.getChild("bone2");
		this.bone = root.getChild("bone");
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.head2 = root.getChild("head2");
		this.arm1 = root.getChild("arm1");
		this.arm2 = root.getChild("arm2");
		this.lenny_face = root.getChild("lenny_face");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition wing1 = partdefinition.addOrReplaceChild("wing1", CubeListBuilder.create().texOffs(15, 76).addBox(-43.0F, -12.0F, -0.5F, 43.0F, 44.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -8.0F, 4.5F, 0.0F, 0.3054F, 0.0F));
		PartDefinition wing2 = partdefinition.addOrReplaceChild("wing2", CubeListBuilder.create().texOffs(15, 76).addBox(-43.0F, -12.0F, -0.5F, 43.0F, 44.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -8.0F, 4.5F, 0.0F, 2.8798F, 0.0F));
		PartDefinition bone2 = partdefinition.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(83, 48).addBox(-6.5F, -0.0036F, -0.9258F, 13.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 12.9951F, -0.7962F, 0.2618F, 0.0F, 0.0F));
		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(81, 29).addBox(-5.5F, -0.25F, -0.5F, 11.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 3.25F, -1.5F, 0.1309F, 0.0F, 0.0F));
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(66, 21).addBox(-5.0F, -27.0F, -1.0F, 10.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(2, 17)
				.addBox(-4.5F, -25.0F, -1.0F, 9.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 27).addBox(-5.0F, -34.0F, -1.0F, 10.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, 1.0F));
		PartDefinition head2 = partdefinition.addOrReplaceChild("head2", CubeListBuilder.create().texOffs(62, 2).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -10.0F, 1.0F));
		PartDefinition arm1 = partdefinition.addOrReplaceChild("arm1", CubeListBuilder.create().texOffs(44, 15).addBox(-2.0F, -1.0F, -1.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(52, 51)
				.addBox(-2.0F, 5.0F, -1.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(52, 43).addBox(-3.0F, 11.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-6.0F, -8.0F, 0.0F, -0.0433F, 0.0057F, 0.1308F));
		PartDefinition arm2 = partdefinition.addOrReplaceChild(
				"arm2", CubeListBuilder.create().texOffs(44, 15).mirror().addBox(-1.0F, -1.0F, -1.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(52, 51).mirror()
						.addBox(-1.0F, 5.0F, -1.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(52, 43).mirror().addBox(-1.0F, 11.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(6.0F, -8.0F, 0.0F, -0.0433F, -0.0057F, -0.1308F));
		PartDefinition lenny_face = partdefinition.addOrReplaceChild("lenny_face", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, -4.0F, -2.0F, -0.3927F, 0.0F, 0.0F));
		PartDefinition cube_r1 = lenny_face.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(52, 0).addBox(-3.7F, -5.0F, -1.0F, 5.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(7.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0436F));
		PartDefinition cube_r2 = lenny_face.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(13, 53).addBox(-3.3F, -5.0F, -1.0F, 5.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0873F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		wing1.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		wing2.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		bone2.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		head2.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		arm1.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		arm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		lenny_face.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.arm1.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.head2.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head2.xRot = headPitch / (180F / (float) Math.PI);
		this.arm2.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
	}
}