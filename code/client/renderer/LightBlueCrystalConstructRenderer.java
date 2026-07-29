package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.dreamcritting.ror.entity.LightBlueCrystalConstructEntity;
import com.dreamcritting.ror.client.model.ModelCrystalConstruct;

public class LightBlueCrystalConstructRenderer extends MobRenderer<LightBlueCrystalConstructEntity, ModelCrystalConstruct<LightBlueCrystalConstructEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/light_blue_crystal_construct.png");

	public LightBlueCrystalConstructRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelCrystalConstruct<LightBlueCrystalConstructEntity>(context.bakeLayer(ModelCrystalConstruct.LAYER_LOCATION)), 0.75f);
	}

	@Override
	public ResourceLocation getTextureLocation(LightBlueCrystalConstructEntity entity) {
		return entityTexture;
	}
}