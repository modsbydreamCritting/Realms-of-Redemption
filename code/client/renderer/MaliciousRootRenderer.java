package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import com.dreamcritting.ror.entity.MaliciousRootEntity;
import com.dreamcritting.ror.client.model.animations.MaliciousRootAnimation;
import com.dreamcritting.ror.client.model.ModelMaliciousRoot;

public class MaliciousRootRenderer extends MobRenderer<MaliciousRootEntity, ModelMaliciousRoot<MaliciousRootEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/malicious_root.png");

	public MaliciousRootRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(ModelMaliciousRoot.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(MaliciousRootEntity entity) {
		return entityTexture;
	}

	private static final class AnimatedModel extends ModelMaliciousRoot<MaliciousRootEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<MaliciousRootEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(MaliciousRootEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, MaliciousRootAnimation.idle, ageInTicks, 1f);
				this.animate(entity.animationState1, MaliciousRootAnimation.attack, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(MaliciousRootEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}