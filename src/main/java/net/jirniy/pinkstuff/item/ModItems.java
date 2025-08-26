package net.jirniy.pinkstuff.item;


import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.entity.ModEntities;
import net.jirniy.pinkstuff.item.custom.*;
import net.jirniy.pinkstuff.trim.ModTrimMaterials;
import net.jirniy.pinkstuff.util.ModTags;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.BannerPatternsComponent;
import net.minecraft.component.type.BlocksAttacksComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ModItems {

    public static final Item AMETHYST_NUGGET = registerItem("amethyst_nugget", Item::new);
    public static final Item DIAMOND_NUGGET = registerItem("diamond_nugget", Item::new);
    public static final Item EMERALD_NUGGET = registerItem("emerald_nugget", Item::new);
    public static final Item QUARTZ_NUGGET = registerItem("quartz_nugget", Item::new);
    public static final Item NETHERITE_NUGGET = registerItem("netherite_nugget", Item::new);

    public static final Item AMETHYST_BLAZE_ROD = registerItem("amethyst_blaze_rod", Item::new);

    public static final Item SULFUR = registerItem("sulfur",
            setting -> new Item(setting.trimMaterial(ModTrimMaterials.SULFUR)));

    public static final Item CORRUPT_DROPLET = registerItem("corrupt_droplet",
            setting -> new BlockItem(ModBlocks.CORRUPTION_CLUMP, setting));
    public static final Item CORRUPT_MASS = registerItem("corrupt_mass",
            setting -> new Item(setting.trimMaterial(ModTrimMaterials.CORRUPT)));

    public static final Item MOONSTEEL_NUGGET = registerItem("moonsteel_nugget", Item::new);
    public static final Item MOONSTEEL_INGOT = registerItem("moonsteel_ingot",
            setting -> new Item(setting.trimMaterial(ModTrimMaterials.MOONSTEEL)));
    public static final Item RAW_MOONSTEEL = registerItem("raw_moonsteel", Item::new);

    public static final Item CERILLE_NUGGET = registerItem("cerille_nugget", Item::new);
    public static final Item CERILLE_INGOT = registerItem("cerille_ingot",
            setting -> new Item(setting.trimMaterial(ModTrimMaterials.CERILLE)));

    public static final Item SUNGAZE_NUGGET = registerItem("sungaze_nugget", Item::new);
    public static final Item SUNGAZE = registerItem("sungaze",
            setting -> new Item(setting.trimMaterial(ModTrimMaterials.SUNGAZE)));

    public static final Item KUNZITE_NUGGET = registerItem("kunzite_nugget", Item::new);
    public static final Item KUNZITE = registerItem("kunzite",
            setting -> new Item(setting.trimMaterial(ModTrimMaterials.KUNZITE)));
    public static final Item RAW_KUNZITE = registerItem("raw_kunzite", Item::new);

    public static final Item CRYSTAL_GLITTER = registerItem("crystal_glitter", Item::new);
    public static final Item ELYSIUM_NUGGET = registerItem("elysium_nugget", Item::new);
    public static final Item ELYSIUM_INGOT = registerItem("elysium_ingot",
            setting -> new Item(setting.trimMaterial(ModTrimMaterials.ELYSIUM)));
    public static final Item ELYSIAN_REDSTONE_CORE = registerItem("elysian_redstone_core", setting -> new Item(setting.rarity(Rarity.UNCOMMON)));
    public static final Item PINK_BITS = registerItem("pink_bits", Item::new);
    public static final Item MEMORY_SHARD = registerItem("memory_shard",
            setting -> new Item(setting.rarity(Rarity.RARE).trimMaterial(ModTrimMaterials.MEMORY)));

    public static final Item PINLINE_NUGGET = registerItem("pinline_nugget", Item::new);
    public static final Item PINLINE_INGOT = registerItem("pinline_ingot",
            setting -> new Item(setting.trimMaterial(ModTrimMaterials.PINLINE)));
    public static final Item PREPARED_PINLINE = registerItem("prepared_pinline", Item::new);
    public static final Item RAW_PINLINE = registerItem("raw_pinline",
            setting -> new Item(setting.trimMaterial(ModTrimMaterials.RAW_PINLINE)));

    public static final Item GLAZED_CHORUS_FRUIT = registerItem("glazed_chorus_fruit", setting -> new Item(setting
            .food(ModFoodComponents.GLAZED_CHORUS_FRUIT, ModFoodComponents.GLAZED_CHORUS_FRUIT_EFFECT)));
    public static final Item COAL_MEAL = registerItem("coal_meal", setting -> new Item(setting
            .food(ModFoodComponents.COAL_MEAL, ModFoodComponents.COAL_MEAL_EFFECT)));
    public static final Item GELATINOUS_BUD = registerItem("gelatinous_bud", setting -> new Item(setting
            .food(ModFoodComponents.GELATINOUS_BUD, ModFoodComponents.GELATINOUS_BUD_EFFECT)));
    public static final Item ELYSIUM_APPLE = registerItem("elysium_apple", setting -> new Item(setting
            .food(ModFoodComponents.ELYSIUM_APPLE, ModFoodComponents.ELYSIUM_APPLE_EFFECT).rarity(Rarity.UNCOMMON)));
    public static final Item GODFRUIT = registerItem("godfruit", setting -> new Item(setting
            .food(ModFoodComponents.GODFRUIT, ModFoodComponents.GODFRUIT_EFFECT).rarity(Rarity.RARE)));
    public static final Item CRYSTAL_CARROT = registerItem("crystal_carrot", setting -> new Item(setting
            .food(ModFoodComponents.CRYSTAL_CARROT, ModFoodComponents.CRYSTAL_CARROT_EFFECT)));
    public static final Item GEM_BERRY = registerItem("gem_berry",
            setting -> new BlockItem(ModBlocks.GEM_BERRY_BUSH, setting
                    .food(ModFoodComponents.GEM_BERRY, ModFoodComponents.GEM_BERRY_EFFECT)));
    public static final Item CHARMBERRY = registerItem("charmberry",
            setting -> new BlockItem(ModBlocks.CHARMBERRY_BUSH, setting
                    .food(ModFoodComponents.CHARMBERRY, ModFoodComponents.CHARMBERRY_EFFECT)));
    public static final Item BERRY_SALAD = registerItem("berry_salad",
            setting -> new Item( setting.food(ModFoodComponents.BERRY_SALAD, ModFoodComponents.BERRY_SALAD_EFFECT)
                    .useRemainder(Items.BOWL).maxCount(1)));
    public static final Item HAZEWEAVER = registerItem("hazeweaver",
            setting -> new BlockItem(ModBlocks.HAZEWEAVER_PLANT, setting
                    .food(ModFoodComponents.HAZEWEAVER, ModFoodComponents.HAZEWEAVER_EFFECT)));

    public static final Item CRAWLER_SPAWN_EGG = registerItem("crawler_spawn_egg",
            setting -> new SpawnEggItem(ModEntities.CRAWLER, setting));
    public static final Item CORRUPTED_ZOMBIE_SPAWN_EGG = registerItem("corrupted_zombie_spawn_egg",
            setting -> new SpawnEggItem(ModEntities.CORRUPTED_ZOMBIE, setting));
    public static final Item CORRUPTED_SKELETON_SPAWN_EGG = registerItem("corrupted_skeleton_spawn_egg",
            setting -> new SpawnEggItem(ModEntities.CORRUPTED_SKELETON, setting));
    public static final Item AMETHYST_BLAZE_SPAWN_EGG = registerItem("amethyst_blaze_spawn_egg",
            setting -> new SpawnEggItem(ModEntities.AMETHYST_BLAZE, setting));

    public static final Item THERMIUM_NUGGET = registerItem("thermium_nugget", Item::new);
    public static final Item THERMIUM = registerItem("thermium", setting -> new Item(setting.trimMaterial(ModTrimMaterials.THERMIUM)));
    public static final Item RAW_THERMIUM = registerItem("raw_thermium", Item::new);
    public static final Item ENERGIZED_THERMIUM = registerItem("energized_thermium", setting -> new Item(setting.rarity(Rarity.UNCOMMON)));

    public static final Item STYXCOAL = registerItem("styxcoal", Item::new);

    public static final Item COTTON_SEEDS = registerItem("cotton_seeds",
            setting -> new BlockItem(ModBlocks.COTTON, setting));
    public static final Item COTTON = registerItem("cotton", Item::new);

    public static final Item KUNZITE_SWORD = registerItem("kunzite_sword",
            setting -> new Item(setting.sword(ModToolMaterials.KUNZITE, 2, -2.4f)));
    public static final Item KUNZITE_PICKAXE = registerItem("kunzite_pickaxe",
            setting -> new Item(setting.pickaxe(ModToolMaterials.KUNZITE, 1, -2.8f)));
    public static final Item KUNZITE_SHOVEL = registerItem("kunzite_shovel",
            setting -> new ShovelItem(ModToolMaterials.KUNZITE, 1.5f, -3.0f, setting));
    public static final Item KUNZITE_AXE = registerItem("kunzite_axe",
            setting -> new AxeItem(ModToolMaterials.KUNZITE, 6, -3.2f, setting));
    public static final Item KUNZITE_HOE = registerItem("kunzite_hoe",
            setting -> new HoeItem(ModToolMaterials.KUNZITE, 0, -3f, setting));

    public static final Item ELYSIUM_SWORD = registerItem("elysium_sword",
            setting -> new Item(setting.sword(ModToolMaterials.ELYSIUM, 4, -1.8f).rarity(Rarity.UNCOMMON)));
    public static final Item ELYSIUM_PICKAXE = registerItem("elysium_pickaxe",
            setting -> new Item(setting.pickaxe(ModToolMaterials.ELYSIUM, 1, -2.8f).rarity(Rarity.UNCOMMON)));
    public static final Item ELYSIUM_SHOVEL = registerItem("elysium_shovel",
            setting -> new ShovelItem(ModToolMaterials.ELYSIUM, 1.5f, -3.0f, setting.rarity(Rarity.UNCOMMON)));
    public static final Item ELYSIUM_AXE = registerItem("elysium_axe",
            setting -> new AxeItem(ModToolMaterials.ELYSIUM, 9, -2.4f, setting.rarity(Rarity.UNCOMMON)));
    public static final Item ELYSIUM_HOE = registerItem("elysium_hoe",
            setting -> new HoeItem(ModToolMaterials.ELYSIUM, 0, -3f, setting.rarity(Rarity.UNCOMMON)));

    public static final Item PINLINE_SWORD = registerItem("pinline_sword",
            setting -> new Item(setting.sword(ModToolMaterials.PINLINE, 2.2f, -1.8f)));
    public static final Item PINLINE_PICKAXE = registerItem("pinline_pickaxe",
            setting -> new Item(setting.pickaxe(ModToolMaterials.PINLINE, 1.2f, -2.8f)));
    public static final Item PINLINE_SHOVEL = registerItem("pinline_shovel",
            setting -> new ShovelItem(ModToolMaterials.PINLINE, 1.7f, -3.0f, setting));
    public static final Item PINLINE_AXE = registerItem("pinline_axe",
            setting -> new AxeItem(ModToolMaterials.PINLINE, 7, -3.2f, setting));
    public static final Item PINLINE_HOE = registerItem("pinline_hoe",
            setting -> new HoeItem(ModToolMaterials.PINLINE, 0, -3f, setting));

    public static final Item MOONSTEEL_SWORD = registerItem("moonsteel_sword",
            setting -> new Item(setting.sword(ModToolMaterials.MOONSTEEL, 2.5f, -2.4f)));
    public static final Item MOONSTEEL_PICKAXE = registerItem("moonsteel_pickaxe",
            setting -> new Item(setting.pickaxe(ModToolMaterials.MOONSTEEL, 1.2f, -2.8f)));
    public static final Item MOONSTEEL_SHOVEL = registerItem("moonsteel_shovel",
            setting -> new ShovelItem(ModToolMaterials.MOONSTEEL, 2f, -3.0f, setting));
    public static final Item MOONSTEEL_AXE = registerItem("moonsteel_axe",
            setting -> new AxeItem(ModToolMaterials.MOONSTEEL, 6, -3.2f, setting));
    public static final Item MOONSTEEL_HOE = registerItem("moonsteel_hoe",
            setting -> new HoeItem(ModToolMaterials.MOONSTEEL, 0, -3f, setting));

    public static final Item CERILLE_SWORD = registerItem("cerille_sword",
            setting -> new Item(setting.sword(ModToolMaterials.CERILLE, 4f, -2.2f)));
    public static final Item CERILLE_PICKAXE = registerItem("cerille_pickaxe",
            setting -> new Item(setting.pickaxe(ModToolMaterials.CERILLE, 1.4f, -2.8f)));
    public static final Item CERILLE_SHOVEL = registerItem("cerille_shovel",
            setting -> new ShovelItem(ModToolMaterials.CERILLE, 2.2f, -3.0f, setting));
    public static final Item CERILLE_AXE = registerItem("cerille_axe",
            setting -> new AxeItem(ModToolMaterials.CERILLE, 8, -3.2f, setting));
    public static final Item CERILLE_HOE = registerItem("cerille_hoe",
            setting -> new HoeItem(ModToolMaterials.CERILLE, 0, -3f, setting));

    public static final Item SUNBLAZE_SWORD = registerItem("sunblaze_sword",
            setting -> new SunblazeSwordItem(setting.sword(ModToolMaterials.SUNBLAZE, 3.5f, -2.0f)));
    public static final Item SUNBLAZE_PICKAXE = registerItem("sunblaze_pickaxe",
            setting -> new Item(setting.pickaxe(ModToolMaterials.SUNBLAZE, 1.6f, -2.8f)));
    public static final Item SUNBLAZE_SHOVEL = registerItem("sunblaze_shovel",
            setting -> new ShovelItem(ModToolMaterials.SUNBLAZE, 2.4f, -3.0f, setting));
    public static final Item SUNBLAZE_AXE = registerItem("sunblaze_axe",
            setting -> new AxeItem(ModToolMaterials.SUNBLAZE, 9, -3.4f, setting));
    public static final Item SUNBLAZE_HOE = registerItem("sunblaze_hoe",
            setting -> new HoeItem(ModToolMaterials.SUNBLAZE, 0, -3f, setting));

    public static final Item ELYSIUM_HAMMER = registerItem("elysium_hammer",
            setting -> new HammerItem(ModToolMaterials.SPECIAL, 8, -3.4f, setting.rarity(Rarity.RARE)));
    public static final Item ELYSIUM_MULTITOOL = registerItem("elysium_multitool",
            setting -> new MultitoolItem(ModToolMaterials.SPECIAL, 3, -1f, setting.rarity(Rarity.RARE)));
    public static final Item DAWNBLOOMER = registerItem("dawnbloomer",
            setting -> new DawnbloomerItem(setting.sword(ModToolMaterials.SPECIAL, 7, -1.8f).rarity(Rarity.RARE)));
    public static final Item NETHERITE_MULTITOOL = registerItem("netherite_multitool",
            setting -> new MultitoolItem(ToolMaterial.NETHERITE, 3, -1f, setting.rarity(Rarity.UNCOMMON)));
    public static final Item SUNBLAZE_MULTITOOL = registerItem("sunblaze_multitool",
            setting -> new MultitoolItem(ModToolMaterials.SUNBLAZE, 1.5f, -1f, setting.rarity(Rarity.UNCOMMON)));
    public static final Item BEDROCK_BREAKER = registerItem("bedrock_breaker",
            setting -> new BreakerItem(setting.maxCount(16)));

    public static final Item KUNZITE_HELMET = registerItem("kunzite_helmet",
            setting -> new Item(setting.armor(ModArmorMaterials.KUNZITE_ARMOR_MATERIAL, EquipmentType.HELMET)));
    public static final Item KUNZITE_CHESTPLATE = registerItem("kunzite_chestplate",
            setting -> new Item(setting.armor(ModArmorMaterials.KUNZITE_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)));
    public static final Item KUNZITE_LEGGINGS = registerItem("kunzite_leggings",
            setting -> new Item(setting.armor(ModArmorMaterials.KUNZITE_ARMOR_MATERIAL, EquipmentType.LEGGINGS)));
    public static final Item KUNZITE_BOOTS = registerItem("kunzite_boots",
            setting -> new Item(setting.armor(ModArmorMaterials.KUNZITE_ARMOR_MATERIAL, EquipmentType.BOOTS)));

    public static final Item ELYSIUM_HELMET = registerItem("elysium_helmet",
            setting -> new ModArmorItem(setting.armor(ModArmorMaterials.ELYSIUM_ARMOR_MATERIAL, EquipmentType.HELMET).rarity(Rarity.UNCOMMON)));
    public static final Item ELYSIUM_CHESTPLATE = registerItem("elysium_chestplate",
            setting -> new ModArmorItem(setting.armor(ModArmorMaterials.ELYSIUM_ARMOR_MATERIAL, EquipmentType.CHESTPLATE).rarity(Rarity.UNCOMMON)));
    public static final Item ELYSIUM_LEGGINGS = registerItem("elysium_leggings",
            setting -> new ModArmorItem(setting.armor(ModArmorMaterials.ELYSIUM_ARMOR_MATERIAL, EquipmentType.LEGGINGS).rarity(Rarity.UNCOMMON)));
    public static final Item ELYSIUM_BOOTS = registerItem("elysium_boots",
            setting -> new ModArmorItem(setting.armor(ModArmorMaterials.ELYSIUM_ARMOR_MATERIAL, EquipmentType.BOOTS).rarity(Rarity.UNCOMMON)));

    public static final Item PINLINE_HELMET = registerItem("pinline_helmet",
            setting -> new ModArmorItem(setting.armor(ModArmorMaterials.PINLINE_ARMOR_MATERIAL, EquipmentType.HELMET)));
    public static final Item PINLINE_CHESTPLATE = registerItem("pinline_chestplate",
            setting -> new ModArmorItem(setting.armor(ModArmorMaterials.PINLINE_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)));
    public static final Item PINLINE_LEGGINGS = registerItem("pinline_leggings",
            setting -> new ModArmorItem(setting.armor(ModArmorMaterials.PINLINE_ARMOR_MATERIAL, EquipmentType.LEGGINGS)));
    public static final Item PINLINE_BOOTS = registerItem("pinline_boots",
            setting -> new ModArmorItem(setting.armor(ModArmorMaterials.PINLINE_ARMOR_MATERIAL, EquipmentType.BOOTS)));

    public static final Item MOONSTEEL_HELMET = registerItem("moonsteel_helmet",
            setting -> new Item(setting.armor(ModArmorMaterials.MOONSTEEL_ARMOR_MATERIAL, EquipmentType.HELMET)));
    public static final Item MOONSTEEL_CHESTPLATE = registerItem("moonsteel_chestplate",
            setting -> new Item(setting.armor(ModArmorMaterials.MOONSTEEL_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)));
    public static final Item MOONSTEEL_LEGGINGS = registerItem("moonsteel_leggings",
            setting -> new Item(setting.armor(ModArmorMaterials.MOONSTEEL_ARMOR_MATERIAL, EquipmentType.LEGGINGS)));
    public static final Item MOONSTEEL_BOOTS = registerItem("moonsteel_boots",
            setting -> new Item(setting.armor(ModArmorMaterials.MOONSTEEL_ARMOR_MATERIAL, EquipmentType.BOOTS)));

    public static final Item CERILLE_HELMET = registerItem("cerille_helmet",
            setting -> new ModArmorItem(setting.armor(ModArmorMaterials.CERILLE_ARMOR_MATERIAL, EquipmentType.HELMET)));
    public static final Item CERILLE_CHESTPLATE = registerItem("cerille_chestplate",
            setting -> new ModArmorItem(setting.armor(ModArmorMaterials.CERILLE_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)));
    public static final Item CERILLE_LEGGINGS = registerItem("cerille_leggings",
            setting -> new ModArmorItem(setting.armor(ModArmorMaterials.CERILLE_ARMOR_MATERIAL, EquipmentType.LEGGINGS)));
    public static final Item CERILLE_BOOTS = registerItem("cerille_boots",
            setting -> new ModArmorItem(setting.armor(ModArmorMaterials.CERILLE_ARMOR_MATERIAL, EquipmentType.BOOTS)));

    public static final Item SUNBLAZE_HELMET = registerItem("sunblaze_helmet",
            setting -> new ModArmorItem(setting.armor(ModArmorMaterials.SUNBLAZE_ARMOR_MATERIAL, EquipmentType.HELMET)));
    public static final Item SUNBLAZE_CHESTPLATE = registerItem("sunblaze_chestplate",
            setting -> new ModArmorItem(setting.armor(ModArmorMaterials.SUNBLAZE_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)));
    public static final Item SUNBLAZE_LEGGINGS = registerItem("sunblaze_leggings",
            setting -> new ModArmorItem(setting.armor(ModArmorMaterials.SUNBLAZE_ARMOR_MATERIAL, EquipmentType.LEGGINGS)));
    public static final Item SUNBLAZE_BOOTS = registerItem("sunblaze_boots",
            setting -> new ModArmorItem(setting.armor(ModArmorMaterials.SUNBLAZE_ARMOR_MATERIAL, EquipmentType.BOOTS)));

    public static final Item CHERRY_SMITHING_TEMPLATE = registerItem("cherry_armor_trim_smithing_template",
            setting -> SmithingTemplateItem.of(setting.rarity(Rarity.RARE)));
    public static final Item BLOOM_SMITHING_TEMPLATE = registerItem("bloom_armor_trim_smithing_template",
            setting -> SmithingTemplateItem.of(setting.rarity(Rarity.UNCOMMON)));
    public static final Item SWORDMASTER_SMITHING_TEMPLATE = registerItem("swordmaster_armor_trim_smithing_template",
            setting -> SmithingTemplateItem.of(setting.rarity(Rarity.UNCOMMON)));
    public static final Item SHATTER_SMITHING_TEMPLATE = registerItem("shatter_armor_trim_smithing_template",
            setting -> SmithingTemplateItem.of(setting.rarity(Rarity.UNCOMMON)));
    public static final Item CREEPER_SMITHING_TEMPLATE = registerItem("creeper_armor_trim_smithing_template",
            setting -> SmithingTemplateItem.of(setting.rarity(Rarity.EPIC)));
    public static final Item CHESS_SMITHING_TEMPLATE = registerItem("chess_armor_trim_smithing_template",
            setting -> SmithingTemplateItem.of(setting.rarity(Rarity.UNCOMMON)));
    public static final Item WANDERER_SMITHING_TEMPLATE = registerItem("wanderer_armor_trim_smithing_template",
            setting -> SmithingTemplateItem.of(setting.rarity(Rarity.UNCOMMON)));
    public static final Item SHELL_SMITHING_TEMPLATE = registerItem("shell_armor_trim_smithing_template",
            setting -> SmithingTemplateItem.of(setting.rarity(Rarity.UNCOMMON)));
    public static final Item WINGFLAP_SMITHING_TEMPLATE = registerItem("wingflap_armor_trim_smithing_template",
            setting -> SmithingTemplateItem.of(setting.rarity(Rarity.RARE)));
    public static final Item OVERGROWTH_SMITHING_TEMPLATE = registerItem("overgrowth_armor_trim_smithing_template",
            setting -> SmithingTemplateItem.of(setting.rarity(Rarity.RARE)));
    public static final Item CORRUPTION_SMITHING_TEMPLATE = registerItem("corruption_armor_trim_smithing_template",
            setting -> SmithingTemplateItem.of(setting.rarity(Rarity.RARE)));
    public static final Item FORBIDDEN_SMITHING_TEMPLATE = registerItem("forbidden_armor_trim_smithing_template",
            setting -> SmithingTemplateItem.of(setting.rarity(Rarity.UNCOMMON)));


    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(JirniysPinkStuff.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(JirniysPinkStuff.MOD_ID, name)))));
    }

    public static void registerModItems() {
        JirniysPinkStuff.LOGGER.info("Registering Mod Items for " + JirniysPinkStuff.MOD_ID);
    }
}
