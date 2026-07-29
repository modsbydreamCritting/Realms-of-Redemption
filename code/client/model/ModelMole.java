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
public class ModelMole<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("ror", "model_mole"), "main");
	public final ModelPart bone;
	public final ModelPart head;
	public final ModelPart nose;
	public final ModelPart leg1;
	public final ModelPart leg2;
	public final ModelPart leg3;
	public final ModelPart leg4;

	public ModelMole(ModelPart root) {
		this.bone = root.getChild("bone");
		this.head = root.getChild("head");
		this.nose = this.head.getChild("nose");
		this.leg1 = root.getChild("leg1");
		this.leg2 = root.getChild("leg2");
		this.leg3 = root.getChild("leg3");
		this.leg4 = root.getChild("leg4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(44, 72).addBox(-8.0F, -14.0F, 22.0F, 16.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 9)
				.addBox(-4.0F, -9.0F, 26.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-12.0F, -16.0F, -14.0F, 24.0F, 16.0F, 36.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 52).addBox(-8.0F, -6.5F, -8.0F, 16.0F, 13.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.5F, -14.0F));
		PartDefinition nose = head.addOrReplaceChild("nose",
				CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -3.5F, -4.0F, 12.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(24, 17).addBox(2.0F, -5.5F, -4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(24, 13)
						.addBox(-4.0F, -5.5F, -4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(20, 9).addBox(2.0F, 3.5F, -4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(20, 9).mirror()
						.addBox(-4.0F, 3.5F, -4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(14, 21).addBox(-4.0F, -2.5F, -2.0F, 8.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, -8.0F));
		PartDefinition leg1 = partdefinition.addOrReplaceChild("leg1",
				CubeListBuilder.create().texOffs(48, 52).addBox(0.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(54, 52).addBox(-4.0F, -5.0F, -5.0F, 4.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(12.0F, 19.0F, -6.0F, 0.0F, 0.4363F, 0.0F));
		PartDefinition cube_r1 = leg1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 73).addBox(-1.0F, 2.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 21)
				.addBox(-1.0F, -4.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(14, 75).addBox(-1.0F, -1.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, 0.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
		PartDefinition leg2 = partdefinition.addOrReplaceChild("leg2",
				CubeListBuilder.create().texOffs(48, 52).addBox(-0.2249F, -4.2918F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(48, 52).addBox(-10.2249F, -4.2918F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(12.0F, 18.0F, 17.0F, -0.3927F, 0.0F, 0.2618F));
		PartDefinition cube_r2 = leg2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 73).addBox(-1.0F, 2.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 21)
				.addBox(-1.0F, -4.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(14, 75).addBox(-1.0F, -1.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(10.7751F, 0.7082F, 0.0F, 0.0F, 0.3927F, 0.0F));
		PartDefinition leg3 = partdefinition.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(48, 52).mirror().addBox(-10.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(48, 52).mirror()
				.addBox(0.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-12.0F, 18.0F, 17.0F, -0.3927F, 0.0F, -0.2618F));
		PartDefinition cube_r3 = leg3.addOrReplaceChild(
				"cube_r3", CubeListBuilder.create().texOffs(0, 73).mirror().addBox(-1.0F, 2.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 21).mirror()
						.addBox(-1.0F, -4.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(14, 75).mirror().addBox(-1.0F, -1.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-11.0F, 0.0F, 0.0F, 0.0F, -0.3927F, 0.0F));
		PartDefinition leg4 = partdefinition.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(48, 52).mirror().addBox(-10.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(54, 52).mirror()
				.addBox(0.0F, -5.0F, -5.0F, 4.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-12.0F, 19.0F, -6.0F, 0.0F, -0.4363F, 0.0F));
		PartDefinition cube_r4 = leg4.addOrReplaceChild(
				"cube_r4", CubeListBuilder.create().texOffs(0, 73).mirror().addBox(-1.0F, 2.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 21).mirror()
						.addBox(-1.0F, -4.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(14, 75).mirror().addBox(-1.0F, -1.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-11.0F, 0.0F, 0.0F, 0.0F, -0.3491F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}