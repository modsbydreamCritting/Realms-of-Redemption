
package com.dreamcritting.ror.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.neoforged.neoforge.common.util.TriState;

public class PlantSustainingBlock extends Block {
    public PlantSustainingBlock(Properties properties) {
        super(properties);
    }

    @Override
    public TriState canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction direction, BlockState plant) {
        return TriState.TRUE;
    }
}
