package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.dreamcritting.ror.entity.NeonResidentEntity;
import com.dreamcritting.ror.client.model.ModelNeonResident;

public class NeonResidentRenderer extends MobRenderer<NeonResidentEntity, ModelNeonResident<NeonResidentEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/neon_resident.png");

	public NeonResidentRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelNeonResident<NeonResidentEntity>(context.bakeLayer(ModelNeonResident.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(NeonResidentEntity entity) {
		return entityTexture;
	}
}