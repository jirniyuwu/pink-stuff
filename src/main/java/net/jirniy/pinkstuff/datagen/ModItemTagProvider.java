package net.jirniy.pinkstuff.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.item.ModItems;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.KUNZITE_SWORD)
                .add(ModItems.ELYSIUM_SWORD)
                .add(ModItems.DAWNBLOOMER);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.KUNZITE_PICKAXE)
                .add(ModItems.ELYSIUM_PICKAXE)
                .add(ModItems.ELYSIUM_HAMMER);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.KUNZITE_SHOVEL)
                .add(ModItems.ELYSIUM_SHOVEL);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.KUNZITE_AXE)
                .add(ModItems.ELYSIUM_AXE);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.KUNZITE_HOE)
                .add(ModItems.ELYSIUM_HOE);
        getOrCreateTagBuilder(ItemTags.ARMOR_ENCHANTABLE)
                .add(ModItems.KUNZITE_HELMET)
                .add(ModItems.KUNZITE_CHESTPLATE)
                .add(ModItems.KUNZITE_LEGGINGS)
                .add(ModItems.KUNZITE_BOOTS)
                .add(ModItems.ELYSIUM_HELMET)
                .add(ModItems.ELYSIUM_CHESTPLATE)
                .add(ModItems.ELYSIUM_LEGGINGS)
                .add(ModItems.ELYSIUM_BOOTS);
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.KUNZITE_HELMET)
                .add(ModItems.KUNZITE_CHESTPLATE)
                .add(ModItems.KUNZITE_LEGGINGS)
                .add(ModItems.KUNZITE_BOOTS)
                .add(ModItems.ELYSIUM_HELMET)
                .add(ModItems.ELYSIUM_CHESTPLATE)
                .add(ModItems.ELYSIUM_LEGGINGS)
                .add(ModItems.ELYSIUM_BOOTS);
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.CRYSTAL_CHERRY_LOG.asItem())
                .add(ModBlocks.CRYSTAL_CHERRY_WOOD.asItem())
                .add(ModBlocks.STRIPPED_CRYSTAL_CHERRY_LOG.asItem())
                .add(ModBlocks.STRIPPED_CRYSTAL_CHERRY_WOOD.asItem());
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.CRYSTAL_CHERRY_PLANKS.asItem());
        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(ModItems.KUNZITE_HELMET)
                .add(ModItems.ELYSIUM_HELMET);
        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .add(ModItems.KUNZITE_CHESTPLATE)
                .add(ModItems.ELYSIUM_CHESTPLATE);
        getOrCreateTagBuilder(ItemTags.LEG_ARMOR_ENCHANTABLE)
                .add(ModItems.KUNZITE_LEGGINGS)
                .add(ModItems.ELYSIUM_LEGGINGS);
        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .add(ModItems.KUNZITE_BOOTS)
                .add(ModItems.ELYSIUM_BOOTS);
    }
}