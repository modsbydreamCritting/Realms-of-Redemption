package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.dreamcritting.ror.entity.GnomeEntity;
import com.dreamcritting.ror.client.model.Modelgnome;

public class GnomeRenderer extends MobRenderer<GnomeEntity, Modelgnome<GnomeEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/gnome_2.png");

	public GnomeRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelgnome<GnomeEntity>(context.bakeLayer(Modelgnome.LAYER_LOCATION)), 0.3f);
	}

	@Override
	public ResourceLocation getTextureLocation(GnomeEntity entity) {
		return entityTexture;
	}
}