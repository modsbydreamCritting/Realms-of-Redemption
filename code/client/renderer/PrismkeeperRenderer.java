package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.dreamcritting.ror.entity.PrismkeeperEntity;
import com.dreamcritting.ror.client.model.ModelAlex;

public class PrismkeeperRenderer extends MobRenderer<PrismkeeperEntity, ModelAlex<PrismkeeperEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/prismkeeper.png");

	public PrismkeeperRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelAlex<PrismkeeperEntity>(context.bakeLayer(ModelAlex.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(PrismkeeperEntity entity) {
		return entityTexture;
	}
}