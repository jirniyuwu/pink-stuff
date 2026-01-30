package net.jirniy.pinkstuff.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.MultifaceBlock;
import net.minecraft.block.PillarBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;

public class SappyLogBlock extends PillarBlock {
    private final MultifaceBlock sap;
    private final float sapChance;

    public SappyLogBlock(float chance, MultifaceBlock sap, Settings settings) {
        super(settings);
        this.sapChance = chance;
        this.sap = sap;
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (state.get(PillarBlock.AXIS) == Direction.Axis.X) {
            if (world.isAir(pos.up()) && random.nextFloat() < sapChance) {
                world.setBlockState(pos.up(), sap.withDirection(sap.getDefaultState(), world, pos.up(), Direction.DOWN));
            }
            if (world.isAir(pos.down()) && random.nextFloat() < sapChance) {
                world.setBlockState(pos.down(), sap.withDirection(sap.getDefaultState(), world, pos.down(), Direction.UP));
            }
            if (world.isAir(pos.north()) && random.nextFloat() < sapChance) {
                world.setBlockState(pos.north(), sap.withDirection(sap.getDefaultState(), world, pos.north(), Direction.SOUTH));
            }
            if (world.isAir(pos.south()) && random.nextFloat() < sapChance) {
                world.setBlockState(pos.south(), sap.withDirection(sap.getDefaultState(), world, pos.south(), Direction.NORTH));
            }
        }
        if (state.get(PillarBlock.AXIS) == Direction.Axis.Y) {
            if (world.isAir(pos.west()) && random.nextFloat() < sapChance) {
                world.setBlockState(pos.west(), sap.withDirection(sap.getDefaultState(), world, pos.west(), Direction.EAST));
            }
            if (world.isAir(pos.east()) && random.nextFloat() < sapChance) {
                world.setBlockState(pos.east(), sap.withDirection(sap.getDefaultState(), world, pos.east(), Direction.WEST));
            }
            if (world.isAir(pos.north()) && random.nextFloat() < sapChance) {
                world.setBlockState(pos.north(), sap.withDirection(sap.getDefaultState(), world, pos.north(), Direction.SOUTH));
            }
            if (world.isAir(pos.south()) && random.nextFloat() < sapChance) {
                world.setBlockState(pos.south(), sap.withDirection(sap.getDefaultState(), world, pos.south(), Direction.NORTH));
            }
        }
        if (state.get(PillarBlock.AXIS) == Direction.Axis.Z) {
            if (world.isAir(pos.up()) && random.nextFloat() < sapChance) {
                world.setBlockState(pos.up(), sap.withDirection(sap.getDefaultState(), world, pos.up(), Direction.DOWN));
            }
            if (world.isAir(pos.down()) && random.nextFloat() < sapChance) {
                world.setBlockState(pos.down(), sap.withDirection(sap.getDefaultState(), world, pos.down(), Direction.UP));
            }
            if (world.isAir(pos.west()) && random.nextFloat() < sapChance) {
                world.setBlockState(pos.west(), sap.withDirection(sap.getDefaultState(), world, pos.west(), Direction.EAST));
            }
            if (world.isAir(pos.east()) && random.nextFloat() < sapChance) {
                world.setBlockState(pos.east(), sap.withDirection(sap.getDefaultState(), world, pos.east(), Direction.WEST));
            }
        }
        super.randomTick(state, world, pos, random);
    }
}
