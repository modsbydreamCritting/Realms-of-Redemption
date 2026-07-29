package com.dreamcritting.ror.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.registries.Registries;

import com.dreamcritting.ror.RorMod;

public class RorModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(Registries.POTION, RorMod.MODID);
	public static final DeferredHolder<Potion, Potion> DEADLY_POISON = REGISTRY.register("deadly_poison", () -> new Potion(new MobEffectInstance(RorModMobEffects.FATAL_POISON, 3600, 0, false, true)));
	public static final DeferredHolder<Potion, Potion> FEARFULNESS = REGISTRY.register("fearfulness", () -> new Potion(new MobEffectInstance(RorModMobEffects.FEAR, 3600, 0, false, true)));
	public static final DeferredHolder<Potion, Potion> FEARLESSNESS = REGISTRY.register("fearlessness", () -> new Potion(new MobEffectInstance(RorModMobEffects.BRAVERY, 3600, 0, false, true)));
	public static final DeferredHolder<Potion, Potion> INSANE_LEVITATION = REGISTRY.register("insane_levitation", () -> new Potion(new MobEffectInstance(MobEffects.LEVITATION, 20, 50, false, true)));
	public static final DeferredHolder<Potion, Potion> LONG_BRAVERY = REGISTRY.register("long_bravery", () -> new Potion(new MobEffectInstance(RorModMobEffects.BRAVERY, 7200, 0, false, true)));
	public static final DeferredHolder<Potion, Potion> LONG_CLUMSYNESS = REGISTRY.register("long_clumsyness", () -> new Potion(new MobEffectInstance(RorModMobEffects.CLUMSYNESS, 7200, 0, false, true)));
	public static final DeferredHolder<Potion, Potion> LONG_DEAFNESS = REGISTRY.register("long_deafness", () -> new Potion(new MobEffectInstance(RorModMobEffects.DEAFNESS, 7200, 0, false, true)));
	public static final DeferredHolder<Potion, Potion> LONG_FATAL_POISON = REGISTRY.register("long_fatal_poison", () -> new Potion(new MobEffectInstance(RorModMobEffects.FATAL_POISON, 7200, 0, false, true)));
	public static final DeferredHolder<Potion, Potion> LONG_FEAR = REGISTRY.register("long_fear", () -> new Potion(new MobEffectInstance(RorModMobEffects.FEAR, 7200, 0, false, true)));
	public static final DeferredHolder<Potion, Potion> LONG_MAGIC_BOOST = REGISTRY.register("long_magic_boost", () -> new Potion(new MobEffectInstance(RorModMobEffects.MAGIC_BOOST, 7200, 0, false, true)));
	public static final DeferredHolder<Potion, Potion> LONG_MANA_DRAIN = REGISTRY.register("long_mana_drain", () -> new Potion(new MobEffectInstance(RorModMobEffects.MANA_DRAIN, 7200, 0, false, true)));
	public static final DeferredHolder<Potion, Potion> LONG_MUSIC_BOOST = REGISTRY.register("long_music_boost", () -> new Potion(new MobEffectInstance(RorModMobEffects.MUSIC_BOOST, 7200, 0, false, true)));
	public static final DeferredHolder<Potion, Potion> LONG_NIGHTSHADE_POISON = REGISTRY.register("long_nightshade_poison", () -> new Potion(new MobEffectInstance(MobEffects.POISON, 1800, 1, false, true)));
	public static final DeferredHolder<Potion, Potion> LONG_SILENCE = REGISTRY.register("long_silence", () -> new Potion(new MobEffectInstance(RorModMobEffects.SILENCE, 7200, 0, false, true)));
	public static final DeferredHolder<Potion, Potion> MAGICAL_BOOST = REGISTRY.register("magical_boost", () -> new Potion(new MobEffectInstance(RorModMobEffects.MAGIC_BOOST, 3600, 0, false, true)));
	public static final DeferredHolder<Potion, Potion> MAGICAL_IMPAIRMENT = REGISTRY.register("magical_impairment", () -> new Potion(new MobEffectInstance(RorModMobEffects.MANA_DRAIN, 3600, 0, false, true)));
	public static final DeferredHolder<Potion, Potion> MUSICAL_BOOST = REGISTRY.register("musical_boost", () -> new Potion(new MobEffectInstance(RorModMobEffects.MUSIC_BOOST, 3600, 0, false, true)));
	public static final DeferredHolder<Potion, Potion> MUSICAL_IMPAIRMENT = REGISTRY.register("musical_impairment", () -> new Potion(new MobEffectInstance(RorModMobEffects.DEAFNESS, 3600, 0, false, true)));
	public static final DeferredHolder<Potion, Potion> NIGHTSHADE_POISON = REGISTRY.register("nightshade_poison", () -> new Potion(new MobEffectInstance(MobEffects.POISON, 900, 1, false, true)));
	public static final DeferredHolder<Potion, Potion> STEALTH_BOOST = REGISTRY.register("stealth_boost", () -> new Potion(new MobEffectInstance(RorModMobEffects.SILENCE, 3600, 0, false, true)));
	public static final DeferredHolder<Potion, Potion> STEALTH_IMPAIRMENT = REGISTRY.register("stealth_impairment", () -> new Potion(new MobEffectInstance(RorModMobEffects.CLUMSYNESS, 3600, 0, false, true)));
	public static final DeferredHolder<Potion, Potion> STRONG_BRAVERY = REGISTRY.register("strong_bravery", () -> new Potion(new MobEffectInstance(RorModMobEffects.BRAVERY, 1800, 1, false, true)));
	public static final DeferredHolder<Potion, Potion> STRONG_CLUMSYNESS = REGISTRY.register("strong_clumsyness", () -> new Potion(new MobEffectInstance(RorModMobEffects.CLUMSYNESS, 1800, 1, false, true)));
	public static final DeferredHolder<Potion, Potion> STRONG_DEAFNESS = REGISTRY.register("strong_deafness", () -> new Potion(new MobEffectInstance(RorModMobEffects.DEAFNESS, 1800, 1, false, true)));
	public static final DeferredHolder<Potion, Potion> STRONG_FATAL_POISON = REGISTRY.register("strong_fatal_poison", () -> new Potion(new MobEffectInstance(RorModMobEffects.FATAL_POISON, 1800, 1, false, true)));
	public static final DeferredHolder<Potion, Potion> STRONG_FEAR = REGISTRY.register("strong_fear", () -> new Potion(new MobEffectInstance(RorModMobEffects.FEAR, 1800, 1, false, true)));
	public static final DeferredHolder<Potion, Potion> STRONG_MAGIC_BOOST = REGISTRY.register("strong_magic_boost", () -> new Potion(new MobEffectInstance(RorModMobEffects.MAGIC_BOOST, 1800, 1, false, true)));
	public static final DeferredHolder<Potion, Potion> STRONG_MANA_DRAIN = REGISTRY.register("strong_mana_drain", () -> new Potion(new MobEffectInstance(RorModMobEffects.MANA_DRAIN, 1800, 1, false, true)));
	public static final DeferredHolder<Potion, Potion> STRONG_MUSIC_BOOST = REGISTRY.register("strong_music_boost", () -> new Potion(new MobEffectInstance(RorModMobEffects.MUSIC_BOOST, 1800, 1, false, true)));
	public static final DeferredHolder<Potion, Potion> STRONG_NIGHTSHADE_POISON = REGISTRY.register("strong_nightshade_poison", () -> new Potion(new MobEffectInstance(MobEffects.POISON, 420, 2, false, true)));
	public static final DeferredHolder<Potion, Potion> STRONG_SILENCE = REGISTRY.register("strong_silence", () -> new Potion(new MobEffectInstance(RorModMobEffects.SILENCE, 1800, 1, false, true)));
	public static final DeferredHolder<Potion, Potion> VERY_STRONG_BRAVERY = REGISTRY.register("very_strong_bravery", () -> new Potion(new MobEffectInstance(RorModMobEffects.BRAVERY, 1200, 2, false, true)));
}