package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.dreamcritting.ror.entity.GreenCrystalGolemEntity;
import com.dreamcritting.ror.client.model.ModelCrystalGolem;

public class GreenCrystalGolemRenderer extends MobRenderer<GreenCrystalGolemEntity, ModelCrystalGolem<GreenCrystalGolemEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/green_crystal_golem.png");

	public GreenCrystalGolemRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelCrystalGolem<GreenCrystalGolemEntity>(context.bakeLayer(ModelCrystalGolem.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(GreenCrystalGolemEntity entity) {
		return entityTexture;
	}
}