package net.jirniy.pinkstuff.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class ModGrassBlock extends FlowerBlock {
    private final VoxelShape SHAPE;
    private final Block blockToPlaceOn;

    public ModGrassBlock(Block block, Settings settings, int minX, int minZ, int maxX, int maxY, int maxZ) {
        super(StatusEffects.DARKNESS, 0, settings);
        this.SHAPE = Block.createCuboidShape(minX, 0, minZ, maxX, maxY, maxZ);
        this.blockToPlaceOn = block;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(this.blockToPlaceOn);
    }
}