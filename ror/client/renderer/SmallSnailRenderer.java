package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.mojang.blaze3d.vertex.PoseStack;

import com.dreamcritting.ror.entity.SmallSnailEntity;
import com.dreamcritting.ror.client.model.ModelSmallSnail;

public class SmallSnailRenderer extends MobRenderer<SmallSnailEntity, ModelSmallSnail<SmallSnailEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/small_snail.png");

	public SmallSnailRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelSmallSnail<SmallSnailEntity>(context.bakeLayer(ModelSmallSnail.LAYER_LOCATION)), 0.1f);
	}

	@Override
	protected void scale(SmallSnailEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(entity.getAgeScale(), entity.getAgeScale(), entity.getAgeScale());
	}

	@Override
	public ResourceLocation getTextureLocation(SmallSnailEntity entity) {
		return entityTexture;
	}
}