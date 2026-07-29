package com.dreamcritting.ror.special;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import com.dreamcritting.ror.init.RorModBlocks;

public class FactoryPrismUsed {
	public static void execute(LevelAccessor world, double x, double y, double z, Direction direction) {
		if (direction == null)
			return;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == RorModBlocks.BLUE_METAL_BLOCK.get()) {
			if (direction == Direction.UP) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:factory_portal_spawns")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:factory_portal_spawns")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
			}
		}
	}
}