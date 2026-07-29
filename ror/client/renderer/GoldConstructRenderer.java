package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.dreamcritting.ror.entity.GoldConstructEntity;
import com.dreamcritting.ror.client.model.ModelCrystalConstruct;

public class GoldConstructRenderer extends MobRenderer<GoldConstructEntity, ModelCrystalConstruct<GoldConstructEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/gold_construct.png");

	public GoldConstructRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelCrystalConstruct<GoldConstructEntity>(context.bakeLayer(ModelCrystalConstruct.LAYER_LOCATION)), 0.75f);
	}

	@Override
	public ResourceLocation getTextureLocation(GoldConstructEntity entity) {
		return entityTexture;
	}
}