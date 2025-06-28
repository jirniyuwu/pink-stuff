package net.jirniy.pinkstuff.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup KUNZITE_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(JirniysPinkStuff.MOD_ID, "kunzite_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.KUNZITE))
                    .displayName(Text.translatable("itemgroup.pinkstuff.kunzite_items"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModItems.RAW_KUNZITE);
                        entries.add(ModItems.KUNZITE);
                        entries.add(ModItems.PINK_BITS);

                        entries.add(ModBlocks.KUNZITE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_KUNZITE_ORE);
                        entries.add(ModBlocks.AMETHYST_KUNZITE_ORE);
                        entries.add(ModBlocks.RAW_KUNZITE_BLOCK);
                        entries.add(ModBlocks.KUNZITE_BLOCK);

                        entries.add(ModBlocks.KUNZITE_BRICKS);
                        entries.add(ModBlocks.CHISELED_KUNZITE_BRICKS);
                        entries.add(ModBlocks.KUNZITE_BULB);
                        entries.add(ModBlocks.KUNZITE_BRICKS_SLAB);
                        entries.add(ModBlocks.KUNZITE_BRICKS_STAIRS);
                        entries.add(ModBlocks.KUNZITE_BRICKS_WALL);

                        entries.add(ModItems.CRYSTAL_GLITTER);
                        entries.add(ModItems.ELYSIUM_INGOT);
                        entries.add(ModItems.ELYSIAN_REDSTONE_CORE);
                        entries.add(ModBlocks.ELYSIUM_BLOCK);

                        entries.add(ModBlocks.ELYSIUM_BRICKS);
                        entries.add(ModBlocks.CHISELED_ELYSIUM_BRICKS);
                        entries.add(ModBlocks.ELYSIUM_BULB);
                        entries.add(ModBlocks.ELYSIUM_BRICKS_SLAB);
                        entries.add(ModBlocks.ELYSIUM_BRICKS_STAIRS);
                        entries.add(ModBlocks.ELYSIUM_BRICKS_WALL);

                        entries.add(ModItems.RAW_THERMIUM);
                        entries.add(ModItems.THERMIUM);
                        entries.add(ModItems.ENERGIZED_THERMIUM);
                        entries.add(ModBlocks.THERMIUM_ORE);
                        entries.add(ModBlocks.DEEPSLATE_THERMIUM_ORE);
                        entries.add(ModBlocks.RAW_THERMIUM_BLOCK);
                        entries.add(ModBlocks.THERMIUM_BLOCK);
                        entries.add(ModBlocks.ENERGIZED_THERMIUM_BLOCK);

                        entries.add(ModBlocks.THERMIUM_BRICKS);
                        entries.add(ModBlocks.CHISELED_THERMIUM_BRICKS);
                        entries.add(ModBlocks.THERMIUM_BULB);
                        entries.add(ModBlocks.THERMIUM_BRICKS_SLAB);
                        entries.add(ModBlocks.THERMIUM_BRICKS_STAIRS);
                        entries.add(ModBlocks.THERMIUM_BRICKS_WALL);
                        entries.add(ModBlocks.DISPLAY);
                        entries.add(ModBlocks.THERMIUM_BLASTER);

                        entries.add(ModItems.MEMORY_SHARD);

                        entries.add(ModBlocks.CRYSTAL_CHERRY_LOG);
                        entries.add(ModBlocks.CRYSTAL_CHERRY_WOOD);
                        entries.add(ModBlocks.STRIPPED_CRYSTAL_CHERRY_LOG);
                        entries.add(ModBlocks.STRIPPED_CRYSTAL_CHERRY_WOOD);
                        entries.add(ModBlocks.CRYSTAL_CHERRY_PLANKS);
                        entries.add(ModBlocks.CRYSTAL_CHERRY_LEAVES);
                        entries.add(ModBlocks.CRYSTAL_CHERRY_SAPLING);

                        entries.add(ModBlocks.CRYSTAL_CHERRY_SLAB);
                        entries.add(ModBlocks.CRYSTAL_CHERRY_STAIRS);
                        entries.add(ModBlocks.CRYSTAL_CHERRY_FENCE);
                        entries.add(ModBlocks.CRYSTAL_CHERRY_FENCE_GATE);
                        entries.add(ModBlocks.CRYSTAL_CHERRY_DOOR);
                        entries.add(ModBlocks.CRYSTAL_CHERRY_TRAPDOOR);
                        entries.add(ModBlocks.CRYSTAL_CHERRY_PRESSURE_PLATE);
                        entries.add(ModBlocks.CRYSTAL_CHERRY_BUTTON);

                        entries.add(ModBlocks.POLISHED_AMETHYST_BLOCK);
                        entries.add(ModBlocks.POLISHED_AMETHYST_SLAB);
                        entries.add(ModBlocks.POLISHED_AMETHYST_STAIRS);
                        entries.add(ModBlocks.POLISHED_AMETHYST_WALL);

                        entries.add(ModBlocks.AMETHYST_BRICKS);
                        entries.add(ModBlocks.CHISELED_AMETHYST_BRICKS);
                        entries.add(ModBlocks.AMETHYST_BULB);
                        entries.add(ModBlocks.AMETHYST_BRICKS_SLAB);
                        entries.add(ModBlocks.AMETHYST_BRICKS_STAIRS);
                        entries.add(ModBlocks.AMETHYST_BRICKS_WALL);

                        entries.add(ModItems.GELATINOUS_BUD);
                        entries.add(ModItems.ELYSIUM_APPLE);
                        entries.add(ModItems.CRYSTAL_CARROT);
                        entries.add(ModItems.GEM_BERRY);

                        entries.add(ModItems.KUNZITE_SWORD);
                        entries.add(ModItems.KUNZITE_PICKAXE);
                        entries.add(ModItems.KUNZITE_AXE);
                        entries.add(ModItems.KUNZITE_SHOVEL);
                        entries.add(ModItems.KUNZITE_HOE);
                        entries.add(ModItems.KUNZITE_HELMET);
                        entries.add(ModItems.KUNZITE_CHESTPLATE);
                        entries.add(ModItems.KUNZITE_LEGGINGS);
                        entries.add(ModItems.KUNZITE_BOOTS);

                        entries.add(ModItems.ELYSIUM_SWORD);
                        entries.add(ModItems.ELYSIUM_PICKAXE);
                        entries.add(ModItems.ELYSIUM_AXE);
                        entries.add(ModItems.ELYSIUM_SHOVEL);
                        entries.add(ModItems.ELYSIUM_HOE);
                        entries.add(ModItems.ELYSIUM_HAMMER);
                        entries.add(ModItems.ELYSIUM_HELMET);
                        entries.add(ModItems.ELYSIUM_CHESTPLATE);
                        entries.add(ModItems.ELYSIUM_LEGGINGS);
                        entries.add(ModItems.ELYSIUM_BOOTS);

                        entries.add(ModItems.DAWNBLOOMER);
                    })
                    .build());

    public static void registerItemGroups() {
        JirniysPinkStuff.LOGGER.info("Registering Item Groups for " + JirniysPinkStuff.MOD_ID);
    }
}
