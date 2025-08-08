package net.jirniy.pinkstuff.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.MultifaceBlock;
import net.minecraft.block.MultifaceGrower;
import net.minecraft.block.MultifaceGrowthBlock;
import net.minecraft.util.math.Direction;

public class ModMultifaceBlock extends MultifaceGrowthBlock {
    public static final MapCodec<ModMultifaceBlock> CODEC = createCodec(ModMultifaceBlock::new);

    public ModMultifaceBlock(Settings settings) {
        super(settings);
    }

    @Override
    public MapCodec<? extends MultifaceGrowthBlock> getCodec() {
        return CODEC;
    }

    @Override
    public MultifaceGrower getGrower() {
        return new MultifaceGrower(this);
    }

    public static int luminanceSupplier(BlockState state, float multiplier) {
        float luminance = 0;
        if (MultifaceBlock.hasDirection(state, Direction.UP)) {
            luminance += multiplier;
        }
        if (MultifaceBlock.hasDirection(state, Direction.DOWN)) {
            luminance += multiplier;
        }
        if (MultifaceBlock.hasDirection(state, Direction.EAST)) {
            luminance += multiplier;
        }
        if (MultifaceBlock.hasDirection(state, Direction.WEST)) {
            luminance += multiplier;
        }
        if (MultifaceBlock.hasDirection(state, Direction.NORTH)) {
            luminance += multiplier;
        }
        if (MultifaceBlock.hasDirection(state, Direction.SOUTH)) {
            luminance += multiplier;
        }
        if (luminance > 15) {
            return 15;
        } else if (luminance < 0) {
            return 0;
        } else {
            return (int) Math.floor(luminance);
        }
    }
}
