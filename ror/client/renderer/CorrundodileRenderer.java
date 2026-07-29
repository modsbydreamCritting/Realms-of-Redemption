package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import com.dreamcritting.ror.entity.CorrundodileEntity;
import com.dreamcritting.ror.client.model.animations.CorrundodileAnimation;
import com.dreamcritting.ror.client.model.ModelCorrundodile;

public class CorrundodileRenderer extends MobRenderer<CorrundodileEntity, ModelCorrundodile<CorrundodileEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/corrundodile.png");

	public CorrundodileRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(ModelCorrundodile.LAYER_LOCATION)), 2f);
	}

	@Override
	public ResourceLocation getTextureLocation(CorrundodileEntity entity) {
		return entityTexture;
	}

	private static final class AnimatedModel extends ModelCorrundodile<CorrundodileEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<CorrundodileEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(CorrundodileEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, CorrundodileAnimation.idle, ageInTicks, 1f);
				this.animateWalk(CorrundodileAnimation.walk, limbSwing, limbSwingAmount, 1f, 3f);
				this.animate(entity.animationState2, CorrundodileAnimation.attack, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(CorrundodileEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}