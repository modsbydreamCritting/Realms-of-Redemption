package com.dreamcritting.ror.item;

import net.minecraft.ChatFormatting;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class WeatherFactoryMapItem extends Item {
	public WeatherFactoryMapItem() {
		super(new Item.Properties());
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable(this.getDescriptionId() + ".desc").withStyle(ChatFormatting.GRAY));
		list.add(Component.translatable(this.getDescriptionId() + ".desc2").withStyle(ChatFormatting.AQUA));
		list.add(Component.translatable(this.getDescriptionId() + ".desc3").withStyle(ChatFormatting.BLUE));
		list.add(Component.translatable(this.getDescriptionId() + ".desc4").withStyle(ChatFormatting.GRAY));
		list.add(Component.translatable(this.getDescriptionId() + ".desc5").withStyle(ChatFormatting.YELLOW));
		list.add(Component.translatable(this.getDescriptionId() + ".desc6").withStyle(ChatFormatting.DARK_RED));
		list.add(Component.translatable(this.getDescriptionId() + ".desc7").withStyle(ChatFormatting.GOLD));
	}
}