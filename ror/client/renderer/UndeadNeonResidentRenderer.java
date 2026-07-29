package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.dreamcritting.ror.entity.UndeadNeonResidentEntity;
import com.dreamcritting.ror.client.model.ModelNeonResident;

public class UndeadNeonResidentRenderer extends MobRenderer<UndeadNeonResidentEntity, ModelNeonResident<UndeadNeonResidentEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/undead_neon_resident.png");

	public UndeadNeonResidentRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelNeonResident<UndeadNeonResidentEntity>(context.bakeLayer(ModelNeonResident.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(UndeadNeonResidentEntity entity) {
		return entityTexture;
	}
}