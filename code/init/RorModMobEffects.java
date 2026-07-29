package com.dreamcritting.ror.init;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import com.dreamcritting.ror.potion.*;
import com.dreamcritting.ror.RorMod;

@EventBusSubscriber
public class RorModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, RorMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> MUSIC_BOOST = REGISTRY.register("music_boost", MusicBoostMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> MAGIC_BOOST = REGISTRY.register("magic_boost", MagicBoostMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> DEAFNESS = REGISTRY.register("deafness", DeafnessMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> SILENCE = REGISTRY.register("silence", SilenceMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> CLUMSYNESS = REGISTRY.register("clumsyness", ClumsynessMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> MANA_DRAIN = REGISTRY.register("mana_drain", ManaDrainMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> FEAR = REGISTRY.register("fear", FearMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> BRAVERY = REGISTRY.register("bravery", BraveryMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> ALCHOHOL = REGISTRY.register("alchohol", AlchoholMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> COOLDOWN = REGISTRY.register("cooldown", CooldownMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> FATAL_POISON = REGISTRY.register("fatal_poison", FatalPoisonMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> HOPE = REGISTRY.register("hope", HopeMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> MUSICAL_ABILITY_COOLDOWN = REGISTRY.register("musical_ability_cooldown", MusicalAbilityCooldownMobEffect::new);
	public static final DeferredHolder<MobEffect, MobEffect> MAGICAL_ABILITY_COOLDOWN = REGISTRY.register("magical_ability_cooldown", MagicalAbilityCooldownMobEffect::new);

	@SubscribeEvent
	public static void onEffectRemoved(MobEffectEvent.Remove event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	@SubscribeEvent
	public static void onEffectExpired(MobEffectEvent.Expired event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	private static void expireEffects(Entity entity, MobEffectInstance effectInstance) {
		if (effectInstance.getEffect().is(ALCHOHOL)) {
			if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(RorModMobEffects.ALCHOHOL))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 300, 0, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 300, 0, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 300, 0, false, false));
			}
		}
	}
}