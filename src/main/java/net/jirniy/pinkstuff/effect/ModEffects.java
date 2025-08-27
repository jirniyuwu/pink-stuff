package net.jirniy.pinkstuff.effect;

import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {

    public static final RegistryEntry<StatusEffect> DAWNBREAKER = registerStatusEffect("dawnbreaker",
            new BlankEffect(StatusEffectCategory.BENEFICIAL, 0xFFC1AD));
    public static final RegistryEntry<StatusEffect> LIFE_TRADE = registerStatusEffect("life_trade",
            new BlankEffect(StatusEffectCategory.NEUTRAL, 0xFF495C));

    public static final RegistryEntry<StatusEffect> FAIRY_SUPPORT = registerStatusEffect("fairy_support",
            new FairySupportStatusEffect(StatusEffectCategory.BENEFICIAL, 0xF2ADEC)
                    .addAttributeModifier(EntityAttributes.ATTACK_DAMAGE,
                            Identifier.of(JirniysPinkStuff.MOD_ID, "effect.fairy_support"),
                            (double)0.5F, EntityAttributeModifier.Operation.ADD_VALUE));
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
    public static final RegistryEntry<StatusEffect> DEATH_GRIP = registerStatusEffect("death_grip",
            new DeathGripEffect(40, StatusEffectCategory.HARMFUL, 0x341411)
                    .addAttributeModifier(EntityAttributes.JUMP_STRENGTH,
                            Identifier.of(JirniysPinkStuff.MOD_ID, "effect.death_grip"),
                            (double)-0.05F, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(EntityAttributes.MOVEMENT_SPEED,
                            Identifier.of(JirniysPinkStuff.MOD_ID, "effect.death_grip"),
                            (double)-0.1F, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    );

    public static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(JirniysPinkStuff.MOD_ID, name), statusEffect);
    }
    public static void registerEffects() {
        JirniysPinkStuff.LOGGER.info("Registering Mod Effects for " + JirniysPinkStuff.MOD_ID);
    }
}
