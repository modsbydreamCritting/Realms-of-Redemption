package com.dreamcritting.ror.special;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class ScanbotSpecialAttack {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity attack_target;
		if (Math.random() <= 0.005) {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				attack_target = entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null;
				ScanBeam.execute(world, 0.01, x, attack_target.getX(), y + 1.8, attack_target.getY() + 1, z, attack_target.getZ());
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:scan")), SoundSource.HOSTILE, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:scan")), SoundSource.HOSTILE, 1, 1, false);
					}
				}
				attack_target.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MOB_PROJECTILE), entity), 4);
			}
		}
	}
}