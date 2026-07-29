package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.dreamcritting.ror.entity.CrystalcopterEntity;
import com.dreamcritting.ror.client.model.ModelCrystalcopter2;

public class CrystalcopterRenderer extends MobRenderer<CrystalcopterEntity, ModelCrystalcopter2<CrystalcopterEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/crystalcopter.png");

	public CrystalcopterRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelCrystalcopter2<CrystalcopterEntity>(context.bakeLayer(ModelCrystalcopter2.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CrystalcopterEntity entity) {
		return entityTexture;
	}
}