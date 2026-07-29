package com.dreamcritting.ror.special;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import com.dreamcritting.ror.init.RorModMobEffects;
import com.dreamcritting.ror.init.RorModAttributes;

public class MagicItemCooldownIgnoreDamageAndAmmo {
	public static void execute(Entity entity, Entity this_entity, ItemStack this_item, double base_cooldown) {
		if (entity == null || this_entity == null)
			return;
		double final_cooldown;
		final_cooldown = base_cooldown / (this_entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(RorModAttributes.MAGICAL_POWER) ? _livingEntity0.getAttribute(RorModAttributes.MAGICAL_POWER).getValue() : 0);
		if (this_entity instanceof Player _player)
			_player.getCooldowns().addCooldown(this_item.getItem(), (int) final_cooldown);
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(RorModMobEffects.MAGICAL_ABILITY_COOLDOWN, (int) final_cooldown, 0, false, false));
	}
}