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

import com.dreamcritting.ror.entity.GoogloidGhostEntity;
import com.dreamcritting.ror.client.model.ModelGoogloid3;

public class GoogloidGhostRenderer extends MobRenderer<GoogloidGhostEntity, ModelGoogloid3<GoogloidGhostEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/blank.png");

	public GoogloidGhostRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelGoogloid3<GoogloidGhostEntity>(context.bakeLayer(ModelGoogloid3.LAYER_LOCATION)), 0.5f);
		this.addLayer(new RenderLayer<GoogloidGhostEntity, ModelGoogloid3<GoogloidGhostEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("ror:textures/entities/googloid_ghost.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, GoogloidGhostEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(GoogloidGhostEntity entity) {
		return entityTexture;
	}
}