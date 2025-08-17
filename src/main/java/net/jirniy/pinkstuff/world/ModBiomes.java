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
    public static final RegistryKey<Biome> STYXMOSS_OVERGROWTH = register("styxmoss_overgrowth");
    public static final RegistryKey<Biome> KEAPHE_FOREST = register("keaphe_forest");
    public static final RegistryKey<Biome> DRY_OUTSKIRTS = register("dry_outskirts");

    private static RegistryKey<Biome> register(String id) {
        return RegistryKey.of(RegistryKeys.BIOME, Identifier.of(JirniysPinkStuff.MOD_ID + id));
    }

    public static void registerBiomes() {
        JirniysPinkStuff.LOGGER.info("Registering Mod Biomes for " + JirniysPinkStuff.MOD_ID);
    }
}
