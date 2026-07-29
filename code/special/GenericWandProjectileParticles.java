package com.dreamcritting.ror.special;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import com.dreamcritting.ror.init.RorModParticleTypes;

public class GenericWandProjectileParticles {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles(RorModParticleTypes.MAGIC_FIREBALL.get(), x, y, z, 2, 0.1, 0.1, 0.1, 0.1);
	}
}