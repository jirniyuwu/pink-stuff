package net.jirniy.pinkstuff.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.item.ModItems;
import net.jirniy.pinkstuff.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter;

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
                .add(ModBlocks.THERMIUM_ORE);
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
    }
}
