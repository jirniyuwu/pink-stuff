package net.jirniy.pinkstuff.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.item.ModArmorMaterials;
import net.jirniy.pinkstuff.item.ModItems;
import net.jirniy.pinkstuff.item.custom.ModArmorItem;
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
        BlockStateModelGenerator.BlockTexturePool crystalCherryPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CRYSTAL_CHERRY_PLANKS);
        BlockStateModelGenerator.BlockTexturePool polishedAmethystPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_AMETHYST_BLOCK);
        BlockStateModelGenerator.BlockTexturePool amethystBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.AMETHYST_BRICKS);
        BlockStateModelGenerator.BlockTexturePool kunziteBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.KUNZITE_BRICKS);
        BlockStateModelGenerator.BlockTexturePool elysiumBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ELYSIUM_BRICKS);
        BlockStateModelGenerator.BlockTexturePool thermiumBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.THERMIUM_BRICKS);

        crystalCherryPool.stairs(ModBlocks.CRYSTAL_CHERRY_STAIRS);
        crystalCherryPool.slab(ModBlocks.CRYSTAL_CHERRY_SLAB);
        crystalCherryPool.button(ModBlocks.CRYSTAL_CHERRY_BUTTON);
        crystalCherryPool.pressurePlate(ModBlocks.CRYSTAL_CHERRY_PRESSURE_PLATE);
        crystalCherryPool.fence(ModBlocks.CRYSTAL_CHERRY_FENCE);
        crystalCherryPool.fenceGate(ModBlocks.CRYSTAL_CHERRY_FENCE_GATE);
        blockStateModelGenerator.registerDoor(ModBlocks.CRYSTAL_CHERRY_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.CRYSTAL_CHERRY_TRAPDOOR);

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

        blockStateModelGenerator.registerSingleton(ModBlocks.CRYSTAL_CHERRY_LEAVES, TexturedModel.LEAVES);

        blockStateModelGenerator.createLogTexturePool(ModBlocks.CRYSTAL_CHERRY_LOG).log(ModBlocks.CRYSTAL_CHERRY_LOG).wood(ModBlocks.CRYSTAL_CHERRY_WOOD);
        blockStateModelGenerator.createLogTexturePool(ModBlocks.STRIPPED_CRYSTAL_CHERRY_LOG).log(ModBlocks.STRIPPED_CRYSTAL_CHERRY_LOG).wood(ModBlocks.STRIPPED_CRYSTAL_CHERRY_WOOD);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.CRYSTAL_CHERRY_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.KUNZITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_KUNZITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRYSTAL_GLITTER, Models.GENERATED);
        itemModelGenerator.register(ModItems.ELYSIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ELYSIAN_REDSTONE_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PINK_BITS, Models.GENERATED);

        itemModelGenerator.register(ModItems.GELATINOUS_BUD, Models.GENERATED);
        itemModelGenerator.register(ModItems.ELYSIUM_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRYSTAL_CARROT, Models.GENERATED);
        itemModelGenerator.register(ModItems.GEM_BERRY, Models.GENERATED);

        itemModelGenerator.register(ModItems.THERMIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_THERMIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.MEMORY_SHARD, Models.GENERATED);

        itemModelGenerator.register(ModItems.KUNZITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.KUNZITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.KUNZITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.KUNZITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.KUNZITE_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.ELYSIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ELYSIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ELYSIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ELYSIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ELYSIUM_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ELYSIUM_HAMMER, Models.HANDHELD);

        itemModelGenerator.register(ModBlocks.CRYSTAL_CHERRY_SAPLING.asItem(), Models.GENERATED);

        itemModelGenerator.registerArmor(ModItems.KUNZITE_HELMET,
                ModArmorMaterials.KUNZITE_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.KUNZITE_CHESTPLATE,
                ModArmorMaterials.KUNZITE_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.KUNZITE_LEGGINGS,
                ModArmorMaterials.KUNZITE_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.KUNZITE_BOOTS,
                ModArmorMaterials.KUNZITE_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);

        itemModelGenerator.registerArmor(ModItems.ELYSIUM_HELMET,
                ModArmorMaterials.ELYSIUM_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.ELYSIUM_CHESTPLATE,
                ModArmorMaterials.ELYSIUM_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.ELYSIUM_LEGGINGS,
                ModArmorMaterials.ELYSIUM_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.ELYSIUM_BOOTS,
                ModArmorMaterials.ELYSIUM_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);


    }
}
