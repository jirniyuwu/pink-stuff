package net.jirniy.pinkstuff.enchantment;

import com.mojang.serialization.MapCodec;
import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.enchantment.custom.CleanseEnchantmentEffect;
import net.jirniy.pinkstuff.enchantment.custom.ExperienceSyphonEnchantmentEffect;
import net.jirniy.pinkstuff.enchantment.custom.LightningEnchantmentEffect;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantmentEffects {
    public static final MapCodec<? extends EnchantmentEntityEffect> LIGHTNING =
            registerEntityEffect("lightning", LightningEnchantmentEffect.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> CLEANSE =
            registerEntityEffect("cleanse", CleanseEnchantmentEffect.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> XP_SYPHON =
            registerEntityEffect("xp_syphon", ExperienceSyphonEnchantmentEffect.CODEC);

    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(String name, MapCodec<? extends EnchantmentEntityEffect> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(JirniysPinkStuff.MOD_ID, name), codec);
    };

    public static void registerEnchantmentEffects() {
        JirniysPinkStuff.LOGGER.info("Registering Mod Enchantments for " + JirniysPinkStuff.MOD_ID);
    }
}
