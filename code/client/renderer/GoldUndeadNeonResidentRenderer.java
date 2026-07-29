package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.dreamcritting.ror.entity.GoldUndeadNeonResidentEntity;
import com.dreamcritting.ror.client.model.ModelNeonResident;

public class GoldUndeadNeonResidentRenderer extends MobRenderer<GoldUndeadNeonResidentEntity, ModelNeonResident<GoldUndeadNeonResidentEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/gold_undead_neon_resident.png");

	public GoldUndeadNeonResidentRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelNeonResident<GoldUndeadNeonResidentEntity>(context.bakeLayer(ModelNeonResident.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(GoldUndeadNeonResidentEntity entity) {
		return entityTexture;
	}
}