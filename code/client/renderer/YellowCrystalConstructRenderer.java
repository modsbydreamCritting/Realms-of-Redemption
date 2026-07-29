package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.dreamcritting.ror.entity.YellowCrystalConstructEntity;
import com.dreamcritting.ror.client.model.ModelCrystalConstruct;

public class YellowCrystalConstructRenderer extends MobRenderer<YellowCrystalConstructEntity, ModelCrystalConstruct<YellowCrystalConstructEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/yellow_crystal_construct.png");

	public YellowCrystalConstructRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelCrystalConstruct<YellowCrystalConstructEntity>(context.bakeLayer(ModelCrystalConstruct.LAYER_LOCATION)), 0.75f);
	}

	@Override
	public ResourceLocation getTextureLocation(YellowCrystalConstructEntity entity) {
		return entityTexture;
	}
}