package com.dreamcritting.ror.item;

import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.resources.ResourceLocation;

import com.dreamcritting.ror.init.RorModAttributes;
import com.dreamcritting.ror.RorMod;

public class AssassinEmblemItem extends Item {
	public AssassinEmblemItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).attributes(ItemAttributeModifiers.builder()
				.add(RorModAttributes.STEALTH, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(RorMod.MODID, "assassin_emblem_0"), 0.5, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), EquipmentSlotGroup.HAND).build()));
	}
}