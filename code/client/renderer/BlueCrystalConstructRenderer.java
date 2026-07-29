package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.dreamcritting.ror.entity.BlueCrystalConstructEntity;
import com.dreamcritting.ror.client.model.ModelCrystalConstruct;

public class BlueCrystalConstructRenderer extends MobRenderer<BlueCrystalConstructEntity, ModelCrystalConstruct<BlueCrystalConstructEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/blue_crystal_construct.png");

	public BlueCrystalConstructRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelCrystalConstruct<BlueCrystalConstructEntity>(context.bakeLayer(ModelCrystalConstruct.LAYER_LOCATION)), 0.75f);
	}

	@Override
	public ResourceLocation getTextureLocation(BlueCrystalConstructEntity entity) {
		return entityTexture;
	}
}