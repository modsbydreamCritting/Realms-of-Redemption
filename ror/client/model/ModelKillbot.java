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
public class ModelKillbot<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("ror", "model_killbot"), "main");
	public final ModelPart body;
	public final ModelPart bone9;
	public final ModelPart bone10;
	public final ModelPart bone11;
	public final ModelPart arm1;
	public final ModelPart armpart1;
	public final ModelPart hand1;
	public final ModelPart fingers1;
	public final ModelPart thumb1;
	public final ModelPart arm2;
	public final ModelPart bone7;
	public final ModelPart hand2;
	public final ModelPart fingers2;
	public final ModelPart thumb2;
	public final ModelPart leg1;
	public final ModelPart legpart1;
	public final ModelPart foot1;
	public final ModelPart leg2;
	public final ModelPart legpart2;
	public final ModelPart foot2;

	public ModelKillbot(ModelPart root) {
		this.body = root.getChild("body");
		this.bone9 = this.body.getChild("bone9");
		this.bone10 = this.body.getChild("bone10");
		this.bone11 = this.body.getChild("bone11");
		this.arm1 = this.body.getChild("arm1");
		this.armpart1 = this.arm1.getChild("armpart1");
		this.hand1 = this.armpart1.getChild("hand1");
		this.fingers1 = this.hand1.getChild("fingers1");
		this.thumb1 = this.hand1.getChild("thumb1");
		this.arm2 = this.body.getChild("arm2");
		this.bone7 = this.arm2.getChild("bone7");
		this.hand2 = this.bone7.getChild("hand2");
		this.fingers2 = this.hand2.getChild("fingers2");
		this.thumb2 = this.hand2.getChild("thumb2");
		this.leg1 = root.getChild("leg1");
		this.legpart1 = this.leg1.getChild("legpart1");
		this.foot1 = this.legpart1.getChild("foot1");
		this.leg2 = root.getChild("leg2");
		this.legpart2 = this.leg2.getChild("legpart2");
		this.foot2 = this.legpart2.getChild("foot2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 143).addBox(-12.0F, -5.0F, -12.0F, 24.0F, 11.0F, 22.0F, new CubeDeformation(0.0F)).texOffs(0, 96).addBox(-14.0F, -27.0F, -13.0F, 28.0F, 23.0F, 24.0F, new CubeDeformation(0.0F)).texOffs(214, 0)
						.addBox(-10.0F, -26.0F, -15.0F, 20.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(232, 0).mirror().addBox(10.0F, -26.0F, -15.0F, 2.0F, 21.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(232, 0)
						.addBox(-12.0F, -26.0F, -15.0F, 2.0F, 21.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(214, 0).addBox(-10.0F, -7.0F, -15.0F, 20.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -16.0F, 0.0F));
		PartDefinition bone9 = body.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(72, 18).addBox(-2.0F, -10.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(72, 18)
				.addBox(14.0F, -10.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(72, 18).addBox(6.0F, -10.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -25.0F, -6.0F, -0.3491F, 0.0F, 0.0F));
		PartDefinition bone10 = body.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(72, 18).addBox(-2.0F, -10.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(72, 18)
				.addBox(14.0F, -10.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(72, 18).addBox(6.0F, -10.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -25.0F, 1.0F, -0.3491F, 0.0F, 0.0F));
		PartDefinition bone11 = body.addOrReplaceChild("bone11", CubeListBuilder.create().texOffs(72, 18).addBox(-2.0F, -10.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -25.0F, -6.0F, -0.3491F, 0.0F, 0.0F));
		PartDefinition arm1 = body.addOrReplaceChild("arm1", CubeListBuilder.create().texOffs(146, 172).mirror().addBox(-5.0F, -5.0F, -5.0F, 10.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-18.0F, -20.0F, -1.0F, -0.2618F, 0.3491F, 0.3491F));
		PartDefinition armpart1 = arm1.addOrReplaceChild("armpart1", CubeListBuilder.create().texOffs(172, 101).mirror().addBox(-4.0F, -2.0926F, -3.6014F, 8.0F, 21.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 13.0F, 0.0F, 0.3054F, 0.0F, 0.0F));
		PartDefinition hand1 = armpart1.addOrReplaceChild("hand1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 18.9148F, -0.0972F, 0.0436F, 0.0F, 0.0F));
		PartDefinition cube_r1 = hand1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(111, 77).mirror().addBox(-6.0F, -3.0F, -8.0F, 12.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, -0.0872F, -1.9981F, 0.0436F, 0.0F, 0.0F));
		PartDefinition fingers1 = hand1.addOrReplaceChild("fingers1",
				CubeListBuilder.create().texOffs(0, 0).mirror().addBox(3.0F, -1.4568F, -3.09F, 2.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(34, 0).mirror()
						.addBox(3.0F, 10.5432F, -3.09F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(34, 0).mirror().addBox(-1.0F, 10.5432F, -3.09F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(34, 0)
						.mirror().addBox(-5.0F, 10.5432F, -3.09F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).mirror().addBox(-1.0F, -1.4568F, -3.09F, 2.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(0, 0).mirror().addBox(-5.0F, -1.4568F, -3.09F, 2.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, -0.0872F, -8.9981F, -0.2618F, 0.0F, 0.0F));
		PartDefinition thumb1 = hand1.addOrReplaceChild("thumb1", CubeListBuilder.create().texOffs(14, 0).mirror().addBox(-1.0F, -1.2462F, 0.5921F, 2.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(34, 0).mirror()
				.addBox(-1.0F, 10.7538F, -1.4079F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, -0.0872F, 5.0019F, -0.4363F, 0.0F, 0.0F));
		PartDefinition arm2 = body.addOrReplaceChild("arm2", CubeListBuilder.create().texOffs(146, 172).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(17.0F, -20.0F, -1.0F, -0.2618F, -0.3491F, -0.3491F));
		PartDefinition bone7 = arm2.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(172, 101).addBox(-4.0F, -2.0926F, -3.6014F, 8.0F, 21.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 13.0F, 0.0F, 0.3054F, 0.0F, 0.0F));
		PartDefinition hand2 = bone7.addOrReplaceChild("hand2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 18.9148F, -2.0972F, 0.0873F, 0.0F, 0.0F));
		PartDefinition cube_r2 = hand2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(111, 77).addBox(-6.0F, -3.0F, -8.0F, 12.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0436F, 0.0F, 0.0F));
		PartDefinition fingers2 = hand2.addOrReplaceChild("fingers2",
				CubeListBuilder.create().texOffs(0, 0).addBox(3.0F, -1.4568F, -3.09F, 2.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(34, 0).addBox(3.0F, 10.5432F, -3.09F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(34, 0)
						.addBox(-1.0F, 10.5432F, -3.09F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(34, 0).addBox(-5.0F, 10.5432F, -3.09F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-1.0F, -1.4568F, -3.09F, 2.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-5.0F, -1.4568F, -3.09F, 2.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -7.0F, -0.2618F, 0.0F, 0.0F));
		PartDefinition thumb2 = hand2.addOrReplaceChild("thumb2",
				CubeListBuilder.create().texOffs(14, 0).addBox(-1.0F, -1.2462F, 0.5921F, 2.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(34, 0).addBox(-1.0F, 10.7538F, -1.4079F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0F, 0.0F, 7.0F, -0.4363F, 0.0F, 0.0F));
		PartDefinition leg1 = partdefinition.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 228).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-12.0F, -12.0F, -1.0F, -0.1309F, 0.0F, 0.0F));
		PartDefinition legpart1 = leg1.addOrReplaceChild("legpart1", CubeListBuilder.create().texOffs(0, 196).addBox(-4.0F, -2.0926F, -3.6014F, 8.0F, 21.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 13.0F, 0.0F, 0.3054F, 0.0F, 0.0F));
		PartDefinition foot1 = legpart1.addOrReplaceChild("foot1", CubeListBuilder.create().texOffs(0, 59).addBox(-6.0F, 0.0F, -10.0F, 12.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 17.8896F, 0.2991F, -0.1745F, 0.0F, 0.0F));
		PartDefinition cube_r3 = foot1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -3.5F, -1.5F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
				.addBox(-1.0F, -3.5F, -1.5F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(3.0F, -3.5F, -1.5F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 3.5178F, -10.4005F, -0.1745F, 0.0F, 0.0F));
		PartDefinition leg2 = partdefinition.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 228).mirror().addBox(-5.0F, -5.0F, -5.0F, 10.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(12.0F, -12.0F, -1.0F, -0.1309F, 0.0F, 0.0F));
		PartDefinition legpart2 = leg2.addOrReplaceChild("legpart2", CubeListBuilder.create().texOffs(0, 196).mirror().addBox(-4.0F, -4.0F, -3.0F, 8.0F, 21.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 15.0F, 0.0F, 0.3054F, 0.0F, 0.0F));
		PartDefinition foot2 = legpart2.addOrReplaceChild("foot2", CubeListBuilder.create().texOffs(0, 59).mirror().addBox(-6.0F, 0.0F, -10.0F, 12.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 15.9822F, 0.9005F, -0.1745F, 0.0F, 0.0F));
		PartDefinition cube_r4 = foot2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -3.5F, -1.5F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
				.addBox(-1.0F, -3.5F, -1.5F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(3.0F, -3.5F, -1.5F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 3.5178F, -10.4005F, -0.1745F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}