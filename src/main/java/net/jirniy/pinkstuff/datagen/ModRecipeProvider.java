package net.jirniy.pinkstuff.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.item.ModItems;
import net.jirniy.pinkstuff.trim.ModTrimPatterns;
import net.jirniy.pinkstuff.util.ModTags;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SmokingRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                List<ItemConvertible> KUNZITE_SMELTABLES = List.of(
                        ModItems.RAW_KUNZITE,
                        ModBlocks.KUNZITE_ORE,
                        ModBlocks.DEEPSLATE_KUNZITE_ORE,
                        ModBlocks.AMETHYST_KUNZITE_ORE);
                List<ItemConvertible> ELYSIUM_SMELTABLES = List.of(
                        ModItems.CRYSTAL_GLITTER);
                List<ItemConvertible> THERMIUM_SMELTABLES = List.of(
                        ModItems.RAW_THERMIUM,
                        ModBlocks.THERMIUM_ORE,
                        ModBlocks.DEEPSLATE_THERMIUM_ORE);
                List<ItemConvertible> MOONSTEEL_SMELTABLES = List.of(
                        ModItems.RAW_MOONSTEEL,
                        ModBlocks.STYXIAN_MOONSTEEL_ORE,
                        ModBlocks.COMPRESSED_STYXIAN_MOONSTEEL_ORE);
                List<ItemConvertible> KUNZITE_GEAR = List.of(
                        ModItems.KUNZITE_SWORD,
                        ModItems.KUNZITE_PICKAXE,
                        ModItems.KUNZITE_AXE,
                        ModItems.KUNZITE_SHOVEL,
                        ModItems.KUNZITE_HOE,
                        ModItems.KUNZITE_HELMET,
                        ModItems.KUNZITE_CHESTPLATE,
                        ModItems.KUNZITE_LEGGINGS,
                        ModItems.KUNZITE_BOOTS);
                List<ItemConvertible> ELYSIUM_GEAR = List.of(
                        ModItems.ELYSIUM_SWORD,
                        ModItems.ELYSIUM_PICKAXE,
                        ModItems.ELYSIUM_AXE,
                        ModItems.ELYSIUM_SHOVEL,
                        ModItems.ELYSIUM_HOE,
                        ModItems.ELYSIUM_HELMET,
                        ModItems.ELYSIUM_CHESTPLATE,
                        ModItems.ELYSIUM_LEGGINGS,
                        ModItems.ELYSIUM_BOOTS);
                List<ItemConvertible> MOONSTEEL_GEAR = List.of(
                        ModItems.MOONSTEEL_SWORD,
                        ModItems.MOONSTEEL_PICKAXE,
                        ModItems.MOONSTEEL_AXE,
                        ModItems.MOONSTEEL_SHOVEL,
                        ModItems.MOONSTEEL_HOE,
                        ModItems.MOONSTEEL_HELMET,
                        ModItems.MOONSTEEL_CHESTPLATE,
                        ModItems.MOONSTEEL_LEGGINGS,
                        ModItems.MOONSTEEL_BOOTS);
                List<ItemConvertible> CERILLE_GEAR = List.of(
                        ModItems.CERILLE_SWORD,
                        ModItems.CERILLE_PICKAXE,
                        ModItems.CERILLE_AXE,
                        ModItems.CERILLE_SHOVEL,
                        ModItems.CERILLE_HOE,
                        ModItems.CERILLE_HELMET,
                        ModItems.CERILLE_CHESTPLATE,
                        ModItems.CERILLE_LEGGINGS,
                        ModItems.CERILLE_BOOTS);
                List<ItemConvertible> PINLINE_GEAR = List.of(
                        ModItems.PINLINE_SWORD,
                        ModItems.PINLINE_PICKAXE,
                        ModItems.PINLINE_AXE,
                        ModItems.PINLINE_SHOVEL,
                        ModItems.PINLINE_HOE,
                        ModItems.PINLINE_HELMET,
                        ModItems.PINLINE_CHESTPLATE,
                        ModItems.PINLINE_LEGGINGS,
                        ModItems.PINLINE_BOOTS);
                List<ItemConvertible> SUNBLAZE_GEAR = List.of(
                        ModItems.SUNBLAZE_SWORD,
                        ModItems.SUNBLAZE_PICKAXE,
                        ModItems.SUNBLAZE_AXE,
                        ModItems.SUNBLAZE_SHOVEL,
                        ModItems.SUNBLAZE_HOE,
                        ModItems.SUNBLAZE_MULTITOOL,
                        ModItems.SUNBLAZE_HELMET,
                        ModItems.SUNBLAZE_CHESTPLATE,
                        ModItems.SUNBLAZE_LEGGINGS,
                        ModItems.SUNBLAZE_BOOTS);
                List<ItemConvertible> DIAMOND_GEAR = List.of(
                        Items.DIAMOND_SWORD,
                        Items.DIAMOND_PICKAXE,
                        Items.DIAMOND_AXE,
                        Items.DIAMOND_SHOVEL,
                        Items.DIAMOND_HOE,
                        Items.DIAMOND_HELMET,
                        Items.DIAMOND_CHESTPLATE,
                        Items.DIAMOND_LEGGINGS,
                        Items.DIAMOND_BOOTS);
                List<ItemConvertible> NETHERITE_GEAR = List.of(
                        Items.NETHERITE_SWORD,
                        Items.NETHERITE_PICKAXE,
                        Items.NETHERITE_AXE,
                        Items.NETHERITE_SHOVEL,
                        Items.NETHERITE_HOE,
                        Items.NETHERITE_HELMET,
                        Items.NETHERITE_CHESTPLATE,
                        Items.NETHERITE_LEGGINGS,
                        Items.NETHERITE_BOOTS);
                offerSmelting(KUNZITE_SMELTABLES, RecipeCategory.MISC, ModItems.KUNZITE,
                        0.25f, 40, "kunzite_smelting");
                offerBlasting(KUNZITE_SMELTABLES, RecipeCategory.MISC, ModItems.KUNZITE,
                        0.25f, 20, "kunzite_blasting");
                offerSmelting(THERMIUM_SMELTABLES, RecipeCategory.MISC, ModItems.THERMIUM,
                        4f, 640, "thermium_smelting");
                offerBlasting(THERMIUM_SMELTABLES, RecipeCategory.MISC, ModItems.THERMIUM,
                        4f, 320, "thermium_blasting");
                offerSmelting(ELYSIUM_SMELTABLES, RecipeCategory.MISC, ModItems.ELYSIUM_INGOT,
                        2f, 320, "elysium_smelting");
                offerBlasting(ELYSIUM_SMELTABLES, RecipeCategory.MISC, ModItems.ELYSIUM_INGOT,
                        2f, 160, "elysium_blasting");
                offerSmelting(MOONSTEEL_SMELTABLES, RecipeCategory.MISC, ModItems.MOONSTEEL_INGOT,
                        2f, 320, "moonsteel_smelting");
                offerBlasting(MOONSTEEL_SMELTABLES, RecipeCategory.MISC, ModItems.MOONSTEEL_INGOT,
                        2f, 160, "moonsteel_blasting");
                offerSmelting(KUNZITE_GEAR, RecipeCategory.MISC, ModItems.KUNZITE_NUGGET,
                        0f, 200, "kunzite_gear_smelting");
                offerBlasting(KUNZITE_GEAR, RecipeCategory.MISC, ModItems.KUNZITE_NUGGET,
                        0f, 100, "kunzite_gear_blasting");
                offerSmelting(ELYSIUM_GEAR, RecipeCategory.MISC, ModItems.ELYSIUM_NUGGET,
                        0f, 200, "elysium_gear_smelting");
                offerBlasting(ELYSIUM_GEAR, RecipeCategory.MISC, ModItems.ELYSIUM_NUGGET,
                        0f, 100, "elysium_gear_blasting");
                offerSmelting(MOONSTEEL_GEAR, RecipeCategory.MISC, ModItems.MOONSTEEL_NUGGET,
                        0f, 200, "moonsteel_gear_smelting");
                offerBlasting(MOONSTEEL_GEAR, RecipeCategory.MISC, ModItems.MOONSTEEL_NUGGET,
                        0f, 100, "moonsteel_gear_blasting");
                offerSmelting(CERILLE_GEAR, RecipeCategory.MISC, ModItems.CERILLE_NUGGET,
                        0f, 200, "cerille_gear_smelting");
                offerBlasting(CERILLE_GEAR, RecipeCategory.MISC, ModItems.CERILLE_NUGGET,
                        0f, 100, "cerille_gear_blasting");
                offerSmelting(PINLINE_GEAR, RecipeCategory.MISC, ModItems.PINLINE_NUGGET,
                        0f, 200, "pinline_gear_smelting");
                offerBlasting(PINLINE_GEAR, RecipeCategory.MISC, ModItems.PINLINE_NUGGET,
                        0f, 100, "pinline_gear_blasting");
                offerSmelting(SUNBLAZE_GEAR, RecipeCategory.MISC, ModItems.SUNGAZE_NUGGET,
                        0f, 200, "sunblaze_gear_smelting");
                offerBlasting(SUNBLAZE_GEAR, RecipeCategory.MISC, ModItems.SUNGAZE_NUGGET,
                        0f, 100, "sunblaze_gear_blasting");
                offerSmelting(DIAMOND_GEAR, RecipeCategory.MISC, ModItems.DIAMOND_NUGGET,
                        0f, 200, "diamond_gear_smelting");
                offerBlasting(DIAMOND_GEAR, RecipeCategory.MISC, ModItems.DIAMOND_NUGGET,
                        0f, 100, "diamond_gear_blasting");
                offerSmelting(NETHERITE_GEAR, RecipeCategory.MISC, ModItems.NETHERITE_NUGGET,
                        0f, 200, "netherite_gear_smelting");
                offerBlasting(NETHERITE_GEAR, RecipeCategory.MISC, ModItems.NETHERITE_NUGGET,
                        0f, 100, "netherite_gear_blasting");
                offerSmelting(List.of(ModItems.PREPARED_PINLINE), RecipeCategory.MISC, ModItems.PINLINE_INGOT,
                        2f, 1280, "pinline_smelting");
                offerBlasting(List.of(ModItems.PREPARED_PINLINE), RecipeCategory.MISC, ModItems.PINLINE_INGOT,
                        2f, 640, "pinline_blasting");
                offerSmelting(List.of(ModBlocks.PINK_SAND.asItem()), RecipeCategory.MISC, Blocks.GLASS,
                        1f, 200, "pink_sand_to_glass_smelting");
                offerBlasting(List.of(ModBlocks.PINK_SAND.asItem()), RecipeCategory.MISC, Blocks.GLASS,
                        1f, 100, "pink_sand_to_glass_blasting");
                offerSmelting(List.of(Items.MAGMA_CREAM), RecipeCategory.MISC, Items.FIRE_CHARGE,
                        0.1f, 160, "fire_charge_smelting");
                offerBlasting(List.of(Items.MAGMA_CREAM), RecipeCategory.MISC, Items.FIRE_CHARGE,
                        0.1f, 80, "fire_charge_blasting");
                offerSmelting(List.of(Items.FIRE_CHARGE), RecipeCategory.MISC, Items.CHARCOAL,
                        0f, 1280, "fire_to_charcoal_smelting");
                offerBlasting(List.of(Items.FIRE_CHARGE), RecipeCategory.MISC, Items.CHARCOAL,
                        0f, 640, "fire_to_charcoal_blasting");
                offerSmelting(List.of(ModItems.THERMIUM_WASTE), RecipeCategory.MISC, ModItems.THERMIUM_NUGGET,
                        0.1f, 400, "thermium_waste_smelting");
                offerBlasting(List.of(ModItems.THERMIUM_WASTE), RecipeCategory.MISC, ModItems.THERMIUM_NUGGET,
                        0.1f, 200, "thermium_waste_blasting");
                offerSmelting(List.of(ModItems.RAW_FAIRY_MEAT), RecipeCategory.FOOD, ModItems.COOKED_FAIRY_MEAT,
                        1f, 200, "fairy_meat_smelting");
                offerFoodCookingRecipe("smoking", RecipeSerializer.SMOKING, SmokingRecipe::new,
                        100, ModItems.RAW_FAIRY_MEAT, ModItems.COOKED_FAIRY_MEAT, 1f);
                offerSmelting(List.of(ModItems.MATURE_SPROUT), RecipeCategory.FOOD, ModItems.DEAD_SPROUT,
                        1f, 200, "mature_sprout_smelting");
                offerFoodCookingRecipe("smoking", RecipeSerializer.SMOKING, SmokingRecipe::new,
                        100, ModItems.MATURE_SPROUT, ModItems.DEAD_SPROUT, 1f);
                offerSmelting(List.of(ModBlocks.COBBLED_STYXSTONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.STYXSTONE,
                        0f, 200, "cobbled_styxstone_to_styxstone_smelting");
                offerBlasting(List.of(ModBlocks.COBBLED_STYXSTONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.STYXSTONE,
                        0f, 100, "cobbled_styxstone_to_styxstone_blasting");
                offerSmelting(List.of(ModItems.CORRUPT_SPROUTS), RecipeCategory.MISC, ModItems.CORRUPT_DROPLET,
                        0.1f, 200, "corrupt_sprouts_smelting");
                offerReversibleCompactingRecipes(RecipeCategory.MISC,
                        ModItems.KUNZITE, RecipeCategory.BUILDING_BLOCKS, ModBlocks.KUNZITE_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.MISC,
                        ModItems.RAW_KUNZITE, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_KUNZITE_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.MISC,
                        ModItems.THERMIUM, RecipeCategory.BUILDING_BLOCKS, ModBlocks.THERMIUM_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.MISC,
                        ModItems.RAW_THERMIUM, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_THERMIUM_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.MISC,
                        ModItems.ELYSIUM_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ELYSIUM_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.MISC,
                        ModItems.ENERGIZED_THERMIUM, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENERGIZED_THERMIUM_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.MISC,
                        ModItems.SULFUR, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SULFUR_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.MISC,
                        ModItems.PINLINE_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINLINE_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.MISC,
                        ModItems.RAW_PINLINE, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_PINLINE_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.MISC,
                        ModItems.STYXCOAL, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STYXCOAL_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.MISC,
                        ModItems.MOONSTEEL_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOONSTEEL_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.MISC,
                        ModItems.RAW_MOONSTEEL, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_MOONSTEEL_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.MISC,
                        ModItems.CERILLE_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CERILLE_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.MISC,
                        ModItems.SUNGAZE, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SUNGAZE_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.MISC,
                        ModItems.CORRUPT_DROPLET, RecipeCategory.MISC, ModItems.CORRUPT_MASS);
                createShapeless(RecipeCategory.MISC, ModItems.PREPARED_PINLINE, 1)
                        .input(ModItems.KUNZITE).input(ModItems.KUNZITE).input(ModItems.KUNZITE).input(ModItems.KUNZITE)
                        .input(ModItems.RAW_PINLINE).input(ModItems.KUNZITE).input(ModItems.KUNZITE).input(ModItems.KUNZITE).input(ModItems.KUNZITE)
                        .criterion(hasItem(ModItems.RAW_PINLINE), conditionsFromItem(ModItems.RAW_PINLINE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "prepared_pinline")));
                createShapeless(RecipeCategory.MISC, ModItems.CRYSTAL_GLITTER, 1)
                        .input(ModItems.KUNZITE).input(Items.DIAMOND).input(Items.QUARTZ).input(Items.AMETHYST_SHARD)
                        .input(ModItems.KUNZITE).input(Items.DIAMOND).input(Items.QUARTZ).input(Items.AMETHYST_SHARD)
                        .criterion(hasItem(ModItems.KUNZITE), conditionsFromItem(ModItems.KUNZITE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "crystal_glitter")));
                createShapeless(RecipeCategory.MISC, ModItems.CRYSTAL_GLITTER, 1)
                        .input(ModItems.KUNZITE).input(Items.DIAMOND).input(Items.QUARTZ).input(Items.AMETHYST_SHARD)
                        .input(ModItems.MAGIC_GLITTER).input(ModItems.MAGIC_GLITTER)
                        .criterion(hasItem(ModItems.MAGIC_GLITTER), conditionsFromItem(ModItems.MAGIC_GLITTER))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "crystal_glitter_from_magic_glitter")));
                createShapeless(RecipeCategory.MISC, ModItems.KUNZITE, 1)
                        .input(ModItems.PINK_BITS).input(ModItems.PINK_BITS).input(ModItems.PINK_BITS)
                        .input(ModItems.PINK_BITS).input(ModItems.PINK_BITS).input(ModItems.PINK_BITS)
                        .input(ModItems.PINK_BITS).input(ModItems.PINK_BITS).input(Items.AMETHYST_SHARD)
                        .criterion(hasItem(ModItems.PINK_BITS), conditionsFromItem(ModItems.PINK_BITS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "kunzite_from_pink_bits")));
                createShapeless(RecipeCategory.MISC, Items.PINK_DYE, 1)
                        .input(ModItems.PINK_BITS).criterion(hasItem(ModItems.PINK_BITS),
                                conditionsFromItem(ModItems.PINK_BITS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "pink_dye_from_pink_bits")));
                createShapeless(RecipeCategory.MISC, ModItems.CERILLE_INGOT, 1)
                        .input(ModItems.MOONSTEEL_INGOT).input(ModItems.MOONSTEEL_INGOT).input(ModItems.MOONSTEEL_INGOT)
                        .input(ModItems.CORRUPT_MASS).input(ModItems.CORRUPT_MASS).input(ModItems.CORRUPT_MASS)
                        .criterion(hasItem(ModItems.MOONSTEEL_INGOT), conditionsFromItem(ModItems.MOONSTEEL_INGOT))
                        .criterion(hasItem(ModItems.CORRUPT_MASS), conditionsFromItem(ModItems.CORRUPT_MASS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "cerille_ingot_from_moonsteel")));
                createShaped(RecipeCategory.MISC, ModItems.ELYSIAN_REDSTONE_CORE)
                        .pattern("EDE")
                        .pattern("DRD")
                        .pattern("EDE")
                        .input('R', Items.REDSTONE_BLOCK)
                        .input('D', Items.DIAMOND)
                        .input('E', ModItems.ELYSIUM_INGOT)
                        .criterion(hasItem(ModItems.ELYSIUM_INGOT), conditionsFromItem(ModItems.ELYSIUM_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "elysian_redstone_core")));
                createShaped(RecipeCategory.MISC, ModItems.FORBIDDEN_MECHANISM)
                        .pattern("EDE")
                        .pattern("DRD")
                        .pattern("EDE")
                        .input('R', ModItems.SUNGAZE)
                        .input('D', ModItems.CERILLE_INGOT)
                        .input('E', ModItems.MATURE_SPROUT)
                        .criterion(hasItem(ModItems.CERILLE_INGOT), conditionsFromItem(ModItems.CERILLE_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "forbidden_mechanism")));
                createShaped(RecipeCategory.MISC, ModItems.ENERGIZED_THERMIUM)
                        .pattern("TNT")
                        .pattern("TBT")
                        .pattern("TNT")
                        .input('N', ModItems.NETHERITE_NUGGET)
                        .input('B', Items.BLAZE_ROD)
                        .input('T', ModItems.THERMIUM)
                        .criterion(hasItem(ModItems.THERMIUM), conditionsFromItem(ModItems.THERMIUM))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "energized_thermium_from_thermium")));
                createShaped(RecipeCategory.COMBAT, ModItems.KUNZITE_SWORD)
                        .pattern("A")
                        .pattern("K")
                        .pattern("S")
                        .input('S', Items.STICK)
                        .input('A', Items.AMETHYST_SHARD)
                        .input('K', ModItems.KUNZITE)
                        .criterion(hasItem(ModItems.KUNZITE), conditionsFromItem(ModItems.KUNZITE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "kunzite_sword")));
                createShaped(RecipeCategory.TOOLS, ModItems.KUNZITE_PICKAXE)
                        .pattern("KAK")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('S', Items.STICK)
                        .input('K', ModItems.KUNZITE)
                        .input('A', Items.AMETHYST_SHARD)
                        .criterion(hasItem(ModItems.KUNZITE), conditionsFromItem(ModItems.KUNZITE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "kunzite_pickaxe")));
                createShaped(RecipeCategory.TOOLS, ModItems.KUNZITE_SHOVEL)
                        .pattern("K")
                        .pattern("S")
                        .pattern("S")
                        .input('S', Items.STICK)
                        .input('K', ModItems.KUNZITE)
                        .criterion(hasItem(ModItems.KUNZITE), conditionsFromItem(ModItems.KUNZITE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "kunzite_shovel")));
                createShaped(RecipeCategory.TOOLS, ModItems.KUNZITE_AXE)
                        .pattern("KA")
                        .pattern("KS")
                        .pattern(" S")
                        .input('S', Items.STICK)
                        .input('K', ModItems.KUNZITE)
                        .input('A', Items.AMETHYST_SHARD)
                        .criterion(hasItem(ModItems.KUNZITE), conditionsFromItem(ModItems.KUNZITE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "kunzite_axe")));
                createShaped(RecipeCategory.TOOLS, ModItems.KUNZITE_HOE)
                        .pattern("KK")
                        .pattern(" S")
                        .pattern(" S")
                        .input('S', Items.STICK)
                        .input('K', ModItems.KUNZITE)
                        .criterion(hasItem(ModItems.KUNZITE), conditionsFromItem(ModItems.KUNZITE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "kunzite_hoe")));
                createShaped(RecipeCategory.COMBAT, ModItems.PINLINE_SWORD)
                        .pattern("K")
                        .pattern("K")
                        .pattern("S")
                        .input('S', Items.STICK)
                        .input('K', ModItems.PINLINE_INGOT)
                        .criterion(hasItem(ModItems.PINLINE_INGOT), conditionsFromItem(ModItems.PINLINE_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "pinline_sword")));
                createShaped(RecipeCategory.TOOLS, ModItems.PINLINE_PICKAXE)
                        .pattern("KKK")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('S', Items.STICK)
                        .input('K', ModItems.PINLINE_INGOT)
                        .criterion(hasItem(ModItems.PINLINE_INGOT), conditionsFromItem(ModItems.PINLINE_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "pinline_pickaxe")));
                createShaped(RecipeCategory.TOOLS, ModItems.PINLINE_SHOVEL)
                        .pattern("K")
                        .pattern("S")
                        .pattern("S")
                        .input('S', Items.STICK)
                        .input('K', ModItems.PINLINE_INGOT)
                        .criterion(hasItem(ModItems.PINLINE_INGOT), conditionsFromItem(ModItems.PINLINE_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "pinline_shovel")));
                createShaped(RecipeCategory.TOOLS, ModItems.PINLINE_AXE)
                        .pattern("KK")
                        .pattern("KS")
                        .pattern(" S")
                        .input('S', Items.STICK)
                        .input('K', ModItems.PINLINE_INGOT)
                        .criterion(hasItem(ModItems.PINLINE_INGOT), conditionsFromItem(ModItems.PINLINE_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "pinline_axe")));
                createShaped(RecipeCategory.TOOLS, ModItems.PINLINE_HOE)
                        .pattern("KK")
                        .pattern(" S")
                        .pattern(" S")
                        .input('S', Items.STICK)
                        .input('K', ModItems.PINLINE_INGOT)
                        .criterion(hasItem(ModItems.PINLINE_INGOT), conditionsFromItem(ModItems.PINLINE_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "pinline_hoe")));

                createShaped(RecipeCategory.COMBAT, ModItems.MOONSTEEL_SWORD)
                        .pattern("K")
                        .pattern("K")
                        .pattern("S")
                        .input('S', Items.STICK)
                        .input('K', ModItems.MOONSTEEL_INGOT)
                        .criterion(hasItem(ModItems.MOONSTEEL_INGOT), conditionsFromItem(ModItems.MOONSTEEL_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "moonsteel_sword")));
                createShaped(RecipeCategory.TOOLS, ModItems.MOONSTEEL_PICKAXE)
                        .pattern("KKK")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('S', Items.STICK)
                        .input('K', ModItems.MOONSTEEL_INGOT)
                        .criterion(hasItem(ModItems.MOONSTEEL_INGOT), conditionsFromItem(ModItems.MOONSTEEL_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "moonsteel_pickaxe")));
                createShaped(RecipeCategory.TOOLS, ModItems.MOONSTEEL_SHOVEL)
                        .pattern("K")
                        .pattern("S")
                        .pattern("S")
                        .input('S', Items.STICK)
                        .input('K', ModItems.MOONSTEEL_INGOT)
                        .criterion(hasItem(ModItems.MOONSTEEL_INGOT), conditionsFromItem(ModItems.MOONSTEEL_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "moonsteel_shovel")));
                createShaped(RecipeCategory.TOOLS, ModItems.MOONSTEEL_AXE)
                        .pattern("KK")
                        .pattern("KS")
                        .pattern(" S")
                        .input('S', Items.STICK)
                        .input('K', ModItems.MOONSTEEL_INGOT)
                        .criterion(hasItem(ModItems.MOONSTEEL_INGOT), conditionsFromItem(ModItems.MOONSTEEL_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "moonsteel_axe")));
                createShaped(RecipeCategory.TOOLS, ModItems.MOONSTEEL_HOE)
                        .pattern("KK")
                        .pattern(" S")
                        .pattern(" S")
                        .input('S', Items.STICK)
                        .input('K', ModItems.MOONSTEEL_INGOT)
                        .criterion(hasItem(ModItems.MOONSTEEL_INGOT), conditionsFromItem(ModItems.MOONSTEEL_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "moonsteel_hoe")));

                createShaped(RecipeCategory.COMBAT, ModItems.CERILLE_SWORD)
                        .pattern("K")
                        .pattern("K")
                        .pattern("S")
                        .input('S', Items.STICK)
                        .input('K', ModItems.CERILLE_INGOT)
                        .criterion(hasItem(ModItems.CERILLE_INGOT), conditionsFromItem(ModItems.CERILLE_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "cerille_sword")));
                createShaped(RecipeCategory.TOOLS, ModItems.CERILLE_PICKAXE)
                        .pattern("KKK")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('S', Items.STICK)
                        .input('K', ModItems.CERILLE_INGOT)
                        .criterion(hasItem(ModItems.CERILLE_INGOT), conditionsFromItem(ModItems.CERILLE_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "cerille_pickaxe")));
                createShaped(RecipeCategory.TOOLS, ModItems.CERILLE_SHOVEL)
                        .pattern("K")
                        .pattern("S")
                        .pattern("S")
                        .input('S', Items.STICK)
                        .input('K', ModItems.CERILLE_INGOT)
                        .criterion(hasItem(ModItems.CERILLE_INGOT), conditionsFromItem(ModItems.CERILLE_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "cerille_shovel")));
                createShaped(RecipeCategory.TOOLS, ModItems.CERILLE_AXE)
                        .pattern("KK")
                        .pattern("KS")
                        .pattern(" S")
                        .input('S', Items.STICK)
                        .input('K', ModItems.CERILLE_INGOT)
                        .criterion(hasItem(ModItems.CERILLE_INGOT), conditionsFromItem(ModItems.CERILLE_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "cerille_axe")));
                createShaped(RecipeCategory.TOOLS, ModItems.CERILLE_HOE)
                        .pattern("KK")
                        .pattern(" S")
                        .pattern(" S")
                        .input('S', Items.STICK)
                        .input('K', ModItems.CERILLE_INGOT)
                        .criterion(hasItem(ModItems.CERILLE_INGOT), conditionsFromItem(ModItems.CERILLE_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "cerille_hoe")));
                createShaped(RecipeCategory.TOOLS, ModItems.SUNSHADE)
                        .pattern("CTC")
                        .pattern("CSC")
                        .pattern(" N ")
                        .input('N', ModItems.AMETHYST_BLAZE_ROD)
                        .input('S', ModItems.CERILLE_SWORD)
                        .input('C', ModItems.FORBIDDEN_MECHANISM)
                        .input('T', ModItems.THERMIUM)
                        .criterion(hasItem(ModItems.FORBIDDEN_MECHANISM), conditionsFromItem(ModItems.FORBIDDEN_MECHANISM))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "sunshade")));

                createShaped(RecipeCategory.COMBAT, ModItems.SUNBLAZE_SWORD)
                        .pattern("T")
                        .pattern("G")
                        .pattern("/")
                        .input('/', Items.STICK)
                        .input('G', ModItems.SUNGAZE)
                        .input('T', ModItems.THERMIUM)
                        .criterion(hasItem(ModItems.SUNGAZE), conditionsFromItem(ModItems.SUNGAZE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "sunblaze_sword")));
                createShaped(RecipeCategory.TOOLS, ModItems.SUNBLAZE_PICKAXE)
                        .pattern("GTG")
                        .pattern(" / ")
                        .pattern(" / ")
                        .input('/', Items.STICK)
                        .input('G', ModItems.SUNGAZE)
                        .input('T', ModItems.THERMIUM)
                        .criterion(hasItem(ModItems.SUNGAZE), conditionsFromItem(ModItems.SUNGAZE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "sunblaze_pickaxe")));
                createShaped(RecipeCategory.TOOLS, ModItems.SUNBLAZE_SHOVEL)
                        .pattern("G")
                        .pattern("/")
                        .pattern("/")
                        .input('/', Items.STICK)
                        .input('G', ModItems.SUNGAZE)
                        .criterion(hasItem(ModItems.SUNGAZE), conditionsFromItem(ModItems.SUNGAZE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "sunblaze_shovel")));
                createShaped(RecipeCategory.TOOLS, ModItems.SUNBLAZE_AXE)
                        .pattern("GG")
                        .pattern("G/")
                        .pattern(" /")
                        .input('/', Items.STICK)
                        .input('G', ModItems.SUNGAZE)
                        .criterion(hasItem(ModItems.SUNGAZE), conditionsFromItem(ModItems.SUNGAZE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "sunblaze_axe")));
                createShaped(RecipeCategory.TOOLS, ModItems.SUNBLAZE_HOE)
                        .pattern("GG")
                        .pattern(" /")
                        .pattern(" /")
                        .input('/', Items.STICK)
                        .input('G', ModItems.SUNGAZE)
                        .criterion(hasItem(ModItems.SUNGAZE), conditionsFromItem(ModItems.SUNGAZE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "sunblaze_hoe")));
                createShaped(RecipeCategory.TOOLS, ModItems.SUNBLAZE_MULTITOOL)
                        .pattern("III")
                        .pattern("PAS")
                        .pattern("TBT")
                        .input('I', ModItems.AMETHYST_BLAZE_ROD)
                        .input('T', ModItems.THERMIUM)
                        .input('B', ModBlocks.SUNGAZE_BLOCK.asItem())
                        .input('P', ModItems.SUNBLAZE_PICKAXE)
                        .input('S', ModItems.SUNBLAZE_SHOVEL)
                        .input('A', ModItems.SUNBLAZE_AXE)
                        .criterion(hasItem(ModItems.AMETHYST_BLAZE_ROD), conditionsFromItem(ModItems.AMETHYST_BLAZE_ROD))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "sunblaze_multitool")));

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_ICE, 1)
                        .pattern("PPP")
                        .pattern("PIP")
                        .pattern("PPP")
                        .input('P', ModItems.PINK_BITS)
                        .input('I', Items.BLUE_ICE)
                        .criterion(hasItem(ModItems.PINK_BITS), conditionsFromItem(ModItems.PINK_BITS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "pink_ice")));
                createShaped(RecipeCategory.COMBAT, ModItems.ELYSIUM_SWORD)
                        .pattern("E")
                        .pattern("C")
                        .pattern("K")
                        .input('K', ModItems.KUNZITE_SWORD)
                        .input('E', ModItems.ELYSIUM_INGOT)
                        .input('C', ModItems.ELYSIAN_REDSTONE_CORE)
                        .criterion(hasItem(ModItems.ELYSIUM_INGOT), conditionsFromItem(ModItems.ELYSIUM_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "elysium_sword")));
                createShaped(RecipeCategory.TOOLS, ModItems.ELYSIUM_PICKAXE)
                        .pattern("ECE")
                        .pattern(" K ")
                        .pattern(" S ")
                        .input('S', Items.STICK)
                        .input('E', ModItems.ELYSIUM_INGOT)
                        .input('K', ModItems.KUNZITE_PICKAXE)
                        .input('C', ModItems.ELYSIAN_REDSTONE_CORE)
                        .criterion(hasItem(ModItems.ELYSIUM_INGOT), conditionsFromItem(ModItems.ELYSIUM_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "elysium_pickaxe")));
                createShaped(RecipeCategory.TOOLS, ModItems.ELYSIUM_AXE)
                        .pattern("EC")
                        .pattern("EK")
                        .pattern(" S")
                        .input('S', Items.STICK)
                        .input('K', ModItems.KUNZITE_AXE)
                        .input('E', ModItems.ELYSIUM_INGOT)
                        .input('C', ModItems.ELYSIAN_REDSTONE_CORE)
                        .criterion(hasItem(ModItems.ELYSIUM_INGOT), conditionsFromItem(ModItems.ELYSIUM_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "elysium_axe")));
                createShaped(RecipeCategory.TOOLS, ModItems.ELYSIUM_SHOVEL)
                        .pattern("E")
                        .pattern("K")
                        .pattern("S")
                        .input('S', Items.STICK)
                        .input('K', ModItems.KUNZITE_SHOVEL)
                        .input('E', ModItems.ELYSIUM_INGOT)
                        .criterion(hasItem(ModItems.ELYSIUM_INGOT), conditionsFromItem(ModItems.ELYSIUM_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "elysium_shovel")));
                createShaped(RecipeCategory.TOOLS, ModItems.ELYSIUM_HOE)
                        .pattern("EE")
                        .pattern(" K")
                        .pattern(" S")
                        .input('S', Items.STICK)
                        .input('K', ModItems.KUNZITE_HOE)
                        .input('E', ModItems.ELYSIUM_INGOT)
                        .criterion(hasItem(ModItems.ELYSIUM_INGOT), conditionsFromItem(ModItems.ELYSIUM_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "elysium_hoe")));

                createShaped(RecipeCategory.TOOLS, ModItems.ELYSIUM_HAMMER)
                        .pattern("EME")
                        .pattern("CPC")
                        .pattern(" N ")
                        .input('N', Items.NETHERITE_INGOT)
                        .input('P', ModItems.ELYSIUM_PICKAXE)
                        .input('E', ModItems.ELYSIUM_INGOT)
                        .input('C', ModItems.ELYSIAN_REDSTONE_CORE)
                        .input('M', ModItems.MEMORY_SHARD)
                        .criterion(hasItem(ModItems.MEMORY_SHARD), conditionsFromItem(ModItems.MEMORY_SHARD))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "elysium_hammer")));
                createShaped(RecipeCategory.TOOLS, ModItems.ELYSIUM_MULTITOOL)
                        .pattern("EME")
                        .pattern("PAS")
                        .pattern(" N ")
                        .input('N', Items.NETHERITE_INGOT)
                        .input('P', ModItems.ELYSIUM_PICKAXE)
                        .input('E', ModItems.ENERGIZED_THERMIUM)
                        .input('S', ModItems.ELYSIUM_SHOVEL)
                        .input('A', ModItems.ELYSIUM_AXE)
                        .input('M', ModItems.MEMORY_SHARD)
                        .criterion(hasItem(ModItems.MEMORY_SHARD), conditionsFromItem(ModItems.MEMORY_SHARD))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "elysium_multitool")));
                createShaped(RecipeCategory.TOOLS, ModItems.NETHERITE_MULTITOOL)
                        .pattern("III")
                        .pattern("PAS")
                        .pattern("IBI")
                        .input('I', ModItems.PINLINE_INGOT)
                        .input('B', ModBlocks.PINLINE_BLOCK.asItem())
                        .input('P', Items.NETHERITE_PICKAXE)
                        .input('S', Items.NETHERITE_SHOVEL)
                        .input('A', Items.NETHERITE_AXE)
                        .criterion(hasItem(ModItems.PINLINE_INGOT), conditionsFromItem(ModItems.PINLINE_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "netherite_multitool")));
                createShaped(RecipeCategory.TOOLS, ModItems.DAWNBLOOMER)
                        .pattern("TMT")
                        .pattern("CSC")
                        .pattern(" N ")
                        .input('N', Items.NETHERITE_INGOT)
                        .input('T', ModItems.ENERGIZED_THERMIUM)
                        .input('S', ModItems.ELYSIUM_SWORD)
                        .input('C', ModItems.ELYSIAN_REDSTONE_CORE)
                        .input('M', ModItems.MEMORY_SHARD)
                        .criterion(hasItem(ModItems.MEMORY_SHARD), conditionsFromItem(ModItems.MEMORY_SHARD))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "dawnbloomer")));

                createShaped(RecipeCategory.COMBAT, ModItems.KUNZITE_HELMET)
                        .pattern("AKA")
                        .pattern("K K")
                        .input('K', ModItems.KUNZITE)
                        .input('A', Items.AMETHYST_SHARD)
                        .criterion(hasItem(ModItems.KUNZITE), conditionsFromItem(ModItems.KUNZITE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "kunzite_helmet")));
                createShaped(RecipeCategory.COMBAT, ModItems.KUNZITE_CHESTPLATE)
                        .pattern("K K")
                        .pattern("AKA")
                        .pattern("KKK")
                        .input('K', ModItems.KUNZITE)
                        .input('A', Items.AMETHYST_SHARD)
                        .criterion(hasItem(ModItems.KUNZITE), conditionsFromItem(ModItems.KUNZITE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "kunzite_chestplate")));
                createShaped(RecipeCategory.COMBAT, ModItems.KUNZITE_LEGGINGS)
                        .pattern("AKA")
                        .pattern("K K")
                        .pattern("K K")
                        .input('K', ModItems.KUNZITE)
                        .input('A', Items.AMETHYST_SHARD)
                        .criterion(hasItem(ModItems.KUNZITE), conditionsFromItem(ModItems.KUNZITE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "kunzite_leggings")));
                createShaped(RecipeCategory.COMBAT, ModItems.KUNZITE_BOOTS)
                        .pattern("K K")
                        .pattern("A A")
                        .input('K', ModItems.KUNZITE)
                        .input('A', Items.AMETHYST_SHARD)
                        .criterion(hasItem(ModItems.KUNZITE), conditionsFromItem(ModItems.KUNZITE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "kunzite_boots")));

                createShaped(RecipeCategory.COMBAT, ModItems.PINLINE_HELMET)
                        .pattern("KKK")
                        .pattern("K K")
                        .input('K', ModItems.PINLINE_INGOT)
                        .criterion(hasItem(ModItems.PINLINE_INGOT), conditionsFromItem(ModItems.PINLINE_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "pinline_helmet")));
                createShaped(RecipeCategory.COMBAT, ModItems.PINLINE_CHESTPLATE)
                        .pattern("K K")
                        .pattern("KKK")
                        .pattern("KKK")
                        .input('K', ModItems.PINLINE_INGOT)
                        .criterion(hasItem(ModItems.PINLINE_INGOT), conditionsFromItem(ModItems.PINLINE_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "pinline_chestplate")));
                createShaped(RecipeCategory.COMBAT, ModItems.PINLINE_LEGGINGS)
                        .pattern("KKK")
                        .pattern("K K")
                        .pattern("K K")
                        .input('K', ModItems.PINLINE_INGOT)
                        .criterion(hasItem(ModItems.PINLINE_INGOT), conditionsFromItem(ModItems.PINLINE_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "pinline_leggings")));
                createShaped(RecipeCategory.COMBAT, ModItems.PINLINE_BOOTS)
                        .pattern("K K")
                        .pattern("K K")
                        .input('K', ModItems.PINLINE_INGOT)
                        .criterion(hasItem(ModItems.PINLINE_INGOT), conditionsFromItem(ModItems.PINLINE_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "pinline_boots")));

                createShaped(RecipeCategory.COMBAT, ModItems.ELYSIUM_HELMET)
                        .pattern("CKC")
                        .pattern("E E")
                        .input('K', ModItems.KUNZITE_HELMET)
                        .input('C', ModItems.ELYSIAN_REDSTONE_CORE)
                        .input('E', ModItems.ELYSIUM_INGOT)
                        .criterion(hasItem(ModItems.ELYSIUM_INGOT), conditionsFromItem(ModItems.ELYSIUM_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "elysium_helmet")));
                createShaped(RecipeCategory.COMBAT, ModItems.ELYSIUM_CHESTPLATE)
                        .pattern("E E")
                        .pattern("CKC")
                        .pattern("EEE")
                        .input('K', ModItems.KUNZITE_CHESTPLATE)
                        .input('C', ModItems.ELYSIAN_REDSTONE_CORE)
                        .input('E', ModItems.ELYSIUM_INGOT)
                        .criterion(hasItem(ModItems.ELYSIUM_INGOT), conditionsFromItem(ModItems.ELYSIUM_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "elysium_chestplate")));
                createShaped(RecipeCategory.COMBAT, ModItems.ELYSIUM_LEGGINGS)
                        .pattern("CKC")
                        .pattern("E E")
                        .pattern("E E")
                        .input('K', ModItems.KUNZITE_LEGGINGS)
                        .input('C', ModItems.ELYSIAN_REDSTONE_CORE)
                        .input('E', ModItems.ELYSIUM_INGOT)
                        .criterion(hasItem(ModItems.ELYSIUM_INGOT), conditionsFromItem(ModItems.ELYSIUM_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "elysium_leggings")));
                createShaped(RecipeCategory.COMBAT, ModItems.ELYSIUM_BOOTS)
                        .pattern("EKE")
                        .pattern("C C")
                        .input('K', ModItems.KUNZITE_BOOTS)
                        .input('C', ModItems.ELYSIAN_REDSTONE_CORE)
                        .input('E', ModItems.ELYSIUM_INGOT)
                        .criterion(hasItem(ModItems.ELYSIUM_INGOT), conditionsFromItem(ModItems.ELYSIUM_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "elysium_boots")));

                createShaped(RecipeCategory.COMBAT, ModItems.MOONSTEEL_HELMET)
                        .pattern("KKK")
                        .pattern("K K")
                        .input('K', ModItems.MOONSTEEL_INGOT)
                        .criterion(hasItem(ModItems.MOONSTEEL_INGOT), conditionsFromItem(ModItems.MOONSTEEL_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "moonsteel_helmet")));
                createShaped(RecipeCategory.COMBAT, ModItems.MOONSTEEL_CHESTPLATE)
                        .pattern("K K")
                        .pattern("KKK")
                        .pattern("KKK")
                        .input('K', ModItems.MOONSTEEL_INGOT)
                        .criterion(hasItem(ModItems.MOONSTEEL_INGOT), conditionsFromItem(ModItems.MOONSTEEL_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "moonsteel_chestplate")));
                createShaped(RecipeCategory.COMBAT, ModItems.MOONSTEEL_LEGGINGS)
                        .pattern("KKK")
                        .pattern("K K")
                        .pattern("K K")
                        .input('K', ModItems.MOONSTEEL_INGOT)
                        .criterion(hasItem(ModItems.MOONSTEEL_INGOT), conditionsFromItem(ModItems.MOONSTEEL_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "moonsteel_leggings")));
                createShaped(RecipeCategory.COMBAT, ModItems.MOONSTEEL_BOOTS)
                        .pattern("K K")
                        .pattern("K K")
                        .input('K', ModItems.MOONSTEEL_INGOT)
                        .criterion(hasItem(ModItems.MOONSTEEL_INGOT), conditionsFromItem(ModItems.MOONSTEEL_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "moonsteel_boots")));

                createShaped(RecipeCategory.COMBAT, ModItems.CERILLE_HELMET)
                        .pattern("KKK")
                        .pattern("K K")
                        .input('K', ModItems.CERILLE_INGOT)
                        .criterion(hasItem(ModItems.CERILLE_INGOT), conditionsFromItem(ModItems.CERILLE_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "cerille_helmet")));
                createShaped(RecipeCategory.COMBAT, ModItems.CERILLE_CHESTPLATE)
                        .pattern("K K")
                        .pattern("KKK")
                        .pattern("KKK")
                        .input('K', ModItems.CERILLE_INGOT)
                        .criterion(hasItem(ModItems.CERILLE_INGOT), conditionsFromItem(ModItems.CERILLE_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "cerille_chestplate")));
                createShaped(RecipeCategory.COMBAT, ModItems.CERILLE_LEGGINGS)
                        .pattern("KKK")
                        .pattern("K K")
                        .pattern("K K")
                        .input('K', ModItems.CERILLE_INGOT)
                        .criterion(hasItem(ModItems.CERILLE_INGOT), conditionsFromItem(ModItems.CERILLE_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "cerille_leggings")));
                createShaped(RecipeCategory.COMBAT, ModItems.CERILLE_BOOTS)
                        .pattern("K K")
                        .pattern("K K")
                        .input('K', ModItems.CERILLE_INGOT)
                        .criterion(hasItem(ModItems.CERILLE_INGOT), conditionsFromItem(ModItems.CERILLE_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "cerille_boots")));

                createShaped(RecipeCategory.COMBAT, ModItems.SUNBLAZE_HELMET)
                        .pattern("TGT")
                        .pattern("G G")
                        .input('G', ModItems.SUNGAZE)
                        .input('T', ModItems.THERMIUM)
                        .criterion(hasItem(ModItems.SUNGAZE), conditionsFromItem(ModItems.SUNGAZE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "sunblaze_helmet")));
                createShaped(RecipeCategory.COMBAT, ModItems.SUNBLAZE_CHESTPLATE)
                        .pattern("G G")
                        .pattern("TGT")
                        .pattern("GGG")
                        .input('G', ModItems.SUNGAZE)
                        .input('T', ModItems.THERMIUM)
                        .criterion(hasItem(ModItems.SUNGAZE), conditionsFromItem(ModItems.SUNGAZE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "sunblaze_chestplate")));
                createShaped(RecipeCategory.COMBAT, ModItems.SUNBLAZE_LEGGINGS)
                        .pattern("TGT")
                        .pattern("G G")
                        .pattern("G G")
                        .input('G', ModItems.SUNGAZE)
                        .input('T', ModItems.THERMIUM)
                        .criterion(hasItem(ModItems.SUNGAZE), conditionsFromItem(ModItems.SUNGAZE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "sunblaze_leggings")));
                createShaped(RecipeCategory.COMBAT, ModItems.SUNBLAZE_BOOTS)
                        .pattern("T T")
                        .pattern("G G")
                        .input('G', ModItems.SUNGAZE)
                        .input('T', ModItems.THERMIUM)
                        .criterion(hasItem(ModItems.SUNGAZE), conditionsFromItem(ModItems.SUNGAZE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "sunblaze_boots")));

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHORUS_PLANKS, 4)
                        .input(ModTags.Items.CHORUS_LOGS).criterion(hasItem(ModBlocks.CHORUS_LOG),
                                conditionsFromItem(ModBlocks.CHORUS_LOG)).offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "chorus_planks")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHORUS_WOOD, 3)
                        .pattern("CC")
                        .pattern("CC")
                        .input('C', ModBlocks.CHORUS_LOG)
                        .criterion(hasItem(ModBlocks.CHORUS_LOG), conditionsFromItem(ModBlocks.CHORUS_LOG))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "chorus_wood")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_CHORUS_WOOD, 3)
                        .pattern("CC")
                        .pattern("CC")
                        .input('C', ModBlocks.STRIPPED_CHORUS_LOG)
                        .criterion(hasItem(ModBlocks.STRIPPED_CHORUS_LOG), conditionsFromItem(ModBlocks.STRIPPED_CHORUS_LOG))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "stripped_chorus_wood")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHORUS_LOG, 1)
                        .pattern("CC")
                        .pattern("CC")
                        .input('C', Items.CHORUS_FRUIT)
                        .criterion(hasItem(Items.CHORUS_FRUIT), conditionsFromItem(Items.CHORUS_FRUIT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "chorus_log")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, Blocks.CHORUS_FLOWER, 1)
                        .pattern("CCC")
                        .pattern("CCC")
                        .pattern("CCC")
                        .input('C', ModBlocks.CHORUS_LEAVES)
                        .criterion(hasItem(ModBlocks.CHORUS_LEAVES), conditionsFromItem(ModBlocks.CHORUS_LEAVES))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "chorus_flower_from_chorus_leaves")));

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KEAPHE_PLANKS, 4)
                        .input(ModTags.Items.KEAPHE_LOGS).criterion(hasItem(ModBlocks.KEAPHE_LOG),
                                conditionsFromItem(ModBlocks.KEAPHE_LOG)).offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "keaphe_planks")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KEAPHE_WOOD, 3)
                        .pattern("CC")
                        .pattern("CC")
                        .input('C', ModBlocks.KEAPHE_LOG)
                        .criterion(hasItem(ModBlocks.KEAPHE_LOG), conditionsFromItem(ModBlocks.KEAPHE_LOG))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "keaphe_wood")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_KEAPHE_WOOD, 3)
                        .pattern("CC")
                        .pattern("CC")
                        .input('C', ModBlocks.STRIPPED_KEAPHE_LOG)
                        .criterion(hasItem(ModBlocks.STRIPPED_KEAPHE_LOG), conditionsFromItem(ModBlocks.STRIPPED_KEAPHE_LOG))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "stripped_keaphe_wood")));

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WASTEWOOD_PLANKS, 4)
                        .input(ModTags.Items.WASTEWOOD_LOGS).criterion(hasItem(ModBlocks.WASTEWOOD_LOG),
                                conditionsFromItem(ModBlocks.WASTEWOOD_LOG)).offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "wastewood_planks")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WASTEWOOD_WOOD, 3)
                        .pattern("CC")
                        .pattern("CC")
                        .input('C', ModBlocks.WASTEWOOD_LOG)
                        .criterion(hasItem(ModBlocks.WASTEWOOD_LOG), conditionsFromItem(ModBlocks.WASTEWOOD_LOG))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "wastewood_wood")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_WASTEWOOD_WOOD, 3)
                        .pattern("CC")
                        .pattern("CC")
                        .input('C', ModBlocks.STRIPPED_WASTEWOOD_LOG)
                        .criterion(hasItem(ModBlocks.STRIPPED_WASTEWOOD_LOG), conditionsFromItem(ModBlocks.STRIPPED_WASTEWOOD_LOG))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "stripped_wastewood_wood")));

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CORRERIE_PLANKS, 4)
                        .input(ModTags.Items.CORRERIE_LOGS).criterion(hasItem(ModBlocks.CORRERIE_LOG),
                                conditionsFromItem(ModBlocks.CORRERIE_LOG)).offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "correrie_planks")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CORRERIE_WOOD, 3)
                        .pattern("CC")
                        .pattern("CC")
                        .input('C', ModBlocks.CORRERIE_LOG)
                        .criterion(hasItem(ModBlocks.CORRERIE_LOG), conditionsFromItem(ModBlocks.CORRERIE_LOG))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "correrie_wood")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_CORRERIE_WOOD, 3)
                        .pattern("CC")
                        .pattern("CC")
                        .input('C', ModBlocks.STRIPPED_CORRERIE_LOG)
                        .criterion(hasItem(ModBlocks.STRIPPED_CORRERIE_LOG), conditionsFromItem(ModBlocks.STRIPPED_CORRERIE_LOG))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "stripped_correrie_wood")));

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRYSTAL_CHERRY_PLANKS, 4)
                        .input(ModTags.Items.CRYSTAL_CHERRY_LOGS).criterion(hasItem(ModBlocks.CRYSTAL_CHERRY_LOG),
                                conditionsFromItem(ModBlocks.CRYSTAL_CHERRY_LOG)).offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "crystal_cherry_planks")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRYSTAL_CHERRY_WOOD, 3)
                        .pattern("CC")
                        .pattern("CC")
                        .input('C', ModBlocks.CRYSTAL_CHERRY_LOG)
                        .criterion(hasItem(ModBlocks.CRYSTAL_CHERRY_LOG), conditionsFromItem(ModBlocks.CRYSTAL_CHERRY_LOG))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "crystal_cherry_wood")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_CRYSTAL_CHERRY_WOOD, 3)
                        .pattern("CC")
                        .pattern("CC")
                        .input('C', ModBlocks.STRIPPED_CRYSTAL_CHERRY_LOG)
                        .criterion(hasItem(ModBlocks.STRIPPED_CRYSTAL_CHERRY_LOG), conditionsFromItem(ModBlocks.STRIPPED_CRYSTAL_CHERRY_LOG))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "stripped_crystal_cherry_wood")));
                createShapeless(RecipeCategory.DECORATIONS, ModBlocks.CRYSTAL_CHERRY_SAPLING, 1)
                        .input(ModItems.PINK_BITS).input(ModItems.PINK_BITS).input(ModItems.PINK_BITS)
                        .input(ModItems.PINK_BITS).input(Blocks.CHERRY_SAPLING).input(ModItems.PINK_BITS)
                        .input(ModItems.PINK_BITS).input(ModItems.PINK_BITS).input(ModItems.PINK_BITS)
                        .criterion(hasItem(Blocks.CHERRY_SAPLING),
                                conditionsFromItem(Blocks.CHERRY_SAPLING))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "crystal_cherry_sapling_from_cherry_sapling")));
                createShapeless(RecipeCategory.MISC, Items.AMETHYST_SHARD, 1)
                        .input(ModItems.KUNZITE).input(ModItems.KUNZITE).input(ModItems.KUNZITE)
                        .input(ModItems.KUNZITE).input(Items.PURPLE_DYE).input(ModItems.KUNZITE)
                        .criterion(hasItem(ModItems.PINK_BITS),
                                conditionsFromItem(ModItems.PINK_BITS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "amethyst_shard_from_kunzite")));
                createShapeless(RecipeCategory.MISC, ModItems.PINK_BITS, 2)
                        .input(ModBlocks.CRYSTAL_CHERRY_LEAVES)
                        .criterion(hasItem(ModBlocks.CRYSTAL_CHERRY_LEAVES),
                                conditionsFromItem(ModBlocks.CRYSTAL_CHERRY_LEAVES))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "pink_bits_from_crystal_cherry_leaves")));
                createShapeless(RecipeCategory.BUILDING_BLOCKS, Blocks.CHERRY_PLANKS, 1)
                        .input(ModBlocks.CRYSTAL_CHERRY_PLANKS)
                        .criterion(hasItem(ModBlocks.CRYSTAL_CHERRY_PLANKS),
                                conditionsFromItem(ModBlocks.CRYSTAL_CHERRY_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "cherry_planks_from_crystal_cherry_planks")));
                createShapeless(RecipeCategory.FOOD, ModItems.GELATINOUS_BUD, 1)
                        .input(ModItems.KUNZITE).input(ModItems.KUNZITE)
                        .input(Items.BONE_MEAL).input(Items.BONE_MEAL)
                        .criterion(hasItem(ModItems.KUNZITE), conditionsFromItem(ModItems.KUNZITE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "gelatinous_bud")));

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ASHEN_PLANKS, 4)
                        .input(ModTags.Items.ASHEN_LOGS).criterion(hasItem(ModBlocks.ASHEN_LOG),
                                conditionsFromItem(ModBlocks.ASHEN_LOG)).offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "ashen_planks")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ASHEN_WOOD, 3)
                        .pattern("CC")
                        .pattern("CC")
                        .input('C', ModBlocks.ASHEN_LOG)
                        .criterion(hasItem(ModBlocks.ASHEN_LOG), conditionsFromItem(ModBlocks.ASHEN_LOG))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "ashen_wood")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_ASHEN_WOOD, 3)
                        .pattern("CC")
                        .pattern("CC")
                        .input('C', ModBlocks.STRIPPED_ASHEN_LOG)
                        .criterion(hasItem(ModBlocks.STRIPPED_ASHEN_LOG), conditionsFromItem(ModBlocks.STRIPPED_ASHEN_LOG))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "stripped_ashen_wood")));

                createDoorRecipe(ModBlocks.CRYSTAL_CHERRY_DOOR, Ingredient.ofItem(ModBlocks.CRYSTAL_CHERRY_PLANKS))
                        .criterion(hasItem(ModBlocks.CRYSTAL_CHERRY_PLANKS), conditionsFromItem(ModBlocks.CRYSTAL_CHERRY_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "crystal_cherry_door")));
                createTrapdoorRecipe(ModBlocks.CRYSTAL_CHERRY_TRAPDOOR, Ingredient.ofItem(ModBlocks.CRYSTAL_CHERRY_PLANKS))
                        .criterion(hasItem(ModBlocks.CRYSTAL_CHERRY_PLANKS), conditionsFromItem(ModBlocks.CRYSTAL_CHERRY_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "crystal_cherry_trapdoor")));
                createButtonRecipe(ModBlocks.CRYSTAL_CHERRY_BUTTON, Ingredient.ofItem(ModBlocks.CRYSTAL_CHERRY_PLANKS))
                        .criterion(hasItem(ModBlocks.CRYSTAL_CHERRY_PLANKS), conditionsFromItem(ModBlocks.CRYSTAL_CHERRY_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "crystal_cherry_button")));
                createPressurePlateRecipe(RecipeCategory.REDSTONE, ModBlocks.CRYSTAL_CHERRY_PRESSURE_PLATE, Ingredient.ofItem(ModBlocks.CRYSTAL_CHERRY_PLANKS))
                        .criterion(hasItem(ModBlocks.CRYSTAL_CHERRY_PLANKS), conditionsFromItem(ModBlocks.CRYSTAL_CHERRY_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "crystal_cherry_pressure_plate")));
                createFenceGateRecipe(ModBlocks.CRYSTAL_CHERRY_FENCE_GATE, Ingredient.ofItem(ModBlocks.CRYSTAL_CHERRY_PLANKS))
                        .criterion(hasItem(ModBlocks.CRYSTAL_CHERRY_PLANKS), conditionsFromItem(ModBlocks.CRYSTAL_CHERRY_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "crystal_cherry_fence_gate")));
                createFenceRecipe(ModBlocks.CRYSTAL_CHERRY_FENCE, Ingredient.ofItem(ModBlocks.CRYSTAL_CHERRY_PLANKS))
                        .criterion(hasItem(ModBlocks.CRYSTAL_CHERRY_PLANKS), conditionsFromItem(ModBlocks.CRYSTAL_CHERRY_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "crystal_cherry_fence")));
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRYSTAL_CHERRY_SLAB, Ingredient.ofItem(ModBlocks.CRYSTAL_CHERRY_PLANKS))
                        .criterion(hasItem(ModBlocks.CRYSTAL_CHERRY_PLANKS), conditionsFromItem(ModBlocks.CRYSTAL_CHERRY_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "crystal_cherry_slab")));
                createStairsRecipe(ModBlocks.CRYSTAL_CHERRY_STAIRS, Ingredient.ofItem(ModBlocks.CRYSTAL_CHERRY_PLANKS))
                        .criterion(hasItem(ModBlocks.CRYSTAL_CHERRY_PLANKS), conditionsFromItem(ModBlocks.CRYSTAL_CHERRY_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "crystal_cherry_stairs")));

                createDoorRecipe(ModBlocks.CHORUS_DOOR, Ingredient.ofItem(ModBlocks.CHORUS_PLANKS))
                        .criterion(hasItem(ModBlocks.CHORUS_PLANKS), conditionsFromItem(ModBlocks.CHORUS_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "chorus_door")));
                createTrapdoorRecipe(ModBlocks.CHORUS_TRAPDOOR, Ingredient.ofItem(ModBlocks.CHORUS_PLANKS))
                        .criterion(hasItem(ModBlocks.CHORUS_PLANKS), conditionsFromItem(ModBlocks.CHORUS_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "chorus_trapdoor")));
                createButtonRecipe(ModBlocks.CHORUS_BUTTON, Ingredient.ofItem(ModBlocks.CHORUS_PLANKS))
                        .criterion(hasItem(ModBlocks.CHORUS_PLANKS), conditionsFromItem(ModBlocks.CHORUS_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "chorus_button")));
                createPressurePlateRecipe(RecipeCategory.REDSTONE, ModBlocks.CHORUS_PRESSURE_PLATE, Ingredient.ofItem(ModBlocks.CHORUS_PLANKS))
                        .criterion(hasItem(ModBlocks.CHORUS_PLANKS), conditionsFromItem(ModBlocks.CHORUS_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "chorus_pressure_plate")));
                createFenceGateRecipe(ModBlocks.CHORUS_FENCE_GATE, Ingredient.ofItem(ModBlocks.CHORUS_PLANKS))
                        .criterion(hasItem(ModBlocks.CHORUS_PLANKS), conditionsFromItem(ModBlocks.CHORUS_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "chorus_fence_gate")));
                createFenceRecipe(ModBlocks.CHORUS_FENCE, Ingredient.ofItem(ModBlocks.CHORUS_PLANKS))
                        .criterion(hasItem(ModBlocks.CHORUS_PLANKS), conditionsFromItem(ModBlocks.CHORUS_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "chorus_fence")));
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHORUS_SLAB, Ingredient.ofItem(ModBlocks.CHORUS_PLANKS))
                        .criterion(hasItem(ModBlocks.CHORUS_PLANKS), conditionsFromItem(ModBlocks.CHORUS_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "chorus_slab")));
                createStairsRecipe(ModBlocks.CHORUS_STAIRS, Ingredient.ofItem(ModBlocks.CHORUS_PLANKS))
                        .criterion(hasItem(ModBlocks.CHORUS_PLANKS), conditionsFromItem(ModBlocks.CHORUS_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "chorus_stairs")));

                createDoorRecipe(ModBlocks.ASHEN_DOOR, Ingredient.ofItem(ModBlocks.ASHEN_PLANKS))
                        .criterion(hasItem(ModBlocks.ASHEN_PLANKS), conditionsFromItem(ModBlocks.ASHEN_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "ashen_door")));
                createTrapdoorRecipe(ModBlocks.ASHEN_TRAPDOOR, Ingredient.ofItem(ModBlocks.ASHEN_PLANKS))
                        .criterion(hasItem(ModBlocks.ASHEN_PLANKS), conditionsFromItem(ModBlocks.ASHEN_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "ashen_trapdoor")));
                createButtonRecipe(ModBlocks.ASHEN_BUTTON, Ingredient.ofItem(ModBlocks.ASHEN_PLANKS))
                        .criterion(hasItem(ModBlocks.ASHEN_PLANKS), conditionsFromItem(ModBlocks.ASHEN_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "ashen_button")));
                createPressurePlateRecipe(RecipeCategory.REDSTONE, ModBlocks.ASHEN_PRESSURE_PLATE, Ingredient.ofItem(ModBlocks.ASHEN_PLANKS))
                        .criterion(hasItem(ModBlocks.ASHEN_PLANKS), conditionsFromItem(ModBlocks.ASHEN_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "ashen_pressure_plate")));
                createFenceGateRecipe(ModBlocks.ASHEN_FENCE_GATE, Ingredient.ofItem(ModBlocks.ASHEN_PLANKS))
                        .criterion(hasItem(ModBlocks.ASHEN_PLANKS), conditionsFromItem(ModBlocks.ASHEN_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "ashen_fence_gate")));
                createFenceRecipe(ModBlocks.ASHEN_FENCE, Ingredient.ofItem(ModBlocks.ASHEN_PLANKS))
                        .criterion(hasItem(ModBlocks.ASHEN_PLANKS), conditionsFromItem(ModBlocks.ASHEN_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "ashen_fence")));
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ASHEN_SLAB, Ingredient.ofItem(ModBlocks.ASHEN_PLANKS))
                        .criterion(hasItem(ModBlocks.ASHEN_PLANKS), conditionsFromItem(ModBlocks.ASHEN_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "ashen_slab")));
                createStairsRecipe(ModBlocks.ASHEN_STAIRS, Ingredient.ofItem(ModBlocks.ASHEN_PLANKS))
                        .criterion(hasItem(ModBlocks.ASHEN_PLANKS), conditionsFromItem(ModBlocks.ASHEN_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "ashen_stairs")));

                createDoorRecipe(ModBlocks.KEAPHE_DOOR, Ingredient.ofItem(ModBlocks.KEAPHE_PLANKS))
                        .criterion(hasItem(ModBlocks.KEAPHE_PLANKS), conditionsFromItem(ModBlocks.KEAPHE_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "keaphe_door")));
                createTrapdoorRecipe(ModBlocks.KEAPHE_TRAPDOOR, Ingredient.ofItem(ModBlocks.KEAPHE_PLANKS))
                        .criterion(hasItem(ModBlocks.KEAPHE_PLANKS), conditionsFromItem(ModBlocks.KEAPHE_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "keaphe_trapdoor")));
                createButtonRecipe(ModBlocks.KEAPHE_BUTTON, Ingredient.ofItem(ModBlocks.KEAPHE_PLANKS))
                        .criterion(hasItem(ModBlocks.KEAPHE_PLANKS), conditionsFromItem(ModBlocks.KEAPHE_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "keaphe_button")));
                createPressurePlateRecipe(RecipeCategory.REDSTONE, ModBlocks.KEAPHE_PRESSURE_PLATE, Ingredient.ofItem(ModBlocks.KEAPHE_PLANKS))
                        .criterion(hasItem(ModBlocks.KEAPHE_PLANKS), conditionsFromItem(ModBlocks.KEAPHE_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "keaphe_pressure_plate")));
                createFenceGateRecipe(ModBlocks.KEAPHE_FENCE_GATE, Ingredient.ofItem(ModBlocks.KEAPHE_PLANKS))
                        .criterion(hasItem(ModBlocks.KEAPHE_PLANKS), conditionsFromItem(ModBlocks.KEAPHE_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "keaphe_fence_gate")));
                createFenceRecipe(ModBlocks.KEAPHE_FENCE, Ingredient.ofItem(ModBlocks.KEAPHE_PLANKS))
                        .criterion(hasItem(ModBlocks.KEAPHE_PLANKS), conditionsFromItem(ModBlocks.KEAPHE_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "keaphe_fence")));
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KEAPHE_SLAB, Ingredient.ofItem(ModBlocks.KEAPHE_PLANKS))
                        .criterion(hasItem(ModBlocks.KEAPHE_PLANKS), conditionsFromItem(ModBlocks.KEAPHE_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "keaphe_slab")));
                createStairsRecipe(ModBlocks.KEAPHE_STAIRS, Ingredient.ofItem(ModBlocks.KEAPHE_PLANKS))
                        .criterion(hasItem(ModBlocks.KEAPHE_PLANKS), conditionsFromItem(ModBlocks.KEAPHE_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "keaphe_stairs")));

                createDoorRecipe(ModBlocks.WASTEWOOD_DOOR, Ingredient.ofItem(ModBlocks.WASTEWOOD_PLANKS))
                        .criterion(hasItem(ModBlocks.WASTEWOOD_PLANKS), conditionsFromItem(ModBlocks.WASTEWOOD_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "wastewood_door")));
                createTrapdoorRecipe(ModBlocks.WASTEWOOD_TRAPDOOR, Ingredient.ofItem(ModBlocks.WASTEWOOD_PLANKS))
                        .criterion(hasItem(ModBlocks.WASTEWOOD_PLANKS), conditionsFromItem(ModBlocks.WASTEWOOD_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "wastewood_trapdoor")));
                createButtonRecipe(ModBlocks.WASTEWOOD_BUTTON, Ingredient.ofItem(ModBlocks.WASTEWOOD_PLANKS))
                        .criterion(hasItem(ModBlocks.WASTEWOOD_PLANKS), conditionsFromItem(ModBlocks.WASTEWOOD_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "wastewood_button")));
                createPressurePlateRecipe(RecipeCategory.REDSTONE, ModBlocks.WASTEWOOD_PRESSURE_PLATE, Ingredient.ofItem(ModBlocks.WASTEWOOD_PLANKS))
                        .criterion(hasItem(ModBlocks.WASTEWOOD_PLANKS), conditionsFromItem(ModBlocks.WASTEWOOD_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "wastewood_pressure_plate")));
                createFenceGateRecipe(ModBlocks.WASTEWOOD_FENCE_GATE, Ingredient.ofItem(ModBlocks.WASTEWOOD_PLANKS))
                        .criterion(hasItem(ModBlocks.WASTEWOOD_PLANKS), conditionsFromItem(ModBlocks.WASTEWOOD_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "wastewood_fence_gate")));
                createFenceRecipe(ModBlocks.WASTEWOOD_FENCE, Ingredient.ofItem(ModBlocks.WASTEWOOD_PLANKS))
                        .criterion(hasItem(ModBlocks.WASTEWOOD_PLANKS), conditionsFromItem(ModBlocks.WASTEWOOD_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "wastewood_fence")));
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WASTEWOOD_SLAB, Ingredient.ofItem(ModBlocks.WASTEWOOD_PLANKS))
                        .criterion(hasItem(ModBlocks.WASTEWOOD_PLANKS), conditionsFromItem(ModBlocks.WASTEWOOD_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "wastewood_slab")));
                createStairsRecipe(ModBlocks.WASTEWOOD_STAIRS, Ingredient.ofItem(ModBlocks.WASTEWOOD_PLANKS))
                        .criterion(hasItem(ModBlocks.WASTEWOOD_PLANKS), conditionsFromItem(ModBlocks.WASTEWOOD_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "wastewood_stairs")));
                createDoorRecipe(ModBlocks.CORRERIE_DOOR, Ingredient.ofItem(ModBlocks.CORRERIE_PLANKS))
                        .criterion(hasItem(ModBlocks.CORRERIE_PLANKS), conditionsFromItem(ModBlocks.CORRERIE_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "correrie_door")));
                createTrapdoorRecipe(ModBlocks.CORRERIE_TRAPDOOR, Ingredient.ofItem(ModBlocks.CORRERIE_PLANKS))
                        .criterion(hasItem(ModBlocks.CORRERIE_PLANKS), conditionsFromItem(ModBlocks.CORRERIE_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "correrie_trapdoor")));
                createButtonRecipe(ModBlocks.CORRERIE_BUTTON, Ingredient.ofItem(ModBlocks.CORRERIE_PLANKS))
                        .criterion(hasItem(ModBlocks.CORRERIE_PLANKS), conditionsFromItem(ModBlocks.CORRERIE_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "correrie_button")));
                createPressurePlateRecipe(RecipeCategory.REDSTONE, ModBlocks.CORRERIE_PRESSURE_PLATE, Ingredient.ofItem(ModBlocks.CORRERIE_PLANKS))
                        .criterion(hasItem(ModBlocks.CORRERIE_PLANKS), conditionsFromItem(ModBlocks.CORRERIE_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "correrie_pressure_plate")));
                createFenceGateRecipe(ModBlocks.CORRERIE_FENCE_GATE, Ingredient.ofItem(ModBlocks.CORRERIE_PLANKS))
                        .criterion(hasItem(ModBlocks.CORRERIE_PLANKS), conditionsFromItem(ModBlocks.CORRERIE_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "correrie_fence_gate")));
                createFenceRecipe(ModBlocks.CORRERIE_FENCE, Ingredient.ofItem(ModBlocks.CORRERIE_PLANKS))
                        .criterion(hasItem(ModBlocks.CORRERIE_PLANKS), conditionsFromItem(ModBlocks.CORRERIE_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "correrie_fence")));
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CORRERIE_SLAB, Ingredient.ofItem(ModBlocks.CORRERIE_PLANKS))
                        .criterion(hasItem(ModBlocks.CORRERIE_PLANKS), conditionsFromItem(ModBlocks.CORRERIE_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "correrie_slab")));
                createStairsRecipe(ModBlocks.CORRERIE_STAIRS, Ingredient.ofItem(ModBlocks.CORRERIE_PLANKS))
                        .criterion(hasItem(ModBlocks.CORRERIE_PLANKS), conditionsFromItem(ModBlocks.CORRERIE_PLANKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "correrie_stairs")));

                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_AMETHYST_SLAB, Ingredient.ofItem(ModBlocks.POLISHED_AMETHYST_BLOCK))
                        .criterion(hasItem(ModBlocks.POLISHED_AMETHYST_BLOCK), conditionsFromItem(ModBlocks.POLISHED_AMETHYST_BLOCK))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "polished_amethyst_slab")));
                createStairsRecipe(ModBlocks.POLISHED_AMETHYST_STAIRS, Ingredient.ofItem(ModBlocks.POLISHED_AMETHYST_BLOCK))
                        .criterion(hasItem(ModBlocks.POLISHED_AMETHYST_BLOCK), conditionsFromItem(ModBlocks.POLISHED_AMETHYST_BLOCK))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "polished_amethyst_stairs")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_AMETHYST_WALL, 6)
                        .pattern("BBB")
                        .pattern("BBB")
                        .input('B', ModBlocks.POLISHED_AMETHYST_BLOCK)
                        .criterion(hasItem(ModBlocks.POLISHED_AMETHYST_BLOCK), conditionsFromItem(ModBlocks.POLISHED_AMETHYST_BLOCK))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "polished_amethyst_wall")));

                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_BRICKS_SLAB, Ingredient.ofItem(ModBlocks.AMETHYST_BRICKS))
                        .criterion(hasItem(ModBlocks.AMETHYST_BRICKS), conditionsFromItem(ModBlocks.AMETHYST_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "amethyst_bricks_slab")));
                createStairsRecipe(ModBlocks.AMETHYST_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.AMETHYST_BRICKS))
                        .criterion(hasItem(ModBlocks.AMETHYST_BRICKS), conditionsFromItem(ModBlocks.AMETHYST_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "amethyst_bricks_stairs")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_BRICKS_WALL, 6)
                        .pattern("BBB")
                        .pattern("BBB")
                        .input('B', ModBlocks.AMETHYST_BRICKS)
                        .criterion(hasItem(ModBlocks.AMETHYST_BRICKS), conditionsFromItem(ModBlocks.AMETHYST_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "amethyst_bricks_wall")));

                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KUNZITE_BRICKS_SLAB, Ingredient.ofItem(ModBlocks.KUNZITE_BRICKS))
                        .criterion(hasItem(ModBlocks.KUNZITE_BRICKS), conditionsFromItem(ModBlocks.KUNZITE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "kunzite_bricks_slab")));
                createStairsRecipe(ModBlocks.KUNZITE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.KUNZITE_BRICKS))
                        .criterion(hasItem(ModBlocks.KUNZITE_BRICKS), conditionsFromItem(ModBlocks.KUNZITE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "kunzite_bricks_stairs")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KUNZITE_BRICKS_WALL, 6)
                        .pattern("BBB")
                        .pattern("BBB")
                        .input('B', ModBlocks.KUNZITE_BRICKS)
                        .criterion(hasItem(ModBlocks.KUNZITE_BRICKS), conditionsFromItem(ModBlocks.KUNZITE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "kunzite_bricks_wall")));

                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ELYSIUM_BRICKS_SLAB, Ingredient.ofItem(ModBlocks.ELYSIUM_BRICKS))
                        .criterion(hasItem(ModBlocks.ELYSIUM_BRICKS), conditionsFromItem(ModBlocks.ELYSIUM_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "elysium_bricks_slab")));
                createStairsRecipe(ModBlocks.ELYSIUM_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.ELYSIUM_BRICKS))
                        .criterion(hasItem(ModBlocks.ELYSIUM_BRICKS), conditionsFromItem(ModBlocks.ELYSIUM_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "elysium_bricks_stairs")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ELYSIUM_BRICKS_WALL, 6)
                        .pattern("BBB")
                        .pattern("BBB")
                        .input('B', ModBlocks.ELYSIUM_BRICKS)
                        .criterion(hasItem(ModBlocks.ELYSIUM_BRICKS), conditionsFromItem(ModBlocks.ELYSIUM_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "elysium_bricks_wall")));

                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.THERMIUM_BRICKS_SLAB, Ingredient.ofItem(ModBlocks.THERMIUM_BRICKS))
                        .criterion(hasItem(ModBlocks.THERMIUM_BRICKS), conditionsFromItem(ModBlocks.THERMIUM_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "thermium_bricks_slab")));
                createStairsRecipe(ModBlocks.THERMIUM_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.THERMIUM_BRICKS))
                        .criterion(hasItem(ModBlocks.THERMIUM_BRICKS), conditionsFromItem(ModBlocks.THERMIUM_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "thermium_bricks_stairs")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.THERMIUM_BRICKS_WALL, 6)
                        .pattern("BBB")
                        .pattern("BBB")
                        .input('B', ModBlocks.THERMIUM_BRICKS)
                        .criterion(hasItem(ModBlocks.THERMIUM_BRICKS), conditionsFromItem(ModBlocks.THERMIUM_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "thermium_bricks_wall")));

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_AMETHYST_BLOCK, 4)
                        .pattern("BB")
                        .pattern("BB")
                        .input('B', Blocks.AMETHYST_BLOCK)
                        .criterion(hasItem(Blocks.AMETHYST_BLOCK), conditionsFromItem(Blocks.AMETHYST_BLOCK))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "polished_amethyst_block")));

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_BRICKS, 8)
                        .pattern("SSS")
                        .pattern("SAS")
                        .pattern("SSS")
                        .input('S', ModTags.Items.BRICKS_CRAFTABLE)
                        .input('A', Items.AMETHYST_SHARD)
                        .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "amethyst_bricks")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KUNZITE_BRICKS, 8)
                        .pattern("SSS")
                        .pattern("SKS")
                        .pattern("SSS")
                        .input('S', ModTags.Items.BRICKS_CRAFTABLE)
                        .input('K', ModItems.KUNZITE)
                        .criterion(hasItem(ModItems.KUNZITE), conditionsFromItem(ModItems.KUNZITE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "kunzite_bricks")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ELYSIUM_BRICKS, 8)
                        .pattern("SSS")
                        .pattern("SES")
                        .pattern("SSS")
                        .input('S', ModTags.Items.BRICKS_CRAFTABLE)
                        .input('E', ModItems.ELYSIUM_INGOT)
                        .criterion(hasItem(ModItems.ELYSIUM_INGOT), conditionsFromItem(ModItems.ELYSIUM_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "elysium_bricks")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.THERMIUM_BRICKS, 8)
                        .pattern("SSS")
                        .pattern("STS")
                        .pattern("SSS")
                        .input('S', ModTags.Items.BRICKS_CRAFTABLE)
                        .input('T', ModItems.THERMIUM)
                        .criterion(hasItem(ModItems.THERMIUM), conditionsFromItem(ModItems.THERMIUM))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "thermium_bricks")));

                createShapeless(RecipeCategory.FOOD, ModItems.ELYSIUM_APPLE, 4)
                        .input(Items.APPLE).input(Items.APPLE).input(Items.APPLE)
                        .input(Items.APPLE).input(ModItems.ELYSIUM_INGOT)
                        .criterion(hasItem(ModItems.ELYSIUM_INGOT), conditionsFromItem(ModItems.ELYSIUM_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "elysium_apple")));

                createShaped(RecipeCategory.FOOD, ModItems.GODFRUIT, 1)
                        .pattern("CEC")
                        .pattern("EME")
                        .pattern("CEC")
                        .input('E', ModItems.ELYSIUM_APPLE)
                        .input('C', ModItems.ELYSIAN_REDSTONE_CORE)
                        .input('M', ModItems.MEMORY_SHARD)
                        .criterion(hasItem(ModItems.MEMORY_SHARD), conditionsFromItem(ModItems.MEMORY_SHARD))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "godfruit")));

                createShaped(RecipeCategory.FOOD, ModItems.CRYSTAL_CARROT, 1)
                        .pattern("PPP")
                        .pattern("PCP")
                        .pattern("PPP")
                        .input('P', ModItems.PINK_BITS)
                        .input('C', Items.GOLDEN_CARROT)
                        .criterion(hasItem(Items.GOLDEN_CARROT), conditionsFromItem(Items.GOLDEN_CARROT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "crystal_carrot")));

                createShapeless(RecipeCategory.FOOD, ModItems.GEM_BERRY, 1)
                        .input(Items.GLOW_BERRIES).input(ModItems.KUNZITE)
                        .criterion(hasItem(ModItems.KUNZITE), conditionsFromItem(ModItems.KUNZITE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "gem_berry_from_glow_berries")));
                createShapeless(RecipeCategory.FOOD, ModItems.GEM_BERRY, 1)
                        .input(Items.SWEET_BERRIES).input(ModItems.KUNZITE)
                        .criterion(hasItem(ModItems.KUNZITE), conditionsFromItem(ModItems.KUNZITE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "gem_berry_from_sweet_berries")));

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.DISPLAY, 2)
                        .pattern("SSS")
                        .pattern("/T/")
                        .pattern("PPP")
                        .input('T', ModItems.THERMIUM)
                        .input('S', Blocks.SMOOTH_STONE)
                        .input('/', Items.STICK)
                        .input('P', Blocks.CHERRY_PLANKS)
                        .criterion(hasItem(ModItems.THERMIUM), conditionsFromItem(ModItems.THERMIUM))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "display")));
                createShaped(RecipeCategory.DECORATIONS, ModBlocks.MOONSTEEL_CHAIN, 1)
                        .pattern("S")
                        .pattern("/")
                        .pattern("S")
                        .input('S', ModItems.MOONSTEEL_NUGGET)
                        .input('/', ModItems.MOONSTEEL_INGOT)
                        .criterion(hasItem(ModItems.MOONSTEEL_NUGGET), conditionsFromItem(ModItems.MOONSTEEL_NUGGET))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "moonsteel_chain")));
                createShaped(RecipeCategory.DECORATIONS, ModBlocks.MOONSTEEL_LANTERN, 1)
                        .pattern("SSS")
                        .pattern("S/S")
                        .pattern("SSS")
                        .input('S', ModItems.MOONSTEEL_NUGGET)
                        .input('/', Items.TORCH)
                        .criterion(hasItem(ModItems.MOONSTEEL_NUGGET), conditionsFromItem(ModItems.MOONSTEEL_NUGGET))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "moonsteel_lantern")));


                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.THERMIUM_BLASTER, 1)
                        .pattern("AAA")
                        .pattern("TBT")
                        .pattern("DDD")
                        .input('T', ModItems.ENERGIZED_THERMIUM)
                        .input('B', Blocks.BLAST_FURNACE)
                        .input('A', ModBlocks.POLISHED_AMETHYST_BLOCK)
                        .input('D', Blocks.POLISHED_DEEPSLATE)
                        .criterion(hasItem(ModItems.THERMIUM), conditionsFromItem(ModItems.THERMIUM))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "thermium_blaster")));

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_AMETHYST_BRICKS, 4)
                        .pattern("BB")
                        .pattern("BB")
                        .input('B', ModBlocks.AMETHYST_BRICKS)
                        .criterion(hasItem(ModBlocks.AMETHYST_BRICKS), conditionsFromItem(ModBlocks.AMETHYST_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "chiseled_amethyst_bricks")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_KUNZITE_BRICKS, 4)
                        .pattern("BB")
                        .pattern("BB")
                        .input('B', ModBlocks.KUNZITE_BRICKS)
                        .criterion(hasItem(ModBlocks.KUNZITE_BRICKS), conditionsFromItem(ModBlocks.KUNZITE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "chiseled_kunzite_bricks")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_ELYSIUM_BRICKS, 4)
                        .pattern("BB")
                        .pattern("BB")
                        .input('B', ModBlocks.ELYSIUM_BRICKS)
                        .criterion(hasItem(ModBlocks.ELYSIUM_BRICKS), conditionsFromItem(ModBlocks.ELYSIUM_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "chiseled_elysium_bricks")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_THERMIUM_BRICKS, 4)
                        .pattern("BB")
                        .pattern("BB")
                        .input('B', ModBlocks.THERMIUM_BRICKS)
                        .criterion(hasItem(ModBlocks.THERMIUM_BRICKS), conditionsFromItem(ModBlocks.THERMIUM_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "chiseled_thermium_bricks")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_PINLINE_BRICKS, 4)
                        .pattern("BB")
                        .pattern("BB")
                        .input('B', ModBlocks.PINLINE_BRICKS)
                        .criterion(hasItem(ModBlocks.PINLINE_BRICKS), conditionsFromItem(ModBlocks.PINLINE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "chiseled_pinline_bricks")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_RAW_PINLINE_BRICKS, 4)
                        .pattern("BB")
                        .pattern("BB")
                        .input('B', ModBlocks.RAW_PINLINE_BRICKS)
                        .criterion(hasItem(ModBlocks.RAW_PINLINE_BRICKS), conditionsFromItem(ModBlocks.RAW_PINLINE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "chiseled_raw_pinline_bricks")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_MOONSTEEL_BRICKS, 4)
                        .pattern("BB")
                        .pattern("BB")
                        .input('B', ModBlocks.MOONSTEEL_BRICKS)
                        .criterion(hasItem(ModBlocks.MOONSTEEL_BRICKS), conditionsFromItem(ModBlocks.MOONSTEEL_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "chiseled_moonsteel_bricks")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_CERILLE_BRICKS, 4)
                        .pattern("BB")
                        .pattern("BB")
                        .input('B', ModBlocks.CERILLE_BRICKS)
                        .criterion(hasItem(ModBlocks.CERILLE_BRICKS), conditionsFromItem(ModBlocks.CERILLE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "chiseled_cerille_bricks")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_SUNGAZE_BRICKS, 4)
                        .pattern("BB")
                        .pattern("BB")
                        .input('B', ModBlocks.SUNGAZE_BRICKS)
                        .criterion(hasItem(ModBlocks.SUNGAZE_BRICKS), conditionsFromItem(ModBlocks.SUNGAZE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "chiseled_sungaze_bricks")));

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_BULB, 2)
                        .pattern("AAA")
                        .pattern("AGA")
                        .pattern("AAA")
                        .input('A', ModBlocks.AMETHYST_BRICKS)
                        .input('G', Blocks.GLOWSTONE)
                        .criterion(hasItem(ModBlocks.AMETHYST_BRICKS), conditionsFromItem(ModBlocks.AMETHYST_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "amethyst_bulb")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KUNZITE_BULB, 2)
                        .pattern("AAA")
                        .pattern("AGA")
                        .pattern("AAA")
                        .input('A', ModBlocks.KUNZITE_BRICKS)
                        .input('G', Blocks.GLOWSTONE)
                        .criterion(hasItem(ModBlocks.KUNZITE_BRICKS), conditionsFromItem(ModBlocks.KUNZITE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "kunzite_bulb")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ELYSIUM_BULB, 2)
                        .pattern("AAA")
                        .pattern("AGA")
                        .pattern("AAA")
                        .input('A', ModBlocks.ELYSIUM_BRICKS)
                        .input('G', Blocks.GLOWSTONE)
                        .criterion(hasItem(ModBlocks.ELYSIUM_BRICKS), conditionsFromItem(ModBlocks.ELYSIUM_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "elysium_bulb")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.THERMIUM_BULB, 2)
                        .pattern("AAA")
                        .pattern("AGA")
                        .pattern("AAA")
                        .input('A', ModBlocks.THERMIUM_BRICKS)
                        .input('G', Blocks.GLOWSTONE)
                        .criterion(hasItem(ModBlocks.THERMIUM_BRICKS), conditionsFromItem(ModBlocks.THERMIUM_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "thermium_bulb")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MEMORY_BULB, 2)
                        .pattern("AAA")
                        .pattern("AGA")
                        .pattern("AAA")
                        .input('A', ModBlocks.MEMORY_BRICKS)
                        .input('G', Blocks.GLOWSTONE)
                        .criterion(hasItem(ModBlocks.MEMORY_BRICKS), conditionsFromItem(ModBlocks.MEMORY_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "memory_bulb")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINLINE_BULB, 2)
                        .pattern("AAA")
                        .pattern("AGA")
                        .pattern("AAA")
                        .input('A', ModBlocks.PINLINE_BRICKS)
                        .input('G', Blocks.GLOWSTONE)
                        .criterion(hasItem(ModBlocks.PINLINE_BRICKS), conditionsFromItem(ModBlocks.PINLINE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "pinline_bulb")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_PINLINE_BULB, 2)
                        .pattern("AAA")
                        .pattern("AGA")
                        .pattern("AAA")
                        .input('A', ModBlocks.RAW_PINLINE_BRICKS)
                        .input('G', Blocks.GLOWSTONE)
                        .criterion(hasItem(ModBlocks.RAW_PINLINE_BRICKS), conditionsFromItem(ModBlocks.RAW_PINLINE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "raw_pinline_bulb")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOONSTEEL_BULB, 2)
                        .pattern("AAA")
                        .pattern("AGA")
                        .pattern("AAA")
                        .input('A', ModBlocks.MOONSTEEL_BRICKS)
                        .input('G', Blocks.GLOWSTONE)
                        .criterion(hasItem(ModBlocks.MOONSTEEL_BRICKS), conditionsFromItem(ModBlocks.MOONSTEEL_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "moonsteel_bulb")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CERILLE_BULB, 2)
                        .pattern("AAA")
                        .pattern("AGA")
                        .pattern("AAA")
                        .input('A', ModBlocks.CERILLE_BRICKS)
                        .input('G', Blocks.GLOWSTONE)
                        .criterion(hasItem(ModBlocks.CERILLE_BRICKS), conditionsFromItem(ModBlocks.CERILLE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "cerille_bulb")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SUNGAZE_BULB, 2)
                        .pattern("AAA")
                        .pattern("AGA")
                        .pattern("AAA")
                        .input('A', ModBlocks.SUNGAZE_BRICKS)
                        .input('G', Blocks.GLOWSTONE)
                        .criterion(hasItem(ModBlocks.SUNGAZE_BRICKS), conditionsFromItem(ModBlocks.SUNGAZE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "sungaze_bulb")));

                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MEMORY_BRICKS_SLAB, Ingredient.ofItem(ModBlocks.MEMORY_BRICKS))
                        .criterion(hasItem(ModBlocks.MEMORY_BRICKS), conditionsFromItem(ModBlocks.MEMORY_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "memory_bricks_slab")));
                createStairsRecipe(ModBlocks.MEMORY_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.MEMORY_BRICKS))
                        .criterion(hasItem(ModBlocks.MEMORY_BRICKS), conditionsFromItem(ModBlocks.MEMORY_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "memory_bricks_stairs")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MEMORY_BRICKS_WALL, 6)
                        .pattern("BBB")
                        .pattern("BBB")
                        .input('B', ModBlocks.MEMORY_BRICKS)
                        .criterion(hasItem(ModBlocks.MEMORY_BRICKS), conditionsFromItem(ModBlocks.MEMORY_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "memory_bricks_wall")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MEMORY_BRICKS, 8)
                        .pattern("SSS")
                        .pattern("SAS")
                        .pattern("SSS")
                        .input('S', ModTags.Items.BRICKS_CRAFTABLE)
                        .input('A', ModItems.MEMORY_SHARD)
                        .criterion(hasItem(ModItems.MEMORY_SHARD), conditionsFromItem(ModItems.MEMORY_SHARD))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "memory_bricks")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINLINE_BRICKS, 8)
                        .pattern("SSS")
                        .pattern("SAS")
                        .pattern("SSS")
                        .input('S', ModTags.Items.BRICKS_CRAFTABLE)
                        .input('A', ModItems.PINLINE_INGOT)
                        .criterion(hasItem(ModItems.PINLINE_INGOT), conditionsFromItem(ModItems.PINLINE_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "pinline_bricks")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_PINLINE_BRICKS, 8)
                        .pattern("SSS")
                        .pattern("SAS")
                        .pattern("SSS")
                        .input('S', ModTags.Items.BRICKS_CRAFTABLE)
                        .input('A', ModItems.RAW_PINLINE)
                        .criterion(hasItem(ModItems.RAW_PINLINE), conditionsFromItem(ModItems.RAW_PINLINE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "raw_pinline_bricks")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOONSTEEL_BRICKS, 8)
                        .pattern("SSS")
                        .pattern("SAS")
                        .pattern("SSS")
                        .input('S', ModTags.Items.BRICKS_CRAFTABLE)
                        .input('A', ModItems.MOONSTEEL_INGOT)
                        .criterion(hasItem(ModItems.MOONSTEEL_INGOT), conditionsFromItem(ModItems.MOONSTEEL_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "moonsteel_bricks")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CERILLE_BRICKS, 8)
                        .pattern("SSS")
                        .pattern("SAS")
                        .pattern("SSS")
                        .input('S', ModTags.Items.BRICKS_CRAFTABLE)
                        .input('A', ModItems.CERILLE_INGOT)
                        .criterion(hasItem(ModItems.CERILLE_INGOT), conditionsFromItem(ModItems.CERILLE_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "cerille_bricks")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SUNGAZE_BRICKS, 8)
                        .pattern("SSS")
                        .pattern("SAS")
                        .pattern("SSS")
                        .input('S', ModTags.Items.BRICKS_CRAFTABLE)
                        .input('A', ModItems.SUNGAZE)
                        .criterion(hasItem(ModItems.SUNGAZE), conditionsFromItem(ModItems.SUNGAZE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "sungaze_bricks")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COMPRESSED_END_STONE, 1)
                        .pattern("SSS")
                        .pattern("SSS")
                        .pattern("SSS")
                        .input('S', Blocks.END_STONE)
                        .criterion(hasItem(Blocks.END_STONE), conditionsFromItem(Blocks.END_STONE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "compressed_end_stone")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COMPRESSED_END_STONE_BRICKS, 4)
                        .pattern("SS")
                        .pattern("SS")
                        .input('S', ModBlocks.COMPRESSED_END_STONE)
                        .criterion(hasItem(ModBlocks.COMPRESSED_END_STONE), conditionsFromItem(ModBlocks.COMPRESSED_END_STONE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "compressed_end_stone_bricks")));
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOONSTEEL_BRICKS_SLAB, Ingredient.ofItem(ModBlocks.MOONSTEEL_BRICKS))
                        .criterion(hasItem(ModBlocks.MOONSTEEL_BRICKS), conditionsFromItem(ModBlocks.MOONSTEEL_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "moonsteel_bricks_slab")));
                createStairsRecipe(ModBlocks.MOONSTEEL_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.MOONSTEEL_BRICKS))
                        .criterion(hasItem(ModBlocks.MOONSTEEL_BRICKS), conditionsFromItem(ModBlocks.MOONSTEEL_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "moonsteel_bricks_stairs")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOONSTEEL_BRICKS_WALL, 6)
                        .pattern("BBB")
                        .pattern("BBB")
                        .input('B', ModBlocks.MOONSTEEL_BRICKS)
                        .criterion(hasItem(ModBlocks.MOONSTEEL_BRICKS), conditionsFromItem(ModBlocks.MOONSTEEL_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "moonsteel_bricks_wall")));
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CERILLE_BRICKS_SLAB, Ingredient.ofItem(ModBlocks.CERILLE_BRICKS))
                        .criterion(hasItem(ModBlocks.CERILLE_BRICKS), conditionsFromItem(ModBlocks.CERILLE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "cerille_bricks_slab")));
                createStairsRecipe(ModBlocks.CERILLE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.CERILLE_BRICKS))
                        .criterion(hasItem(ModBlocks.CERILLE_BRICKS), conditionsFromItem(ModBlocks.CERILLE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "cerille_bricks_stairs")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CERILLE_BRICKS_WALL, 6)
                        .pattern("BBB")
                        .pattern("BBB")
                        .input('B', ModBlocks.CERILLE_BRICKS)
                        .criterion(hasItem(ModBlocks.CERILLE_BRICKS), conditionsFromItem(ModBlocks.CERILLE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "cerille_bricks_wall")));
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SUNGAZE_BRICKS_SLAB, Ingredient.ofItem(ModBlocks.SUNGAZE_BRICKS))
                        .criterion(hasItem(ModBlocks.SUNGAZE_BRICKS), conditionsFromItem(ModBlocks.SUNGAZE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "sungaze_bricks_slab")));
                createStairsRecipe(ModBlocks.SUNGAZE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.SUNGAZE_BRICKS))
                        .criterion(hasItem(ModBlocks.SUNGAZE_BRICKS), conditionsFromItem(ModBlocks.SUNGAZE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "sungaze_bricks_stairs")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SUNGAZE_BRICKS_WALL, 6)
                        .pattern("BBB")
                        .pattern("BBB")
                        .input('B', ModBlocks.SUNGAZE_BRICKS)
                        .criterion(hasItem(ModBlocks.SUNGAZE_BRICKS), conditionsFromItem(ModBlocks.SUNGAZE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "sungaze_bricks_wall")));
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINLINE_BRICKS_SLAB, Ingredient.ofItem(ModBlocks.PINLINE_BRICKS))
                        .criterion(hasItem(ModBlocks.PINLINE_BRICKS), conditionsFromItem(ModBlocks.PINLINE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "pinline_bricks_slab")));
                createStairsRecipe(ModBlocks.PINLINE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.PINLINE_BRICKS))
                        .criterion(hasItem(ModBlocks.PINLINE_BRICKS), conditionsFromItem(ModBlocks.PINLINE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "pinline_bricks_stairs")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINLINE_BRICKS_WALL, 6)
                        .pattern("BBB")
                        .pattern("BBB")
                        .input('B', ModBlocks.PINLINE_BRICKS)
                        .criterion(hasItem(ModBlocks.PINLINE_BRICKS), conditionsFromItem(ModBlocks.PINLINE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "pinline_bricks_wall")));
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_PINLINE_BRICKS_SLAB, Ingredient.ofItem(ModBlocks.RAW_PINLINE_BRICKS))
                        .criterion(hasItem(ModBlocks.RAW_PINLINE_BRICKS), conditionsFromItem(ModBlocks.RAW_PINLINE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "raw_pinline_bricks_slab")));
                createStairsRecipe(ModBlocks.RAW_PINLINE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.RAW_PINLINE_BRICKS))
                        .criterion(hasItem(ModBlocks.RAW_PINLINE_BRICKS), conditionsFromItem(ModBlocks.RAW_PINLINE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "raw_pinline_bricks_stairs")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_PINLINE_BRICKS_WALL, 6)
                        .pattern("BBB")
                        .pattern("BBB")
                        .input('B', ModBlocks.RAW_PINLINE_BRICKS)
                        .criterion(hasItem(ModBlocks.RAW_PINLINE_BRICKS), conditionsFromItem(ModBlocks.RAW_PINLINE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "raw_pinline_bricks_wall")));
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COMPRESSED_END_STONE_BRICKS_SLAB, Ingredient.ofItem(ModBlocks.COMPRESSED_END_STONE_BRICKS))
                        .criterion(hasItem(ModBlocks.COMPRESSED_END_STONE_BRICKS), conditionsFromItem(ModBlocks.COMPRESSED_END_STONE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "compressed_end_stone_bricks_slab")));
                createStairsRecipe(ModBlocks.COMPRESSED_END_STONE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.COMPRESSED_END_STONE_BRICKS))
                        .criterion(hasItem(ModBlocks.COMPRESSED_END_STONE_BRICKS), conditionsFromItem(ModBlocks.COMPRESSED_END_STONE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "compressed_end_stone_bricks_stairs")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COMPRESSED_END_STONE_BRICKS_WALL, 6)
                        .pattern("BBB")
                        .pattern("BBB")
                        .input('B', ModBlocks.COMPRESSED_END_STONE_BRICKS)
                        .criterion(hasItem(ModBlocks.COMPRESSED_END_STONE_BRICKS), conditionsFromItem(ModBlocks.COMPRESSED_END_STONE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "compressed_end_stone_bricks_wall")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COMPRESSED_STYXSTONE, 1)
                        .pattern("SSS")
                        .pattern("SSS")
                        .pattern("SSS")
                        .input('S', ModBlocks.COBBLED_STYXSTONE)
                        .criterion(hasItem(ModBlocks.COBBLED_STYXSTONE), conditionsFromItem(ModBlocks.COBBLED_STYXSTONE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "compressed_styxstone")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_COMPRESSED_STYXSTONE, 4)
                        .pattern("SS")
                        .pattern("SS")
                        .input('S', ModBlocks.COMPRESSED_STYXSTONE)
                        .criterion(hasItem(ModBlocks.COMPRESSED_STYXSTONE), conditionsFromItem(ModBlocks.COMPRESSED_STYXSTONE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "polished_compressed_styxstone")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COMPRESSED_STYXSTONE_BRICKS, 4)
                        .pattern("SS")
                        .pattern("SS")
                        .input('S', ModBlocks.POLISHED_COMPRESSED_STYXSTONE)
                        .criterion(hasItem(ModBlocks.POLISHED_COMPRESSED_STYXSTONE), conditionsFromItem(ModBlocks.POLISHED_COMPRESSED_STYXSTONE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "compressed_styxstone_bricks")));
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COMPRESSED_STYXSTONE_BRICKS_SLAB, Ingredient.ofItem(ModBlocks.COMPRESSED_STYXSTONE_BRICKS))
                        .criterion(hasItem(ModBlocks.COMPRESSED_STYXSTONE_BRICKS), conditionsFromItem(ModBlocks.COMPRESSED_STYXSTONE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "compressed_styxstone_bricks_slab")));
                createStairsRecipe(ModBlocks.COMPRESSED_STYXSTONE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.COMPRESSED_STYXSTONE_BRICKS))
                        .criterion(hasItem(ModBlocks.COMPRESSED_STYXSTONE_BRICKS), conditionsFromItem(ModBlocks.COMPRESSED_STYXSTONE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "compressed_styxstone_bricks_stairs")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COMPRESSED_STYXSTONE_BRICKS_WALL, 6)
                        .pattern("BBB")
                        .pattern("BBB")
                        .input('B', ModBlocks.COMPRESSED_STYXSTONE_BRICKS)
                        .criterion(hasItem(ModBlocks.COMPRESSED_STYXSTONE_BRICKS), conditionsFromItem(ModBlocks.COMPRESSED_STYXSTONE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "compressed_styxstone_bricks_wall")));
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_COMPRESSED_STYXSTONE_SLAB, Ingredient.ofItem(ModBlocks.POLISHED_COMPRESSED_STYXSTONE))
                        .criterion(hasItem(ModBlocks.POLISHED_COMPRESSED_STYXSTONE), conditionsFromItem(ModBlocks.POLISHED_COMPRESSED_STYXSTONE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "polished_compressed_styxstone_slab")));
                createStairsRecipe(ModBlocks.POLISHED_COMPRESSED_STYXSTONE_STAIRS, Ingredient.ofItem(ModBlocks.POLISHED_COMPRESSED_STYXSTONE))
                        .criterion(hasItem(ModBlocks.POLISHED_COMPRESSED_STYXSTONE), conditionsFromItem(ModBlocks.POLISHED_COMPRESSED_STYXSTONE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "polished_compressed_styxstone_stairs")));
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_COMPRESSED_STYXSTONE_WALL, ModBlocks.POLISHED_COMPRESSED_STYXSTONE);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_STYXSTONE, 4)
                        .pattern("SS")
                        .pattern("SS")
                        .input('S', ModBlocks.COBBLED_STYXSTONE)
                        .criterion(hasItem(ModBlocks.COBBLED_STYXSTONE), conditionsFromItem(ModBlocks.COBBLED_STYXSTONE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "polished_styxstone")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STYXSTONE_BRICKS, 4)
                        .pattern("SS")
                        .pattern("SS")
                        .input('S', ModBlocks.POLISHED_STYXSTONE)
                        .criterion(hasItem(ModBlocks.POLISHED_STYXSTONE), conditionsFromItem(ModBlocks.POLISHED_STYXSTONE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "styxstone_bricks")));
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STYXSTONE_BRICKS_SLAB, Ingredient.ofItem(ModBlocks.STYXSTONE_BRICKS))
                        .criterion(hasItem(ModBlocks.STYXSTONE_BRICKS), conditionsFromItem(ModBlocks.STYXSTONE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "styxstone_bricks_slab")));
                createStairsRecipe(ModBlocks.STYXSTONE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.STYXSTONE_BRICKS))
                        .criterion(hasItem(ModBlocks.STYXSTONE_BRICKS), conditionsFromItem(ModBlocks.STYXSTONE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "styxstone_bricks_stairs")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STYXSTONE_BRICKS_WALL, 6)
                        .pattern("BBB")
                        .pattern("BBB")
                        .input('B', ModBlocks.STYXSTONE_BRICKS)
                        .criterion(hasItem(ModBlocks.STYXSTONE_BRICKS), conditionsFromItem(ModBlocks.STYXSTONE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "styxstone_bricks_wall")));
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_STYXSTONE_SLAB, Ingredient.ofItem(ModBlocks.POLISHED_STYXSTONE))
                        .criterion(hasItem(ModBlocks.POLISHED_STYXSTONE), conditionsFromItem(ModBlocks.POLISHED_STYXSTONE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "polished_styxstone_slab")));
                createStairsRecipe(ModBlocks.POLISHED_STYXSTONE_STAIRS, Ingredient.ofItem(ModBlocks.POLISHED_STYXSTONE))
                        .criterion(hasItem(ModBlocks.POLISHED_STYXSTONE), conditionsFromItem(ModBlocks.POLISHED_STYXSTONE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "polished_styxstone_stairs")));
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_STYXSTONE_WALL, ModBlocks.POLISHED_STYXSTONE);
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBBLED_STYXSTONE_SLAB, Ingredient.ofItem(ModBlocks.COBBLED_STYXSTONE))
                        .criterion(hasItem(ModBlocks.COBBLED_STYXSTONE), conditionsFromItem(ModBlocks.COBBLED_STYXSTONE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "cobbled_styxstone_slab")));
                createStairsRecipe(ModBlocks.COBBLED_STYXSTONE_STAIRS, Ingredient.ofItem(ModBlocks.COBBLED_STYXSTONE))
                        .criterion(hasItem(ModBlocks.COBBLED_STYXSTONE), conditionsFromItem(ModBlocks.COBBLED_STYXSTONE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "cobbled_styxstone_stairs")));
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBBLED_STYXSTONE_WALL, ModBlocks.COBBLED_STYXSTONE);
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_COBBLED_STYXSTONE_SLAB, Ingredient.ofItem(ModBlocks.MOSSY_COBBLED_STYXSTONE))
                        .criterion(hasItem(ModBlocks.MOSSY_COBBLED_STYXSTONE), conditionsFromItem(ModBlocks.MOSSY_COBBLED_STYXSTONE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "mossy_cobbled_styxstone_slab")));
                createStairsRecipe(ModBlocks.MOSSY_COBBLED_STYXSTONE_STAIRS, Ingredient.ofItem(ModBlocks.MOSSY_COBBLED_STYXSTONE))
                        .criterion(hasItem(ModBlocks.MOSSY_COBBLED_STYXSTONE), conditionsFromItem(ModBlocks.MOSSY_COBBLED_STYXSTONE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "mossy_cobbled_styxstone_stairs")));
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_COBBLED_STYXSTONE_WALL, ModBlocks.MOSSY_COBBLED_STYXSTONE);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MABRIZE, 4)
                        .pattern("SS")
                        .pattern("SS")
                        .input('S', ModBlocks.MABRIZE)
                        .criterion(hasItem(ModBlocks.MABRIZE), conditionsFromItem(ModBlocks.MABRIZE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "polished_mabrize")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MABRIZE_BRICKS, 4)
                        .pattern("SS")
                        .pattern("SS")
                        .input('S', ModBlocks.POLISHED_MABRIZE)
                        .criterion(hasItem(ModBlocks.POLISHED_MABRIZE), conditionsFromItem(ModBlocks.POLISHED_MABRIZE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "mabrize_bricks")));
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MABRIZE_BRICKS_SLAB, Ingredient.ofItem(ModBlocks.MABRIZE_BRICKS))
                        .criterion(hasItem(ModBlocks.MABRIZE_BRICKS), conditionsFromItem(ModBlocks.MABRIZE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "mabrize_bricks_slab")));
                createStairsRecipe(ModBlocks.MABRIZE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.MABRIZE_BRICKS))
                        .criterion(hasItem(ModBlocks.MABRIZE_BRICKS), conditionsFromItem(ModBlocks.MABRIZE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "mabrize_bricks_stairs")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MABRIZE_BRICKS_WALL, 6)
                        .pattern("BBB")
                        .pattern("BBB")
                        .input('B', ModBlocks.MABRIZE_BRICKS)
                        .criterion(hasItem(ModBlocks.MABRIZE_BRICKS), conditionsFromItem(ModBlocks.MABRIZE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "mabrize_bricks_wall")));
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MABRIZE_SLAB, Ingredient.ofItem(ModBlocks.POLISHED_MABRIZE))
                        .criterion(hasItem(ModBlocks.POLISHED_MABRIZE), conditionsFromItem(ModBlocks.POLISHED_MABRIZE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "polished_mabrize_slab")));
                createStairsRecipe(ModBlocks.POLISHED_MABRIZE_STAIRS, Ingredient.ofItem(ModBlocks.POLISHED_MABRIZE))
                        .criterion(hasItem(ModBlocks.POLISHED_MABRIZE), conditionsFromItem(ModBlocks.POLISHED_MABRIZE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "polished_mabrize_stairs")));
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MABRIZE_WALL, ModBlocks.POLISHED_MABRIZE);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_AMETANE, 4)
                        .pattern("SS")
                        .pattern("SS")
                        .input('S', ModBlocks.AMETANE)
                        .criterion(hasItem(ModBlocks.AMETANE), conditionsFromItem(ModBlocks.AMETANE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "polished_ametane")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETANE_BRICKS, 4)
                        .pattern("SS")
                        .pattern("SS")
                        .input('S', ModBlocks.POLISHED_AMETANE)
                        .criterion(hasItem(ModBlocks.POLISHED_AMETANE), conditionsFromItem(ModBlocks.POLISHED_AMETANE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "ametane_bricks")));
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETANE_BRICKS_SLAB, Ingredient.ofItem(ModBlocks.AMETANE_BRICKS))
                        .criterion(hasItem(ModBlocks.AMETANE_BRICKS), conditionsFromItem(ModBlocks.AMETANE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "ametane_bricks_slab")));
                createStairsRecipe(ModBlocks.AMETANE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.AMETANE_BRICKS))
                        .criterion(hasItem(ModBlocks.AMETANE_BRICKS), conditionsFromItem(ModBlocks.AMETANE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "ametane_bricks_stairs")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETANE_BRICKS_WALL, 6)
                        .pattern("BBB")
                        .pattern("BBB")
                        .input('B', ModBlocks.AMETANE_BRICKS)
                        .criterion(hasItem(ModBlocks.AMETANE_BRICKS), conditionsFromItem(ModBlocks.AMETANE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "ametane_bricks_wall")));
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_AMETANE_SLAB, Ingredient.ofItem(ModBlocks.POLISHED_AMETANE))
                        .criterion(hasItem(ModBlocks.POLISHED_AMETANE), conditionsFromItem(ModBlocks.POLISHED_AMETANE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "polished_ametane_slab")));
                createStairsRecipe(ModBlocks.POLISHED_AMETANE_STAIRS, Ingredient.ofItem(ModBlocks.POLISHED_AMETANE))
                        .criterion(hasItem(ModBlocks.POLISHED_AMETANE), conditionsFromItem(ModBlocks.POLISHED_AMETANE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "polished_ametane_stairs")));
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_AMETANE_WALL, ModBlocks.POLISHED_AMETANE);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CORESTONE, 2)
                        .criterion(hasItem(ModBlocks.BLACK_GOOP), conditionsFromItem(ModBlocks.BLACK_GOOP))
                        .input(ModBlocks.BLACK_GOOP).input(ModBlocks.BLACK_GOOP)
                        .input(ModTags.Items.BRICKS_CRAFTABLE).input(ModTags.Items.BRICKS_CRAFTABLE)
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "corestone_from_black_goop")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CORESTONE, 4)
                        .pattern("SS")
                        .pattern("SS")
                        .input('S', ModBlocks.CORESTONE)
                        .criterion(hasItem(ModBlocks.CORESTONE), conditionsFromItem(ModBlocks.CORESTONE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "polished_corestone")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CORESTONE_BRICKS, 4)
                        .pattern("SS")
                        .pattern("SS")
                        .input('S', ModBlocks.POLISHED_CORESTONE)
                        .criterion(hasItem(ModBlocks.POLISHED_CORESTONE), conditionsFromItem(ModBlocks.POLISHED_CORESTONE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "corestone_bricks")));
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CORESTONE_BRICKS_SLAB, Ingredient.ofItem(ModBlocks.CORESTONE_BRICKS))
                        .criterion(hasItem(ModBlocks.CORESTONE_BRICKS), conditionsFromItem(ModBlocks.CORESTONE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "corestone_bricks_slab")));
                createStairsRecipe(ModBlocks.CORESTONE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.CORESTONE_BRICKS))
                        .criterion(hasItem(ModBlocks.CORESTONE_BRICKS), conditionsFromItem(ModBlocks.CORESTONE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "corestone_bricks_stairs")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CORESTONE_BRICKS_WALL, 6)
                        .pattern("BBB")
                        .pattern("BBB")
                        .input('B', ModBlocks.CORESTONE_BRICKS)
                        .criterion(hasItem(ModBlocks.CORESTONE_BRICKS), conditionsFromItem(ModBlocks.CORESTONE_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "corestone_bricks_wall")));
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CORESTONE_SLAB, Ingredient.ofItem(ModBlocks.POLISHED_CORESTONE))
                        .criterion(hasItem(ModBlocks.POLISHED_CORESTONE), conditionsFromItem(ModBlocks.POLISHED_CORESTONE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "polished_corestone_slab")));
                createStairsRecipe(ModBlocks.POLISHED_CORESTONE_STAIRS, Ingredient.ofItem(ModBlocks.POLISHED_CORESTONE))
                        .criterion(hasItem(ModBlocks.POLISHED_CORESTONE), conditionsFromItem(ModBlocks.POLISHED_CORESTONE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "polished_corestone_stairs")));
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CORESTONE_WALL, ModBlocks.POLISHED_CORESTONE);
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_TILES_SLAB, Ingredient.ofItem(ModBlocks.AMETHYST_TILES))
                        .criterion(hasItem(ModBlocks.AMETHYST_TILES), conditionsFromItem(ModBlocks.AMETHYST_TILES))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "amethyst_tiles_slab")));
                createStairsRecipe(ModBlocks.AMETHYST_TILES_STAIRS, Ingredient.ofItem(ModBlocks.AMETHYST_TILES))
                        .criterion(hasItem(ModBlocks.AMETHYST_TILES), conditionsFromItem(ModBlocks.AMETHYST_TILES))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "amethyst_tiles_stairs")));
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_TILES_WALL, ModBlocks.AMETHYST_TILES);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_TILES, 4)
                        .pattern("SS")
                        .pattern("SS")
                        .input('S', ModBlocks.POLISHED_AMETHYST_BLOCK)
                        .criterion(hasItem(ModBlocks.POLISHED_AMETHYST_BLOCK), conditionsFromItem(ModBlocks.POLISHED_AMETHYST_BLOCK))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "amethyst_tiles")));

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_ASH, 1)
                        .input(ModBlocks.ASH_BLOCK).input(ModBlocks.ASH_BLOCK).input(Blocks.BASALT).input(Blocks.BASALT)
                        .criterion(hasItem(ModBlocks.ASH_BLOCK), conditionsFromItem(ModBlocks.ASH_BLOCK))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "packed_ash")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ASH_BRICKS, 4)
                        .pattern("SS")
                        .pattern("SS")
                        .input('S', ModBlocks.PACKED_ASH)
                        .criterion(hasItem(ModBlocks.PACKED_ASH), conditionsFromItem(ModBlocks.PACKED_ASH))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "ash_bricks")));
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ASH_BRICKS_SLAB, Ingredient.ofItem(ModBlocks.ASH_BRICKS))
                        .criterion(hasItem(ModBlocks.ASH_BRICKS), conditionsFromItem(ModBlocks.ASH_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "ash_bricks_slab")));
                createStairsRecipe(ModBlocks.ASH_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.ASH_BRICKS))
                        .criterion(hasItem(ModBlocks.ASH_BRICKS), conditionsFromItem(ModBlocks.ASH_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "ash_bricks_stairs")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ASH_BRICKS_WALL, 6)
                        .pattern("BBB")
                        .pattern("BBB")
                        .input('B', ModBlocks.ASH_BRICKS)
                        .criterion(hasItem(ModBlocks.ASH_BRICKS), conditionsFromItem(ModBlocks.ASH_BRICKS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "ash_bricks_wall")));

                offerReversibleCompactingRecipes(RecipeCategory.MISC,
                        ModItems.AMETHYST_NUGGET, RecipeCategory.MISC, Items.AMETHYST_SHARD);
                offerReversibleCompactingRecipes(RecipeCategory.MISC,
                        ModItems.DIAMOND_NUGGET, RecipeCategory.MISC, Items.DIAMOND);
                offerReversibleCompactingRecipes(RecipeCategory.MISC,
                        ModItems.EMERALD_NUGGET, RecipeCategory.MISC, Items.EMERALD);
                offerReversibleCompactingRecipes(RecipeCategory.MISC,
                        ModItems.QUARTZ_NUGGET, RecipeCategory.MISC, Items.QUARTZ);
                offerReversibleCompactingRecipes(RecipeCategory.MISC,
                        ModItems.NETHERITE_NUGGET, RecipeCategory.MISC, Items.NETHERITE_INGOT);

                createShaped(RecipeCategory.MISC, ModItems.KUNZITE, 1)
                        .pattern("SSS")
                        .pattern("SSS")
                        .pattern("SSS")
                        .input('S', ModItems.KUNZITE_NUGGET)
                        .criterion(hasItem(ModItems.KUNZITE_NUGGET), conditionsFromItem(ModItems.KUNZITE_NUGGET))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "kunzite_from_nugget")));
                createShapeless(RecipeCategory.MISC, ModItems.KUNZITE_NUGGET, 9)
                        .criterion(hasItem(ModItems.KUNZITE), conditionsFromItem(ModItems.KUNZITE))
                        .input(ModItems.KUNZITE).offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "nugget_from_kunzite")));
                createShaped(RecipeCategory.MISC, ModBlocks.BLACK_GOOP, 1)
                        .pattern("SS")
                        .pattern("SS")
                        .input('S', ModItems.CORRUPT_MASS)
                        .criterion(hasItem(ModItems.CORRUPT_DROPLET), conditionsFromItem(ModItems.CORRUPT_DROPLET))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "black_goop")));

                createShaped(RecipeCategory.MISC, ModItems.THERMIUM, 1)
                        .pattern("SSS")
                        .pattern("SSS")
                        .pattern("SSS")
                        .input('S', ModItems.THERMIUM_NUGGET)
                        .criterion(hasItem(ModItems.THERMIUM_NUGGET), conditionsFromItem(ModItems.THERMIUM_NUGGET))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "thermium_from_nugget")));
                createShapeless(RecipeCategory.MISC, ModItems.THERMIUM_NUGGET, 9)
                        .criterion(hasItem(ModItems.THERMIUM), conditionsFromItem(ModItems.THERMIUM))
                        .input(ModItems.THERMIUM).offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "nugget_from_thermium")));

                createShaped(RecipeCategory.MISC, ModItems.ELYSIUM_INGOT, 1)
                        .pattern("SSS")
                        .pattern("SSS")
                        .pattern("SSS")
                        .input('S', ModItems.ELYSIUM_NUGGET)
                        .criterion(hasItem(ModItems.ELYSIUM_NUGGET), conditionsFromItem(ModItems.ELYSIUM_NUGGET))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "elysium_from_nugget")));
                createShapeless(RecipeCategory.MISC, ModItems.ELYSIUM_NUGGET, 9)
                        .criterion(hasItem(ModItems.ELYSIUM_INGOT), conditionsFromItem(ModItems.ELYSIUM_INGOT))
                        .input(ModItems.ELYSIUM_INGOT).offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "nugget_from_elysium")));

                createShaped(RecipeCategory.MISC, ModItems.MOONSTEEL_INGOT, 1)
                        .pattern("SSS")
                        .pattern("SSS")
                        .pattern("SSS")
                        .input('S', ModItems.MOONSTEEL_NUGGET)
                        .criterion(hasItem(ModItems.MOONSTEEL_NUGGET), conditionsFromItem(ModItems.MOONSTEEL_NUGGET))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "moonsteel_from_nugget")));
                createShapeless(RecipeCategory.MISC, ModItems.MOONSTEEL_NUGGET, 9)
                        .criterion(hasItem(ModItems.MOONSTEEL_INGOT), conditionsFromItem(ModItems.MOONSTEEL_INGOT))
                        .input(ModItems.MOONSTEEL_INGOT).offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "nugget_from_moonsteel")));

                createShaped(RecipeCategory.MISC, ModItems.CERILLE_INGOT, 1)
                        .pattern("SSS")
                        .pattern("SSS")
                        .pattern("SSS")
                        .input('S', ModItems.CERILLE_NUGGET)
                        .criterion(hasItem(ModItems.CERILLE_NUGGET), conditionsFromItem(ModItems.CERILLE_NUGGET))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "cerille_from_nugget")));
                createShapeless(RecipeCategory.MISC, ModItems.CERILLE_NUGGET, 9)
                        .criterion(hasItem(ModItems.CERILLE_INGOT), conditionsFromItem(ModItems.CERILLE_INGOT))
                        .input(ModItems.CERILLE_INGOT).offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "nugget_from_cerille")));

                createShaped(RecipeCategory.MISC, ModItems.PINLINE_INGOT, 1)
                        .pattern("SSS")
                        .pattern("SSS")
                        .pattern("SSS")
                        .input('S', ModItems.PINLINE_NUGGET)
                        .criterion(hasItem(ModItems.PINLINE_NUGGET), conditionsFromItem(ModItems.PINLINE_NUGGET))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "pinline_from_nugget")));
                createShapeless(RecipeCategory.MISC, ModItems.PINLINE_NUGGET, 9)
                        .criterion(hasItem(ModItems.PINLINE_INGOT), conditionsFromItem(ModItems.PINLINE_INGOT))
                        .input(ModItems.PINLINE_INGOT).offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "nugget_from_pinline")));

                createShaped(RecipeCategory.MISC, ModItems.SUNGAZE, 1)
                        .pattern("SSS")
                        .pattern("SSS")
                        .pattern("SSS")
                        .input('S', ModItems.SUNGAZE_NUGGET)
                        .criterion(hasItem(ModItems.SUNGAZE_NUGGET), conditionsFromItem(ModItems.SUNGAZE_NUGGET))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "sungaze_from_nugget")));
                createShapeless(RecipeCategory.MISC, ModItems.SUNGAZE_NUGGET, 9)
                        .criterion(hasItem(ModItems.SUNGAZE), conditionsFromItem(ModItems.SUNGAZE))
                        .input(ModItems.SUNGAZE).offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "nugget_from_sungaze")));

                createShaped(RecipeCategory.MISC, ModBlocks.AMETHYST_CLUMP, 1)
                        .pattern("S S")
                        .pattern(" S ")
                        .pattern("S S")
                        .input('S', ModItems.AMETHYST_NUGGET)
                        .criterion(hasItem(ModItems.AMETHYST_NUGGET), conditionsFromItem(ModItems.AMETHYST_NUGGET))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "amethyst_clump")));
                createShaped(RecipeCategory.MISC, ModBlocks.KUNZITE_CLUMP, 1)
                        .pattern("S S")
                        .pattern(" S ")
                        .pattern("S S")
                        .input('S', ModItems.KUNZITE_NUGGET)
                        .criterion(hasItem(ModItems.KUNZITE_NUGGET), conditionsFromItem(ModItems.KUNZITE_NUGGET))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "kunzite_clump")));
                createShaped(RecipeCategory.MISC, ModBlocks.DIAMOND_CLUMP, 1)
                        .pattern("S S")
                        .pattern(" S ")
                        .pattern("S S")
                        .input('S', ModItems.DIAMOND_NUGGET)
                        .criterion(hasItem(ModItems.DIAMOND_NUGGET), conditionsFromItem(ModItems.DIAMOND_NUGGET))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "diamond_clump")));
                createShaped(RecipeCategory.MISC, ModBlocks.EMERALD_CLUMP, 1)
                        .pattern("S S")
                        .pattern(" S ")
                        .pattern("S S")
                        .input('S', ModItems.EMERALD_NUGGET)
                        .criterion(hasItem(ModItems.EMERALD_NUGGET), conditionsFromItem(ModItems.EMERALD_NUGGET))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "emerald_clump")));
                createShaped(RecipeCategory.MISC, ModBlocks.QUARTZ_CLUMP, 1)
                        .pattern("S S")
                        .pattern(" S ")
                        .pattern("S S")
                        .input('S', ModItems.QUARTZ_NUGGET)
                        .criterion(hasItem(ModItems.QUARTZ_NUGGET), conditionsFromItem(ModItems.QUARTZ_NUGGET))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "quartz_clump")));
                createShaped(RecipeCategory.MISC, ModBlocks.THERMIUM_CLUMP, 1)
                        .pattern("S S")
                        .pattern(" S ")
                        .pattern("S S")
                        .input('S', ModItems.THERMIUM_NUGGET)
                        .criterion(hasItem(ModItems.THERMIUM_NUGGET), conditionsFromItem(ModItems.THERMIUM_NUGGET))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "thermium_clump")));

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KUNZITE_ROD, 4)
                        .pattern("R")
                        .pattern("M")
                        .input('R', Items.BLAZE_ROD)
                        .input('M', ModItems.KUNZITE)
                        .criterion(hasItem(ModItems.KUNZITE), conditionsFromItem(ModItems.KUNZITE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "kunzite_rod")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ELYSIUM_ROD, 4)
                        .pattern("R")
                        .pattern("M")
                        .input('R', Items.BLAZE_ROD)
                        .input('M', ModItems.ELYSIUM_INGOT)
                        .criterion(hasItem(ModItems.ELYSIUM_INGOT), conditionsFromItem(ModItems.ELYSIUM_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "elysium_rod")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_ROD, 4)
                        .pattern("R")
                        .pattern("M")
                        .input('R', Items.BLAZE_ROD)
                        .input('M', Items.AMETHYST_SHARD)
                        .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "amethyst_rod")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.THERMIUM_ROD, 4)
                        .pattern("R")
                        .pattern("M")
                        .input('R', Items.BLAZE_ROD)
                        .input('M', ModItems.THERMIUM)
                        .criterion(hasItem(ModItems.THERMIUM), conditionsFromItem(ModItems.THERMIUM))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "thermium_rod")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINLINE_ROD, 4)
                        .pattern("R")
                        .pattern("M")
                        .input('R', Items.BLAZE_ROD)
                        .input('M', ModItems.PINLINE_INGOT)
                        .criterion(hasItem(ModItems.PINLINE_INGOT), conditionsFromItem(ModItems.PINLINE_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "pinline_rod")));
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_PINLINE_ROD, 4)
                        .pattern("R")
                        .pattern("M")
                        .input('R', Items.BLAZE_ROD)
                        .input('M', ModItems.RAW_PINLINE)
                        .criterion(hasItem(ModItems.RAW_PINLINE), conditionsFromItem(ModItems.RAW_PINLINE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "raw_pinline_rod")));

                createShaped(RecipeCategory.BUILDING_BLOCKS, Blocks.TORCH, 4)
                        .pattern("C")
                        .pattern("/")
                        .input('/', Items.STICK)
                        .input('C', ModItems.STYXCOAL)
                        .criterion(hasItem(ModItems.STYXCOAL), conditionsFromItem(ModItems.STYXCOAL))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "torch_from_styxcoal")));

                createShapeless(RecipeCategory.FOOD, ModItems.COAL_MEAL, 2)
                        .criterion(hasItem(Items.COAL), conditionsFromItem(Items.COAL))
                        .input(ItemTags.COALS).input(ItemTags.COALS).input(ItemTags.COALS)
                        .input(ModItems.THERMIUM_NUGGET).input(Items.WHEAT).input(ModItems.THERMIUM_NUGGET)
                        .input(ItemTags.COALS).input(ItemTags.COALS).input(ItemTags.COALS)
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "coal_meal")));

                createShaped(RecipeCategory.MISC, ModItems.BEDROCK_BREAKER, 1)
                        .pattern("CEC")
                        .pattern("CBC")
                        .pattern("CSC")
                        .input('S', ModBlocks.PINLINE_BLOCK)
                        .input('E', ModItems.ELYSIUM_INGOT)
                        .input('C', Items.COPPER_INGOT)
                        .input('B', Items.BRUSH)
                        .criterion(hasItem(ModItems.PINLINE_INGOT), conditionsFromItem(ModItems.PINLINE_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "bedrock_breaker")));

                createShaped(RecipeCategory.REDSTONE, ModBlocks.AMETHYST_LAMP, 1)
                        .pattern("ECE")
                        .pattern("CLC")
                        .pattern("ECE")
                        .input('E', ModItems.MOONSTEEL_INGOT)
                        .input('C', Items.AMETHYST_BLOCK)
                        .input('L', Items.REDSTONE_LAMP)
                        .criterion(hasItem(Items.REDSTONE_LAMP), conditionsFromItem(Items.REDSTONE_LAMP))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "amethyst_lamp")));

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STYXIA_PORTAL_FRAME, 1)
                        .pattern("N N")
                        .pattern("CCC")
                        .pattern("NSN")
                        .input('N', ModItems.MOONSTEEL_NUGGET)
                        .input('S', ModBlocks.STYXSTONE)
                        .input('C', ModItems.CERILLE_INGOT)
                        .criterion(hasItem(ModBlocks.STYXSTONE), conditionsFromItem(ModBlocks.STYXSTONE))
                        .criterion(hasItem(ModBlocks.STYXIA_PORTAL_FRAME), conditionsFromItem(ModBlocks.STYXIA_PORTAL_FRAME))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "styxia_portal_frame")));

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_SANDSTONE, 1)
                        .pattern("SS")
                        .pattern("SS")
                        .input('S', ModBlocks.PINK_SAND)
                        .criterion(hasItem(ModBlocks.PINK_SAND), conditionsFromItem(ModBlocks.PINK_SAND))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "pink_sand")));
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_SANDSTONE_SLAB, Ingredient.ofItem(ModBlocks.PINK_SANDSTONE))
                        .criterion(hasItem(ModBlocks.PINK_SANDSTONE), conditionsFromItem(ModBlocks.PINK_SANDSTONE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "pink_sandstone_slab")));
                createStairsRecipe(ModBlocks.PINK_SANDSTONE_STAIRS, Ingredient.ofItem(ModBlocks.PINK_SANDSTONE))
                        .criterion(hasItem(ModBlocks.PINK_SANDSTONE), conditionsFromItem(ModBlocks.PINK_SANDSTONE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "pink_sandstone_stairs")));
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_SANDSTONE_WALL, ModBlocks.PINK_SANDSTONE);
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_PINK_SANDSTONE_SLAB, Ingredient.ofItem(ModBlocks.SMOOTH_PINK_SANDSTONE))
                        .criterion(hasItem(ModBlocks.SMOOTH_PINK_SANDSTONE), conditionsFromItem(ModBlocks.SMOOTH_PINK_SANDSTONE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "smooth_pink_sandstone_slab")));
                createStairsRecipe(ModBlocks.PINK_SANDSTONE_STAIRS, Ingredient.ofItem(ModBlocks.SMOOTH_PINK_SANDSTONE))
                        .criterion(hasItem(ModBlocks.SMOOTH_PINK_SANDSTONE), conditionsFromItem(ModBlocks.SMOOTH_PINK_SANDSTONE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "smooth_pink_sandstone_stairs")));
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_PINK_SANDSTONE_SLAB, Ingredient.ofItem(ModBlocks.CUT_PINK_SANDSTONE))
                        .criterion(hasItem(ModBlocks.CUT_PINK_SANDSTONE), conditionsFromItem(ModBlocks.CUT_PINK_SANDSTONE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "cut_pink_sandstone_slab")));
                offerChiseledBlockRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_PINK_SANDSTONE, ModBlocks.PINK_SANDSTONE);
                offerSmelting(List.of(ModBlocks.PINK_SANDSTONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_PINK_SANDSTONE,
                        0f, 200, "smooth_pink_sandstone");

                createShapeless(RecipeCategory.DECORATIONS, ModBlocks.AMETHYST_PARTERS, 1)
                        .input(ItemTags.FLOWERS).input(ModItems.AMETHYST_NUGGET)
                        .criterion(hasItem(ModItems.AMETHYST_NUGGET), conditionsFromItem(ModItems.AMETHYST_NUGGET))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "amethyst_parters")));
                createShapeless(RecipeCategory.DECORATIONS, ModBlocks.KUNZITE_LOVELILY, 1)
                        .input(ItemTags.FLOWERS).input(ModItems.KUNZITE_NUGGET)
                        .criterion(hasItem(ModItems.KUNZITE_NUGGET), conditionsFromItem(ModItems.KUNZITE_NUGGET))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "kunzite_lovelily")));
                createShapeless(RecipeCategory.DECORATIONS, ModBlocks.ELYSIAN_SKYBERRY, 1)
                        .input(ItemTags.FLOWERS).input(ModItems.ELYSIUM_NUGGET)
                        .criterion(hasItem(ModItems.ELYSIUM_NUGGET), conditionsFromItem(ModItems.ELYSIUM_NUGGET))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "elysian_skyberry")));
                createShapeless(RecipeCategory.DECORATIONS, ModBlocks.MEMORIA_BOURPEER, 1)
                        .input(ItemTags.FLOWERS).input(ModItems.MEMORY_SHARD)
                        .criterion(hasItem(ModItems.MEMORY_SHARD), conditionsFromItem(ModItems.MEMORY_SHARD))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "memoria_bourpeer")));
                createShapeless(RecipeCategory.DECORATIONS, ModBlocks.THERMIUM_WILTBORN, 1)
                        .input(ItemTags.FLOWERS).input(ModItems.THERMIUM)
                        .criterion(hasItem(ModItems.THERMIUM), conditionsFromItem(ModItems.THERMIUM))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "thermium_wiltborn")));

                createShapeless(RecipeCategory.MISC, ModItems.THERMIUM_NUGGET, 1)
                        .input(ModItems.HAZEWEAVER)
                        .criterion(hasItem(ModItems.HAZEWEAVER), conditionsFromItem(ModItems.HAZEWEAVER))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "thermium_nugget_from_hazeweaver")));
                createShapeless(RecipeCategory.MISC, ModBlocks.MOSSY_COBBLED_STYXSTONE, 1)
                        .input(ModBlocks.STYXMOSS).input(ModBlocks.COBBLED_STYXSTONE)
                        .criterion(hasItem(ModBlocks.COBBLED_STYXSTONE), conditionsFromItem(ModBlocks.COBBLED_STYXSTONE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "mossy_cobbled_styxstone")));

                createShapeless(RecipeCategory.MISC, ModItems.BERRY_SALAD, 1)
                        .input(ModTags.Items.BERRIES).input(ModTags.Items.BERRIES).input(ModTags.Items.BERRIES).input(Items.BOWL)
                        .criterion(hasItem(Items.BOWL), conditionsFromItem(Items.BOWL))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "berry_salad")));
                createShapeless(RecipeCategory.MISC, ModItems.FLESHY_STEW, 1)
                        .input(ModItems.CORRUPT_MASS).input(Items.ROTTEN_FLESH).input(Items.ROTTEN_FLESH).input(Items.BOWL)
                        .criterion(hasItem(ModItems.CORRUPT_MASS), conditionsFromItem(ModItems.CORRUPT_MASS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "fleshy_stew")));

                createShapeless(RecipeCategory.MISC, Items.GUNPOWDER, 1)
                        .input(ModItems.SULFUR).input(ItemTags.COALS).input(ItemTags.COALS)
                        .criterion(hasItem(ModItems.SULFUR), conditionsFromItem(ModItems.SULFUR))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "gunpowder_from_sulfur")));
                createShapeless(RecipeCategory.MISC, Items.BLAZE_POWDER, 2)
                        .input(ModItems.SULFUR).input(ModItems.SULFUR)
                        .input(Items.BLAZE_POWDER).input(Items.GLOWSTONE_DUST)
                        .criterion(hasItem(ModItems.SULFUR), conditionsFromItem(ModItems.SULFUR))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "blaze_powder_from_sulfur")));
                createShapeless(RecipeCategory.MISC, ModBlocks.ASHEN_LOG, 2)
                        .input(ItemTags.LOGS_THAT_BURN).input(ItemTags.LOGS_THAT_BURN).input(Items.FIRE_CHARGE).input(Items.GUNPOWDER)
                        .criterion(hasItem(Items.FIRE_CHARGE), conditionsFromItem(Items.FIRE_CHARGE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "ashen_logs")));

                createShapeless(RecipeCategory.MISC, Items.ENDER_PEARL, 1)
                        .input(ModItems.RAW_PINLINE).input(Items.CHORUS_FRUIT)
                        .input(ModItems.RAW_PINLINE).input(Items.CHORUS_FRUIT)
                        .criterion(hasItem(ModItems.RAW_PINLINE), conditionsFromItem(ModItems.RAW_PINLINE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "ender_pearl_from_pinline")));
                createShaped(RecipeCategory.MISC, Items.SHULKER_SHELL, 2)
                        .pattern("ISI")
                        .pattern("I I")
                        .input('S', Items.SHULKER_SHELL)
                        .input('I', ModItems.PINLINE_INGOT)
                        .criterion(hasItem(ModItems.PINLINE_INGOT), conditionsFromItem(ModItems.PINLINE_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "shulker_shell_from_pinline")));
                createShapeless(RecipeCategory.MISC, Items.PURPLE_DYE, 1)
                        .input(ModBlocks.CHORUS_LILY)
                        .criterion(hasItem(ModBlocks.CHORUS_LILY), conditionsFromItem(ModBlocks.CHORUS_LILY))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "black_dye_from_chorus_lily")));
                createShapeless(RecipeCategory.MISC, ModItems.GLAZED_CHORUS_FRUIT, 1)
                        .input(ModBlocks.CHORUS_LILY).input(ModBlocks.CHORUS_LILY)
                        .input(Items.POPPED_CHORUS_FRUIT).input(Items.POPPED_CHORUS_FRUIT)
                        .criterion(hasItem(Items.CHORUS_FRUIT), conditionsFromItem(Items.CHORUS_FRUIT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "glazed_chorus_fruit")));

                createShapeless(RecipeCategory.MISC, ModBlocks.SNOWY_SPRUCE_SAPLING, 1)
                        .input(Blocks.SPRUCE_SAPLING).input(Items.SNOWBALL).input(Items.SNOWBALL).input(Items.SNOWBALL)
                        .criterion(hasItem(Blocks.SPRUCE_SAPLING), conditionsFromItem(Blocks.SPRUCE_SAPLING))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "snowy_spruce_sapling")));
                createShapeless(RecipeCategory.MISC, ModBlocks.SNOWY_SPRUCE_LEAVES, 1)
                        .input(Blocks.SPRUCE_LEAVES).input(Items.SNOWBALL)
                        .criterion(hasItem(Blocks.SPRUCE_LEAVES), conditionsFromItem(Blocks.SPRUCE_LEAVES))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "snowy_spruce_leaves")));
                createShapeless(RecipeCategory.MISC, ModBlocks.GLOWING_CHERRY_LEAVES, 1)
                        .input(Blocks.CHERRY_LEAVES).input(Items.GLOWSTONE_DUST)
                        .criterion(hasItem(Blocks.CHERRY_LEAVES), conditionsFromItem(Blocks.CHERRY_LEAVES))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "glowing_cherry_leaves")));

                createShapeless(RecipeCategory.MISC, ModBlocks.GLOWING_AMETHYST, 1)
                        .input(Blocks.AMETHYST_BLOCK).input(Items.GLOWSTONE_DUST).input(Items.GLOWSTONE_DUST).input(Items.GLOWSTONE_DUST)
                        .criterion(hasItem(Blocks.AMETHYST_BLOCK), conditionsFromItem(Blocks.AMETHYST_BLOCK))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "glowing_amethyst")));

                createShapeless(RecipeCategory.MISC, Items.PURPLE_DYE, 1)
                        .input(ModBlocks.DEATH_FLOWERS)
                        .criterion(hasItem(ModBlocks.DEATH_FLOWERS), conditionsFromItem(ModBlocks.DEATH_FLOWERS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "dye_from_death_flowers")));

                createShaped(RecipeCategory.MISC, Items.LEATHER, 1)
                        .pattern("CD")
                        .pattern("CC")
                        .input('D', Items.BROWN_DYE)
                        .input('C', ModItems.COTTON)
                        .criterion(hasItem(ModItems.COTTON), conditionsFromItem(ModItems.COTTON))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "leather_from_cotton")));
                createShaped(RecipeCategory.MISC, Blocks.WHITE_WOOL, 1)
                        .pattern("CCC")
                        .pattern("CCC")
                        .pattern("CCC")
                        .input('C', ModItems.COTTON)
                        .criterion(hasItem(ModItems.COTTON), conditionsFromItem(ModItems.COTTON))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "wool_from_cotton")));
                createShaped(RecipeCategory.MISC, ModItems.CORRUPT_MASS, 1)
                        .pattern("CC")
                        .pattern("CC")
                        .input('C', ModItems.DEAD_SPROUT)
                        .criterion(hasItem(ModItems.DEAD_SPROUT), conditionsFromItem(ModItems.DEAD_SPROUT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "corrupt_mass_from_dead_sprout")));

                createShapeless(RecipeCategory.MISC, Items.MUSHROOM_STEW, 1)
                        .input(ModBlocks.BLUE_MUSHROOM).input(Items.RED_MUSHROOM).input(Items.BOWL)
                        .criterion(hasItem(Items.BOWL), conditionsFromItem(Items.BOWL))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "mushroom_stew_blue_and_red")));
                createShapeless(RecipeCategory.MISC, Items.MUSHROOM_STEW, 1)
                        .input(ModBlocks.BLUE_MUSHROOM).input(Items.BROWN_MUSHROOM).input(Items.BOWL)
                        .criterion(hasItem(Items.BOWL), conditionsFromItem(Items.BOWL))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "mushroom_stew_blue_and_brown")));

                offerSmithingTrimRecipe(ModItems.CHERRY_SMITHING_TEMPLATE, ModTrimPatterns.CHERRY,
                        RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(JirniysPinkStuff.MOD_ID, "cherry")));
                offerSmithingTemplateCopyingRecipe(ModItems.CHERRY_SMITHING_TEMPLATE, ModBlocks.CRYSTAL_CHERRY_LOG);
                offerSmithingTrimRecipe(ModItems.BLOOM_SMITHING_TEMPLATE, ModTrimPatterns.BLOOM,
                        RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(JirniysPinkStuff.MOD_ID, "bloom")));
                offerSmithingTemplateCopyingRecipe(ModItems.BLOOM_SMITHING_TEMPLATE, ModBlocks.CRYSTAL_CHERRY_LOG);
                offerSmithingTrimRecipe(ModItems.SWORDMASTER_SMITHING_TEMPLATE, ModTrimPatterns.SWORDMASTER,
                        RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(JirniysPinkStuff.MOD_ID, "swordmaster")));
                offerSmithingTemplateCopyingRecipe(ModItems.SWORDMASTER_SMITHING_TEMPLATE, Blocks.COPPER_BLOCK);
                offerSmithingTrimRecipe(ModItems.SHATTER_SMITHING_TEMPLATE, ModTrimPatterns.SHATTER,
                        RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(JirniysPinkStuff.MOD_ID, "shatter")));
                offerSmithingTemplateCopyingRecipe(ModItems.SHATTER_SMITHING_TEMPLATE, Blocks.TERRACOTTA);
                offerSmithingTrimRecipe(ModItems.CREEPER_SMITHING_TEMPLATE, ModTrimPatterns.CREEPER,
                        RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(JirniysPinkStuff.MOD_ID, "creeper")));
                offerSmithingTemplateCopyingRecipe(ModItems.CREEPER_SMITHING_TEMPLATE, Items.CREEPER_HEAD);
                offerSmithingTrimRecipe(ModItems.CHESS_SMITHING_TEMPLATE, ModTrimPatterns.CHESS,
                        RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(JirniysPinkStuff.MOD_ID, "chess")));
                offerSmithingTemplateCopyingRecipe(ModItems.CHESS_SMITHING_TEMPLATE, Items.BLUE_WOOL);
                offerSmithingTrimRecipe(ModItems.WANDERER_SMITHING_TEMPLATE, ModTrimPatterns.WANDERER,
                        RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(JirniysPinkStuff.MOD_ID, "wanderer")));
                offerSmithingTemplateCopyingRecipe(ModItems.WANDERER_SMITHING_TEMPLATE, Items.BLUE_WOOL);
                offerSmithingTrimRecipe(ModItems.SHELL_SMITHING_TEMPLATE, ModTrimPatterns.SHELL,
                        RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(JirniysPinkStuff.MOD_ID, "shell")));
                offerSmithingTemplateCopyingRecipe(ModItems.SHELL_SMITHING_TEMPLATE, Items.PURPUR_BLOCK);
                offerSmithingTrimRecipe(ModItems.WINGFLAP_SMITHING_TEMPLATE, ModTrimPatterns.WINGFLAP,
                        RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(JirniysPinkStuff.MOD_ID, "wingflap")));
                offerSmithingTemplateCopyingRecipe(ModItems.WINGFLAP_SMITHING_TEMPLATE, Items.PURPUR_BLOCK);
                offerSmithingTrimRecipe(ModItems.OVERGROWTH_SMITHING_TEMPLATE, ModTrimPatterns.OVERGROWTH,
                        RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(JirniysPinkStuff.MOD_ID, "overgrowth")));
                offerSmithingTemplateCopyingRecipe(ModItems.OVERGROWTH_SMITHING_TEMPLATE, ModBlocks.MOSSY_COBBLED_STYXSTONE);
                offerSmithingTrimRecipe(ModItems.CORRUPTION_SMITHING_TEMPLATE, ModTrimPatterns.CORRUPTION,
                        RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(JirniysPinkStuff.MOD_ID, "corruption")));
                offerSmithingTemplateCopyingRecipe(ModItems.CORRUPTION_SMITHING_TEMPLATE, ModBlocks.BLACK_GOOP);
                offerSmithingTrimRecipe(ModItems.FORBIDDEN_SMITHING_TEMPLATE, ModTrimPatterns.FORBIDDEN,
                        RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(JirniysPinkStuff.MOD_ID, "forbidden")));
                offerSmithingTemplateCopyingRecipe(ModItems.FORBIDDEN_SMITHING_TEMPLATE, ModBlocks.COMPRESSED_STYXSTONE);
                offerSmithingTrimRecipe(ModItems.FAIRYTALE_SMITHING_TEMPLATE, ModTrimPatterns.FAIRYTALE,
                        RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(JirniysPinkStuff.MOD_ID, "fairytale")));
                offerSmithingTemplateCopyingRecipe(ModItems.FAIRYTALE_SMITHING_TEMPLATE, ModBlocks.POLISHED_AMETHYST_BLOCK);
            }
        };
    }

    @Override
    public String getName() {
        return "Recipes";
    }
}
