package net.jirniy.pinkstuff.item.custom;

import net.jirniy.pinkstuff.util.ModTags;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BreakerItem extends Item {
    public BreakerItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        BlockPos pos = context.getBlockPos();
        World world = context.getWorld();
        if (world.getBlockState(pos).isIn(ModTags.Blocks.BREAKER_BREAKABLE)) {
            context.getStack().decrementUnlessCreative(1, player);
            world.addBlockBreakParticles(pos, world.getBlockState(pos));
            world.playSoundClient(SoundEvents.BLOCK_ANVIL_LAND, SoundCategory.BLOCKS, 1, 1);
            world.setBlockState(pos, Blocks.AIR.getDefaultState());
        }
        return super.useOnBlock(context);
    }
}
