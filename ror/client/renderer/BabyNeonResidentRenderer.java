package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.dreamcritting.ror.entity.BabyNeonResidentEntity;
import com.dreamcritting.ror.client.model.ModelBabyNeonResident;

public class BabyNeonResidentRenderer extends MobRenderer<BabyNeonResidentEntity, ModelBabyNeonResident<BabyNeonResidentEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/neon_resident_2.png");

	public BabyNeonResidentRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelBabyNeonResident<BabyNeonResidentEntity>(context.bakeLayer(ModelBabyNeonResident.LAYER_LOCATION)), 0.3f);
	}

	@Override
	public ResourceLocation getTextureLocation(BabyNeonResidentEntity entity) {
		return entityTexture;
	}
}