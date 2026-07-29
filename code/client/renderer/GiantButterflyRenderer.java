package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import com.dreamcritting.ror.entity.GiantButterflyEntity;
import com.dreamcritting.ror.client.model.animations.GiantButterflyAnimation;
import com.dreamcritting.ror.client.model.ModelGiantButterfly;

public class GiantButterflyRenderer extends MobRenderer<GiantButterflyEntity, ModelGiantButterfly<GiantButterflyEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/giant_butterfly_2.png");

	public GiantButterflyRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(ModelGiantButterfly.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(GiantButterflyEntity entity) {
		return entityTexture;
	}

	private static final class AnimatedModel extends ModelGiantButterfly<GiantButterflyEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<GiantButterflyEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(GiantButterflyEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, GiantButterflyAnimation.fly, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(GiantButterflyEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}