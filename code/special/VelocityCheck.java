package com.dreamcritting.ror.special;

import net.minecraft.world.entity.Entity;

public class VelocityCheck {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return Math.sqrt(Math.pow(entity.getDeltaMovement().x(), 2) + Math.pow(entity.getDeltaMovement().y(), 2) + Math.pow(entity.getDeltaMovement().z(), 2)) >= 1.58;
	}
}