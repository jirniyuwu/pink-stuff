package net.jirniy.pinkstuff.block.custom;

import net.jirniy.pinkstuff.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SapBlock extends ModMultifaceBlock {
    private final ItemConvertible bottle;

    public SapBlock(ItemConvertible bottle, Settings settings) {
        super(settings);
        this.bottle = bottle;
    }

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (player.canModifyBlocks() && stack.isOf(Items.GLASS_BOTTLE)) {
            if (stack.getCount() > 1) {
                ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.MAPLE_SYRUP_BOTTLE, 1));
            } else {
                stack.decrementUnlessCreative(1, player);
                player.getInventory().insertStack(player.getInventory().getSelectedSlot(), new ItemStack(ModItems.MAPLE_SYRUP_BOTTLE, 1));
            }
            world.removeBlock(pos, false);
            world.playSound(player, pos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS);
            return ActionResult.SUCCESS;
        }
        return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
    }
}
