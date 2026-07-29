package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.dreamcritting.ror.entity.YellowCrystalGolemEntity;
import com.dreamcritting.ror.client.model.ModelCrystalGolem;

public class YellowCrystalGolemRenderer extends MobRenderer<YellowCrystalGolemEntity, ModelCrystalGolem<YellowCrystalGolemEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/yellow_crystal_golem.png");

	public YellowCrystalGolemRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelCrystalGolem<YellowCrystalGolemEntity>(context.bakeLayer(ModelCrystalGolem.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(YellowCrystalGolemEntity entity) {
		return entityTexture;
	}
}