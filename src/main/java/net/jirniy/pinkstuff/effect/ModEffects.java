package net.jirniy.pinkstuff.effect;

import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {

    public static final RegistryEntry<StatusEffect> DAWNBREAKER = registerStatusEffect("dawnbreaker",
            new BlankEffect(StatusEffectCategory.BENEFICIAL, 0xFFC1AD));

    public static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(JirniysPinkStuff.MOD_ID, name), statusEffect);
    }
    public static void registerEffects() {
        JirniysPinkStuff.LOGGER.info("Registering Mod Effects for " + JirniysPinkStuff.MOD_ID);
    }
}
