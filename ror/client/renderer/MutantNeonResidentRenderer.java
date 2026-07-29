package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.dreamcritting.ror.entity.MutantNeonResidentEntity;
import com.dreamcritting.ror.client.model.ModelMutantNeonResident;

public class MutantNeonResidentRenderer extends MobRenderer<MutantNeonResidentEntity, ModelMutantNeonResident<MutantNeonResidentEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/mutant_neon_resident.png");

	public MutantNeonResidentRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelMutantNeonResident<MutantNeonResidentEntity>(context.bakeLayer(ModelMutantNeonResident.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(MutantNeonResidentEntity entity) {
		return entityTexture;
	}
}