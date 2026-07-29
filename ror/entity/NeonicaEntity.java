package com.dreamcritting.ror.entity;

import com.dreamcritting.ror.configs.RorConfigsCommon;
import com.dreamcritting.ror.init.RorModEntities;
import com.dreamcritting.ror.special.*;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.BuiltInRegistries;

import javax.annotation.Nullable;

import java.util.Comparator;

public class NeonicaEntity extends Monster {
	public static final EntityDataAccessor<Integer> DATA_spawnx = SynchedEntityData.defineId(NeonicaEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_spawny = SynchedEntityData.defineId(NeonicaEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_spawnz = SynchedEntityData.defineId(NeonicaEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_bombtimer = SynchedEntityData.defineId(NeonicaEntity.class, EntityDataSerializers.INT);
	private final ServerBossEvent bossInfo = new ServerBossEvent(this.getDisplayName(), ServerBossEvent.BossBarColor.BLUE, ServerBossEvent.BossBarOverlay.NOTCHED_12);

	public NeonicaEntity(EntityType<NeonicaEntity> type, Level world) {
		super(type, world);
		xpReward = 150;
		
		setPersistenceRequired();
		refreshDimensions();
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(DATA_spawnx, 0);
		builder.define(DATA_spawny, 0);
		builder.define(DATA_spawnz, 0);
		builder.define(DATA_bombtimer, 0);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth()) && this.mob.getSensing().hasLineOfSight(entity);
			}
		});
		this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(3, new RandomStrollGoal(this, 0.8));
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, Player.class, false, false));
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
	public void die(DamageSource source) {
		super.die(source);
		Level world = this.level();
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity sourceentity = source.getEntity();
		{
			final Vec3 _center = new Vec3(x, y, z);
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(48 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				if (entityiterator instanceof Player) {
					if (!(entityiterator == sourceentity)) {
						LiteralChatSender.execute(entityiterator, Component.translatable("entity.ror.neonica.dies").getString(), this.getDisplayName().getString());
					}
				}
			}
		}
		CheckIfWon.execute(sourceentity);
		LiteralChatSender.execute(sourceentity, Component.translatable("entity.ror.neonica.dies").getString(), this.getDisplayName().getString());
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata);
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
        if (RorConfigsCommon.CUSTOM_MOB_ATTRIBUTES.get()) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue((RorConfigsCommon.NEONICA_HEALTH.get()));
			this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue((RorConfigsCommon.NEONICA_DAMAGE.get()));
		}

        if (!this.level().isClientSide())
			this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 99999, 128, false, false));
		this.getEntityData().set(NeonicaEntity.DATA_spawnx, (int) Math.round(this.getX()));
		this.getEntityData().set(NeonicaEntity.DATA_spawny, (int) Math.round(this.getY()));
		this.getEntityData().set(NeonicaEntity.DATA_spawnz, (int) Math.round(this.getZ()));
		{
			final Vec3 _center = new Vec3(x, y, z);
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(48 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				if (entityiterator instanceof Player) {
					LiteralChatSender.execute(entityiterator, Component.translatable("entity.ror.neonica.spawned").getString(), this.getDisplayName().getString());
				}
			}
		}
		return retval;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("Dataspawnx", this.entityData.get(DATA_spawnx));
		compound.putInt("Dataspawny", this.entityData.get(DATA_spawny));
		compound.putInt("Dataspawnz", this.entityData.get(DATA_spawnz));
		compound.putInt("Databombtimer", this.entityData.get(DATA_bombtimer));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Dataspawnx"))
			this.entityData.set(DATA_spawnx, compound.getInt("Dataspawnx"));
		if (compound.contains("Dataspawny"))
			this.entityData.set(DATA_spawny, compound.getInt("Dataspawny"));
		if (compound.contains("Dataspawnz"))
			this.entityData.set(DATA_spawnz, compound.getInt("Dataspawnz"));
		if (compound.contains("Databombtimer"))
			this.entityData.set(DATA_bombtimer, compound.getInt("Databombtimer"));
	}

	@Override
	public void baseTick() {
		super.baseTick();
		Level world = this.level();
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		double nearbylasers;
		double bombx;
		double bomby;
		double bombz;
        if (this.getHealth() >= RorConfigsCommon.NEONICA_HEALTH.get() * 0.81) {
            if (!this.level().isClientSide())
				this.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 4, 127, false, false));
            if (!this.level().isClientSide())
				this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 4, 127, false, false));
			{
				double _tx = (this.getEntityData().get(NeonicaEntity.DATA_spawnx) - 0.5);
				double _ty = (this.getEntityData().get(NeonicaEntity.DATA_spawny));
				double _tz = (this.getEntityData().get(NeonicaEntity.DATA_spawnz) - 0.5);
				this.teleportTo(_tx, _ty, _tz);
			}
			if (Math.random() <= 0.02) {
				nearbylasers = 0;
				{
					final Vec3 _center = new Vec3(x, y, z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(38 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (entityiterator instanceof LaserbeamEntity) {
							nearbylasers = nearbylasers + 1;
						}
					}
				}
				if (nearbylasers <= 15) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = RorModEntities.LASERBEAM.get().spawn(_level, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -16, 16), y - 0.95, z + Mth.nextInt(RandomSource.create(), -16, 16)), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
			}
		} else {
			if (Math.random() <= 0.003) {
				bombx = (this.getEntityData().get(NeonicaEntity.DATA_spawnx)) + Mth.nextInt(RandomSource.create(), -16, 16);
				bomby = (this.getEntityData().get(NeonicaEntity.DATA_spawny)) - 1;
				bombz = (this.getEntityData().get(NeonicaEntity.DATA_spawnz)) + Mth.nextInt(RandomSource.create(), -16, 16);
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = RorModEntities.NEON_VORTEX.get().spawn(_level, BlockPos.containing(bombx, bomby, bombz), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(56 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (entityiterator instanceof Player) {
							WarningChatSender.execute(entityiterator, "text.ror.neon_bomb_spawn");
						}
					}
				}
				this.getEntityData().set(NeonicaEntity.DATA_bombtimer, 185);
			}
		}
		if ((this instanceof NeonicaEntity _datEntI ? _datEntI.getEntityData().get(NeonicaEntity.DATA_bombtimer) : 0) > 0) {
			this.getEntityData().set(NeonicaEntity.DATA_bombtimer, (this.getEntityData().get(NeonicaEntity.DATA_bombtimer)) - 1);
			if ((this.getEntityData().get(NeonicaEntity.DATA_bombtimer)) > 0 && (this.getEntityData().get(NeonicaEntity.DATA_bombtimer)) < 5) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(48 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (entityiterator instanceof Player livEnt) {
							LiteralChatSender.execute(entityiterator, Component.translatable("entity.ror.neonica.wins").getString(), this.getDisplayName().getString());
							entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.FELL_OUT_OF_WORLD)), livEnt.getHealth() - 2);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")),
											SoundSource.BLOCKS, 1, 1);
								} else {
									_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.explode")), SoundSource.BLOCKS, 1, 1,
											false);
								}
							}
						}
					}
				}
				if (!this.level().isClientSide())
					this.discard();
			}
		}
	}

	@Override
	public boolean isPushedByFluid() {
		return false;
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
	public EntityDimensions getDefaultDimensions(Pose pose) {
		return super.getDefaultDimensions(pose).scale(1.2f);
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.35);
		builder = builder.add(Attributes.MAX_HEALTH, 1000);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 9);
		builder = builder.add(Attributes.FOLLOW_RANGE, 24);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 10);
		return builder;
	}
}