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

// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelCrystalcopter2<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("ror", "model_crystalcopter_2"), "main");
	public final ModelPart bone;
	public final ModelPart spinny;

	public ModelCrystalcopter2(ModelPart root) {
		this.bone = root.getChild("bone");
		this.spinny = root.getChild("spinny");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -14.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition spinny = partdefinition.addOrReplaceChild("spinny", CubeListBuilder.create().texOffs(0, 29).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, 0.0F));
		PartDefinition cube_r1 = spinny.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 24).addBox(-16.0F, -1.0F, -2.0F, 16.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, -0.3927F, -0.7854F, 0.0F));
		PartDefinition cube_r2 = spinny.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 24).addBox(-16.0F, -1.0F, -2.0F, 16.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, -0.3927F, -1.5708F, 0.0F));
		PartDefinition cube_r3 = spinny.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 24).addBox(-16.0F, -1.0F, -2.0F, 16.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, -0.3927F, -2.3562F, 0.0F));
		PartDefinition cube_r4 = spinny.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 24).addBox(-16.0F, -1.0F, -2.0F, 16.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, -0.3927F, 3.1416F, 0.0F));
		PartDefinition cube_r5 = spinny.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 24).addBox(-16.0F, -1.0F, -2.0F, 16.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, -0.3927F, 2.3562F, 0.0F));
		PartDefinition cube_r6 = spinny.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 24).addBox(-16.0F, -1.0F, -2.0F, 16.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, -0.3927F, 1.5708F, 0.0F));
		PartDefinition cube_r7 = spinny.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 24).addBox(-16.0F, -1.0F, -2.0F, 16.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, -0.3927F, 0.7854F, 0.0F));
		PartDefinition cube_r8 = spinny.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 24).addBox(-16.0F, -1.0F, -2.0F, 16.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		spinny.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.spinny.yRot = ageInTicks;
	}
}