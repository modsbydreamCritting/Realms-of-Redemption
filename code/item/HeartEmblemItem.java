package com.dreamcritting.ror.item;

import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.resources.ResourceLocation;

import com.dreamcritting.ror.RorMod;

public class HeartEmblemItem extends Item {
	public HeartEmblemItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)
				.attributes(ItemAttributeModifiers.builder().add(Attributes.MAX_HEALTH, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(RorMod.MODID, "heart_emblem_0"), 4, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.HAND)
						.add(Attributes.ATTACK_DAMAGE, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(RorMod.MODID, "heart_emblem_1"), -3, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.ANY).build()));
	}
}