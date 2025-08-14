package net.jirniy.pinkstuff.item;


import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.util.ModTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;

public class ModArmorMaterials {
    static RegistryKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));
    public static final RegistryKey<EquipmentAsset> KUNZITE_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(JirniysPinkStuff.MOD_ID, "kunzite"));

    public static final ArmorMaterial KUNZITE_ARMOR_MATERIAL = new ArmorMaterial(27, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 2);
        map.put(EquipmentType.LEGGINGS, 3);
        map.put(EquipmentType.CHESTPLATE, 5);
        map.put(EquipmentType.HELMET, 2);
        map.put(EquipmentType.BODY, 4);
    }), 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,0,0, ModTags.Items.KUNZITE_REPAIR, KUNZITE_KEY);

    public static final RegistryKey<EquipmentAsset> ELYSIUM_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(JirniysPinkStuff.MOD_ID, "elysium"));

    public static final ArmorMaterial ELYSIUM_ARMOR_MATERIAL = new ArmorMaterial(196, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 4);
        map.put(EquipmentType.LEGGINGS, 5);
        map.put(EquipmentType.CHESTPLATE, 7);
        map.put(EquipmentType.HELMET, 4);
        map.put(EquipmentType.BODY, 6);
    }), 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1,0.05f, ModTags.Items.ELYSIUM_REPAIR, ELYSIUM_KEY);

    public static final RegistryKey<EquipmentAsset> PINLINE_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(JirniysPinkStuff.MOD_ID, "pinline"));

    public static final ArmorMaterial PINLINE_ARMOR_MATERIAL = new ArmorMaterial(54, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 3);
        map.put(EquipmentType.LEGGINGS, 4);
        map.put(EquipmentType.CHESTPLATE, 4);
        map.put(EquipmentType.HELMET, 2);
        map.put(EquipmentType.BODY, 4);
    }), 20, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0,0.1f, ModTags.Items.PINLINE_REPAIR, PINLINE_KEY);

    public static final RegistryKey<EquipmentAsset> MOONSTEEL_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(JirniysPinkStuff.MOD_ID, "moonsteel"));

    public static final ArmorMaterial MOONSTEEL_ARMOR_MATERIAL = new ArmorMaterial(54, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 2);
        map.put(EquipmentType.LEGGINGS, 3);
        map.put(EquipmentType.CHESTPLATE, 4);
        map.put(EquipmentType.HELMET, 2);
        map.put(EquipmentType.BODY, 4);
    }), 20, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0,0.2f, ModTags.Items.MOONSTEEL_REPAIR, MOONSTEEL_KEY);

    public static final RegistryKey<EquipmentAsset> CERILLE_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(JirniysPinkStuff.MOD_ID, "cerille"));

    public static final ArmorMaterial CERILLE_ARMOR_MATERIAL = new ArmorMaterial(54, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 4);
        map.put(EquipmentType.LEGGINGS, 4);
        map.put(EquipmentType.CHESTPLATE, 5);
        map.put(EquipmentType.HELMET, 4);
        map.put(EquipmentType.BODY, 4);
    }), 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1,0.1f, ModTags.Items.CERILLE_REPAIR, CERILLE_KEY);
}