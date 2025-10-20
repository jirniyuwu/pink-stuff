package net.jirniy.pinkstuff.block.custom;

import com.mojang.serialization.MapCodec;
import net.jirniy.pinkstuff.block.entity.custom.ShelfBlockEntity2;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ShelfBlockEntity;
import net.minecraft.block.enums.SideChainPart;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.block.WireOrientation;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.event.GameEvent.Emitter;
import net.minecraft.world.tick.ScheduledTickView;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.OptionalInt;

public class ModShelfBlock extends BlockWithEntity implements InteractibleSlotContainer, SideChaining, Waterloggable {
    public static final MapCodec<ModShelfBlock> CODEC = createCodec(ModShelfBlock::new);
    public static final BooleanProperty POWERED;
    public static final EnumProperty<Direction> FACING;
    public static final EnumProperty<SideChainPart> SIDE_CHAIN;
    public static final BooleanProperty WATERLOGGED;
    private static final Map<Direction, VoxelShape> SHAPES;

    public MapCodec<ModShelfBlock> getCodec() {
        return CODEC;
    }

    public ModShelfBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(FACING, Direction.NORTH)).with(POWERED, false)).with(SIDE_CHAIN, SideChainPart.UNCONNECTED)).with(WATERLOGGED, false));
    }

    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return (VoxelShape)SHAPES.get(state.get(FACING));
    }

    protected boolean hasSidedTransparency(BlockState state) {
        return true;
    }

    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return type == NavigationType.WATER && state.getFluidState().isIn(FluidTags.WATER);
    }

    @Nullable
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ShelfBlockEntity2(pos, state);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING, POWERED, SIDE_CHAIN, WATERLOGGED});
    }

    protected void onStateReplaced(BlockState state, ServerWorld world, BlockPos pos, boolean moved) {
        ItemScatterer.onStateReplaced(state, world, pos);
        this.disconnectNeighbors(world, pos, state);
    }

    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, @Nullable WireOrientation wireOrientation, boolean notify) {
        if (!world.isClient()) {
            boolean bl = world.isReceivingRedstonePower(pos);
            if ((Boolean)state.get(POWERED) != bl) {
                BlockState blockState = (BlockState)state.with(POWERED, bl);
                if (!bl) {
                    blockState = (BlockState)blockState.with(SIDE_CHAIN, SideChainPart.UNCONNECTED);
                }

                world.setBlockState(pos, blockState, 3);
                this.playSound(world, pos, bl ? SoundEvents.BLOCK_SHELF_ACTIVATE : SoundEvents.BLOCK_SHELF_DEACTIVATE);
                world.emitGameEvent(bl ? GameEvent.BLOCK_ACTIVATE : GameEvent.BLOCK_DEACTIVATE, pos, Emitter.of(blockState));
            }

        }
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        return (BlockState)((BlockState)((BlockState)this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite())).with(POWERED, ctx.getWorld().isReceivingRedstonePower(ctx.getBlockPos()))).with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return (BlockState)state.with(FACING, rotation.rotate((Direction)state.get(FACING)));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation((Direction)state.get(FACING)));
    }

    public int getRows() {
        return 1;
    }

    public int getColumns() {
        return 3;
    }

    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        BlockEntity var9 = world.getBlockEntity(pos);
        if (var9 instanceof ShelfBlockEntity2 shelfBlockEntity) {
            if (!hand.equals(Hand.OFF_HAND)) {
                OptionalInt optionalInt = this.getHitSlot(hit, (Direction)state.get(FACING));
                if (optionalInt.isEmpty()) {
                    return ActionResult.PASS;
                }

                if (world.isClient()) {
                    return ActionResult.SUCCESS;
                }

                PlayerInventory playerInventory = player.getInventory();
                if (!(Boolean)state.get(POWERED)) {
                    boolean bl = swapSingleStack(stack, player, shelfBlockEntity, optionalInt.getAsInt(), playerInventory);
                    if (bl) {
                        this.playSound(world, pos, stack.isEmpty() ? SoundEvents.BLOCK_SHELF_TAKE_ITEM : SoundEvents.BLOCK_SHELF_SINGLE_SWAP);
                    } else {
                        if (stack.isEmpty()) {
                            return ActionResult.PASS;
                        }

                        this.playSound(world, pos, SoundEvents.BLOCK_SHELF_PLACE_ITEM);
                    }

                    return ActionResult.SUCCESS.withNewHandStack(stack);
                }

                ItemStack itemStack = playerInventory.getSelectedStack();
                boolean bl2 = this.swapAllStacks(world, pos, playerInventory);
                if (!bl2) {
                    return ActionResult.CONSUME;
                }

                this.playSound(world, pos, SoundEvents.BLOCK_SHELF_MULTI_SWAP);
                if (itemStack == playerInventory.getSelectedStack()) {
                    return ActionResult.SUCCESS;
                }

                return ActionResult.SUCCESS.withNewHandStack(playerInventory.getSelectedStack());
            }
        }

        return ActionResult.PASS;
    }

    private static boolean swapSingleStack(ItemStack stack, PlayerEntity player, ShelfBlockEntity2 blockEntity, int hitSlot, PlayerInventory playerInventory) {
        ItemStack itemStack = blockEntity.swapStackNoMarkDirty(hitSlot, stack);
        ItemStack itemStack2 = player.isInCreativeMode() && itemStack.isEmpty() ? stack.copy() : itemStack;
        playerInventory.setStack(playerInventory.getSelectedSlot(), itemStack2);
        playerInventory.markDirty();
        blockEntity.markDirty(GameEvent.ITEM_INTERACT_FINISH);
        return !itemStack.isEmpty();
    }

    private boolean swapAllStacks(World world, BlockPos pos, PlayerInventory playerInventory) {
        List<BlockPos> list = this.getPositionsInChain(world, pos);
        if (list.isEmpty()) {
            return false;
        } else {
            boolean bl = false;

            for(int i = 0; i < list.size(); ++i) {
                ShelfBlockEntity2 shelfBlockEntity = (ShelfBlockEntity2)world.getBlockEntity((BlockPos)list.get(i));
                if (shelfBlockEntity != null) {
                    for(int j = 0; j < shelfBlockEntity.size(); ++j) {
                        int k = 9 - (list.size() - i) * shelfBlockEntity.size() + j;
                        if (k >= 0 && k <= playerInventory.size()) {
                            ItemStack itemStack = playerInventory.removeStack(k);
                            ItemStack itemStack2 = shelfBlockEntity.swapStackNoMarkDirty(j, itemStack);
                            if (!itemStack.isEmpty() || !itemStack2.isEmpty()) {
                                playerInventory.setStack(k, itemStack2);
                                bl = true;
                            }
                        }
                    }

                    playerInventory.markDirty();
                    shelfBlockEntity.markDirty(GameEvent.ENTITY_INTERACT);
                }
            }

            return bl;
        }
    }

    public SideChainPart getSideChainPart(BlockState state) {
        return (SideChainPart)state.get(SIDE_CHAIN);
    }

    public BlockState withSideChainPart(BlockState state, SideChainPart sideChainPart) {
        return (BlockState)state.with(SIDE_CHAIN, sideChainPart);
    }

    public Direction getFacing(BlockState state) {
        return (Direction)state.get(FACING);
    }

    public boolean canChainWith(BlockState state) {
        return state.isIn(BlockTags.WOODEN_SHELVES) && state.contains(POWERED) && (Boolean)state.get(POWERED);
    }

    public int getMaxSideChainLength() {
        return 3;
    }

    protected void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if ((Boolean)state.get(POWERED)) {
            this.connectNeighbors(world, pos, state, oldState);
        } else {
            this.disconnectNeighbors(world, pos, state);
        }

    }

    private void playSound(WorldAccess world, BlockPos pos, SoundEvent sound) {
        world.playSound((Entity)null, pos, sound, SoundCategory.BLOCKS, 1.0F, 1.0F);
    }

    protected FluidState getFluidState(BlockState state) {
        return (Boolean)state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    protected BlockState getStateForNeighborUpdate(BlockState state, WorldView world, ScheduledTickView tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, Random random) {
        if ((Boolean)state.get(WATERLOGGED)) {
            tickView.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return super.getStateForNeighborUpdate(state, world, tickView, pos, direction, neighborPos, neighborState, random);
    }

    protected boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    protected int getComparatorOutput(BlockState state, World world, BlockPos pos, Direction direction) {
        if (world.isClient()) {
            return 0;
        } else if (direction != ((Direction)state.get(FACING)).getOpposite()) {
            return 0;
        } else {
            BlockEntity var6 = world.getBlockEntity(pos);
            if (var6 instanceof ShelfBlockEntity2) {
                ShelfBlockEntity2 shelfBlockEntity = (ShelfBlockEntity2)var6;
                int i = shelfBlockEntity.getStack(0).isEmpty() ? 0 : 1;
                int j = shelfBlockEntity.getStack(1).isEmpty() ? 0 : 1;
                int k = shelfBlockEntity.getStack(2).isEmpty() ? 0 : 1;
                return i | j << 1 | k << 2;
            } else {
                return 0;
            }
        }
    }

    static {
        POWERED = Properties.POWERED;
        FACING = Properties.HORIZONTAL_FACING;
        SIDE_CHAIN = Properties.SIDE_CHAIN;
        WATERLOGGED = Properties.WATERLOGGED;
        SHAPES = VoxelShapes.createHorizontalFacingShapeMap(VoxelShapes.union(Block.createCuboidShape((double)0.0F, (double)12.0F, (double)11.0F, (double)16.0F, (double)16.0F, (double)13.0F), new VoxelShape[]{Block.createCuboidShape((double)0.0F, (double)0.0F, (double)13.0F, (double)16.0F, (double)16.0F, (double)16.0F), Block.createCuboidShape((double)0.0F, (double)0.0F, (double)11.0F, (double)16.0F, (double)4.0F, (double)13.0F)}));
    }
}
