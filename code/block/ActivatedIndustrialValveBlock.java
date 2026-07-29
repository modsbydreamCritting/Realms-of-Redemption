package com.dreamcritting.ror.block;

import com.dreamcritting.ror.init.RorModBlocks;
import com.dreamcritting.ror.init.RorModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class ActivatedIndustrialValveBlock extends OmnidirectionalBlock {

	public ActivatedIndustrialValveBlock() {
		super(BlockBehaviour.Properties.of().strength(6f, 9f).instrument(NoteBlockInstrument.BASEDRUM));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public InteractionResult useWithoutItem(BlockState blockstate, Level world, BlockPos pos, Player entity, BlockHitResult hit) {
		super.useWithoutItem(blockstate, world, pos, entity, hit);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
        ItemStack item_to_spawn = ItemStack.EMPTY;
		ItemStack item_held;
		BlockState block_to_place = Blocks.AIR.defaultBlockState();
		BlockState container_used;
		boolean valve_works = false;
        item_held = entity.getMainHandItem().copy();
		container_used = (world.getBlockState(BlockPos.containing(x, y - 1, z)));
		if (container_used.getBlock() == RorModBlocks.SPECTRA_TANK.get()) {
			if (item_held.getItem() == RorModItems.EMPTY_CANISTER.get()) {
				block_to_place = RorModBlocks.EMPTY_TANK.get().defaultBlockState();
				item_to_spawn = new ItemStack(RorModItems.SPECTRA_CANISTER.get()).copy();
				valve_works = true;
			}
		} else if (container_used.getBlock() == RorModBlocks.POWER_CELL.get()) {
			if (item_held.getItem() == RorModItems.EMPTY_CANISTER.get()) {
				block_to_place = RorModBlocks.EMPTY_POWER_CELL.get().defaultBlockState();
				item_to_spawn = new ItemStack(RorModItems.ENERGY_CANISTER.get()).copy();
				valve_works = true;
			}
		} else if (container_used.getBlock() == RorModBlocks.TOXIC_SLUDGE_TANK.get()) {
			if (item_held.getItem() == RorModItems.CONTAINMENT_BOX.get()) {
				block_to_place = RorModBlocks.EMPTY_TANK.get().defaultBlockState();
				item_to_spawn = new ItemStack(RorModItems.TOXIC_SLUDGE_CONTAINMENT_BOX.get()).copy();
				valve_works = true;
			}
		} else if (container_used.getBlock() == RorModBlocks.BLOOD_TANK.get()) {
			if (item_held.getItem() == RorModItems.EMPTY_CANISTER.get()) {
				block_to_place = RorModBlocks.EMPTY_TANK.get().defaultBlockState();
				item_to_spawn = new ItemStack(RorModItems.BLOOD_CANISTER.get()).copy();
				valve_works = true;
			}
		}
		if (valve_works) {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), item_to_spawn);
				entityToSpawn.setPickUpDelay(1);
				_level.addFreshEntity(entityToSpawn);
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.brewing_stand.brew")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.brewing_stand.brew")), SoundSource.BLOCKS, 1, 1, false);
				}
			}

			world.setBlock(BlockPos.containing(x, y - 1, z), block_to_place, 3);
			entity.getMainHandItem().shrink(1);
		}
		return InteractionResult.SUCCESS;
    }
}