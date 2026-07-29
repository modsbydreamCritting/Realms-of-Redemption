package com.dreamcritting.ror.potion;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import com.dreamcritting.ror.init.RorModAttributes;
import com.dreamcritting.ror.RorMod;

public class MagicBoostMobEffect extends MobEffect {
	public MagicBoostMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -3394561);
		this.addAttributeModifier(RorModAttributes.MAGICAL_POWER, ResourceLocation.fromNamespaceAndPath(RorMod.MODID, "effect.magic_boost_0"), 0.05, AttributeModifier.Operation.ADD_VALUE);
	}
}