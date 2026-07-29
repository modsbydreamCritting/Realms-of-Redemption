package com.dreamcritting.ror.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import com.dreamcritting.ror.RorMod;

public class RorModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, RorMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> AMBIENT_FACTORY = REGISTRY.register("ambient_factory", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "ambient_factory")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CYBERLAND_MUSIC = REGISTRY.register("cyberland_music", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "cyberland_music")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CYBERLAND_PORTAL_SPAWN = REGISTRY.register("cyberland_portal_spawn", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "cyberland_portal_spawn")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ELECTRIC_GUITAR_CHORDS = REGISTRY.register("electric_guitar_chords", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "electric_guitar_chords")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ELECTRIC_GUITAR_HEAL = REGISTRY.register("electric_guitar_heal", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "electric_guitar_heal")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ELECTRIC_GUITAR_IMPAIR = REGISTRY.register("electric_guitar_impair", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "electric_guitar_impair")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ENSCORCELMENT_STATION_USED = REGISTRY.register("enscorcelment_station_used", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "enscorcelment_station_used")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FACTORY_MUSIC = REGISTRY.register("factory_music", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "factory_music")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FACTORY_PORTAL_SPAWNS = REGISTRY.register("factory_portal_spawns", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "factory_portal_spawns")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FLOWERBED_MUSIC = REGISTRY.register("flowerbed_music", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "flowerbed_music")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FLOWERBED_PORTAL_SPAWNS = REGISTRY.register("flowerbed_portal_spawns", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "flowerbed_portal_spawns")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FORCE_FIELD_ZAPS = REGISTRY.register("force_field_zaps", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "force_field_zaps")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FRENCH_HORN_ANGER = REGISTRY.register("french_horn_anger", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "french_horn_anger")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FRENCH_HORN_HEAL = REGISTRY.register("french_horn_heal", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "french_horn_heal")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FRENCH_HORN_IMPAIR = REGISTRY.register("french_horn_impair", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "french_horn_impair")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FRENCH_HORN_SLOW_RECOVERY = REGISTRY.register("french_horn_slow_recovery", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "french_horn_slow_recovery")));
	public static final DeferredHolder<SoundEvent, SoundEvent> GENERIC_SPELLS = REGISTRY.register("generic_spells", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "generic_spells")));
	public static final DeferredHolder<SoundEvent, SoundEvent> GHOST_AMBIENT = REGISTRY.register("ghost_ambient", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "ghost_ambient")));
	public static final DeferredHolder<SoundEvent, SoundEvent> GOOGLOID_AMBIENT = REGISTRY.register("googloid_ambient", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "googloid_ambient")));
	public static final DeferredHolder<SoundEvent, SoundEvent> KILLBOT_MUSIC = REGISTRY.register("killbot_music", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "killbot_music")));
	public static final DeferredHolder<SoundEvent, SoundEvent> KILLBOT_MUSIC_END = REGISTRY.register("killbot_music_end", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "killbot_music_end")));
	public static final DeferredHolder<SoundEvent, SoundEvent> KILLBOT_START = REGISTRY.register("killbot_start", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "killbot_start")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LASER_BUZZ = REGISTRY.register("laser_buzz", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "laser_buzz")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LASER_SHOOTS = REGISTRY.register("laser_shoots", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "laser_shoots")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LEVITATION_SPELL = REGISTRY.register("levitation_spell", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "levitation_spell")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LUTE_BIG_HEAL = REGISTRY.register("lute_big_heal", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "lute_big_heal")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LUTE_HEAL = REGISTRY.register("lute_heal", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "lute_heal")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LUTE_IMPAIR = REGISTRY.register("lute_impair", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "lute_impair")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LUTE_REVEAL = REGISTRY.register("lute_reveal", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "lute_reveal")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LYRE_ANGER = REGISTRY.register("lyre_anger", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "lyre_anger")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LYRE_EXTINGUISH = REGISTRY.register("lyre_extinguish", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "lyre_extinguish")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LYRE_HEAL = REGISTRY.register("lyre_heal", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "lyre_heal")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LYRE_IMPAIR = REGISTRY.register("lyre_impair", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "lyre_impair")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LYRE_REVEAL = REGISTRY.register("lyre_reveal", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "lyre_reveal")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOX_AMBIENT = REGISTRY.register("mox_ambient", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "mox_ambient")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOX_DIES = REGISTRY.register("mox_dies", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "mox_dies")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOX_KILLS = REGISTRY.register("mox_kills", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "mox_kills")));
	public static final DeferredHolder<SoundEvent, SoundEvent> NEON_CITY_MUSIC = REGISTRY.register("neon_city_music", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "neon_city_music")));
	public static final DeferredHolder<SoundEvent, SoundEvent> NEON_CITY_PORTAL_SPAWNS = REGISTRY.register("neon_city_portal_spawns", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "neon_city_portal_spawns")));
	public static final DeferredHolder<SoundEvent, SoundEvent> PANPIPES_ANGER = REGISTRY.register("panpipes_anger", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "panpipes_anger")));
	public static final DeferredHolder<SoundEvent, SoundEvent> PANPIPES_HEAL = REGISTRY.register("panpipes_heal", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "panpipes_heal")));
	public static final DeferredHolder<SoundEvent, SoundEvent> PANPIPES_REVEAL = REGISTRY.register("panpipes_reveal", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "panpipes_reveal")));
	public static final DeferredHolder<SoundEvent, SoundEvent> PRISMACON_MUSIC = REGISTRY.register("prismacon_music", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "prismacon_music")));
	public static final DeferredHolder<SoundEvent, SoundEvent> PRISMACON_PORTAL_SPAWNS = REGISTRY.register("prismacon_portal_spawns", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "prismacon_portal_spawns")));
	public static final DeferredHolder<SoundEvent, SoundEvent> PRISMACON_UNDERGROUND_MUSIC = REGISTRY.register("prismacon_underground_music", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "prismacon_underground_music")));
	public static final DeferredHolder<SoundEvent, SoundEvent> RADAR_WAND_USED = REGISTRY.register("radar_wand_used", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "radar_wand_used")));
	public static final DeferredHolder<SoundEvent, SoundEvent> RAINBOOM = REGISTRY.register("rainboom", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "rainboom")));
	public static final DeferredHolder<SoundEvent, SoundEvent> REPAIR_SPELL = REGISTRY.register("repair_spell", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "repair_spell")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SCAN = REGISTRY.register("scan", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "scan")));
	public static final DeferredHolder<SoundEvent, SoundEvent> TITANIA_SPAWNS = REGISTRY.register("titania_spawns", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "titania_spawns")));
	public static final DeferredHolder<SoundEvent, SoundEvent> TWINKLY_SPELL = REGISTRY.register("twinkly_spell", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "twinkly_spell")));
	public static final DeferredHolder<SoundEvent, SoundEvent> UNDERCOPTER_NOISE = REGISTRY.register("undercopter_noise", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "undercopter_noise")));
	public static final DeferredHolder<SoundEvent, SoundEvent> UNDERGROUND_JUNGLE_MUSIC = REGISTRY.register("underground_jungle_music", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "underground_jungle_music")));
	public static final DeferredHolder<SoundEvent, SoundEvent> WRENCH_USED = REGISTRY.register("wrench_used", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "wrench_used")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ROBOT_DIES = REGISTRY.register("robot_dies", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ror", "robot_dies")));
}