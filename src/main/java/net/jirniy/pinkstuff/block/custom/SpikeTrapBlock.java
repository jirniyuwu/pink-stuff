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
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.block.WireOrientation;
import org.jspecify.annotations.Nullable;

public class SpikeTrapBlock extends Block {
    public static final BooleanProperty ACTIVE = BooleanProperty.of("active");
    private static final VoxelShape COLLISION_SHAPE = Block.createColumnShape((double)16.0F, (double)0.0F, (double)15.9F);

    public SpikeTrapBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(ACTIVE, false));
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        if (world.getReceivedRedstonePower(pos) > 0) {
            world.setBlockState(pos, state.with(ACTIVE, true));
            world.playSound(null, pos, SoundEvent.of(SoundEvents.ITEM_SPEAR_ATTACK.value().id()), SoundCategory.BLOCKS);
        }
    }

    @Override
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, @Nullable WireOrientation wireOrientation, boolean notify) {
        super.neighborUpdate(state, world, pos, sourceBlock, wireOrientation, notify);
        if (world.getReceivedRedstonePower(pos) > 0) {
            if (!state.get(ACTIVE)) {
                world.playSound(null, pos, SoundEvent.of(SoundEvents.ITEM_SPEAR_ATTACK.value().id()), SoundCategory.BLOCKS);
            }
            world.setBlockState(pos, state.with(ACTIVE, true));
        } else {
            world.scheduleBlockTick(pos, state.getBlock(), 20);
        }
    }

    @Override
    protected void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        super.scheduledTick(state, world, pos, random);
        if (state.get(ACTIVE)) {
            if (world.getReceivedRedstonePower(pos) <= 0) {
                world.playSound(null, pos, SoundEvent.of(SoundEvents.ITEM_SPEAR_USE.value().id()), SoundCategory.BLOCKS);
                world.setBlockState(pos, state.with(ACTIVE, false));
            } else {
                world.scheduleBlockTick(pos, state.getBlock(), 2);
            }
        }
    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, double fallDistance) {
        super.onLandedUpon(world, state, pos, entity, fallDistance);
        if (state.get(ACTIVE) && !world.isClient()) {
            ServerWorld serverWorld = (ServerWorld) world;
            entity.damage(serverWorld, ModDamageTypes.of(world, ModDamageTypes.SPIKE_TRAP), (float) Math.max(4, fallDistance*2));
        }
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, EntityCollisionHandler handler, boolean bl) {
        super.onEntityCollision(state, world, pos, entity, handler, bl);
        onLandedUpon(world, state, pos, entity, 0f);
    }

    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return COLLISION_SHAPE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ACTIVE);
    }
}
