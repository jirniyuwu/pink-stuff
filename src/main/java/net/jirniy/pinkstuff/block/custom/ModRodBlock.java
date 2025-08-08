package net.jirniy.pinkstuff.block.custom;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.EndRodBlock;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ModRodBlock extends EndRodBlock {
    private final SimpleParticleType PARTICLE;

    public ModRodBlock(@Nullable SimpleParticleType particle, AbstractBlock.Settings settings) {
        super(settings);
        this.PARTICLE = particle;
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (PARTICLE != null) {
            Direction direction = (Direction)state.get(FACING);
            double d = (double)pos.getX() + 0.55 - (double)(random.nextFloat() * 0.1f);
            double e = (double)pos.getY() + 0.55 - (double)(random.nextFloat() * 0.1f);
            double f = (double)pos.getZ() + 0.55 - (double)(random.nextFloat() * 0.1f);
            double g = 0.4f - (random.nextFloat() + random.nextFloat()) * 0.4f;
            if (random.nextInt(5) == 0) {
                world.addParticleClient(
                        this.PARTICLE,
                        d + (double) direction.getOffsetX() * g,
                        e + (double) direction.getOffsetY() * g,
                        f + (double) direction.getOffsetZ() * g,
                        random.nextGaussian() * 0.005,
                        random.nextGaussian() * 0.005,
                        random.nextGaussian() * 0.005);
            }
        }
    }
}
