package net.jirniy.pinkstuff.world;

import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.heightprovider.BiasedToBottomHeightProvider;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> KUNZITE_ORE_PLACED_KEY = registerKey("kunzite_ore_placed");
    public static final RegistryKey<PlacedFeature> STYXIAN_AMETHYST_ORE_PLACED_KEY = registerKey("styxian_amethyst_ore_placed");
    public static final RegistryKey<PlacedFeature> THERMIUM_ORE_PLACED_KEY = registerKey("thermium_ore_placed");
    public static final RegistryKey<PlacedFeature> DRIPSTONE_THERMIUM_ORE_PLACED_KEY = registerKey("dripstone_thermium_ore_placed");
    public static final RegistryKey<PlacedFeature> SULFUR_ORE_PLACED_KEY = registerKey("sulfur_ore_placed");
    public static final RegistryKey<PlacedFeature> STYXCOAL_ORE_PLACED_KEY = registerKey("styxcoal_ore_placed");
    public static final RegistryKey<PlacedFeature> STYXCOAL_ORE_BONUS_PLACED_KEY = registerKey("styxcoal_ore_bonus_placed");
    public static final RegistryKey<PlacedFeature> MOONSTEEL_ORE_PLACED_KEY = registerKey("moonsteel_ore_placed");
    public static final RegistryKey<PlacedFeature> PINLINE_ORE_PLACED_KEY = registerKey("pinline_ore_placed");
    public static final RegistryKey<PlacedFeature> CORRUPT_ORE_PLACED_KEY = registerKey("corrupt_ore_placed");
    public static final RegistryKey<PlacedFeature> GEM_TREE_PLACED_KEY = registerKey("gem_tree_placed");
    public static final RegistryKey<PlacedFeature> CHORUS_TREE_PLACED_KEY = registerKey("chorus_placed");
    public static final RegistryKey<PlacedFeature> ASHEN_TREE_PLACED_KEY = registerKey("ashen_placed");
    public static final RegistryKey<PlacedFeature> KEAPHE_TREE_PLACED_KEY = registerKey("keaphe_placed");
    public static final RegistryKey<PlacedFeature> KEAPHE_FOREST_PLACED_KEY = registerKey("keaphe_forest_placed");
    public static final RegistryKey<PlacedFeature> GIANT_KEAPHE_TREE_PLACED_KEY = registerKey("giant_keaphe_placed");
    public static final RegistryKey<PlacedFeature> CRYSTAL_CHERRY_PLACED_KEY = registerKey("crystal_cherry_placed");
    public static final RegistryKey<PlacedFeature> SNOWY_SPRUCE_PLACED_KEY = registerKey("snowy_spruce_placed");
    public static final RegistryKey<PlacedFeature> GEM_BERRY_BUSH_PLACED_KEY = registerKey("gem_berry_bush_placed");
    public static final RegistryKey<PlacedFeature> HAZEWEAVER_PLANT_PLACED_KEY = registerKey("hazeweaver_plant_placed");
    public static final RegistryKey<PlacedFeature> SMALL_END_GRASS_PLACED_KEY = registerKey("small_end_grass_placed");
    public static final RegistryKey<PlacedFeature> MEDIUM_END_GRASS_PLACED_KEY = registerKey("medium_end_grass_placed");
    public static final RegistryKey<PlacedFeature> LARGE_END_GRASS_PLACED_KEY = registerKey("large_end_grass_placed");
    public static final RegistryKey<PlacedFeature> CHORUS_LILY_PLACED_KEY = registerKey("chorus_lily_placed");
    public static final RegistryKey<PlacedFeature> COMPRESSEND_END_STONE_PLACED_KEY = registerKey("compressed_end_stone_placed");
    public static final RegistryKey<PlacedFeature> COMPRESSED_STYXSTONE_PLACED_KEY = registerKey("compressed_styxstone_placed");
    public static final RegistryKey<PlacedFeature> MABRIZE_PLACED_KEY = registerKey("mabrize_placed");
    public static final RegistryKey<PlacedFeature> KUNZITE_GEODE_LUSH_PLACED_KEY = registerKey("kunzite_geode_lush_placed");
    public static final RegistryKey<PlacedFeature> KUNZITE_GEODE_CHERRY_PLACED_KEY = registerKey("kunzite_geode_cherry_placed");
    public static final RegistryKey<PlacedFeature> AMETHYST_CLUMP_PLACED_KEY = registerKey("amethyst_clump_placed");
    public static final RegistryKey<PlacedFeature> DIAMOND_CLUMP_PLACED_KEY = registerKey("diamond_clump_placed");
    public static final RegistryKey<PlacedFeature> EMERALD_CLUMP_PLACED_KEY = registerKey("emerald_clump_placed");
    public static final RegistryKey<PlacedFeature> QUARTZ_CLUMP_PLACED_KEY = registerKey("quartz_clump_placed");
    public static final RegistryKey<PlacedFeature> KUNZITE_CLUMP_PLACED_KEY = registerKey("kunzite_clump_placed");
    public static final RegistryKey<PlacedFeature> THERMIUM_CLUMP_PLACED_KEY = registerKey("thermium_clump_placed");
    public static final RegistryKey<PlacedFeature> CORRUPTION_CLUMP_PLACED_KEY = registerKey("corruption_clump_placed");
    public static final RegistryKey<PlacedFeature> CORRUPTION_SPIKE_PLACED_KEY = registerKey("corruption_spike_placed");
    public static final RegistryKey<PlacedFeature> CORRUPTION_DISC_PLACED_KEY = registerKey("corruption_disc_placed");
    public static final RegistryKey<PlacedFeature> CORRUPT_ROOTS_PLACED_KEY = registerKey("corrupt_roots_placed");
    public static final RegistryKey<PlacedFeature> DEATHFLOWER_PLACED_KEY = registerKey("deathflower_placed");
    public static final RegistryKey<PlacedFeature> STYXIAN_ROCK_PLACED_KEY = registerKey("styxian_rock_placed");
    public static final RegistryKey<PlacedFeature> MOSSY_STYXIAN_ROCK_PLACED_KEY = registerKey("mossy_styxian_rock_placed");
    public static final RegistryKey<PlacedFeature> STYXMOSS_VEGETATION_PLACED_KEY = registerKey("styxmoss_vegetation_placed");
    public static final RegistryKey<PlacedFeature> STYXMOSS_PATCH_PLACED_KEY = registerKey("styxmoss_patch_placed");
    public static final RegistryKey<PlacedFeature> STYXGRASS_PATCH_PLACED_KEY = registerKey("styxgrass_patch_placed");
    public static final RegistryKey<PlacedFeature> STYXMOSS_DISC_PLACED_KEY = registerKey("styxmoss_disc_placed");

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
        register(context, STYXIAN_AMETHYST_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.STYXIAN_AMETHYST_ORE_KEY),
                ModOrePlacement.modifiersWithCount(3,
                        HeightRangePlacementModifier.of(
                                BiasedToBottomHeightProvider.create(YOffset.BOTTOM, YOffset.fixed(100), 1)))
        );
        register(context, PINLINE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PINLINE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(2,
                        HeightRangePlacementModifier.of(
                                BiasedToBottomHeightProvider.create(YOffset.fixed(0), YOffset.fixed(60), 1)))
        );
        register(context, MOONSTEEL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MOONSTEEL_ORE_KEY),
                ModOrePlacement.modifiersWithCount(15,
                        HeightRangePlacementModifier.of(
                                BiasedToBottomHeightProvider.create(YOffset.BOTTOM, YOffset.fixed(90), 1)))
        );
        register(context, STYXCOAL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.STYXCOAL_ORE_KEY),
                ModOrePlacement.modifiersWithCount(9,
                        HeightRangePlacementModifier.uniform(YOffset.BOTTOM, YOffset.fixed(100)))
        );
        register(context, STYXCOAL_ORE_BONUS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.STYXCOAL_ORE_KEY),
                ModOrePlacement.modifiersWithCount(30,
                        HeightRangePlacementModifier.trapezoid(YOffset.BOTTOM, YOffset.fixed(200)))
        );
        register(context, COMPRESSEND_END_STONE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.COMPRESSED_END_STONE_KEY),
                ModOrePlacement.modifiersWithCount(13,
                        HeightRangePlacementModifier.of(
                                BiasedToBottomHeightProvider.create(YOffset.BOTTOM, YOffset.fixed(50), 2)))
        );
        register(context, COMPRESSED_STYXSTONE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.COMPRESSED_STYXSTONE_KEY),
                ModOrePlacement.modifiersWithCount(15,
                        HeightRangePlacementModifier.of(
                                BiasedToBottomHeightProvider.create(YOffset.BOTTOM, YOffset.fixed(90), 4)))
        );
        register(context, MABRIZE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MABRIZE_KEY),
                ModOrePlacement.modifiersWithCount(9,
                        HeightRangePlacementModifier.trapezoid(YOffset.BOTTOM, YOffset.fixed(90))));

        register(context, DEATHFLOWER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DEATHFLOWER_KEY),
                NoiseThresholdCountPlacementModifier.of(-0.8, 5, 10), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, CORRUPTION_SPIKE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CORRUPTION_SPIKE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(6, 0.5f, 3), Blocks.SHORT_GRASS
                ));
        register(context, CORRUPTION_DISC_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CORRUPTION_DISC_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(3, 0.5f, 3), Blocks.SHORT_GRASS
                ));
        register(context, CORRUPT_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CORRUPT_ORE_KEY),
                ModOrePlacement.modifiersWithCount(160,
                        HeightRangePlacementModifier.of(
                                BiasedToBottomHeightProvider.create(YOffset.fixed(40), YOffset.fixed(320), 2))
        ));
        register(context, STYXMOSS_DISC_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.STYXMOSS_DISK_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(1, 0.5f, 1), ModBlocks.STYXGRASS
                ));
        register(context, STYXIAN_ROCK_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.STYXIAN_ROCK_KEY),
                CountPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_NO_LEAVES_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, MOSSY_STYXIAN_ROCK_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MOSSY_STYXIAN_ROCK_KEY),
                CountPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_NO_LEAVES_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, STYXMOSS_VEGETATION_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.STYXMOSS_VEGETATION_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(5, 0.5f, 3), ModBlocks.STYXGRASS
                ));
        register(context, STYXMOSS_PATCH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.STYXMOSS_PATCH_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(3, 0.5f, 1), ModBlocks.STYXGRASS
                ));

        register(context, AMETHYST_CLUMP_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.AMETHYST_CLUMP_KEY),
                new PlacementModifier[]{CountPlacementModifier.of(UniformIntProvider.create(10, 30)),
                        PlacedFeatures.BOTTOM_TO_120_RANGE, SquarePlacementModifier.of(),
                        SurfaceThresholdFilterPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG, Integer.MIN_VALUE, -13),
                        BiomePlacementModifier.of()});
        register(context, DIAMOND_CLUMP_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DIAMOND_CLUMP_KEY),
                new PlacementModifier[]{CountPlacementModifier.of(UniformIntProvider.create(5, 10)),
                        HeightRangePlacementModifier.trapezoid(YOffset.BOTTOM, YOffset.fixed(30)), SquarePlacementModifier.of(),
                        SurfaceThresholdFilterPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG, Integer.MIN_VALUE, -13),
                        BiomePlacementModifier.of()});
        register(context, EMERALD_CLUMP_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.EMERALD_CLUMP_KEY),
                new PlacementModifier[]{CountPlacementModifier.of(UniformIntProvider.create(10, 60)),
                        HeightRangePlacementModifier.trapezoid(YOffset.BOTTOM, YOffset.fixed(120)), SquarePlacementModifier.of(),
                        SurfaceThresholdFilterPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG, Integer.MIN_VALUE, -13),
                        BiomePlacementModifier.of()});
        register(context, QUARTZ_CLUMP_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.QUARTZ_CLUMP_KEY),
                new PlacementModifier[]{CountPlacementModifier.of(UniformIntProvider.create(15, 40)),
                        PlacedFeatures.BOTTOM_TO_TOP_RANGE, SquarePlacementModifier.of(),
                        BiomePlacementModifier.of()});
        register(context, KUNZITE_CLUMP_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.KUNZITE_CLUMP_KEY),
                new PlacementModifier[]{CountPlacementModifier.of(UniformIntProvider.create(15, 50)),
                        PlacedFeatures.BOTTOM_TO_120_RANGE, SquarePlacementModifier.of(),
                        SurfaceThresholdFilterPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG, Integer.MIN_VALUE, -13),
                        BiomePlacementModifier.of()});
        register(context, THERMIUM_CLUMP_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.THERMIUM_CLUMP_KEY),
                new PlacementModifier[]{CountPlacementModifier.of(UniformIntProvider.create(1, 3)),
                        HeightRangePlacementModifier.trapezoid(YOffset.BOTTOM, YOffset.fixed(20)), SquarePlacementModifier.of(),
                        SurfaceThresholdFilterPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG, Integer.MIN_VALUE, -13),
                        BiomePlacementModifier.of()});
        register(context, CORRUPTION_CLUMP_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CORRUPTION_CLUMP_KEY),
                new PlacementModifier[]{CountPlacementModifier.of(UniformIntProvider.create(200, 256)),
                        HeightRangePlacementModifier.uniform(YOffset.BOTTOM, YOffset.fixed(180)), SquarePlacementModifier.of(),
                        BiomePlacementModifier.of()});

        register(context, GEM_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.GEM_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(1, 0.1f, 0), Blocks.CHERRY_SAPLING
                ));

        register(context, ASHEN_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ASHEN_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(0, 0.1f, 1), Blocks.DEAD_BUSH
                ));

        register(context, KEAPHE_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.KEAPHE_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(0, 0.5f, 1), ModBlocks.KEAPHE_SAPLING
                ));
        register(context, GIANT_KEAPHE_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.GIANT_KEAPHE_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(1, 0.5f, 2), ModBlocks.KEAPHE_SAPLING
                ));
        register(context, KEAPHE_FOREST_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.KEAPHE_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(2, 0.5f, 2), ModBlocks.KEAPHE_SAPLING
                ));

        register(context, SNOWY_SPRUCE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SNOWY_SPRUCE_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(0, 0.1f, 1), ModBlocks.SNOWY_SPRUCE_SAPLING
                ));

        register(context, CRYSTAL_CHERRY_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRYSTAL_CHERRY_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(2, 0.1f, 2), ModBlocks.CRYSTAL_CHERRY_SAPLING
                ));

        register(context, CHORUS_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CHORUS_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(0, 0.2f, 1), ModBlocks.CHORUS_SAPLING
                ));

        register(context, KUNZITE_GEODE_LUSH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.KUNZITE_GEODE_KEY),
                HeightRangePlacementModifier.trapezoid(YOffset.BOTTOM, YOffset.fixed(40)),
                PlacedFeatures.createCountExtraModifier(0, 0.5f, 1));
        register(context, KUNZITE_GEODE_CHERRY_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.KUNZITE_GEODE_KEY),
                HeightRangePlacementModifier.trapezoid(YOffset.BOTTOM, YOffset.fixed(100)),
                PlacedFeatures.createCountExtraModifier(1, 0.5f, 1));

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
        register(context, STYXGRASS_PATCH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.STYXGRASS_PATCH_KEY),
                RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, CORRUPT_ROOTS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CORRUPT_ROOTS_KEY),
                RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
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
