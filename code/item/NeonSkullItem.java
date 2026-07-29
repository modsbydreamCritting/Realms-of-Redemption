package com.dreamcritting.ror.item;

import com.dreamcritting.ror.init.RorModBlocks;
import com.dreamcritting.ror.init.RorModEntities;
import com.dreamcritting.ror.special.GreenChatSender;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;
import net.minecraft.network.chat.Component;

public class NeonSkullItem extends DescriptableItem {
	public NeonSkullItem() {
		super(new Item.Properties().rarity(Rarity.UNCOMMON));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		Level world = context.getLevel();
		double x = context.getClickedPos().getX();
		double y = context.getClickedPos().getY();
		double z = context.getClickedPos().getZ();
	    Entity entity = context.getPlayer();
		ItemStack itemstack = context.getItemInHand();
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == RorModBlocks.NEON_ALTAR.get() && !world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude() && !world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude()
				&& !world.getBlockState(BlockPos.containing(x, y + 3, z)).canOcclude()) {
			itemstack.shrink(1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.portal.travel")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.portal.travel")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level) {
				RorModEntities.NEONICA.get().spawn(_level, BlockPos.containing(x + 0.05, y + 1, z + 0.05), MobSpawnType.MOB_SUMMONED);
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"fill ~-2 ~ ~-2 ~2 ~5 ~2 ror:force_field hollow"); //faster to code this was ik it's odd
			GreenChatSender.execute(entity, "entity.ror.neonica.phase_1_start");
			world.setBlock(BlockPos.containing(x, y, z), RorModBlocks.NEON_ALTAR.get().defaultBlockState(), 3);
		}
		return InteractionResult.SUCCESS;
	}
}