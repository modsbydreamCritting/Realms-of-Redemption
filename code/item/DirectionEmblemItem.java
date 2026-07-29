package com.dreamcritting.ror.item;

import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.resources.ResourceLocation;

import com.dreamcritting.ror.RorMod;

public class DirectionEmblemItem extends Item {
	public DirectionEmblemItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)
				.attributes(ItemAttributeModifiers.builder()
						.add(Attributes.MOVEMENT_SPEED, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(RorMod.MODID, "direction_emblem_0"), 0.34, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), EquipmentSlotGroup.HAND)
						.add(Attributes.MAX_HEALTH, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(RorMod.MODID, "direction_emblem_1"), -2, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.HAND).build()));
	}
}