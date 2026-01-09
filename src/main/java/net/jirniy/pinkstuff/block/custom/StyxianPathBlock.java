package net.jirniy.pinkstuff.block.custom;

import com.mojang.serialization.MapCodec;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.block.WireOrientation;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.tick.ScheduledTickView;
import org.jspecify.annotations.Nullable;

public class StyxianPathBlock extends Block {
    public static final MapCodec<StyxianPathBlock> CODEC = createCodec(StyxianPathBlock::new);
    private static final VoxelShape SHAPE = Block.createColumnShape((double)16.0F, (double)0.0F, (double)15.0F);

    public MapCodec<StyxianPathBlock> getCodec() {
        return CODEC;
    }

    public StyxianPathBlock(Settings settings) {
        super(settings);
    }

    protected boolean hasSidedTransparency(BlockState state) {
        return true;
    }

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (state.isOf(ModBlocks.STYXIAN_PATH) && stack.isOf(ModBlocks.POLISHED_STYXSTONE.asItem())) {
            stack.decrementUnlessCreative(1, player);
            world.setBlockState(pos, ModBlocks.TILED_STYXIAN_PATH.getDefaultState());
            world.playSoundAtBlockCenterClient(pos, SoundEvents.BLOCK_POLISHED_DEEPSLATE_PLACE, SoundCategory.BLOCKS, 1, 1, true);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, state));
            return ActionResult.SUCCESS;
        }
        return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return !this.getDefaultState().canPlaceAt(ctx.getWorld(), ctx.getBlockPos()) ? Block.pushEntitiesUpBeforeBlockChange(this.getDefaultState(), ModBlocks.STYXIAN_SOIL.getDefaultState(), ctx.getWorld(), ctx.getBlockPos()) : super.getPlacementState(ctx);
    }

    protected BlockState getStateForNeighborUpdate(BlockState state, WorldView world, ScheduledTickView tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, Random random) {
        if (direction == Direction.UP && !state.canPlaceAt(world, pos)) {
            tickView.scheduleBlockTick(pos, this, 1);
        }

        return super.getStateForNeighborUpdate(state, world, tickView, pos, direction, neighborPos, neighborState, random);
    }

    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos.up());
        return !blockState.isSolid() || blockState.getBlock() instanceof FenceGateBlock;
    }

    protected void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockState blockState = pushEntitiesUpBeforeBlockChange(state, ModBlocks.STYXIAN_SOIL.getDefaultState(), world, pos);
        world.setBlockState(pos, blockState);
        world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(null, blockState));
    }

    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }
}
