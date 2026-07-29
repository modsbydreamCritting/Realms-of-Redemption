package com.dreamcritting.ror.special;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;

public class GemCuttingChatSender {
	public static void execute(Entity entity, double chance) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal((Component.translatable("block.ror.gem_cutting_station.cutting").getString() + "" + chance + Component.translatable("block.ror.gem_cutting_station.cutting2").getString())).withStyle(ChatFormatting.GRAY), false);
	}
}
