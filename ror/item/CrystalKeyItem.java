package com.dreamcritting.ror.item;

import com.dreamcritting.ror.init.RorModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

public class CrystalKeyItem extends DescriptableItem {
	public CrystalKeyItem() {
		super(new Item.Properties());
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		Level world = context.getLevel();
		double x = context.getClickedPos().getX();
		double y = context.getClickedPos().getY();
		double z = context.getClickedPos().getZ();
		ItemStack itemstack = context.getItemInHand();
		if ((world.getBlockState(BlockPos.containing(x, y, z))) == RorModBlocks.WHITE_CRYSTAL_KEYBLOCK.get().defaultBlockState()
				&& (world.getBlockState(BlockPos.containing(x, y + 1, z))) == RorModBlocks.WHITE_CRYSTAL_KEYBLOCK.get().defaultBlockState()) {
			world.destroyBlock(BlockPos.containing(x, y, z), false);
			world.destroyBlock(BlockPos.containing(x, y + 1, z), false);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.ender_chest.open")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.ender_chest.open")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
			itemstack.shrink(1);
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))) == RorModBlocks.WHITE_CRYSTAL_KEYBLOCK.get().defaultBlockState()
				&& (world.getBlockState(BlockPos.containing(x, y - 1, z))) == RorModBlocks.WHITE_CRYSTAL_KEYBLOCK.get().defaultBlockState()) {
			world.destroyBlock(BlockPos.containing(x, y, z), false);
			world.destroyBlock(BlockPos.containing(x, y - 1, z), false);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.ender_chest.open")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.ender_chest.open")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
			itemstack.shrink(1);
		}
		return InteractionResult.SUCCESS;
	}
}