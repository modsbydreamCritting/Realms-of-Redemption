package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.mojang.blaze3d.vertex.PoseStack;

import com.dreamcritting.ror.entity.NeonicaEntity;
import com.dreamcritting.ror.client.model.ModelNeonica4;

public class NeonicaRenderer extends MobRenderer<NeonicaEntity, ModelNeonica4<NeonicaEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/neonica_4.png");

	public NeonicaRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelNeonica4<NeonicaEntity>(context.bakeLayer(ModelNeonica4.LAYER_LOCATION)), 0.5f);
	}

	@Override
	protected void scale(NeonicaEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(1.2f, 1.2f, 1.2f);
	}

	@Override
	public ResourceLocation getTextureLocation(NeonicaEntity entity) {
		return entityTexture;
	}
}