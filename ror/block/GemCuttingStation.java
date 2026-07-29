
package com.dreamcritting.ror.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

import com.dreamcritting.ror.special.GemCuttingStationNeighbourBlockChanges;

public class GemCuttingStation extends Block {
    public GemCuttingStation() {
        super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(50f, 1200f).requiresCorrectToolForDrops().mapColor(MapColor.WATER));
    }

    @Override
    public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
        super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
        GemCuttingStationNeighbourBlockChanges.execute(world, pos.getX(), pos.getY(), pos.getZ());
    }
}
