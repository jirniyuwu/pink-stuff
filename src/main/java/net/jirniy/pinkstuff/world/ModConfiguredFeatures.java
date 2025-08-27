package net.jirniy.pinkstuff.world;

import com.google.common.collect.ImmutableList;
import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.block.custom.CharmberryBushBlock;
import net.jirniy.pinkstuff.block.custom.CottonCropBlock;
import net.jirniy.pinkstuff.block.custom.GemBerryBushBlock;
import net.jirniy.pinkstuff.block.custom.HangingStyxgrassBlock;
import net.jirniy.pinkstuff.util.ModTags;
import net.jirniy.pinkstuff.world.features.HangingStyxgrassDecorator;
import net.jirniy.pinkstuff.world.features.ModFeatures;
import net.jirniy.pinkstuff.world.features.StyxmossVineDecorator;
import net.minecraft.block.*;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.Pool;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.intprovider.WeightedListIntProvider;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.ThreeLayersFeatureSize;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.*;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.PredicatedStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.*;

import java.util.List;
import java.util.OptionalInt;

import static net.minecraft.block.Blocks.*;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> KUNZITE_ORE_KEY = registryKey("kunzite_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> STYXIAN_AMETHYST_ORE_KEY = registryKey("styxian_amethyst_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> THERMIUM_ORE_KEY = registryKey("thermium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> THERMIUM_ORE_DRIPSTONE_KEY = registryKey("thermium_ore_dripstone");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SULFUR_ORE_KEY = registryKey("sulfur_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> STYXIAN_SULFUR_ORE_KEY = registryKey("styxian_sulfur_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PINLINE_ORE_KEY = registryKey("pinline_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> STYXCOAL_ORE_KEY = registryKey("styxcoal_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MOONSTEEL_ORE_KEY = registryKey("moonsteel_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SUNGAZE_ORE_KEY = registryKey("sungaze_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> STYXIAN_LAPIS_ORE_KEY = registryKey("styxian_lapis_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GEM_BERRY_BUSH_KEY = registryKey("gem_berry_bush");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GEM_TREE_KEY = registryKey("gem_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CRYSTAL_CHERRY_KEY = registryKey("crystal_cherry");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CHORUS_TREE_KEY = registryKey("chorus_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ASHEN_TREE_KEY = registryKey("ashen_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> KEAPHE_TREE_KEY = registryKey("keaphe_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TALL_KEAPHE_TREE_KEY = registryKey("tall_keaphe_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GIANT_KEAPHE_TREE_KEY = registryKey("giant_keaphe_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GIANT_CHERRY_TREE_KEY = registryKey("giant_cherry_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SNOWY_SPRUCE_TREE_KEY = registryKey("snowy_spruce_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HAZEWEAVER_PLANT_KEY = registryKey("hazeweaver_plant");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SMALL_END_GRASS_KEY = registryKey("small_end_grass");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MEDIUM_END_GRASS_KEY = registryKey("medium_end_grass");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LARGE_END_GRASS_KEY = registryKey("large_end_grass");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CHORUS_LILY_KEY = registryKey("chorus_lily");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COMPRESSED_END_STONE_KEY = registryKey("compressed_end_stone");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COMPRESSED_STYXSTONE_KEY = registryKey("compressed_styxstone");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MABRIZE_KEY = registryKey("mabrize");
    public static final RegistryKey<ConfiguredFeature<?, ?>> KUNZITE_GEODE_KEY = registryKey("kunzite_geode");
    public static final RegistryKey<ConfiguredFeature<?, ?>> AMETHYST_CLUMP_KEY = registryKey("amethyst_clump");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DIAMOND_CLUMP_KEY = registryKey("diamond_clump");
    public static final RegistryKey<ConfiguredFeature<?, ?>> EMERALD_CLUMP_KEY = registryKey("emerald_clump");
    public static final RegistryKey<ConfiguredFeature<?, ?>> QUARTZ_CLUMP_KEY = registryKey("quartz_clump");
    public static final RegistryKey<ConfiguredFeature<?, ?>> KUNZITE_CLUMP_KEY = registryKey("kunzite_clump");
    public static final RegistryKey<ConfiguredFeature<?, ?>> THERMIUM_CLUMP_KEY = registryKey("thermium_clump");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CORRUPTION_CLUMP_KEY = registryKey("corruption_clump");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CORRUPTION_SPIKE_KEY = registryKey("corruption_spike");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CORRUPTION_DISC_KEY = registryKey("corruption_disc");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CORRUPT_ROOTS_KEY = registryKey("corrupt_roots");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CORRUPT_ORE_KEY = registryKey("corrupt_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> AMETHYST_SPIKE_KEY = registryKey("amethyst_spike");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DEATHFLOWER_KEY = registryKey("deathflower");
    public static final RegistryKey<ConfiguredFeature<?, ?>> STYXIAN_ROCK_KEY = registryKey("styxian_rock");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MOSSY_STYXIAN_ROCK_KEY = registryKey("mossy_styxian_rock");
    public static final RegistryKey<ConfiguredFeature<?, ?>> STYXIAN_CLAY_PATCH_KEY = registryKey("styxian_clay_patch");
    public static final RegistryKey<ConfiguredFeature<?, ?>> STYXIAN_GRAVEL_PATCH_KEY = registryKey("styxian_gravel_patch");
    public static final RegistryKey<ConfiguredFeature<?, ?>> STYXMOSS_PATCH_KEY = registryKey("styxmoss_patch");
    public static final RegistryKey<ConfiguredFeature<?, ?>> STYXMOSS_VEGETATION_KEY = registryKey("styxmoss_vegetation");
    public static final RegistryKey<ConfiguredFeature<?, ?>> STYXMOSS_PATCH_BONEMEAL_KEY = registryKey("styxmoss_patch_bonemeal");
    public static final RegistryKey<ConfiguredFeature<?, ?>> STYXGRASS_PATCH_KEY = registryKey("styxgrass_patch");
    public static final RegistryKey<ConfiguredFeature<?, ?>> STYXGRASS_CEILING_KEY = registryKey("styxgrass_ceiling");
    public static final RegistryKey<ConfiguredFeature<?, ?>> STYXMOSS_DISK_KEY = registryKey("styxmoss_disk_patch");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CRAWLER_STONE_KEY = registryKey("crawler_stone");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COTTON_PATCH_KEY = registryKey("cotton_patch");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CHARMBERRY_PATCH_KEY = registryKey("charmberry_patch");
    public static final RegistryKey<ConfiguredFeature<?, ?>> AMETHYST_PATCH_KEY = registryKey("amethyst_patch");
    public static final RegistryKey<ConfiguredFeature<?, ?>> STYXIAN_DELTA_KEY = registryKey("styxian_delta");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ASH_PATCH_KEY = registryKey("ash_patch");

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
        List<OreFeatureConfig.Target> styxianSulfurOres =
                List.of(OreFeatureConfig.createTarget(new BlockMatchRuleTest(ModBlocks.MABRIZE), ModBlocks.STYXIAN_SULFUR_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(new BlockMatchRuleTest(ModBlocks.STYXSTONE), ModBlocks.STYXIAN_SULFUR_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(new BlockMatchRuleTest(ModBlocks.COMPRESSED_STYXSTONE), ModBlocks.COMPRESSED_STYXIAN_SULFUR_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> endPinlineOres =
                List.of(OreFeatureConfig.createTarget(new BlockMatchRuleTest(END_STONE), ModBlocks.END_PINLINE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(new BlockMatchRuleTest(ModBlocks.COMPRESSED_END_STONE), ModBlocks.COMPRESSED_END_PINLINE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> compressedEndStone =
                List.of(OreFeatureConfig.createTarget(new BlockMatchRuleTest(END_STONE), ModBlocks.COMPRESSED_END_STONE.getDefaultState()),
                        OreFeatureConfig.createTarget(new BlockMatchRuleTest(ModBlocks.END_PINLINE_ORE), ModBlocks.COMPRESSED_END_PINLINE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> styxianAmethystOres =
                List.of(OreFeatureConfig.createTarget(new BlockMatchRuleTest(ModBlocks.STYXSTONE), ModBlocks.STYXIAN_AMETHYST_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(new BlockMatchRuleTest(ModBlocks.MABRIZE), ModBlocks.STYXIAN_AMETHYST_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(new BlockMatchRuleTest(ModBlocks.COMPRESSED_STYXSTONE), ModBlocks.COMPRESSED_STYXIAN_AMETHYST_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> styxianStyxcoalOres =
                List.of(OreFeatureConfig.createTarget(new BlockMatchRuleTest(ModBlocks.STYXSTONE), ModBlocks.STYXIAN_STYXCOAL_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(new BlockMatchRuleTest(ModBlocks.MABRIZE), ModBlocks.STYXIAN_STYXCOAL_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(new BlockMatchRuleTest(ModBlocks.COMPRESSED_STYXSTONE), ModBlocks.COMPRESSED_STYXIAN_STYXCOAL_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> styxianMoonsteelOres =
                List.of(OreFeatureConfig.createTarget(new BlockMatchRuleTest(ModBlocks.STYXSTONE), ModBlocks.STYXIAN_MOONSTEEL_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(new BlockMatchRuleTest(ModBlocks.MABRIZE), ModBlocks.STYXIAN_MOONSTEEL_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(new BlockMatchRuleTest(ModBlocks.COMPRESSED_STYXSTONE), ModBlocks.COMPRESSED_STYXIAN_MOONSTEEL_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> styxianLapisOres =
                List.of(OreFeatureConfig.createTarget(new BlockMatchRuleTest(ModBlocks.STYXSTONE), ModBlocks.STYXIAN_LAPIS_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(new BlockMatchRuleTest(ModBlocks.MABRIZE), ModBlocks.STYXIAN_LAPIS_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(new BlockMatchRuleTest(ModBlocks.COMPRESSED_STYXSTONE), ModBlocks.COMPRESSED_STYXIAN_LAPIS_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> styxianSungazeOres =
                List.of(OreFeatureConfig.createTarget(new BlockMatchRuleTest(ModBlocks.STYXSTONE), ModBlocks.STYXIAN_SUNGAZE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(new BlockMatchRuleTest(ModBlocks.MABRIZE), ModBlocks.STYXIAN_SUNGAZE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(new BlockMatchRuleTest(ModBlocks.COMPRESSED_STYXSTONE), ModBlocks.COMPRESSED_STYXIAN_SUNGAZE_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> crawlerStone =
                List.of(OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.STONE), ModBlocks.CRAWLER_STONE.getDefaultState()),
                        OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.DEEPSLATE), ModBlocks.CRAWLER_DEEPSLATE.getDefaultState()),
                        OreFeatureConfig.createTarget(new BlockMatchRuleTest(NETHERRACK), ModBlocks.CRAWLER_NETHERRACK.getDefaultState()),
                        OreFeatureConfig.createTarget(new BlockMatchRuleTest(ModBlocks.STYXSTONE), ModBlocks.CRAWLER_STYXSTONE.getDefaultState()),
                        OreFeatureConfig.createTarget(new BlockMatchRuleTest(ModBlocks.COMPRESSED_STYXSTONE), ModBlocks.CRAWLER_COMPRESSED_STYXSTONE.getDefaultState()));

        register(context, DEATHFLOWER_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(96, 6, 2,
                PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(flowerbed(ModBlocks.DEATH_FLOWERS))))));
        register(context, STYXIAN_ROCK_KEY, ModFeatures.ROCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.COBBLED_STYXSTONE)));
        register(context, MOSSY_STYXIAN_ROCK_KEY, ModFeatures.ROCK, new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(Pool.<BlockState>builder()
                .add(ModBlocks.MOSSY_COBBLED_STYXSTONE.getDefaultState(), 3)
                .add(ModBlocks.COBBLED_STYXSTONE.getDefaultState(), 1))));
        register(context, STYXIAN_CLAY_PATCH_KEY, Feature.ORE, new OreFeatureConfig(
                List.of(OreFeatureConfig.createTarget(new BlockMatchRuleTest(ModBlocks.STYXIAN_SOIL), CLAY.getDefaultState()),
                        OreFeatureConfig.createTarget(new BlockMatchRuleTest(ModBlocks.STYXSTONE), CLAY.getDefaultState())),
                14));
        register(context, STYXIAN_GRAVEL_PATCH_KEY, Feature.ORE, new OreFeatureConfig(
                List.of(OreFeatureConfig.createTarget(new BlockMatchRuleTest(ModBlocks.ASH_BLOCK), GRAVEL.getDefaultState()),
                        OreFeatureConfig.createTarget(new BlockMatchRuleTest(ModBlocks.COMPRESSED_STYXSTONE), GRAVEL.getDefaultState()),
                        OreFeatureConfig.createTarget(new BlockMatchRuleTest(ModBlocks.STYXSTONE), GRAVEL.getDefaultState())),
                18));
        register(context, STYXMOSS_VEGETATION_KEY, Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(Pool.<BlockState>builder()
                        .add(ModBlocks.STYXMOSS_CARPET.getDefaultState(), 10)
                        .add(ModBlocks.STYXGRASS.getDefaultState(), 20)
                        .add(ModBlocks.KEAPHE_SAPLING.getDefaultState(), 1)
                        .add(Blocks.AIR.getDefaultState(), 39))));
        register(context, STYXMOSS_PATCH_BONEMEAL_KEY, Feature.VEGETATION_PATCH,
                new VegetationPatchFeatureConfig(BlockTags.MOSS_REPLACEABLE,
                        BlockStateProvider.of(ModBlocks.STYXMOSS), PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(Pool.<BlockState>builder()
                                .add(ModBlocks.STYXMOSS_CARPET.getDefaultState(), 1)
                                .add(ModBlocks.STYXGRASS.getDefaultState(), 2)
                                .add(Blocks.AIR.getDefaultState(), 4)))),
                VerticalSurfaceType.FLOOR,
                ConstantIntProvider.create(1), 0.2f, 5, 0.6f,
                        UniformIntProvider.create(1, 2), 0.3f));
        register(context, STYXMOSS_PATCH_KEY, Feature.VEGETATION_PATCH,
                new VegetationPatchFeatureConfig(BlockTags.MOSS_REPLACEABLE,
                        BlockStateProvider.of(ModBlocks.STYXMOSS), PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(Pool.<BlockState>builder()
                                .add(ModBlocks.STYXMOSS_CARPET.getDefaultState(), 30)
                                .add(ModBlocks.STYXGRASS.getDefaultState(), 50)
                                .add(ModBlocks.KEAPHE_SAPLING.getDefaultState(), 1)
                                .add(Blocks.AIR.getDefaultState(), 150)
                                .add(ModBlocks.CHARMBERRY_BUSH
                                        .getDefaultState().with(GemBerryBushBlock.AGE, 2), 2)
                                .add(ModBlocks.CHARMBERRY_BUSH
                                        .getDefaultState().with(GemBerryBushBlock.AGE, 3), 1)))),
                        VerticalSurfaceType.FLOOR,
                        ConstantIntProvider.create(1), 0.2f, 5, 0.8f,
                        UniformIntProvider.create(4, 6), 0.5f));
        register(context, STYXGRASS_CEILING_KEY, Feature.VEGETATION_PATCH,
                new VegetationPatchFeatureConfig(BlockTags.MOSS_REPLACEABLE,
                        BlockStateProvider.of(ModBlocks.STYXMOSS), PlacedFeatures.createEntry(Feature.BLOCK_COLUMN,
                        new BlockColumnFeatureConfig(List.of(BlockColumnFeatureConfig.createLayer(
                                UniformIntProvider.create(1, 3), BlockStateProvider.of(ModBlocks.HANGING_STYXMOSS.getDefaultState().with(HangingStyxgrassBlock.TIP, false))),
                                BlockColumnFeatureConfig.createLayer(ConstantIntProvider.create(1),
                                        BlockStateProvider.of(ModBlocks.HANGING_STYXMOSS.getDefaultState().with(HangingStyxgrassBlock.TIP, true)))),
                                Direction.DOWN, BlockPredicate.IS_AIR, true)),
                VerticalSurfaceType.CEILING, UniformIntProvider.create(1, 2), 0.5F, 5,
                        0.1F, UniformIntProvider.create(3, 6), 0.3F));
        register(context, ASH_PATCH_KEY, Feature.VEGETATION_PATCH,
                new VegetationPatchFeatureConfig(BlockTags.MOSS_REPLACEABLE,
                        BlockStateProvider.of(ModBlocks.ASH_BLOCK), PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(Pool.<BlockState>builder()
                                .add(DEAD_BUSH.getDefaultState(), 1)
                                .add(Blocks.AIR.getDefaultState(), 49)))),
                        VerticalSurfaceType.FLOOR,
                        ConstantIntProvider.create(1), 0.2f, 5, 0.5f,
                        UniformIntProvider.create(4, 6), 0.5f));

        register(context, KUNZITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldKunziteOres, 15));
        register(context, THERMIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldThermiumOres, 3, 0.3f));
        register(context, THERMIUM_ORE_DRIPSTONE_KEY, Feature.ORE, new OreFeatureConfig(overworldThermiumOres, 5, 0.1f));
        register(context, SULFUR_ORE_KEY, Feature.SCATTERED_ORE, new OreFeatureConfig(netherSulfurOres, 25));
        register(context, STYXIAN_SULFUR_ORE_KEY, Feature.ORE, new OreFeatureConfig(styxianSulfurOres, 13));
        register(context, STYXIAN_AMETHYST_ORE_KEY, Feature.SCATTERED_ORE, new OreFeatureConfig(styxianAmethystOres, 40));
        register(context, PINLINE_ORE_KEY, Feature.SCATTERED_ORE, new OreFeatureConfig(endPinlineOres, 64));
        register(context, STYXCOAL_ORE_KEY, Feature.ORE, new OreFeatureConfig(styxianStyxcoalOres, 16));
        register(context, MOONSTEEL_ORE_KEY, Feature.ORE, new OreFeatureConfig(styxianMoonsteelOres, 11));
        register(context, SUNGAZE_ORE_KEY, Feature.ORE, new OreFeatureConfig(styxianSungazeOres, 7, 0.4f));
        register(context, STYXIAN_LAPIS_ORE_KEY, Feature.ORE, new OreFeatureConfig(styxianLapisOres, 8));
        register(context, COMPRESSED_END_STONE_KEY, Feature.ORE, new OreFeatureConfig(compressedEndStone, 64, 0.3f));
        register(context, COMPRESSED_STYXSTONE_KEY, Feature.ORE, new OreFeatureConfig(
                List.of(OreFeatureConfig.createTarget(new BlockMatchRuleTest(ModBlocks.STYXSTONE), ModBlocks.COMPRESSED_STYXSTONE.getDefaultState())), 64, 0.3f));
        register(context, MABRIZE_KEY, Feature.ORE, new OreFeatureConfig(
                List.of(OreFeatureConfig.createTarget(new BlockMatchRuleTest(ModBlocks.STYXSTONE), ModBlocks.MABRIZE.getDefaultState())), 30, 0.0f));
        register(context, CRAWLER_STONE_KEY, Feature.REPLACE_SINGLE_BLOCK, new EmeraldOreFeatureConfig(crawlerStone));

        register(context, STYXIAN_DELTA_KEY, Feature.DELTA_FEATURE, new DeltaFeatureConfig(
                Blocks.LAVA.getDefaultState(), Blocks.MAGMA_BLOCK.getDefaultState(), UniformIntProvider.create(3, 5), UniformIntProvider.create(1, 3)));

        register(context, CORRUPTION_SPIKE_KEY, ModFeatures.CORRUPTION_SPIKE, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLACK_GOOP)));
        register(context, AMETHYST_SPIKE_KEY, ModFeatures.CORRUPTION_SPIKE, new SimpleBlockFeatureConfig(
                new WeightedBlockStateProvider(Pool.<BlockState>builder()
                .add(AMETHYST_BLOCK.getDefaultState(), 29)
                .add(BUDDING_AMETHYST.getDefaultState(), 1))));
        register(context, CORRUPTION_DISC_KEY, Feature.DISK, new DiskFeatureConfig(
                PredicatedStateProvider.of(ModBlocks.BLACK_GOOP),
                BlockPredicate.matchingBlocks(List.of(ModBlocks.STYXIAN_SOIL, ModBlocks.STYXSTONE)),
                UniformIntProvider.create(4, 5), 1));
        register(context, CORRUPT_ORE_KEY, Feature.ORE, new OreFeatureConfig(
                List.of(OreFeatureConfig.createTarget(new BlockMatchRuleTest(ModBlocks.BLACK_GOOP), ModBlocks.CORRUPT_ORE.getDefaultState())), 3));

        register(context, STYXMOSS_DISK_KEY, Feature.DISK, new DiskFeatureConfig(
                PredicatedStateProvider.of(ModBlocks.STYXMOSS),
                BlockPredicate.matchingBlocks(List.of(ModBlocks.STYXIAN_SOIL, ModBlocks.STYXMOSS)),
                UniformIntProvider.create(3, 5), 1));

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
        register(context, CORRUPTION_CLUMP_KEY, Feature.MULTIFACE_GROWTH, new MultifaceGrowthFeatureConfig(
                (MultifaceGrowthBlock) ModBlocks.CORRUPTION_CLUMP, 40, true, true, true, 0.6f, RegistryEntryList.of(Block::getRegistryEntry, new Block[]{ModBlocks.BLACK_GOOP, ModBlocks.STYXSTONE, ModBlocks.COMPRESSED_STYXSTONE, ModBlocks.MABRIZE})));

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

        register(context, KEAPHE_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.KEAPHE_LOG),
                new BendingTrunkPlacer(5, 2, 1, 6, UniformIntProvider.create(1, 2)),
                new WeightedBlockStateProvider(
                        Pool.<BlockState>builder()
                                .add(ModBlocks.KEAPHE_LEAVES.getDefaultState(), 5)
                                .add(ModBlocks.FLOWERING_KEAPHE_LEAVES.getDefaultState(), 1)
                ),
                new CherryFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(1), ConstantIntProvider.create(4), 0.25F, 0.5F, 0.16666667F, 0.33333334F),
                new TwoLayersFeatureSize(1, 0, 2))
                .decorators(ImmutableList.of(new HangingStyxgrassDecorator(0.25f), new StyxmossVineDecorator()))
                .dirtProvider(BlockStateProvider.of(ModBlocks.STYXIAN_SOIL)).build());

        register(context, TALL_KEAPHE_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.KEAPHE_LOG),
                new BendingTrunkPlacer(9, 3, 2, 10, UniformIntProvider.create(1, 3)),
                new WeightedBlockStateProvider(
                        Pool.<BlockState>builder()
                                .add(ModBlocks.KEAPHE_LEAVES.getDefaultState(), 5)
                                .add(ModBlocks.FLOWERING_KEAPHE_LEAVES.getDefaultState(), 1)
                ),
                new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(1), ConstantIntProvider.create(4), 0.25F, 0.5F, 0.25F, 0.5F),
                new TwoLayersFeatureSize(1, 0, 2))
                .decorators(ImmutableList.of(new HangingStyxgrassDecorator(0.25f)))
                .dirtProvider(BlockStateProvider.of(ModBlocks.STYXIAN_SOIL)).build());

        register(context, GIANT_KEAPHE_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.KEAPHE_LOG),
                new GiantTrunkPlacer(14, 6, 4),
                new WeightedBlockStateProvider(
                        Pool.<BlockState>builder()
                                .add(ModBlocks.KEAPHE_LEAVES.getDefaultState(), 5)
                                .add(ModBlocks.FLOWERING_KEAPHE_LEAVES.getDefaultState(), 1)
                ),
                new JungleFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),
                new TwoLayersFeatureSize(3, 1, 2))
                .decorators(ImmutableList.of(new HangingStyxgrassDecorator(0.25f)))
                .dirtProvider(BlockStateProvider.of(ModBlocks.STYXIAN_SOIL)).build());
        register(context, GIANT_CHERRY_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(CHERRY_LOG),
                new GiantTrunkPlacer(10, 6, 4),
                new WeightedBlockStateProvider(
                        Pool.<BlockState>builder()
                                .add(CHERRY_LEAVES.getDefaultState(), 2)
                                .add(ModBlocks.GLOWING_CHERRY_LEAVES.getDefaultState(), 1)
                ),
                new SpruceFoliagePlacer(ConstantIntProvider.create(4),
                        ConstantIntProvider.create(0),
                        UniformIntProvider.create(6, 8)),
                new TwoLayersFeatureSize(3, 1, 2))
                .dirtProvider(BlockStateProvider.of(ModBlocks.STYXIAN_SOIL)).build());

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
        register(context, STYXGRASS_PATCH_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.STYXGRASS)),
                        List.of(ModBlocks.STYXMOSS, ModBlocks.STYXIAN_SOIL)));
        register(context, CORRUPT_ROOTS_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(
                                Pool.<BlockState>builder()
                                        .add(ModBlocks.CORRUPT_ROOTS.getDefaultState(), 1)
                                        .add(AIR.getDefaultState(), 2))),
                        List.of(ModBlocks.STYXIAN_SOIL, ModBlocks.BLACK_GOOP, ModBlocks.CORRUPT_ORE)));
        register(context, COTTON_PATCH_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(
                                Pool.<BlockState>builder()
                                        .add(ModBlocks.COTTON.getDefaultState().with(CottonCropBlock.AGE, 0), 1)
                                        .add(ModBlocks.COTTON.getDefaultState().with(CottonCropBlock.AGE, 1), 2)
                                        .add(ModBlocks.COTTON.getDefaultState().with(CottonCropBlock.AGE, 2), 2))),
                        List.of(Blocks.DIRT, GRASS_BLOCK)));
        register(context, CHARMBERRY_PATCH_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(
                                Pool.<BlockState>builder()
                                        .add(ModBlocks.CHARMBERRY_BUSH.getDefaultState().with(CharmberryBushBlock.AGE, 2), 2)
                                        .add(ModBlocks.CHARMBERRY_BUSH.getDefaultState().with(CharmberryBushBlock.AGE, 3), 1))),
                        List.of(ModBlocks.STYXIAN_SOIL, ModBlocks.STYXMOSS)));
        register(context, AMETHYST_PATCH_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(
                                Pool.<BlockState>builder()
                                        .add(AMETHYST_CLUSTER.getDefaultState().with(AmethystClusterBlock.FACING, Direction.UP), 1)
                                        .add(SMALL_AMETHYST_BUD.getDefaultState().with(AmethystClusterBlock.FACING, Direction.UP), 5)
                                        .add(MEDIUM_AMETHYST_BUD.getDefaultState().with(AmethystClusterBlock.FACING, Direction.UP), 3)
                                        .add(LARGE_AMETHYST_BUD.getDefaultState().with(AmethystClusterBlock.FACING, Direction.UP), 2))),
                        List.of(ModBlocks.STYXIAN_SOIL, AMETHYST_BLOCK)));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(JirniysPinkStuff.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key,
                                                                                   F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

    private static Pool.Builder<BlockState> flowerbed(Block flowerbed) {
        return segmentedBlock(flowerbed, 1, 4, FlowerbedBlock.FLOWER_AMOUNT, FlowerbedBlock.HORIZONTAL_FACING);
    }

    private static Pool.Builder<BlockState> segmentedBlock(Block block, int min, int max, IntProperty amountProperty, EnumProperty<Direction> facingProperty) {
        Pool.Builder<BlockState> builder = Pool.builder();
        for (int i = min; i <= max; ++i) {
            for (Direction direction : Direction.Type.HORIZONTAL) {
                builder.add((BlockState)((BlockState)block.getDefaultState().with(amountProperty, i)).with(facingProperty, direction), 1);
            }
        }
        return builder;
    }
}
