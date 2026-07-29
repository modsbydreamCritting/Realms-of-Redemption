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

import com.dreamcritting.ror.entity.LaserbotEntity;
import com.dreamcritting.ror.client.model.ModelLaserbotModel4;

public class LaserbotRenderer extends MobRenderer<LaserbotEntity, ModelLaserbotModel4<LaserbotEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/laserbot_2.png");

	public LaserbotRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelLaserbotModel4<LaserbotEntity>(context.bakeLayer(ModelLaserbotModel4.LAYER_LOCATION)), 0.5f);
		this.addLayer(new RenderLayer<LaserbotEntity, ModelLaserbotModel4<LaserbotEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("ror:textures/entities/laserbot_glow.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, LaserbotEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				EntityModel model = new ModelLaserbotModel4(Minecraft.getInstance().getEntityModels().bakeLayer(ModelLaserbotModel4.LAYER_LOCATION));
				this.getParentModel().copyPropertiesTo(model);
				model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
				model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
				model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(LaserbotEntity entity) {
		return entityTexture;
	}
}