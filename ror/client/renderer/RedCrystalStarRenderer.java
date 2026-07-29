package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.dreamcritting.ror.entity.RedCrystalStarEntity;
import com.dreamcritting.ror.client.model.ModelCrystalStar;

public class RedCrystalStarRenderer extends MobRenderer<RedCrystalStarEntity, ModelCrystalStar<RedCrystalStarEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/red_crystal_star.png");

	public RedCrystalStarRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelCrystalStar<RedCrystalStarEntity>(context.bakeLayer(ModelCrystalStar.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(RedCrystalStarEntity entity) {
		return entityTexture;
	}
}