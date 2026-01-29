package net.jirniy.pinkstuff.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeBookCategories;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public record GrowingChamberRecipe(Ingredient inputItem, ItemStack output, float boneMealConsumptionChance, int time) implements Recipe<GrowingChamberRecipeInput> {
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.inputItem);
        return list;
    }

    @Override
    public boolean matches(GrowingChamberRecipeInput input, World world) {
        if(world.isClient()) {
            return false;
        }

        return inputItem.test(input.getStackInSlot(0));
    }

    @Override
    public ItemStack craft(GrowingChamberRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public RecipeSerializer<? extends Recipe<GrowingChamberRecipeInput>> getSerializer() {
        return ModRecipes.GROWING_CHAMBER_SERIALIZER;
    }

    @Override
    public RecipeType<? extends Recipe<GrowingChamberRecipeInput>> getType() {
        return ModRecipes.GROWING_CHAMBER_TYPE;
    }

    @Override
    public IngredientPlacement getIngredientPlacement() {
        return IngredientPlacement.forSingleSlot(inputItem);
    }

    @Override
    public RecipeBookCategory getRecipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    public static class Serializer implements RecipeSerializer<GrowingChamberRecipe> {
        public static final MapCodec<GrowingChamberRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC.fieldOf("ingredient").forGetter(GrowingChamberRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(GrowingChamberRecipe::output),
                Codec.floatRange(0, 1).fieldOf("bone_meal_consumption_chance").forGetter(GrowingChamberRecipe::boneMealConsumptionChance),
                Codec.intRange(1, 65536).fieldOf("cooking_time").forGetter(GrowingChamberRecipe::time)
        ).apply(inst, GrowingChamberRecipe::new));

        public static final PacketCodec<RegistryByteBuf, GrowingChamberRecipe> STREAM_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, GrowingChamberRecipe::inputItem,
                        ItemStack.PACKET_CODEC, GrowingChamberRecipe::output,
                        PacketCodecs.codec(Codec.floatRange(0, 1)), GrowingChamberRecipe::boneMealConsumptionChance,
                        PacketCodecs.codec(Codec.intRange(1, 65536)), GrowingChamberRecipe::time,
                        GrowingChamberRecipe::new);

        @Override
        public MapCodec<GrowingChamberRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, GrowingChamberRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }
}
