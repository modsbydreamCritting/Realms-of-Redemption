package com.dreamcritting.ror.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import com.dreamcritting.ror.RorMod;

public class RorModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, RorMod.MODID);
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> MAGIC_GEARS = REGISTRY.register("magic_gears", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> MAGIC_FIREBALL = REGISTRY.register("magic_fireball", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> RAINBOW = REGISTRY.register("rainbow", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> RAINBOW_MAGIC = REGISTRY.register("rainbow_magic", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> MAGIC_STARS = REGISTRY.register("magic_stars", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SCAN = REGISTRY.register("scan", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> RED_LASER = REGISTRY.register("red_laser", () -> new SimpleParticleType(true));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> TITANIA_SHIELD = REGISTRY.register("titania_shield", () -> new SimpleParticleType(false));
}