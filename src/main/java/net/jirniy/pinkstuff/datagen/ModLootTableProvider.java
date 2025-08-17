package net.jirniy.pinkstuff.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.block.custom.GemBerryBushBlock;
import net.jirniy.pinkstuff.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MultifaceBlock;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.TableBonusLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.Direction;

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
        addDrop(ModBlocks.COMPRESSED_END_STONE);
        addDrop(ModBlocks.MOONSTEEL_LANTERN);
        addDrop(ModBlocks.MOONSTEEL_CHAIN);

        addDrop(ModBlocks.KUNZITE_BLOCK);
        addDrop(ModBlocks.RAW_KUNZITE_BLOCK);
        addDrop(ModBlocks.ELYSIUM_BLOCK);
        addDrop(ModBlocks.THERMIUM_BLOCK);
        addDrop(ModBlocks.RAW_THERMIUM_BLOCK);
        addDrop(ModBlocks.ENERGIZED_THERMIUM_BLOCK);
        addDrop(ModBlocks.SULFUR_BLOCK);
        addDrop(ModBlocks.PINLINE_BLOCK);
        addDrop(ModBlocks.RAW_PINLINE_BLOCK);

        addDrop(ModBlocks.POLISHED_AMETHYST_BLOCK);
        addDrop(ModBlocks.AMETHYST_BRICKS);
        addDrop(ModBlocks.KUNZITE_BRICKS);
        addDrop(ModBlocks.ELYSIUM_BRICKS);
        addDrop(ModBlocks.THERMIUM_BRICKS);
        addDrop(ModBlocks.MEMORY_BRICKS);
        addDrop(ModBlocks.PINLINE_BRICKS);
        addDrop(ModBlocks.RAW_PINLINE_BRICKS);
        addDrop(ModBlocks.COMPRESSED_END_STONE_BRICKS);
        addDrop(ModBlocks.STYXSTONE_BRICKS);
        addDrop(ModBlocks.COMPRESSED_STYXSTONE_BRICKS);
        addDrop(ModBlocks.MABRIZE_BRICKS);
        addDrop(ModBlocks.MOONSTEEL_BRICKS);
        addDrop(ModBlocks.CERILLE_BRICKS);

        addDrop(ModBlocks.CHISELED_AMETHYST_BRICKS);
        addDrop(ModBlocks.CHISELED_KUNZITE_BRICKS);
        addDrop(ModBlocks.CHISELED_ELYSIUM_BRICKS);
        addDrop(ModBlocks.CHISELED_THERMIUM_BRICKS);
        addDrop(ModBlocks.CHISELED_MEMORY_BRICKS);
        addDrop(ModBlocks.CHISELED_PINLINE_BRICKS);
        addDrop(ModBlocks.CHISELED_RAW_PINLINE_BRICKS);
        addDrop(ModBlocks.CHISELED_MOONSTEEL_BRICKS);
        addDrop(ModBlocks.CHISELED_CERILLE_BRICKS);

        addDrop(ModBlocks.AMETHYST_BULB);
        addDrop(ModBlocks.KUNZITE_BULB);
        addDrop(ModBlocks.ELYSIUM_BULB);
        addDrop(ModBlocks.THERMIUM_BULB);
        addDrop(ModBlocks.MEMORY_BULB);
        addDrop(ModBlocks.PINLINE_BULB);
        addDrop(ModBlocks.RAW_PINLINE_BULB);
        addDrop(ModBlocks.MOONSTEEL_BULB);
        addDrop(ModBlocks.CERILLE_BULB);

        addDrop(ModBlocks.POLISHED_AMETHYST_STAIRS);
        addDrop(ModBlocks.AMETHYST_BRICKS_STAIRS);
        addDrop(ModBlocks.KUNZITE_BRICKS_STAIRS);
        addDrop(ModBlocks.ELYSIUM_BRICKS_STAIRS);
        addDrop(ModBlocks.THERMIUM_BRICKS_STAIRS);
        addDrop(ModBlocks.MEMORY_BRICKS_STAIRS);
        addDrop(ModBlocks.PINLINE_BRICKS_STAIRS);
        addDrop(ModBlocks.RAW_PINLINE_BRICKS_STAIRS);
        addDrop(ModBlocks.COMPRESSED_END_STONE_BRICKS_STAIRS);
        addDrop(ModBlocks.STYXSTONE_BRICKS_STAIRS);
        addDrop(ModBlocks.COMPRESSED_STYXSTONE_BRICKS_STAIRS);
        addDrop(ModBlocks.MABRIZE_BRICKS_STAIRS);
        addDrop(ModBlocks.MOONSTEEL_BRICKS_STAIRS);
        addDrop(ModBlocks.CERILLE_BRICKS_STAIRS);

        addDrop(ModBlocks.POLISHED_AMETHYST_SLAB, slabDrops(ModBlocks.POLISHED_AMETHYST_SLAB));
        addDrop(ModBlocks.AMETHYST_BRICKS_SLAB, slabDrops(ModBlocks.AMETHYST_BRICKS_SLAB));
        addDrop(ModBlocks.KUNZITE_BRICKS_SLAB, slabDrops(ModBlocks.KUNZITE_BRICKS_SLAB));
        addDrop(ModBlocks.ELYSIUM_BRICKS_SLAB, slabDrops(ModBlocks.ELYSIUM_BRICKS_SLAB));
        addDrop(ModBlocks.THERMIUM_BRICKS_SLAB, slabDrops(ModBlocks.THERMIUM_BRICKS_SLAB));
        addDrop(ModBlocks.MEMORY_BRICKS_SLAB, slabDrops(ModBlocks.MEMORY_BRICKS_SLAB));
        addDrop(ModBlocks.RAW_PINLINE_BRICKS_SLAB, slabDrops(ModBlocks.RAW_PINLINE_BRICKS_SLAB));
        addDrop(ModBlocks.PINLINE_BRICKS_SLAB, slabDrops(ModBlocks.PINLINE_BRICKS_SLAB));
        addDrop(ModBlocks.COMPRESSED_END_STONE_BRICKS_SLAB, slabDrops(ModBlocks.COMPRESSED_END_STONE_BRICKS_SLAB));
        addDrop(ModBlocks.STYXSTONE_BRICKS_SLAB, slabDrops(ModBlocks.STYXSTONE_BRICKS_SLAB));
        addDrop(ModBlocks.COMPRESSED_STYXSTONE_BRICKS_SLAB, slabDrops(ModBlocks.COMPRESSED_STYXSTONE_BRICKS_SLAB));
        addDrop(ModBlocks.MABRIZE_BRICKS_SLAB, slabDrops(ModBlocks.MABRIZE_BRICKS_SLAB));
        addDrop(ModBlocks.CERILLE_BRICKS_SLAB, slabDrops(ModBlocks.CERILLE_BRICKS_SLAB));
        addDrop(ModBlocks.MOONSTEEL_BRICKS_SLAB, slabDrops(ModBlocks.MOONSTEEL_BRICKS_SLAB));

        addDrop(ModBlocks.POLISHED_AMETHYST_WALL);
        addDrop(ModBlocks.AMETHYST_BRICKS_WALL);
        addDrop(ModBlocks.KUNZITE_BRICKS_WALL);
        addDrop(ModBlocks.ELYSIUM_BRICKS_WALL);
        addDrop(ModBlocks.THERMIUM_BRICKS_WALL);
        addDrop(ModBlocks.MEMORY_BRICKS_WALL);
        addDrop(ModBlocks.PINLINE_BRICKS_WALL);
        addDrop(ModBlocks.RAW_PINLINE_BRICKS_WALL);
        addDrop(ModBlocks.COMPRESSED_END_STONE_BRICKS_WALL);
        addDrop(ModBlocks.STYXSTONE_BRICKS_WALL);
        addDrop(ModBlocks.COMPRESSED_STYXSTONE_BRICKS_WALL);
        addDrop(ModBlocks.MABRIZE_BRICKS_WALL);
        addDrop(ModBlocks.MOONSTEEL_BRICKS_WALL);
        addDrop(ModBlocks.CERILLE_BRICKS_WALL);

        addDrop(ModBlocks.KUNZITE_ORE, oreDrops(ModBlocks.KUNZITE_ORE, ModItems.RAW_KUNZITE));
        addDrop(ModBlocks.DEEPSLATE_KUNZITE_ORE, oreDrops(ModBlocks.DEEPSLATE_KUNZITE_ORE, ModItems.RAW_KUNZITE));
        addDrop(ModBlocks.AMETHYST_KUNZITE_ORE, multipleOreDrops(ModBlocks.AMETHYST_KUNZITE_ORE, ModItems.PINK_BITS, 4, 10));
        addDrop(ModBlocks.THERMIUM_ORE, multipleOreDrops(ModBlocks.THERMIUM_ORE, ModItems.RAW_THERMIUM, 1, 2));
        addDrop(ModBlocks.DEEPSLATE_THERMIUM_ORE, multipleOreDrops(ModBlocks.DEEPSLATE_THERMIUM_ORE, ModItems.RAW_THERMIUM, 1, 3));
        addDrop(ModBlocks.NETHER_SULFUR_ORE, oreDrops(ModBlocks.NETHER_SULFUR_ORE, ModItems.SULFUR));
        addDrop(ModBlocks.END_PINLINE_ORE, oreDrops(ModBlocks.END_PINLINE_ORE, ModItems.RAW_PINLINE));
        addDrop(ModBlocks.COMPRESSED_END_PINLINE_ORE, oreDrops(ModBlocks.COMPRESSED_END_PINLINE_ORE, ModItems.RAW_PINLINE));
        addDrop(ModBlocks.STYXIAN_AMETHYST_ORE, multipleOreDrops(ModBlocks.STYXIAN_AMETHYST_ORE, ModItems.AMETHYST_NUGGET, 3, 7));
        addDrop(ModBlocks.COMPRESSED_STYXIAN_AMETHYST_ORE, multipleOreDrops(ModBlocks.COMPRESSED_STYXIAN_AMETHYST_ORE, ModItems.AMETHYST_NUGGET, 3, 7));
        addDrop(ModBlocks.CORRUPT_ORE, multipleOreDrops(ModBlocks.CORRUPT_ORE, ModItems.CORRUPT_DROPLET, 9, 29));
        addDrop(ModBlocks.CORRUPT_ROOTS, multipleOreDrops(ModBlocks.CORRUPT_ROOTS, ModItems.CORRUPT_DROPLET, 1, 2));
        addDrop(ModBlocks.STYXIAN_STYXCOAL_ORE, oreDrops(ModBlocks.STYXIAN_STYXCOAL_ORE, ModItems.STYXCOAL));
        addDrop(ModBlocks.COMPRESSED_STYXIAN_STYXCOAL_ORE, oreDrops(ModBlocks.COMPRESSED_STYXIAN_STYXCOAL_ORE, ModItems.STYXCOAL));
        addDrop(ModBlocks.STYXIAN_MOONSTEEL_ORE, oreDrops(ModBlocks.STYXIAN_MOONSTEEL_ORE, ModItems.RAW_MOONSTEEL));
        addDrop(ModBlocks.COMPRESSED_STYXIAN_MOONSTEEL_ORE, oreDrops(ModBlocks.COMPRESSED_STYXIAN_MOONSTEEL_ORE, ModItems.RAW_MOONSTEEL));
        addDrop(ModBlocks.STYXIAN_LAPIS_ORE, multipleOreDrops(ModBlocks.STYXIAN_LAPIS_ORE, Items.LAPIS_LAZULI, 4, 8));
        addDrop(ModBlocks.COMPRESSED_STYXIAN_LAPIS_ORE, multipleOreDrops(ModBlocks.COMPRESSED_STYXIAN_LAPIS_ORE, Items.LAPIS_LAZULI, 4, 8));
        addDrop(ModBlocks.STYXIAN_SUNGAZE_ORE, oreDrops(ModBlocks.STYXIAN_SUNGAZE_ORE, ModItems.SUNGAZE));
        addDrop(ModBlocks.COMPRESSED_STYXIAN_SUNGAZE_ORE, oreDrops(ModBlocks.COMPRESSED_STYXIAN_SUNGAZE_ORE, ModItems.SUNGAZE));

        addDrop(ModBlocks.STYXIAN_SOIL);
        addDrop(ModBlocks.STYXMOSS);
        addDrop(ModBlocks.STYXMOSS_CARPET);
        addDrop(ModBlocks.MABRIZE);
        addDrop(ModBlocks.STYXSTONE, ModBlocks.COBBLED_STYXSTONE);
        addDrop(ModBlocks.COBBLED_STYXSTONE);
        addDrop(ModBlocks.MOSSY_COBBLED_STYXSTONE);
        addDrop(ModBlocks.COMPRESSED_STYXSTONE);
        addDrop(ModBlocks.STYXGRASS, dropsWithShears(ModBlocks.STYXGRASS));
        addDrop(ModBlocks.HANGING_STYXGRASS, dropsWithShears(ModBlocks.HANGING_STYXGRASS));
        addDrop(ModBlocks.STYXMOSS_VINE, dropsWithShears(ModBlocks.STYXMOSS_VINE));
        addDrop(ModBlocks.DEATH_FLOWERS);
        addDrop(ModBlocks.STYXCOAL_BLOCK);
        addDrop(ModBlocks.MOONSTEEL_BLOCK);
        addDrop(ModBlocks.RAW_MOONSTEEL_BLOCK);
        addDrop(ModBlocks.CERILLE_BLOCK);
        addDrop(ModBlocks.SUNGAZE_BLOCK);

        addDrop(ModBlocks.PINK_SAND);
        addDrop(ModBlocks.PINK_SANDSTONE);
        addDrop(ModBlocks.CUT_PINK_SANDSTONE);
        addDrop(ModBlocks.CHISELED_PINK_SANDSTONE);
        addDrop(ModBlocks.SMOOTH_PINK_SANDSTONE);
        addDrop(ModBlocks.PINK_SANDSTONE_SLAB, slabDrops(ModBlocks.PINK_SANDSTONE_SLAB));
        addDrop(ModBlocks.CUT_PINK_SANDSTONE_SLAB, slabDrops(ModBlocks.CUT_PINK_SANDSTONE_SLAB));
        addDrop(ModBlocks.SMOOTH_PINK_SANDSTONE_SLAB, slabDrops(ModBlocks.SMOOTH_PINK_SANDSTONE_SLAB));
        addDrop(ModBlocks.PINK_SANDSTONE_STAIRS);
        addDrop(ModBlocks.SMOOTH_PINK_SANDSTONE_STAIRS);
        addDrop(ModBlocks.PINK_SANDSTONE_WALL);

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

        addDrop(ModBlocks.CRYSTAL_CHERRY_LEAVES, multipleOreDrops(ModBlocks.CRYSTAL_CHERRY_LEAVES, ModItems.PINK_BITS, 1, 2));

        addDrop(ModBlocks.CHORUS_LOG);
        addDrop(ModBlocks.CHORUS_WOOD);
        addDrop(ModBlocks.STRIPPED_CHORUS_LOG);
        addDrop(ModBlocks.STRIPPED_CHORUS_WOOD);
        addDrop(ModBlocks.CHORUS_PLANKS);
        addDrop(ModBlocks.CHORUS_SAPLING);

        addDrop(ModBlocks.CHORUS_SLAB, slabDrops(ModBlocks.CHORUS_SLAB));
        addDrop(ModBlocks.CHORUS_STAIRS);
        addDrop(ModBlocks.CHORUS_FENCE);
        addDrop(ModBlocks.CHORUS_FENCE_GATE);
        addDrop(ModBlocks.CHORUS_DOOR, doorDrops(ModBlocks.CHORUS_DOOR));
        addDrop(ModBlocks.CHORUS_TRAPDOOR);
        addDrop(ModBlocks.CHORUS_BUTTON);
        addDrop(ModBlocks.CHORUS_PRESSURE_PLATE);

        addDrop(ModBlocks.CHORUS_LEAVES, leavesWithItemDrops(ModBlocks.CHORUS_LEAVES, ModBlocks.CHORUS_SAPLING, 0.01f, Items.CHORUS_FRUIT, 0.2f));

        addDrop(ModBlocks.SNOWY_SPRUCE_SAPLING);
        addDrop(ModBlocks.SNOWY_SPRUCE_LEAVES, leavesWithItemDrops(ModBlocks.SNOWY_SPRUCE_LEAVES, ModBlocks.SNOWY_SPRUCE_SAPLING, 0.05f, Items.SNOWBALL, 0.02f));

        addDrop(ModBlocks.ASHEN_LOG);
        addDrop(ModBlocks.ASHEN_WOOD);
        addDrop(ModBlocks.STRIPPED_ASHEN_LOG);
        addDrop(ModBlocks.STRIPPED_ASHEN_WOOD);
        addDrop(ModBlocks.ASHEN_PLANKS);

        addDrop(ModBlocks.ASHEN_SLAB, slabDrops(ModBlocks.ASHEN_SLAB));
        addDrop(ModBlocks.ASHEN_STAIRS);
        addDrop(ModBlocks.ASHEN_FENCE);
        addDrop(ModBlocks.ASHEN_FENCE_GATE);
        addDrop(ModBlocks.ASHEN_DOOR, doorDrops(ModBlocks.ASHEN_DOOR));
        addDrop(ModBlocks.ASHEN_TRAPDOOR);
        addDrop(ModBlocks.ASHEN_BUTTON);
        addDrop(ModBlocks.ASHEN_PRESSURE_PLATE);

        addDrop(ModBlocks.KEAPHE_LOG);
        addDrop(ModBlocks.KEAPHE_WOOD);
        addDrop(ModBlocks.STRIPPED_KEAPHE_LOG);
        addDrop(ModBlocks.STRIPPED_KEAPHE_WOOD);
        addDrop(ModBlocks.KEAPHE_PLANKS);

        addDrop(ModBlocks.KEAPHE_SLAB, slabDrops(ModBlocks.KEAPHE_SLAB));
        addDrop(ModBlocks.KEAPHE_STAIRS);
        addDrop(ModBlocks.KEAPHE_FENCE);
        addDrop(ModBlocks.KEAPHE_FENCE_GATE);
        addDrop(ModBlocks.KEAPHE_DOOR, doorDrops(ModBlocks.KEAPHE_DOOR));
        addDrop(ModBlocks.KEAPHE_TRAPDOOR);
        addDrop(ModBlocks.KEAPHE_BUTTON);
        addDrop(ModBlocks.KEAPHE_PRESSURE_PLATE);

        addDrop(ModBlocks.KEAPHE_SAPLING);
        addDrop(ModBlocks.KEAPHE_LEAVES, leavesDrops(ModBlocks.KEAPHE_LEAVES, ModBlocks.KEAPHE_SAPLING, 0.05f));
        addDrop(ModBlocks.FLOWERING_KEAPHE_LEAVES, leavesDrops(ModBlocks.FLOWERING_KEAPHE_LEAVES, ModBlocks.KEAPHE_SAPLING, 0.1f));

        addPottedPlantDrops(ModBlocks.POTTED_MEMORIA_BOURPEER);
        addPottedPlantDrops(ModBlocks.POTTED_THERMIUM_WILTBORN);
        addPottedPlantDrops(ModBlocks.POTTED_ELYSIAN_SKYBERRY);
        addPottedPlantDrops(ModBlocks.POTTED_KUNZITE_LOVELILY);
        addPottedPlantDrops(ModBlocks.POTTED_AMETHYST_PARTERS);
        addPottedPlantDrops(ModBlocks.POTTED_CRYSTAL_CHERRY_SAPLING);
        addPottedPlantDrops(ModBlocks.POTTED_CHORUS_SAPLING);
        addPottedPlantDrops(ModBlocks.POTTED_KEAPHE_SAPLING);

        addDrop(ModBlocks.AMETHYST_PARTERS);
        addDrop(ModBlocks.KUNZITE_LOVELILY);
        addDrop(ModBlocks.ELYSIAN_SKYBERRY);
        addDrop(ModBlocks.THERMIUM_WILTBORN);
        addDrop(ModBlocks.MEMORIA_BOURPEER);
        addDrop(ModBlocks.HAZEWEAVER_PLANT, ModItems.HAZEWEAVER);

        addDrop(ModBlocks.KUNZITE_ROD);
        addDrop(ModBlocks.AMETHYST_ROD);
        addDrop(ModBlocks.THERMIUM_ROD);
        addDrop(ModBlocks.PINLINE_ROD);
        addDrop(ModBlocks.RAW_PINLINE_ROD);
        addDrop(ModBlocks.ELYSIUM_ROD);

        addDropWithSilkTouch(ModBlocks.SMALL_END_GRASS);
        addDropWithSilkTouch(ModBlocks.MEDIUM_END_GRASS);
        addDropWithSilkTouch(ModBlocks.LARGE_END_GRASS);
        addDrop(ModBlocks.CHORUS_LILY);

        addDropWithSilkTouch(ModBlocks.BLACK_GOOP);

        addDrop(Blocks.LARGE_AMETHYST_BUD, multipleOreDrops(Blocks.LARGE_AMETHYST_BUD, ModItems.AMETHYST_NUGGET, 2, 8));
        addDrop(Blocks.MEDIUM_AMETHYST_BUD, multipleOreDrops(Blocks.MEDIUM_AMETHYST_BUD, ModItems.AMETHYST_NUGGET, 0, 3));

        addDrop(ModBlocks.AMETHYST_CLUMP, clumpDrops(ModBlocks.AMETHYST_CLUMP, ModItems.AMETHYST_NUGGET, 3));
        addDrop(ModBlocks.DIAMOND_CLUMP, clumpDrops(ModBlocks.DIAMOND_CLUMP, ModItems.DIAMOND_NUGGET, 2));
        addDrop(ModBlocks.EMERALD_CLUMP, clumpDrops(ModBlocks.EMERALD_CLUMP, ModItems.EMERALD_NUGGET, 3));
        addDrop(ModBlocks.KUNZITE_CLUMP, clumpDrops(ModBlocks.KUNZITE_CLUMP, ModItems.KUNZITE_NUGGET, 3));
        addDrop(ModBlocks.THERMIUM_CLUMP, clumpDrops(ModBlocks.THERMIUM_CLUMP, ModItems.THERMIUM_NUGGET, 1));
        addDrop(ModBlocks.QUARTZ_CLUMP, clumpDrops(ModBlocks.QUARTZ_CLUMP, ModItems.QUARTZ_NUGGET, 3));
        addDrop(ModBlocks.CORRUPTION_CLUMP, multifaceGrowthDrops(Block.getBlockFromItem(ModItems.CORRUPT_DROPLET)));

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
        this.addDrop(ModBlocks.CHARMBERRY_BUSH,
                block -> this.applyExplosionDecay(
                        block,LootTable.builder().pool(LootPool.builder().conditionally(
                                                BlockStatePropertyLootCondition.builder(ModBlocks.CHARMBERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(GemBerryBushBlock.AGE, 3))
                                        )
                                        .with(ItemEntry.builder(ModItems.CHARMBERRY))
                                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F)))
                                        .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                        ).pool(LootPool.builder().conditionally(
                                        BlockStatePropertyLootCondition.builder(ModBlocks.CHARMBERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(GemBerryBushBlock.AGE, 2))
                                ).with(ItemEntry.builder(ModItems.CHARMBERRY))
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
                                .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE))))));
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }

    public LootTable.Builder clumpDrops(Block drop, Item item, float count) {
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item)
                                .apply(Direction.values(), (direction) -> SetCountLootFunction.builder(UniformLootNumberProvider.create(1, count), true)
                                        .conditionally(BlockStatePropertyLootCondition.builder(drop)
                                                .properties(net.minecraft.predicate.StatePredicate.Builder.create().exactMatch(MultifaceBlock.getProperty(direction), true)))))
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(-1.0F), true))));
    }

    public LootTable.Builder leavesWithItemDrops(Block leaves, Block sapling, float saplingChance, Item item, float itemChance) {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        return this.leavesDrops(leaves, sapling, saplingChance)
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(this.createWithoutShearsOrSilkTouchCondition())
                        .with(((LeafEntry.Builder)this.addSurvivesExplosionCondition(leaves, ItemEntry.builder(item)))
                                .conditionally(TableBonusLootCondition.builder(impl.getOrThrow(Enchantments.FORTUNE), itemChance))));
    }
}
