package com.dreamcritting.ror.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.ai.attributes.DefaultAttributes;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.core.registries.BuiltInRegistries;

import java.util.stream.Collectors;
import java.util.List;

import com.dreamcritting.ror.RorMod;

@EventBusSubscriber
public class RorModAttributes {
	public static final DeferredRegister<Attribute> REGISTRY = DeferredRegister.create(BuiltInRegistries.ATTRIBUTE, RorMod.MODID);
	public static final DeferredHolder<Attribute, Attribute> MAGICAL_POWER = REGISTRY.register("magical_power", () -> new RangedAttribute("attribute.ror.magical_power", 1d, -1024d, 1024d).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> MUSICAL_POWER = REGISTRY.register("musical_power", () -> new RangedAttribute("attribute.ror.musical_power", 1d, -1024d, 1024d).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> STEALTH = REGISTRY.register("stealth", () -> new RangedAttribute("attribute.ror.stealth", 1d, 0d, 1024d).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> DIFFICULTY_MODIFIER = REGISTRY.register("difficulty_modifier", () -> new RangedAttribute("attribute.ror.difficulty_modifier", 1d, 0d, 255d).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> FEAR_RESISTANCE = REGISTRY.register("fear_resistance", () -> new RangedAttribute("attribute.ror.fear_resistance", 0d, -1024d, 1024d).setSyncable(true));

	@SubscribeEvent
	public static void addAttributes(EntityAttributeModificationEvent event) {
		event.add(EntityType.PLAYER, MAGICAL_POWER);
		event.add(EntityType.PLAYER, MUSICAL_POWER);
		event.add(EntityType.PLAYER, STEALTH);
		List.of(RorModEntities.TITANIA.get(), RorModEntities.MOX.get()).stream().filter(DefaultAttributes::hasSupplier).map(entityType -> (EntityType<? extends LivingEntity>) entityType).collect(Collectors.toList())
				.forEach(entity -> event.add(entity, DIFFICULTY_MODIFIER));
		event.add(EntityType.PLAYER, FEAR_RESISTANCE);
	}
}