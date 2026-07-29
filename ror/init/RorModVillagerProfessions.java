package com.dreamcritting.ror.init;

import net.neoforged.neoforge.registries.RegisterEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Holder;

import java.util.function.Supplier;
import java.util.function.Predicate;
import java.util.Optional;
import java.util.Map;
import java.util.HashMap;

import com.google.common.collect.ImmutableSet;

import com.dreamcritting.ror.RorMod;

@EventBusSubscriber
public class RorModVillagerProfessions {
	private static final Map<String, ProfessionPoiType> POI_TYPES = new HashMap<>();
	public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(Registries.VILLAGER_PROFESSION, RorMod.MODID);
	public static final DeferredHolder<VillagerProfession, VillagerProfession> NEON_TRADER = registerProfession("neon_trader", () -> RorModBlocks.NEON_TRADER_WORKSTATION.get(),
			() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")));
	public static final DeferredHolder<VillagerProfession, VillagerProfession> CRYSTAL_TRADER = registerProfession("crystal_trader", () -> RorModBlocks.CRYSTAL_TRADER_WORKSTATION.get(),
			() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")));
	public static final DeferredHolder<VillagerProfession, VillagerProfession> ROBOT_TRADER = registerProfession("robot_trader", () -> RorModBlocks.ROBOT_TRADER_WORKSTATION.get(),
			() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_armorer")));
	public static final DeferredHolder<VillagerProfession, VillagerProfession> FLOWERBED_TRADER = registerProfession("flowerbed_trader", () -> RorModBlocks.TITANIA_ALTAR.get(),
			() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cleric")));

	private static DeferredHolder<VillagerProfession, VillagerProfession> registerProfession(String name, Supplier<Block> block, Supplier<SoundEvent> soundEvent) {
		POI_TYPES.put(name, new ProfessionPoiType(block, null));
		return PROFESSIONS.register(name, () -> {
			Predicate<Holder<PoiType>> poiPredicate = poiTypeHolder -> (POI_TYPES.get(name).poiType != null) && (poiTypeHolder.value() == POI_TYPES.get(name).poiType.value());
			return new VillagerProfession(RorMod.MODID + ":" + name, poiPredicate, poiPredicate, ImmutableSet.of(), ImmutableSet.of(), soundEvent.get());
		});
	}

	@SubscribeEvent
	public static void registerProfessionPointsOfInterest(RegisterEvent event) {
		event.register(Registries.POINT_OF_INTEREST_TYPE, registerHelper -> {
			for (Map.Entry<String, ProfessionPoiType> entry : POI_TYPES.entrySet()) {
				Block block = entry.getValue().block.get();
				String name = entry.getKey();
				Optional<Holder<PoiType>> existingCheck = PoiTypes.forState(block.defaultBlockState());
				if (existingCheck.isPresent()) {
					RorMod.LOGGER.error("Skipping villager profession " + name + " that uses POI block " + block + " that is already in use by " + existingCheck);
					continue;
				}
				PoiType poiType = new PoiType(ImmutableSet.copyOf(block.getStateDefinition().getPossibleStates()), 1, 1);
				registerHelper.register(ResourceLocation.fromNamespaceAndPath("ror", name), poiType);
				entry.getValue().poiType = BuiltInRegistries.POINT_OF_INTEREST_TYPE.wrapAsHolder(poiType);
			}
		});
	}

	private static class ProfessionPoiType {
		final Supplier<Block> block;
		Holder<PoiType> poiType;

		ProfessionPoiType(Supplier<Block> block, Holder<PoiType> poiType) {
			this.block = block;
			this.poiType = poiType;
		}
	}
}