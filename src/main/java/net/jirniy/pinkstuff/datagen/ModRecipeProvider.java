package net.jirniy.pinkstuff.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.item.ModItems;
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
                        ModBlocks.DEEPSLATE_KUNZITE_ORE);
                List<ItemConvertible> ELYSIUM_SMELTABLES = List.of(
                        ModItems.CRYSTAL_GLITTER);
                offerSmelting(KUNZITE_SMELTABLES, RecipeCategory.MISC, ModItems.KUNZITE,
                        0.25f, 80, "kunzite");
                offerBlasting(KUNZITE_SMELTABLES, RecipeCategory.MISC, ModItems.KUNZITE,
                        0.25f, 40, "kunzite");
                offerSmelting(ELYSIUM_SMELTABLES, RecipeCategory.MISC, ModItems.ELYSIUM_INGOT,
                        1f, 160, "elysium");
                offerBlasting(ELYSIUM_SMELTABLES, RecipeCategory.MISC, ModItems.ELYSIUM_INGOT,
                        1f, 80, "elysium");
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS,
                        ModItems.KUNZITE, RecipeCategory.DECORATIONS, ModBlocks.KUNZITE_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS,
                        ModItems.RAW_KUNZITE, RecipeCategory.DECORATIONS, ModBlocks.RAW_KUNZITE_BLOCK);
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
                        .pattern("K")
                        .pattern("K")
                        .pattern("S")
                        .input('S', Items.STICK)
                        .input('K', ModItems.KUNZITE)
                        .criterion(hasItem(ModItems.KUNZITE), conditionsFromItem(ModItems.KUNZITE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "kunzite_sword")));
                createShaped(RecipeCategory.TOOLS, ModItems.KUNZITE_PICKAXE)
                        .pattern("KKK")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('S', Items.STICK)
                        .input('K', ModItems.KUNZITE)
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
                        .pattern("KK")
                        .pattern("KS")
                        .pattern(" S")
                        .input('S', Items.STICK)
                        .input('K', ModItems.KUNZITE)
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
                        .pattern("S")
                        .input('S', Items.STICK)
                        .input('E', ModItems.ELYSIUM_INGOT)
                        .input('C', ModItems.ELYSIAN_REDSTONE_CORE)
                        .criterion(hasItem(ModItems.ELYSIUM_INGOT), conditionsFromItem(ModItems.ELYSIUM_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "elysium_sword")));
                createShaped(RecipeCategory.TOOLS, ModItems.ELYSIUM_PICKAXE)
                        .pattern("ECE")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('S', Items.STICK)
                        .input('E', ModItems.ELYSIUM_INGOT)
                        .input('C', ModItems.ELYSIAN_REDSTONE_CORE)
                        .criterion(hasItem(ModItems.ELYSIUM_INGOT), conditionsFromItem(ModItems.ELYSIUM_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "elysium_pickaxe")));
                createShaped(RecipeCategory.TOOLS, ModItems.ELYSIUM_AXE)
                        .pattern("EC")
                        .pattern("ES")
                        .pattern(" S")
                        .input('S', Items.STICK)
                        .input('E', ModItems.ELYSIUM_INGOT)
                        .input('C', ModItems.ELYSIAN_REDSTONE_CORE)
                        .criterion(hasItem(ModItems.ELYSIUM_INGOT), conditionsFromItem(ModItems.ELYSIUM_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "elysium_axe")));
                createShaped(RecipeCategory.TOOLS, ModItems.ELYSIUM_SHOVEL)
                        .pattern("E")
                        .pattern("S")
                        .pattern("S")
                        .input('S', Items.STICK)
                        .input('E', ModItems.ELYSIUM_INGOT)
                        .criterion(hasItem(ModItems.ELYSIUM_INGOT), conditionsFromItem(ModItems.ELYSIUM_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "elysium_shovel")));
                createShaped(RecipeCategory.TOOLS, ModItems.ELYSIUM_HOE)
                        .pattern("EE")
                        .pattern(" S")
                        .pattern(" S")
                        .input('S', Items.STICK)
                        .input('E', ModItems.ELYSIUM_INGOT)
                        .criterion(hasItem(ModItems.ELYSIUM_INGOT), conditionsFromItem(ModItems.ELYSIUM_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(JirniysPinkStuff.MOD_ID, "elysium_hoe")));
            }
        };
    }

    @Override
    public String getName() {
        return "Recipes";
    }
}
