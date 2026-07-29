package com.dreamcritting.ror.special;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class DontAttackPlayers {
	public static boolean execute(Entity entity) {
		Entity target;
		target = entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null;
		if (!(target == null)) {
			return !(target instanceof Player || target.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("eyelid:good"))));
		}
		return true;
	}
}