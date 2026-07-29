package com.dreamcritting.ror.client.renderer;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

import com.dreamcritting.ror.entity.RainboomEntity;
import com.dreamcritting.ror.client.model.Modelrainboom3;

public class RainboomRenderer extends MobRenderer<RainboomEntity, Modelrainboom3<RainboomEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/blank.png");

	public RainboomRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelrainboom3<>(context.bakeLayer(Modelrainboom3.LAYER_LOCATION)), 0f);
		this.addLayer(new RenderLayer<>(this) {
            final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("ror:textures/entities/rainboom_2.png");

            @Override
            public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, RainboomEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
                VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
                this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
            }
        });
	}

	@Override
	protected void scale(RainboomEntity entity, PoseStack poseStack, float f) {
		float scale = (float) RainboomRenderer.calculateScale(entity);
		poseStack.scale(scale, scale, scale);
	}

	public static double calculateScale(Entity entity) {
		double a;
		double b;
		b = entity.getEntityData().get(RainboomEntity.DATA_time_alive);
		a = 1 - 1 / Math.pow(1.024, b);
		return a;
	}

	@Override
	public ResourceLocation getTextureLocation(RainboomEntity entity) {
		return entityTexture;
	}
}