package net.jirniy.pinkstuff.util;

import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ModDamageTypes {
    public static final RegistryKey<DamageType> DEATH_GRIP = create("death_grip");
    public static final RegistryKey<DamageType> SPIKE_TRAP = create("spike_trap");

    public static DamageSource of(World world, RegistryKey<DamageType> key) {
        return world.getDamageSources().create(key);
    }

    public static RegistryKey<DamageType> create(String path) {
        return RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(JirniysPinkStuff.MOD_ID, path));
    }

    public static void registerDamageTypes() {
        JirniysPinkStuff.LOGGER.info("Registering Damage Types for " + JirniysPinkStuff.MOD_ID);
    }
}