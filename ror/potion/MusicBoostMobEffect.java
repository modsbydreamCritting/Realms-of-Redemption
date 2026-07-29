package com.dreamcritting.ror.potion;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import com.dreamcritting.ror.init.RorModAttributes;
import com.dreamcritting.ror.RorMod;

public class MusicBoostMobEffect extends MobEffect {
	public MusicBoostMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -6710785);
		this.addAttributeModifier(RorModAttributes.MUSICAL_POWER, ResourceLocation.fromNamespaceAndPath(RorMod.MODID, "effect.music_boost_0"), 0.05, AttributeModifier.Operation.ADD_VALUE);
	}
}