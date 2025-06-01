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

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRYSTAL_CHERRY_PLANKS);
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
