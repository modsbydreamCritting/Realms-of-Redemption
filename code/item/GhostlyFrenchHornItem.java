package com.dreamcritting.ror.item;

import com.dreamcritting.ror.init.RorModMobEffects;
import com.dreamcritting.ror.special.MusicalItemCooldown;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;

public class GhostlyFrenchHornItem extends DescriptableItem {
	public GhostlyFrenchHornItem() {
		super(new Item.Properties().durability(250).rarity(Rarity.UNCOMMON));
	}

	@Override
	public int getUseDuration(ItemStack itemstack, LivingEntity livingEntity) {
		return 80;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		entity.startUsingItem(hand);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		ItemStack itemstack = ar.getObject();
        if (!entity.hasEffect(RorModMobEffects.MUSICAL_ABILITY_COOLDOWN)) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:french_horn_impair")), SoundSource.PLAYERS, 1, (float) 0.7);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:french_horn_impair")), SoundSource.PLAYERS, 1, (float) 0.7, false);
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (!(entityiterator == entity)) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(RorModMobEffects.FEAR, 480,
									(entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect(RorModMobEffects.FEAR) ? _livEnt.getEffect(RorModMobEffects.FEAR).getAmplifier() : 0) + 8, true, true));
						entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC), entity), 10);
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.NOTE, (entityiterator.getY()), (entityiterator.getX()), (entityiterator.getZ()), 1, 0.2, 1, 0.2, 0.2);
					}
				}
			}
			MusicalItemCooldown.execute(world, x, y, z, entity, itemstack, 40);
		}
		return ar;
	}
}