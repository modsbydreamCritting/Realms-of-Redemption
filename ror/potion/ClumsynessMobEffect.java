package com.dreamcritting.ror.potion;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import com.dreamcritting.ror.init.RorModAttributes;
import com.dreamcritting.ror.RorMod;

public class ClumsynessMobEffect extends MobEffect {
	public ClumsynessMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16764058);
		this.addAttributeModifier(RorModAttributes.STEALTH, ResourceLocation.fromNamespaceAndPath(RorMod.MODID, "effect.clumsyness_0"), -0.1, AttributeModifier.Operation.ADD_VALUE);
	}
}