package net.jirniy.pinkstuff.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.MultifaceGrower;
import net.minecraft.block.MultifaceGrowthBlock;

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
}
