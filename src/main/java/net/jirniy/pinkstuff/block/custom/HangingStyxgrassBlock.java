package net.jirniy.pinkstuff.block.custom;

import net.jirniy.pinkstuff.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.HangingMossBlock;
import net.minecraft.block.MultifaceBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class HangingStyxgrassBlock extends HangingMossBlock {
    public HangingStyxgrassBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!this.canPlaceAt(world, pos)) {
            world.breakBlock(pos, true);
        }
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return this.canPlaceAt(world, pos);
    }

    private boolean canPlaceAt(BlockView world, BlockPos pos) {
        BlockState blockState;
        BlockPos blockPos = pos.offset(Direction.UP);
        return MultifaceBlock.canGrowOn(world, Direction.UP, blockPos, blockState = world.getBlockState(blockPos)) || blockState.isOf(ModBlocks.HANGING_STYXGRASS);
    }
}