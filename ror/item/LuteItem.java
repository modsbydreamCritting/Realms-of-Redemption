package com.dreamcritting.ror.item;

import com.dreamcritting.ror.init.RorModMobEffects;
import com.dreamcritting.ror.special.LiteralInfoChatSender;
import com.dreamcritting.ror.special.MusicalItemCooldown;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import java.util.Comparator;
import java.util.List;

public class LuteItem extends Item {
	public LuteItem() {
		super(new Item.Properties().durability(200).rarity(Rarity.UNCOMMON));
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
		list.add(Component.translatable(this.getDescriptionId() + ".anger").withStyle(ChatFormatting.GRAY));
		list.add(Component.translatable(this.getDescriptionId() + ".impair").withStyle(ChatFormatting.GRAY));
		list.add(Component.translatable(this.getDescriptionId() + ".reveal").withStyle(ChatFormatting.GRAY));
		list.add(Component.translatable(this.getDescriptionId() + ".big_heal").withStyle(ChatFormatting.GRAY));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		entity.startUsingItem(hand);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		ItemStack itemstack = ar.getObject();
		String mode;
        if (!entity.hasEffect(RorModMobEffects.MUSICAL_ABILITY_COOLDOWN)) {
			mode = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("mode");
			if (entity.isShiftKeyDown()) {
				switch ((mode)) {
					case "heal" -> {
						{
							final String _tagName = "mode";
							final String _tagValue = "anger";
							CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
						}
						itemstack.set(DataComponents.CUSTOM_NAME, Component.literal((Component.translatable("item.ror.lute").getString() + " " + Component.translatable("item.ror.ability.anger").getString())));
					}
					case "anger" -> {
						{
							final String _tagName = "mode";
							final String _tagValue = "impair";
							CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
						}
						itemstack.set(DataComponents.CUSTOM_NAME, Component.literal((Component.translatable("item.ror.lute").getString() + " " + Component.translatable("item.ror.ability.impair").getString())));
					}
					case "impair" -> {
						{
							final String _tagName = "mode";
							final String _tagValue = "reveal";
							CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
						}
						itemstack.set(DataComponents.CUSTOM_NAME, Component.literal((Component.translatable("item.ror.lute").getString() + " " + Component.translatable("item.ror.ability.reveal").getString())));
					}
					case "reveal" -> {
						{
							final String _tagName = "mode";
							final String _tagValue = "big_heal";
							CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
						}
						itemstack.set(DataComponents.CUSTOM_NAME, Component.literal((Component.translatable("item.ror.lute").getString() + " " + Component.translatable("item.ror.ability.big_heal").getString())));
					}
					default -> {
						{
							final String _tagName = "mode";
							final String _tagValue = "heal";
							CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
						}
						itemstack.set(DataComponents.CUSTOM_NAME, Component.literal((Component.translatable("item.ror.lute").getString() + " " + Component.translatable("item.ror.ability.heal").getString())));
					}
				}
				LiteralInfoChatSender.execute(entity, Component.translatable("item.ror.mode_changed").getString() + " "
						+ ((Component.translatable(("item.ror.ability." + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("mode"))).getString()).replace(")", "")).replace("(", ""));
			} else if ((mode).equals("heal")) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:lute_heal")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:lute_heal")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
                if (!entity.level().isClientSide())
					entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 2, 0, false, true));
				MusicalItemCooldown.execute(world, x, y, z, entity, itemstack, 400);
			} else if ((mode).equals("big_heal")) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:lute_big_heal")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:lute_big_heal")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
                if (!entity.level().isClientSide())
					entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 2, 1, false, true));
				MusicalItemCooldown.execute(world, x, y, z, entity, itemstack, 1000);
			} else if ((mode).equals("impair")) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:lute_impair")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:lute_impair")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (Math.random() <= 0.25) {
							if (!(entityiterator == entity)) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 120, 0, true, true));
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 120, 0, true, true));
							}
						}
					}
				}
				MusicalItemCooldown.execute(world, x, y, z, entity, itemstack, 200);
			} else if ((mode).equals("reveal")) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:lute_reveal")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:lute_reveal")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (Math.random() <= 0.5) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 120, 0, false, true));
						}
					}
				}
				MusicalItemCooldown.execute(world, x, y, z, entity, itemstack, 200);
			}
		}		return ar;
	}
}