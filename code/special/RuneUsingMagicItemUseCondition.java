package com.dreamcritting.ror.special;

import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import com.dreamcritting.ror.init.RorModMobEffects;
import com.dreamcritting.ror.init.RorModItems;

public class RuneUsingMagicItemUseCondition {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (hasEntityInInventory(entity, new ItemStack(RorModItems.RUNE.get())) || getEntityGameType(entity) == GameType.CREATIVE) && !(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(RorModMobEffects.MAGICAL_ABILITY_COOLDOWN));
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}