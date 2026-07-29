package com.dreamcritting.ror.special;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import com.dreamcritting.ror.init.RorModMobEffects;

public class IgnoreAmmoMagicItemUseCondition {
	public static boolean execute(Entity entity) {
		return !(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(RorModMobEffects.MAGICAL_ABILITY_COOLDOWN));
	}
}