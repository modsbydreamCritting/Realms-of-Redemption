package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import com.dreamcritting.ror.entity.PlacerEntity;

public class PlacerRenderer extends HumanoidMobRenderer<PlacerEntity, HumanoidModel<PlacerEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/small_robot_2.png");

	public PlacerRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<PlacerEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(PlacerEntity entity) {
		return entityTexture;
	}
}