package com.dreamcritting.ror.potion;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import com.dreamcritting.ror.init.RorModAttributes;
import com.dreamcritting.ror.RorMod;

public class BraveryMobEffect extends MobEffect {
	public BraveryMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -22006);
		this.addAttributeModifier(RorModAttributes.FEAR_RESISTANCE, ResourceLocation.fromNamespaceAndPath(RorMod.MODID, "effect.bravery_0"), 1, AttributeModifier.Operation.ADD_VALUE);
	}
}