package net.jirniy.pinkstuff.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.jirniy.pinkstuff.world.ModBiomes;
import net.jirniy.pinkstuff.world.ModPlacedFeatures;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModTreeGeneration {
    public static void generateTrees() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.CHERRY_GROVE),
                GenerationStep.Feature.SURFACE_STRUCTURES, ModPlacedFeatures.GEM_TREE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.CHERRY_GROVE),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CRYSTAL_CHERRY_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_MIDLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CHORUS_TREE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.ERODED_BADLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ASHEN_TREE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SNOWY_PLAINS,
                        BiomeKeys.SNOWY_TAIGA, BiomeKeys.ICE_SPIKES),
                GenerationStep.Feature.SURFACE_STRUCTURES, ModPlacedFeatures.SNOWY_SPRUCE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.CORRUPTED_SPIKES),
                GenerationStep.Feature.SURFACE_STRUCTURES, ModPlacedFeatures.SNOWY_SPRUCE_PLACED_KEY);
    }
}
