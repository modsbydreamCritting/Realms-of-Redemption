package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.dreamcritting.ror.entity.YellowCrystalStarEntity;
import com.dreamcritting.ror.client.model.ModelCrystalStar;

public class YellowCrystalStarRenderer extends MobRenderer<YellowCrystalStarEntity, ModelCrystalStar<YellowCrystalStarEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/yellow_crystal_star.png");

	public YellowCrystalStarRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelCrystalStar<YellowCrystalStarEntity>(context.bakeLayer(ModelCrystalStar.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(YellowCrystalStarEntity entity) {
		return entityTexture;
	}
}