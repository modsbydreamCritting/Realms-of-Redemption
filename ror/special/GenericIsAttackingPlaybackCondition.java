package com.dreamcritting.ror.special;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class GenericIsAttackingPlaybackCondition {
	public static boolean execute(Entity entity) {
		return entity instanceof LivingEntity _livEnt0 && _livEnt0.swinging;
	}
}