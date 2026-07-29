package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

import com.dreamcritting.ror.entity.GoldScanbotEntity;
import com.dreamcritting.ror.client.model.ModelScanbot;

public class GoldScanbotRenderer extends MobRenderer<GoldScanbotEntity, ModelScanbot<GoldScanbotEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/gold_scanbot.png");

	public GoldScanbotRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelScanbot<GoldScanbotEntity>(context.bakeLayer(ModelScanbot.LAYER_LOCATION)), 0.5f);
		this.addLayer(new RenderLayer<GoldScanbotEntity, ModelScanbot<GoldScanbotEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("ror:textures/entities/scanbot_glow.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, GoldScanbotEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				EntityModel model = new ModelScanbot(Minecraft.getInstance().getEntityModels().bakeLayer(ModelScanbot.LAYER_LOCATION));
				this.getParentModel().copyPropertiesTo(model);
				model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
				model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
				model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(GoldScanbotEntity entity) {
		return entityTexture;
	}
}