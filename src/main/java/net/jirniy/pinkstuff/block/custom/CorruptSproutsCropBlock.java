package net.jirniy.pinkstuff.block.custom;

import net.jirniy.pinkstuff.item.ModItems;
import net.jirniy.pinkstuff.util.ModTags;
import net.minecraft.block.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class CorruptSproutsCropBlock extends CropBlock {
    public static final int MAX_AGE = 8;
    public static final IntProperty AGE = IntProperty.of("age", 0, 8);
    private static final VoxelShape[] SHAPES_BY_AGE = Block.createShapeArray(9, (age) ->
            switch (age) {
                case 0 -> Block.createColumnShape(16f, 0f, 2f);
                case 1 -> Block.createColumnShape(16f, 0f, 4f);
                case 2 -> Block.createColumnShape(16f, 0f, 6f);
                case 3 -> Block.createColumnShape(16f, 0f, 8f);
                case 4 -> Block.createColumnShape(16f, 0f, 10f);
                case 5 -> Block.createColumnShape(16f, 0f, 12f);
                case 6, 7, 8 -> Block.createColumnShape(16f, 0f, 14f);
                default -> Block.createColumnShape(16f, 0f, 16f);
            });

    public CorruptSproutsCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(Blocks.FARMLAND) || floor.isIn(ModTags.Blocks.CORRUPT_BLOCKS);
    }

    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPES_BY_AGE[this.getAge(state)];
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.CORRUPT_SPROUTS;
    }

    @Override
    public IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
