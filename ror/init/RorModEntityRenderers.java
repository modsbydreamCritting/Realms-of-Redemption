package com.dreamcritting.ror.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import com.dreamcritting.ror.client.renderer.*;

@EventBusSubscriber(Dist.CLIENT)
public class RorModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(RorModEntities.ALLIED_GHOST.get(), AlliedGhostRenderer::new);
		event.registerEntityRenderer(RorModEntities.BABY_NEON_RESIDENT.get(), BabyNeonResidentRenderer::new);
		event.registerEntityRenderer(RorModEntities.BLUE_CRYSTAL_CONSTRUCT.get(), BlueCrystalConstructRenderer::new);
		event.registerEntityRenderer(RorModEntities.BLUE_CRYSTAL_GOLEM.get(), BlueCrystalGolemRenderer::new);
		event.registerEntityRenderer(RorModEntities.BLUE_CRYSTAL_STAR.get(), BlueCrystalStarRenderer::new);
		event.registerEntityRenderer(RorModEntities.CORRUNDODILE.get(), CorrundodileRenderer::new);
		event.registerEntityRenderer(RorModEntities.CORRUNDOLING.get(), CorrundolingRenderer::new);
		event.registerEntityRenderer(RorModEntities.CORRUNDUM_GOLEM.get(), CorrundumGolemRenderer::new);
		event.registerEntityRenderer(RorModEntities.CORRUNDUM_SPIKE.get(), CorrundumSpikeRenderer::new);
		event.registerEntityRenderer(RorModEntities.COWBOT.get(), CowbotRenderer::new);
		event.registerEntityRenderer(RorModEntities.CRYSTALCOPTER.get(), CrystalcopterRenderer::new);
		event.registerEntityRenderer(RorModEntities.DEVOURER_WAND_PROJECTILE.get(), DevourerWandProjectileRenderer::new);
		event.registerEntityRenderer(RorModEntities.FAIRY.get(), FairyRenderer::new);
		event.registerEntityRenderer(RorModEntities.FAIRY_WAND_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(RorModEntities.GHOST.get(), GhostRenderer::new);
		event.registerEntityRenderer(RorModEntities.GHOST_ANGEL.get(), GhostAngelRenderer::new);
		event.registerEntityRenderer(RorModEntities.GIANT_BUTTERFLY.get(), GiantButterflyRenderer::new);
		event.registerEntityRenderer(RorModEntities.GIANT_MOLE.get(), GiantMoleRenderer::new);
		event.registerEntityRenderer(RorModEntities.GNOME.get(), GnomeRenderer::new);
		event.registerEntityRenderer(RorModEntities.GOLD_CONSTRUCT.get(), GoldConstructRenderer::new);
		event.registerEntityRenderer(RorModEntities.GOLD_SCANBOT.get(), GoldScanbotRenderer::new);
		event.registerEntityRenderer(RorModEntities.GOLD_UNDEAD_NEON_RESIDENT.get(), GoldUndeadNeonResidentRenderer::new);
		event.registerEntityRenderer(RorModEntities.GOOGLOID.get(), GoogloidRenderer::new);
		event.registerEntityRenderer(RorModEntities.GOOGLOID_GHOST.get(), GoogloidGhostRenderer::new);
		event.registerEntityRenderer(RorModEntities.GREEN_CRYSTAL_CONSTRUCT.get(), GreenCrystalConstructRenderer::new);
		event.registerEntityRenderer(RorModEntities.GREEN_CRYSTAL_GOLEM.get(), GreenCrystalGolemRenderer::new);
		event.registerEntityRenderer(RorModEntities.GREEN_CRYSTAL_STAR.get(), GreenCrystalStarRenderer::new);
		event.registerEntityRenderer(RorModEntities.GUARDBOT.get(), GuardbotRenderer::new);
		event.registerEntityRenderer(RorModEntities.HEAVY_LASERBOT.get(), HeavyLaserbotRenderer::new);
		event.registerEntityRenderer(RorModEntities.HUMBOLDT.get(), HumboldtRenderer::new);
		event.registerEntityRenderer(RorModEntities.JAW_WAND_PROJECTILE.get(), JawWandProjectileRenderer::new);
		event.registerEntityRenderer(RorModEntities.KILLBOT.get(), KillbotRenderer::new);
		event.registerEntityRenderer(RorModEntities.LASERBEAM.get(), LaserbeamRenderer::new);
		event.registerEntityRenderer(RorModEntities.LASERBOT.get(), LaserbotRenderer::new);
		event.registerEntityRenderer(RorModEntities.LASER_BLAST.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(RorModEntities.LIGHT_BLUE_CRYSTAL_CONSTRUCT.get(), LightBlueCrystalConstructRenderer::new);
		event.registerEntityRenderer(RorModEntities.LIGHT_BLUE_CRYSTAL_GOLEM.get(), LightBlueCrystalGolemRenderer::new);
		event.registerEntityRenderer(RorModEntities.LIGHT_BLUE_CRYSTAL_STAR.get(), LightBlueCrystalStarRenderer::new);
		event.registerEntityRenderer(RorModEntities.MALICIOUS_ROOT.get(), MaliciousRootRenderer::new);
		event.registerEntityRenderer(RorModEntities.MEAT_PUDDLE.get(), MeatPuddleRenderer::new);
		event.registerEntityRenderer(RorModEntities.MECHANICAL_WAND_PROJECTILE.get(), MechanicalWandProjectileRenderer::new);
		event.registerEntityRenderer(RorModEntities.MOON_DUNGEON_GUARD.get(), MoonDungeonGuardRenderer::new);
		event.registerEntityRenderer(RorModEntities.MOX.get(), MoxRenderer::new);
		event.registerEntityRenderer(RorModEntities.MUTANT_NEON_RESIDENT.get(), MutantNeonResidentRenderer::new);
		event.registerEntityRenderer(RorModEntities.NEONICA.get(), NeonicaRenderer::new);
		event.registerEntityRenderer(RorModEntities.NEON_RESIDENT.get(), NeonResidentRenderer::new);
		event.registerEntityRenderer(RorModEntities.NEON_VORTEX.get(), NeonVortexRenderer::new);
		event.registerEntityRenderer(RorModEntities.PLACER.get(), PlacerRenderer::new);
		event.registerEntityRenderer(RorModEntities.PRISMKEEPER.get(), PrismkeeperRenderer::new);
		event.registerEntityRenderer(RorModEntities.RAINBOOM.get(), RainboomRenderer::new);
		event.registerEntityRenderer(RorModEntities.RAINBOW_WAND_PROJECTILE.get(), RainbowWandProjectileRenderer::new);
		event.registerEntityRenderer(RorModEntities.RED_CRYSTAL_CONSTRUCT.get(), RedCrystalConstructRenderer::new);
		event.registerEntityRenderer(RorModEntities.RED_CRYSTAL_GOLEM.get(), RedCrystalGolemRenderer::new);
		event.registerEntityRenderer(RorModEntities.RED_CRYSTAL_STAR.get(), RedCrystalStarRenderer::new);
		event.registerEntityRenderer(RorModEntities.SCANBOT.get(), ScanbotRenderer::new);
		event.registerEntityRenderer(RorModEntities.SMALL_ROBOT.get(), SmallRobotRenderer::new);
		event.registerEntityRenderer(RorModEntities.SMALL_SNAIL.get(), SmallSnailRenderer::new);
		event.registerEntityRenderer(RorModEntities.SPAWNER_PLACER.get(), SpawnerPlacerRenderer::new);
		event.registerEntityRenderer(RorModEntities.SPAWN_FLUFFER.get(), SpawnFlufferRenderer::new);
		event.registerEntityRenderer(RorModEntities.STREETLIGHT.get(), StreetlightRenderer::new);
		event.registerEntityRenderer(RorModEntities.SWARM_SPIDER.get(), SwarmSpiderRenderer::new);
		event.registerEntityRenderer(RorModEntities.TEMPLE.get(), TempleRenderer::new);
		event.registerEntityRenderer(RorModEntities.THROWN_GALACTIC_SHURIKEN.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(RorModEntities.THROWN_MAGNOLITE_SHURIKEN.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(RorModEntities.THROWN_PRISMITE_SHURIKEN.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(RorModEntities.THROWN_TOURMALINE_SHURIKEN.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(RorModEntities.THROWN_TSAVORITE_SHURIKEN.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(RorModEntities.TITANIA.get(), TitaniaRenderer::new);
		event.registerEntityRenderer(RorModEntities.UNDEAD_NEON_RESIDENT.get(), UndeadNeonResidentRenderer::new);
		event.registerEntityRenderer(RorModEntities.UNDERCOPTER.get(), UndercopterRenderer::new);
		event.registerEntityRenderer(RorModEntities.YELLOW_CRYSTAL_CONSTRUCT.get(), YellowCrystalConstructRenderer::new);
		event.registerEntityRenderer(RorModEntities.YELLOW_CRYSTAL_GOLEM.get(), YellowCrystalGolemRenderer::new);
		event.registerEntityRenderer(RorModEntities.YELLOW_CRYSTAL_STAR.get(), YellowCrystalStarRenderer::new);
		event.registerEntityRenderer(RorModEntities.LASER.get(), ThrownItemRenderer::new);
	}
}