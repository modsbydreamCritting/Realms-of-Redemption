package com.dreamcritting.ror.init;

import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

@EventBusSubscriber
public class RorModTrades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == RorModVillagerProfessions.NEON_TRADER.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.NEON_COIN.get()), new ItemStack(Items.BREAD, 6), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.NEON_COIN.get(), 4), new ItemStack(RorModItems.NEON_CITY.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.NEON_COIN.get()), new ItemStack(RorModItems.RUNE.get(), 12), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.NEON_COIN.get(), 8), new ItemStack(Items.DIAMOND), 10, 6, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.NEON_COIN.get(), 15), new ItemStack(Items.GOLDEN_APPLE), 10, 7, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.NEON_COIN.get(), 4), new ItemStack(RorModItems.TSAVORITE.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.RUBELLITE_HEART.get()), new ItemStack(RorModItems.NEON_COIN.get(), 4), 10, 7, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.NEON_COIN.get(), 10), new ItemStack(RorModItems.NEON_HELMET.get()), 10, 8, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.NEON_COIN.get(), 10), new ItemStack(RorModItems.NEON_CHESTPLATE.get()), 10, 8, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.NEON_COIN.get(), 10), new ItemStack(RorModItems.NEON_LEGGINGS.get()), 10, 8, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.NEON_COIN.get(), 10), new ItemStack(RorModItems.NEON_BOOTS.get()), 10, 8, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.NEON_COIN.get(), 64), new ItemStack(RorModItems.TOP_HELMET.get()), 10, 25, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.NEON_COIN.get()), new ItemStack(RorModBlocks.CYAN_NEON_BLOCK.get(), 32), new ItemStack(RorModBlocks.PINK_NEON_BLOCK.get(), 32), 10, 5, 0.02f));
		}
		if (event.getType() == RorModVillagerProfessions.CRYSTAL_TRADER.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.GOLD_MOB_TOKEN.get()), new ItemStack(RorModItems.SWORD_OF_GREED.get()), 10, 30, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.GOLD_MOB_TOKEN.get()), new ItemStack(RorModItems.SWORD_OF_WRATH.get()), 10, 30, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.GOLD_MOB_TOKEN.get()), new ItemStack(Items.ENCHANTED_GOLDEN_APPLE), 10, 30, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.XOLITE.get(), 4), new ItemStack(RorModItems.WHITE_SAPPHIRE.get(), 4), new ItemStack(RorModItems.CRYSTAL_WAND.get()), 10, 20, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Blocks.AMETHYST_BLOCK, 32), new ItemStack(Items.EMERALD, 3), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.JAW_WAND.get()), new ItemStack(RorModItems.GOLD_MOB_TOKEN.get()), new ItemStack(RorModItems.DEVOURER_WAND.get()), 10, 30, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.DIAMOND), new ItemStack(RorModItems.TSAVORITE.get(), 2), new ItemStack(RorModItems.BAG_OF_SHINY_STUFF.get()), 20, 5, 0.05f));
		}
		if (event.getType() == RorModVillagerProfessions.ROBOT_TRADER.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.ROBOTIC_CHESTPLATE.get()), new ItemStack(RorModItems.NEON_CHESTPLATE.get()), new ItemStack(Items.NETHERITE_CHESTPLATE), 10, 20, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.BLUE_METAL_PLATE.get(), 12), new ItemStack(RorModItems.LASER_DIODE.get(), 4), new ItemStack(Blocks.REDSTONE_BLOCK, 4), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.REDSTONE, 64), new ItemStack(RorModItems.RUNE.get(), 48), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Blocks.IRON_BLOCK, 3), new ItemStack(Blocks.COPPER_BLOCK, 3), new ItemStack(RorModItems.TOURMALINE_UPGRADE_SMITHING_TEMPLATE.get()), 10, 5, 0.05f));
			event.getTrades().get(1)
					.add(new BasicItemListing(new ItemStack(RorModItems.CHARGED_BATTERY.get()), new ItemStack(RorModItems.BLUE_METAL_PLATE.get(), 12), new ItemStack(RorModItems.TOURMALINE_UPGRADE_SMITHING_TEMPLATE.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.TOURMALINE.get()), new ItemStack(Items.EMERALD), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.NETHERITE_INGOT), new ItemStack(Items.IRON_INGOT, 48), 10, 10, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.MOON_COIN.get()), new ItemStack(RorModItems.GALACTITE_INGOT.get()), new ItemStack(Items.NETHERITE_INGOT), 10, 10, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.MOON_COIN.get()), new ItemStack(Items.WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE), 10, 10, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.MOON_COIN.get()), new ItemStack(RorModItems.TOURMALINE_UPGRADE_SMITHING_TEMPLATE.get(), 3), 10, 10, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.MOON_COIN.get()), new ItemStack(RorModItems.REPAIR_SPELL.get()), 10, 10, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.MOON_COIN.get(), 3), new ItemStack(Blocks.GOLD_BLOCK, 2), new ItemStack(RorModItems.FRENCH_HORN.get()), 10, 20, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.MOON_COIN.get(), 3), new ItemStack(RorModItems.ASSASSINS_KNIFE.get()), 10, 20, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.MOON_COIN.get()), new ItemStack(RorModItems.GALACTIC_SHURIKEN.get()), 10, 10, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.MOON_COIN.get()), new ItemStack(RorModBlocks.DAFFODILIUM_BLOCK.get()), new ItemStack(RorModItems.FAIRYDUST.get(), 7), 10, 10, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.MAGNOLITE_INGOT.get()), new ItemStack(Items.EMERALD, 2), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.MECHANITE_INGOT.get()), new ItemStack(Items.EMERALD, 2), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.PRISMITE_INGOT.get()), new ItemStack(Items.EMERALD, 2), 10, 5, 0.05f));
		}
		if (event.getType() == RorModVillagerProfessions.FLOWERBED_TRADER.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.MOON_COIN.get()), new ItemStack(RorModItems.DRESS_HELMET.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.NEON_COIN.get()), new ItemStack(RorModItems.DRESS_CHESTPLATE.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.SPECTRA_CANISTER.get()), new ItemStack(RorModItems.DRESS_BOOTS.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.MOON_COIN.get()), new ItemStack(RorModItems.SUIT_CHESTPLATE.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.NEON_COIN.get()), new ItemStack(RorModItems.SUIT_LEGGINGS.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.SPECTRA_CANISTER.get()), new ItemStack(RorModItems.SUIT_BOOTS.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModBlocks.NIGHTSHADE_BERRY.get()), new ItemStack(Items.SWEET_BERRIES, 10), 24, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.DAFFODILIUM_INGOT.get(), 3), new ItemStack(RorModBlocks.GREEN_GARNET.get()), new ItemStack(RorModItems.ASSASSINS_HELMET.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.DAFFODILIUM_INGOT.get(), 6), new ItemStack(RorModBlocks.GREEN_GARNET.get()), new ItemStack(RorModItems.ASSASSINS_CHESTPLATE.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.DAFFODILIUM_INGOT.get(), 4), new ItemStack(RorModBlocks.GREEN_GARNET.get()), new ItemStack(RorModItems.ASSASSINS_LEGGINGS.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(RorModItems.DAFFODILIUM_INGOT.get(), 2), new ItemStack(RorModBlocks.GREEN_GARNET.get()), new ItemStack(RorModItems.ASSASSINS_BOOTS.get()), 10, 5, 0.05f));
		}
	}
}