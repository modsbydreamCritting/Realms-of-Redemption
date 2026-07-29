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

import com.dreamcritting.ror.entity.LaserbeamEntity;
import com.dreamcritting.ror.client.model.ModelLaserbeam2;

public class LaserbeamRenderer extends MobRenderer<LaserbeamEntity, ModelLaserbeam2<LaserbeamEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/blank.png");

	public LaserbeamRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelLaserbeam2<LaserbeamEntity>(context.bakeLayer(ModelLaserbeam2.LAYER_LOCATION)), 0.5f);
		this.addLayer(new RenderLayer<LaserbeamEntity, ModelLaserbeam2<LaserbeamEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("ror:textures/entities/laserbeam_2.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, LaserbeamEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(LaserbeamEntity entity) {
		return entityTexture;
	}
}