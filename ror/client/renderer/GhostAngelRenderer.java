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

import com.dreamcritting.ror.entity.GhostAngelEntity;
import com.dreamcritting.ror.client.model.ModelMox4;

public class GhostAngelRenderer extends MobRenderer<GhostAngelEntity, ModelMox4<GhostAngelEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/blank.png");

	public GhostAngelRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelMox4<GhostAngelEntity>(context.bakeLayer(ModelMox4.LAYER_LOCATION)), 0.5f);
		this.addLayer(new RenderLayer<GhostAngelEntity, ModelMox4<GhostAngelEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("ror:textures/entities/mox3.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, GhostAngelEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(GhostAngelEntity entity) {
		return entityTexture;
	}
}