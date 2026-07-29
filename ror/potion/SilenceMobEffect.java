package com.dreamcritting.ror.potion;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import com.dreamcritting.ror.init.RorModAttributes;
import com.dreamcritting.ror.RorMod;

public class SilenceMobEffect extends MobEffect {
	public SilenceMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -13421773);
		this.addAttributeModifier(RorModAttributes.STEALTH, ResourceLocation.fromNamespaceAndPath(RorMod.MODID, "effect.silence_0"), 0.1, AttributeModifier.Operation.ADD_VALUE);
	}
}