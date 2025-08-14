package net.jirniy.pinkstuff.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.jirniy.pinkstuff.world.ModBiomes;
import net.jirniy.pinkstuff.world.ModPlacedFeatures;
import net.minecraft.world.gen.GenerationStep;

public class ModMiscGeneration {
    public static void generateMisc() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.CORRUPTED_SPIKES),
                GenerationStep.Feature.SURFACE_STRUCTURES, ModPlacedFeatures.CORRUPTION_DISC_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.STYXIAN_STONY_HILLS),
                GenerationStep.Feature.SURFACE_STRUCTURES, ModPlacedFeatures.CORRUPTION_DISC_PLACED_KEY);
    }
}
