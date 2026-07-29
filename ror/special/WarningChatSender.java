package com.dreamcritting.ror.special;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;

public class WarningChatSender {
	public static void execute(Entity entity, String message_key) {
		if (entity == null || message_key == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal((Component.translatable(message_key).getString())).withStyle(ChatFormatting.RED), false);
	}
}
