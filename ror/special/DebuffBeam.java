package com.dreamcritting.ror.special;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class DebuffBeam {
	public static void execute(LevelAccessor world, double density, double x1, double x2, double y1, double y2, double z1, double z2) {
		double distance;
		double Delta_X;
		double Delta_Z;
		double Delta_Y;
		double Cur_Z;
		double steps;
		double Cur_Y;
		double Cur_X;
		distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(z2 - y1, 2) + Math.pow(z2 - z1, 2));
		steps = distance * density;
		Delta_X = (x2 - x1) / steps;
		Delta_Y = (y2 - y1) / steps;
		Delta_Z = (z2 - z1) / steps;
		Cur_X = x1;
		Cur_Y = y1;
		Cur_Z = z1;
		for (int index23 = 0; index23 < (int) (steps + 1); index23++) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.ENCHANTED_HIT, Cur_X, Cur_Y, Cur_Z, 1, 0, 0, 0, 0);
			Cur_X = Cur_X + Delta_X;
			Cur_Y = Cur_Y + Delta_Y;
			Cur_Z = Cur_Z + Delta_Z;
		}
	}
}