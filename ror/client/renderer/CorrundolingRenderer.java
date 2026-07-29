package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.dreamcritting.ror.entity.CorrundolingEntity;
import com.dreamcritting.ror.client.model.ModelCorrundoling;

public class CorrundolingRenderer extends MobRenderer<CorrundolingEntity, ModelCorrundoling<CorrundolingEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/corrundoling.png");

	public CorrundolingRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelCorrundoling<CorrundolingEntity>(context.bakeLayer(ModelCorrundoling.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CorrundolingEntity entity) {
		return entityTexture;
	}
}