package com.dreamcritting.ror.potion;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import com.dreamcritting.ror.init.RorModAttributes;
import com.dreamcritting.ror.RorMod;

public class DeafnessMobEffect extends MobEffect {
	public DeafnessMobEffect() {
		super(MobEffectCategory.HARMFUL, -13434778);
		this.addAttributeModifier(RorModAttributes.MUSICAL_POWER, ResourceLocation.fromNamespaceAndPath(RorMod.MODID, "effect.deafness_0"), -0.05, AttributeModifier.Operation.ADD_VALUE);
	}
}