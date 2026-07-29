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
public class ModelRobotBoss2<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("ror", "model_robot_boss_2"), "main");
	public final ModelPart bone10;
	public final ModelPart bone9;
	public final ModelPart body;
	public final ModelPart leg1;
	public final ModelPart leg2;
	public final ModelPart arm1;
	public final ModelPart arm2;

	public ModelRobotBoss2(ModelPart root) {
		this.bone10 = root.getChild("bone10");
		this.bone9 = root.getChild("bone9");
		this.body = root.getChild("body");
		this.leg1 = root.getChild("leg1");
		this.leg2 = root.getChild("leg2");
		this.arm1 = root.getChild("arm1");
		this.arm2 = root.getChild("arm2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bone10 = partdefinition.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(72, 18).addBox(-2.0F, -10.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(72, 18)
				.addBox(14.0F, -10.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(72, 18).addBox(6.0F, -10.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -41.0F, 1.0F, -0.3491F, 0.0F, 0.0F));
		PartDefinition bone9 = partdefinition.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(72, 18).addBox(-2.0F, -10.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(72, 18)
				.addBox(14.0F, -10.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(72, 18).addBox(6.0F, -10.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -41.0F, -6.0F, -0.3491F, 0.0F, 0.0F));
		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 143).addBox(-12.0F, -45.0F, -12.0F, 24.0F, 11.0F, 22.0F, new CubeDeformation(0.0F)).texOffs(0, 96).addBox(-14.0F, -67.0F, -13.0F, 28.0F, 23.0F, 24.0F, new CubeDeformation(0.0F)).texOffs(214, 0)
						.addBox(-10.0F, -66.0F, -15.0F, 20.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(232, 0).mirror().addBox(10.0F, -66.0F, -15.0F, 2.0F, 21.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(232, 0)
						.addBox(-12.0F, -66.0F, -15.0F, 2.0F, 21.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(214, 0).addBox(-10.0F, -47.0F, -15.0F, 20.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition leg1 = partdefinition.addOrReplaceChild("leg1",
				CubeListBuilder.create().texOffs(0, 228).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(3.0F, 31.0F, -6.0F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-1.0F, 31.0F, -6.0F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-5.0F, 31.0F, -6.0F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-12.0F, -12.0F, -1.0F, -0.1309F, 0.0F, 0.0F));
		PartDefinition cube_r1 = leg1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 59).addBox(-6.0F, -3.5F, -4.0F, 12.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 34.0F, 0.0F, 0.1309F, 0.0F, 0.0F));
		PartDefinition cube_r2 = leg1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 196).addBox(-4.0F, 11.0F, -3.0F, 8.0F, 21.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.3058F, -4.5106F, 0.2618F, 0.0F, 0.0F));
		PartDefinition leg2 = partdefinition.addOrReplaceChild("leg2",
				CubeListBuilder.create().texOffs(0, 228).mirror().addBox(-5.0F, -5.0F, -5.0F, 10.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).addBox(3.0F, 31.0F, -6.0F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
						.texOffs(0, 0).addBox(-1.0F, 31.0F, -6.0F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-5.0F, 31.0F, -6.0F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(12.0F, -12.0F, -1.0F, -0.1309F, 0.0F, 0.0F));
		PartDefinition cube_r3 = leg2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 59).mirror().addBox(-6.0F, -3.5F, -4.0F, 12.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 34.0F, 0.0F, 0.1309F, 0.0F, 0.0F));
		PartDefinition cube_r4 = leg2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 196).mirror().addBox(-4.0F, 11.0F, -3.0F, 8.0F, 21.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.3058F, -4.5106F, 0.2618F, 0.0F, 0.0F));
		PartDefinition arm1 = partdefinition.addOrReplaceChild("arm1",
				CubeListBuilder.create().texOffs(146, 172).mirror().addBox(-5.0F, -5.0F, -5.0F, 10.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).mirror()
						.addBox(3.0F, 33.0F, -6.0F, 2.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(14, 0).mirror().addBox(3.0F, 29.0F, 10.0F, 2.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(34, 0).mirror()
						.addBox(3.0F, 41.0F, 8.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(34, 0).mirror().addBox(3.0F, 45.0F, -6.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(34, 0).mirror()
						.addBox(-1.0F, 45.0F, -6.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(34, 0).mirror().addBox(-5.0F, 45.0F, -6.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).mirror()
						.addBox(-1.0F, 33.0F, -6.0F, 2.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).mirror().addBox(-5.0F, 33.0F, -6.0F, 2.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-18.0F, -36.0F, -1.0F, -0.2618F, 0.3491F, 0.3491F));
		PartDefinition cube_r5 = arm1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(111, 77).mirror().addBox(-6.0F, -3.0F, -8.0F, 12.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 32.0073F, 3.5042F, 0.4363F, 0.0F, 0.0F));
		PartDefinition cube_r6 = arm1.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(172, 101).mirror().addBox(-4.0F, -10.5F, -4.0F, 8.0F, 21.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 20.8985F, 2.9083F, 0.3054F, 0.0F, 0.0F));
		PartDefinition arm2 = partdefinition.addOrReplaceChild("arm2",
				CubeListBuilder.create().texOffs(146, 172).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(3.0F, 33.0F, -6.0F, 2.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(14, 0)
						.addBox(-5.0F, 29.0F, 10.0F, 2.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(34, 0).addBox(-5.0F, 41.0F, 8.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(34, 0)
						.addBox(3.0F, 45.0F, -6.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(34, 0).addBox(-1.0F, 45.0F, -6.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(34, 0)
						.addBox(-5.0F, 45.0F, -6.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-1.0F, 33.0F, -6.0F, 2.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-5.0F, 33.0F, -6.0F, 2.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(17.0F, -36.0F, -1.0F, -0.2618F, -0.3491F, -0.3491F));
		PartDefinition cube_r7 = arm2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(111, 77).addBox(-6.0F, -3.0F, -8.0F, 12.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 32.0073F, 3.5042F, 0.4363F, 0.0F, 0.0F));
		PartDefinition cube_r8 = arm2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(172, 101).addBox(-4.0F, -10.5F, -4.0F, 8.0F, 21.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 20.8985F, 2.9083F, 0.3054F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		bone10.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		bone9.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		arm1.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		arm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.leg1.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.leg2.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.arm1.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.arm2.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
	}
}