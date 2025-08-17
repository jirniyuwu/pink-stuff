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

public record ThermiumBlasterRecipe(Ingredient inputItem, ItemStack output, int fuelCost) implements Recipe<ThermiumBlasterRecipeInput> {
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.inputItem);
        return list;
    }

    @Override
    public boolean matches(ThermiumBlasterRecipeInput input, World world) {
        if(world.isClient()) {
            return false;
        }

        return inputItem.test(input.getStackInSlot(0));
    }

    @Override
    public ItemStack craft(ThermiumBlasterRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public RecipeSerializer<? extends Recipe<ThermiumBlasterRecipeInput>> getSerializer() {
        return ModRecipes.THERMIUM_BLASTER_SERIALIZER;
    }

    @Override
    public RecipeType<? extends Recipe<ThermiumBlasterRecipeInput>> getType() {
        return ModRecipes.THERMIUM_BLASTER_TYPE;
    }

    @Override
    public IngredientPlacement getIngredientPlacement() {
        return IngredientPlacement.forSingleSlot(inputItem);
    }

    @Override
    public RecipeBookCategory getRecipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    public static class Serializer implements RecipeSerializer<ThermiumBlasterRecipe> {
        public static final MapCodec<ThermiumBlasterRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC.fieldOf("ingredient").forGetter(ThermiumBlasterRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(ThermiumBlasterRecipe::output),
                Codec.intRange(0, 65536).fieldOf("fuel_cost").forGetter(ThermiumBlasterRecipe::fuelCost)
        ).apply(inst, ThermiumBlasterRecipe::new));

        public static final PacketCodec<RegistryByteBuf, ThermiumBlasterRecipe> STREAM_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, ThermiumBlasterRecipe::inputItem,
                        ItemStack.PACKET_CODEC, ThermiumBlasterRecipe::output,
                        PacketCodecs.codec(Codec.intRange(0, 65536)), ThermiumBlasterRecipe::fuelCost,
                        ThermiumBlasterRecipe::new);

        @Override
        public MapCodec<ThermiumBlasterRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, ThermiumBlasterRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }
}
