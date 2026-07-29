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

import com.dreamcritting.ror.entity.AlliedGhostEntity;
import com.dreamcritting.ror.client.model.ModelRoRGhost2;

public class AlliedGhostRenderer extends MobRenderer<AlliedGhostEntity, ModelRoRGhost2<AlliedGhostEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/blank.png");

	public AlliedGhostRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelRoRGhost2<AlliedGhostEntity>(context.bakeLayer(ModelRoRGhost2.LAYER_LOCATION)), 0.5f);
		this.addLayer(new RenderLayer<AlliedGhostEntity, ModelRoRGhost2<AlliedGhostEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("ror:textures/entities/green_ghost_2.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, AlliedGhostEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(AlliedGhostEntity entity) {
		return entityTexture;
	}
}