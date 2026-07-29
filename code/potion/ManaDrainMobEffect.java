package com.dreamcritting.ror.potion;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import com.dreamcritting.ror.init.RorModAttributes;
import com.dreamcritting.ror.RorMod;

public class ManaDrainMobEffect extends MobEffect {
	public ManaDrainMobEffect() {
		super(MobEffectCategory.HARMFUL, -10092442);
		this.addAttributeModifier(RorModAttributes.MAGICAL_POWER, ResourceLocation.fromNamespaceAndPath(RorMod.MODID, "effect.mana_drain_0"), -0.05, AttributeModifier.Operation.ADD_VALUE);
	}
}