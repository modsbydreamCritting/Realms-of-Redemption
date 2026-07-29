package com.dreamcritting.ror.entity;

import com.dreamcritting.ror.init.RorModItems;
import com.dreamcritting.ror.special.LiteralChatSender;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.Difficulty;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.BuiltInRegistries;

import com.dreamcritting.ror.init.RorModEntities;

public class NeonResidentEntity extends Monster {
	public static final EntityDataAccessor<Boolean> started = SynchedEntityData.defineId(NeonResidentEntity.class, EntityDataSerializers.BOOLEAN);

	public NeonResidentEntity(EntityType<NeonResidentEntity> type, Level world) {
		super(type, world);
		xpReward = 1;
		
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(started, false);
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
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1));
		this.targetSelector.addGoal(3, new HurtByTargetGoal(this).setAlertOthers());
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(5, new FloatGoal(this));
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
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("started", this.entityData.get(started));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("started"))
			this.entityData.set(started, compound.getBoolean("started"));
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());
		super.mobInteract(sourceentity, hand);
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level();
        if (this.getHealth() == this.getMaxHealth()) {
            if (!(this.getTarget() instanceof LivingEntity)) {
                if (!(this.getEntityData().get(NeonResidentEntity.started))) {
					this.getEntityData().set(NeonResidentEntity.started, true);
                    LiteralChatSender.execute(sourceentity, Component.translatable("text.could_you_help_me").getString(), entity.getDisplayName().getString());
                    ItemStack _setstack9 = new ItemStack(
                            (BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("ror:random_items"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
                    _setstack9.setCount(1);
					this.setItemInHand(InteractionHand.MAIN_HAND, _setstack9);
                    if (sourceentity instanceof ServerPlayer _player) {
                        AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("ror:a_friendly_face"));
                        if (_adv != null) {
                            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                            if (!_ap.isDone()) {
                                for (String criteria : _ap.getRemainingCriteria())
                                    _player.getAdvancements().award(_adv, criteria);
                            }
                        }
                    }
                } else {
                    LiteralChatSender.execute(sourceentity,
                            Component.translatable("text.could_you_get_me_a").getString() + "" + this.getMainHandItem().getDisplayName().getString().replace("]", "").replace("[", ""),
                            entity.getDisplayName().getString());
                    if (sourceentity.getMainHandItem().getItem() == this.getMainHandItem().getItem()) {
						sourceentity.getMainHandItem().shrink(1);
                        this.getMainHandItem().shrink(1);
                        LiteralChatSender.execute(sourceentity, Component.translatable("text.thank_you").getString(), entity.getDisplayName().getString());
                        if (world instanceof ServerLevel _level) {
                            ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(RorModItems.NEON_COIN.get()));
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity(entityToSpawn);
                        }
                        if (Mth.nextInt(RandomSource.create(), 1, 10) == 10) {
                            if (world instanceof ServerLevel _level) {
                                ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(RorModItems.NEON_COIN.get()));
                                entityToSpawn.setPickUpDelay(10);
                                _level.addFreshEntity(entityToSpawn);
                            }
                        }
						this.getEntityData().set(NeonResidentEntity.started, false);
                        if (sourceentity instanceof ServerPlayer _player) {
                            AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("ror:businessman"));
                            if (_adv != null) {
                                AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                if (!_ap.isDone()) {
                                    for (String criteria : _ap.getRemainingCriteria())
                                        _player.getAdvancements().award(_adv, criteria);
                                }
                            }
                        }
                    }
                }
            }
        }
		return retval;
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
		event.register(RorModEntities.NEON_RESIDENT.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getDifficulty() != Difficulty.PEACEFUL && Monster.isDarkEnoughToSpawn(world, pos, random) && Mob.checkMobSpawnRules(entityType, world, reason, pos, random)),
				RegisterSpawnPlacementsEvent.Operation.REPLACE);
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 50);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 6);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		return builder;
	}
}