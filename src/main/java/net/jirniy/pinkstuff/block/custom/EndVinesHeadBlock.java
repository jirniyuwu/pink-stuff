package net.jirniy.pinkstuff.block.custom;

import com.mojang.serialization.MapCodec;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
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

public class EndVinesHeadBlock extends AbstractPlantStemBlock implements EndVines {
    public static final MapCodec<EndVinesHeadBlock> CODEC = createCodec(EndVinesHeadBlock::new);
    private static final float GROW_CHANCE = 0.11F;

    public MapCodec<EndVinesHeadBlock> getCodec() {
        return CODEC;
    }

    public EndVinesHeadBlock(AbstractBlock.Settings settings) {
        super(settings, Direction.DOWN, SHAPE, false, 0.1);
        this.setDefaultState((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(AGE, 0)).with(BERRIES, false));
    }

    protected int getGrowthLength(Random random) {
        return 1;
    }

    protected boolean chooseStemState(BlockState state) {
        return state.isAir();
    }

    protected Block getPlant() {
        return ModBlocks.END_VINES_PLANT;
    }

    protected BlockState copyState(BlockState from, BlockState to) {
        return (BlockState)to.with(BERRIES, (Boolean)from.get(BERRIES));
    }

    protected BlockState age(BlockState state, Random random) {
        return (BlockState)super.age(state, random).with(BERRIES, random.nextFloat() < 0.11F);
    }

    protected ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state, boolean includeData) {
        return new ItemStack(ModItems.PEARLISCINE);
    }

    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        return EndVines.pickBerries(player, state, world, pos);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
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
