package net.jirniy.pinkstuff.world;

import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.block.custom.GemBerryBushBlock;
import net.jirniy.pinkstuff.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.MultifaceGrowthBlock;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.Pool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.intprovider.WeightedListIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.ThreeLayersFeatureSize;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.CherryFoliagePlacer;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.foliage.PineFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.CherryTrunkPlacer;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;
import java.util.OptionalInt;

import static net.minecraft.block.Blocks.*;

public class ModConfiguredFeatures {
    // CF -> PF -> WG

    public static final RegistryKey<ConfiguredFeature<?, ?>> KUNZITE_ORE_KEY = registryKey("kunzite_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> THERMIUM_ORE_KEY = registryKey("thermium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SULFUR_ORE_KEY = registryKey("sulfur_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PINLINE_ORE_KEY = registryKey("pinline_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GEM_BERRY_BUSH_KEY = registryKey("gem_berry_bush");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GEM_TREE_KEY = registryKey("gem_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CRYSTAL_CHERRY_KEY = registryKey("crystal_cherry");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CHORUS_TREE_KEY = registryKey("chorus_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ASHEN_TREE_KEY = registryKey("ashen_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SNOWY_SPRUCE_TREE_KEY = registryKey("snowy_spruce_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HAZEWEAVER_PLANT_KEY = registryKey("hazeweaver_plant");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SMALL_END_GRASS_KEY = registryKey("small_end_grass");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MEDIUM_END_GRASS_KEY = registryKey("medium_end_grass");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LARGE_END_GRASS_KEY = registryKey("large_end_grass");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CHORUS_LILY_KEY = registryKey("chorus_lily");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COMPRESSED_END_STONE_KEY = registryKey("compressed_end_stone");
    public static final RegistryKey<ConfiguredFeature<?, ?>> KUNZITE_GEODE_KEY = registryKey("kunzite_geode");
    public static final RegistryKey<ConfiguredFeature<?, ?>> AMETHYST_CLUMP_KEY = registryKey("amethyst_clump");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DIAMOND_CLUMP_KEY = registryKey("diamond_clump");
    public static final RegistryKey<ConfiguredFeature<?, ?>> EMERALD_CLUMP_KEY = registryKey("emerald_clump");
    public static final RegistryKey<ConfiguredFeature<?, ?>> QUARTZ_CLUMP_KEY = registryKey("quartz_clump");
    public static final RegistryKey<ConfiguredFeature<?, ?>> KUNZITE_CLUMP_KEY = registryKey("kunzite_clump");
    public static final RegistryKey<ConfiguredFeature<?, ?>> THERMIUM_CLUMP_KEY = registryKey("thermium_clump");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldKunziteOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.KUNZITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_KUNZITE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> overworldThermiumOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.THERMIUM_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_THERMIUM_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> netherSulfurOres =
                List.of(OreFeatureConfig.createTarget(new BlockMatchRuleTest(BASALT), ModBlocks.NETHER_SULFUR_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(new BlockMatchRuleTest(BLACKSTONE), ModBlocks.NETHER_SULFUR_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> endPinlineOres =
                List.of(OreFeatureConfig.createTarget(new BlockMatchRuleTest(END_STONE), ModBlocks.END_PINLINE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(new BlockMatchRuleTest(ModBlocks.COMPRESSED_END_STONE), ModBlocks.COMPRESSED_END_PINLINE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> compressedEndStone =
                List.of(OreFeatureConfig.createTarget(new BlockMatchRuleTest(END_STONE), ModBlocks.COMPRESSED_END_STONE.getDefaultState()),
                        OreFeatureConfig.createTarget(new BlockMatchRuleTest(ModBlocks.END_PINLINE_ORE), ModBlocks.COMPRESSED_END_PINLINE_ORE.getDefaultState()));

        register(context, KUNZITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldKunziteOres, 15));
        register(context, THERMIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldThermiumOres, 3, 0.3f));
        register(context, SULFUR_ORE_KEY, Feature.SCATTERED_ORE, new OreFeatureConfig(netherSulfurOres, 25));
        register(context, PINLINE_ORE_KEY, Feature.SCATTERED_ORE, new OreFeatureConfig(endPinlineOres, 64));
        register(context, COMPRESSED_END_STONE_KEY, Feature.ORE, new OreFeatureConfig(compressedEndStone, 64, 0.3f));

        register(context, AMETHYST_CLUMP_KEY, Feature.MULTIFACE_GROWTH, new MultifaceGrowthFeatureConfig(
                (MultifaceGrowthBlock) ModBlocks.AMETHYST_CLUMP, 25, true, true, true, 0.6f, RegistryEntryList.of(Block::getRegistryEntry, new Block[]{Blocks.STONE, Blocks.ANDESITE, Blocks.DIORITE, Blocks.GRANITE, Blocks.DRIPSTONE_BLOCK, Blocks.CALCITE, Blocks.TUFF, Blocks.DEEPSLATE})));
        register(context, DIAMOND_CLUMP_KEY, Feature.MULTIFACE_GROWTH, new MultifaceGrowthFeatureConfig(
                (MultifaceGrowthBlock) ModBlocks.DIAMOND_CLUMP, 15, true, true, true, 0.3f, RegistryEntryList.of(Block::getRegistryEntry, new Block[]{Blocks.STONE, Blocks.ANDESITE, Blocks.DIORITE, Blocks.GRANITE, Blocks.DRIPSTONE_BLOCK, Blocks.CALCITE, Blocks.TUFF, Blocks.DEEPSLATE, SCULK})));
        register(context, EMERALD_CLUMP_KEY, Feature.MULTIFACE_GROWTH, new MultifaceGrowthFeatureConfig(
                (MultifaceGrowthBlock) ModBlocks.EMERALD_CLUMP, 20, true, true, true, 0.4f, RegistryEntryList.of(Block::getRegistryEntry, new Block[]{Blocks.STONE, Blocks.ANDESITE, Blocks.DIORITE, Blocks.GRANITE, Blocks.DRIPSTONE_BLOCK, Blocks.CALCITE, Blocks.TUFF, Blocks.DEEPSLATE})));
        register(context, QUARTZ_CLUMP_KEY, Feature.MULTIFACE_GROWTH, new MultifaceGrowthFeatureConfig(
                (MultifaceGrowthBlock) ModBlocks.QUARTZ_CLUMP, 25, true, true, true, 0.8f, RegistryEntryList.of(Block::getRegistryEntry, new Block[]{NETHERRACK, BLACKSTONE, BASALT, SOUL_SAND, SOUL_SOIL, MAGMA_BLOCK, NETHER_GOLD_ORE, NETHER_QUARTZ_ORE})));
        register(context, KUNZITE_CLUMP_KEY, Feature.MULTIFACE_GROWTH, new MultifaceGrowthFeatureConfig(
                (MultifaceGrowthBlock) ModBlocks.KUNZITE_CLUMP, 25, true, true, true, 0.7f, RegistryEntryList.of(Block::getRegistryEntry, new Block[]{Blocks.STONE, Blocks.ANDESITE, Blocks.DIORITE, Blocks.GRANITE, Blocks.DRIPSTONE_BLOCK, Blocks.CALCITE, Blocks.TUFF, Blocks.DEEPSLATE})));
        register(context, THERMIUM_CLUMP_KEY, Feature.MULTIFACE_GROWTH, new MultifaceGrowthFeatureConfig(
                (MultifaceGrowthBlock) ModBlocks.THERMIUM_CLUMP, 15, true, true, true, 0.2f, RegistryEntryList.of(Block::getRegistryEntry, new Block[]{Blocks.STONE, Blocks.ANDESITE, Blocks.DIORITE, Blocks.GRANITE, Blocks.DRIPSTONE_BLOCK, Blocks.CALCITE, Blocks.TUFF, Blocks.DEEPSLATE})));

        register(context, GEM_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                new WeightedBlockStateProvider(
                        Pool.<BlockState>builder()
                                .add(AMETHYST_BLOCK.getDefaultState(), 4)
                                .add(BUDDING_AMETHYST.getDefaultState(), 1)
                                .add(ModBlocks.AMETHYST_KUNZITE_ORE.getDefaultState(), 2)
                ),
                new LargeOakTrunkPlacer(7, 7, 5),
                BlockStateProvider.of(AIR),
                new BlobFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(1), 1),
                new TwoLayersFeatureSize(3, 1, 4)).build());

        register(context, CRYSTAL_CHERRY_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                new WeightedBlockStateProvider(
                        Pool.<BlockState>builder()
                                .add(CHERRY_LOG.getDefaultState(), 1)
                                .add(ModBlocks.CRYSTAL_CHERRY_LOG.getDefaultState(), 2)
                ),
                new CherryTrunkPlacer(
                        7,
                        1,
                        0,
                        new WeightedListIntProvider(
                                Pool.<IntProvider>builder().add(ConstantIntProvider.create(1), 1).add(ConstantIntProvider.create(2), 1).add(ConstantIntProvider.create(3), 1).build()
                        ),
                        UniformIntProvider.create(2, 4),
                        UniformIntProvider.create(-4, -3),
                        UniformIntProvider.create(-1, 0)
                ),
                new WeightedBlockStateProvider(
                        Pool.<BlockState>builder()
                                .add(CHERRY_LEAVES.getDefaultState(), 1)
                                .add(ModBlocks.CRYSTAL_CHERRY_LEAVES.getDefaultState(), 2)
                ),
                new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0), ConstantIntProvider.create(5), 0.25F, 0.5F, 0.16666667F, 0.33333334F),
                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, CHORUS_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.CHORUS_LOG),
                new CherryTrunkPlacer(
                        6,
                        3,
                        2,
                        UniformIntProvider.create(2, 3),
                        UniformIntProvider.create(2, 4),
                        UniformIntProvider.create(-4, -3),
                        UniformIntProvider.create(-1, 0)
                ),
                BlockStateProvider.of(ModBlocks.CHORUS_LEAVES),
                new LargeOakFoliagePlacer(
                        ConstantIntProvider.create(2),
                        ConstantIntProvider.create(4),
                        4),
                new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty()))
                .dirtProvider(BlockStateProvider.of(END_STONE)).build());

        register(context, ASHEN_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.ASHEN_LOG),
                new ForkingTrunkPlacer(4, 2, 2),
                BlockStateProvider.of(AIR),
                new BlobFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(1), 1),
                new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty()))
                .dirtProvider(BlockStateProvider.of(ModBlocks.ASHEN_LOG)).build());

        register(context, SNOWY_SPRUCE_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(SPRUCE_LOG),
                new StraightTrunkPlacer(5, 4, 3),
                BlockStateProvider.of(ModBlocks.SNOWY_SPRUCE_LEAVES),
                new PineFoliagePlacer(ConstantIntProvider.create(0), UniformIntProvider.create(0, 1), UniformIntProvider.create(3, 4)),
                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, KUNZITE_GEODE_KEY, Feature.GEODE, new GeodeFeatureConfig(new
                GeodeLayerConfig(BlockStateProvider.of(Blocks.AIR),
                new WeightedBlockStateProvider(
                        Pool.<BlockState>builder()
                                .add(ModBlocks.AMETHYST_KUNZITE_ORE.getDefaultState(), 3)
                                .add(AMETHYST_BLOCK.getDefaultState(), 1)
                ),
                new WeightedBlockStateProvider(
                        Pool.<BlockState>builder()
                                .add(ModBlocks.AMETHYST_KUNZITE_ORE.getDefaultState(), 1)
                                .add(AMETHYST_BLOCK.getDefaultState(), 1)
                ),
                new WeightedBlockStateProvider(
                        Pool.<BlockState>builder()
                                .add(ModBlocks.AMETHYST_KUNZITE_ORE.getDefaultState(), 1)
                                .add(AMETHYST_BLOCK.getDefaultState(), 3)
                ),
                BlockStateProvider.of(GRANITE),
                List.of(ModBlocks.AMETHYST_KUNZITE_ORE.getDefaultState()),
                ModTags.Blocks.KUNZITE_GEODE_IRREPLACEABLE,
                BlockTags.GEODE_INVALID_BLOCKS),
                new GeodeLayerThicknessConfig(0.6, 0.8, 0.9, 1.2),
                new GeodeCrackConfig(0.2, (double)1.0F, 2),
                0.35, 0.083, true,
                UniformIntProvider.create(2, 5), UniformIntProvider.create(1, 3), UniformIntProvider.create(1, 2),
                -16, 16, 0.05, 1
        ));


        register(context, GEM_BERRY_BUSH_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.GEM_BERRY_BUSH
                                .getDefaultState().with(GemBerryBushBlock.AGE, 3))),
                        List.of(Blocks.GRASS_BLOCK)));

        register(context, HAZEWEAVER_PLANT_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(
                                Pool.<BlockState>builder()
                                        .add(ModBlocks.HAZEWEAVER_PLANT.getDefaultState(), 1)
                                        .add(AIR.getDefaultState(), 2))),
                        List.of(Blocks.GRASS_BLOCK)));

        register(context, SMALL_END_GRASS_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.SMALL_END_GRASS)),
                        List.of(Blocks.END_STONE, ModBlocks.COMPRESSED_END_STONE)));
        register(context, MEDIUM_END_GRASS_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.MEDIUM_END_GRASS)),
                        List.of(Blocks.END_STONE, ModBlocks.COMPRESSED_END_STONE)));
        register(context, LARGE_END_GRASS_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LARGE_END_GRASS)),
                        List.of(Blocks.END_STONE, ModBlocks.COMPRESSED_END_STONE)));
        register(context, CHORUS_LILY_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(
                                Pool.<BlockState>builder()
                                        .add(ModBlocks.CHORUS_LILY.getDefaultState(), 1)
                                        .add(AIR.getDefaultState(), 4))),
                        List.of(Blocks.END_STONE, ModBlocks.COMPRESSED_END_STONE)));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(JirniysPinkStuff.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key,
                                                                                   F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
