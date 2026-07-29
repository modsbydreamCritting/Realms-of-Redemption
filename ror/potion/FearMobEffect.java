package com.dreamcritting.ror.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import com.dreamcritting.ror.RorMod;

public class FearMobEffect extends MobEffect {
	public FearMobEffect() {
		super(MobEffectCategory.HARMFUL, -10027060);
		this.addAttributeModifier(Attributes.MAX_HEALTH, ResourceLocation.fromNamespaceAndPath(RorMod.MODID, "effect.fear_0"), -1, AttributeModifier.Operation.ADD_VALUE);
	}
}