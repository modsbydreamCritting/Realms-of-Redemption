package com.dreamcritting.ror.special;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class LiteralChatSender {
	public static void execute(Entity entity, String message, String name) {
		if (entity == null || message == null || name == null)
			return;
        if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("<" + name + "> " + message)), false);
	}
}