package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.dreamcritting.ror.entity.MoonDungeonGuardEntity;
import com.dreamcritting.ror.client.model.ModelMoonDungeonGuard;

public class MoonDungeonGuardRenderer extends MobRenderer<MoonDungeonGuardEntity, ModelMoonDungeonGuard<MoonDungeonGuardEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/undercopter2.png");

	public MoonDungeonGuardRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelMoonDungeonGuard<MoonDungeonGuardEntity>(context.bakeLayer(ModelMoonDungeonGuard.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(MoonDungeonGuardEntity entity) {
		return entityTexture;
	}
}