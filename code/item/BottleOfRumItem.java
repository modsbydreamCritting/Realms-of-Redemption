package com.dreamcritting.ror.item;

import com.dreamcritting.ror.init.RorModMobEffects;
import net.minecraft.ChatFormatting;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.network.chat.Component;

import java.util.List;

public class BottleOfRumItem extends Item {
	public BottleOfRumItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(0).saturationModifier(0f).alwaysEdible().build()));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.DRINK;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable(this.getDescriptionId() + ".desc").withStyle(ChatFormatting.GRAY));
		list.add(Component.translatable(this.getDescriptionId() + ".desc2").withStyle(ChatFormatting.BLUE));
		list.add(Component.translatable(this.getDescriptionId() + ".desc3").withStyle(ChatFormatting.RED));
		list.add(Component.translatable(this.getDescriptionId() + ".desc4").withStyle(ChatFormatting.RED));
		list.add(Component.translatable(this.getDescriptionId() + ".desc5").withStyle(ChatFormatting.RED));
		list.add(Component.literal(""));
		list.add(Component.translatable("potion.whenDrank").withStyle(ChatFormatting.DARK_PURPLE));
		list.add(Component.translatable(this.getDescriptionId() + ".desc6").withStyle(ChatFormatting.BLUE));
	}
	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = new ItemStack(Items.GLASS_BOTTLE);
		super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		if (entity.hasEffect(RorModMobEffects.BRAVERY)) {
			if (!entity.level().isClientSide())
				entity.addEffect(new MobEffectInstance(RorModMobEffects.BRAVERY, 7200, (entity.hasEffect(RorModMobEffects.BRAVERY) ? entity.getEffect(RorModMobEffects.BRAVERY).getAmplifier() : 0) + 1, false, false));
		} else {
			if (!entity.level().isClientSide())
				entity.addEffect(new MobEffectInstance(RorModMobEffects.BRAVERY, 7200, 0, false, false));
		}
		if (!entity.level().isClientSide())
			entity.addEffect(new MobEffectInstance(RorModMobEffects.CLUMSYNESS, 7200, 1, false, false));
			entity.addEffect(new MobEffectInstance(RorModMobEffects.CLUMSYNESS, 7200, (entity.hasEffect(RorModMobEffects.CLUMSYNESS) ? entity.getEffect(RorModMobEffects.CLUMSYNESS).getAmplifier() : 0) + 1, false, false));
			entity.addEffect(new MobEffectInstance(RorModMobEffects.MANA_DRAIN, 7200, 0, false, false));
			entity.addEffect(new MobEffectInstance(RorModMobEffects.MANA_DRAIN, 7200, (entity.hasEffect(RorModMobEffects.MANA_DRAIN) ? entity.getEffect(RorModMobEffects.MANA_DRAIN).getAmplifier() : 0) + 1, false, false));
		if (entity.hasEffect(RorModMobEffects.ALCHOHOL)) {
			if (!entity.level().isClientSide())
				entity.addEffect(new MobEffectInstance(RorModMobEffects.ALCHOHOL, 7200, (entity.hasEffect(RorModMobEffects.ALCHOHOL) ? entity.getEffect(RorModMobEffects.ALCHOHOL).getAmplifier() : 0) + 1,
						false, false));
		} else {
			if (!entity.level().isClientSide())
				entity.addEffect(new MobEffectInstance(RorModMobEffects.ALCHOHOL, 7200, 0, false, false));
		}
		if ((entity.hasEffect(RorModMobEffects.ALCHOHOL) ? entity.getEffect(RorModMobEffects.ALCHOHOL).getAmplifier() : 0) >= 3) {
			if ((entity.hasEffect(RorModMobEffects.ALCHOHOL) ? entity.getEffect(RorModMobEffects.ALCHOHOL).getAmplifier() : 0) < 6) {
				if (!entity.level().isClientSide())
					entity.addEffect(new MobEffectInstance(MobEffects.POISON, (entity.hasEffect(RorModMobEffects.ALCHOHOL) ? entity.getEffect(RorModMobEffects.ALCHOHOL).getAmplifier() : 0) * 180,
							(entity.hasEffect(RorModMobEffects.ALCHOHOL) ? entity.getEffect(RorModMobEffects.ALCHOHOL).getAmplifier() : 0) - 3, false, false));
			} else {
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), (entity.hasEffect(RorModMobEffects.ALCHOHOL) ? entity.getEffect(RorModMobEffects.ALCHOHOL).getAmplifier() : 0) - 2);
			}
		}
			if (itemstack.isEmpty()) {
			return retval;
		} else {
			if (entity instanceof Player player && !player.getAbilities().instabuild) {
				if (!player.getInventory().add(retval))
					player.drop(retval, false);
			}
			return itemstack;
		}
	}
}