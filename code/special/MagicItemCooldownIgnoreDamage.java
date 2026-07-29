package com.dreamcritting.ror.special;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import com.dreamcritting.ror.init.RorModMobEffects;
import com.dreamcritting.ror.init.RorModAttributes;

public class MagicItemCooldownIgnoreDamage {
	public static void execute(LevelAccessor world, Entity this_entity, ItemStack ammunition, ItemStack this_item, double base_cooldown) {
		if (this_entity == null)
			return;
		double final_cooldown = 0;
		final_cooldown = base_cooldown / (this_entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(RorModAttributes.MAGICAL_POWER) ? _livingEntity0.getAttribute(RorModAttributes.MAGICAL_POWER).getValue() : 0);
		if (this_entity instanceof Player _player)
			_player.getCooldowns().addCooldown(this_item.getItem(), (int) final_cooldown);
		if (Math.random() > this_item.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("ror:runic")))) / 10d) {
			if (this_entity instanceof Player _player) {
				ItemStack _stktoremove = ammunition;
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
		}
		if (this_entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(RorModMobEffects.MAGICAL_ABILITY_COOLDOWN, (int) final_cooldown, 0, false, false));
	}
}