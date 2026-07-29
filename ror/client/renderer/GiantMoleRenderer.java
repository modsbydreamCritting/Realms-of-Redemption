package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import com.dreamcritting.ror.entity.GiantMoleEntity;
import com.dreamcritting.ror.client.model.animations.MoleAnimation;
import com.dreamcritting.ror.client.model.ModelMole;

public class GiantMoleRenderer extends MobRenderer<GiantMoleEntity, ModelMole<GiantMoleEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/mole2_1.png");

	public GiantMoleRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(ModelMole.LAYER_LOCATION)), 1f);
	}

	@Override
	public ResourceLocation getTextureLocation(GiantMoleEntity entity) {
		return entityTexture;
	}

	private static final class AnimatedModel extends ModelMole<GiantMoleEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<GiantMoleEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(GiantMoleEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, MoleAnimation.idle, ageInTicks, 1f);
				this.animateWalk(MoleAnimation.walk, limbSwing, limbSwingAmount, 2f, 1f);
				this.animate(entity.animationState2, MoleAnimation.attack, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(GiantMoleEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}