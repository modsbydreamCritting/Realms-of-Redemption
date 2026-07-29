package com.dreamcritting.ror.special;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;

public class LiteralInfoChatSender {
	public static void execute(Entity entity, String message) {
		if (entity == null || message == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(message).withStyle(ChatFormatting.GRAY), false);
	}
}
