package com.dreamcritting.ror.item;

import com.dreamcritting.ror.init.RorModBlocks;
import com.dreamcritting.ror.init.RorModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Level;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

public class PrismiteHeartItem extends DescriptableItem {
	public PrismiteHeartItem() {
		super(new Item.Properties().rarity(Rarity.UNCOMMON));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		Level world = context.getLevel();
		double x = context.getClickedPos().getX();
		double y = context.getClickedPos().getY();
		double z = context.getClickedPos().getZ();
		ItemStack itemstack = context.getItemInHand();
		if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == RorModBlocks.CRYSTAL_ALTAR.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == RorModBlocks.CRYSTAL_ALTAR_ACTIVATED.get())
				&& !world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude() && !world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude() && !world.getBlockState(BlockPos.containing(x, y + 3, z)).canOcclude()
				&& !world.getBlockState(BlockPos.containing(x, y + 4, z)).canOcclude()) {
			itemstack.shrink(1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.EXPLOSION_EMITTER, x, y, z, 5, 0.5, 0.5, 0.5, 1);
			if (world instanceof ServerLevel _level) {
				RorModEntities.CORRUNDODILE.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
			}
			world.setBlock(BlockPos.containing(x, y, z), RorModBlocks.CRYSTAL_ALTAR_ACTIVATED.get().defaultBlockState(), 3);
		}
		return InteractionResult.SUCCESS;
	}
}