package com.dreamcritting.ror.entity;

import com.dreamcritting.ror.configs.RorConfigsCommon;
import com.dreamcritting.ror.init.RorModAttributes;
import com.dreamcritting.ror.init.RorModMobEffects;
import com.dreamcritting.ror.special.*;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.AABB;
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
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import java.util.Comparator;
import java.util.EnumSet;

import javax.annotation.Nullable;

public class MoxEntity extends Monster {
	private final ServerBossEvent bossInfo = new ServerBossEvent(this.getDisplayName(), ServerBossEvent.BossBarColor.WHITE, ServerBossEvent.BossBarOverlay.NOTCHED_12);

	public MoxEntity(EntityType<MoxEntity> type, Level world) {
		super(type, world);
		xpReward = 120;
		
		setPersistenceRequired();
		this.moveControl = new FlyingMoveControl(this, 10, true);
	}

	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		RorConfigsCommon.CUSTOM_MOB_ATTRIBUTES.get();
		{
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(((double) RorConfigsCommon.MOX_HEALTH.get()));
			this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(((double) RorConfigsCommon.MOX_DAMAGE.get()));
			this.getAttribute(RorModAttributes.DIFFICULTY_MODIFIER).setBaseValue(((double) RorConfigsCommon.MOX_ATTACK_SPEED_MULTIPLIER.get() / 100));
			this.setHealth(this.getMaxHealth());
			return livingdata;
		}
	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new FlyingPathNavigation(this, world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new Goal() {
			{
				this.setFlags(EnumSet.of(Goal.Flag.MOVE));
			}

			public boolean canUse() {
                return MoxEntity.this.getTarget() != null && !MoxEntity.this.getMoveControl().hasWanted();
			}

			@Override
			public boolean canContinueToUse() {
				return MoxEntity.this.getMoveControl().hasWanted() && MoxEntity.this.getTarget() != null && MoxEntity.this.getTarget().isAlive();
			}

			@Override
			public void start() {
				LivingEntity livingentity = MoxEntity.this.getTarget();
				Vec3 vec3d = livingentity.getEyePosition(1);
				MoxEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1);
			}

			@Override
			public void tick() {
				LivingEntity livingentity = MoxEntity.this.getTarget();
				if (MoxEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
					MoxEntity.this.doHurtTarget(livingentity);
				} else {
					double d0 = MoxEntity.this.distanceToSqr(livingentity);
					if (d0 < 16) {
						Vec3 vec3d = livingentity.getEyePosition(1);
						MoxEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1);
					}
				}
			}
		});
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.8, 20) {
			@Override
			protected Vec3 getPosition() {
				RandomSource random = MoxEntity.this.getRandom();
				double dir_x = MoxEntity.this.getX() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_y = MoxEntity.this.getY() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_z = MoxEntity.this.getZ() + ((random.nextFloat() * 2 - 1) * 16);
				return new Vec3(dir_x, dir_y, dir_z);
			}
		});
		this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth()) && this.mob.getSensing().hasLineOfSight(entity);
			}
		});
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, Player.class, false, false));
		this.targetSelector.addGoal(6, new HurtByTargetGoal(this));
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:mox_ambient"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.ghast.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:mox_dies"));
	}

	@Override
	public boolean causeFallDamage(float l, float d, DamageSource source) {
		return false;
	}

	@Override
	public boolean hurt(DamageSource damagesource, float amount) {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Level world = this.level();
		Entity entity = this;
		Entity sourceentity = damagesource.getEntity();
        GhostIsAttacked.execute(world, x, y, z, entity, sourceentity);
		return super.hurt(damagesource, amount);
	}

	@Override
	public boolean doHurtTarget(Entity entity) {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Level world = this.level();
		Entity sourceentity = this;
		if (!super.doHurtTarget(entity)) {
			return false;
		} else {
			GhostAttacksEntity.execute(world, x, y, z, entity, sourceentity);
			return true;
		}
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		CheckIfWon.execute(source.getEntity());
	}

	@Override
	public void awardKillScore(Entity entity, int score, DamageSource damageSource) {
		super.awardKillScore(entity, score, damageSource);
		Level world = this.level();
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:mox_kills")), SoundSource.HOSTILE, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:mox_kills")), SoundSource.HOSTILE, 1, 1, false);
			}
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
		double difficulty_multiplier;
        difficulty_multiplier = this.getAttributes().hasAttribute(RorModAttributes.DIFFICULTY_MODIFIER) ? this.getAttribute(RorModAttributes.DIFFICULTY_MODIFIER).getBaseValue() : 0;
		if (Math.random() <= 0.01) {
			GetCloserToPlayer.execute(world, x, y, z, this);
		}
		if (Math.random() <= 0.01 * difficulty_multiplier) {
            attack_target = this.getTarget();
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SOUL, x, y, z, 10, 4, 4, 4, 0.1);
			if (!(attack_target == null)) {
                if ((Entity) this.getTarget() instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(
							new MobEffectInstance(RorModMobEffects.FEAR, 100, (attack_target instanceof LivingEntity _livEnt && _livEnt.hasEffect(RorModMobEffects.FEAR) ? _livEnt.getEffect(RorModMobEffects.FEAR).getAmplifier() : 0) + 1, true, true));
				if (!this.level().isClientSide())
					this.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1, true, true));
			}
		}
		if (Math.random() <= 0.005 * difficulty_multiplier) {
            attack_target = this.getTarget();
			if (!(attack_target == null)) {
				if (attack_target instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 100, 0, true, true));
				attack_target.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MOB_ATTACK), this), 4);
			}
		}
		if (Math.random() <= 0.002 * difficulty_multiplier) {
            attack_target = this.getTarget();
			if (!(attack_target == null)) {
				if (attack_target instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 100, 0, true, true));
				attack_target.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MOB_ATTACK), this), 6);
			}
		}
		if (Math.random() <= 0.02 * difficulty_multiplier) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (entityiterator instanceof Player) {
						entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MOB_ATTACK), this), 4);
					}
				}
			}
		}
		world.addParticle(ParticleTypes.SNEEZE, x, y, z, 0, 0, 0);
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

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.1);
		builder = builder.add(Attributes.MAX_HEALTH, 1000);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 7);
		builder = builder.add(Attributes.FOLLOW_RANGE, 24);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 2);
		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0.1);
		builder = builder.add(Attributes.FLYING_SPEED, 0.1);
		return builder;
	}
}