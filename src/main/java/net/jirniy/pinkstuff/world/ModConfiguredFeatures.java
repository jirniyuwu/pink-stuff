package net.jirniy.pinkstuff.world;

import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.Pool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.RandomizedIntBlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

import static net.minecraft.block.Blocks.*;

public class ModConfiguredFeatures {
    // CF -> PF -> WG

    public static final RegistryKey<ConfiguredFeature<?, ?>> KUNZITE_ORE_KEY = registryKey("kunzite_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> GEM_TREE_KEY = registryKey("gem_tree");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest amethystReplaceables = new BlockMatchRuleTest(AMETHYST_BLOCK);

        List<OreFeatureConfig.Target> overworldKunziteOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.KUNZITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(amethystReplaceables, ModBlocks.AMETHYST_KUNZITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_KUNZITE_ORE.getDefaultState()));

        register(context, KUNZITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldKunziteOres, 15));

        register(context, GEM_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                new WeightedBlockStateProvider(
                        Pool.<BlockState>builder()
                                .add(AMETHYST_BLOCK.getDefaultState(), 4)
                                .add(BUDDING_AMETHYST.getDefaultState(), 1)
                                .add(ModBlocks.AMETHYST_KUNZITE_ORE.getDefaultState(), 2)
                ),
                new ForkingTrunkPlacer(5, 6, 3),
                BlockStateProvider.of(AIR),
                new BlobFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(1), 1),
                new TwoLayersFeatureSize(3, 1, 4)).build());
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
