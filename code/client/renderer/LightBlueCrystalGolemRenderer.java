package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.dreamcritting.ror.entity.LightBlueCrystalGolemEntity;
import com.dreamcritting.ror.client.model.ModelCrystalGolem;

public class LightBlueCrystalGolemRenderer extends MobRenderer<LightBlueCrystalGolemEntity, ModelCrystalGolem<LightBlueCrystalGolemEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/light_blue_crystal_golem.png");

	public LightBlueCrystalGolemRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelCrystalGolem<LightBlueCrystalGolemEntity>(context.bakeLayer(ModelCrystalGolem.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(LightBlueCrystalGolemEntity entity) {
		return entityTexture;
	}
}