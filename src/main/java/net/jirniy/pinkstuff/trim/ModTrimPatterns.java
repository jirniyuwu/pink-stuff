package net.jirniy.pinkstuff.trim;

import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.trim.ArmorTrimPattern;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class ModTrimPatterns {
    public static final RegistryKey<ArmorTrimPattern> CHERRY = RegistryKey.of(RegistryKeys.TRIM_PATTERN,
            Identifier.of(JirniysPinkStuff.MOD_ID, "cherry"));
    public static final RegistryKey<ArmorTrimPattern> SWORDMASTER = RegistryKey.of(RegistryKeys.TRIM_PATTERN,
            Identifier.of(JirniysPinkStuff.MOD_ID, "swordmaster"));
    public static final RegistryKey<ArmorTrimPattern> SHATTER = RegistryKey.of(RegistryKeys.TRIM_PATTERN,
            Identifier.of(JirniysPinkStuff.MOD_ID, "shatter"));
    public static final RegistryKey<ArmorTrimPattern> BLOOM = RegistryKey.of(RegistryKeys.TRIM_PATTERN,
            Identifier.of(JirniysPinkStuff.MOD_ID, "bloom"));
    public static final RegistryKey<ArmorTrimPattern> CREEPER = RegistryKey.of(RegistryKeys.TRIM_PATTERN,
            Identifier.of(JirniysPinkStuff.MOD_ID, "creeper"));

    public static void bootstrap(Registerable<ArmorTrimPattern> context) {
        register(context, ModItems.CHERRY_SMITHING_TEMPLATE, CHERRY);
        register(context, ModItems.SWORDMASTER_SMITHING_TEMPLATE, SWORDMASTER);
        register(context, ModItems.SHATTER_SMITHING_TEMPLATE, SHATTER);
        register(context, ModItems.BLOOM_SMITHING_TEMPLATE, BLOOM);
        register(context, ModItems.CREEPER_SMITHING_TEMPLATE, CREEPER);
    }

    private static void register(Registerable<ArmorTrimPattern> context, Item item, RegistryKey<ArmorTrimPattern> key) {
        ArmorTrimPattern trimPattern = new ArmorTrimPattern(key.getValue(),
                Text.translatable(Util.createTranslationKey("trim_pattern", key.getValue())), false);

        context.register(key, trimPattern);
    }
}
