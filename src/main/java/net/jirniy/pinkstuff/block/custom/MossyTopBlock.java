package net.jirniy.pinkstuff.block.custom;

import net.jirniy.pinkstuff.util.ModDamageTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.block.WireOrientation;
import org.jspecify.annotations.Nullable;

public class MossyTopBlock extends Block {
    private static BlockState toReplaceWith;

    public MossyTopBlock(BlockState replace, Settings settings) {
        super(settings);
        toReplaceWith = replace;
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        super.randomTick(state, world, pos, random);
        if (world.getBlockState(pos.up()).isSideSolidFullSquare(world, pos.up(), Direction.DOWN)) {
            world.setBlockState(pos, toReplaceWith);
        } else {
            if (world.getBlockState(pos.east()).isOf(toReplaceWith.getBlock()) && random.nextFloat() <= 0.1
                    && !world.getBlockState(pos.east().up()).isSideSolidFullSquare(world, pos.east().up(), Direction.DOWN)) {
                world.setBlockState(pos.east(), this.getDefaultState());
            }
            if (world.getBlockState(pos.north()).isOf(toReplaceWith.getBlock()) && random.nextFloat() <= 0.1
                    && !world.getBlockState(pos.north().up()).isSideSolidFullSquare(world, pos.north().up(), Direction.DOWN)) {
                world.setBlockState(pos.north(), this.getDefaultState());
            }
            if (world.getBlockState(pos.south()).isOf(toReplaceWith.getBlock()) && random.nextFloat() <= 0.1
                    && !world.getBlockState(pos.south().up()).isSideSolidFullSquare(world, pos.south().up(), Direction.DOWN)) {
                world.setBlockState(pos.south(), this.getDefaultState());
            }
            if (world.getBlockState(pos.west()).isOf(toReplaceWith.getBlock()) && random.nextFloat() <= 0.1
                    && !world.getBlockState(pos.west().up()).isSideSolidFullSquare(world, pos.west().up(), Direction.DOWN)) {
                world.setBlockState(pos.west(), this.getDefaultState());
            }
        }
    }
}
