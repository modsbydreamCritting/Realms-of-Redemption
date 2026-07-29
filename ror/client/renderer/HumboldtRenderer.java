package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import com.dreamcritting.ror.entity.HumboldtEntity;
import com.dreamcritting.ror.client.model.animations.HumboldtAnimation;
import com.dreamcritting.ror.client.model.ModelHumboldt;

public class HumboldtRenderer extends MobRenderer<HumboldtEntity, ModelHumboldt<HumboldtEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/humboldt.png");

	public HumboldtRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(ModelHumboldt.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(HumboldtEntity entity) {
		return entityTexture;
	}

	private static final class AnimatedModel extends ModelHumboldt<HumboldtEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<HumboldtEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(HumboldtEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, HumboldtAnimation.idle, ageInTicks, 1f);
				this.animateWalk(HumboldtAnimation.walk, limbSwing, limbSwingAmount, 2f, 7f);
				this.animate(entity.animationState2, HumboldtAnimation.attack, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(HumboldtEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}