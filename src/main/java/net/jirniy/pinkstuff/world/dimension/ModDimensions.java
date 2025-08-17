package net.jirniy.pinkstuff.world.dimension;

import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensions {
    public static final RegistryKey<World> STYXIA = RegistryKey.of(RegistryKeys.WORLD, Identifier.of(JirniysPinkStuff.MOD_ID, "styxia"));
    public static final RegistryKey<DimensionOptions> STYXIA_OPTIONS = RegistryKey.of(RegistryKeys.DIMENSION, Identifier.of(JirniysPinkStuff.MOD_ID, "styxia"));
    public static final RegistryKey<DimensionType> STYXIA_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE, Identifier.of(JirniysPinkStuff.MOD_ID, "styxia_type"));

    public static void registerDimensions() {
        JirniysPinkStuff.LOGGER.info("Registering Mod Dimensions for " + JirniysPinkStuff.MOD_ID);
    }
}
