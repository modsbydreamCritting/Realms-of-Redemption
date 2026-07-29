package com.dreamcritting.ror.init;

import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import com.dreamcritting.ror.client.particle.*;

@EventBusSubscriber(Dist.CLIENT)
public class RorModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(RorModParticleTypes.MAGIC_GEARS.get(), MagicGearsParticle::provider);
		event.registerSpriteSet(RorModParticleTypes.MAGIC_FIREBALL.get(), MagicFireballParticle::provider);
		event.registerSpriteSet(RorModParticleTypes.RAINBOW.get(), RainbowParticle::provider);
		event.registerSpriteSet(RorModParticleTypes.RAINBOW_MAGIC.get(), RainbowMagicParticle::provider);
		event.registerSpriteSet(RorModParticleTypes.MAGIC_STARS.get(), MagicStarsParticle::provider);
		event.registerSpriteSet(RorModParticleTypes.SCAN.get(), ScanParticle::provider);
		event.registerSpriteSet(RorModParticleTypes.RED_LASER.get(), RedLaserParticle::provider);
		event.registerSpriteSet(RorModParticleTypes.TITANIA_SHIELD.get(), TitaniaShieldParticle::provider);
	}
}