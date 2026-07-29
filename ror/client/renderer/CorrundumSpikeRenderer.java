package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import com.dreamcritting.ror.entity.CorrundumSpikeEntity;
import com.dreamcritting.ror.client.model.animations.SpikeAnimation;
import com.dreamcritting.ror.client.model.ModelSpike;

public class CorrundumSpikeRenderer extends MobRenderer<CorrundumSpikeEntity, ModelSpike<CorrundumSpikeEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/corrundum_spike_block_4.png");

	public CorrundumSpikeRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(ModelSpike.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CorrundumSpikeEntity entity) {
		return entityTexture;
	}

	private static final class AnimatedModel extends ModelSpike<CorrundumSpikeEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<CorrundumSpikeEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(CorrundumSpikeEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, SpikeAnimation.attack, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(CorrundumSpikeEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}