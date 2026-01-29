package net.jirniy.pinkstuff.recipe;

import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static final RecipeSerializer<ThermiumBlasterRecipe> THERMIUM_BLASTER_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, Identifier.of(JirniysPinkStuff.MOD_ID, "thermium_blaster"),
            new ThermiumBlasterRecipe.Serializer());
    public static final RecipeType<ThermiumBlasterRecipe> THERMIUM_BLASTER_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(JirniysPinkStuff.MOD_ID, "thermium_blaster"), new RecipeType<ThermiumBlasterRecipe>() {
                @Override
                public String toString() {
                    return "thermium_blaster";
                }
            });

    public static final RecipeSerializer<GrowingChamberRecipe> GROWING_CHAMBER_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, Identifier.of(JirniysPinkStuff.MOD_ID, "growing_chamber"),
            new GrowingChamberRecipe.Serializer());
    public static final RecipeType<GrowingChamberRecipe> GROWING_CHAMBER_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(JirniysPinkStuff.MOD_ID, "growing_chamber"), new RecipeType<GrowingChamberRecipe>() {
                @Override
                public String toString() {
                    return "growing_chamber";
                }
            });

    public static void registerRecipes() {
        JirniysPinkStuff.LOGGER.info("Registering Custom Recipes for " + JirniysPinkStuff.MOD_ID);
    }
}
