package com.dreamcritting.ror.client;

import org.joml.Matrix4f;

import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.vertex.*;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@EventBusSubscriber(Dist.CLIENT)
public class RorModSkyboxRenderer {
	private static final ResourceKey CYBERLAND = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("ror:cyberland"));
	private static final ResourceLocation CYBERLAND_SKYBOX = ResourceLocation.parse("ror:textures/skybox/cyberland.png");

	@SubscribeEvent
	public static void renderSky(RenderLevelStageEvent event) {
		Minecraft mc = Minecraft.getInstance();
		if (mc.player == null)
			return;
		if (event.getStage() != RenderLevelStageEvent.Stage.AFTER_SKY)
			return;
		if (mc.player.level().dimension() == CYBERLAND) {
			renderCustomSkybox(event, CYBERLAND_SKYBOX);
		}
	}

	public static void renderCustomSkybox(RenderLevelStageEvent event, ResourceLocation texture) {
		PoseStack poseStack = event.getPoseStack();
		poseStack.pushPose();
		poseStack.mulPose(event.getModelViewMatrix());
		GlStateManager._enableBlend();
		RenderSystem.defaultBlendFunc();
		GlStateManager._depthMask(false);
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderTexture(0, texture);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		Tesselator tesselator = Tesselator.getInstance();
		float distance = 100.0F;
		float size = 100.0F;
		renderSkyboxQuad(poseStack, tesselator, -size, distance, -size, 1.0F / 4.0F, 1.0F / 3.0F, size, distance, -size, 2.0F / 4.0F, 1.0F / 3.0F, size, distance, size, 2.0F / 4.0F, 0.0F, -size, distance, size, 1.0F / 4.0F, 0.0F);
		renderSkyboxQuad(poseStack, tesselator, -size, -distance, -size, 1.0F / 4.0F, 2.0F / 3.0F, -size, -distance, size, 1.0F / 4.0F, 3.0F / 3.0F, size, -distance, size, 2.0F / 4.0F, 3.0F / 3.0F, size, -distance, -size, 2.0F / 4.0F, 2.0F / 3.0F);
		renderSkyboxQuad(poseStack, tesselator, -distance, -size, size, 0.0F, 2.0F / 3.0F, -distance, -size, -size, 1.0F / 4.0F, 2.0F / 3.0F, -distance, size, -size, 1.0F / 4.0F, 1.0F / 3.0F, -distance, size, size, 0.0F, 1.0F / 3.0F);
		renderSkyboxQuad(poseStack, tesselator, -size, -size, -distance, 1.0F / 4.0F, 2.0F / 3.0F, size, -size, -distance, 2.0F / 4.0F, 2.0F / 3.0F, size, size, -distance, 2.0F / 4.0F, 1.0F / 3.0F, -size, size, -distance, 1.0F / 4.0F, 1.0F / 3.0F);
		renderSkyboxQuad(poseStack, tesselator, distance, -size, -size, 2.0F / 4.0F, 2.0F / 3.0F, distance, -size, size, 3.0F / 4.0F, 2.0F / 3.0F, distance, size, size, 3.0F / 4.0F, 1.0F / 3.0F, distance, size, -size, 2.0F / 4.0F, 1.0F / 3.0F);
		renderSkyboxQuad(poseStack, tesselator, size, -size, distance, 3.0F / 4.0F, 2.0F / 3.0F, -size, -size, distance, 4.0F / 4.0F, 2.0F / 3.0F, -size, size, distance, 4.0F / 4.0F, 1.0F / 3.0F, size, size, distance, 3.0F / 4.0F, 1.0F / 3.0F);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		GlStateManager._depthMask(true);
		GlStateManager._disableBlend();
		poseStack.popPose();
	}

	private static void renderSkyboxQuad(PoseStack poseStack, Tesselator tesselator, float x1, float y1, float z1, float u1, float v1, float x2, float y2, float z2, float u2, float v2, float x3, float y3, float z3, float u3, float v3, float x4,
			float y4, float z4, float u4, float v4) {
		Matrix4f matrix = poseStack.last().pose();
		BufferBuilder buffer = tesselator.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
		buffer.addVertex(matrix, x1, y1, z1).setUv(u1, v1);
		buffer.addVertex(matrix, x2, y2, z2).setUv(u2, v2);
		buffer.addVertex(matrix, x3, y3, z3).setUv(u3, v3);
		buffer.addVertex(matrix, x4, y4, z4).setUv(u4, v4);
		BufferUploader.drawWithShader(buffer.buildOrThrow());
	}
}