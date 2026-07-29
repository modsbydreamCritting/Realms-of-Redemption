package com.dreamcritting.ror.special;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class PlacerOnEntityTickUpdate {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		// Umm... gonna assume this is done like this for a reason, the other traders are just included in the structures but maybe this one breaks.
		if (world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("ror:is_neon_city")))) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"summon villager ~ ~ ~ {VillagerData:{type:plains,profession:\"ror:neon_trader\",level:2},Offers:{Recipes:[{maxUses:10,buy:{id:\"ror:neon_coin\",count:1},sell:{id:bread,count:6}},{maxUses:10,buy:{id:\"ror:neon_coin\",count:4},sell:{id:\"ror:neon_city\",count:1}},{maxUses:10,buy:{id:\"ror:neon_coin\",count:1},sell:{id:\"ror:rune\",count:12}},{maxUses:10,buy:{id:\"ror:neon_coin\",count:8},sell:{id:diamond,count:1}},{maxUses:10,buy:{id:\"ror:neon_coin\",count:15},sell:{id:golden_apple,count:1}},{maxUses:10,buy:{id:\"ror:neon_coin\",count:4},sell:{id:\"ror:tsavorite\",count:1}},{maxUses:10,buy:{id:\"ror:rubellite_heart\",count:1},sell:{id:\"ror:neon_coin\",count:4}},{maxUses:10,buy:{id:\"ror:neon_coin\",count:10},sell:{id:\"ror:neon_helmet\",count:1}},{maxUses:10,buy:{id:\"ror:neon_coin\",count:10},sell:{id:\"ror:neon_chestplate\",count:1}},{maxUses:10,buy:{id:\"ror:neon_coin\",count:10},sell:{id:\"ror:neon_leggings\",count:1}},{maxUses:10,buy:{id:\"ror:neon_coin\",count:10},sell:{id:\"ror:neon_boots\",count:1}},{maxUses:10,buy:{id:\"ror:neon_coin\",count:64},sell:{id:\"ror:top_helmet\",count:1}},{maxUses:10,buy:{id:\"ror:cyan_neon_block\",count:32},buyB:{id:\"ror:neon_coin\",count:1},sell:{id:\"ror:pink_neon_block\",count:32}}]},Health:50,attributes:[{id:\"generic.max_health\",base:50f}]}");
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}