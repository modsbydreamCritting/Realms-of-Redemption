package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.dreamcritting.ror.entity.LightBlueCrystalStarEntity;
import com.dreamcritting.ror.client.model.ModelCrystalStar;

public class LightBlueCrystalStarRenderer extends MobRenderer<LightBlueCrystalStarEntity, ModelCrystalStar<LightBlueCrystalStarEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/light_blue_crystal_star.png");

	public LightBlueCrystalStarRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelCrystalStar<LightBlueCrystalStarEntity>(context.bakeLayer(ModelCrystalStar.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(LightBlueCrystalStarEntity entity) {
		return entityTexture;
	}
}