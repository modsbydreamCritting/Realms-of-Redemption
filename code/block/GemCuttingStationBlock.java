package com.dreamcritting.ror.block;

import com.dreamcritting.ror.init.RorModBlocks;
import com.dreamcritting.ror.init.RorModItems;
import com.dreamcritting.ror.special.LiteralInfoChatSender;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.core.BlockPos;

import com.dreamcritting.ror.special.GemCuttingStationNeighbourBlockChanges;

public class GemCuttingStationBlock extends Block {
	public GemCuttingStationBlock() {
		super(BlockBehaviour.Properties.of().strength(50f, 1200f).instrument(NoteBlockInstrument.BASEDRUM));
	}

	@Override
	public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
		GemCuttingStationNeighbourBlockChanges.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public InteractionResult useWithoutItem(BlockState blockstate, Level world, BlockPos pos, Player entity, BlockHitResult hit) {
		super.useWithoutItem(blockstate, world, pos, entity, hit);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
        if (entity.getMainHandItem().getItem() == RorModItems.UNCUT_TSAVORITE.get()) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(RorModItems.UNCUT_TSAVORITE.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.end_portal_frame.fill")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.end_portal_frame.fill")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
			world.setBlock(BlockPos.containing(x, y, z), RorModBlocks.GEM_CUTTING_STATION_TSAVORITE.get().defaultBlockState(), 3);
		} else {
            if (entity.getMainHandItem().getItem() == RorModItems.UNCUT_TOURMALINE.get()) {
                if (entity instanceof Player _player) {
                    ItemStack _stktoremove = new ItemStack(RorModItems.UNCUT_TOURMALINE.get());
                    _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                }
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.end_portal_frame.fill")), SoundSource.BLOCKS, 1, 1);
                    } else {
                        _level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.end_portal_frame.fill")), SoundSource.BLOCKS, 1, 1, false);
                    }
                }
                world.setBlock(BlockPos.containing(x, y, z), RorModBlocks.GEM_CUTTING_STATION_TOURMALINE.get().defaultBlockState(), 3);
            } else {
if (entity.getMainHandItem().getItem() == RorModItems.UNCUT_XOLITE.get()) {
if (entity instanceof Player _player) {
ItemStack _stktoremove = new ItemStack(RorModItems.UNCUT_XOLITE.get());
_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
}
if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.end_portal_frame.fill")), SoundSource.BLOCKS, 1, 1);
} else {
_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.end_portal_frame.fill")), SoundSource.BLOCKS, 1, 1, false);
}
}
world.setBlock(BlockPos.containing(x, y, z), RorModBlocks.GEM_CUTTING_STATION_XOLITE.get().defaultBlockState(), 3);
} else {
LiteralInfoChatSender.execute(entity, Component.translatable("block.ror.gem_cutting_station.fail").getString());
}
}
        }
		return InteractionResult.SUCCESS;
	}
}