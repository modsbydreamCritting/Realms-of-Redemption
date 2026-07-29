package com.dreamcritting.ror.entity;

import com.dreamcritting.ror.special.GhostAttacksEntity;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
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
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import java.util.EnumSet;

import com.dreamcritting.ror.special.GhostIsAttacked;
import com.dreamcritting.ror.special.DontAttackPlayers;

public class AlliedGhostEntity extends Monster {
	public AlliedGhostEntity(EntityType<AlliedGhostEntity> type, Level world) {
		super(type, world);
		xpReward = 6;
		
		this.moveControl = new FlyingMoveControl(this, 10, true);
	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new FlyingPathNavigation(this, world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Monster.class, false, false) {
			@Override
			public boolean canUse() {
				double x = AlliedGhostEntity.this.getX();
				double y = AlliedGhostEntity.this.getY();
				double z = AlliedGhostEntity.this.getZ();
				Entity entity = AlliedGhostEntity.this;
				Level world = AlliedGhostEntity.this.level();
				return super.canUse() && DontAttackPlayers.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = AlliedGhostEntity.this.getX();
				double y = AlliedGhostEntity.this.getY();
				double z = AlliedGhostEntity.this.getZ();
				Entity entity = AlliedGhostEntity.this;
				Level world = AlliedGhostEntity.this.level();
				return super.canContinueToUse() && DontAttackPlayers.execute(entity);
			}
		});
		this.goalSelector.addGoal(2, new Goal() {
			{
				this.setFlags(EnumSet.of(Goal.Flag.MOVE));
			}

			public boolean canUse() {
				if (AlliedGhostEntity.this.getTarget() != null && !AlliedGhostEntity.this.getMoveControl().hasWanted()) {
					return true;
				} else {
					return false;
				}
			}

			@Override
			public boolean canContinueToUse() {
				return AlliedGhostEntity.this.getMoveControl().hasWanted() && AlliedGhostEntity.this.getTarget() != null && AlliedGhostEntity.this.getTarget().isAlive();
			}

			@Override
			public void start() {
				LivingEntity livingentity = AlliedGhostEntity.this.getTarget();
				Vec3 vec3d = livingentity.getEyePosition(1);
				AlliedGhostEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1);
			}

			@Override
			public void tick() {
				LivingEntity livingentity = AlliedGhostEntity.this.getTarget();
				if (AlliedGhostEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
					AlliedGhostEntity.this.doHurtTarget(livingentity);
				} else {
					double d0 = AlliedGhostEntity.this.distanceToSqr(livingentity);
					if (d0 < 16) {
						Vec3 vec3d = livingentity.getEyePosition(1);
						AlliedGhostEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1);
					}
				}
			}
		});
		this.goalSelector.addGoal(3, new RandomStrollGoal(this, 0.8, 20) {
			@Override
			protected Vec3 getPosition() {
				RandomSource random = AlliedGhostEntity.this.getRandom();
				double dir_x = AlliedGhostEntity.this.getX() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_y = AlliedGhostEntity.this.getY() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_z = AlliedGhostEntity.this.getZ() + ((random.nextFloat() * 2 - 1) * 16);
				return new Vec3(dir_x, dir_y, dir_z);
			}
		});
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < 1.44 && this.mob.getSensing().hasLineOfSight(entity);
			}
		});
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(6, new HurtByTargetGoal(this) {
			@Override
			public boolean canUse() {
				double x = AlliedGhostEntity.this.getX();
				double y = AlliedGhostEntity.this.getY();
				double z = AlliedGhostEntity.this.getZ();
				Entity entity = AlliedGhostEntity.this;
				Level world = AlliedGhostEntity.this.level();
				return super.canUse() && DontAttackPlayers.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = AlliedGhostEntity.this.getX();
				double y = AlliedGhostEntity.this.getY();
				double z = AlliedGhostEntity.this.getZ();
				Entity entity = AlliedGhostEntity.this;
				Level world = AlliedGhostEntity.this.level();
				return super.canContinueToUse() && DontAttackPlayers.execute(entity);
			}
		});
	}

	@Override
	public SoundEvent getAmbientSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:ghost_ambient"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.ghast.scream"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.ghast.death"));
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
		Entity immediatesourceentity = damagesource.getDirectEntity();

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
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.08);
		builder = builder.add(Attributes.MAX_HEALTH, 50);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.25);
		builder = builder.add(Attributes.FLYING_SPEED, 0.08);
		return builder;
	}
}