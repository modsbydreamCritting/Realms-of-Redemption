package com.dreamcritting.ror.item;

import com.dreamcritting.ror.init.RorModMobEffects;
import net.minecraft.ChatFormatting;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.registries.RegisterEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Holder;
import net.minecraft.Util;

import java.util.Comparator;
import java.util.List;
import java.util.EnumMap;

import com.google.common.collect.Iterables;

import com.dreamcritting.ror.init.RorModItems;

@EventBusSubscriber
public abstract class GhostlyItem extends ArmorItem {
	public static Holder<ArmorMaterial> ARMOR_MATERIAL = null;

	@SubscribeEvent
	public static void registerArmorMaterial(RegisterEvent event) {
		event.register(Registries.ARMOR_MATERIAL, registerHelper -> {
			ArmorMaterial armorMaterial = new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
				map.put(ArmorItem.Type.BOOTS, 3);
				map.put(ArmorItem.Type.LEGGINGS, 6);
				map.put(ArmorItem.Type.CHESTPLATE, 8);
				map.put(ArmorItem.Type.HELMET, 3);
				map.put(ArmorItem.Type.BODY, 8);
			}), 12, DeferredHolder.create(Registries.SOUND_EVENT, ResourceLocation.parse("item.armor.equip_diamond")), () -> Ingredient.of(new ItemStack(RorModItems.ECTOPLASM.get())),
					List.of(new ArmorMaterial.Layer(ResourceLocation.parse("ror:ghost"))), 2.3f, 0f);
			registerHelper.register(ResourceLocation.parse("ror:ghostly"), armorMaterial);
			ARMOR_MATERIAL = BuiltInRegistries.ARMOR_MATERIAL.wrapAsHolder(armorMaterial);
		});
	}

	public GhostlyItem(ArmorItem.Type type, Item.Properties properties) {
		super(ARMOR_MATERIAL, type, properties);
	}

	public static class Helmet extends GhostlyItem {
		public Helmet() {
			super(ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(35)));
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, list, flag);
			list.add(Component.translatable("item.ror.ghostly_armor.buff").withStyle(ChatFormatting.GRAY));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
                double nearby_mob_max_health;
				double max_health_to_trigger;
				if (Math.random() <= 0.05) {
                    LivingEntity _entGetArmor = (LivingEntity) entity;
                    if (_entGetArmor.getItemBySlot(EquipmentSlot.CHEST).getItem() == RorModItems.GHOSTLY_CHESTPLATE.get()) {
                        if (_entGetArmor.getItemBySlot(EquipmentSlot.LEGS).getItem() == RorModItems.GHOSTLY_LEGGINGS.get()) {
                            if (_entGetArmor.getItemBySlot(EquipmentSlot.FEET).getItem() == RorModItems.GHOSTLY_BOOTS.get()) {
                                LivingEntity _livEnt = (LivingEntity) entity;
                                if (_livEnt.getOffhandItem().getItem() == RorModItems.FEAR_EMBLEM.get()) {
                                    max_health_to_trigger = 30;
                                } else {
                                    max_health_to_trigger = 13;
                                }
                                {
                                    final Vec3 _center = new Vec3(x, y, z);
                                    for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
                                        if (!(entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("ror:ghostly_armor_effect_immune"))) || entityiterator instanceof Player)) {
                                            nearby_mob_max_health = entityiterator instanceof LivingEntity _livEnt2 ? _livEnt2.getMaxHealth() : -1;
                                            if (nearby_mob_max_health < max_health_to_trigger) {
                                                if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                                    _entity.addEffect(new MobEffectInstance(RorModMobEffects.FEAR, 200, (int) Math.round(nearby_mob_max_health / 2)));
                                                if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                                    _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 1));
                                                if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                                    _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 0));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
				}
			}
		}
	}

	public static class Chestplate extends GhostlyItem {
		public Chestplate() {
			super(ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(35)));
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, list, flag);
			list.add(Component.translatable("item.ror.ghostly_armor.buff").withStyle(ChatFormatting.GRAY));
		}
	}

	public static class Leggings extends GhostlyItem {
		public Leggings() {
			super(ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(35)));
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, list, flag);
			list.add(Component.translatable("item.ror.ghostly_armor.buff").withStyle(ChatFormatting.GRAY));
		}
	}

	public static class Boots extends GhostlyItem {
		public Boots() {
			super(ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(35)));
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, list, flag);
			list.add(Component.translatable("item.ror.ghostly_armor.buff").withStyle(ChatFormatting.GRAY));
		}
	}
}