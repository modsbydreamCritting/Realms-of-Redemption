package com.dreamcritting.ror.special;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import com.dreamcritting.ror.RorMod;

public class CheckIfWon {
	public static void execute(Entity entity) {
		if (!(entity instanceof ServerPlayer player) || !(player.level() instanceof ServerLevel))
			return;

		RorMod.queueServerWork(5, () -> {
			if (!hasAllAdvancements(player))
				return;

			AdvancementHolder adv = player.server.getAdvancements().get(ResourceLocation.parse("ror:dimensional_domination"));

			if (adv == null)
				return;

			AdvancementProgress progress = player.getAdvancements().getOrStartProgress(adv);

			for (String criteria : progress.getRemainingCriteria()) {
				player.getAdvancements().award(adv, criteria);
			}
		});
	}

	private static final String[] REQUIRED_ADVANCEMENTS = {
			"ror:blue_screen_of_death",
			"ror:rolling_diamond_dice",
			"ror:midsummer_nights_duel",
			"ror:bodyslam",
			"ror:i_dont_want_a_dinosaur",
			"ror:access_granted"
	};

	private static boolean hasAllAdvancements(ServerPlayer player) {
		for (String id : REQUIRED_ADVANCEMENTS) {
			AdvancementHolder adv = player.server.getAdvancements().get(ResourceLocation.parse(id));

			if (adv == null || !player.getAdvancements().getOrStartProgress(adv).isDone()) {
				return false;
			}
		}
		return true;
	}
}