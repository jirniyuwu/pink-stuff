package net.jirniy.pinkstuff.item;


import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.item.custom.HammerItem;
import net.jirniy.pinkstuff.item.custom.ModArmorItem;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    public static final Item KUNZITE = registerItem("kunzite", Item::new);
    public static final Item RAW_KUNZITE = registerItem("raw_kunzite", Item::new);
    public static final Item CRYSTAL_GLITTER = registerItem("crystal_glitter", Item::new);
    public static final Item ELYSIUM_INGOT = registerItem("elysium_ingot", Item::new);
    public static final Item ELYSIAN_REDSTONE_CORE = registerItem("elysian_redstone_core", Item::new);
    public static final Item PINK_BITS = registerItem("pink_bits", Item::new);
//    public static final Item KUNZITE = registerItem(new Item.Settings(), "kunzite");
//    public static final Item RAW_KUNZITE = registerItem(new Item.Settings(), "raw_kunzite");
//    public static final Item CRYSTAL_GLITTER = registerItem(new Item.Settings(), "crystal_glitter");
//    public static final Item ELYSIUM_INGOT = registerItem(new Item.Settings(), "elysium_ingot");
//    public static final Item ELYSIAN_REDSTONE_CORE = registerItem(new Item.Settings(), "elysian_redstone_core");
//    public static final Item PINK_BITS = registerItem(new Item.Settings(), "pink_bits");

    public static final Item KUNZITE_SWORD = registerItem("kunzite_sword",
            setting -> new Item(setting.sword(ModToolMaterials.KUNZITE, 5, -2.4f)));
    public static final Item KUNZITE_PICKAXE = registerItem("kunzite_pickaxe",
            setting -> new Item(setting.pickaxe(ModToolMaterials.KUNZITE, 1, -2.8f)));
    public static final Item KUNZITE_SHOVEL = registerItem("kunzite_shovel",
            setting -> new ShovelItem(ModToolMaterials.KUNZITE, 1.5f, -3.0f, setting));
    public static final Item KUNZITE_AXE = registerItem("kunzite_axe",
            setting -> new AxeItem(ModToolMaterials.KUNZITE, 8, -3.2f, setting));
    public static final Item KUNZITE_HOE = registerItem("kunzite_hoe",
            setting -> new HoeItem(ModToolMaterials.KUNZITE, 0, -3f, setting));

    public static final Item ELYSIUM_SWORD = registerItem("elysium_sword",
            setting -> new Item(setting.sword(ModToolMaterials.ELYSIUM, 11, -1.4f)));
    public static final Item ELYSIUM_PICKAXE = registerItem("elysium_pickaxe",
            setting -> new Item(setting.pickaxe(ModToolMaterials.ELYSIUM, 1, -2.8f)));
    public static final Item ELYSIUM_SHOVEL = registerItem("elysium_shovel",
            setting -> new ShovelItem(ModToolMaterials.ELYSIUM, 1.5f, -3.0f, setting));
    public static final Item ELYSIUM_AXE = registerItem("elysium_axe",
            setting -> new AxeItem(ModToolMaterials.ELYSIUM, 15, -3.4f, setting));
    public static final Item ELYSIUM_HOE = registerItem("elysium_hoe",
            setting -> new HoeItem(ModToolMaterials.ELYSIUM, 0, -3f, setting));

    public static final Item ELYSIUM_HAMMER = registerItem("elysium_hammer",
            setting -> new HammerItem(ModToolMaterials.ELYSIUM, 7, -3.8f, setting));

    public static final Item KUNZITE_HELMET = registerItem("kunzite_helmet",
            setting -> new Item(setting.armor(ModArmorMaterials.KUNZITE_ARMOR_MATERIAL, EquipmentType.HELMET)));
    public static final Item KUNZITE_CHESTPLATE = registerItem("kunzite_chestplate",
            setting -> new Item(setting.armor(ModArmorMaterials.KUNZITE_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)));
    public static final Item KUNZITE_LEGGINGS = registerItem("kunzite_leggings",
            setting -> new Item(setting.armor(ModArmorMaterials.KUNZITE_ARMOR_MATERIAL, EquipmentType.LEGGINGS)));
    public static final Item KUNZITE_BOOTS = registerItem("kunzite_boots",
            setting -> new Item(setting.armor(ModArmorMaterials.KUNZITE_ARMOR_MATERIAL, EquipmentType.BOOTS)));

    public static final Item ELYSIUM_HELMET = registerItem("elysium_helmet",
            setting -> new Item(setting.armor(ModArmorMaterials.ELYSIUM_ARMOR_MATERIAL, EquipmentType.HELMET)));
    public static final Item ELYSIUM_CHESTPLATE = registerItem("elysium_chestplate",
            setting -> new Item(setting.armor(ModArmorMaterials.ELYSIUM_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)));
    public static final Item ELYSIUM_LEGGINGS = registerItem("elysium_leggings",
            setting -> new Item(setting.armor(ModArmorMaterials.ELYSIUM_ARMOR_MATERIAL, EquipmentType.LEGGINGS)));
    public static final Item ELYSIUM_BOOTS = registerItem("elysium_boots",
            setting -> new Item(setting.armor(ModArmorMaterials.ELYSIUM_ARMOR_MATERIAL, EquipmentType.BOOTS)));


    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(JirniysPinkStuff.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(JirniysPinkStuff.MOD_ID, name)))));
    }

    public static void registerModItems() {
        JirniysPinkStuff.LOGGER.info("Registering Mod Items for " + JirniysPinkStuff.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(KUNZITE);
            entries.add(RAW_KUNZITE);
            entries.add(CRYSTAL_GLITTER);
            entries.add(ELYSIUM_INGOT);
            entries.add(ELYSIAN_REDSTONE_CORE);
            entries.add(PINK_BITS);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(KUNZITE_SWORD);
            entries.add(ELYSIUM_SWORD);
            entries.add(KUNZITE_HELMET);
            entries.add(KUNZITE_CHESTPLATE);
            entries.add(KUNZITE_LEGGINGS);
            entries.add(KUNZITE_BOOTS);
            entries.add(ELYSIUM_HELMET);
            entries.add(ELYSIUM_CHESTPLATE);
            entries.add(ELYSIUM_LEGGINGS);
            entries.add(ELYSIUM_BOOTS);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(KUNZITE_PICKAXE);
            entries.add(KUNZITE_AXE);
            entries.add(KUNZITE_SHOVEL);
            entries.add(KUNZITE_HOE);
            entries.add(ELYSIUM_PICKAXE);
            entries.add(ELYSIUM_AXE);
            entries.add(ELYSIUM_SHOVEL);
            entries.add(ELYSIUM_HOE);
            entries.add(ELYSIUM_HAMMER);
        });
    }
}
