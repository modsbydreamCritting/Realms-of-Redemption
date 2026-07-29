package com.dreamcritting.ror.entity;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.common.NeoForgeMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.nbt.CompoundTag;

import java.util.Comparator;

public class CorrundumSpikeEntity extends Monster {
	public static final EntityDataAccessor<Integer> action_state = SynchedEntityData.defineId(CorrundumSpikeEntity.class, EntityDataSerializers.INT);
	public final AnimationState animationState0 = new AnimationState();

	public CorrundumSpikeEntity(EntityType<CorrundumSpikeEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(true);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(action_state, 0);
	}

	@Override
	public boolean hurt(DamageSource damagesource, float amount) {
		if         (damagesource.is(DamageTypes.FALLING_ANVIL)
				|| (damagesource.is(DamageTypes.DRAGON_BREATH)
				|| damagesource.is(DamageTypes.WITHER_SKULL)
				|| damagesource.is(DamageTypes.TRIDENT)
				|| damagesource.is(DamageTypes.PLAYER_EXPLOSION)
				|| damagesource.is(DamageTypes.TRIDENT)
				|| damagesource.is(DamageTypes.EXPLOSION)
				|| damagesource.is(DamageTypes.LIGHTNING_BOLT)
				|| damagesource.is(DamageTypes.DROWN)
				|| damagesource.is(DamageTypes.CACTUS)
				|| damagesource.is(DamageTypes.IN_WALL)
				|| damagesource.is(DamageTypes.FALL)
				|| damagesource.is(DamageTypes.PLAYER_EXPLOSION)
				|| damagesource.is(DamageTypes.TRIDENT)
				|| damagesource.is(DamageTypes.EXPLOSION)
				|| damagesource.is(DamageTypes.IN_FIRE)
				|| damagesource.getDirectEntity() instanceof ThrownPotion
				|| damagesource.getDirectEntity() instanceof AreaEffectCloud
				|| damagesource.getDirectEntity() instanceof Player
				|| damagesource.getDirectEntity() instanceof AbstractArrow
				|| damagesource.typeHolder().is(NeoForgeMod.POISON_DAMAGE)
		))
			return false;
		return super.hurt(damagesource, amount);
	}

	@Override
	public boolean ignoreExplosion(Explosion explosion) {
		return true;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("action_state", this.entityData.get(action_state));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("action_state"))
			this.entityData.set(action_state, compound.getInt("action_state"));
	}

	@Override
	public void tick() {
		super.tick();
		if (this.level().isClientSide()) {
			this.animationState0.animateWhen((this.getEntityData().get(CorrundumSpikeEntity.action_state)) == 1, this.tickCount);
		}
	}

	@Override
	public void baseTick() {
		super.baseTick();
		Level world = this.level();
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		this.getPersistentData().putDouble("timer", (this.getPersistentData().getDouble("timer") + 1));
		if (this.getPersistentData().getDouble("timer") == 20) {
			if (this instanceof CorrundumSpikeEntity _datEntSetI)
				_datEntSetI.getEntityData().set(CorrundumSpikeEntity.action_state, 1);
			{
				final Vec3 _center = new Vec3(x, (y + 1), z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (!(entityiterator instanceof CorrundumSpikeEntity || entityiterator instanceof CorrundodileEntity)) {
						entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.STALAGMITE)), 5);
					}
				}
			}
			{
				final Vec3 _center = new Vec3(x, (y + 2), z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (!(entityiterator instanceof CorrundumSpikeEntity || entityiterator instanceof CorrundodileEntity)) {
						entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.STALAGMITE)), 5);
					}
				}
			}
		} else if (this.getPersistentData().getDouble("timer") >= 50) {
			if (!this.level().isClientSide())
				this.discard();
		}
	}

	@Override
	public boolean isPushable() {
		return false;
	}

	@Override
	protected void doPush(Entity entityIn) {
	}

	@Override
	protected void pushEntities() {
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 500);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 0);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		return builder;
	}
}