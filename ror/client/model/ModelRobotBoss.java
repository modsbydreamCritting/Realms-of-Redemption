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
public class ModelRobotBoss<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("ror", "model_robot_boss"), "main");
	public final ModelPart body;
	public final ModelPart bone9;
	public final ModelPart bone10;
	public final ModelPart bone11;
	public final ModelPart leg1;
	public final ModelPart bone;
	public final ModelPart bone2;
	public final ModelPart leg2;
	public final ModelPart bone3;
	public final ModelPart bone4;
	public final ModelPart leg3;
	public final ModelPart bone5;
	public final ModelPart bone6;
	public final ModelPart leg4;
	public final ModelPart bone7;
	public final ModelPart bone8;

	public ModelRobotBoss(ModelPart root) {
		this.body = root.getChild("body");
		this.bone9 = root.getChild("bone9");
		this.bone10 = root.getChild("bone10");
		this.bone11 = root.getChild("bone11");
		this.leg1 = root.getChild("leg1");
		this.bone = root.getChild("bone");
		this.bone2 = root.getChild("bone2");
		this.leg2 = root.getChild("leg2");
		this.bone3 = root.getChild("bone3");
		this.bone4 = root.getChild("bone4");
		this.leg3 = root.getChild("leg3");
		this.bone5 = root.getChild("bone5");
		this.bone6 = root.getChild("bone6");
		this.leg4 = root.getChild("leg4");
		this.bone7 = root.getChild("bone7");
		this.bone8 = root.getChild("bone8");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 143).addBox(-12.0F, -45.0F, -12.0F, 24.0F, 11.0F, 22.0F, new CubeDeformation(0.0F)).texOffs(0, 96).addBox(-14.0F, -67.0F, -13.0F, 28.0F, 23.0F, 24.0F, new CubeDeformation(0.0F)).texOffs(214, 0)
						.addBox(-10.0F, -66.0F, -15.0F, 20.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(232, 0).mirror().addBox(10.0F, -66.0F, -15.0F, 2.0F, 21.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(232, 0)
						.addBox(-12.0F, -66.0F, -15.0F, 2.0F, 21.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(214, 0).addBox(-10.0F, -47.0F, -15.0F, 20.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition bone9 = body.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(72, 18).addBox(-2.0F, -10.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(72, 18)
				.addBox(14.0F, -10.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(72, 18).addBox(6.0F, -10.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -65.0F, -6.0F, -0.3491F, 0.0F, 0.0F));
		PartDefinition bone10 = body.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(72, 18).addBox(-2.0F, -10.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(72, 18)
				.addBox(14.0F, -10.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(72, 18).addBox(6.0F, -10.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -65.0F, 1.0F, -0.3491F, 0.0F, 0.0F));
		PartDefinition bone11 = body.addOrReplaceChild("bone11", CubeListBuilder.create().texOffs(72, 18).addBox(-2.0F, -10.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -65.0F, -6.0F, -0.3491F, 0.0F, 0.0F));
		PartDefinition leg1 = partdefinition.addOrReplaceChild("leg1",
				CubeListBuilder.create().texOffs(0, 228).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(3.0F, 31.0F, -6.0F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-1.0F, 31.0F, -6.0F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-5.0F, 31.0F, -6.0F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-12.0F, -12.0F, -1.0F, -0.1309F, 0.0F, 0.0F));
		PartDefinition bone = leg1.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 196).addBox(-4.0F, -4.0F, -3.0F, 8.0F, 21.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 0.0F, 0.3054F, 0.0F, 0.0F));
		PartDefinition bone2 = leg1.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 59).addBox(-6.0F, -3.5F, -4.0F, 12.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 34.0F, 0.0F, 0.1309F, 0.0F, 0.0F));
		PartDefinition leg2 = partdefinition.addOrReplaceChild("leg2",
				CubeListBuilder.create().texOffs(0, 228).mirror().addBox(-5.0F, -5.0F, -5.0F, 10.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).addBox(3.0F, 31.0F, -6.0F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
						.texOffs(0, 0).addBox(-1.0F, 31.0F, -6.0F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-5.0F, 31.0F, -6.0F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(12.0F, -12.0F, -1.0F, -0.1309F, 0.0F, 0.0F));
		PartDefinition bone3 = leg2.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(0, 196).mirror().addBox(-4.0F, -4.0F, -3.0F, 8.0F, 21.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 15.0F, 0.0F, 0.3054F, 0.0F, 0.0F));
		PartDefinition bone4 = leg2.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(0, 59).mirror().addBox(-6.0F, -3.5F, -4.0F, 12.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 34.0F, 0.0F, 0.1309F, 0.0F, 0.0F));
		PartDefinition leg3 = partdefinition.addOrReplaceChild("leg3",
				CubeListBuilder.create().texOffs(146, 172).mirror().addBox(-5.0F, -5.0F, -5.0F, 10.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).mirror()
						.addBox(3.0F, 33.0F, -6.0F, 2.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(14, 0).mirror().addBox(3.0F, 29.0F, 10.0F, 2.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(34, 0).mirror()
						.addBox(3.0F, 41.0F, 8.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(34, 0).mirror().addBox(3.0F, 45.0F, -6.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(34, 0).mirror()
						.addBox(-1.0F, 45.0F, -6.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(34, 0).mirror().addBox(-5.0F, 45.0F, -6.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).mirror()
						.addBox(-1.0F, 33.0F, -6.0F, 2.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).mirror().addBox(-5.0F, 33.0F, -6.0F, 2.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-18.0F, -36.0F, -1.0F, -0.2618F, 0.3491F, 0.3491F));
		PartDefinition bone5 = leg3.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(172, 101).mirror().addBox(-4.0F, -4.0F, -3.0F, 8.0F, 21.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 15.0F, 0.0F, 0.3054F, 0.0F, 0.0F));
		PartDefinition bone6 = leg3.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(111, 77).mirror().addBox(-6.0F, -3.5F, -4.0F, 12.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 34.0F, 0.0F, 0.3927F, 0.0F, 0.0F));
		PartDefinition leg4 = partdefinition.addOrReplaceChild("leg4",
				CubeListBuilder.create().texOffs(146, 172).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(3.0F, 33.0F, -6.0F, 2.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(14, 0)
						.addBox(-5.0F, 29.0F, 10.0F, 2.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(34, 0).addBox(-5.0F, 41.0F, 8.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(34, 0)
						.addBox(3.0F, 45.0F, -6.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(34, 0).addBox(-1.0F, 45.0F, -6.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(34, 0)
						.addBox(-5.0F, 45.0F, -6.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-1.0F, 33.0F, -6.0F, 2.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-5.0F, 33.0F, -6.0F, 2.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(17.0F, -36.0F, -1.0F, -0.2618F, -0.3491F, -0.3491F));
		PartDefinition bone7 = leg4.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(172, 101).addBox(-4.0F, -4.0F, -3.0F, 8.0F, 21.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 0.0F, 0.3054F, 0.0F, 0.0F));
		PartDefinition bone8 = leg4.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(111, 77).addBox(-6.0F, -3.5F, -4.0F, 12.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 34.0F, 0.0F, 0.3927F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.leg1.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.leg4.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.leg2.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.leg3.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}