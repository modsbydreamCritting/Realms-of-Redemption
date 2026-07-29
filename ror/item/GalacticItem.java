package com.dreamcritting.ror.item;

import net.neoforged.neoforge.registries.RegisterEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Holder;
import net.minecraft.Util;

import java.util.List;
import java.util.EnumMap;

import com.dreamcritting.ror.init.RorModItems;
import com.dreamcritting.ror.RorMod;

@EventBusSubscriber
public abstract class GalacticItem extends ArmorItem {
	public static Holder<ArmorMaterial> ARMOR_MATERIAL = null;

	@SubscribeEvent
	public static void registerArmorMaterial(RegisterEvent event) {
		event.register(Registries.ARMOR_MATERIAL, registerHelper -> {
			ArmorMaterial armorMaterial = new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
				map.put(ArmorItem.Type.BOOTS, 4);
				map.put(ArmorItem.Type.LEGGINGS, 7);
				map.put(ArmorItem.Type.CHESTPLATE, 9);
				map.put(ArmorItem.Type.HELMET, 4);
				map.put(ArmorItem.Type.BODY, 9);
			}), 12, BuiltInRegistries.SOUND_EVENT.wrapAsHolder(SoundEvents.EMPTY), () -> Ingredient.of(new ItemStack(RorModItems.GALACTITE_INGOT.get())), List.of(new ArmorMaterial.Layer(ResourceLocation.parse("ror:galactic_"))), 3.4f, 0f);
			registerHelper.register(ResourceLocation.parse("ror:galactic"), armorMaterial);
			ARMOR_MATERIAL = BuiltInRegistries.ARMOR_MATERIAL.wrapAsHolder(armorMaterial);
		});
	}

	public GalacticItem(ArmorItem.Type type, Item.Properties properties) {
		super(ARMOR_MATERIAL, type, properties);
	}

	public static class Helmet extends GalacticItem {
		public Helmet() {
			super(ArmorItem.Type.HELMET,
					new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(40))
							.attributes(ItemAttributeModifiers.builder().add(Attributes.ARMOR, new AttributeModifier(ResourceLocation.withDefaultNamespace("armor.helmet"), 4, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.HEAD)
									.add(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(ResourceLocation.withDefaultNamespace("armor.helmet"), 3.4, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.HEAD)
									.add(Attributes.GRAVITY, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(RorMod.MODID, "galactic_0.helmet"), -0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), EquipmentSlotGroup.ANY).build()));
		}
	}

	public static class Chestplate extends GalacticItem {
		public Chestplate() {
			super(ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(40))
					.attributes(ItemAttributeModifiers.builder().add(Attributes.ARMOR, new AttributeModifier(ResourceLocation.withDefaultNamespace("armor.chestplate"), 9, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.CHEST)
							.add(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(ResourceLocation.withDefaultNamespace("armor.chestplate"), 3.4, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.CHEST)
							.add(Attributes.GRAVITY, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(RorMod.MODID, "galactic_0.chestplate"), -0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), EquipmentSlotGroup.ANY).build()));
		}
	}

	public static class Leggings extends GalacticItem {
		public Leggings() {
			super(ArmorItem.Type.LEGGINGS,
					new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(40))
							.attributes(ItemAttributeModifiers.builder().add(Attributes.ARMOR, new AttributeModifier(ResourceLocation.withDefaultNamespace("armor.leggings"), 7, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.LEGS)
									.add(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(ResourceLocation.withDefaultNamespace("armor.leggings"), 3.4, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.LEGS)
									.add(Attributes.GRAVITY, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(RorMod.MODID, "galactic_0.leggings"), -0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), EquipmentSlotGroup.ANY).build()));
		}
	}

	public static class Boots extends GalacticItem {
		public Boots() {
			super(ArmorItem.Type.BOOTS,
					new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(40))
							.attributes(ItemAttributeModifiers.builder().add(Attributes.ARMOR, new AttributeModifier(ResourceLocation.withDefaultNamespace("armor.boots"), 4, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.FEET)
									.add(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(ResourceLocation.withDefaultNamespace("armor.boots"), 3.4, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.FEET)
									.add(Attributes.GRAVITY, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(RorMod.MODID, "galactic_0.boots"), -0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), EquipmentSlotGroup.ANY).build()));
		}
	}
}