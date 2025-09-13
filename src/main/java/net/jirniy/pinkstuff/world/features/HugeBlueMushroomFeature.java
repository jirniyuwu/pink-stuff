package net.jirniy.pinkstuff.world.features;

import com.mojang.serialization.Codec;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.MushroomBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class HugeBlueMushroomFeature extends HugeMushroomFeature {
    public HugeBlueMushroomFeature(Codec<HugeMushroomFeatureConfig> codec) {
        super(codec);
    }

    protected void generateCap(WorldAccess world, Random random, BlockPos start, int y, BlockPos.Mutable mutable, HugeMushroomFeatureConfig config) {
        for(int i = y - 1; i <= y; ++i) {
            int j = i < y ? config.foliageRadius : config.foliageRadius - 1;
            int k = config.foliageRadius - 2;

            for(int l = -j; l <= j; ++l) {
                for(int m = -j; m <= j; ++m) {
                    boolean bl = l == -j;
                    boolean bl2 = l == j;
                    boolean bl3 = m == -j;
                    boolean bl4 = m == j;
                    boolean bl5 = bl || bl2;
                    boolean bl6 = bl3 || bl4;
                    if (i >= y || bl5 != bl6) {
                        mutable.set(start, l, i, m);
                        BlockState blockState = config.capProvider.get(random, start);
                        if (blockState.contains(MushroomBlock.WEST) && blockState.contains(MushroomBlock.EAST) && blockState.contains(MushroomBlock.NORTH) && blockState.contains(MushroomBlock.SOUTH) && blockState.contains(MushroomBlock.UP)) {
                            blockState = (BlockState)((BlockState)((BlockState)((BlockState)((BlockState)blockState.with(MushroomBlock.UP, i >= y - 1)).with(MushroomBlock.DOWN, !(i >= y - 1)).with(MushroomBlock.WEST, l < -k)).with(MushroomBlock.EAST, l > k)).with(MushroomBlock.NORTH, m < -k)).with(MushroomBlock.SOUTH, m > k);
                        }

                        this.generateStem(world, mutable, blockState);
                    }
                }
            }
        }

    }

    protected int getHeight(Random random) {
        int i = random.nextInt(5) + 5;
        if (random.nextInt(7) == 0) {
            i += random.nextInt(6);
        }

        return i;
    }

    protected int getCapSize(int i, int j, int capSize, int y) {
        int k = 0;
        if (y < j && y >= j - 3) {
            k = capSize;
        } else if (y == j) {
            k = capSize;
        }

        return k;
    }
}
