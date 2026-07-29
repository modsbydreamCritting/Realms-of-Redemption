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

// Made with Blockbench 4.11.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelUndercopter<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("ror", "model_undercopter"), "main");
	public final ModelPart spinny1;
	public final ModelPart not_spinning;
	public final ModelPart spinny2;

	public ModelUndercopter(ModelPart root) {
		this.spinny1 = root.getChild("spinny1");
		this.not_spinning = root.getChild("not_spinning");
		this.spinny2 = root.getChild("spinny2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition spinny1 = partdefinition.addOrReplaceChild("spinny1", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, 0.0F));
		PartDefinition not_spinning = partdefinition.addOrReplaceChild("not_spinning",
				CubeListBuilder.create().texOffs(32, 20).addBox(3.0F, -14.0F, -5.0F, 2.0F, 19.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(40, 3).addBox(2.0F, 12.0F, -6.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(40, 0)
						.addBox(0.0F, 14.0F, -5.0F, 8.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 36).addBox(3.0F, 14.0F, -8.0F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(20, 36)
						.addBox(5.0F, -10.0F, -5.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(43, 31).addBox(9.0F, -11.0F, -6.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(43, 31)
						.addBox(-4.0F, -11.0F, -6.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(22, 36).addBox(5.0F, -13.0F, -5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(22, 36)
						.addBox(1.0F, -13.0F, -5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(20, 36).addBox(-1.0F, -10.0F, -5.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-4.0F, 7.0F, 4.0F));
		PartDefinition spinny2 = partdefinition.addOrReplaceChild("spinny2", CubeListBuilder.create().texOffs(0, 20).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		spinny1.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		not_spinning.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		spinny2.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.spinny1.yRot = ageInTicks / 20.f;
		this.spinny2.yRot = ageInTicks / 20.f;
	}
}