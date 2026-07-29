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
public class ModelHumboldt<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("ror", "model_humboldt"), "main");
	public final ModelPart bone;
	public final ModelPart tentacle1;
	public final ModelPart tentacle2;
	public final ModelPart tentacle3;
	public final ModelPart tentacle4;

	public ModelHumboldt(ModelPart root) {
		this.bone = root.getChild("bone");
		this.tentacle1 = root.getChild("tentacle1");
		this.tentacle2 = root.getChild("tentacle2");
		this.tentacle3 = root.getChild("tentacle3");
		this.tentacle4 = root.getChild("tentacle4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bone = partdefinition.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(32, 2).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition tentacle1 = partdefinition.addOrReplaceChild("tentacle1", CubeListBuilder.create().texOffs(0, 14).addBox(-2.5F, 0.0F, -2.5F, 7.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.5F, 20.0F, 3.5F, 0.0F, -0.3927F, 0.0F));
		PartDefinition cube_r1 = tentacle1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(22, 23).addBox(2.5F, -1.5F, 1.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(9.5F, 2.0F, -2.5F, 0.0F, 0.0F, -1.5708F));
		PartDefinition cube_r2 = tentacle1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 23).addBox(0.0F, -3.0F, 0.5F, 7.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.5F, 4.0F, -2.5F, 0.0F, 0.0F, -0.6981F));
		PartDefinition tentacle2 = partdefinition.addOrReplaceChild("tentacle2", CubeListBuilder.create().texOffs(0, 14).addBox(-2.5F, 0.0F, -2.5F, 7.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.5F, 20.0F, -3.5F, 0.0F, 0.3927F, 0.0F));
		PartDefinition cube_r3 = tentacle2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(22, 23).addBox(2.5F, -1.5F, 1.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(9.5F, 2.0F, -2.5F, 0.0F, 0.0F, -1.5708F));
		PartDefinition cube_r4 = tentacle2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 23).addBox(0.0F, -3.0F, 0.5F, 7.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.5F, 4.0F, -2.5F, 0.0F, 0.0F, -0.6981F));
		PartDefinition tentacle3 = partdefinition.addOrReplaceChild("tentacle3", CubeListBuilder.create().texOffs(0, 14).addBox(-2.5F, 0.0F, -2.5F, 7.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.5F, 20.0F, -3.5F, 0.0F, 2.7489F, 0.0F));
		PartDefinition cube_r5 = tentacle3.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(22, 23).addBox(2.5F, -1.5F, 1.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(9.5F, 2.0F, -2.5F, 0.0F, 0.0F, -1.5708F));
		PartDefinition cube_r6 = tentacle3.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 23).addBox(0.0F, -3.0F, 0.5F, 7.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.5F, 4.0F, -2.5F, 0.0F, 0.0F, -0.6981F));
		PartDefinition tentacle4 = partdefinition.addOrReplaceChild("tentacle4", CubeListBuilder.create().texOffs(0, 14).addBox(-2.5F, 0.0F, -2.5F, 7.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.5F, 20.0F, 3.5F, 0.0F, -2.7489F, 0.0F));
		PartDefinition cube_r7 = tentacle4.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(22, 23).addBox(2.5F, -1.5F, 1.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(9.5F, 2.0F, -2.5F, 0.0F, 0.0F, -1.5708F));
		PartDefinition cube_r8 = tentacle4.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 23).addBox(0.0F, -3.0F, 0.5F, 7.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.5F, 4.0F, -2.5F, 0.0F, 0.0F, -0.6981F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		tentacle1.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		tentacle2.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		tentacle3.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		tentacle4.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}