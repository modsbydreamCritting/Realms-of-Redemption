package com.dreamcritting.ror.item;

import com.dreamcritting.ror.init.RorModItems;
import com.dreamcritting.ror.special.LiteralInfoChatSender;
import com.dreamcritting.ror.special.MagicItemCooldown;
import com.dreamcritting.ror.special.RuneUsingMagicItemUseCondition;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import java.util.List;

public class MoleWandItem extends Item {
	public MoleWandItem() {
		super(new Item.Properties().durability(64));
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
		double sx ;
		double sy;
		double sz;
		double ores;
		if (RuneUsingMagicItemUseCondition.execute(entity)) {
			MagicItemCooldown.execute(world, entity, new ItemStack(RorModItems.RUNE.get()), itemstack, 80);
			sx = -4;
			ores = 0;
			for (int index201 = 0; index201 < 8; index201++) {
				sy = -4;
				for (int index202 = 0; index202 < 8; index202++) {
					sz = -4;
					for (int index203 = 0; index203 < 8; index203++) {
						if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("c:ores")))) {
							ores = ores + 1;
						}
						sz = sz + 1;
					}
					sy = sy + 1;
				}
				sx = sx + 1;
			}
			LiteralInfoChatSender.execute(entity, Component.translatable("item.ror.mole_wand.nearby_ore").getString() + " " + Math.round(ores));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.cast_spell")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
		}
		return ar;
	}
}