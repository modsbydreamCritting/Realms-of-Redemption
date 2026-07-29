package com.dreamcritting.ror.item;

import com.dreamcritting.ror.init.RorModBlocks;
import com.dreamcritting.ror.init.RorModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

public class CorruptedDriveItem extends DescriptableItem {
	public CorruptedDriveItem() {
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
		double sx;
		double sy;
		double sz;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == RorModBlocks.ROBOT_TERMINAL.get() && !world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude()
				&& !world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude() && !world.getBlockState(BlockPos.containing(x, y + 3, z)).canOcclude() && !world.getBlockState(BlockPos.containing(x, y + 4, z)).canOcclude()
				&& !world.getBlockState(BlockPos.containing(x, y + 5, z)).canOcclude()) {
			itemstack.shrink(1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level) {
				RorModEntities.KILLBOT.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
			}
			sx = -4;
			for (int index3 = 0; index3 < 8; index3++) {
				sy = -4;
				for (int index4 = 0; index4 < 8; index4++) {
					sz = -4;
					for (int index5 = 0; index5 < 8; index5++) {
						if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == RorModBlocks.MONITOR_CORNER_1.get()) {
							{
								BlockPos _bp = BlockPos.containing(x + sx, y + sy, z + sz);
								BlockState _bs = RorModBlocks.BLUESCREENED_MONITOR_CORNER_1.get().defaultBlockState();
								BlockState _bso = world.getBlockState(_bp);
								for (Property<?> _propertyOld : _bso.getProperties()) {
									Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
									if (_propertyNew != null) {
										_bs.getValue(_propertyNew);
										try {
											_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
										} catch (Exception ignored) {
										}
									}
								}
								world.setBlock(_bp, _bs, 3);
							}
						} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == RorModBlocks.MONITOR_CORNER_2.get()) {
							{
								BlockPos _bp = BlockPos.containing(x + sx, y + sy, z + sz);
								BlockState _bs = RorModBlocks.BLUESCREENED_MONITOR_CORNER_2.get().defaultBlockState();
								BlockState _bso = world.getBlockState(_bp);
								for (Property<?> _propertyOld : _bso.getProperties()) {
									Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
									if (_propertyNew != null) {
										_bs.getValue(_propertyNew);
										try {
											_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
										} catch (Exception ignored) {
										}
									}
								}
								world.setBlock(_bp, _bs, 3);
							}
						} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == RorModBlocks.MONITOR_CORNER_3.get()) {
							{
								BlockPos _bp = BlockPos.containing(x + sx, y + sy, z + sz);
								BlockState _bs = RorModBlocks.BLUESCREENED_MONITOR_CORNER_3.get().defaultBlockState();
								BlockState _bso = world.getBlockState(_bp);
								for (Property<?> _propertyOld : _bso.getProperties()) {
									Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
									if (_propertyNew != null) {
										_bs.getValue(_propertyNew);
										try {
											_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
										} catch (Exception ignored) {
										}
									}
								}
								world.setBlock(_bp, _bs, 3);
							}
						} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == RorModBlocks.MONITOR_CORNER_4.get()) {
							{
								BlockPos _bp = BlockPos.containing(x + sx, y + sy, z + sz);
								BlockState _bs = RorModBlocks.BLUESCREENED_MONITOR_CORNER_4.get().defaultBlockState();
								BlockState _bso = world.getBlockState(_bp);
								for (Property<?> _propertyOld : _bso.getProperties()) {
									Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
									if (_propertyNew != null) {
										_bs.getValue(_propertyNew);
										try {
											_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
										} catch (Exception ignored) {
										}
									}
								}
								world.setBlock(_bp, _bs, 3);
							}
						}
						sz = sz + 1;
					}
					sy = sy + 1;
				}
				sx = sx + 1;
			}
		}
		return InteractionResult.SUCCESS;
	}
}