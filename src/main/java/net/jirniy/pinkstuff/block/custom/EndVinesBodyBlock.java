package net.jirniy.pinkstuff.block.custom;

import com.mojang.serialization.MapCodec;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class EndVinesBodyBlock  extends AbstractPlantBlock implements EndVines {
    public static final MapCodec<CaveVinesBodyBlock> CODEC = createCodec(CaveVinesBodyBlock::new);

    public MapCodec<CaveVinesBodyBlock> getCodec() {
        return CODEC;
    }

    public EndVinesBodyBlock(AbstractBlock.Settings settings) {
        super(settings, Direction.DOWN, SHAPE, false);
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(BERRIES, false));
    }

    protected AbstractPlantStemBlock getStem() {
        return (AbstractPlantStemBlock) ModBlocks.END_VINES;
    }

    protected BlockState copyState(BlockState from, BlockState to) {
        return (BlockState)to.with(BERRIES, (Boolean)from.get(BERRIES));
    }

    protected ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state, boolean includeData) {
        return new ItemStack(ModItems.PEARLISCINE);
    }

    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        return EndVines.pickBerries(player, state, world, pos);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{BERRIES});
    }

    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return !(Boolean)state.get(BERRIES);
    }

    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        world.setBlockState(pos, (BlockState)state.with(BERRIES, true), 2);
    }
}
