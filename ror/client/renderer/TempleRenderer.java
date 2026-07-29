package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import com.dreamcritting.ror.entity.TempleEntity;

public class TempleRenderer extends HumanoidMobRenderer<TempleEntity, HumanoidModel<TempleEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/blank.png");

	public TempleRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<TempleEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(TempleEntity entity) {
		return entityTexture;
	}
}