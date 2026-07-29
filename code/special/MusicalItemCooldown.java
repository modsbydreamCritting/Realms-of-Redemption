package com.dreamcritting.ror.special;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import com.dreamcritting.ror.init.RorModAttributes;

public class MusicalItemCooldown {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity this_entity, ItemStack this_item, double base_cooldown) {
		if (this_entity == null)
			return;
        if (this_entity instanceof Player _player) {
            _player.getCooldowns().addCooldown(this_item.getItem(), (int) (base_cooldown
                    / (_player.getAttributes().hasAttribute(RorModAttributes.MUSICAL_POWER) ? _player.getAttribute(RorModAttributes.MUSICAL_POWER).getValue() : 0)));
        }
		if (world instanceof ServerLevel _level) {
			this_item.hurtAndBreak(1, _level, null, _stkprov -> {
			});
		}
		if (this_entity instanceof Player _player)
			_player.causeFoodExhaustion((float) 0.1);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.NOTE, x, y, z, 4, 0.2, 1, 0.2, 0.2);
	}
}