package com.dreamcritting.ror.special;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import java.util.Comparator;

import com.dreamcritting.ror.init.RorModItems;
import com.dreamcritting.ror.init.RorModBlocks;

public class GemCuttingStationNeighbourBlockChanges {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		BlockState BlockAbove;
		double CuttingChance = 0;
		BlockAbove = (world.getBlockState(BlockPos.containing(x, y + 1, z)));
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == RorModBlocks.GEM_CUTTING_STATION_TSAVORITE.get()) {
			if (BlockAbove.getBlock() == RorModBlocks.DIAMOND_GEM_CUTTER.get()) {
				CuttingChance = 0.3;
			} else if (BlockAbove.getBlock() == RorModBlocks.TSAVORITE_GEM_CUTTER.get()) {
				CuttingChance = 0.4;
			} else if (BlockAbove.getBlock() == RorModBlocks.TOURMALINE_GEM_CUTTER.get()) {
				CuttingChance = 0.5;
			} else if (BlockAbove.getBlock() == RorModBlocks.INCOMPLETE_GEM_CUTTER.get()) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(24 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (entityiterator instanceof Player) {
							LiteralInfoChatSender.execute(entityiterator, Component.translatable("block.ror.gem_cutting_station.cutting_head_required").getString());
						}
					}
				}
			}
			if (BlockAbove.is(BlockTags.create(ResourceLocation.parse("ror:gem_cutters")))) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(24 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (entityiterator instanceof Player) {
							GemCuttingChatSender.execute(entityiterator, CuttingChance * 100);
						}
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.grindstone.use")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.grindstone.use")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
				if (Math.random() <= CuttingChance) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(RorModItems.TSAVORITE.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					{
						final Vec3 _center = new Vec3(x, y, z);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(24 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (entityiterator instanceof Player) {
								GreenChatSender.execute(entityiterator, "block.ror.gem_cutting_station.success");
							}
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.chime")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.chime")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
				} else {
					{
						final Vec3 _center = new Vec3(x, y, z);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(24 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (entityiterator instanceof Player) {
								LiteralInfoChatSender.execute(entityiterator, Component.translatable("block.ror.gem_cutting_station.shatter").getString());
							}
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.break")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.break")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
				}
				world.setBlock(BlockPos.containing(x, y, z), RorModBlocks.GEM_CUTTING_STATION.get().defaultBlockState(), 3);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == RorModBlocks.GEM_CUTTING_STATION_TOURMALINE.get()) {
			if (BlockAbove.getBlock() == RorModBlocks.DIAMOND_GEM_CUTTER.get()) {
				CuttingChance = 0.05;
			} else if (BlockAbove.getBlock() == RorModBlocks.TSAVORITE_GEM_CUTTER.get()) {
				CuttingChance = 0.1;
			} else if (BlockAbove.getBlock() == RorModBlocks.TOURMALINE_GEM_CUTTER.get()) {
				CuttingChance = 0.15;
			} else if (BlockAbove.getBlock() == RorModBlocks.INCOMPLETE_GEM_CUTTER.get()) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(24 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (entityiterator instanceof Player) {
							LiteralInfoChatSender.execute(entityiterator, Component.translatable("block.ror.gem_cutting_station.cutting_head_required").getString());
						}
					}
				}
			}
			if (BlockAbove.is(BlockTags.create(ResourceLocation.parse("ror:gem_cutters")))) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(24 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (entityiterator instanceof Player) {
							GemCuttingChatSender.execute(entityiterator, CuttingChance * 100);
						}
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.grindstone.use")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.grindstone.use")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
				if (Math.random() <= CuttingChance) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(RorModItems.TOURMALINE.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					{
						final Vec3 _center = new Vec3(x, y, z);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(24 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (entityiterator instanceof Player) {
								GreenChatSender.execute(entityiterator, "block.ror.gem_cutting_station.success");
							}
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.chime")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.chime")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
				} else {
					{
						final Vec3 _center = new Vec3(x, y, z);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(24 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (entityiterator instanceof Player) {
								LiteralInfoChatSender.execute(entityiterator, Component.translatable("block.ror.gem_cutting_station.shatter").getString());
							}
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.break")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.break")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
				}
				world.setBlock(BlockPos.containing(x, y, z), RorModBlocks.GEM_CUTTING_STATION.get().defaultBlockState(), 3);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == RorModBlocks.GEM_CUTTING_STATION_XOLITE.get()) {
			if (BlockAbove.getBlock() == RorModBlocks.DIAMOND_GEM_CUTTER.get()) {
				CuttingChance = 0.07;
			} else if (BlockAbove.getBlock() == RorModBlocks.TSAVORITE_GEM_CUTTER.get()) {
				CuttingChance = 0.15;
			} else if (BlockAbove.getBlock() == RorModBlocks.TOURMALINE_GEM_CUTTER.get()) {
				CuttingChance = 0.3;
			} else if (BlockAbove.getBlock() == RorModBlocks.INCOMPLETE_GEM_CUTTER.get()) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(24 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (entityiterator instanceof Player) {
							LiteralInfoChatSender.execute(entityiterator, Component.translatable("block.ror.gem_cutting_station.cutting_head_required").getString());
						}
					}
				}
			}
			if (BlockAbove.is(BlockTags.create(ResourceLocation.parse("ror:gem_cutters")))) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(24 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (entityiterator instanceof Player) {
							GemCuttingChatSender.execute(entityiterator, CuttingChance * 100);
						}
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.grindstone.use")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.grindstone.use")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
				if (Math.random() <= CuttingChance) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(RorModItems.XOLITE.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					{
						final Vec3 _center = new Vec3(x, y, z);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(24 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (entityiterator instanceof Player) {
								GreenChatSender.execute(entityiterator, "block.ror.gem_cutting_station.success");
							}
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.chime")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.chime")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
				} else {
					{
						final Vec3 _center = new Vec3(x, y, z);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(24 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (entityiterator instanceof Player) {
								LiteralInfoChatSender.execute(entityiterator, Component.translatable("block.ror.gem_cutting_station.shatter").getString());
							}
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.break")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.break")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
				}
				world.setBlock(BlockPos.containing(x, y, z), RorModBlocks.GEM_CUTTING_STATION.get().defaultBlockState(), 3);
			}
		}
	}
}