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
            }
        };
    }

    @Override
    public String getName() {
        return "Recipes";
    }
}
