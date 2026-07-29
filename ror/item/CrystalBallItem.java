package com.dreamcritting.ror.item;

import com.dreamcritting.ror.init.RorModBlocks;
import com.dreamcritting.ror.init.RorModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import net.minecraft.world.level.Level;

public class CrystalBallItem extends DescriptableItem {
	public CrystalBallItem() {
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
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == RorModBlocks.TITANIA_ALTAR.get() && !world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude()
				&& !world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude() && !world.getBlockState(BlockPos.containing(x, y + 3, z)).canOcclude() && !world.getBlockState(BlockPos.containing(x, y + 4, z)).canOcclude()
				&& !world.getBlockState(BlockPos.containing(x, y + 5, z)).canOcclude()) {
			itemstack.shrink(1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:titania_spawns")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:titania_spawns")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level) {
				RorModEntities.TITANIA.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
			}
		}
		return InteractionResult.SUCCESS;
	}
}