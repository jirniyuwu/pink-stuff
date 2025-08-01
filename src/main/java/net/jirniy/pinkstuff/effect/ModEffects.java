package net.jirniy.pinkstuff.effect;

import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {

    public static final RegistryEntry<StatusEffect> DAWNBREAKER = registerStatusEffect("dawnbreaker",
            new BlankEffect(StatusEffectCategory.BENEFICIAL, 0xFFC1AD));
    public static final RegistryEntry<StatusEffect> GROUNDED = registerStatusEffect("grounded",
            new GroundedEffect(StatusEffectCategory.HARMFUL, 0xA39CB2)
                    .addAttributeModifier(EntityAttributes.GRAVITY,
                            Identifier.of(JirniysPinkStuff.MOD_ID, "effect.grounded"),
                            (double)0.005F, EntityAttributeModifier.Operation.ADD_VALUE)
                    .addAttributeModifier(EntityAttributes.SAFE_FALL_DISTANCE,
                            Identifier.of(JirniysPinkStuff.MOD_ID, "effect.grounded"),
                            (double)-0.5F, EntityAttributeModifier.Operation.ADD_VALUE)
                    .addAttributeModifier(EntityAttributes.FALL_DAMAGE_MULTIPLIER,
                            Identifier.of(JirniysPinkStuff.MOD_ID, "effect.grounded"),
                            (double)0.1F, EntityAttributeModifier.Operation.ADD_VALUE));

    public static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(JirniysPinkStuff.MOD_ID, name), statusEffect);
    }
    public static void registerEffects() {
        JirniysPinkStuff.LOGGER.info("Registering Mod Effects for " + JirniysPinkStuff.MOD_ID);
    }
}
