package com.dreamcritting.ror.special;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.SimpleParticleType;

import com.dreamcritting.ror.init.RorModParticleTypes;

public class RedBeam {
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
		for (int index25 = 0; index25 < (int) (steps + 1); index25++) {
			world.addParticle(RorModParticleTypes.RED_LASER.get(), Cur_X, Cur_Y, Cur_Z, 0, 0, 0);
			Cur_X = Cur_X + Delta_X;
			Cur_Y = Cur_Y + Delta_Y;
			Cur_Z = Cur_Z + Delta_Z;
		}
	}
}