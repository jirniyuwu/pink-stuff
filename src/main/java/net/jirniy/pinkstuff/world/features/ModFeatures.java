package net.jirniy.pinkstuff.world.features;

import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.feature.*;

public class ModFeatures {
    public static final Feature<SimpleBlockFeatureConfig> CORRUPTION_SPIKE = register("corruption_spike", new CorruptionSpikeFeature(SimpleBlockFeatureConfig.CODEC));
    public static final Feature<SimpleBlockFeatureConfig> ROCK = register("rock", new RockFeature(SimpleBlockFeatureConfig.CODEC));

    private static <C extends FeatureConfig, F extends Feature<C>> F register(String name, F feature) {
        return (F) Registry.register(Registries.FEATURE, name, feature);
    }

    public static void registerFeatures() {
        JirniysPinkStuff.LOGGER.info("Registering Mod Features for " + JirniysPinkStuff.MOD_ID);
    }
}
