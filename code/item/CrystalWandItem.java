package com.dreamcritting.ror.item;

import com.dreamcritting.ror.init.RorModItems;
import com.dreamcritting.ror.special.MagicItemCooldown;
import com.dreamcritting.ror.special.RuneUsingMagicItemUseCondition;
import net.minecraft.ChatFormatting;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import java.util.List;

public class CrystalWandItem extends Item {
	public CrystalWandItem() {
		super(new Item.Properties().durability(256));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.BOW;
	}

	@Override
	public int getUseDuration(ItemStack itemstack, LivingEntity livingEntity) {
		return 72000;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
			list.add(Component.translatable("item.ror.ammunition.runes").withStyle(ChatFormatting.DARK_GREEN));
			list.add(Component.translatable("stat.ror.speed.2").withStyle(ChatFormatting.DARK_GREEN));
			list.add(Component.translatable(this.getDescriptionId() + ".desc").withStyle(ChatFormatting.GRAY));
		}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		entity.startUsingItem(hand);
		ItemStack itemstack = ar.getObject();
        if (RuneUsingMagicItemUseCondition.execute(entity)) {
            if (!entity.level().isClientSide())
				entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 240, 2, false, false));
			MagicItemCooldown.execute(world, entity, new ItemStack(RorModItems.RUNE.get()), itemstack, 60);
		}
		return ar;
	}
}