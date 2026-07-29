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
public class ModelMox5<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("ror", "model_mox_5"), "main");
	public final ModelPart body;
	public final ModelPart head;
	public final ModelPart head3;
	public final ModelPart head4;
	public final ModelPart head2;
	public final ModelPart arm1;
	public final ModelPart arm2;
	public final ModelPart lenny_face;

	public ModelMox5(ModelPart root) {
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.head3 = root.getChild("head3");
		this.head4 = root.getChild("head4");
		this.head2 = root.getChild("head2");
		this.arm1 = root.getChild("arm1");
		this.arm2 = root.getChild("arm2");
		this.lenny_face = root.getChild("lenny_face");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(60, 31).addBox(-6.0F, -27.0F, -1.0F, 12.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(60, 20).addBox(-5.5F, -24.0F, -1.0F, 11.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(0, 40)
						.addBox(-7.5F, -12.0F, -3.0F, 15.0F, 7.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(0, 20).addBox(-8.5F, -5.0F, -4.0F, 17.0F, 7.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-9.5F, 2.0F, -5.0F, 19.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(52, 40).addBox(-6.5F, -20.0F, -2.0F, 13.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 58)
						.addBox(-6.0F, -34.0F, -1.0F, 12.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 18.0F, 0.0F));
		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(52, 57).addBox(-6.0F, -22.0F, -4.0F, 10.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(70, 0).addBox(-5.0F, -23.0F, -4.0F, 8.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.0F, -3.0F, 1.0F));
		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(74, 99).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-6.0F, -13.0F, 4.0F, 0.3054F, 0.0873F, 0.2182F));
		PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(16, 95).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-7.0F, -13.0F, -1.0F, 0.1309F, 0.0F, 0.2182F));
		PartDefinition cube_r3 = head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(62, 99).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-6.0F, -18.0F, -2.0F, 0.1309F, 0.0F, 0.2182F));
		PartDefinition head3 = partdefinition.addOrReplaceChild("head3", CubeListBuilder.create(), PartPose.offsetAndRotation(5.0F, -24.5F, -2.5F, 0.0F, 0.0F, -0.7854F));
		PartDefinition cube_r4 = head3.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(88, 85).addBox(-3.5F, -4.0F, -2.0F, 5.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-9.5F, -1.7606F, 9.4432F, 0.3927F, -0.48F, 0.9163F));
		PartDefinition cube_r5 = head3.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 97).addBox(-3.5F, -4.0F, -2.0F, 5.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.5F, 1.2394F, 10.4432F, 0.3927F, -0.0436F, 0.7854F));
		PartDefinition cube_r6 = head3.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(102, 95).addBox(-1.5F, -4.0F, -2.0F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.5F, 2.2394F, 10.4432F, 0.3054F, 0.0F, 0.3491F));
		PartDefinition cube_r7 = head3.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(96, 19).addBox(-2.7071F, -3.8558F, 6.8792F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 2.5F, -1.5F, 0.0436F, 0.0F, 0.0F));
		PartDefinition cube_r8 = head3.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(88, 95).addBox(-2.0F, -5.6264F, 2.987F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 2.5F, -1.5F, -0.0873F, 0.0F, -0.0436F));
		PartDefinition cube_r9 = head3.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(96, 29).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, -2.5F, 0.5F, -0.4363F, -0.0436F, -0.7418F));
		PartDefinition cube_r10 = head3.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(92, 68).addBox(-2.0F, -4.0F, -0.5F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.5F, -0.5F, -0.3491F, 0.0436F, -0.6109F));
		PartDefinition cube_r11 = head3.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(34, 92).addBox(-2.0F, -7.0F, -1.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 2.5F, -1.5F, -0.2618F, -0.0436F, 0.0436F));
		PartDefinition head4 = partdefinition.addOrReplaceChild("head4", CubeListBuilder.create().texOffs(48, 92).addBox(-2.0F, -4.5F, -1.5F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(7.0F, -19.5F, -3.5F, 0.0F, 0.0F, -0.3054F));
		PartDefinition cube_r12 = head4.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(96, 39).addBox(-0.9947F, -1.9641F, 6.0574F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 1.5F, 0.5F, 0.3054F, 0.0F, 0.0F));
		PartDefinition cube_r13 = head4.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(92, 57).addBox(-1.347F, -5.7646F, 2.7822F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 2.5F, 0.5F, 0.1745F, 0.0F, 0.0F));
		PartDefinition head2 = partdefinition.addOrReplaceChild("head2", CubeListBuilder.create(), PartPose.offset(0.0F, -16.0F, 1.0F));
		PartDefinition arm1 = partdefinition.addOrReplaceChild("arm1", CubeListBuilder.create().texOffs(0, 106).addBox(-5.0F, -1.0F, -2.0F, 5.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(22, 106)
				.addBox(-4.0F, 5.0F, -1.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(70, 10).addBox(-5.0F, 14.0F, -1.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-6.0F, -15.0F, 0.0F, -0.0436F, 0.0F, 0.1309F));
		PartDefinition arm2 = partdefinition.addOrReplaceChild(
				"arm2", CubeListBuilder.create().texOffs(0, 106).mirror().addBox(0.0F, -1.0F, -2.0F, 5.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(22, 106).mirror()
						.addBox(0.0F, 5.0F, -1.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(70, 10).mirror().addBox(0.0F, 14.0F, -1.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(6.0F, -15.0F, 0.0F, -0.0436F, 0.0F, -0.1309F));
		PartDefinition lenny_face = partdefinition.addOrReplaceChild("lenny_face", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, -11.0F, -2.0F, -0.3927F, 0.0F, 0.0F));
		PartDefinition cube_r14 = lenny_face.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(88, 10).addBox(-4.7F, -6.0F, -1.0F, 6.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(8.0F, 1.0F, 0.0F, 0.0F, 0.0F, -0.0436F));
		PartDefinition cube_r15 = lenny_face.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(16, 86).addBox(-4.3F, -6.0F, -1.0F, 6.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0436F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		head3.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		head4.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
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
		this.head3.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head3.xRot = headPitch / (180F / (float) Math.PI);
		this.arm2.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.head4.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head4.xRot = headPitch / (180F / (float) Math.PI);
	}
}