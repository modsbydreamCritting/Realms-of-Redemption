package com.dreamcritting.ror.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import com.dreamcritting.ror.RorMod;

public class HopeMobEffect extends MobEffect {
	public HopeMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -6684673);
		this.addAttributeModifier(Attributes.MAX_HEALTH, ResourceLocation.fromNamespaceAndPath(RorMod.MODID, "effect.hope_0"), 1, AttributeModifier.Operation.ADD_VALUE);
	}
}