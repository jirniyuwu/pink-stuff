package net.jirniy.pinkstuff.world;

import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.heightprovider.BiasedToBottomHeightProvider;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> KUNZITE_ORE_PLACED_KEY = registerKey("kunzite_ore_placed");
    public static final RegistryKey<PlacedFeature> THERMIUM_ORE_PLACED_KEY = registerKey("thermium_ore_placed");
    public static final RegistryKey<PlacedFeature> DRIPSTONE_THERMIUM_ORE_PLACED_KEY = registerKey("dripstone_thermium_ore_placed");
    public static final RegistryKey<PlacedFeature> SULFUR_ORE_PLACED_KEY = registerKey("sulfur_ore_placed");
    public static final RegistryKey<PlacedFeature> GEM_TREE_PLACED_KEY = registerKey("gem_tree_placed");
    public static final RegistryKey<PlacedFeature> CHORUS_TREE_PLACED_KEY = registerKey("chorus_placed");
    public static final RegistryKey<PlacedFeature> CRYSTAL_CHERRY_PLACED_KEY = registerKey("crystal_cherry_placed");
    public static final RegistryKey<PlacedFeature> GEM_BERRY_BUSH_PLACED_KEY = registerKey("gem_berry_bush_placed");
    public static final RegistryKey<PlacedFeature> HAZEWEAVER_PLANT_PLACED_KEY = registerKey("hazeweaver_plant_placed");
    public static final RegistryKey<PlacedFeature> SMALL_END_GRASS_PLACED_KEY = registerKey("small_end_grass_placed");
    public static final RegistryKey<PlacedFeature> MEDIUM_END_GRASS_PLACED_KEY = registerKey("medium_end_grass_placed");
    public static final RegistryKey<PlacedFeature> LARGE_END_GRASS_PLACED_KEY = registerKey("large_end_grass_placed");
    public static final RegistryKey<PlacedFeature> CHORUS_LILY_PLACED_KEY = registerKey("chorus_lily_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, KUNZITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.KUNZITE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(14,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-40), YOffset.fixed(200)))
                );

        register(context, THERMIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.THERMIUM_ORE_KEY),
                ModOrePlacement.modifiersWithCount(4,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-100), YOffset.fixed(10)))
        );

        register(context, DRIPSTONE_THERMIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.THERMIUM_ORE_KEY),
                ModOrePlacement.modifiersWithCount(9,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-100), YOffset.fixed(40)))
        );

        register(context, SULFUR_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SULFUR_ORE_KEY),
                ModOrePlacement.modifiersWithCount(8,
                        HeightRangePlacementModifier.of(
                                BiasedToBottomHeightProvider.create(YOffset.BOTTOM, YOffset.fixed(100), 1)))
        );

        register(context, GEM_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.GEM_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(1, 0.1f, 0), Blocks.CHERRY_SAPLING
                ));

        register(context, CRYSTAL_CHERRY_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRYSTAL_CHERRY_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(2, 0.1f, 2), ModBlocks.CRYSTAL_CHERRY_SAPLING
                ));

        register(context, CHORUS_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CHORUS_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(0, 0.2f, 1), ModBlocks.CHORUS_SAPLING
                ));

        register(context, GEM_BERRY_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.GEM_BERRY_BUSH_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, HAZEWEAVER_PLANT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.HAZEWEAVER_PLANT_KEY),
                RarityFilterPlacementModifier.of(516), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SMALL_END_GRASS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SMALL_END_GRASS_KEY),
                RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, MEDIUM_END_GRASS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MEDIUM_END_GRASS_KEY),
                RarityFilterPlacementModifier.of(8), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, LARGE_END_GRASS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LARGE_END_GRASS_KEY),
                RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, CHORUS_LILY_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CHORUS_LILY_KEY),
                RarityFilterPlacementModifier.of(16), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(JirniysPinkStuff.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
