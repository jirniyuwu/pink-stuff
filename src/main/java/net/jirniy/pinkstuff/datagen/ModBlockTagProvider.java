package net.jirniy.pinkstuff.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.util.ModTags;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.PINK_ICE)
                .add(ModBlocks.KUNZITE_BLOCK)
                .add(ModBlocks.RAW_KUNZITE_BLOCK)
                .add(ModBlocks.DEEPSLATE_KUNZITE_ORE)
                .add(ModBlocks.AMETHYST_KUNZITE_ORE)
                .add(ModBlocks.KUNZITE_ORE)
                .add(ModBlocks.ELYSIUM_BLOCK)
                .add(ModBlocks.THERMIUM_BLOCK)
                .add(ModBlocks.ENERGIZED_THERMIUM_BLOCK)
                .add(ModBlocks.RAW_THERMIUM_BLOCK)
                .add(ModBlocks.DEEPSLATE_THERMIUM_ORE)
                .add(ModBlocks.THERMIUM_ORE)
                .add(ModBlocks.POLISHED_AMETHYST_BLOCK)
                .add(ModBlocks.AMETHYST_BRICKS)
                .add(ModBlocks.AMETHYST_BULB)
                .add(ModBlocks.KUNZITE_BRICKS)
                .add(ModBlocks.KUNZITE_BULB)
                .add(ModBlocks.ELYSIUM_BRICKS)
                .add(ModBlocks.ELYSIUM_BULB)
                .add(ModBlocks.THERMIUM_BRICKS)
                .add(ModBlocks.THERMIUM_BULB)
                .add(ModBlocks.CHISELED_AMETHYST_BRICKS)
                .add(ModBlocks.CHISELED_KUNZITE_BRICKS)
                .add(ModBlocks.CHISELED_ELYSIUM_BRICKS)
                .add(ModBlocks.CHISELED_THERMIUM_BRICKS)
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
                .add(ModBlocks.THERMIUM_BRICKS_WALL)
                .add(ModBlocks.THERMIUM_BLASTER)
                .add(ModBlocks.MEMORY_BRICKS)
                .add(ModBlocks.CHISELED_MEMORY_BRICKS)
                .add(ModBlocks.MEMORY_BULB)
                .add(ModBlocks.MEMORY_BRICKS_SLAB)
                .add(ModBlocks.MEMORY_BRICKS_STAIRS)
                .add(ModBlocks.MEMORY_BRICKS_WALL);
        valueLookupBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.CRYSTAL_CHERRY_SLAB)
                .add(ModBlocks.CRYSTAL_CHERRY_BUTTON)
                .add(ModBlocks.CRYSTAL_CHERRY_PRESSURE_PLATE)
                .add(ModBlocks.CRYSTAL_CHERRY_STAIRS)
                .add(ModBlocks.CRYSTAL_CHERRY_DOOR)
                .add(ModBlocks.CRYSTAL_CHERRY_TRAPDOOR)
                .add(ModBlocks.DISPLAY);
        valueLookupBuilder(BlockTags.PLANKS)
                .add(ModBlocks.CRYSTAL_CHERRY_PLANKS);
        valueLookupBuilder(BlockTags.LEAVES)
                .add(ModBlocks.CRYSTAL_CHERRY_LEAVES);
        valueLookupBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.AMETHYST_BULB)
                .add(ModBlocks.KUNZITE_BULB);
        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.KUNZITE_BLOCK)
                .add(ModBlocks.RAW_KUNZITE_BLOCK)
                .add(ModBlocks.DEEPSLATE_KUNZITE_ORE)
                .add(ModBlocks.KUNZITE_ORE)
                .add(ModBlocks.ELYSIUM_BLOCK)
                .add(ModBlocks.ELYSIUM_BULB)
                .add(ModBlocks.THERMIUM_BULB);
        valueLookupBuilder(ModTags.Blocks.NEEDS_KUNZITE_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);
        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.THERMIUM_BLOCK)
                .add(ModBlocks.RAW_THERMIUM_BLOCK)
                .add(ModBlocks.DEEPSLATE_THERMIUM_ORE)
                .add(ModBlocks.THERMIUM_ORE)
                .add(ModBlocks.ENERGIZED_THERMIUM_BLOCK)
                .add(ModBlocks.MEMORY_BRICKS)
                .add(ModBlocks.CHISELED_MEMORY_BRICKS)
                .add(ModBlocks.MEMORY_BULB)
                .add(ModBlocks.MEMORY_BRICKS_SLAB)
                .add(ModBlocks.MEMORY_BRICKS_STAIRS)
                .add(ModBlocks.MEMORY_BRICKS_WALL);
        valueLookupBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.CRYSTAL_CHERRY_LOG)
                .add(ModBlocks.CRYSTAL_CHERRY_WOOD)
                .add(ModBlocks.STRIPPED_CRYSTAL_CHERRY_LOG)
                .add(ModBlocks.STRIPPED_CRYSTAL_CHERRY_WOOD);
        valueLookupBuilder(ModTags.Blocks.NEEDS_SPECIAL_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);
        valueLookupBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.CRYSTAL_CHERRY_FENCE);
        valueLookupBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.CRYSTAL_CHERRY_FENCE_GATE);
        valueLookupBuilder(BlockTags.WALLS)
                .add(ModBlocks.AMETHYST_BRICKS_WALL)
                .add(ModBlocks.KUNZITE_BRICKS_WALL)
                .add(ModBlocks.ELYSIUM_BRICKS_WALL)
                .add(ModBlocks.THERMIUM_BRICKS_WALL)
                .add(ModBlocks.POLISHED_AMETHYST_WALL)
                .add(ModBlocks.MEMORY_BRICKS_WALL);
        valueLookupBuilder(BlockTags.BEACON_BASE_BLOCKS)
                .add(ModBlocks.KUNZITE_BLOCK)
                .add(ModBlocks.ELYSIUM_BLOCK)
                .add(ModBlocks.THERMIUM_BLOCK);
        valueLookupBuilder(BlockTags.FLOWERS)
                .add(ModBlocks.HAZEWEAVER_PLANT)
                .add(ModBlocks.AMETHYST_PARTERS)
                .add(ModBlocks.KUNZITE_LOVELILY)
                .add(ModBlocks.ELYSIAN_SKYBERRY)
                .add(ModBlocks.MEMORIA_BOURPEER)
                .add(ModBlocks.THERMIUM_WILTBORN);
        valueLookupBuilder(BlockTags.FLOWER_POTS)
                .add(ModBlocks.POTTED_AMETHYST_PARTERS)
                .add(ModBlocks.POTTED_KUNZITE_LOVELILY)
                .add(ModBlocks.POTTED_ELYSIAN_SKYBERRY)
                .add(ModBlocks.POTTED_MEMORIA_BOURPEER)
                .add(ModBlocks.POTTED_THERMIUM_WILTBORN)
                .add(ModBlocks.POTTED_CRYSTAL_CHERRY_SAPLING)
                .add(ModBlocks.POTTED_HAZEWEAVER_PLANT);
        valueLookupBuilder(BlockTags.ICE)
                .add(ModBlocks.PINK_ICE);
        valueLookupBuilder(BlockTags.SLABS)
                .add(ModBlocks.AMETHYST_BRICKS_SLAB)
                .add(ModBlocks.ELYSIUM_BRICKS_SLAB)
                .add(ModBlocks.KUNZITE_BRICKS_SLAB)
                .add(ModBlocks.POLISHED_AMETHYST_SLAB)
                .add(ModBlocks.THERMIUM_BRICKS_SLAB)
                .add(ModBlocks.MEMORY_BRICKS_SLAB);
        valueLookupBuilder(BlockTags.STAIRS)
                .add(ModBlocks.AMETHYST_BRICKS_STAIRS)
                .add(ModBlocks.ELYSIUM_BRICKS_STAIRS)
                .add(ModBlocks.KUNZITE_BRICKS_STAIRS)
                .add(ModBlocks.POLISHED_AMETHYST_STAIRS)
                .add(ModBlocks.THERMIUM_BRICKS_STAIRS)
                .add(ModBlocks.MEMORY_BRICKS_STAIRS);
        valueLookupBuilder(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.CRYSTAL_CHERRY_SLAB);
        valueLookupBuilder(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.CRYSTAL_CHERRY_STAIRS);
        valueLookupBuilder(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.CRYSTAL_CHERRY_DOOR);
        valueLookupBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.CRYSTAL_CHERRY_TRAPDOOR);
        valueLookupBuilder(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.CRYSTAL_CHERRY_BUTTON);
        valueLookupBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.CRYSTAL_CHERRY_PRESSURE_PLATE);
        valueLookupBuilder(ModTags.Blocks.CRYSTAL_CHERRY_LOGS)
                .add(ModBlocks.CRYSTAL_CHERRY_LOG)
                .add(ModBlocks.CRYSTAL_CHERRY_WOOD)
                .add(ModBlocks.STRIPPED_CRYSTAL_CHERRY_LOG)
                .add(ModBlocks.STRIPPED_CRYSTAL_CHERRY_WOOD);
    }
}
