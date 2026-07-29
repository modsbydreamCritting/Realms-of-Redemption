package com.dreamcritting.ror.entity;

import com.dreamcritting.ror.configs.RorConfigsCommon;
import com.dreamcritting.ror.init.RorModBlocks;
import com.dreamcritting.ror.special.*;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import java.util.Comparator;

public class LaserbeamEntity extends Monster {
	public LaserbeamEntity(EntityType<LaserbeamEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Player.class, false, false));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth()) && this.mob.getSensing().hasLineOfSight(entity);
			}
		});
		this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.8));
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.extinguish")), 0.15f, 1);
	}

	@Override
	public boolean hurt(DamageSource damagesource, float amount) {
			return false;
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());
		super.mobInteract(sourceentity, hand);
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level();
		double lx;
		double ly;
		double lz;
		double neonica_base_health;
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("ror:prisms")))) {
			if (!entity.level().isClientSide())
				entity.discard();
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:laser_shoots")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:laser_shoots")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			lx = sourceentity.level().clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(32)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, sourceentity)).getBlockPos()
					.getX();
			ly = sourceentity.level().clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(32)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, sourceentity)).getBlockPos()
					.getY();
			lz = sourceentity.level().clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(32)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, sourceentity)).getBlockPos()
					.getZ();
			RedBeam.execute(world, 0.6, x, lx, sourceentity.getY() + 1.4, ly, z, lz);
			RedBeam.execute(world, 0.55, x, x, sourceentity.getY() + 1.4, y + 16, z, z);
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"stopsound @p hostile ror:laser_buzz ");
			if ((world.getBlockState(BlockPos.containing(lx, ly, lz))).getBlock() == RorModBlocks.FORCE_FIELD.get()) {
				neonica_base_health = RorConfigsCommon.NEONICA_HEALTH.get();
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.EXPLOSION, lx, ly, lz, 30, 0.5, 0.5, 0.5, 1);
				{
					final Vec3 _center = new Vec3(lx, ly, lz);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (entityiterator instanceof NeonicaEntity entity1) {
							entity1.setHealth((float) (entity1.getHealth() - neonica_base_health / 50));
							if (entity1.getHealth() <= neonica_base_health * 0.8) {
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
													.withSuppressedOutput(),
											// Just faster to code it this way
											"fill ~-5 ~-5 ~-5 ~5 ~5 ~5 air replace ror:force_field");
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.elder_guardian.curse")), SoundSource.HOSTILE, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.elder_guardian.curse")), SoundSource.HOSTILE, 1, 1, false);
									}
								}
								LivingEntity _entity = (LivingEntity) entityiterator;
								_entity.removeEffect(MobEffects.DAMAGE_RESISTANCE);
								_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
								LivingEntity _livingEntity24 = (LivingEntity) entityiterator;
								if (_livingEntity24.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE))
									_livingEntity24.getAttribute(Attributes.KNOCKBACK_RESISTANCE).setBaseValue(0.3);
								GreenChatSender.execute(sourceentity, "entiy.ror.neonica.phase_2_start");
							}
						}
					}
				}
			} else {
				WarningChatSender.execute(sourceentity, "entity.ror.laserbeam.missed");
			}
		} else {
			LiteralInfoChatSender.execute(sourceentity, Component.translatable("entity.ror.laserbeam.right_clicked").getString());
		}		return retval;
	}

	@Override
	public void baseTick() {
		super.baseTick();
		Level world = this.level();
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
        if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:laser_buzz")), SoundSource.HOSTILE, (float) 0.8, 2);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:laser_buzz")), SoundSource.HOSTILE, (float) 0.8, 2, false);
			}
		}
		if (Math.random() <= 0.003) {
			if (!this.level().isClientSide())
				this.discard();
		}
	}

	@Override
	public boolean isPushedByFluid() {
		return false;
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 1000);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 12);
		builder = builder.add(Attributes.FOLLOW_RANGE, 32);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 10);
		return builder;
	}
}