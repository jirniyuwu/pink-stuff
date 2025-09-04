package net.jirniy.pinkstuff.block.custom;

import com.mojang.serialization.MapCodec;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.util.ModGamerules;
import net.jirniy.pinkstuff.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class CorrerieLogBlock extends Block {
    public static final MapCodec<CorrerieLogBlock> CODEC = createCodec(CorrerieLogBlock::new);
    public static final BooleanProperty SPREADABLE = BooleanProperty.of("spreadable");
    public static final EnumProperty<Direction.Axis> AXIS;

    public MapCodec<CorrerieLogBlock> getCodec() {
        return CODEC;
    }

    public CorrerieLogBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)this.getDefaultState().with(AXIS, Direction.Axis.Y));
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!world.getGameRules().getBoolean(ModGamerules.DISABLE_CORRUPTION_SPREAD) && state.get(SPREADABLE)) {
            spread(world, pos, random);
        }
        super.randomTick(state, world, pos, random);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (placer != null && placer.isPlayer()) {
            world.setBlockState(pos, state.with(SPREADABLE, false));
        }
        super.onPlaced(world, pos, state, placer, itemStack);
    }

    protected BlockState rotate(BlockState state, BlockRotation rotation) {
        return changeRotation(state, rotation);
    }

    public static BlockState changeRotation(BlockState state, BlockRotation rotation) {
        switch (rotation) {
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90:
                switch ((Direction.Axis)state.get(AXIS)) {
                    case X -> {
                        return (BlockState)state.with(AXIS, Direction.Axis.Z);
                    }
                    case Z -> {
                        return (BlockState)state.with(AXIS, Direction.Axis.X);
                    }
                    default -> {
                        return state;
                    }
                }
            default:
                return state;
        }
    }

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (stack.isOf(Items.SHEARS)) {
            if (state.get(SPREADABLE) == true) {
                world.setBlockState(pos, state.with(SPREADABLE, false));
                stack.damage(1, player);
                world.playSoundAtBlockCenterClient(pos, SoundEvents.ITEM_SHEARS_SNIP, SoundCategory.BLOCKS, 1, 1, true);
                world.addBlockBreakParticles(pos, state);
                world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, state));
            } else if (state.get(SPREADABLE) == false) {
                world.setBlockState(pos, state.with(SPREADABLE, true));
                stack.damage(1, player);
                world.playSoundAtBlockCenterClient(pos, SoundEvents.ITEM_SHEARS_SNIP, SoundCategory.BLOCKS, 1, 1, true);
                world.addBlockBreakParticles(pos, state);
                world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, state));
            }
        }
        return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(SPREADABLE);
        builder.add(AXIS);
    }
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(AXIS, ctx.getSide().getAxis());
    }
    static {
        AXIS = Properties.AXIS;
    }

    protected void spread(ServerWorld world, BlockPos pos, Random random) {
        if (random.nextBetween(1, world.getGameRules().getInt(ModGamerules.CORRUPTION_SPREAD_CHANCE)) == 1) {
            if (!world.isAir(pos.down())) {
                if (world.getBlockState(pos.down()).isIn(ModTags.Blocks.CORRUPTABLE_BLOCKS)) {
                    world.setBlockState(pos.down(), ModBlocks.BLACK_GOOP.getDefaultState());
                    world.playSoundAtBlockCenterClient(pos.south(), SoundEvents.BLOCK_HONEY_BLOCK_SLIDE,
                            SoundCategory.BLOCKS, 1f, 1, true);
                } else if (world.getBlockState(pos.down()).isIn(BlockTags.LOGS)) {
                    world.setBlockState(pos.down(), ModBlocks.CORRERIE_LOG.getDefaultState());
                    world.playSoundAtBlockCenterClient(pos.south(), SoundEvents.BLOCK_HONEY_BLOCK_SLIDE,
                            SoundCategory.BLOCKS, 1f, 1, true);
                }
            }
        }
        if (random.nextBetween(1, world.getGameRules().getInt(ModGamerules.CORRUPTION_SPREAD_CHANCE)) == 1) {
            if (!world.isAir(pos.up())) {
                if (world.getBlockState(pos.up()).isIn(ModTags.Blocks.CORRUPTABLE_BLOCKS)) {
                    world.setBlockState(pos.up(), ModBlocks.BLACK_GOOP.getDefaultState());
                    world.playSoundAtBlockCenterClient(pos.south(), SoundEvents.BLOCK_HONEY_BLOCK_SLIDE,
                            SoundCategory.BLOCKS, 1f, 1, true);
                } else if (world.getBlockState(pos.up()).isIn(BlockTags.LOGS)) {
                    world.setBlockState(pos.up(), ModBlocks.CORRERIE_LOG.getDefaultState());
                    world.playSoundAtBlockCenterClient(pos.south(), SoundEvents.BLOCK_HONEY_BLOCK_SLIDE,
                            SoundCategory.BLOCKS, 1f, 1, true);
                }
            } else if (random.nextInt(20) == 1) {
                world.setBlockState(pos.up(), ModBlocks.CORRUPT_ROOTS.getDefaultState());
                world.playSoundAtBlockCenterClient(pos.south(), SoundEvents.BLOCK_HONEY_BLOCK_SLIDE,
                        SoundCategory.BLOCKS, 1f, 1, true);
            }
        }
        if (random.nextBetween(1, world.getGameRules().getInt(ModGamerules.CORRUPTION_SPREAD_CHANCE)) == 1) {
            if (!world.isAir(pos.east())) {
                if (world.getBlockState(pos.east()).isIn(ModTags.Blocks.CORRUPTABLE_BLOCKS)) {
                    world.setBlockState(pos.east(), ModBlocks.BLACK_GOOP.getDefaultState());
                    world.playSoundAtBlockCenterClient(pos.south(), SoundEvents.BLOCK_HONEY_BLOCK_SLIDE,
                            SoundCategory.BLOCKS, 1f, 1, true);
                } else if (world.getBlockState(pos.east()).isIn(BlockTags.LOGS)) {
                    world.setBlockState(pos.east(), ModBlocks.CORRERIE_LOG.getDefaultState());
                    world.playSoundAtBlockCenterClient(pos.south(), SoundEvents.BLOCK_HONEY_BLOCK_SLIDE,
                            SoundCategory.BLOCKS, 1f, 1, true);
                }
            }
        }
        if (random.nextBetween(1, world.getGameRules().getInt(ModGamerules.CORRUPTION_SPREAD_CHANCE)) == 1) {
            if (!world.isAir(pos.west())) {
                if (world.getBlockState(pos.west()).isIn(ModTags.Blocks.CORRUPTABLE_BLOCKS)) {
                    world.setBlockState(pos.west(), ModBlocks.BLACK_GOOP.getDefaultState());
                    world.playSoundAtBlockCenterClient(pos.south(), SoundEvents.BLOCK_HONEY_BLOCK_SLIDE,
                            SoundCategory.BLOCKS, 1f, 1, true);
                } else if (world.getBlockState(pos.west()).isIn(BlockTags.LOGS)) {
                    world.setBlockState(pos.west(), ModBlocks.CORRERIE_LOG.getDefaultState());
                    world.playSoundAtBlockCenterClient(pos.south(), SoundEvents.BLOCK_HONEY_BLOCK_SLIDE,
                            SoundCategory.BLOCKS, 1f, 1, true);
                }
            }
        }
        if (random.nextBetween(1, world.getGameRules().getInt(ModGamerules.CORRUPTION_SPREAD_CHANCE)) == 1) {
            if (!world.isAir(pos.north())) {
                if (world.getBlockState(pos.north()).isIn(ModTags.Blocks.CORRUPTABLE_BLOCKS)) {
                    world.setBlockState(pos.north(), ModBlocks.BLACK_GOOP.getDefaultState());
                    world.playSoundAtBlockCenterClient(pos.south(), SoundEvents.BLOCK_HONEY_BLOCK_SLIDE,
                            SoundCategory.BLOCKS, 1f, 1, true);
                } else if (world.getBlockState(pos.north()).isIn(BlockTags.LOGS)) {
                    world.setBlockState(pos.north(), ModBlocks.CORRERIE_LOG.getDefaultState());
                    world.playSoundAtBlockCenterClient(pos.south(), SoundEvents.BLOCK_HONEY_BLOCK_SLIDE,
                            SoundCategory.BLOCKS, 1f, 1, true);
                }
            }
        }
        if (random.nextBetween(1, world.getGameRules().getInt(ModGamerules.CORRUPTION_SPREAD_CHANCE)) == 1) {
            if (!world.isAir(pos.south())) {
                if (world.getBlockState(pos.south()).isIn(ModTags.Blocks.CORRUPTABLE_BLOCKS)) {
                    world.setBlockState(pos.south(), ModBlocks.BLACK_GOOP.getDefaultState());
                    world.playSoundAtBlockCenterClient(pos.south(), SoundEvents.BLOCK_HONEY_BLOCK_SLIDE,
                            SoundCategory.BLOCKS, 1f, 1, true);
                } else if (world.getBlockState(pos.south()).isIn(BlockTags.LOGS)) {
                    world.setBlockState(pos.south(), ModBlocks.CORRERIE_LOG.getDefaultState());
                    world.playSoundAtBlockCenterClient(pos.south(), SoundEvents.BLOCK_HONEY_BLOCK_SLIDE,
                            SoundCategory.BLOCKS, 1f, 1, true);
                }
            }
        }
    }
}
