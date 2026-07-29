package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.dreamcritting.ror.entity.UndercopterEntity;
import com.dreamcritting.ror.client.model.ModelUndercopter;

public class UndercopterRenderer extends MobRenderer<UndercopterEntity, ModelUndercopter<UndercopterEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/undercopter2.png");

	public UndercopterRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelUndercopter<UndercopterEntity>(context.bakeLayer(ModelUndercopter.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(UndercopterEntity entity) {
		return entityTexture;
	}
}