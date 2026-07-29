package com.dreamcritting.ror.item;

import com.dreamcritting.ror.init.RorModItems;
import com.dreamcritting.ror.special.MagicItemCooldown;
import com.dreamcritting.ror.special.RuneUsingMagicItemUseCondition;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
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

import java.util.List;

public class LevitationSpellItem extends Item {
	public LevitationSpellItem() {
		super(new Item.Properties().durability(128).rarity(Rarity.UNCOMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable(this.getDescriptionId() + ".desc").withStyle(ChatFormatting.GRAY));
		list.add(Component.translatable("item.ror.ammunition.runes").withStyle(ChatFormatting.DARK_GREEN));
		list.add(Component.translatable("stat.ror.speed.0.05").withStyle(ChatFormatting.DARK_GREEN));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		ItemStack itemstack = ar.getObject();
		if (RuneUsingMagicItemUseCondition.execute(entity)) {
            if (!entity.level().isClientSide())
				entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 60, 4));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:levitation_spell")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ror:levitation_spell")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			MagicItemCooldown.execute(world, entity, new ItemStack(RorModItems.RUNE.get()), itemstack, 400);
		}
		return ar;
	}
}