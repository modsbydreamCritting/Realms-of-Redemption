package com.dreamcritting.ror.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.resources.ResourceLocation;

import com.dreamcritting.ror.init.RorModAttributes;
import com.dreamcritting.ror.RorMod;

public class ImmovableEmblemItem extends Item {
	public ImmovableEmblemItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)
				.attributes(ItemAttributeModifiers.builder()
						.add(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(RorMod.MODID, "immovable_emblem_0"), 0.5, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.HAND)
						.add(RorModAttributes.FEAR_RESISTANCE, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(RorMod.MODID, "immovable_emblem_1"), 1, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.HAND).build()));
	}
}