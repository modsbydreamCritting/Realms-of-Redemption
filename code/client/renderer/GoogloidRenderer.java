package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.dreamcritting.ror.entity.GoogloidEntity;
import com.dreamcritting.ror.client.model.ModelGoogloid3;

public class GoogloidRenderer extends MobRenderer<GoogloidEntity, ModelGoogloid3<GoogloidEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/googleoid.png");

	public GoogloidRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelGoogloid3<GoogloidEntity>(context.bakeLayer(ModelGoogloid3.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(GoogloidEntity entity) {
		return entityTexture;
	}
}