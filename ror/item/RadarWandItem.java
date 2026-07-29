package com.dreamcritting.ror.item;

import com.dreamcritting.ror.init.RorModItems;
import com.dreamcritting.ror.special.LiteralInfoChatSender;
import com.dreamcritting.ror.special.MagicItemCooldown;
import com.dreamcritting.ror.special.RuneUsingMagicItemUseCondition;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import java.util.Comparator;
import java.util.List;

public class RadarWandItem extends Item {
	public RadarWandItem() {
		super(new Item.Properties().durability(72).rarity(Rarity.UNCOMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable(this.getDescriptionId() + ".desc").withStyle(ChatFormatting.GRAY));
		list.add(Component.translatable("item.ror.ammunition.runes").withStyle(ChatFormatting.DARK_GREEN));
		list.add(Component.translatable("stat.ror.speed.0.25").withStyle(ChatFormatting.DARK_GREEN));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		ItemStack itemstack = ar.getObject();
		Entity nearest_mob;
		if (RuneUsingMagicItemUseCondition.execute(entity)) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:radar_wand_used")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:radar_wand_used")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			if (!((findEntityInWorldRange(world, Monster.class, x, y, z, 16)) == null)) {
				nearest_mob = findEntityInWorldRange(world, Monster.class, x, y, z, 16);
				if (!nearest_mob.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("ror:undetectable")))) {
					LiteralInfoChatSender.execute(entity, Component.translatable("item.ror.radar_wand.nearest_mob").getString() + " " + nearest_mob.getDisplayName().getString());
				} else {
					LiteralInfoChatSender.execute(entity, Component.translatable("item.ror.radar_wand.no_mobs_nearby").getString());
				}
			} else {
				LiteralInfoChatSender.execute(entity, Component.translatable("item.ror.radar_wand.no_mobs_nearby").getString());
			}
			MagicItemCooldown.execute(world, entity, new ItemStack(RorModItems.RUNE.get()), itemstack, 80);
		}
		return ar;
	}
	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}