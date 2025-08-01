package net.jirniy.pinkstuff.util;

import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static final RegistryEntry<Potion> GROUNDED = registerPotion("grounded",
            new Potion("grounded", new StatusEffectInstance(ModEffects.GROUNDED, 400, 0)));
    public static final RegistryEntry<Potion> STRONG_GROUNDED = registerPotion("strong_grounded",
            new Potion("grounded", new StatusEffectInstance(ModEffects.GROUNDED, 200, 1)));

    public static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(JirniysPinkStuff.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        JirniysPinkStuff.LOGGER.info("Registering Mod Potions for " + JirniysPinkStuff.MOD_ID);
    }
}
