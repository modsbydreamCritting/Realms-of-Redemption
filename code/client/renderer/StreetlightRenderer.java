package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

import com.dreamcritting.ror.entity.StreetlightEntity;
import com.dreamcritting.ror.client.model.ModelStreetlight;

public class StreetlightRenderer extends MobRenderer<StreetlightEntity, ModelStreetlight<StreetlightEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/streetlight.png");

	public StreetlightRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelStreetlight<StreetlightEntity>(context.bakeLayer(ModelStreetlight.LAYER_LOCATION)), 0.5f);
		this.addLayer(new RenderLayer<StreetlightEntity, ModelStreetlight<StreetlightEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("ror:textures/entities/streetlight_glow.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, StreetlightEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(StreetlightEntity entity) {
		return entityTexture;
	}
}