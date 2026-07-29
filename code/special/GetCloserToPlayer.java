package com.dreamcritting.ror.special;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import java.util.Comparator;

public class GetCloserToPlayer {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity nearest_player;
		if (world.getEntitiesOfClass(ServerPlayer.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(48 / 2d), e -> true).isEmpty()) {
			if (!world.getEntitiesOfClass(ServerPlayer.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(96 / 2d), e -> true).isEmpty()) {
				nearest_player = findEntityInWorldRange(world, Player.class, x, y, z, 96);
				if (entity instanceof Mob _entity && nearest_player instanceof LivingEntity _ent)
					_entity.setTarget(_ent);
				if (entity instanceof Mob _entity)
					_entity.getNavigation().moveTo((nearest_player.getX()), (nearest_player.getY()), (nearest_player.getZ()), 1.3);
			}
		}
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}