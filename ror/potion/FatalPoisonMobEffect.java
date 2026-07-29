package com.dreamcritting.ror.potion;

import com.dreamcritting.ror.init.RorModMobEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.EffectCures;
import net.neoforged.neoforge.common.EffectCure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import java.util.Set;

public class FatalPoisonMobEffect extends MobEffect {
	public FatalPoisonMobEffect() {
		super(MobEffectCategory.HARMFUL, -10092442);
	}

	@Override
	public void fillEffectCures(Set<EffectCure> cures, MobEffectInstance effectInstance) {
		cures.add(EffectCures.MILK);
		cures.add(EffectCures.PROTECTED_BY_TOTEM);
		cures.add(EffectCures.HONEY);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
        if (!entity.level().isClientSide())
			entity.addEffect(new MobEffectInstance(MobEffects.POISON, entity.hasEffect(RorModMobEffects.FATAL_POISON) ? entity.getEffect(RorModMobEffects.FATAL_POISON).getDuration() : 0,
					entity.hasEffect(RorModMobEffects.FATAL_POISON) ? entity.getEffect(RorModMobEffects.FATAL_POISON).getAmplifier() : 0, false, false));
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		Level world = entity.level();
        if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 1) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), 20);
		}
		return super.applyEffectTick(entity, amplifier);
	}
}