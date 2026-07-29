package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.dreamcritting.ror.entity.MeatPuddleEntity;
import com.dreamcritting.ror.client.model.ModelMeatPuddle;

public class MeatPuddleRenderer extends MobRenderer<MeatPuddleEntity, ModelMeatPuddle<MeatPuddleEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/meat_puddle_3.png");

	public MeatPuddleRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelMeatPuddle<MeatPuddleEntity>(context.bakeLayer(ModelMeatPuddle.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(MeatPuddleEntity entity) {
		return entityTexture;
	}
}