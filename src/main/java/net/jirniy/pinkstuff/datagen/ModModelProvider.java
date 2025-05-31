package net.jirniy.pinkstuff.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.item.ModItems;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

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
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ELYSIUM_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.KUNZITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_KUNZITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRYSTAL_GLITTER, Models.GENERATED);
        itemModelGenerator.register(ModItems.ELYSIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ELYSIAN_REDSTONE_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PINK_BITS, Models.GENERATED);

        itemModelGenerator.register(ModItems.KUNZITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.KUNZITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.KUNZITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.KUNZITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.KUNZITE_HOE, Models.HANDHELD);
    }
}
