package net.jirniy.pinkstuff.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.block.custom.GemBerryBushBlock;
import net.jirniy.pinkstuff.item.ModArmorMaterials;
import net.jirniy.pinkstuff.item.ModItems;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.client.data.TexturedModel;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool compressedEndStonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.COMPRESSED_END_STONE_BRICKS);
        BlockStateModelGenerator.BlockTexturePool ashenPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ASHEN_PLANKS);
        BlockStateModelGenerator.BlockTexturePool keaphePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.KEAPHE_PLANKS);
        BlockStateModelGenerator.BlockTexturePool chorusPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CHORUS_PLANKS);
        BlockStateModelGenerator.BlockTexturePool crystalCherryPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CRYSTAL_CHERRY_PLANKS);
        BlockStateModelGenerator.BlockTexturePool polishedAmethystPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_AMETHYST_BLOCK);
        BlockStateModelGenerator.BlockTexturePool amethystBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.AMETHYST_BRICKS);
        BlockStateModelGenerator.BlockTexturePool kunziteBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.KUNZITE_BRICKS);
        BlockStateModelGenerator.BlockTexturePool elysiumBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ELYSIUM_BRICKS);
        BlockStateModelGenerator.BlockTexturePool thermiumBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.THERMIUM_BRICKS);
        BlockStateModelGenerator.BlockTexturePool memoryBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MEMORY_BRICKS);
        BlockStateModelGenerator.BlockTexturePool pinlineBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PINLINE_BRICKS);
        BlockStateModelGenerator.BlockTexturePool rawPinlineBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RAW_PINLINE_BRICKS);
        BlockStateModelGenerator.BlockTexturePool styxstoneBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.STYXSTONE_BRICKS);
        BlockStateModelGenerator.BlockTexturePool compressedStyxstoneBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.COMPRESSED_STYXSTONE_BRICKS);
        BlockStateModelGenerator.BlockTexturePool mabrizeBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MABRIZE_BRICKS);
        BlockStateModelGenerator.BlockTexturePool moonsteelBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MOONSTEEL_BRICKS);
        BlockStateModelGenerator.BlockTexturePool cerilleBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CERILLE_BRICKS);
        BlockStateModelGenerator.BlockTexturePool sungazeBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SUNGAZE_BRICKS);
        BlockStateModelGenerator.BlockTexturePool pinkSandstonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PINK_SANDSTONE);
        BlockStateModelGenerator.BlockTexturePool smoothPinkSandstonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SMOOTH_PINK_SANDSTONE);
        BlockStateModelGenerator.BlockTexturePool cutPinkSandstonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CUT_PINK_SANDSTONE);
        BlockStateModelGenerator.BlockTexturePool cobbledStyxstonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.COBBLED_STYXSTONE);
        BlockStateModelGenerator.BlockTexturePool mossyCobbledStyxstonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MOSSY_COBBLED_STYXSTONE);
        BlockStateModelGenerator.BlockTexturePool polishedStyxstonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_STYXSTONE);
        BlockStateModelGenerator.BlockTexturePool polishedCompressedStyxstonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_COMPRESSED_STYXSTONE);
        BlockStateModelGenerator.BlockTexturePool polishedMabrizePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_MABRIZE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_AMETHYST_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_KUNZITE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_ELYSIUM_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_THERMIUM_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_MEMORY_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_PINLINE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_RAW_PINLINE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_CERILLE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_MOONSTEEL_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_SUNGAZE_BRICKS);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AMETHYST_BULB);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.KUNZITE_BULB);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ELYSIUM_BULB);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.THERMIUM_BULB);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MEMORY_BULB);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINLINE_BULB);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PINLINE_BULB);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CERILLE_BULB);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOONSTEEL_BULB);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SUNGAZE_BULB);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.AMETHYST_PARTERS, ModBlocks.POTTED_AMETHYST_PARTERS, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.KUNZITE_LOVELILY, ModBlocks.POTTED_KUNZITE_LOVELILY, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.ELYSIAN_SKYBERRY, ModBlocks.POTTED_ELYSIAN_SKYBERRY, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.THERMIUM_WILTBORN, ModBlocks.POTTED_THERMIUM_WILTBORN, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.MEMORIA_BOURPEER, ModBlocks.POTTED_MEMORIA_BOURPEER, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.CRYSTAL_CHERRY_SAPLING, ModBlocks.POTTED_CRYSTAL_CHERRY_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.CHORUS_SAPLING, ModBlocks.POTTED_CHORUS_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.HAZEWEAVER_PLANT, ModBlocks.POTTED_HAZEWEAVER_PLANT, BlockStateModelGenerator.CrossType.TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.SNOWY_SPRUCE_SAPLING, ModBlocks.POTTED_SNOWY_SPRUCE_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.KEAPHE_SAPLING, ModBlocks.POTTED_KEAPHE_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);

        crystalCherryPool.stairs(ModBlocks.CRYSTAL_CHERRY_STAIRS);
        crystalCherryPool.slab(ModBlocks.CRYSTAL_CHERRY_SLAB);
        crystalCherryPool.button(ModBlocks.CRYSTAL_CHERRY_BUTTON);
        crystalCherryPool.pressurePlate(ModBlocks.CRYSTAL_CHERRY_PRESSURE_PLATE);
        crystalCherryPool.fence(ModBlocks.CRYSTAL_CHERRY_FENCE);
        crystalCherryPool.fenceGate(ModBlocks.CRYSTAL_CHERRY_FENCE_GATE);
        blockStateModelGenerator.registerDoor(ModBlocks.CRYSTAL_CHERRY_DOOR);
        blockStateModelGenerator.registerOrientableTrapdoor(ModBlocks.CRYSTAL_CHERRY_TRAPDOOR);

        chorusPool.stairs(ModBlocks.CHORUS_STAIRS);
        chorusPool.slab(ModBlocks.CHORUS_SLAB);
        chorusPool.button(ModBlocks.CHORUS_BUTTON);
        chorusPool.pressurePlate(ModBlocks.CHORUS_PRESSURE_PLATE);
        chorusPool.fence(ModBlocks.CHORUS_FENCE);
        chorusPool.fenceGate(ModBlocks.CHORUS_FENCE_GATE);
        blockStateModelGenerator.registerDoor(ModBlocks.CHORUS_DOOR);
        blockStateModelGenerator.registerOrientableTrapdoor(ModBlocks.CHORUS_TRAPDOOR);

        ashenPool.stairs(ModBlocks.ASHEN_STAIRS);
        ashenPool.slab(ModBlocks.ASHEN_SLAB);
        ashenPool.button(ModBlocks.ASHEN_BUTTON);
        ashenPool.pressurePlate(ModBlocks.ASHEN_PRESSURE_PLATE);
        ashenPool.fence(ModBlocks.ASHEN_FENCE);
        ashenPool.fenceGate(ModBlocks.ASHEN_FENCE_GATE);
        blockStateModelGenerator.registerDoor(ModBlocks.ASHEN_DOOR);
        blockStateModelGenerator.registerOrientableTrapdoor(ModBlocks.ASHEN_TRAPDOOR);

        keaphePool.stairs(ModBlocks.KEAPHE_STAIRS);
        keaphePool.slab(ModBlocks.KEAPHE_SLAB);
        keaphePool.button(ModBlocks.KEAPHE_BUTTON);
        keaphePool.pressurePlate(ModBlocks.KEAPHE_PRESSURE_PLATE);
        keaphePool.fence(ModBlocks.KEAPHE_FENCE);
        keaphePool.fenceGate(ModBlocks.KEAPHE_FENCE_GATE);
        blockStateModelGenerator.registerDoor(ModBlocks.KEAPHE_DOOR);
        blockStateModelGenerator.registerOrientableTrapdoor(ModBlocks.KEAPHE_TRAPDOOR);

        polishedAmethystPool.stairs(ModBlocks.POLISHED_AMETHYST_STAIRS);
        polishedAmethystPool.slab(ModBlocks.POLISHED_AMETHYST_SLAB);
        polishedAmethystPool.wall(ModBlocks.POLISHED_AMETHYST_WALL);

        amethystBricksPool.stairs(ModBlocks.AMETHYST_BRICKS_STAIRS);
        amethystBricksPool.slab(ModBlocks.AMETHYST_BRICKS_SLAB);
        amethystBricksPool.wall(ModBlocks.AMETHYST_BRICKS_WALL);

        kunziteBricksPool.stairs(ModBlocks.KUNZITE_BRICKS_STAIRS);
        kunziteBricksPool.slab(ModBlocks.KUNZITE_BRICKS_SLAB);
        kunziteBricksPool.wall(ModBlocks.KUNZITE_BRICKS_WALL);

        elysiumBricksPool.stairs(ModBlocks.ELYSIUM_BRICKS_STAIRS);
        elysiumBricksPool.slab(ModBlocks.ELYSIUM_BRICKS_SLAB);
        elysiumBricksPool.wall(ModBlocks.ELYSIUM_BRICKS_WALL);

        thermiumBricksPool.stairs(ModBlocks.THERMIUM_BRICKS_STAIRS);
        thermiumBricksPool.slab(ModBlocks.THERMIUM_BRICKS_SLAB);
        thermiumBricksPool.wall(ModBlocks.THERMIUM_BRICKS_WALL);

        memoryBricksPool.stairs(ModBlocks.MEMORY_BRICKS_STAIRS);
        memoryBricksPool.slab(ModBlocks.MEMORY_BRICKS_SLAB);
        memoryBricksPool.wall(ModBlocks.MEMORY_BRICKS_WALL);

        pinlineBricksPool.stairs(ModBlocks.PINLINE_BRICKS_STAIRS);
        pinlineBricksPool.slab(ModBlocks.PINLINE_BRICKS_SLAB);
        pinlineBricksPool.wall(ModBlocks.PINLINE_BRICKS_WALL);

        rawPinlineBricksPool.stairs(ModBlocks.RAW_PINLINE_BRICKS_STAIRS);
        rawPinlineBricksPool.slab(ModBlocks.RAW_PINLINE_BRICKS_SLAB);
        rawPinlineBricksPool.wall(ModBlocks.RAW_PINLINE_BRICKS_WALL);

        compressedEndStonePool.stairs(ModBlocks.COMPRESSED_END_STONE_BRICKS_STAIRS);
        compressedEndStonePool.slab(ModBlocks.COMPRESSED_END_STONE_BRICKS_SLAB);
        compressedEndStonePool.wall(ModBlocks.COMPRESSED_END_STONE_BRICKS_WALL);

        compressedStyxstoneBricksPool.stairs(ModBlocks.COMPRESSED_STYXSTONE_BRICKS_STAIRS);
        compressedStyxstoneBricksPool.slab(ModBlocks.COMPRESSED_STYXSTONE_BRICKS_SLAB);
        compressedStyxstoneBricksPool.wall(ModBlocks.COMPRESSED_STYXSTONE_BRICKS_WALL);
        polishedCompressedStyxstonePool.stairs(ModBlocks.POLISHED_COMPRESSED_STYXSTONE_STAIRS);
        polishedCompressedStyxstonePool.slab(ModBlocks.POLISHED_COMPRESSED_STYXSTONE_SLAB);
        polishedCompressedStyxstonePool.wall(ModBlocks.POLISHED_COMPRESSED_STYXSTONE_WALL);

        styxstoneBricksPool.stairs(ModBlocks.STYXSTONE_BRICKS_STAIRS);
        styxstoneBricksPool.slab(ModBlocks.STYXSTONE_BRICKS_SLAB);
        styxstoneBricksPool.wall(ModBlocks.STYXSTONE_BRICKS_WALL);
        polishedStyxstonePool.stairs(ModBlocks.POLISHED_STYXSTONE_STAIRS);
        polishedStyxstonePool.slab(ModBlocks.POLISHED_STYXSTONE_SLAB);
        polishedStyxstonePool.wall(ModBlocks.POLISHED_STYXSTONE_WALL);
        cobbledStyxstonePool.stairs(ModBlocks.COBBLED_STYXSTONE_STAIRS);
        cobbledStyxstonePool.slab(ModBlocks.COBBLED_STYXSTONE_SLAB);
        cobbledStyxstonePool.wall(ModBlocks.COBBLED_STYXSTONE_WALL);
        mossyCobbledStyxstonePool.stairs(ModBlocks.MOSSY_COBBLED_STYXSTONE_STAIRS);
        mossyCobbledStyxstonePool.slab(ModBlocks.MOSSY_COBBLED_STYXSTONE_SLAB);
        mossyCobbledStyxstonePool.wall(ModBlocks.MOSSY_COBBLED_STYXSTONE_WALL);

        mabrizeBricksPool.stairs(ModBlocks.MABRIZE_BRICKS_STAIRS);
        mabrizeBricksPool.slab(ModBlocks.MABRIZE_BRICKS_SLAB);
        mabrizeBricksPool.wall(ModBlocks.MABRIZE_BRICKS_WALL);
        polishedMabrizePool.stairs(ModBlocks.POLISHED_MABRIZE_STAIRS);
        polishedMabrizePool.slab(ModBlocks.POLISHED_MABRIZE_SLAB);
        polishedMabrizePool.wall(ModBlocks.POLISHED_MABRIZE_WALL);

        moonsteelBricksPool.stairs(ModBlocks.MOONSTEEL_BRICKS_STAIRS);
        moonsteelBricksPool.slab(ModBlocks.MOONSTEEL_BRICKS_SLAB);
        moonsteelBricksPool.wall(ModBlocks.MOONSTEEL_BRICKS_WALL);

        cerilleBricksPool.stairs(ModBlocks.CERILLE_BRICKS_STAIRS);
        cerilleBricksPool.slab(ModBlocks.CERILLE_BRICKS_SLAB);
        cerilleBricksPool.wall(ModBlocks.CERILLE_BRICKS_WALL);

        sungazeBricksPool.stairs(ModBlocks.SUNGAZE_BRICKS_STAIRS);
        sungazeBricksPool.slab(ModBlocks.SUNGAZE_BRICKS_SLAB);
        sungazeBricksPool.wall(ModBlocks.SUNGAZE_BRICKS_WALL);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_SAND);
        pinkSandstonePool.stairs(ModBlocks.PINK_SANDSTONE_STAIRS);
        pinkSandstonePool.slab(ModBlocks.PINK_SANDSTONE_SLAB);
        pinkSandstonePool.wall(ModBlocks.PINK_SANDSTONE_WALL);
        cutPinkSandstonePool.slab(ModBlocks.CUT_PINK_SANDSTONE_SLAB);
        smoothPinkSandstonePool.stairs(ModBlocks.SMOOTH_PINK_SANDSTONE_STAIRS);
        smoothPinkSandstonePool.slab(ModBlocks.SMOOTH_PINK_SANDSTONE_SLAB);
        blockStateModelGenerator.registerSimpleState(ModBlocks.CHISELED_PINK_SANDSTONE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COMPRESSED_END_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_ICE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.KUNZITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_KUNZITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.KUNZITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_KUNZITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AMETHYST_KUNZITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ELYSIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.THERMIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_THERMIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.THERMIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_THERMIUM_ORE);
        blockStateModelGenerator.registerSimpleState(ModBlocks.NETHER_SULFUR_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SULFUR_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_PINLINE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COMPRESSED_END_PINLINE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PINLINE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINLINE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLACK_GOOP);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CORRUPT_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STYXSTONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STYXIAN_SOIL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MABRIZE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COMPRESSED_STYXSTONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STYXIAN_AMETHYST_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COMPRESSED_STYXIAN_AMETHYST_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COMPRESSED_STYXIAN_STYXCOAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STYXIAN_STYXCOAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STYXCOAL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COMPRESSED_STYXIAN_MOONSTEEL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STYXIAN_MOONSTEEL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COMPRESSED_STYXIAN_LAPIS_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STYXIAN_LAPIS_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOONSTEEL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_MOONSTEEL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CERILLE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COMPRESSED_STYXIAN_SUNGAZE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STYXIAN_SUNGAZE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SUNGAZE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRAWLER_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRAWLER_DEEPSLATE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRAWLER_NETHERRACK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRAWLER_STYXSTONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRAWLER_COMPRESSED_STYXSTONE);

        blockStateModelGenerator.registerFlowerbed(ModBlocks.DEATH_FLOWERS);
        blockStateModelGenerator.registerWoolAndCarpet(ModBlocks.STYXMOSS, ModBlocks.STYXMOSS_CARPET);
        blockStateModelGenerator.registerHangingMoss(ModBlocks.HANGING_STYXGRASS);

        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.AMETHYST_CLUMP);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.DIAMOND_CLUMP);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.EMERALD_CLUMP);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.KUNZITE_CLUMP);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.THERMIUM_CLUMP);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.QUARTZ_CLUMP);
        blockStateModelGenerator.registerMultifaceBlockModel(ModBlocks.CORRUPTION_CLUMP);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.STYXMOSS_VINE);

        blockStateModelGenerator.registerRod(ModBlocks.KUNZITE_ROD);
        blockStateModelGenerator.registerRod(ModBlocks.ELYSIUM_ROD);
        blockStateModelGenerator.registerRod(ModBlocks.AMETHYST_ROD);
        blockStateModelGenerator.registerRod(ModBlocks.THERMIUM_ROD);
        blockStateModelGenerator.registerRod(ModBlocks.PINLINE_ROD);
        blockStateModelGenerator.registerRod(ModBlocks.RAW_PINLINE_ROD);

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.THERMIUM_BLASTER);
        blockStateModelGenerator.registerLantern(ModBlocks.MOONSTEEL_LANTERN);
        blockStateModelGenerator.registerSingleton(ModBlocks.CRYSTAL_CHERRY_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerSingleton(ModBlocks.CHORUS_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerSingleton(ModBlocks.SNOWY_SPRUCE_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerSingleton(ModBlocks.KEAPHE_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerSingleton(ModBlocks.FLOWERING_KEAPHE_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.GEM_BERRY_BUSH, BlockStateModelGenerator.CrossType.NOT_TINTED,
                GemBerryBushBlock.AGE, 0, 1, 2, 3);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.CHARMBERRY_BUSH, BlockStateModelGenerator.CrossType.NOT_TINTED,
                GemBerryBushBlock.AGE, 0, 1, 2, 3);

        blockStateModelGenerator.registerTintableCross(ModBlocks.SMALL_END_GRASS, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.MEDIUM_END_GRASS, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.LARGE_END_GRASS, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.CHORUS_LILY, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.STYXGRASS, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.CORRUPT_ROOTS, BlockStateModelGenerator.CrossType.NOT_TINTED);

        blockStateModelGenerator.createLogTexturePool(ModBlocks.CRYSTAL_CHERRY_LOG).log(ModBlocks.CRYSTAL_CHERRY_LOG).wood(ModBlocks.CRYSTAL_CHERRY_WOOD);
        blockStateModelGenerator.createLogTexturePool(ModBlocks.STRIPPED_CRYSTAL_CHERRY_LOG).log(ModBlocks.STRIPPED_CRYSTAL_CHERRY_LOG).wood(ModBlocks.STRIPPED_CRYSTAL_CHERRY_WOOD);
        blockStateModelGenerator.createLogTexturePool(ModBlocks.CHORUS_LOG).log(ModBlocks.CHORUS_LOG).wood(ModBlocks.CHORUS_WOOD);
        blockStateModelGenerator.createLogTexturePool(ModBlocks.STRIPPED_CHORUS_LOG).log(ModBlocks.STRIPPED_CHORUS_LOG).wood(ModBlocks.STRIPPED_CHORUS_WOOD);
        blockStateModelGenerator.createLogTexturePool(ModBlocks.ENERGIZED_THERMIUM_BLOCK).log(ModBlocks.ENERGIZED_THERMIUM_BLOCK);
        blockStateModelGenerator.createLogTexturePool(ModBlocks.ASHEN_LOG).log(ModBlocks.ASHEN_LOG).wood(ModBlocks.ASHEN_WOOD);
        blockStateModelGenerator.createLogTexturePool(ModBlocks.STRIPPED_ASHEN_LOG).log(ModBlocks.STRIPPED_ASHEN_LOG).wood(ModBlocks.STRIPPED_ASHEN_WOOD);
        blockStateModelGenerator.createLogTexturePool(ModBlocks.KEAPHE_LOG).log(ModBlocks.KEAPHE_LOG).wood(ModBlocks.KEAPHE_WOOD);
        blockStateModelGenerator.createLogTexturePool(ModBlocks.STRIPPED_KEAPHE_LOG).log(ModBlocks.STRIPPED_KEAPHE_LOG).wood(ModBlocks.STRIPPED_KEAPHE_WOOD);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CRAWLER_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORRUPTED_ZOMBIE_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORRUPTED_SKELETON_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.AMETHYST_BLAZE_SPAWN_EGG, Models.GENERATED);

        itemModelGenerator.register(ModItems.AMETHYST_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIAMOND_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.QUARTZ_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.EMERALD_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHERITE_NUGGET, Models.GENERATED);

        itemModelGenerator.register(ModItems.AMETHYST_BLAZE_ROD, Models.GENERATED);

        itemModelGenerator.register(ModItems.SULFUR, Models.GENERATED);
        itemModelGenerator.register(ModItems.STYXCOAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.MOONSTEEL_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.MOONSTEEL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.MOONSTEEL_CHAIN.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_MOONSTEEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.CERILLE_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.CERILLE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SUNGAZE_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.SUNGAZE, Models.GENERATED);

        itemModelGenerator.register(ModItems.CORRUPT_DROPLET, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORRUPT_MASS, Models.GENERATED);

        itemModelGenerator.register(ModItems.KUNZITE_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.KUNZITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_KUNZITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRYSTAL_GLITTER, Models.GENERATED);

        itemModelGenerator.register(ModItems.ELYSIUM_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.ELYSIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ELYSIAN_REDSTONE_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PINK_BITS, Models.GENERATED);

        itemModelGenerator.register(ModItems.PINLINE_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.PINLINE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_PINLINE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PREPARED_PINLINE, Models.GENERATED);

        itemModelGenerator.register(ModItems.GLAZED_CHORUS_FRUIT, Models.GENERATED);
        itemModelGenerator.register(ModItems.COAL_MEAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.GELATINOUS_BUD, Models.GENERATED);
        itemModelGenerator.register(ModItems.ELYSIUM_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GODFRUIT, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRYSTAL_CARROT, Models.GENERATED);

        itemModelGenerator.register(ModItems.THERMIUM_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.THERMIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_THERMIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENERGIZED_THERMIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.MEMORY_SHARD, Models.GENERATED);

        itemModelGenerator.register(ModItems.KUNZITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.KUNZITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.KUNZITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.KUNZITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.KUNZITE_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.PINLINE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINLINE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINLINE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINLINE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINLINE_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.ELYSIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ELYSIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ELYSIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ELYSIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ELYSIUM_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ELYSIUM_HAMMER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.MOONSTEEL_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MOONSTEEL_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MOONSTEEL_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MOONSTEEL_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MOONSTEEL_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.CERILLE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CERILLE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CERILLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CERILLE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CERILLE_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.SUNBLAZE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SUNBLAZE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SUNBLAZE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SUNBLAZE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SUNBLAZE_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.BEDROCK_BREAKER, Models.HANDHELD);

        itemModelGenerator.register(ModBlocks.CRYSTAL_CHERRY_SAPLING.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.KEAPHE_SAPLING.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.CHORUS_SAPLING.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.SNOWY_SPRUCE_SAPLING.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.AMETHYST_PARTERS.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.KUNZITE_LOVELILY.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.ELYSIAN_SKYBERRY.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.THERMIUM_WILTBORN.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.MEMORIA_BOURPEER.asItem(), Models.GENERATED);

        itemModelGenerator.register(ModItems.HAZEWEAVER, Models.GENERATED);

        itemModelGenerator.register(ModItems.CHERRY_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOOM_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SWORDMASTER_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SHATTER_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CREEPER_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHESS_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.WANDERER_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SHELL_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.WINGFLAP_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.OVERGROWTH_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORRUPTION_SMITHING_TEMPLATE, Models.GENERATED);

        itemModelGenerator.registerArmor(ModItems.KUNZITE_HELMET,
                ModArmorMaterials.KUNZITE_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.KUNZITE_CHESTPLATE,
                ModArmorMaterials.KUNZITE_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.KUNZITE_LEGGINGS,
                ModArmorMaterials.KUNZITE_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.KUNZITE_BOOTS,
                ModArmorMaterials.KUNZITE_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);

        itemModelGenerator.registerArmor(ModItems.PINLINE_HELMET,
                ModArmorMaterials.PINLINE_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.PINLINE_CHESTPLATE,
                ModArmorMaterials.PINLINE_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.PINLINE_LEGGINGS,
                ModArmorMaterials.PINLINE_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.PINLINE_BOOTS,
                ModArmorMaterials.PINLINE_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);

        itemModelGenerator.registerArmor(ModItems.ELYSIUM_HELMET,
                ModArmorMaterials.ELYSIUM_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.ELYSIUM_CHESTPLATE,
                ModArmorMaterials.ELYSIUM_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.ELYSIUM_LEGGINGS,
                ModArmorMaterials.ELYSIUM_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.ELYSIUM_BOOTS,
                ModArmorMaterials.ELYSIUM_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);

        itemModelGenerator.registerArmor(ModItems.MOONSTEEL_HELMET,
                ModArmorMaterials.MOONSTEEL_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.MOONSTEEL_CHESTPLATE,
                ModArmorMaterials.MOONSTEEL_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.MOONSTEEL_LEGGINGS,
                ModArmorMaterials.MOONSTEEL_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.MOONSTEEL_BOOTS,
                ModArmorMaterials.MOONSTEEL_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);

        itemModelGenerator.registerArmor(ModItems.CERILLE_HELMET,
                ModArmorMaterials.CERILLE_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.CERILLE_CHESTPLATE,
                ModArmorMaterials.CERILLE_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.CERILLE_LEGGINGS,
                ModArmorMaterials.CERILLE_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.CERILLE_BOOTS,
                ModArmorMaterials.CERILLE_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);

        itemModelGenerator.registerArmor(ModItems.SUNBLAZE_HELMET,
                ModArmorMaterials.SUNBLAZE_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.SUNBLAZE_CHESTPLATE,
                ModArmorMaterials.SUNBLAZE_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.SUNBLAZE_LEGGINGS,
                ModArmorMaterials.SUNBLAZE_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.SUNBLAZE_BOOTS,
                ModArmorMaterials.SUNBLAZE_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);
    }
}
