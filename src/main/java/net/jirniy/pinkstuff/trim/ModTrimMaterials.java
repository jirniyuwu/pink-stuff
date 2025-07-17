package net.jirniy.pinkstuff.trim;

import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.trim.ArmorTrimAssets;
import net.minecraft.item.equipment.trim.ArmorTrimMaterial;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class ModTrimMaterials {
    public static final RegistryKey<ArmorTrimMaterial> KUNZITE = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(JirniysPinkStuff.MOD_ID, "kunzite"));
    public static final RegistryKey<ArmorTrimMaterial> ELYSIUM = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(JirniysPinkStuff.MOD_ID, "elysium"));
    public static final RegistryKey<ArmorTrimMaterial> THERMIUM = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(JirniysPinkStuff.MOD_ID, "thermium"));
    public static final RegistryKey<ArmorTrimMaterial> MEMORY = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(JirniysPinkStuff.MOD_ID, "memory"));
    public static final RegistryKey<ArmorTrimMaterial> SULFUR = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(JirniysPinkStuff.MOD_ID, "sulfur"));

    public static void bootstrap(Registerable<ArmorTrimMaterial> registerable) {
        register(registerable, KUNZITE, Registries.ITEM.getEntry(ModItems.KUNZITE),
                Style.EMPTY.withColor(TextColor.parse("#e97bee").getOrThrow()), "kunzite");
        register(registerable, ELYSIUM, Registries.ITEM.getEntry(ModItems.ELYSIUM_INGOT),
                Style.EMPTY.withColor(TextColor.parse("#e48bd3").getOrThrow()), "elysium");
        register(registerable, THERMIUM, Registries.ITEM.getEntry(ModItems.THERMIUM),
                Style.EMPTY.withColor(TextColor.parse("#dfffa8").getOrThrow()), "thermium");
        register(registerable, MEMORY, Registries.ITEM.getEntry(ModItems.MEMORY_SHARD),
                Style.EMPTY.withColor(TextColor.parse("#470d86").getOrThrow()), "memory");
        register(registerable, SULFUR, Registries.ITEM.getEntry(ModItems.MEMORY_SHARD),
                Style.EMPTY.withColor(TextColor.parse("#c4bd99").getOrThrow()), "sulfur");
    }

    private static void register(Registerable<ArmorTrimMaterial> registerable, RegistryKey<ArmorTrimMaterial> armorTrimKey,
                                 RegistryEntry<Item> item, Style style, String suffix) {
        ArmorTrimMaterial trimMaterial = new ArmorTrimMaterial(ArmorTrimAssets.of(suffix),
                Text.translatable(Util.createTranslationKey("trim_material", armorTrimKey.getValue())).fillStyle(style));

        registerable.register(armorTrimKey, trimMaterial);
    }
}
