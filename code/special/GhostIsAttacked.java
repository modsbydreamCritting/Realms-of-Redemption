package com.dreamcritting.ror.special;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import java.util.Comparator;

import com.dreamcritting.ror.init.RorModMobEffects;
import com.dreamcritting.ror.init.RorModAttributes;
import com.dreamcritting.ror.entity.GhostAngelEntity;

public class GhostIsAttacked {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double fearvalue = 0;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(RorModMobEffects.MAGICAL_ABILITY_COOLDOWN))) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("eyelid:ghosts")))) {
						fearvalue = fearvalue + (entityiterator instanceof GhostAngelEntity ? 2 : 1);
					}
				}
			}
			fearvalue = fearvalue - (sourceentity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(RorModAttributes.FEAR_RESISTANCE) ? _livingEntity4.getAttribute(RorModAttributes.FEAR_RESISTANCE).getValue() : 0);
			if (fearvalue > -1) {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(RorModMobEffects.FEAR, 100, (int) fearvalue, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(RorModMobEffects.MAGICAL_ABILITY_COOLDOWN, 40, 0, false, false));
			}
		}
	}
}