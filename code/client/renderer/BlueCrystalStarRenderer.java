package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.dreamcritting.ror.entity.BlueCrystalStarEntity;
import com.dreamcritting.ror.client.model.ModelCrystalStar;

public class BlueCrystalStarRenderer extends MobRenderer<BlueCrystalStarEntity, ModelCrystalStar<BlueCrystalStarEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/blue_crystal_star.png");

	public BlueCrystalStarRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelCrystalStar<BlueCrystalStarEntity>(context.bakeLayer(ModelCrystalStar.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(BlueCrystalStarEntity entity) {
		return entityTexture;
	}
}