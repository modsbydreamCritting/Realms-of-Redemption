package com.dreamcritting.ror.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import com.dreamcritting.ror.init.RorModItems;

public class ToxicSludgeContainmentBoxItem extends Item {
	public ToxicSludgeContainmentBoxItem() {
		super(new Item.Properties().stacksTo(16));
	}

	@Override
	public boolean hasCraftingRemainingItem(ItemStack stack) {
		return true;
	}

	@Override
	public ItemStack getCraftingRemainingItem(ItemStack itemstack) {
		return new ItemStack(RorModItems.CONTAINMENT_BOX.get());
	}
}