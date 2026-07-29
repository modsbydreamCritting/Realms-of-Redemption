package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.SpiderModel;

import com.mojang.blaze3d.vertex.PoseStack;

import com.dreamcritting.ror.entity.SwarmSpiderEntity;

public class SwarmSpiderRenderer extends MobRenderer<SwarmSpiderEntity, SpiderModel<SwarmSpiderEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/spider.png");

	public SwarmSpiderRenderer(EntityRendererProvider.Context context) {
		super(context, new SpiderModel<SwarmSpiderEntity>(context.bakeLayer(ModelLayers.SPIDER)), 0.5f);
	}

	@Override
	protected void scale(SwarmSpiderEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(0.3f, 0.3f, 0.3f);
	}

	@Override
	public ResourceLocation getTextureLocation(SwarmSpiderEntity entity) {
		return entityTexture;
	}
}