package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.dreamcritting.ror.entity.RedCrystalGolemEntity;
import com.dreamcritting.ror.client.model.ModelCrystalGolem;

public class RedCrystalGolemRenderer extends MobRenderer<RedCrystalGolemEntity, ModelCrystalGolem<RedCrystalGolemEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/red_crystal_golem.png");

	public RedCrystalGolemRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelCrystalGolem<RedCrystalGolemEntity>(context.bakeLayer(ModelCrystalGolem.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(RedCrystalGolemEntity entity) {
		return entityTexture;
	}
}