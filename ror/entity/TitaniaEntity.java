package com.dreamcritting.ror.entity;

import com.dreamcritting.ror.configs.RorConfigsCommon;
import com.dreamcritting.ror.init.RorModAttributes;
import com.dreamcritting.ror.init.RorModMobEffects;
import com.dreamcritting.ror.init.RorModParticleTypes;
import com.dreamcritting.ror.special.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.ServerLevelAccessor;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import java.util.EnumSet;

import javax.annotation.Nullable;

public class TitaniaEntity extends Monster {
	public static final EntityDataAccessor<Integer> action_state = SynchedEntityData.defineId(TitaniaEntity.class, EntityDataSerializers.INT);
	public final AnimationState animationState0 = new AnimationState();
	public final AnimationState animationState1 = new AnimationState();
	private final ServerBossEvent bossInfo = new ServerBossEvent(this.getDisplayName(), ServerBossEvent.BossBarColor.GREEN, ServerBossEvent.BossBarOverlay.NOTCHED_20);

	public TitaniaEntity(EntityType<TitaniaEntity> type, Level world) {
		super(type, world);
		xpReward = 120;
		
		setPersistenceRequired();
		this.moveControl = new FlyingMoveControl(this, 10, true);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(action_state, 0);
	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new FlyingPathNavigation(this, world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Player.class, false, false));
		this.goalSelector.addGoal(2, new Goal() {
			{
				this.setFlags(EnumSet.of(Goal.Flag.MOVE));
			}

			public boolean canUse() {
				if (TitaniaEntity.this.getTarget() != null && !TitaniaEntity.this.getMoveControl().hasWanted()) {
					return true;
				} else {
					return false;
				}
			}

			@Override
			public boolean canContinueToUse() {
				return TitaniaEntity.this.getMoveControl().hasWanted() && TitaniaEntity.this.getTarget() != null && TitaniaEntity.this.getTarget().isAlive();
			}

			@Override
			public void start() {
				LivingEntity livingentity = TitaniaEntity.this.getTarget();
				Vec3 vec3d = livingentity.getEyePosition(1);
				TitaniaEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1);
			}

			@Override
			public void tick() {
				LivingEntity livingentity = TitaniaEntity.this.getTarget();
				if (TitaniaEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
					TitaniaEntity.this.doHurtTarget(livingentity);
				} else {
					double d0 = TitaniaEntity.this.distanceToSqr(livingentity);
					if (d0 < 24) {
						Vec3 vec3d = livingentity.getEyePosition(1);
						TitaniaEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1);
					}
				}
			}
		});
		this.goalSelector.addGoal(3, new RandomStrollGoal(this, 0.8, 20) {
			@Override
			protected Vec3 getPosition() {
				RandomSource random = TitaniaEntity.this.getRandom();
				double dir_x = TitaniaEntity.this.getX() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_y = TitaniaEntity.this.getY() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_z = TitaniaEntity.this.getZ() + ((random.nextFloat() * 2 - 1) * 16);
				return new Vec3(dir_x, dir_y, dir_z);
			}
		});
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.2, true) {
			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth()) && this.mob.getSensing().hasLineOfSight(entity);
			}
		});
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(6, new HurtByTargetGoal(this));
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.death"));
	}

	@Override
	public boolean causeFallDamage(float l, float d, DamageSource source) {
		return false;
	}

	@Override
	public boolean hurt(DamageSource damagesource, float amount) {
		if (damagesource.is(DamageTypes.IN_FIRE))
			return false;
		if (damagesource.is(DamageTypes.CACTUS))
			return false;
		return super.hurt(damagesource, amount);
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		CheckIfWon.execute(source.getEntity());
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
			this.animationState0.animateWhen(true, this.tickCount);
			this.animationState1.animateWhen(this.getEntityData().get(TitaniaEntity.action_state) == 2, this.tickCount);
		}
	}

	@Override
	public void baseTick() {
		super.baseTick();
		Level world = this.level();
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity attack_target;
		double attack;
		if (Math.random() <= 0.01) {
			GetCloserToPlayer.execute(world, x, y, z, this);
		}
        if (Math.random() <= 0.015
                * (this.getAttributes().hasAttribute(RorModAttributes.DIFFICULTY_MODIFIER) ? this.getAttribute(RorModAttributes.DIFFICULTY_MODIFIER).getBaseValue() : 0)) {
            if (!(this.getTarget() == null)) {
                attack_target = this.getTarget();
				attack = Mth.nextInt(RandomSource.create(), 1, 9);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:generic_spells")), SoundSource.HOSTILE, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:generic_spells")), SoundSource.HOSTILE, 1, 1, false);
					}
				}
				if (attack == 1) {
					if (attack_target instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(RorModMobEffects.MANA_DRAIN, 120, 6));
					attack_target.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MOB_ATTACK), this), 3);
					DebuffBeam.execute(world, 0.8, x, attack_target.getX(), y + 2, attack_target.getY() + 1, z, attack_target.getZ());
				} else if (attack == 2) {
					if (attack_target instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(RorModMobEffects.DEAFNESS, 120, 6));
					attack_target.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MOB_ATTACK), this), 3);
					DebuffBeam.execute(world, 0.8, x, attack_target.getX(), y + 4, attack_target.getY() + 1, z, attack_target.getZ());
				} else if (attack == 3) {
					if (attack_target instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 3));
					attack_target.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MOB_ATTACK), this), 3);
					DebuffBeam.execute(world, 0.8, x, attack_target.getX(), y + 4, attack_target.getY() + 1, z, attack_target.getZ());
				} else if (attack == 4) {
					if (attack_target instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 140, 5));
					attack_target.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MOB_ATTACK), this), 3);
					DebuffBeam.execute(world, 0.8, x, attack_target.getX(), y + 4, attack_target.getY() + 1, z, attack_target.getZ());
				} else if (attack == 5) {
					if (attack_target instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 2));
					attack_target.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MOB_ATTACK), this), 3);
					DebuffBeam.execute(world, 0.8, x, attack_target.getX(), y + 4, attack_target.getY() + 1, z, attack_target.getZ());
				} else if (attack == 6) {
					if (world instanceof ServerLevel _level) {
						LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
						entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(attack_target.getX(), attack_target.getY(), attack_target.getZ())));;
						_level.addFreshEntity(entityToSpawn);
					}
				} else if (attack == 7) {
					this.removeAllEffects();
					this.clearFire();
					if (!this.level().isClientSide())
						this.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 1));
				} else if (attack == 8) {
					FireBeam.execute(world, 0.8, x, attack_target.getX(), y + 4, attack_target.getY() + 1, z, attack_target.getZ());
					attack_target.igniteForSeconds(6);
					attack_target.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MOB_ATTACK), this), 2);
				} else if (attack == 9) {
					if (attack_target instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.HARM, 1, 0));
					MagicBeam.execute(world, 0.8, x, attack_target.getX(), y + 4, attack_target.getY() + 1, z, attack_target.getZ());
				}
				this.getEntityData().set(TitaniaEntity.action_state, 2);
			}
		}
        if (Math.random() <= 0.003
                * (this.getAttributes().hasAttribute(RorModAttributes.DIFFICULTY_MODIFIER) ? this.getAttribute(RorModAttributes.DIFFICULTY_MODIFIER).getBaseValue() : 0)) {
            if (!this.level().isClientSide())
				this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 80, 9));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
		}
        if (this.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(RorModParticleTypes.TITANIA_SHIELD.get(), x, (y + 1.5), z, 5, 0.8, 1.3, 0.8, 0);
		}
		if (this.getEntityData().get(TitaniaEntity.action_state) == 2) {
			this.getPersistentData().putDouble("timer", (this.getPersistentData().getDouble("timer") + 1));
			if (this.getPersistentData().getDouble("timer") >= 20) {
				this.getEntityData().set(TitaniaEntity.action_state, 0);
				this.getPersistentData().putDouble("timer", 0);
			}
		}
	}

	@Override
	public void startSeenByPlayer(ServerPlayer player) {
		super.startSeenByPlayer(player);
		this.bossInfo.addPlayer(player);
	}

	@Override
	public void stopSeenByPlayer(ServerPlayer player) {
		super.stopSeenByPlayer(player);
		this.bossInfo.removePlayer(player);
	}

	@Override
	public void customServerAiStep() {
		super.customServerAiStep();
		this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
	}

	@Override
	protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
	}

	@Override
	public void setNoGravity(boolean ignored) {
		super.setNoGravity(true);
	}

	@Override
	public void aiStep() {
		super.aiStep();
		this.setNoGravity(true);
	}

	@Override
	protected float getFlyingSpeed() {
		return (float) this.getAttributeValue(Attributes.FLYING_SPEED);
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
	}

	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		RorConfigsCommon.CUSTOM_MOB_ATTRIBUTES.get();
		{
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(((double) RorConfigsCommon.TITANIA_HEALTH.get()));
			this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(((double) RorConfigsCommon.TITANIA_DAMAGE.get()));
			this.getAttribute(RorModAttributes.DIFFICULTY_MODIFIER).setBaseValue(((double) RorConfigsCommon.TITANIA_ATTACK_SPEED_MULTIPLIER.get() / 100));
			this.setHealth(this.getMaxHealth());
			return livingdata;
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.1);
		builder = builder.add(Attributes.MAX_HEALTH, 1000);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 8);
		builder = builder.add(Attributes.FOLLOW_RANGE, 32);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0.1);
		builder = builder.add(Attributes.FLYING_SPEED, 0.1);
		return builder;
	}
}