package net.jirniy.pinkstuff.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.jirniy.pinkstuff.world.ModPlacedFeatures;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModBushGeneration {
    public static void generateBushes() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.CHERRY_GROVE),
            GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.GEM_BERRY_BUSH_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.excludeByKey(BiomeKeys.OCEAN, BiomeKeys.DEEP_OCEAN, BiomeKeys.FROZEN_OCEAN,
                        BiomeKeys.DEEP_FROZEN_OCEAN, BiomeKeys.DEEP_COLD_OCEAN, BiomeKeys.COLD_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN,
                        BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.WARM_OCEAN, BiomeKeys.RIVER, BiomeKeys.FROZEN_RIVER),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.HAZEWEAVER_PLANT_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.SMALL_END_GRASS_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MEDIUM_END_GRASS_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LARGE_END_GRASS_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_MIDLANDS, BiomeKeys.END_HIGHLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CHORUS_LILY_PLACED_KEY);
    }
}
