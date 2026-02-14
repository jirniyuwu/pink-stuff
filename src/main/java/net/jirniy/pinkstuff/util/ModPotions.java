package net.jirniy.pinkstuff.util;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.effect.ModEffects;
import net.jirniy.pinkstuff.item.ModItems;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static final RegistryEntry<Potion> GROUNDED = registerPotion("grounded",
            new Potion("grounded", new StatusEffectInstance(ModEffects.GROUNDED, 400, 0)));
    public static final RegistryEntry<Potion> STRONG_GROUNDED = registerPotion("strong_grounded",
            new Potion("grounded", new StatusEffectInstance(ModEffects.GROUNDED, 200, 1)));

    public static final RegistryEntry<Potion> LIFE_TRADE = registerPotion("life_trade",
            new Potion("life_trade", new StatusEffectInstance(ModEffects.LIFE_TRADE, 3600, 0)));
    public static final RegistryEntry<Potion> LONG_LIFE_TRADE = registerPotion("long_life_trade",
            new Potion("life_trade", new StatusEffectInstance(ModEffects.LIFE_TRADE, 9600, 0)));
    public static final RegistryEntry<Potion> STRONG_LIFE_TRADE = registerPotion("strong_life_trade",
            new Potion("life_trade", new StatusEffectInstance(ModEffects.LIFE_TRADE, 1800, 1)));

    public static final RegistryEntry<Potion> VULNERABILITY = registerPotion("vulnerability",
            new Potion("vulnerability", new StatusEffectInstance(ModEffects.VULNERABILITY, 3600, 0)));
    public static final RegistryEntry<Potion> LONG_VULNERABILITY = registerPotion("long_vulnerability",
            new Potion("vulnerability", new StatusEffectInstance(ModEffects.VULNERABILITY, 9600, 0)));
    public static final RegistryEntry<Potion> STRONG_VULNERABILITY = registerPotion("strong_vulnerability",
            new Potion("vulnerability", new StatusEffectInstance(ModEffects.VULNERABILITY, 1800, 1)));

    public static final RegistryEntry<Potion> HEARTBREAK = registerPotion("heartbreak",
            new Potion("heartbreak", new StatusEffectInstance(ModEffects.HEARTBREAK, 3600, 0)));
    public static final RegistryEntry<Potion> LONG_HEARTBREAK = registerPotion("long_heartbreak",
            new Potion("heartbreak", new StatusEffectInstance(ModEffects.HEARTBREAK, 9600, 0)));
    public static final RegistryEntry<Potion> STRONG_HEARTBREAK = registerPotion("strong_heartbreak",
            new Potion("heartbreak", new StatusEffectInstance(ModEffects.HEARTBREAK, 1800, 1)));

    public static final RegistryEntry<Potion> FAIRY_SUPPORT = registerPotion("fairy_support",
            new Potion("fairy_support", new StatusEffectInstance(ModEffects.FAIRY_SUPPORT, 900, 0)));
    public static final RegistryEntry<Potion> LONG_FAIRY_SUPPORT = registerPotion("long_fairy_support",
            new Potion("fairy_support", new StatusEffectInstance(ModEffects.FAIRY_SUPPORT, 1800, 0)));
    public static final RegistryEntry<Potion> STRONG_FAIRY_SUPPORT = registerPotion("strong_fairy_support",
            new Potion("fairy_support", new StatusEffectInstance(ModEffects.FAIRY_SUPPORT, 400, 1)));

    public static final RegistryEntry<Potion> ADRENALINE = registerPotion("adrenaline",
            new Potion("adrenaline", new StatusEffectInstance(ModEffects.VULNERABILITY, 900, 0),
                    new StatusEffectInstance(StatusEffects.SPEED, 900, 1)));
    public static final RegistryEntry<Potion> STRONG_ADRENALINE = registerPotion("strong_adrenaline",
            new Potion("adrenaline", new StatusEffectInstance(ModEffects.VULNERABILITY, 400, 1),
                    new StatusEffectInstance(StatusEffects.SPEED, 400, 3)));
    public static final RegistryEntry<Potion> STRONG_ADRENALINE_2 = registerPotion("strong_adrenaline_2",
            new Potion("adrenaline", new StatusEffectInstance(ModEffects.VULNERABILITY, 160, 2),
                    new StatusEffectInstance(StatusEffects.SPEED, 160, 5)));

    public static final RegistryEntry<Potion> CORRUPT = registerPotion("corrupt",
            new Potion("corrupt", new StatusEffectInstance(ModEffects.DEATH_GRIP, 800, 0)));
    public static final RegistryEntry<Potion> STRONG_CORRUPT = registerPotion("strong_corrupt",
            new Potion("corrupt", new StatusEffectInstance(ModEffects.DEATH_GRIP, 400, 1)));

    public static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(JirniysPinkStuff.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        JirniysPinkStuff.LOGGER.info("Registering Mod Potions for " + JirniysPinkStuff.MOD_ID);

        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(Potions.AWKWARD, ModItems.PREPARED_PINLINE, ModPotions.GROUNDED);
            builder.registerPotionRecipe(ModPotions.GROUNDED, Items.GLOWSTONE_DUST, ModPotions.STRONG_GROUNDED);
            builder.registerPotionRecipe(Potions.SLOW_FALLING, Items.FERMENTED_SPIDER_EYE, ModPotions.GROUNDED);

            builder.registerPotionRecipe(Potions.AWKWARD, ModItems.RAINBOW_MINERAL, ModPotions.ADRENALINE);
            builder.registerPotionRecipe(ModPotions.ADRENALINE, Items.GLOWSTONE_DUST, ModPotions.STRONG_ADRENALINE);
            builder.registerPotionRecipe(ModPotions.STRONG_ADRENALINE, Items.GLOWSTONE_DUST, ModPotions.STRONG_ADRENALINE_2);

            builder.registerPotionRecipe(Potions.AWKWARD, ModItems.ELYSIUM_INGOT, ModPotions.LIFE_TRADE);
            builder.registerPotionRecipe(ModPotions.LIFE_TRADE, Items.GLOWSTONE_DUST, ModPotions.STRONG_LIFE_TRADE);
            builder.registerPotionRecipe(ModPotions.LIFE_TRADE, Items.REDSTONE, ModPotions.LONG_LIFE_TRADE);

            builder.registerPotionRecipe(Potions.AWKWARD, ModItems.MAGIC_GLITTER, ModPotions.FAIRY_SUPPORT);
            builder.registerPotionRecipe(ModPotions.FAIRY_SUPPORT, Items.GLOWSTONE_DUST, ModPotions.STRONG_FAIRY_SUPPORT);
            builder.registerPotionRecipe(ModPotions.FAIRY_SUPPORT, Items.REDSTONE, ModPotions.LONG_FAIRY_SUPPORT);

            builder.registerPotionRecipe(Potions.AWKWARD, ModItems.CERILLE_NUGGET, ModPotions.HEARTBREAK);
            builder.registerPotionRecipe(ModPotions.HEARTBREAK, Items.GLOWSTONE_DUST, ModPotions.STRONG_HEARTBREAK);
            builder.registerPotionRecipe(ModPotions.HEARTBREAK, Items.REDSTONE, ModPotions.LONG_HEARTBREAK);

            builder.registerPotionRecipe(Potions.AWKWARD, ModItems.RAW_MOONSTEEL, ModPotions.VULNERABILITY);
            builder.registerPotionRecipe(ModPotions.VULNERABILITY, Items.GLOWSTONE_DUST, ModPotions.STRONG_VULNERABILITY);
            builder.registerPotionRecipe(ModPotions.VULNERABILITY, Items.REDSTONE, ModPotions.LONG_VULNERABILITY);

            builder.registerPotionRecipe(Potions.AWKWARD, ModItems.CORRUPT_MASS, ModPotions.CORRUPT);
            builder.registerPotionRecipe(ModPotions.CORRUPT, Items.GLOWSTONE_DUST, ModPotions.STRONG_CORRUPT);
        });
    }
}
