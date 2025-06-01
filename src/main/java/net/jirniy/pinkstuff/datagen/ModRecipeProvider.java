package net.jirniy.pinkstuff.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
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

                createShaped(RecipeCategory.TOOLS, ModItems.DAWNBLOOMER)
                        .pattern("TMT")
                        .pattern("CSC")
                        .pattern(" N ")
                        .input('N', Items.NETHERITE_INGOT)
                        .input('T', ModItems.THERMIUM)
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

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRYSTAL_CHERRY_PLANKS, 4)
                        .input(ModBlocks.CRYSTAL_CHERRY_LOG).criterion(hasItem(ModBlocks.CRYSTAL_CHERRY_LOG),
                                conditionsFromItem(ModBlocks.CRYSTAL_CHERRY_LOG)).offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "crystal_cherry_planks_from_crystal_cherry_log")));
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRYSTAL_CHERRY_PLANKS, 4)
                        .input(ModBlocks.CRYSTAL_CHERRY_WOOD).criterion(hasItem(ModBlocks.CRYSTAL_CHERRY_WOOD),
                                conditionsFromItem(ModBlocks.CRYSTAL_CHERRY_LOG)).offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "crystal_cherry_planks_from_crystal_cherry_wood")));
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRYSTAL_CHERRY_PLANKS, 4)
                        .input(ModBlocks.STRIPPED_CRYSTAL_CHERRY_LOG).criterion(hasItem(ModBlocks.STRIPPED_CRYSTAL_CHERRY_LOG),
                                conditionsFromItem(ModBlocks.CRYSTAL_CHERRY_LOG)).offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "crystal_cherry_planks_from_stripped_crystal_cherry_log")));
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRYSTAL_CHERRY_PLANKS, 4)
                        .input(ModBlocks.STRIPPED_CRYSTAL_CHERRY_WOOD).criterion(hasItem(ModBlocks.STRIPPED_CRYSTAL_CHERRY_WOOD),
                                conditionsFromItem(ModBlocks.CRYSTAL_CHERRY_LOG)).offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "crystal_cherry_planks_from_stripped_crystal_cherry_wood")));
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
                createShapeless(RecipeCategory.FOOD, ModItems.GELATINOUS_BUD, 2)
                        .input(ModItems.KUNZITE).input(ModItems.KUNZITE)
                        .input(Items.BONE_MEAL).input(Items.BONE_MEAL)
                        .criterion(hasItem(ModItems.KUNZITE), conditionsFromItem(ModItems.KUNZITE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "gelatinous_bud")));
            }
        };
    }

    @Override
    public String getName() {
        return "Recipes";
    }
}
