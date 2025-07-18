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
                        entries.add(ModItems.CRAWLER_SPAWN_EGG);
                        entries.add(ModItems.QUARTZ_NUGGET);
                        entries.add(ModItems.DIAMOND_NUGGET);
                        entries.add(ModItems.EMERALD_NUGGET);

                        entries.add(ModItems.AMETHYST_NUGGET);
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

                        entries.add(ModItems.SULFUR);
                        entries.add(ModBlocks.NETHER_SULFUR_ORE);
                        entries.add(ModBlocks.SULFUR_BLOCK);

                        entries.add(ModItems.RAW_KUNZITE);
                        entries.add(ModItems.KUNZITE_NUGGET);
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
                        entries.add(ModItems.ELYSIUM_NUGGET);
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
                        entries.add(ModItems.THERMIUM_NUGGET);
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

                        entries.add(ModItems.RAW_PINLINE);
                        entries.add(ModItems.PREPARED_PINLINE);
                        entries.add(ModItems.PINLINE_NUGGET);
                        entries.add(ModItems.PINLINE_INGOT);

                        entries.add(ModBlocks.END_PINLINE_ORE);
                        entries.add(ModBlocks.RAW_PINLINE_BLOCK);
                        entries.add(ModBlocks.PINLINE_BLOCK);

                        entries.add(ModBlocks.PINLINE_BRICKS);
                        entries.add(ModBlocks.CHISELED_PINLINE_BRICKS);
                        entries.add(ModBlocks.PINLINE_BULB);
                        entries.add(ModBlocks.PINLINE_BRICKS_SLAB);
                        entries.add(ModBlocks.PINLINE_BRICKS_STAIRS);
                        entries.add(ModBlocks.PINLINE_BRICKS_WALL);

                        entries.add(ModBlocks.RAW_PINLINE_BRICKS);
                        entries.add(ModBlocks.CHISELED_RAW_PINLINE_BRICKS);
                        entries.add(ModBlocks.RAW_PINLINE_BULB);
                        entries.add(ModBlocks.RAW_PINLINE_BRICKS_SLAB);
                        entries.add(ModBlocks.RAW_PINLINE_BRICKS_STAIRS);
                        entries.add(ModBlocks.RAW_PINLINE_BRICKS_WALL);

                        entries.add(ModItems.MEMORY_SHARD);
                        entries.add(ModBlocks.MEMORY_BRICKS);
                        entries.add(ModBlocks.CHISELED_MEMORY_BRICKS);
                        entries.add(ModBlocks.MEMORY_BULB);
                        entries.add(ModBlocks.MEMORY_BRICKS_SLAB);
                        entries.add(ModBlocks.MEMORY_BRICKS_STAIRS);
                        entries.add(ModBlocks.MEMORY_BRICKS_WALL);

                        entries.add(ModBlocks.AMETHYST_PARTERS);
                        entries.add(ModBlocks.KUNZITE_LOVELILY);
                        entries.add(ModBlocks.ELYSIAN_SKYBERRY);
                        entries.add(ModBlocks.THERMIUM_WILTBORN);
                        entries.add(ModBlocks.MEMORIA_BOURPEER);

                        entries.add(ModBlocks.SMALL_END_GRASS);
                        entries.add(ModBlocks.MEDIUM_END_GRASS);
                        entries.add(ModBlocks.LARGE_END_GRASS);
                        entries.add(ModBlocks.CHORUS_LILY);

                        entries.add(ModBlocks.PINK_ICE);
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

                        entries.add(ModBlocks.CHORUS_LOG);
                        entries.add(ModBlocks.CHORUS_WOOD);
                        entries.add(ModBlocks.STRIPPED_CHORUS_LOG);
                        entries.add(ModBlocks.STRIPPED_CHORUS_WOOD);
                        entries.add(ModBlocks.CHORUS_PLANKS);
                        entries.add(ModBlocks.CHORUS_LEAVES);
                        entries.add(ModBlocks.CHORUS_SAPLING);

                        entries.add(ModBlocks.CHORUS_SLAB);
                        entries.add(ModBlocks.CHORUS_STAIRS);
                        entries.add(ModBlocks.CHORUS_FENCE);
                        entries.add(ModBlocks.CHORUS_FENCE_GATE);
                        entries.add(ModBlocks.CHORUS_DOOR);
                        entries.add(ModBlocks.CHORUS_TRAPDOOR);
                        entries.add(ModBlocks.CHORUS_PRESSURE_PLATE);
                        entries.add(ModBlocks.CHORUS_BUTTON);

                        entries.add(ModItems.COAL_MEAL);
                        entries.add(ModItems.GELATINOUS_BUD);
                        entries.add(ModItems.ELYSIUM_APPLE);
                        entries.add(ModItems.GODFRUIT);
                        entries.add(ModItems.CRYSTAL_CARROT);
                        entries.add(ModItems.GEM_BERRY);
                        entries.add(ModItems.HAZEWEAVER);

                        entries.add(ModItems.BLOOM_SMITHING_TEMPLATE);
                        entries.add(ModItems.CHERRY_SMITHING_TEMPLATE);
                        entries.add(ModItems.SWORDMASTER_SMITHING_TEMPLATE);
                        entries.add(ModItems.SHATTER_SMITHING_TEMPLATE);
                        entries.add(ModItems.CREEPER_SMITHING_TEMPLATE);
                        entries.add(ModItems.CHESS_SMITHING_TEMPLATE);
                        entries.add(ModItems.WANDERER_SMITHING_TEMPLATE);

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
                        entries.add(ModItems.ELYSIUM_MULTITOOL);
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
