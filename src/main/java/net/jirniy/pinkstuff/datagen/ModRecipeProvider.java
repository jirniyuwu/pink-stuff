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
                List<ItemConvertible> PINLINE_SMELTABLES = List.of(
                        ModItems.PREPARED_PINLINE);
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
                offerSmelting(PINLINE_SMELTABLES, RecipeCategory.MISC, ModItems.PINLINE_INGOT,
                        2f, 1280, "pinline_smelting");
                offerBlasting(PINLINE_SMELTABLES, RecipeCategory.MISC, ModItems.PINLINE_INGOT,
                        2f, 640, "pinline_blasting");
                offerSmelting(List.of(Items.MAGMA_CREAM), RecipeCategory.MISC, Items.FIRE_CHARGE,
                        0.1f, 160, "fire_charge_smelting");
                offerBlasting(List.of(Items.MAGMA_CREAM), RecipeCategory.MISC, Items.FIRE_CHARGE,
                        0.1f, 80, "fire_charge_blasting");
                offerSmelting(List.of(Items.FIRE_CHARGE), RecipeCategory.MISC, Items.CHARCOAL,
                        0f, 1280, "fire_to_charcoal_smelting");
                offerBlasting(List.of(Items.FIRE_CHARGE), RecipeCategory.MISC, Items.CHARCOAL,
                        0f, 640, "fire_to_charcoal_blasting");
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS,
                        ModItems.KUNZITE, RecipeCategory.DECORATIONS, ModBlocks.KUNZITE_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS,
                        ModItems.RAW_KUNZITE, RecipeCategory.DECORATIONS, ModBlocks.RAW_KUNZITE_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS,
                        ModItems.THERMIUM, RecipeCategory.DECORATIONS, ModBlocks.THERMIUM_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS,
                        ModItems.RAW_THERMIUM, RecipeCategory.DECORATIONS, ModBlocks.RAW_THERMIUM_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS,
                        ModItems.ELYSIUM_INGOT, RecipeCategory.DECORATIONS, ModBlocks.ELYSIUM_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS,
                        ModItems.ENERGIZED_THERMIUM, RecipeCategory.DECORATIONS, ModBlocks.ENERGIZED_THERMIUM_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS,
                        ModItems.SULFUR, RecipeCategory.DECORATIONS, ModBlocks.SULFUR_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS,
                        ModItems.PINLINE_INGOT, RecipeCategory.DECORATIONS, ModBlocks.PINLINE_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS,
                        ModItems.RAW_PINLINE, RecipeCategory.DECORATIONS, ModBlocks.RAW_PINLINE_BLOCK);
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

                createShapeless(RecipeCategory.FOOD, ModItems.COAL_MEAL, 2)
                        .criterion(hasItem(Items.COAL), conditionsFromItem(Items.COAL))
                        .input(Items.COAL).input(Items.COAL).input(Items.COAL)
                        .input(ModItems.THERMIUM_NUGGET).input(Items.WHEAT).input(ModItems.THERMIUM_NUGGET)
                        .input(Items.COAL).input(Items.COAL).input(Items.COAL)
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
            }
        };
    }

    @Override
    public String getName() {
        return "Recipes";
    }
}
