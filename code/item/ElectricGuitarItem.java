package com.dreamcritting.ror.item;

import com.dreamcritting.ror.init.RorModBlocks;
import com.dreamcritting.ror.init.RorModMobEffects;
import com.dreamcritting.ror.special.LiteralInfoChatSender;
import com.dreamcritting.ror.special.MusicalItemCooldown;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import java.util.Comparator;
import java.util.List;

public class ElectricGuitarItem extends Item {
	public ElectricGuitarItem() {
		super(new Item.Properties().durability(256));
	}

	@Override
	public int getUseDuration(ItemStack itemstack, LivingEntity livingEntity) {
		return 80;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable(this.getDescriptionId() + ".desc").withStyle(ChatFormatting.GRAY));
		list.add(Component.translatable(this.getDescriptionId() + ".heal").withStyle(ChatFormatting.GRAY));
		list.add(Component.translatable(this.getDescriptionId() + ".impair").withStyle(ChatFormatting.GRAY));
		list.add(Component.translatable(this.getDescriptionId() + ".attack").withStyle(ChatFormatting.GRAY));
		list.add(Component.translatable(this.getDescriptionId() + ".disconnect").withStyle(ChatFormatting.GRAY));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		entity.startUsingItem(hand);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		ItemStack itemstack = ar.getObject();
		double centerx = 0;
		double centery = 0;
		double centerz = 0;
		double ampx;
		double ampy;
		double ampz;
		String mode;
        if (!entity.hasEffect(RorModMobEffects.MUSICAL_ABILITY_COOLDOWN)) {
			mode = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("mode");
			if (entity.isShiftKeyDown()) {
				switch ((mode)) {
					case "heal" -> {
						{
							final String _tagName = "mode";
							final String _tagValue = "impair";
							CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
						}
						itemstack.set(DataComponents.CUSTOM_NAME, Component.literal((Component.translatable("item.ror.electric_guitar").getString() + " " + Component.translatable("item.ror.ability.impair").getString())));
					}
					case "impair" -> {
						{
							final String _tagName = "mode";
							final String _tagValue = "attack";
							CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
						}
						itemstack.set(DataComponents.CUSTOM_NAME, Component.literal((Component.translatable("item.ror.electric_guitar").getString() + " " + Component.translatable("item.ror.ability.attack").getString())));
					}
					case "attack" -> {
						{
							final String _tagName = "mode";
							final String _tagValue = "disconnect";
							CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
						}
						itemstack.set(DataComponents.CUSTOM_NAME, Component.literal((Component.translatable("item.ror.electric_guitar").getString() + " " + Component.translatable("item.ror.ability.disconnect").getString())));
					}
					default -> {
						{
							final String _tagName = "mode";
							final String _tagValue = "heal";
							CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
						}
						itemstack.set(DataComponents.CUSTOM_NAME, Component.literal((Component.translatable("item.ror.electric_guitar").getString() + " " + Component.translatable("item.ror.ability.heal").getString())));
					}
				}
				LiteralInfoChatSender.execute(entity, Component.translatable("item.ror.mode_changed").getString() + " "
						+ ((Component.translatable(("item.ror.ability." + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("mode"))).getString()).replace(")", "")).replace("(", ""));
			} else if ((mode).equals("heal")) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:electric_guitar_heal")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:electric_guitar_heal")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
                if (!entity.level().isClientSide())
					entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 2, 0, false, true));
				MusicalItemCooldown.execute(world, x, y, z, entity, itemstack, 200);
			} else if ((mode).equals("impair")) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:electric_guitar_impair")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:electric_guitar_impair")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (Math.random() <= 0.5) {
							if (!(entityiterator instanceof Player)) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 120, 0, true, true));
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 120, 0, true, true));
							}
						}
					}
				}
				MusicalItemCooldown.execute(world, x, y, z, entity, itemstack, 180);
			} else if ((mode).equals("attack")) {
				ampx = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("amp_x");
				ampy = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("amp_y");
				ampz = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("amp_z");
				if ((world.getBlockState(BlockPos.containing(ampx, ampy, ampz))).getBlock() == RorModBlocks.AMP.get()) {
					centerx = ampx;
					centery = ampy;
					centerz = ampz;
					{
						final Vec3 _center = new Vec3(centerx, centery, centerz);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC), entity), 6);
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.NOTE, x, y, z, 1, 0.2, 1, 0.2, 0.2);
						}
					}
				} else if ((world.getBlockState(BlockPos.containing(ampx, ampy, ampz))).getBlock() == RorModBlocks.RADIANT_MAGNOLITE_AMP.get()) {
					centerx = ampx;
					centery = ampy;
					centerz = ampz;
					{
						final Vec3 _center = new Vec3(centerx, centery, centerz);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC), entity), 9);
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.NOTE, x, y, z, 1, 0.2, 1, 0.2, 0.2);
						}
					}
				} else {
					centerx = entity.getX();
					centery = entity.getY();
					centerz = entity.getZ();
					{
						final Vec3 _center = new Vec3(centerx, centery, centerz);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC), entity), 3);
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.NOTE, x, y, z, 1, 0.2, 1, 0.2, 0.2);
						}
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(centerx, centery, centerz), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:electric_guitar_chords")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(centerx, centery, centerz, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:electric_guitar_chords")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
				MusicalItemCooldown.execute(world, x, y, z, entity, itemstack, 6);
			} else if ((mode).equals("disconnect")) {
				if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("amp_x") != 0 && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("amp_y") != 0
						&& itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("amp_z") != 0) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.stone_button.click_off")), SoundSource.BLOCKS, 1, (float) 0.8);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.stone_button.click_off")), SoundSource.BLOCKS, 1, (float) 0.8, false);
						}
					}
					{
						final String _tagName = "amp_x";
						final double _tagValue = 0;
						CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
					}
					{
						final String _tagName = "amp_y";
						final double _tagValue = 0;
						CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
					}
					{
						final String _tagName = "amp_z";
						final double _tagValue = 0;
						CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
					}
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.NOTE, centerx, centery, centerz, 1, 0.2, 1, 0.2, 0.2);
		}
		return ar;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		Level world = context.getLevel();
		double x = context.getClickedPos().getX();
		double y = context.getClickedPos().getY();
		double z = context.getClickedPos().getZ();
		ItemStack itemstack = context.getItemInHand();
		if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("ror:amps")))) {
			{
				final String _tagName = "amp_x";
				final double _tagValue = x;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "amp_y";
				final double _tagValue = y;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "amp_z";
				final double _tagValue = z;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.stone_button.click_on")), SoundSource.BLOCKS, 1, (float) 0.8);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.stone_button.click_on")), SoundSource.BLOCKS, 1, (float) 0.8, false);
				}
			}
		}
		return InteractionResult.SUCCESS;
	}
}