package net.jirniy.pinkstuff.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.util.ModTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.KUNZITE_BLOCK)
                .add(ModBlocks.RAW_KUNZITE_BLOCK)
                .add(ModBlocks.DEEPSLATE_KUNZITE_ORE)
                .add(ModBlocks.AMETHYST_KUNZITE_ORE)
                .add(ModBlocks.KUNZITE_ORE)
                .add(ModBlocks.ELYSIUM_BLOCK)
                .add(ModBlocks.THERMIUM_BLOCK)
                .add(ModBlocks.RAW_THERMIUM_BLOCK)
                .add(ModBlocks.DEEPSLATE_THERMIUM_ORE)
                .add(ModBlocks.THERMIUM_ORE)
                .add(ModBlocks.POLISHED_AMETHYST_BLOCK)
                .add(ModBlocks.AMETHYST_BRICKS)
                .add(ModBlocks.KUNZITE_BRICKS)
                .add(ModBlocks.ELYSIUM_BRICKS)
                .add(ModBlocks.THERMIUM_BRICKS)
                .add(ModBlocks.POLISHED_AMETHYST_STAIRS)
                .add(ModBlocks.AMETHYST_BRICKS_STAIRS)
                .add(ModBlocks.KUNZITE_BRICKS_STAIRS)
                .add(ModBlocks.ELYSIUM_BRICKS_STAIRS)
                .add(ModBlocks.THERMIUM_BRICKS_STAIRS)
                .add(ModBlocks.POLISHED_AMETHYST_SLAB)
                .add(ModBlocks.AMETHYST_BRICKS_SLAB)
                .add(ModBlocks.KUNZITE_BRICKS_SLAB)
                .add(ModBlocks.ELYSIUM_BRICKS_SLAB)
                .add(ModBlocks.THERMIUM_BRICKS_SLAB)
                .add(ModBlocks.POLISHED_AMETHYST_WALL)
                .add(ModBlocks.AMETHYST_BRICKS_WALL)
                .add(ModBlocks.KUNZITE_BRICKS_WALL)
                .add(ModBlocks.ELYSIUM_BRICKS_WALL)
                .add(ModBlocks.THERMIUM_BRICKS_WALL);
        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.CRYSTAL_CHERRY_PLANKS)
                .add(ModBlocks.CRYSTAL_CHERRY_SLAB)
                .add(ModBlocks.CRYSTAL_CHERRY_BUTTON)
                .add(ModBlocks.CRYSTAL_CHERRY_PRESSURE_PLATE)
                .add(ModBlocks.CRYSTAL_CHERRY_STAIRS)
                .add(ModBlocks.CRYSTAL_CHERRY_DOOR)
                .add(ModBlocks.CRYSTAL_CHERRY_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.KUNZITE_BLOCK)
                .add(ModBlocks.RAW_KUNZITE_BLOCK)
                .add(ModBlocks.DEEPSLATE_KUNZITE_ORE)
                .add(ModBlocks.KUNZITE_ORE)
                .add(ModBlocks.ELYSIUM_BLOCK);
        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_KUNZITE_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.THERMIUM_BLOCK)
                .add(ModBlocks.RAW_THERMIUM_BLOCK)
                .add(ModBlocks.DEEPSLATE_THERMIUM_ORE)
                .add(ModBlocks.THERMIUM_ORE);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.CRYSTAL_CHERRY_LOG)
                .add(ModBlocks.CRYSTAL_CHERRY_WOOD)
                .add(ModBlocks.STRIPPED_CRYSTAL_CHERRY_LOG)
                .add(ModBlocks.STRIPPED_CRYSTAL_CHERRY_WOOD);
        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_SPECIAL_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.CRYSTAL_CHERRY_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.CRYSTAL_CHERRY_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.AMETHYST_BRICKS_WALL)
                .add(ModBlocks.KUNZITE_BRICKS_WALL)
                .add(ModBlocks.ELYSIUM_BRICKS_WALL)
                .add(ModBlocks.THERMIUM_BRICKS_WALL)
                .add(ModBlocks.POLISHED_AMETHYST_WALL);
    }
}
