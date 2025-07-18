package net.jirniy.pinkstuff.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.item.ModItems;
import net.jirniy.pinkstuff.util.ModTags;
import net.minecraft.block.Blocks;
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
                .add(ModItems.ELYSIUM_HAMMER)
                .add(ModItems.ELYSIUM_MULTITOOL)
                .add(ModItems.NETHERITE_MULTITOOL);
        valueLookupBuilder(ItemTags.SHOVELS)
                .add(ModItems.KUNZITE_SHOVEL)
                .add(ModItems.ELYSIUM_SHOVEL)
                .add(ModItems.ELYSIUM_MULTITOOL)
                .add(ModItems.NETHERITE_MULTITOOL);
        valueLookupBuilder(ItemTags.AXES)
                .add(ModItems.KUNZITE_AXE)
                .add(ModItems.ELYSIUM_AXE)
                .add(ModItems.ELYSIUM_MULTITOOL)
                .add(ModItems.NETHERITE_MULTITOOL);
        valueLookupBuilder(ItemTags.HOES)
                .add(ModItems.KUNZITE_HOE)
                .add(ModItems.ELYSIUM_HOE)
                .add(ModItems.ELYSIUM_MULTITOOL)
                .add(ModItems.NETHERITE_MULTITOOL);
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
                .add(ModBlocks.STRIPPED_CRYSTAL_CHERRY_WOOD.asItem())
                .add(ModBlocks.CHORUS_LOG.asItem())
                .add(ModBlocks.CHORUS_WOOD.asItem())
                .add(ModBlocks.STRIPPED_CHORUS_LOG.asItem())
                .add(ModBlocks.STRIPPED_CHORUS_WOOD.asItem());
        valueLookupBuilder(ItemTags.PLANKS)
                .add(ModBlocks.CRYSTAL_CHERRY_PLANKS.asItem())
                .add(ModBlocks.CHORUS_PLANKS.asItem());
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
                .add(ModBlocks.CRYSTAL_CHERRY_SAPLING.asItem())
                .add(ModBlocks.CHORUS_SAPLING.asItem());
        valueLookupBuilder(ItemTags.TRIM_MATERIALS)
                .add(ModItems.KUNZITE)
                .add(ModItems.ELYSIUM_INGOT)
                .add(ModItems.THERMIUM)
                .add(ModItems.MEMORY_SHARD)
                .add(ModItems.SULFUR)
                .add(ModItems.PINLINE_INGOT)
                .add(ModItems.RAW_PINLINE);
        valueLookupBuilder(ItemTags.SLABS)
                .add(ModBlocks.AMETHYST_BRICKS_SLAB.asItem())
                .add(ModBlocks.ELYSIUM_BRICKS_SLAB.asItem())
                .add(ModBlocks.KUNZITE_BRICKS_SLAB.asItem())
                .add(ModBlocks.POLISHED_AMETHYST_SLAB.asItem())
                .add(ModBlocks.THERMIUM_BRICKS_SLAB.asItem())
                .add(ModBlocks.MEMORY_BRICKS_SLAB.asItem())
                .add(ModBlocks.PINLINE_BRICKS_SLAB.asItem())
                .add(ModBlocks.RAW_PINLINE_BRICKS_SLAB.asItem());
        valueLookupBuilder(ItemTags.STAIRS)
                .add(ModBlocks.AMETHYST_BRICKS_STAIRS.asItem())
                .add(ModBlocks.ELYSIUM_BRICKS_STAIRS.asItem())
                .add(ModBlocks.KUNZITE_BRICKS_STAIRS.asItem())
                .add(ModBlocks.POLISHED_AMETHYST_STAIRS.asItem())
                .add(ModBlocks.THERMIUM_BRICKS_STAIRS.asItem())
                .add(ModBlocks.MEMORY_BRICKS_STAIRS.asItem())
                .add(ModBlocks.PINLINE_BRICKS_STAIRS.asItem())
                .add(ModBlocks.RAW_PINLINE_BRICKS_STAIRS.asItem());
        valueLookupBuilder(ItemTags.WALLS)
                .add(ModBlocks.AMETHYST_BRICKS_WALL.asItem())
                .add(ModBlocks.ELYSIUM_BRICKS_WALL.asItem())
                .add(ModBlocks.KUNZITE_BRICKS_WALL.asItem())
                .add(ModBlocks.POLISHED_AMETHYST_WALL.asItem())
                .add(ModBlocks.THERMIUM_BRICKS_WALL.asItem())
                .add(ModBlocks.MEMORY_BRICKS_WALL.asItem())
                .add(ModBlocks.PINLINE_BRICKS_WALL.asItem())
                .add(ModBlocks.RAW_PINLINE_BRICKS_WALL.asItem());
        valueLookupBuilder(ItemTags.WOODEN_SLABS)
                .add(ModBlocks.CRYSTAL_CHERRY_SLAB.asItem())
                .add(ModBlocks.CHORUS_SLAB.asItem());
        valueLookupBuilder(ItemTags.WOODEN_STAIRS)
                .add(ModBlocks.CRYSTAL_CHERRY_STAIRS.asItem())
                .add(ModBlocks.CHORUS_STAIRS.asItem());
        valueLookupBuilder(ItemTags.WOODEN_FENCES)
                .add(ModBlocks.CRYSTAL_CHERRY_FENCE.asItem())
                .add(ModBlocks.CHORUS_FENCE.asItem());
        valueLookupBuilder(ItemTags.FENCE_GATES)
                .add(ModBlocks.CRYSTAL_CHERRY_FENCE_GATE.asItem())
                .add(ModBlocks.CHORUS_FENCE_GATE.asItem());
        valueLookupBuilder(ItemTags.WOODEN_DOORS)
                .add(ModBlocks.CRYSTAL_CHERRY_DOOR.asItem())
                .add(ModBlocks.CHORUS_DOOR.asItem());
        valueLookupBuilder(ItemTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.CRYSTAL_CHERRY_TRAPDOOR.asItem())
                .add(ModBlocks.CHORUS_TRAPDOOR.asItem());
        valueLookupBuilder(ItemTags.WOODEN_BUTTONS)
                .add(ModBlocks.CRYSTAL_CHERRY_BUTTON.asItem())
                .add(ModBlocks.CHORUS_BUTTON.asItem());
        valueLookupBuilder(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.CRYSTAL_CHERRY_PRESSURE_PLATE.asItem())
                .add(ModBlocks.CHORUS_PRESSURE_PLATE.asItem());
        valueLookupBuilder(ModTags.Items.CRYSTAL_CHERRY_LOGS)
                .add(ModBlocks.CRYSTAL_CHERRY_LOG.asItem())
                .add(ModBlocks.CRYSTAL_CHERRY_WOOD.asItem())
                .add(ModBlocks.STRIPPED_CRYSTAL_CHERRY_LOG.asItem())
                .add(ModBlocks.STRIPPED_CRYSTAL_CHERRY_WOOD.asItem());
        valueLookupBuilder(ModTags.Items.CHORUS_LOGS)
                .add(ModBlocks.CHORUS_LOG.asItem())
                .add(ModBlocks.CHORUS_WOOD.asItem())
                .add(ModBlocks.STRIPPED_CHORUS_LOG.asItem())
                .add(ModBlocks.STRIPPED_CHORUS_WOOD.asItem());
        valueLookupBuilder(ModTags.Items.BRICKS_CRAFTABLE)
                .add(Blocks.COBBLESTONE.asItem())
                .add(Blocks.COBBLED_DEEPSLATE.asItem())
                .add(Blocks.BLACKSTONE.asItem())
                .add(Blocks.END_STONE.asItem());
    }
}