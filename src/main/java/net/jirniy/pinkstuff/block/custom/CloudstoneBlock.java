package net.jirniy.pinkstuff.block.custom;

import net.jirniy.pinkstuff.entity.ModEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.TranslucentBlock;
import net.minecraft.client.particle.BlockDustParticle;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class CloudstoneBlock extends TranslucentBlock {

    @Override
    protected int getOpacity(BlockState state) {
        return 1;
    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, double fallDistance) {
        if (!world.isClient() && entity instanceof LivingEntity livingEntity) {
            ServerWorld serverWorld = (ServerWorld) world;
            if (fallDistance >= 7) {
                serverWorld.spawnParticles(new BlockStateParticleEffect(ParticleTypes.BLOCK, state),
                        livingEntity.getX(), livingEntity.getY() + 0.1, livingEntity.getZ(),
                        25, 0.4, 0.1, 0.4, 0.9);
            } else if (fallDistance >= 2) {
                serverWorld.spawnParticles(new BlockStateParticleEffect(ParticleTypes.BLOCK, state),
                        livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(),
                        10, 0.3, 0.1, 0.3, 1);
            }
        }
        entity.handleFallDamage(fallDistance, 0.4F, world.getDamageSources().fall());
    }

    public CloudstoneBlock(Settings settings) {
        super(settings);
    }
}
