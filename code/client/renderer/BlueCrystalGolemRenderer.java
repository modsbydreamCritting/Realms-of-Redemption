package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.dreamcritting.ror.entity.BlueCrystalGolemEntity;
import com.dreamcritting.ror.client.model.ModelCrystalGolem;

public class BlueCrystalGolemRenderer extends MobRenderer<BlueCrystalGolemEntity, ModelCrystalGolem<BlueCrystalGolemEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/blue_crystal_golem.png");

	public BlueCrystalGolemRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelCrystalGolem<BlueCrystalGolemEntity>(context.bakeLayer(ModelCrystalGolem.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(BlueCrystalGolemEntity entity) {
		return entityTexture;
	}
}