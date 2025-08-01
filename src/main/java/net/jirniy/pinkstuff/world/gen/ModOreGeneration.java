package net.jirniy.pinkstuff.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.jirniy.pinkstuff.world.ModPlacedFeatures;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.CHERRY_GROVE, BiomeKeys.LUSH_CAVES), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.KUNZITE_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.CHERRY_GROVE), GenerationStep.Feature.UNDERGROUND_DECORATION,
                ModPlacedFeatures.KUNZITE_GEODE_CHERRY_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.LUSH_CAVES), GenerationStep.Feature.UNDERGROUND_DECORATION,
                ModPlacedFeatures.KUNZITE_GEODE_LUSH_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.THERMIUM_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DRIPSTONE_CAVES), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.DRIPSTONE_THERMIUM_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BASALT_DELTAS), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.SULFUR_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS,
                        BiomeKeys.END_MIDLANDS, BiomeKeys.END_BARRENS, BiomeKeys.SMALL_END_ISLANDS), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.PINLINE_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.COMPRESSEND_END_STONE_PLACED_KEY);
    }
}