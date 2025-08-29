package net.jirniy.pinkstuff.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DaylightDetectorBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.block.WireOrientation;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class AmethystLampBlock extends Block {
    public static final IntProperty POWER = IntProperty.of("power", 0, 15);
    public static final BooleanProperty PRESERVE = BooleanProperty.of("preserve");

    public AmethystLampBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(PRESERVE, false));
        setDefaultState(getDefaultState().with(POWER, 0));
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!player.canModifyBlocks()) {
            return super.onUse(state, world, pos, player, hit);
        } else {
            if (!world.isClient) {
                BlockState blockState = (BlockState)state.cycle(PRESERVE);
                world.setBlockState(pos, blockState, 2);
                world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, blockState));
                neighborUpdate(blockState, world, pos, this, null, true);
            }

            return ActionResult.SUCCESS;
        }
    }

    public static int getLuminance(BlockState state) {
        return state.get(POWER);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        this.neighborUpdate(state, world, pos, this, null, true);
        super.onPlaced(world, pos, state, placer, itemStack);
    }

    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, @Nullable WireOrientation wireOrientation, boolean notify) {
        if (!world.isClient && !state.get(PRESERVE)) {
            int redstone = world.getReceivedRedstonePower(pos);
            world.setBlockState(pos, state.with(POWER, redstone));
        }
    }

    @Override
    protected boolean hasComparatorOutput(BlockState state) {
        return state.get(POWER) > 0;
    }

    @Override
    protected int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return state.get(POWER);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(POWER);
        builder.add(PRESERVE);
        super.appendProperties(builder);
    }
}
