package com.dreamcritting.ror.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import com.dreamcritting.ror.client.model.*;

@EventBusSubscriber(Dist.CLIENT)
public class RorModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {

		event.registerLayerDefinition(ModelAlex.LAYER_LOCATION, ModelAlex::createBodyLayer);
		event.registerLayerDefinition(ModelBabyNeonResident.LAYER_LOCATION, ModelBabyNeonResident::createBodyLayer);
		event.registerLayerDefinition(ModelCorrundodile.LAYER_LOCATION, ModelCorrundodile::createBodyLayer);
		event.registerLayerDefinition(ModelCorrundoling.LAYER_LOCATION, ModelCorrundoling::createBodyLayer);
		event.registerLayerDefinition(ModelCorrundumGolem.LAYER_LOCATION, ModelCorrundumGolem::createBodyLayer);
		event.registerLayerDefinition(ModelCrystalConstruct.LAYER_LOCATION, ModelCrystalConstruct::createBodyLayer);
		event.registerLayerDefinition(ModelCrystalGolem.LAYER_LOCATION, ModelCrystalGolem::createBodyLayer);
		event.registerLayerDefinition(ModelCrystalStar.LAYER_LOCATION, ModelCrystalStar::createBodyLayer);
		event.registerLayerDefinition(ModelCrystalcopter2.LAYER_LOCATION, ModelCrystalcopter2::createBodyLayer);
		event.registerLayerDefinition(ModelDress.LAYER_LOCATION, ModelDress::createBodyLayer);
		event.registerLayerDefinition(ModelDress2.LAYER_LOCATION, ModelDress2::createBodyLayer);
		event.registerLayerDefinition(ModelDressHead2.LAYER_LOCATION, ModelDressHead2::createBodyLayer);
		event.registerLayerDefinition(ModelFairy.LAYER_LOCATION, ModelFairy::createBodyLayer);
		event.registerLayerDefinition(ModelGiantButterfly.LAYER_LOCATION, ModelGiantButterfly::createBodyLayer);
		event.registerLayerDefinition(ModelGoogloid.LAYER_LOCATION, ModelGoogloid::createBodyLayer);
		event.registerLayerDefinition(ModelGoogloid2.LAYER_LOCATION, ModelGoogloid2::createBodyLayer);
		event.registerLayerDefinition(ModelGoogloid3.LAYER_LOCATION, ModelGoogloid3::createBodyLayer);
		event.registerLayerDefinition(ModelHat.LAYER_LOCATION, ModelHat::createBodyLayer);
		event.registerLayerDefinition(ModelHeavyLaserbot2.LAYER_LOCATION, ModelHeavyLaserbot2::createBodyLayer);
		event.registerLayerDefinition(ModelHumboldt.LAYER_LOCATION, ModelHumboldt::createBodyLayer);
		event.registerLayerDefinition(ModelKillbot.LAYER_LOCATION, ModelKillbot::createBodyLayer);
		event.registerLayerDefinition(ModelLaserbeam.LAYER_LOCATION, ModelLaserbeam::createBodyLayer);
		event.registerLayerDefinition(ModelLaserbeam2.LAYER_LOCATION, ModelLaserbeam2::createBodyLayer);
		event.registerLayerDefinition(ModelLaserbotModel4.LAYER_LOCATION, ModelLaserbotModel4::createBodyLayer);
		event.registerLayerDefinition(ModelMagicProjectile.LAYER_LOCATION, ModelMagicProjectile::createBodyLayer);
		event.registerLayerDefinition(ModelMeatPuddle.LAYER_LOCATION, ModelMeatPuddle::createBodyLayer);
		event.registerLayerDefinition(ModelMole.LAYER_LOCATION, ModelMole::createBodyLayer);
		event.registerLayerDefinition(ModelMoonDungeonGuard.LAYER_LOCATION, ModelMoonDungeonGuard::createBodyLayer);
		event.registerLayerDefinition(ModelMox.LAYER_LOCATION, ModelMox::createBodyLayer);
		event.registerLayerDefinition(ModelMox1.LAYER_LOCATION, ModelMox1::createBodyLayer);
		event.registerLayerDefinition(ModelMox3.LAYER_LOCATION, ModelMox3::createBodyLayer);
		event.registerLayerDefinition(ModelMox4.LAYER_LOCATION, ModelMox4::createBodyLayer);
		event.registerLayerDefinition(ModelMox5.LAYER_LOCATION, ModelMox5::createBodyLayer);
		event.registerLayerDefinition(ModelMox6.LAYER_LOCATION, ModelMox6::createBodyLayer);
		event.registerLayerDefinition(ModelMutantNeonResident.LAYER_LOCATION, ModelMutantNeonResident::createBodyLayer);
		event.registerLayerDefinition(ModelNeonResident.LAYER_LOCATION, ModelNeonResident::createBodyLayer);
		event.registerLayerDefinition(ModelNeonica4.LAYER_LOCATION, ModelNeonica4::createBodyLayer);
		event.registerLayerDefinition(ModelRoRGhost2.LAYER_LOCATION, ModelRoRGhost2::createBodyLayer);
		event.registerLayerDefinition(ModelRobotBoss.LAYER_LOCATION, ModelRobotBoss::createBodyLayer);
		event.registerLayerDefinition(ModelRobotBoss2.LAYER_LOCATION, ModelRobotBoss2::createBodyLayer);
		event.registerLayerDefinition(ModelScanbot.LAYER_LOCATION, ModelScanbot::createBodyLayer);
		event.registerLayerDefinition(ModelSmallRobot.LAYER_LOCATION, ModelSmallRobot::createBodyLayer);
		event.registerLayerDefinition(ModelSmallSnail.LAYER_LOCATION, ModelSmallSnail::createBodyLayer);
		event.registerLayerDefinition(ModelSpike.LAYER_LOCATION, ModelSpike::createBodyLayer);
		event.registerLayerDefinition(ModelStreetlight.LAYER_LOCATION, ModelStreetlight::createBodyLayer);
		event.registerLayerDefinition(ModelTitania.LAYER_LOCATION, ModelTitania::createBodyLayer);
		event.registerLayerDefinition(ModelUndercopter.LAYER_LOCATION, ModelUndercopter::createBodyLayer);
		event.registerLayerDefinition(Modelgnome.LAYER_LOCATION, Modelgnome::createBodyLayer);
		event.registerLayerDefinition(Modelplayer.LAYER_LOCATION, Modelplayer::createBodyLayer);
		event.registerLayerDefinition(Modelrainboom3.LAYER_LOCATION, Modelrainboom3::createBodyLayer);
		event.registerLayerDefinition(ModelMaliciousRoot.LAYER_LOCATION, ModelMaliciousRoot::createBodyLayer);}
}