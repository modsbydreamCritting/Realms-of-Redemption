package com.dreamcritting.ror.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import com.dreamcritting.ror.entity.*;
import com.dreamcritting.ror.RorMod;

@EventBusSubscriber
public class RorModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, RorMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<LaserEntity>> LASER = register("laser",
			EntityType.Builder.<LaserEntity>of(LaserEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<LaserbotEntity>> LASERBOT = register("laserbot",
			EntityType.Builder.<LaserbotEntity>of(LaserbotEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<HeavyLaserbotEntity>> HEAVY_LASERBOT = register("heavy_laserbot",
			EntityType.Builder.<HeavyLaserbotEntity>of(HeavyLaserbotEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 2.3f));
	public static final DeferredHolder<EntityType<?>, EntityType<RedCrystalGolemEntity>> RED_CRYSTAL_GOLEM = register("red_crystal_golem",
			EntityType.Builder.<RedCrystalGolemEntity>of(RedCrystalGolemEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<CowbotEntity>> COWBOT = register("cowbot",
			EntityType.Builder.<CowbotEntity>of(CowbotEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.9f, 1.4f));
	public static final DeferredHolder<EntityType<?>, EntityType<YellowCrystalGolemEntity>> YELLOW_CRYSTAL_GOLEM = register("yellow_crystal_golem",
			EntityType.Builder.<YellowCrystalGolemEntity>of(YellowCrystalGolemEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<ScanbotEntity>> SCANBOT = register("scanbot",
			EntityType.Builder.<ScanbotEntity>of(ScanbotEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<GreenCrystalGolemEntity>> GREEN_CRYSTAL_GOLEM = register("green_crystal_golem",
			EntityType.Builder.<GreenCrystalGolemEntity>of(GreenCrystalGolemEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<LightBlueCrystalGolemEntity>> LIGHT_BLUE_CRYSTAL_GOLEM = register("light_blue_crystal_golem",
			EntityType.Builder.<LightBlueCrystalGolemEntity>of(LightBlueCrystalGolemEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<BlueCrystalGolemEntity>> BLUE_CRYSTAL_GOLEM = register("blue_crystal_golem",
			EntityType.Builder.<BlueCrystalGolemEntity>of(BlueCrystalGolemEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<SmallRobotEntity>> SMALL_ROBOT = register("small_robot",
			EntityType.Builder.<SmallRobotEntity>of(SmallRobotEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<LaserBlastEntity>> LASER_BLAST = register("laser_blast",
			EntityType.Builder.<LaserBlastEntity>of(LaserBlastEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<RedCrystalStarEntity>> RED_CRYSTAL_STAR = register("red_crystal_star",
			EntityType.Builder.<RedCrystalStarEntity>of(RedCrystalStarEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.8f, 2.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<RedCrystalConstructEntity>> RED_CRYSTAL_CONSTRUCT = register("red_crystal_construct",
			EntityType.Builder.<RedCrystalConstructEntity>of(RedCrystalConstructEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.4f, 2.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<CorrundumGolemEntity>> CORRUNDUM_GOLEM = register("corrundum_golem",
			EntityType.Builder.<CorrundumGolemEntity>of(CorrundumGolemEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1f, 2.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<YellowCrystalStarEntity>> YELLOW_CRYSTAL_STAR = register("yellow_crystal_star",
			EntityType.Builder.<YellowCrystalStarEntity>of(YellowCrystalStarEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.8f, 2.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<GreenCrystalStarEntity>> GREEN_CRYSTAL_STAR = register("green_crystal_star",
			EntityType.Builder.<GreenCrystalStarEntity>of(GreenCrystalStarEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.8f, 2.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<LightBlueCrystalStarEntity>> LIGHT_BLUE_CRYSTAL_STAR = register("light_blue_crystal_star",
			EntityType.Builder.<LightBlueCrystalStarEntity>of(LightBlueCrystalStarEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.8f, 2.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<BlueCrystalStarEntity>> BLUE_CRYSTAL_STAR = register("blue_crystal_star",
			EntityType.Builder.<BlueCrystalStarEntity>of(BlueCrystalStarEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.8f, 2.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<JawWandProjectileEntity>> JAW_WAND_PROJECTILE = register("jaw_wand_projectile",
			EntityType.Builder.<JawWandProjectileEntity>of(JawWandProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<NeonResidentEntity>> NEON_RESIDENT = register("neon_resident",
			EntityType.Builder.<NeonResidentEntity>of(NeonResidentEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<UndeadNeonResidentEntity>> UNDEAD_NEON_RESIDENT = register("undead_neon_resident",
			EntityType.Builder.<UndeadNeonResidentEntity>of(UndeadNeonResidentEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<BabyNeonResidentEntity>> BABY_NEON_RESIDENT = register("baby_neon_resident",
			EntityType.Builder.<BabyNeonResidentEntity>of(BabyNeonResidentEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.4f, 1.2f));
	public static final DeferredHolder<EntityType<?>, EntityType<CorrundolingEntity>> CORRUNDOLING = register("corrundoling",
			EntityType.Builder.<CorrundolingEntity>of(CorrundolingEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.5f, 0.3f));
	public static final DeferredHolder<EntityType<?>, EntityType<DevourerWandProjectileEntity>> DEVOURER_WAND_PROJECTILE = register("devourer_wand_projectile",
			EntityType.Builder.<DevourerWandProjectileEntity>of(DevourerWandProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<YellowCrystalConstructEntity>> YELLOW_CRYSTAL_CONSTRUCT = register("yellow_crystal_construct",
			EntityType.Builder.<YellowCrystalConstructEntity>of(YellowCrystalConstructEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.4f, 2.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<GreenCrystalConstructEntity>> GREEN_CRYSTAL_CONSTRUCT = register("green_crystal_construct",
			EntityType.Builder.<GreenCrystalConstructEntity>of(GreenCrystalConstructEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.4f, 2.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<LightBlueCrystalConstructEntity>> LIGHT_BLUE_CRYSTAL_CONSTRUCT = register("light_blue_crystal_construct",
			EntityType.Builder.<LightBlueCrystalConstructEntity>of(LightBlueCrystalConstructEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.4f, 2.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<BlueCrystalConstructEntity>> BLUE_CRYSTAL_CONSTRUCT = register("blue_crystal_construct",
			EntityType.Builder.<BlueCrystalConstructEntity>of(BlueCrystalConstructEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.4f, 2.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<GoldConstructEntity>> GOLD_CONSTRUCT = register("gold_construct",
			EntityType.Builder.<GoldConstructEntity>of(GoldConstructEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.4f, 2.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<GoldScanbotEntity>> GOLD_SCANBOT = register("gold_scanbot",
			EntityType.Builder.<GoldScanbotEntity>of(GoldScanbotEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<GoldUndeadNeonResidentEntity>> GOLD_UNDEAD_NEON_RESIDENT = register("gold_undead_neon_resident",
			EntityType.Builder.<GoldUndeadNeonResidentEntity>of(GoldUndeadNeonResidentEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<PlacerEntity>> PLACER = register("placer",
			EntityType.Builder.<PlacerEntity>of(PlacerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(2).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<GuardbotEntity>> GUARDBOT = register("guardbot",
			EntityType.Builder.<GuardbotEntity>of(GuardbotEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<MutantNeonResidentEntity>> MUTANT_NEON_RESIDENT = register("mutant_neon_resident",
			EntityType.Builder.<MutantNeonResidentEntity>of(MutantNeonResidentEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.7f, 2.4f));
	public static final DeferredHolder<EntityType<?>, EntityType<StreetlightEntity>> STREETLIGHT = register("streetlight",
			EntityType.Builder.<StreetlightEntity>of(StreetlightEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.3f));
	public static final DeferredHolder<EntityType<?>, EntityType<NeonicaEntity>> NEONICA = register("neonica",
			EntityType.Builder.<NeonicaEntity>of(NeonicaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1f, 2.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<LaserbeamEntity>> LASERBEAM = register("laserbeam",
			EntityType.Builder.<LaserbeamEntity>of(LaserbeamEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 13f));
	public static final DeferredHolder<EntityType<?>, EntityType<SmallSnailEntity>> SMALL_SNAIL = register("small_snail",
			EntityType.Builder.<SmallSnailEntity>of(SmallSnailEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.2f, 0.1f));
	public static final DeferredHolder<EntityType<?>, EntityType<GnomeEntity>> GNOME = register("gnome",
			EntityType.Builder.<GnomeEntity>of(GnomeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.5f, 1.3f));
	public static final DeferredHolder<EntityType<?>, EntityType<PrismkeeperEntity>> PRISMKEEPER = register("prismkeeper",
			EntityType.Builder.<PrismkeeperEntity>of(PrismkeeperEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<SpawnFlufferEntity>> SPAWN_FLUFFER = register("spawn_fluffer",
			EntityType.Builder.<SpawnFlufferEntity>of(SpawnFlufferEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(0).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.1f, 0.1f));
	public static final DeferredHolder<EntityType<?>, EntityType<MechanicalWandProjectileEntity>> MECHANICAL_WAND_PROJECTILE = register("mechanical_wand_projectile",
			EntityType.Builder.<MechanicalWandProjectileEntity>of(MechanicalWandProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<SwarmSpiderEntity>> SWARM_SPIDER = register("swarm_spider",
			EntityType.Builder.<SwarmSpiderEntity>of(SwarmSpiderEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.6f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<RainbowWandProjectileEntity>> RAINBOW_WAND_PROJECTILE = register("rainbow_wand_projectile",
			EntityType.Builder.<RainbowWandProjectileEntity>of(RainbowWandProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<MeatPuddleEntity>> MEAT_PUDDLE = register("meat_puddle",
			EntityType.Builder.<MeatPuddleEntity>of(MeatPuddleEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.8f, 0.3f));
	public static final DeferredHolder<EntityType<?>, EntityType<GoogloidEntity>> GOOGLOID = register("googloid",
			EntityType.Builder.<GoogloidEntity>of(GoogloidEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<UndercopterEntity>> UNDERCOPTER = register("undercopter",
			EntityType.Builder.<UndercopterEntity>of(UndercopterEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<SpawnerPlacerEntity>> SPAWNER_PLACER = register("spawner_placer",
			EntityType.Builder.<SpawnerPlacerEntity>of(SpawnerPlacerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(2).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<MoonDungeonGuardEntity>> MOON_DUNGEON_GUARD = register("moon_dungeon_guard",
			EntityType.Builder.<MoonDungeonGuardEntity>of(MoonDungeonGuardEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.3f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<GhostEntity>> GHOST = register("ghost",
			EntityType.Builder.<GhostEntity>of(GhostEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<ThrownTsavoriteShurikenEntity>> THROWN_TSAVORITE_SHURIKEN = register("thrown_tsavorite_shuriken",
			EntityType.Builder.<ThrownTsavoriteShurikenEntity>of(ThrownTsavoriteShurikenEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<ThrownTourmalineShurikenEntity>> THROWN_TOURMALINE_SHURIKEN = register("thrown_tourmaline_shuriken",
			EntityType.Builder.<ThrownTourmalineShurikenEntity>of(ThrownTourmalineShurikenEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<ThrownMagnoliteShurikenEntity>> THROWN_MAGNOLITE_SHURIKEN = register("thrown_magnolite_shuriken",
			EntityType.Builder.<ThrownMagnoliteShurikenEntity>of(ThrownMagnoliteShurikenEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<ThrownGalacticShurikenEntity>> THROWN_GALACTIC_SHURIKEN = register("thrown_galactic_shuriken",
			EntityType.Builder.<ThrownGalacticShurikenEntity>of(ThrownGalacticShurikenEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<ThrownPrismiteShurikenEntity>> THROWN_PRISMITE_SHURIKEN = register("thrown_prismite_shuriken",
			EntityType.Builder.<ThrownPrismiteShurikenEntity>of(ThrownPrismiteShurikenEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<GoogloidGhostEntity>> GOOGLOID_GHOST = register("googloid_ghost",
			EntityType.Builder.<GoogloidGhostEntity>of(GoogloidGhostEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<GhostAngelEntity>> GHOST_ANGEL = register("ghost_angel",
			EntityType.Builder.<GhostAngelEntity>of(GhostAngelEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1f, 3f));
	public static final DeferredHolder<EntityType<?>, EntityType<CrystalcopterEntity>> CRYSTALCOPTER = register("crystalcopter",
			EntityType.Builder.<CrystalcopterEntity>of(CrystalcopterEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.8f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<TempleEntity>> TEMPLE = register("temple",
			EntityType.Builder.<TempleEntity>of(TempleEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(0).setUpdateInterval(3).fireImmune().ridingOffset(-0.6f).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<FairyWandProjectileEntity>> FAIRY_WAND_PROJECTILE = register("fairy_wand_projectile",
			EntityType.Builder.<FairyWandProjectileEntity>of(FairyWandProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<RainboomEntity>> RAINBOOM = register("rainboom",
			EntityType.Builder.<RainboomEntity>of(RainboomEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(512).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<NeonVortexEntity>> NEON_VORTEX = register("neon_vortex",
			EntityType.Builder.<NeonVortexEntity>of(NeonVortexEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(1f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<AlliedGhostEntity>> ALLIED_GHOST = register("allied_ghost",
			EntityType.Builder.<AlliedGhostEntity>of(AlliedGhostEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<KillbotEntity>> KILLBOT = register("killbot",
			EntityType.Builder.<KillbotEntity>of(KillbotEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(2.2f, 4.4f));
	public static final DeferredHolder<EntityType<?>, EntityType<CorrundodileEntity>> CORRUNDODILE = register("corrundodile",
			EntityType.Builder.<CorrundodileEntity>of(CorrundodileEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(3f, 2.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<CorrundumSpikeEntity>> CORRUNDUM_SPIKE = register("corrundum_spike",
			EntityType.Builder.<CorrundumSpikeEntity>of(CorrundumSpikeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(1.4f, 0.9f));
	public static final DeferredHolder<EntityType<?>, EntityType<GiantMoleEntity>> GIANT_MOLE = register("giant_mole",
			EntityType.Builder.<GiantMoleEntity>of(GiantMoleEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<GiantButterflyEntity>> GIANT_BUTTERFLY = register("giant_butterfly",
			EntityType.Builder.<GiantButterflyEntity>of(GiantButterflyEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(96).setUpdateInterval(3)

					.sized(1f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<HumboldtEntity>> HUMBOLDT = register("humboldt",
			EntityType.Builder.<HumboldtEntity>of(HumboldtEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.1f, 0.85f));
	public static final DeferredHolder<EntityType<?>, EntityType<MaliciousRootEntity>> MALICIOUS_ROOT = register("malicious_root",
			EntityType.Builder.<MaliciousRootEntity>of(MaliciousRootEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.7f, 0.7f));
	public static final DeferredHolder<EntityType<?>, EntityType<FairyEntity>> FAIRY = register("fairy",
			EntityType.Builder.<FairyEntity>of(FairyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.8f, 1.2f));
	public static final DeferredHolder<EntityType<?>, EntityType<MoxEntity>> MOX = register("mox", EntityType.Builder.<MoxEntity>of(MoxEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(1f, 3f));
	public static final DeferredHolder<EntityType<?>, EntityType<TitaniaEntity>> TITANIA = register("titania",
			EntityType.Builder.<TitaniaEntity>of(TitaniaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(96).setUpdateInterval(3).fireImmune()

					.sized(1f, 3f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		LaserbotEntity.init(event);
		HeavyLaserbotEntity.init(event);
		RedCrystalGolemEntity.init(event);
		CowbotEntity.init(event);
		YellowCrystalGolemEntity.init(event);
		ScanbotEntity.init(event);
		GreenCrystalGolemEntity.init(event);
		LightBlueCrystalGolemEntity.init(event);
		BlueCrystalGolemEntity.init(event);
		SmallRobotEntity.init(event);
		RedCrystalStarEntity.init(event);
		RedCrystalConstructEntity.init(event);
		CorrundumGolemEntity.init(event);
		YellowCrystalStarEntity.init(event);
		GreenCrystalStarEntity.init(event);
		LightBlueCrystalStarEntity.init(event);
		BlueCrystalStarEntity.init(event);
		NeonResidentEntity.init(event);
		UndeadNeonResidentEntity.init(event);
		BabyNeonResidentEntity.init(event);
		CorrundolingEntity.init(event);
		YellowCrystalConstructEntity.init(event);
		GreenCrystalConstructEntity.init(event);
		LightBlueCrystalConstructEntity.init(event);
		BlueCrystalConstructEntity.init(event);
		GoldConstructEntity.init(event);
		GoldScanbotEntity.init(event);
		GoldUndeadNeonResidentEntity.init(event);
		GuardbotEntity.init(event);
		MutantNeonResidentEntity.init(event);
		StreetlightEntity.init(event);
		NeonicaEntity.init(event);
		LaserbeamEntity.init(event);
		SmallSnailEntity.init(event);
		GnomeEntity.init(event);
		PrismkeeperEntity.init(event);
		SpawnFlufferEntity.init(event);
		SwarmSpiderEntity.init(event);
		MeatPuddleEntity.init(event);
		GoogloidEntity.init(event);
		UndercopterEntity.init(event);
		MoonDungeonGuardEntity.init(event);
		GhostEntity.init(event);
		GoogloidGhostEntity.init(event);
		GhostAngelEntity.init(event);
		CrystalcopterEntity.init(event);
		TempleEntity.init(event);
		RainboomEntity.init(event);
		NeonVortexEntity.init(event);
		AlliedGhostEntity.init(event);
		KillbotEntity.init(event);
		CorrundodileEntity.init(event);
		CorrundumSpikeEntity.init(event);
		GiantMoleEntity.init(event);
		GiantButterflyEntity.init(event);
		HumboldtEntity.init(event);
		MaliciousRootEntity.init(event);
		FairyEntity.init(event);
		MoxEntity.init(event);
		TitaniaEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(LASERBOT.get(), LaserbotEntity.createAttributes().build());
		event.put(HEAVY_LASERBOT.get(), HeavyLaserbotEntity.createAttributes().build());
		event.put(RED_CRYSTAL_GOLEM.get(), RedCrystalGolemEntity.createAttributes().build());
		event.put(COWBOT.get(), CowbotEntity.createAttributes().build());
		event.put(YELLOW_CRYSTAL_GOLEM.get(), YellowCrystalGolemEntity.createAttributes().build());
		event.put(SCANBOT.get(), ScanbotEntity.createAttributes().build());
		event.put(GREEN_CRYSTAL_GOLEM.get(), GreenCrystalGolemEntity.createAttributes().build());
		event.put(LIGHT_BLUE_CRYSTAL_GOLEM.get(), LightBlueCrystalGolemEntity.createAttributes().build());
		event.put(BLUE_CRYSTAL_GOLEM.get(), BlueCrystalGolemEntity.createAttributes().build());
		event.put(SMALL_ROBOT.get(), SmallRobotEntity.createAttributes().build());
		event.put(RED_CRYSTAL_STAR.get(), RedCrystalStarEntity.createAttributes().build());
		event.put(RED_CRYSTAL_CONSTRUCT.get(), RedCrystalConstructEntity.createAttributes().build());
		event.put(CORRUNDUM_GOLEM.get(), CorrundumGolemEntity.createAttributes().build());
		event.put(YELLOW_CRYSTAL_STAR.get(), YellowCrystalStarEntity.createAttributes().build());
		event.put(GREEN_CRYSTAL_STAR.get(), GreenCrystalStarEntity.createAttributes().build());
		event.put(LIGHT_BLUE_CRYSTAL_STAR.get(), LightBlueCrystalStarEntity.createAttributes().build());
		event.put(BLUE_CRYSTAL_STAR.get(), BlueCrystalStarEntity.createAttributes().build());
		event.put(NEON_RESIDENT.get(), NeonResidentEntity.createAttributes().build());
		event.put(UNDEAD_NEON_RESIDENT.get(), UndeadNeonResidentEntity.createAttributes().build());
		event.put(BABY_NEON_RESIDENT.get(), BabyNeonResidentEntity.createAttributes().build());
		event.put(CORRUNDOLING.get(), CorrundolingEntity.createAttributes().build());
		event.put(YELLOW_CRYSTAL_CONSTRUCT.get(), YellowCrystalConstructEntity.createAttributes().build());
		event.put(GREEN_CRYSTAL_CONSTRUCT.get(), GreenCrystalConstructEntity.createAttributes().build());
		event.put(LIGHT_BLUE_CRYSTAL_CONSTRUCT.get(), LightBlueCrystalConstructEntity.createAttributes().build());
		event.put(BLUE_CRYSTAL_CONSTRUCT.get(), BlueCrystalConstructEntity.createAttributes().build());
		event.put(GOLD_CONSTRUCT.get(), GoldConstructEntity.createAttributes().build());
		event.put(GOLD_SCANBOT.get(), GoldScanbotEntity.createAttributes().build());
		event.put(GOLD_UNDEAD_NEON_RESIDENT.get(), GoldUndeadNeonResidentEntity.createAttributes().build());
		event.put(PLACER.get(), PlacerEntity.createAttributes().build());
		event.put(GUARDBOT.get(), GuardbotEntity.createAttributes().build());
		event.put(MUTANT_NEON_RESIDENT.get(), MutantNeonResidentEntity.createAttributes().build());
		event.put(STREETLIGHT.get(), StreetlightEntity.createAttributes().build());
		event.put(NEONICA.get(), NeonicaEntity.createAttributes().build());
		event.put(LASERBEAM.get(), LaserbeamEntity.createAttributes().build());
		event.put(SMALL_SNAIL.get(), SmallSnailEntity.createAttributes().build());
		event.put(GNOME.get(), GnomeEntity.createAttributes().build());
		event.put(PRISMKEEPER.get(), PrismkeeperEntity.createAttributes().build());
		event.put(SPAWN_FLUFFER.get(), SpawnFlufferEntity.createAttributes().build());
		event.put(SWARM_SPIDER.get(), SwarmSpiderEntity.createAttributes().build());
		event.put(MEAT_PUDDLE.get(), MeatPuddleEntity.createAttributes().build());
		event.put(GOOGLOID.get(), GoogloidEntity.createAttributes().build());
		event.put(UNDERCOPTER.get(), UndercopterEntity.createAttributes().build());
		event.put(SPAWNER_PLACER.get(), SpawnerPlacerEntity.createAttributes().build());
		event.put(MOON_DUNGEON_GUARD.get(), MoonDungeonGuardEntity.createAttributes().build());
		event.put(GHOST.get(), GhostEntity.createAttributes().build());
		event.put(GOOGLOID_GHOST.get(), GoogloidGhostEntity.createAttributes().build());
		event.put(GHOST_ANGEL.get(), GhostAngelEntity.createAttributes().build());
		event.put(CRYSTALCOPTER.get(), CrystalcopterEntity.createAttributes().build());
		event.put(TEMPLE.get(), TempleEntity.createAttributes().build());
		event.put(RAINBOOM.get(), RainboomEntity.createAttributes().build());
		event.put(NEON_VORTEX.get(), NeonVortexEntity.createAttributes().build());
		event.put(ALLIED_GHOST.get(), AlliedGhostEntity.createAttributes().build());
		event.put(KILLBOT.get(), KillbotEntity.createAttributes().build());
		event.put(CORRUNDODILE.get(), CorrundodileEntity.createAttributes().build());
		event.put(CORRUNDUM_SPIKE.get(), CorrundumSpikeEntity.createAttributes().build());
		event.put(GIANT_MOLE.get(), GiantMoleEntity.createAttributes().build());
		event.put(GIANT_BUTTERFLY.get(), GiantButterflyEntity.createAttributes().build());
		event.put(HUMBOLDT.get(), HumboldtEntity.createAttributes().build());
		event.put(MALICIOUS_ROOT.get(), MaliciousRootEntity.createAttributes().build());
		event.put(FAIRY.get(), FairyEntity.createAttributes().build());
		event.put(MOX.get(), MoxEntity.createAttributes().build());
		event.put(TITANIA.get(), TitaniaEntity.createAttributes().build());
	}
}