package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.dreamcritting.ror.entity.GreenCrystalConstructEntity;
import com.dreamcritting.ror.client.model.ModelCrystalConstruct;

public class GreenCrystalConstructRenderer extends MobRenderer<GreenCrystalConstructEntity, ModelCrystalConstruct<GreenCrystalConstructEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/green_crystal_construct.png");

	public GreenCrystalConstructRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelCrystalConstruct<GreenCrystalConstructEntity>(context.bakeLayer(ModelCrystalConstruct.LAYER_LOCATION)), 0.75f);
	}

	@Override
	public ResourceLocation getTextureLocation(GreenCrystalConstructEntity entity) {
		return entityTexture;
	}
}