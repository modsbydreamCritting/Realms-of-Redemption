package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import com.dreamcritting.ror.entity.KillbotEntity;
import com.dreamcritting.ror.client.model.animations.KillbotAnimation;
import com.dreamcritting.ror.client.model.ModelKillbot;

public class KillbotRenderer extends MobRenderer<KillbotEntity, ModelKillbot<KillbotEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/robot_boss.png");

	public KillbotRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(ModelKillbot.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(KillbotEntity entity) {
		return entityTexture;
	}

	private static final class AnimatedModel extends ModelKillbot<KillbotEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<KillbotEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(KillbotEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, KillbotAnimation.idle, ageInTicks, 1f);
				this.animateWalk(KillbotAnimation.walk, limbSwing, limbSwingAmount, 1f, 2f);
				this.animate(entity.animationState2, KillbotAnimation.attack, ageInTicks, 1f);
				this.animate(entity.animationState3, KillbotAnimation.launch, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(KillbotEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}