package com.dreamcritting.ror.special;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

import com.dreamcritting.ror.init.RorModMobEffects;
import com.dreamcritting.ror.init.RorModAttributes;

public class ShurikenAttack {
	public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		if (entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		double stealth_modifier = 0;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) >= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) {
			if (sourceentity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MobEffects.INVISIBILITY)) {
				stealth_modifier = stealth_modifier + 0.1;
			}
			if (sourceentity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(MobEffects.BLINDNESS) || entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(MobEffects.DARKNESS)) {
				stealth_modifier = stealth_modifier - 0.1;
			}
			if (entity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(RorModMobEffects.DEAFNESS)) {
				stealth_modifier = stealth_modifier + 0.1;
			}
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null || entity instanceof Animal) {
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.ARROW), immediatesourceentity, sourceentity),
						(float) ((sourceentity instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity9.getAttribute(Attributes.ATTACK_DAMAGE).getValue() : 0)
								* ((sourceentity instanceof LivingEntity _livingEntity10 && _livingEntity10.getAttributes().hasAttribute(RorModAttributes.STEALTH) ? _livingEntity10.getAttribute(RorModAttributes.STEALTH).getValue() : 0)
										+ stealth_modifier)
								+ (sourceentity instanceof LivingEntity _livingEntity11 && _livingEntity11.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity11.getAttribute(Attributes.ATTACK_DAMAGE).getValue() : 0)));
			}
		}
	}
}