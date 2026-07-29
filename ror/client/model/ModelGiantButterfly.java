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
public class ModelGiantButterfly<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("ror", "model_giant_butterfly"), "main");
	public final ModelPart body;
	public final ModelPart wing1;
	public final ModelPart wing2;
	public final ModelPart head;
	public final ModelPart front_legs;
	public final ModelPart middle_legs;
	public final ModelPart back_legs;

	public ModelGiantButterfly(ModelPart root) {
		this.body = root.getChild("body");
		this.wing1 = this.body.getChild("wing1");
		this.wing2 = this.body.getChild("wing2");
		this.head = this.body.getChild("head");
		this.front_legs = this.body.getChild("front_legs");
		this.middle_legs = this.body.getChild("middle_legs");
		this.back_legs = this.body.getChild("back_legs");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 130).addBox(-4.0F, -8.0F, -10.0F, 8.0F, 8.0F, 24.0F, new CubeDeformation(0.0F))
				.texOffs(30, 104).addBox(-3.0F, -7.0F, 12.0F, 6.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, 0.0F));

		PartDefinition wing1 = body.addOrReplaceChild("wing1", CubeListBuilder.create(), PartPose.offset(1.0F, -8.0F, 0.0F));

		PartDefinition cube_r1 = wing1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(1, 23).addBox(-57.0F, 0.0F, -1.0F, 58.0F, 0.1F, 77.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(57.0F, 0.0F, 41.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition wing2 = body.addOrReplaceChild("wing2", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.0F, -8.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r2 = wing2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(1, 24).addBox(0.0F, -0.2F, -41.0F, 58.0F, 0.1F, 77.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 1.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(98, 114).addBox(-5.0F, -3.0F, -6.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -3.0F, -10.0F));

		PartDefinition cube_r3 = head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(73, 105).addBox(-1.0F, 1.0F, -7.0F, 2.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -4.0F, -5.0F, -0.2182F, 0.1309F, 0.0F));

		PartDefinition cube_r4 = head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(73, 105).addBox(-1.0F, 1.0F, -7.0F, 2.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -5.0F, -0.2182F, -0.1309F, 0.0F));

		PartDefinition front_legs = body.addOrReplaceChild("front_legs", CubeListBuilder.create(), PartPose.offset(4.0F, 0.0F, -5.0F));

		PartDefinition cube_r5 = front_legs.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 116).addBox(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 6.0F, 4.0F, 0.5236F, 0.0F, 0.3927F));

		PartDefinition cube_r6 = front_legs.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 116).addBox(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 4.0F, 0.5236F, 0.0F, -0.3927F));

		PartDefinition middle_legs = body.addOrReplaceChild("middle_legs", CubeListBuilder.create(), PartPose.offset(4.0F, 0.0F, -1.0F));

		PartDefinition cube_r7 = middle_legs.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 116).addBox(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 5.0F, 5.0F, 0.7854F, 0.0F, 0.3491F));

		PartDefinition cube_r8 = middle_legs.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 116).addBox(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 5.0F, 0.7854F, 0.0F, -0.3491F));

		PartDefinition back_legs = body.addOrReplaceChild("back_legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 3.0F));

		PartDefinition cube_r9 = back_legs.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 116).addBox(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 5.0F, 6.0F, 0.8727F, 0.0F, 0.3054F));

		PartDefinition cube_r10 = back_legs.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 116).addBox(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 5.0F, 6.0F, 0.8727F, 0.0F, -0.3054F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}