package com.dreamcritting.ror.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

import com.dreamcritting.ror.entity.TitaniaEntity;
import com.dreamcritting.ror.client.model.animations.TitaniaAnimation;
import com.dreamcritting.ror.client.model.ModelTitania;

public class TitaniaRenderer extends MobRenderer<TitaniaEntity, ModelTitania<TitaniaEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("ror:textures/entities/titania.png");

	public TitaniaRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(ModelTitania.LAYER_LOCATION)), 0.5f);
		this.addLayer(new RenderLayer<TitaniaEntity, ModelTitania<TitaniaEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("ror:textures/entities/titania_glow.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, TitaniaEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(TitaniaEntity entity) {
		return entityTexture;
	}

	private static final class AnimatedModel extends ModelTitania<TitaniaEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<TitaniaEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(TitaniaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, TitaniaAnimation.fly, ageInTicks, 1f);
				this.animate(entity.animationState1, TitaniaAnimation.attack, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(TitaniaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}