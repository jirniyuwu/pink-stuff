package net.jirniy.pinkstuff.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.jirniy.pinkstuff.world.ModPlacedFeatures;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModMiscGeneration {
    public static void generateMisc() {
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_MOUNTAIN),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CLOUD_PLACED_KEY);
    }
}
