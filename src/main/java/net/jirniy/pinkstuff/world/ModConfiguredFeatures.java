package net.jirniy.pinkstuff.world;

import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.block.custom.GemBerryBushBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
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
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.CherryFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.CherryTrunkPlacer;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;

import java.util.List;

import static net.minecraft.block.Blocks.*;

public class ModConfiguredFeatures {
    // CF -> PF -> WG

    public static final RegistryKey<ConfiguredFeature<?, ?>> KUNZITE_ORE_KEY = registryKey("kunzite_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> THERMIUM_ORE_KEY = registryKey("thermium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SULFUR_ORE_KEY = registryKey("sulfur_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GEM_BERRY_BUSH_KEY = registryKey("gem_berry_bush");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GEM_TREE_KEY = registryKey("gem_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CRYSTAL_CHERRY_KEY = registryKey("crystal_cherry");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HAZEWEAVER_PLANT_KEY = registryKey("hazeweaver_plant");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest amethystReplaceables = new BlockMatchRuleTest(AMETHYST_BLOCK);

        List<OreFeatureConfig.Target> overworldKunziteOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.KUNZITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(amethystReplaceables, ModBlocks.AMETHYST_KUNZITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_KUNZITE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> overworldThermiumOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.THERMIUM_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_THERMIUM_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> netherSulfurOres =
                List.of(OreFeatureConfig.createTarget(new BlockMatchRuleTest(BASALT), ModBlocks.NETHER_SULFUR_ORE.getDefaultState()));

        register(context, KUNZITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldKunziteOres, 15));
        register(context, THERMIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldThermiumOres, 3, 0.3f));
        register(context, SULFUR_ORE_KEY, Feature.SCATTERED_ORE, new OreFeatureConfig(netherSulfurOres, 3));

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
