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
public class ModelCorrundodile<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("ror", "model_corrundodile"), "main");
	public final ModelPart body;
	public final ModelPart tailpart1;
	public final ModelPart tail1;
	public final ModelPart head;
	public final ModelPart upper_jaw;
	public final ModelPart upperteeth;
	public final ModelPart lower_jaw;
	public final ModelPart neck;
	public final ModelPart leg1;
	public final ModelPart legpart1;
	public final ModelPart foot1;
	public final ModelPart leg3;
	public final ModelPart legpart3;
	public final ModelPart foot3;
	public final ModelPart leg2;
	public final ModelPart legpart2;
	public final ModelPart foot2;
	public final ModelPart leg4;
	public final ModelPart legpart4;
	public final ModelPart foot4;

	public ModelCorrundodile(ModelPart root) {
		this.body = root.getChild("body");
		this.tailpart1 = this.body.getChild("tailpart1");
		this.tail1 = this.tailpart1.getChild("tail1");
		this.head = this.body.getChild("head");
		this.upper_jaw = this.head.getChild("upper_jaw");
		this.upperteeth = this.upper_jaw.getChild("upperteeth");
		this.lower_jaw = this.head.getChild("lower_jaw");
		this.neck = this.head.getChild("neck");
		this.leg1 = this.body.getChild("leg1");
		this.legpart1 = this.leg1.getChild("legpart1");
		this.foot1 = this.legpart1.getChild("foot1");
		this.leg3 = this.body.getChild("leg3");
		this.legpart3 = this.leg3.getChild("legpart3");
		this.foot3 = this.legpart3.getChild("foot3");
		this.leg2 = root.getChild("leg2");
		this.legpart2 = this.leg2.getChild("legpart2");
		this.foot2 = this.legpart2.getChild("foot2");
		this.leg4 = root.getChild("leg4");
		this.legpart4 = this.leg4.getChild("legpart4");
		this.foot4 = this.legpart4.getChild("foot4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 0).addBox(-16.0F, -14.0F, -30.0F, 32.0F, 32.0F, 32.0F, new CubeDeformation(0.0F)).texOffs(96, 0).addBox(-11.0F, -16.0F, -25.0F, 22.0F, 2.0F, 22.0F, new CubeDeformation(0.0F)).texOffs(32, 175)
						.addBox(-10.02F, -32.0F, -32.5F, 0.02F, 16.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(31, 191).addBox(-17.5F, -32.0F, -24.0F, 16.0F, 16.0F, 0.02F, new CubeDeformation(0.0F)).texOffs(31, 191)
						.addBox(2.5F, -32.0F, -24.0F, 16.0F, 16.0F, 0.02F, new CubeDeformation(0.0F)).texOffs(31, 175).addBox(9.98F, -32.0F, -32.5F, 0.02F, 16.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(31, 175)
						.addBox(9.98F, -32.0F, -12.5F, 0.02F, 16.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(31, 191).addBox(2.5F, -32.0F, -4.0F, 16.0F, 16.0F, 0.02F, new CubeDeformation(0.0F)).texOffs(31, 191)
						.addBox(-17.5F, -32.0F, -4.0F, 16.0F, 16.0F, 0.02F, new CubeDeformation(0.0F)).texOffs(31, 175).addBox(-10.02F, -32.0F, -12.5F, 0.02F, 16.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 6.0F, 22.0F));
		PartDefinition tailpart1 = body.addOrReplaceChild("tailpart1",
				CubeListBuilder.create().texOffs(0, 64).addBox(-13.0F, -10.0F, 2.0F, 26.0F, 28.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(31, 175).addBox(-10.02F, -26.0F, 6.5F, 0.02F, 16.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(31, 191)
						.addBox(-17.5F, -26.0F, 15.0F, 16.0F, 16.0F, 0.02F, new CubeDeformation(0.0F)).texOffs(31, 191).addBox(2.5F, -26.0F, 15.0F, 16.0F, 16.0F, 0.02F, new CubeDeformation(0.0F)).texOffs(31, 175)
						.addBox(9.98F, -26.0F, 6.5F, 0.02F, 16.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition tail1 = tailpart1.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(76, 118).addBox(-10.0F, -10.0F, 0.0F, 20.0F, 20.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 18.0F));
		PartDefinition head = body.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 118).addBox(-14.0F, -18.0F, -10.0F, 28.0F, 28.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(158, 60).mirror().addBox(9.0F, -20.0F, -12.0F, 7.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(158, 60).addBox(-16.0F, -20.0F, -12.0F, 7.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(18, 25).addBox(10.0F, -19.0F, -13.0F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(18, 25)
						.addBox(-15.0F, -19.0F, -13.0F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 8.0F, -30.0F));
		PartDefinition upper_jaw = head.addOrReplaceChild("upper_jaw",
				CubeListBuilder.create().texOffs(84, 64).addBox(-13.0F, -4.0F, -22.0F, 26.0F, 5.0F, 22.0F, new CubeDeformation(0.0F)).texOffs(142, 121).addBox(10.9F, 1.0F, -22.0F, 3.0F, 3.0F, 22.0F, new CubeDeformation(0.0F)).texOffs(136, 96)
						.addBox(-14.0F, 1.0F, -22.0F, 3.1F, 3.0F, 22.0F, new CubeDeformation(0.0F)).texOffs(128, 49).addBox(-12.0F, -2.0F, -27.0F, 24.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -4.0F, -9.0F, -0.1745F, 0.0F, 0.0F));
		PartDefinition upperteeth = upper_jaw.addOrReplaceChild("upperteeth",
				CubeListBuilder.create().texOffs(21, 17).addBox(11.0F, -12.9552F, -5.227F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(21, 17).addBox(11.0F, -9.9552F, -5.227F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(21, 17)
						.addBox(11.0F, -15.9552F, -5.227F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(21, 17).addBox(11.0F, -18.9552F, -5.227F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(21, 17)
						.addBox(11.0F, -21.9552F, -5.227F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(21, 17).addBox(8.0F, -24.9552F, -6.027F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(21, 17)
						.addBox(5.0F, -24.9552F, -6.027F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(21, 17).addBox(2.0F, -24.9552F, -6.027F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(21, 17)
						.addBox(-7.0F, -24.9552F, -6.027F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(21, 17).addBox(-10.0F, -24.9552F, -6.027F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(21, 17)
						.addBox(-4.0F, -24.9552F, -6.027F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(21, 17).addBox(-1.0F, -24.9552F, -6.027F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(21, 17).mirror()
						.addBox(-13.0F, -9.9552F, -5.227F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(21, 17).mirror().addBox(-13.0F, -21.9552F, -5.227F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(21, 17).mirror().addBox(-13.0F, -18.9552F, -5.227F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(21, 17).mirror().addBox(-13.0F, -15.9552F, -5.227F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
						.mirror(false).texOffs(21, 17).mirror().addBox(-13.0F, -12.9552F, -5.227F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
		PartDefinition lower_jaw = head.addOrReplaceChild("lower_jaw",
				CubeListBuilder.create().texOffs(114, 126).addBox(-14.0F, -3.0F, -22.0F, 3.0F, 3.0F, 22.0F, new CubeDeformation(0.0F)).texOffs(62, 91).addBox(-13.0F, 0.0F, -22.0F, 26.0F, 5.0F, 22.0F, new CubeDeformation(0.0F)).texOffs(113, 152)
						.addBox(-12.0F, -3.0F, -26.0F, 24.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(128, 24).addBox(11.0F, -3.0F, -22.0F, 3.0F, 3.0F, 22.0F, new CubeDeformation(0.0F)).texOffs(21, 17)
						.addBox(11.0F, -5.0F, -22.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(21, 17).addBox(8.0F, -5.0F, -25.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(21, 17)
						.addBox(5.0F, -5.0F, -25.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(21, 17).addBox(-1.0F, -5.0F, -25.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(21, 17)
						.addBox(2.0F, -5.0F, -25.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(21, 17).addBox(-7.0F, -5.0F, -25.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(21, 17)
						.addBox(-10.0F, -5.0F, -25.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(21, 17).addBox(-4.0F, -5.0F, -25.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(21, 17).mirror()
						.addBox(-13.0F, -5.0F, -22.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(21, 17).mirror().addBox(-13.0F, -5.0F, -19.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(21, 17)
						.addBox(11.0F, -5.0F, -19.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(21, 17).mirror().addBox(-13.0F, -5.0F, -16.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(21, 17)
						.addBox(11.0F, -5.0F, -16.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(21, 17).mirror().addBox(-13.0F, -5.0F, -13.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(21, 17)
						.addBox(11.0F, -5.0F, -13.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(21, 17).mirror().addBox(-13.0F, -5.0F, -10.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(21, 17)
						.addBox(11.0F, -5.0F, -10.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(21, 17).mirror().addBox(-13.0F, -5.0F, -7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(21, 17)
						.addBox(11.0F, -5.0F, -7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(21, 17).mirror().addBox(-13.0F, -5.0F, -4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(21, 17)
						.addBox(11.0F, -5.0F, -4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 5.0F, -10.0F));
		PartDefinition neck = head.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(105, 170).addBox(-10.0F, -10.0F, -5.0F, 20.0F, 20.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -4.0F, -1.0F, -0.3054F, 0.0F, 0.0F));
		PartDefinition leg1 = body.addOrReplaceChild("leg1",
				CubeListBuilder.create().texOffs(64, 148).addBox(-1.0171F, -3.0603F, -5.3469F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(0.9829F, -4.0603F, -3.3469F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(17.0F, -1.0F, -25.0F, -0.3054F, -0.1309F, 0.0F));
		PartDefinition legpart1 = leg1.addOrReplaceChild("legpart1", CubeListBuilder.create().texOffs(156, 24).addBox(-3.9743F, -1.1177F, -4.6265F, 9.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.9572F, 8.0574F, 0.2797F, 0.3054F, 0.0F, 0.0F));
		PartDefinition foot1 = legpart1.addOrReplaceChild("foot1",
				CubeListBuilder.create().texOffs(0, 156).addBox(-4.9743F, -0.1177F, -6.6265F, 11.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(0, 25).addBox(-1.9743F, 0.8823F, -10.6265F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
						.texOffs(89, 64).addBox(4.0257F, 1.8823F, -8.6265F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 73).addBox(-5.9743F, 1.8823F, -8.6265F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(84, 80)
						.addBox(-2.9743F, -0.1177F, 5.3735F, 7.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 7.0F, 0.0F));
		PartDefinition leg3 = body.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(64, 148).mirror().addBox(-10.9487F, -2.9033F, -5.8448F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).mirror()
				.addBox(-9.9487F, -3.9033F, -3.8448F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-17.0F, -1.0F, -26.0F, -0.3054F, 0.1309F, 0.0F));
		PartDefinition legpart3 = leg3.addOrReplaceChild("legpart3", CubeListBuilder.create().texOffs(156, 24).mirror().addBox(-4.0F, -1.0F, -5.0F, 9.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-5.9487F, 8.0967F, 0.1552F, 0.3054F, 0.0F, 0.0F));
		PartDefinition foot3 = legpart3.addOrReplaceChild("foot3",
				CubeListBuilder.create().texOffs(0, 156).mirror().addBox(-5.0F, 0.0F, -7.0F, 11.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 25).mirror().addBox(-2.0F, 1.0F, -11.0F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
						.mirror(false).texOffs(89, 64).mirror().addBox(4.0F, 2.0F, -9.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 73).mirror().addBox(-6.0F, 2.0F, -9.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
						.mirror(false).texOffs(84, 80).mirror().addBox(-3.0F, 0.0F, 5.0F, 7.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(0.0F, 7.0F, 0.0F));
		PartDefinition leg2 = partdefinition
				.addOrReplaceChild(
						"leg2", CubeListBuilder.create().texOffs(64, 148).addBox(-2.1851F, -2.7772F, -6.245F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(46, 168)
								.addBox(-4.1851F, -1.7772F, -5.245F, 2.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-0.1851F, -3.7772F, -4.245F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(17.0F, 5.0F, 22.0F, -0.3054F, -0.3054F, 0.0F));
		PartDefinition legpart2 = leg2.addOrReplaceChild("legpart2", CubeListBuilder.create().texOffs(156, 24).addBox(-4.0F, -1.0F, -5.0F, 9.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.8149F, 8.2228F, -0.245F, 0.3054F, 0.0F, 0.0F));
		PartDefinition foot2 = legpart2.addOrReplaceChild("foot2",
				CubeListBuilder.create().texOffs(0, 156).addBox(-5.0F, 0.0F, -7.0F, 11.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(0, 25).addBox(-2.0F, 1.0F, -11.0F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(89, 64)
						.addBox(4.0F, 2.0F, -9.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 73).addBox(-6.0F, 2.0F, -9.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(84, 80)
						.addBox(-3.0F, 0.0F, 5.0F, 7.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 7.0F, 0.0F));
		PartDefinition leg4 = partdefinition.addOrReplaceChild("leg4",
				CubeListBuilder.create().texOffs(64, 148).mirror().addBox(-9.7686F, -2.6867F, -6.5318F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(46, 168).mirror()
						.addBox(2.2314F, -1.6867F, -5.5318F, 2.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).mirror().addBox(-8.7686F, -3.6867F, -4.5318F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-17.0F, 5.0F, 22.0F, -0.3054F, 0.3054F, 0.0F));
		PartDefinition legpart4 = leg4.addOrReplaceChild("legpart4", CubeListBuilder.create().texOffs(156, 24).mirror().addBox(-4.0F, -1.0F, -5.0F, 9.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-4.7686F, 8.3133F, -0.5318F, 0.3054F, 0.0F, 0.0F));
		PartDefinition foot4 = legpart4.addOrReplaceChild("foot4",
				CubeListBuilder.create().texOffs(0, 156).mirror().addBox(-5.0F, 0.0F, -7.0F, 11.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 25).mirror().addBox(-2.0F, 1.0F, -11.0F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
						.mirror(false).texOffs(89, 64).mirror().addBox(4.0F, 2.0F, -9.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 73).mirror().addBox(-6.0F, 2.0F, -9.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
						.mirror(false).texOffs(84, 80).mirror().addBox(-3.0F, 0.0F, 5.0F, 7.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(0.0F, 7.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}