package com.dreamcritting.ror.special;

import net.minecraft.world.entity.Entity;

public class GenericIdlePlaybackCondition {
	public static boolean execute(Entity entity) {
		return Math.hypot(entity.getDeltaMovement().x(), entity.getDeltaMovement().z()) == 0;
	}
}