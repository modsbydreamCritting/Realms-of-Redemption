package com.dreamcritting.ror.block;

import net.minecraft.world.level.block.WaterloggedTransparentBlock;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class IndustrialMetalGrateBlock extends WaterloggedTransparentBlock {

	public IndustrialMetalGrateBlock() {
		super(BlockBehaviour.Properties.of().strength(5f, 7f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false).instrument(NoteBlockInstrument.BASEDRUM));
		this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false));
	}
}