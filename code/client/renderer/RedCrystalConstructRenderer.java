package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.dreamcritting.ror.entity.RedCrystalConstructEntity;
import com.dreamcritting.ror.client.model.ModelCrystalConstruct;

public class RedCrystalConstructRenderer extends MobRenderer<RedCrystalConstructEntity, ModelCrystalConstruct<RedCrystalConstructEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/red_crystal_construct.png");

	public RedCrystalConstructRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelCrystalConstruct<RedCrystalConstructEntity>(context.bakeLayer(ModelCrystalConstruct.LAYER_LOCATION)), 0.75f);
	}

	@Override
	public ResourceLocation getTextureLocation(RedCrystalConstructEntity entity) {
		return entityTexture;
	}
}