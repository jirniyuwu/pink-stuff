package net.jirniy.pinkstuff.world.features;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.HangingMossBlock;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import org.apache.commons.lang3.mutable.MutableObject;

import java.util.List;

public class HangingStyxgrassDecorator extends TreeDecorator {
    public static final MapCodec<HangingStyxgrassDecorator> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group((Codec.floatRange(0.0f, 1.0f)
                    .fieldOf("leaves_probability"))
                    .forGetter(treeDecorator -> treeDecorator.leavesProbability))
                    .apply(instance, HangingStyxgrassDecorator::new));
    private final float leavesProbability;

    @Override
    protected TreeDecoratorType<?> getType() {
        return ModTreeDecorators.HANGING_STYXGRASS;
    }

    public HangingStyxgrassDecorator(float leavesProbability) {
        this.leavesProbability = leavesProbability;
    }

    @Override
    public void generate(Generator generator) {
        Random random = generator.getRandom();
        List<BlockPos> list = Util.copyShuffled(generator.getLogPositions(), random);
        if (list.isEmpty()) {
            return;
        }
        MutableObject<BlockPos> mutable = new MutableObject<BlockPos>(list.getFirst());
        list.forEach(pos -> {
            if (pos.getY() < ((BlockPos)mutable.getValue()).getY()) {
                mutable.setValue((BlockPos)pos);
            }
        });
        generator.getLeavesPositions().forEach(pos -> {
            BlockPos blockPos2;
            if (random.nextFloat() < this.leavesProbability && generator.isAir(blockPos2 = pos.down())) {
                decorate(blockPos2, generator);
            }
        });
    }

    private static void decorate(BlockPos pos, Generator generator) {
        while (generator.isAir(pos.down()) && !((double)generator.getRandom().nextFloat() < 0.5)) {
            generator.replace(pos, (BlockState) ModBlocks.HANGING_STYXGRASS.getDefaultState().with(HangingMossBlock.TIP, false));
            pos = pos.down();
        }
        generator.replace(pos, (BlockState)ModBlocks.HANGING_STYXGRASS.getDefaultState().with(HangingMossBlock.TIP, true));
    }
}
