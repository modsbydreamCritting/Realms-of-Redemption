package com.dreamcritting.ror.client.renderer;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

import com.dreamcritting.ror.entity.DevourerWandProjectileEntity;
import com.dreamcritting.ror.client.model.ModelMagicProjectile;

public class DevourerWandProjectileRenderer extends EntityRenderer<DevourerWandProjectileEntity> {
	private static final ResourceLocation texture = ResourceLocation.parse("ror:textures/entities/magic_bolt_3d.png");
	private final ModelMagicProjectile model;

	public DevourerWandProjectileRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new ModelMagicProjectile(context.bakeLayer(ModelMagicProjectile.LAYER_LOCATION));
	}

	@Override
	public void render(DevourerWandProjectileEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.setupAnim(entityIn, 0, 0, entityIn.tickCount + partialTicks, entityIn.getYRot(), entityIn.getXRot());
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY);
		poseStack.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(DevourerWandProjectileEntity entity) {
		return texture;
	}
}