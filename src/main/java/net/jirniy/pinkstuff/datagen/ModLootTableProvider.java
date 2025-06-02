package net.jirniy.pinkstuff.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
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
        addDrop(ModBlocks.THERMIUM_BLOCK);
        addDrop(ModBlocks.RAW_THERMIUM_BLOCK);

        addDrop(ModBlocks.POLISHED_AMETHYST_BLOCK);
        addDrop(ModBlocks.AMETHYST_BRICKS);
        addDrop(ModBlocks.KUNZITE_BRICKS);
        addDrop(ModBlocks.ELYSIUM_BRICKS);
        addDrop(ModBlocks.THERMIUM_BRICKS);

        addDrop(ModBlocks.POLISHED_AMETHYST_STAIRS);
        addDrop(ModBlocks.AMETHYST_BRICKS_STAIRS);
        addDrop(ModBlocks.KUNZITE_BRICKS_STAIRS);
        addDrop(ModBlocks.ELYSIUM_BRICKS_STAIRS);
        addDrop(ModBlocks.THERMIUM_BRICKS_STAIRS);

        addDrop(ModBlocks.POLISHED_AMETHYST_SLAB, slabDrops(ModBlocks.POLISHED_AMETHYST_SLAB));
        addDrop(ModBlocks.AMETHYST_BRICKS_SLAB, slabDrops(ModBlocks.AMETHYST_BRICKS_SLAB));
        addDrop(ModBlocks.KUNZITE_BRICKS_SLAB, slabDrops(ModBlocks.KUNZITE_BRICKS_SLAB));
        addDrop(ModBlocks.ELYSIUM_BRICKS_SLAB, slabDrops(ModBlocks.ELYSIUM_BRICKS_SLAB));
        addDrop(ModBlocks.THERMIUM_BRICKS_SLAB, slabDrops(ModBlocks.THERMIUM_BRICKS_SLAB));

        addDrop(ModBlocks.POLISHED_AMETHYST_WALL);
        addDrop(ModBlocks.AMETHYST_BRICKS_WALL);
        addDrop(ModBlocks.KUNZITE_BRICKS_WALL);
        addDrop(ModBlocks.ELYSIUM_BRICKS_WALL);
        addDrop(ModBlocks.THERMIUM_BRICKS_WALL);

        addDrop(ModBlocks.KUNZITE_ORE, oreDrops(ModBlocks.KUNZITE_ORE, ModItems.RAW_KUNZITE));
        addDrop(ModBlocks.DEEPSLATE_KUNZITE_ORE, oreDrops(ModBlocks.DEEPSLATE_KUNZITE_ORE, ModItems.RAW_KUNZITE));
        addDrop(ModBlocks.AMETHYST_KUNZITE_ORE, multipleOreDrops(ModBlocks.AMETHYST_KUNZITE_ORE, ModItems.PINK_BITS, 6, 19));
        addDrop(ModBlocks.THERMIUM_ORE, multipleOreDrops(ModBlocks.THERMIUM_ORE, ModItems.RAW_THERMIUM, 2, 3));
        addDrop(ModBlocks.DEEPSLATE_THERMIUM_ORE, multipleOreDrops(ModBlocks.DEEPSLATE_THERMIUM_ORE, ModItems.RAW_THERMIUM, 2, 4));

        addDrop(ModBlocks.CRYSTAL_CHERRY_LOG);
        addDrop(ModBlocks.CRYSTAL_CHERRY_WOOD);
        addDrop(ModBlocks.STRIPPED_CRYSTAL_CHERRY_LOG);
        addDrop(ModBlocks.STRIPPED_CRYSTAL_CHERRY_WOOD);
        addDrop(ModBlocks.CRYSTAL_CHERRY_PLANKS);
        addDrop(ModBlocks.CRYSTAL_CHERRY_SAPLING);

        addDrop(ModBlocks.CRYSTAL_CHERRY_SLAB, slabDrops(ModBlocks.CRYSTAL_CHERRY_SLAB));
        addDrop(ModBlocks.CRYSTAL_CHERRY_STAIRS);
        addDrop(ModBlocks.CRYSTAL_CHERRY_FENCE);
        addDrop(ModBlocks.CRYSTAL_CHERRY_FENCE_GATE);
        addDrop(ModBlocks.CRYSTAL_CHERRY_DOOR, doorDrops(ModBlocks.CRYSTAL_CHERRY_DOOR));
        addDrop(ModBlocks.CRYSTAL_CHERRY_TRAPDOOR);
        addDrop(ModBlocks.CRYSTAL_CHERRY_BUTTON);
        addDrop(ModBlocks.CRYSTAL_CHERRY_PRESSURE_PLATE);

        addDrop(ModBlocks.CRYSTAL_CHERRY_LEAVES, multipleOreDrops(ModBlocks.CRYSTAL_CHERRY_LEAVES, ModItems.PINK_BITS, 1, 3));
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
