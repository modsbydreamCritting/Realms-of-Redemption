package com.dreamcritting.ror.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.resources.ResourceLocation;

import com.dreamcritting.ror.init.RorModAttributes;
import com.dreamcritting.ror.RorMod;

public class MusicEmblemItem extends Item {
	public MusicEmblemItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).attributes(ItemAttributeModifiers.builder()
				.add(RorModAttributes.MUSICAL_POWER, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(RorMod.MODID, "music_emblem_0"), 0.2, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), EquipmentSlotGroup.HAND).build()));
	}
}