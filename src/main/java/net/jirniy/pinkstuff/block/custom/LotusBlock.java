package net.jirniy.pinkstuff.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.AbstractBoatEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.block.WireOrientation;
import net.minecraft.world.event.GameEvent;
import org.jspecify.annotations.Nullable;

public class LotusBlock extends FlowerBlock {
    public static final BooleanProperty PAD = BooleanProperty.of("pad");
    private static final VoxelShape SHAPE = Block.createColumnShape((double)12.0F, (double)0.0F, (double)3F);

    public LotusBlock(RegistryEntry<StatusEffect> stewEffect, float effectLengthInSeconds, Settings settings) {
        super(stewEffect, effectLengthInSeconds, settings);
        setDefaultState(getDefaultState().with(PAD, true));
    }

    @Override
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, @Nullable WireOrientation wireOrientation, boolean notify) {
        BlockState floor = world.getBlockState(pos.down());
        if (floor.isSideSolidFullSquare(world, pos.down(), Direction.UP)) {
            world.setBlockState(pos, state.with(PAD, false));
        } else if (floor.isOf(Blocks.WATER) || floor.get(Properties.WATERLOGGED, false)) {
            world.setBlockState(pos, state.with(PAD, true));
        }
        super.neighborUpdate(state, world, pos, sourceBlock, wireOrientation, notify);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        BlockState floor = world.getBlockState(pos.down());
        if (floor.isSideSolidFullSquare(world, pos.down(), Direction.UP)) {
            world.setBlockState(pos, state.with(PAD, false));
        } else if (floor.isOf(Blocks.WATER) || floor.get(Properties.WATERLOGGED, false)) {
            world.setBlockState(pos, state.with(PAD, true));
        }
        super.onPlaced(world, pos, state, placer, itemStack);
    }

    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, EntityCollisionHandler handler, boolean bl) {
        super.onEntityCollision(state, world, pos, entity, handler, bl);
        if (world instanceof ServerWorld && entity instanceof AbstractBoatEntity) {
            world.breakBlock(new BlockPos(pos), true, entity);
        }
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        FluidState fluidState = world.getFluidState(pos);
        FluidState fluidState2 = world.getFluidState(pos.up());
        return (floor.isSideSolidFullSquare(world, pos, Direction.UP) || floor.get(Properties.WATERLOGGED, false) ||
                fluidState.getFluid() == Fluids.WATER) && fluidState2.getFluid() == Fluids.EMPTY;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(PAD);
        super.appendProperties(builder);
    }
}
