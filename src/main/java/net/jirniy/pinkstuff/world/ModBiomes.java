package net.jirniy.pinkstuff.world;

import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class ModBiomes {
    public static final RegistryKey<Biome> STYXIAN_PLAINS = register("styxian_plains");
    public static final RegistryKey<Biome> CORRUPTED_SPIKES = register("corrupted_spikes");
    public static final RegistryKey<Biome> STYXIAN_STONY_HILLS = register("styxian_stony_hills");

    private static RegistryKey<Biome> register(String id) {
        return RegistryKey.of(RegistryKeys.BIOME, Identifier.of(JirniysPinkStuff.MOD_ID + id));
    }

    public static void registerBiomes() {
        JirniysPinkStuff.LOGGER.info("Registering Mod Biomes for " + JirniysPinkStuff.MOD_ID);
    }
}
