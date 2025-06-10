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

    public static void registerRecipes() {
        JirniysPinkStuff.LOGGER.info("Registering Custom Recipes for " + JirniysPinkStuff.MOD_ID);
    }
}
