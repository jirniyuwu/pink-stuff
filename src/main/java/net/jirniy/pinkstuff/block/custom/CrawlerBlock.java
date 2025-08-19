package net.jirniy.pinkstuff.block.custom;

import net.jirniy.pinkstuff.entity.ModEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CrawlerBlock extends Block {

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClient() && !player.isInCreativeMode()) {
            ModEntities.CRAWLER.spawn((ServerWorld) world, pos, SpawnReason.SPAWNER);
        }
        return super.onBreak(world, pos, state, player);
    }

    public CrawlerBlock(Settings settings) {
        super(settings);
    }
}
