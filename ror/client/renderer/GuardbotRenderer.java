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

import com.dreamcritting.ror.entity.GuardbotEntity;
import com.dreamcritting.ror.client.model.Modelplayer;

public class GuardbotRenderer extends MobRenderer<GuardbotEntity, Modelplayer<GuardbotEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/guardbot.png");

	public GuardbotRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelplayer<GuardbotEntity>(context.bakeLayer(Modelplayer.LAYER_LOCATION)), 0.5f);
		this.addLayer(new RenderLayer<GuardbotEntity, Modelplayer<GuardbotEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("ror:textures/entities/guardbot_glow.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, GuardbotEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	protected void scale(GuardbotEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(2f, 2f, 2f);
	}

	@Override
	public ResourceLocation getTextureLocation(GuardbotEntity entity) {
		return entityTexture;
	}
}