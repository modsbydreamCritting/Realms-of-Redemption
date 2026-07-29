package com.dreamcritting.ror.block;

import com.dreamcritting.ror.init.RorModBlocks;
import com.dreamcritting.ror.init.RorModItems;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.core.BlockPos;

public class RetinalScannerBlock extends Block {
	public RetinalScannerBlock() {
		super(BlockBehaviour.Properties.of().strength(-1, 3600000).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM));
	}

	@Override
	public InteractionResult useWithoutItem(BlockState blockstate, Level world, BlockPos pos, Player entity, BlockHitResult hit) {
		super.useWithoutItem(blockstate, world, pos, entity, hit);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		double sx;
		double sz;
        if (entity.getMainHandItem().getItem() == RorModItems.GOOGLOID_EYE.get()) {
			sx = -2;
			for (int index18 = 0; index18 < 5; index18++) {
				sz = -2;
				for (int index19 = 0; index19 < 5; index19++) {
					if ((world.getBlockState(BlockPos.containing(x + sx, y - 2, z + sz))).getBlock() == RorModBlocks.SOLID_MOON_DUNGEON_FORCE_FIELD.get()) {
						world.destroyBlock(BlockPos.containing(x + sx, y - 2, z + sz), false);
					}
					sz = sz + 1;
				}
				sx = sx + 1;
			}
			if (entity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("ror:access_granted"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}		return InteractionResult.SUCCESS;
	}
}