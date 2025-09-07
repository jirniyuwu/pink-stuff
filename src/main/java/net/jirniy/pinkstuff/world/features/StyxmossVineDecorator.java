package net.jirniy.pinkstuff.world.features;

import com.mojang.serialization.MapCodec;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.VineBlock;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class StyxmossVineDecorator extends TreeDecorator {
    public static final MapCodec<StyxmossVineDecorator> CODEC = MapCodec.unit(StyxmossVineDecorator::new);

    protected TreeDecoratorType<?> getType() {
        return ModTreeDecorators.STYXMOSS_VINE;
    }

    public void replaceWithVine(TreeDecorator.Generator generator, BlockPos pos, BooleanProperty faceProperty) {
        generator.replace(pos, (BlockState) ModBlocks.STYXMOSS_VINE.getDefaultState().with(faceProperty, true));
    }

    public void generate(TreeDecorator.Generator generator) {
        Random random = generator.getRandom();
        generator.getLogPositions().forEach((pos) -> {
            if (random.nextInt(3) > 0) {
                BlockPos blockPos = pos.west();
                if (generator.isAir(blockPos)) {
                    replaceWithVine(generator, blockPos, VineBlock.EAST);
                }
            }

            if (random.nextInt(3) > 0) {
                BlockPos blockPos = pos.east();
                if (generator.isAir(blockPos)) {
                    replaceWithVine(generator, blockPos, VineBlock.WEST);
                }
            }

            if (random.nextInt(3) > 0) {
                BlockPos blockPos = pos.north();
                if (generator.isAir(blockPos)) {
                    replaceWithVine(generator, blockPos, VineBlock.SOUTH);
                }
            }

            if (random.nextInt(3) > 0) {
                BlockPos blockPos = pos.south();
                if (generator.isAir(blockPos)) {
                    replaceWithVine(generator, blockPos, VineBlock.NORTH);
                }
            }

        });
    }
}
