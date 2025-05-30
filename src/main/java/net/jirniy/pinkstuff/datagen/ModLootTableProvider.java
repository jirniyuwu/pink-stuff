package net.jirniy.pinkstuff.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.item.ModItems;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.KUNZITE_BLOCK);
        addDrop(ModBlocks.RAW_KUNZITE_BLOCK);
        addDrop(ModBlocks.ELYSIUM_BLOCK);
        addDrop(ModBlocks.KUNZITE_ORE, oreDrops(ModBlocks.KUNZITE_ORE, ModItems.RAW_KUNZITE));
        addDrop(ModBlocks.DEEPSLATE_KUNZITE_ORE, oreDrops(ModBlocks.DEEPSLATE_KUNZITE_ORE, ModItems.RAW_KUNZITE));
    }
}
