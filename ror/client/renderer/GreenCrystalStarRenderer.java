package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.dreamcritting.ror.entity.GreenCrystalStarEntity;
import com.dreamcritting.ror.client.model.ModelCrystalStar;

public class GreenCrystalStarRenderer extends MobRenderer<GreenCrystalStarEntity, ModelCrystalStar<GreenCrystalStarEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/green_crystal_star.png");

	public GreenCrystalStarRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelCrystalStar<GreenCrystalStarEntity>(context.bakeLayer(ModelCrystalStar.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(GreenCrystalStarEntity entity) {
		return entityTexture;
	}
}