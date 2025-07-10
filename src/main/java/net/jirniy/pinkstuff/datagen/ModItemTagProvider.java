package net.jirniy.pinkstuff.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.item.ModItems;
import net.jirniy.pinkstuff.util.ModTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        valueLookupBuilder(ModTags.Items.KUNZITE_REPAIR)
                .add(ModItems.KUNZITE);
        valueLookupBuilder(ModTags.Items.ELYSIUM_REPAIR)
                .add(ModItems.ELYSIUM_INGOT);
        valueLookupBuilder(ModTags.Items.SPECIAL_REPAIR)
                .add(ModItems.ELYSIUM_INGOT);

        valueLookupBuilder(ItemTags.SWORDS)
                .add(ModItems.KUNZITE_SWORD)
                .add(ModItems.ELYSIUM_SWORD)
                .add(ModItems.DAWNBLOOMER);
        valueLookupBuilder(ItemTags.PICKAXES)
                .add(ModItems.KUNZITE_PICKAXE)
                .add(ModItems.ELYSIUM_PICKAXE)
                .add(ModItems.ELYSIUM_HAMMER);
        valueLookupBuilder(ItemTags.SHOVELS)
                .add(ModItems.KUNZITE_SHOVEL)
                .add(ModItems.ELYSIUM_SHOVEL);
        valueLookupBuilder(ItemTags.AXES)
                .add(ModItems.KUNZITE_AXE)
                .add(ModItems.ELYSIUM_AXE);
        valueLookupBuilder(ItemTags.HOES)
                .add(ModItems.KUNZITE_HOE)
                .add(ModItems.ELYSIUM_HOE);
        valueLookupBuilder(ItemTags.ARMOR_ENCHANTABLE)
                .add(ModItems.KUNZITE_HELMET)
                .add(ModItems.KUNZITE_CHESTPLATE)
                .add(ModItems.KUNZITE_LEGGINGS)
                .add(ModItems.KUNZITE_BOOTS)
                .add(ModItems.ELYSIUM_HELMET)
                .add(ModItems.ELYSIUM_CHESTPLATE)
                .add(ModItems.ELYSIUM_LEGGINGS)
                .add(ModItems.ELYSIUM_BOOTS);
        valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.KUNZITE_HELMET)
                .add(ModItems.KUNZITE_CHESTPLATE)
                .add(ModItems.KUNZITE_LEGGINGS)
                .add(ModItems.KUNZITE_BOOTS)
                .add(ModItems.ELYSIUM_HELMET)
                .add(ModItems.ELYSIUM_CHESTPLATE)
                .add(ModItems.ELYSIUM_LEGGINGS)
                .add(ModItems.ELYSIUM_BOOTS);
        valueLookupBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.CRYSTAL_CHERRY_LOG.asItem())
                .add(ModBlocks.CRYSTAL_CHERRY_WOOD.asItem())
                .add(ModBlocks.STRIPPED_CRYSTAL_CHERRY_LOG.asItem())
                .add(ModBlocks.STRIPPED_CRYSTAL_CHERRY_WOOD.asItem());
        valueLookupBuilder(ItemTags.PLANKS)
                .add(ModBlocks.CRYSTAL_CHERRY_PLANKS.asItem());
        valueLookupBuilder(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(ModItems.KUNZITE_HELMET)
                .add(ModItems.ELYSIUM_HELMET);
        valueLookupBuilder(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .add(ModItems.KUNZITE_CHESTPLATE)
                .add(ModItems.ELYSIUM_CHESTPLATE);
        valueLookupBuilder(ItemTags.LEG_ARMOR_ENCHANTABLE)
                .add(ModItems.KUNZITE_LEGGINGS)
                .add(ModItems.ELYSIUM_LEGGINGS);
        valueLookupBuilder(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .add(ModItems.KUNZITE_BOOTS)
                .add(ModItems.ELYSIUM_BOOTS);
        valueLookupBuilder(ItemTags.FLOWERS)
                .add(ModBlocks.AMETHYST_PARTERS.asItem())
                .add(ModBlocks.KUNZITE_LOVELILY.asItem())
                .add(ModBlocks.ELYSIAN_SKYBERRY.asItem())
                .add(ModBlocks.MEMORIA_BOURPEER.asItem())
                .add(ModBlocks.THERMIUM_WILTBORN.asItem())
                .add(ModItems.HAZEWEAVER);
        valueLookupBuilder(ItemTags.SAPLINGS)
                .add(ModBlocks.CRYSTAL_CHERRY_SAPLING.asItem());
    }
}