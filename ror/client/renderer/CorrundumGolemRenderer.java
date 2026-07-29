package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.dreamcritting.ror.entity.CorrundumGolemEntity;
import com.dreamcritting.ror.client.model.ModelCorrundumGolem;

public class CorrundumGolemRenderer extends MobRenderer<CorrundumGolemEntity, ModelCorrundumGolem<CorrundumGolemEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/corrundum_golem.png");

	public CorrundumGolemRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelCorrundumGolem<CorrundumGolemEntity>(context.bakeLayer(ModelCorrundumGolem.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CorrundumGolemEntity entity) {
		return entityTexture;
	}
}