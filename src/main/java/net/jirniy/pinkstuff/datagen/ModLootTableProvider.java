package net.jirniy.pinkstuff.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.block.custom.GemBerryBushBlock;
import net.jirniy.pinkstuff.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);

        addDrop(ModBlocks.DISPLAY);
        addDrop(ModBlocks.THERMIUM_BLASTER);
        addDropWithSilkTouch(ModBlocks.PINK_ICE);

        addDrop(ModBlocks.KUNZITE_BLOCK);
        addDrop(ModBlocks.RAW_KUNZITE_BLOCK);
        addDrop(ModBlocks.ELYSIUM_BLOCK);
        addDrop(ModBlocks.THERMIUM_BLOCK);
        addDrop(ModBlocks.RAW_THERMIUM_BLOCK);
        addDrop(ModBlocks.ENERGIZED_THERMIUM_BLOCK);
        addDrop(ModBlocks.SULFUR_BLOCK);

        addDrop(ModBlocks.POLISHED_AMETHYST_BLOCK);
        addDrop(ModBlocks.AMETHYST_BRICKS);
        addDrop(ModBlocks.KUNZITE_BRICKS);
        addDrop(ModBlocks.ELYSIUM_BRICKS);
        addDrop(ModBlocks.THERMIUM_BRICKS);
        addDrop(ModBlocks.MEMORY_BRICKS);

        addDrop(ModBlocks.CHISELED_AMETHYST_BRICKS);
        addDrop(ModBlocks.CHISELED_KUNZITE_BRICKS);
        addDrop(ModBlocks.CHISELED_ELYSIUM_BRICKS);
        addDrop(ModBlocks.CHISELED_THERMIUM_BRICKS);
        addDrop(ModBlocks.CHISELED_MEMORY_BRICKS);

        addDrop(ModBlocks.AMETHYST_BULB);
        addDrop(ModBlocks.KUNZITE_BULB);
        addDrop(ModBlocks.ELYSIUM_BULB);
        addDrop(ModBlocks.THERMIUM_BULB);
        addDrop(ModBlocks.MEMORY_BULB);

        addDrop(ModBlocks.POLISHED_AMETHYST_STAIRS);
        addDrop(ModBlocks.AMETHYST_BRICKS_STAIRS);
        addDrop(ModBlocks.KUNZITE_BRICKS_STAIRS);
        addDrop(ModBlocks.ELYSIUM_BRICKS_STAIRS);
        addDrop(ModBlocks.THERMIUM_BRICKS_STAIRS);
        addDrop(ModBlocks.MEMORY_BRICKS_STAIRS);

        addDrop(ModBlocks.POLISHED_AMETHYST_SLAB, slabDrops(ModBlocks.POLISHED_AMETHYST_SLAB));
        addDrop(ModBlocks.AMETHYST_BRICKS_SLAB, slabDrops(ModBlocks.AMETHYST_BRICKS_SLAB));
        addDrop(ModBlocks.KUNZITE_BRICKS_SLAB, slabDrops(ModBlocks.KUNZITE_BRICKS_SLAB));
        addDrop(ModBlocks.ELYSIUM_BRICKS_SLAB, slabDrops(ModBlocks.ELYSIUM_BRICKS_SLAB));
        addDrop(ModBlocks.THERMIUM_BRICKS_SLAB, slabDrops(ModBlocks.THERMIUM_BRICKS_SLAB));
        addDrop(ModBlocks.MEMORY_BRICKS_SLAB, slabDrops(ModBlocks.MEMORY_BRICKS_SLAB));

        addDrop(ModBlocks.POLISHED_AMETHYST_WALL);
        addDrop(ModBlocks.AMETHYST_BRICKS_WALL);
        addDrop(ModBlocks.KUNZITE_BRICKS_WALL);
        addDrop(ModBlocks.ELYSIUM_BRICKS_WALL);
        addDrop(ModBlocks.THERMIUM_BRICKS_WALL);
        addDrop(ModBlocks.MEMORY_BRICKS_WALL);

        addDrop(ModBlocks.KUNZITE_ORE, oreDrops(ModBlocks.KUNZITE_ORE, ModItems.RAW_KUNZITE));
        addDrop(ModBlocks.DEEPSLATE_KUNZITE_ORE, oreDrops(ModBlocks.DEEPSLATE_KUNZITE_ORE, ModItems.RAW_KUNZITE));
        addDrop(ModBlocks.AMETHYST_KUNZITE_ORE, multipleOreDrops(ModBlocks.AMETHYST_KUNZITE_ORE, ModItems.PINK_BITS, 4, 10));
        addDrop(ModBlocks.THERMIUM_ORE, multipleOreDrops(ModBlocks.THERMIUM_ORE, ModItems.RAW_THERMIUM, 1, 2));
        addDrop(ModBlocks.DEEPSLATE_THERMIUM_ORE, multipleOreDrops(ModBlocks.DEEPSLATE_THERMIUM_ORE, ModItems.RAW_THERMIUM, 1, 3));
        addDrop(ModBlocks.NETHER_SULFUR_ORE, oreDrops(ModBlocks.NETHER_SULFUR_ORE, ModItems.SULFUR));

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

        addDrop(ModBlocks.CRYSTAL_CHERRY_LEAVES, multipleOreDrops(ModBlocks.CRYSTAL_CHERRY_LEAVES, ModItems.PINK_BITS, 0, 1));

        addDrop(ModBlocks.CHORUS_LOG);
        addDrop(ModBlocks.CHORUS_WOOD);
        addDrop(ModBlocks.STRIPPED_CHORUS_LOG);
        addDrop(ModBlocks.STRIPPED_CHORUS_WOOD);
        addDrop(ModBlocks.CHORUS_PLANKS);
        addDrop(ModBlocks.CHORUS_SAPLING);

        addDrop(ModBlocks.CHORUS_LEAVES, leavesDrops(ModBlocks.CHORUS_LEAVES, ModBlocks.CHORUS_SAPLING, 0.02f));

        addPottedPlantDrops(ModBlocks.POTTED_MEMORIA_BOURPEER);
        addPottedPlantDrops(ModBlocks.POTTED_THERMIUM_WILTBORN);
        addPottedPlantDrops(ModBlocks.POTTED_ELYSIAN_SKYBERRY);
        addPottedPlantDrops(ModBlocks.POTTED_KUNZITE_LOVELILY);
        addPottedPlantDrops(ModBlocks.POTTED_AMETHYST_PARTERS);
        addPottedPlantDrops(ModBlocks.POTTED_CRYSTAL_CHERRY_SAPLING);
        addPottedPlantDrops(ModBlocks.POTTED_CHORUS_SAPLING);

        addDrop(ModBlocks.AMETHYST_PARTERS);
        addDrop(ModBlocks.KUNZITE_LOVELILY);
        addDrop(ModBlocks.ELYSIAN_SKYBERRY);
        addDrop(ModBlocks.THERMIUM_WILTBORN);
        addDrop(ModBlocks.MEMORIA_BOURPEER);
        addDrop(ModBlocks.HAZEWEAVER_PLANT, ModItems.HAZEWEAVER);

        addDropWithSilkTouch(ModBlocks.SMALL_END_GRASS);
        addDropWithSilkTouch(ModBlocks.MEDIUM_END_GRASS);
        addDropWithSilkTouch(ModBlocks.LARGE_END_GRASS);
        addDrop(ModBlocks.CHORUS_LILY);

        addDrop(Blocks.LARGE_AMETHYST_BUD, multipleOreDrops(Blocks.LARGE_AMETHYST_BUD, ModItems.AMETHYST_NUGGET, 2, 8));
        addDrop(Blocks.MEDIUM_AMETHYST_BUD, multipleOreDrops(Blocks.MEDIUM_AMETHYST_BUD, ModItems.AMETHYST_NUGGET, 0, 3));

        this.addDrop(ModBlocks.GEM_BERRY_BUSH,
                block -> this.applyExplosionDecay(
                        block,LootTable.builder().pool(LootPool.builder().conditionally(
                                                BlockStatePropertyLootCondition.builder(ModBlocks.GEM_BERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(GemBerryBushBlock.AGE, 3))
                                        )
                                        .with(ItemEntry.builder(ModItems.GEM_BERRY))
                                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F)))
                                        .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                        ).pool(LootPool.builder().conditionally(
                                        BlockStatePropertyLootCondition.builder(ModBlocks.GEM_BERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(GemBerryBushBlock.AGE, 2))
                                ).with(ItemEntry.builder(ModItems.GEM_BERRY))
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
                                .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE))))));
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
