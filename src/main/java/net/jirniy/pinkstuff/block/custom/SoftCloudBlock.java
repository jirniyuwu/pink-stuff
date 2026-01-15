package net.jirniy.pinkstuff.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.TranslucentBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SoftCloudBlock extends TranslucentBlock {

    @Override
    protected int getOpacity(BlockState state) {
        return 0;
    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, double fallDistance) {
        if (!world.isClient() && entity instanceof LivingEntity livingEntity) {
            ServerWorld serverWorld = (ServerWorld) world;
            if (fallDistance >= 4) {
                serverWorld.spawnParticles(new BlockStateParticleEffect(ParticleTypes.BLOCK, state),
                        livingEntity.getX(), livingEntity.getY() + 0.1, livingEntity.getZ(),
                        45, 0.6, 0.1, 0.6, 0.7);
            } else if (fallDistance >= 1) {
                serverWorld.spawnParticles(new BlockStateParticleEffect(ParticleTypes.BLOCK, state),
                        livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(),
                        15, 0.4, 0.1, 0.4, 0.8);
            }
        }
        entity.handleFallDamage(fallDistance, 0.2F, world.getDamageSources().fall());
    }

    public SoftCloudBlock(Settings settings) {
        super(settings);
    }
}
