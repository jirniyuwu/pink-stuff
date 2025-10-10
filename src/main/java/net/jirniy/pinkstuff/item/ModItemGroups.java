package net.jirniy.pinkstuff.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
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
                        entries.add(ModItems.EXOFAIRY_SPAWN_EGG);
                        entries.add(ModItems.CORRUPTED_ZOMBIE_SPAWN_EGG);
                        entries.add(ModItems.CORRUPTED_SKELETON_SPAWN_EGG);
                        entries.add(ModItems.AMETHYST_BLAZE_SPAWN_EGG);
                        entries.add(ModItems.CORRUPTION_BLAZE_SPAWN_EGG);

                        entries.add(ModBlocks.CRAWLER_STONE);
                        entries.add(ModBlocks.CRAWLER_DEEPSLATE);
                        entries.add(ModBlocks.CRAWLER_NETHERRACK);
                        entries.add(ModBlocks.CRAWLER_STYXSTONE);
                        entries.add(ModBlocks.CRAWLER_COMPRESSED_STYXSTONE);

                        entries.add(ModItems.QUARTZ_NUGGET);
                        entries.add(ModBlocks.QUARTZ_CLUMP);
                        entries.add(ModItems.DIAMOND_NUGGET);
                        entries.add(ModBlocks.DIAMOND_CLUMP);
                        entries.add(ModItems.EMERALD_NUGGET);
                        entries.add(ModBlocks.EMERALD_CLUMP);
                        entries.add(ModItems.NETHERITE_NUGGET);

                        entries.add(ModItems.AMETHYST_BLAZE_ROD);

                        entries.add(ModBlocks.STYXIAN_SOIL);
                        entries.add(ModBlocks.ROOTED_STYXIAN_SOIL);
                        entries.add(ModBlocks.STYXMOSS);
                        entries.add(ModBlocks.STYXMOSS_CARPET);
                        entries.add(ModBlocks.COBBLED_STYXSTONE);
                        entries.add(ModBlocks.COBBLED_STYXSTONE_SLAB);
                        entries.add(ModBlocks.COBBLED_STYXSTONE_STAIRS);
                        entries.add(ModBlocks.COBBLED_STYXSTONE_WALL);
                        entries.add(ModBlocks.MOSSY_COBBLED_STYXSTONE);
                        entries.add(ModBlocks.MOSSY_COBBLED_STYXSTONE_SLAB);
                        entries.add(ModBlocks.MOSSY_COBBLED_STYXSTONE_STAIRS);
                        entries.add(ModBlocks.MOSSY_COBBLED_STYXSTONE_WALL);

                        entries.add(ModBlocks.STYXSTONE);
                        entries.add(ModBlocks.POLISHED_STYXSTONE);
                        entries.add(ModBlocks.POLISHED_STYXSTONE_SLAB);
                        entries.add(ModBlocks.POLISHED_STYXSTONE_STAIRS);
                        entries.add(ModBlocks.POLISHED_STYXSTONE_WALL);
                        entries.add(ModBlocks.STYXSTONE_BRICKS);
                        entries.add(ModBlocks.STYXSTONE_BRICKS_SLAB);
                        entries.add(ModBlocks.STYXSTONE_BRICKS_STAIRS);
                        entries.add(ModBlocks.STYXSTONE_BRICKS_WALL);

                        entries.add(ModBlocks.COMPRESSED_STYXSTONE);
                        entries.add(ModBlocks.POLISHED_COMPRESSED_STYXSTONE);
                        entries.add(ModBlocks.POLISHED_COMPRESSED_STYXSTONE_SLAB);
                        entries.add(ModBlocks.POLISHED_COMPRESSED_STYXSTONE_STAIRS);
                        entries.add(ModBlocks.POLISHED_COMPRESSED_STYXSTONE_WALL);
                        entries.add(ModBlocks.COMPRESSED_STYXSTONE_BRICKS);
                        entries.add(ModBlocks.COMPRESSED_STYXSTONE_BRICKS_SLAB);
                        entries.add(ModBlocks.COMPRESSED_STYXSTONE_BRICKS_STAIRS);
                        entries.add(ModBlocks.COMPRESSED_STYXSTONE_BRICKS_WALL);

                        entries.add(ModBlocks.MABRIZE);
                        entries.add(ModBlocks.POLISHED_MABRIZE);
                        entries.add(ModBlocks.POLISHED_MABRIZE_SLAB);
                        entries.add(ModBlocks.POLISHED_MABRIZE_STAIRS);
                        entries.add(ModBlocks.POLISHED_MABRIZE_WALL);
                        entries.add(ModBlocks.MABRIZE_BRICKS);
                        entries.add(ModBlocks.MABRIZE_BRICKS_SLAB);
                        entries.add(ModBlocks.MABRIZE_BRICKS_STAIRS);
                        entries.add(ModBlocks.MABRIZE_BRICKS_WALL);

                        entries.add(ModBlocks.AMETANE);
                        entries.add(ModBlocks.POLISHED_AMETANE);
                        entries.add(ModBlocks.POLISHED_AMETANE_SLAB);
                        entries.add(ModBlocks.POLISHED_AMETANE_STAIRS);
                        entries.add(ModBlocks.POLISHED_AMETANE_WALL);
                        entries.add(ModBlocks.AMETANE_BRICKS);
                        entries.add(ModBlocks.AMETANE_BRICKS_SLAB);
                        entries.add(ModBlocks.AMETANE_BRICKS_STAIRS);
                        entries.add(ModBlocks.AMETANE_BRICKS_WALL);

                        entries.add(ModBlocks.WASTEROCK);
                        entries.add(ModBlocks.POLISHED_WASTEROCK);
                        entries.add(ModBlocks.POLISHED_WASTEROCK_SLAB);
                        entries.add(ModBlocks.POLISHED_WASTEROCK_STAIRS);
                        entries.add(ModBlocks.POLISHED_WASTEROCK_WALL);
                        entries.add(ModBlocks.WASTEROCK_BRICKS);
                        entries.add(ModBlocks.WASTEROCK_BRICKS_SLAB);
                        entries.add(ModBlocks.WASTEROCK_BRICKS_STAIRS);
                        entries.add(ModBlocks.WASTEROCK_BRICKS_WALL);

                        entries.add(ModBlocks.BLACK_GOOP);
                        entries.add(ModBlocks.CORESTONE);
                        entries.add(ModBlocks.POLISHED_CORESTONE);
                        entries.add(ModBlocks.POLISHED_CORESTONE_SLAB);
                        entries.add(ModBlocks.POLISHED_CORESTONE_STAIRS);
                        entries.add(ModBlocks.POLISHED_CORESTONE_WALL);
                        entries.add(ModBlocks.CORESTONE_BRICKS);
                        entries.add(ModBlocks.CORESTONE_BRICKS_SLAB);
                        entries.add(ModBlocks.CORESTONE_BRICKS_STAIRS);
                        entries.add(ModBlocks.CORESTONE_BRICKS_WALL);

                        entries.add(ModBlocks.COMPRESSED_END_STONE);
                        entries.add(ModBlocks.COMPRESSED_END_STONE_BRICKS);
                        entries.add(ModBlocks.COMPRESSED_END_STONE_BRICKS_SLAB);
                        entries.add(ModBlocks.COMPRESSED_END_STONE_BRICKS_STAIRS);
                        entries.add(ModBlocks.COMPRESSED_END_STONE_BRICKS_WALL);

                        entries.add(ModBlocks.PINK_SAND);
                        entries.add(ModBlocks.PINK_SANDSTONE);
                        entries.add(ModBlocks.PINK_SANDSTONE_SLAB);
                        entries.add(ModBlocks.PINK_SANDSTONE_STAIRS);
                        entries.add(ModBlocks.PINK_SANDSTONE_WALL);
                        entries.add(ModBlocks.SMOOTH_PINK_SANDSTONE);
                        entries.add(ModBlocks.SMOOTH_PINK_SANDSTONE_SLAB);
                        entries.add(ModBlocks.SMOOTH_PINK_SANDSTONE_STAIRS);
                        entries.add(ModBlocks.CUT_PINK_SANDSTONE);
                        entries.add(ModBlocks.CUT_PINK_SANDSTONE_SLAB);
                        entries.add(ModBlocks.CHISELED_PINK_SANDSTONE);
                        entries.add(ModBlocks.ASH_BLOCK);
                        entries.add(ModBlocks.PACKED_ASH);
                        entries.add(ModBlocks.ASH_BRICKS);
                        entries.add(ModBlocks.ASH_BRICKS_SLAB);
                        entries.add(ModBlocks.ASH_BRICKS_STAIRS);
                        entries.add(ModBlocks.ASH_BRICKS_WALL);

                        entries.add(ModItems.STYXCOAL);
                        entries.add(ModBlocks.STYXCOAL_BLOCK);
                        entries.add(ModBlocks.STYXIAN_STYXCOAL_ORE);
                        entries.add(ModBlocks.COMPRESSED_STYXIAN_STYXCOAL_ORE);

                        entries.add(ModItems.AMETHYST_NUGGET);
                        entries.add(ModBlocks.AMETHYST_CLUMP);
                        entries.add(ModBlocks.GLOWING_AMETHYST);
                        entries.add(ModBlocks.FRAGILE_AMETHYST);
                        entries.add(ModBlocks.STYXIAN_AMETHYST_ORE);
                        entries.add(ModBlocks.COMPRESSED_STYXIAN_AMETHYST_ORE);
                        entries.add(ModBlocks.AMETHYST_LAMP);
                        entries.add(ModBlocks.POLISHED_AMETHYST_BLOCK);
                        entries.add(ModBlocks.POLISHED_AMETHYST_SLAB);
                        entries.add(ModBlocks.POLISHED_AMETHYST_STAIRS);
                        entries.add(ModBlocks.POLISHED_AMETHYST_WALL);
                        entries.add(ModBlocks.AMETHYST_TILES);
                        entries.add(ModBlocks.AMETHYST_TILES_SLAB);
                        entries.add(ModBlocks.AMETHYST_TILES_STAIRS);
                        entries.add(ModBlocks.AMETHYST_TILES_WALL);

                        entries.add(ModBlocks.AMETHYST_BRICKS);
                        entries.add(ModBlocks.CHISELED_AMETHYST_BRICKS);
                        entries.add(ModBlocks.AMETHYST_BULB);
                        entries.add(ModBlocks.AMETHYST_BRICKS_SLAB);
                        entries.add(ModBlocks.AMETHYST_BRICKS_STAIRS);
                        entries.add(ModBlocks.AMETHYST_BRICKS_WALL);
                        entries.add(ModBlocks.AMETHYST_ROD);

                        entries.add(ModItems.SULFUR);
                        entries.add(ModBlocks.NETHER_SULFUR_ORE);
                        entries.add(ModBlocks.STYXIAN_SULFUR_ORE);
                        entries.add(ModBlocks.COMPRESSED_STYXIAN_SULFUR_ORE);
                        entries.add(ModBlocks.SULFUR_BLOCK);

                        entries.add(ModItems.RAW_KUNZITE);
                        entries.add(ModItems.KUNZITE_NUGGET);
                        entries.add(ModBlocks.KUNZITE_CLUMP);
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
                        entries.add(ModBlocks.KUNZITE_ROD);

                        entries.add(ModItems.MAGIC_GLITTER);
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
                        entries.add(ModBlocks.ELYSIUM_ROD);

                        entries.add(ModItems.RAW_THERMIUM);
                        entries.add(ModItems.THERMIUM_WASTE);
                        entries.add(ModItems.THERMIUM_NUGGET);
                        entries.add(ModBlocks.THERMIUM_CLUMP);
                        entries.add(ModItems.THERMIUM);
                        entries.add(ModItems.ENERGIZED_THERMIUM);
                        entries.add(ModBlocks.THERMIUM_ORE);
                        entries.add(ModBlocks.DEEPSLATE_THERMIUM_ORE);
                        entries.add(ModBlocks.STYXIAN_THERMIUM_ORE);
                        entries.add(ModBlocks.COMPRESSED_STYXIAN_THERMIUM_ORE);
                        entries.add(ModBlocks.RAW_THERMIUM_BLOCK);
                        entries.add(ModBlocks.THERMIUM_BLOCK);
                        entries.add(ModBlocks.ENERGIZED_THERMIUM_BLOCK);

                        entries.add(ModBlocks.THERMIUM_BRICKS);
                        entries.add(ModBlocks.CHISELED_THERMIUM_BRICKS);
                        entries.add(ModBlocks.THERMIUM_BULB);
                        entries.add(ModBlocks.THERMIUM_BRICKS_SLAB);
                        entries.add(ModBlocks.THERMIUM_BRICKS_STAIRS);
                        entries.add(ModBlocks.THERMIUM_BRICKS_WALL);
                        entries.add(ModBlocks.THERMIUM_ROD);
                        entries.add(ModBlocks.DISPLAY);
                        entries.add(ModBlocks.THERMIUM_BLASTER);

                        entries.add(ModItems.RAW_PINLINE);
                        entries.add(ModItems.PREPARED_PINLINE);
                        entries.add(ModItems.PINLINE_NUGGET);
                        entries.add(ModItems.PINLINE_INGOT);

                        entries.add(ModBlocks.END_PINLINE_ORE);
                        entries.add(ModBlocks.COMPRESSED_END_PINLINE_ORE);
                        entries.add(ModBlocks.RAW_PINLINE_BLOCK);
                        entries.add(ModBlocks.PINLINE_BLOCK);

                        entries.add(ModBlocks.PINLINE_BRICKS);
                        entries.add(ModBlocks.CHISELED_PINLINE_BRICKS);
                        entries.add(ModBlocks.PINLINE_BULB);
                        entries.add(ModBlocks.PINLINE_BRICKS_SLAB);
                        entries.add(ModBlocks.PINLINE_BRICKS_STAIRS);
                        entries.add(ModBlocks.PINLINE_BRICKS_WALL);
                        entries.add(ModBlocks.PINLINE_ROD);

                        entries.add(ModBlocks.RAW_PINLINE_BRICKS);
                        entries.add(ModBlocks.CHISELED_RAW_PINLINE_BRICKS);
                        entries.add(ModBlocks.RAW_PINLINE_BULB);
                        entries.add(ModBlocks.RAW_PINLINE_BRICKS_SLAB);
                        entries.add(ModBlocks.RAW_PINLINE_BRICKS_STAIRS);
                        entries.add(ModBlocks.RAW_PINLINE_BRICKS_WALL);
                        entries.add(ModBlocks.RAW_PINLINE_ROD);

                        entries.add(ModItems.RAW_MOONSTEEL);
                        entries.add(ModItems.MOONSTEEL_NUGGET);
                        entries.add(ModItems.MOONSTEEL_INGOT);

                        entries.add(ModBlocks.STYXIAN_MOONSTEEL_ORE);
                        entries.add(ModBlocks.COMPRESSED_STYXIAN_MOONSTEEL_ORE);
                        entries.add(ModBlocks.RAW_MOONSTEEL_BLOCK);
                        entries.add(ModBlocks.MOONSTEEL_BLOCK);

                        entries.add(ModBlocks.MOONSTEEL_BRICKS);
                        entries.add(ModBlocks.CHISELED_MOONSTEEL_BRICKS);
                        entries.add(ModBlocks.MOONSTEEL_BULB);
                        entries.add(ModBlocks.MOONSTEEL_BRICKS_SLAB);
                        entries.add(ModBlocks.MOONSTEEL_BRICKS_STAIRS);
                        entries.add(ModBlocks.MOONSTEEL_BRICKS_WALL);
                        entries.add(ModBlocks.MOONSTEEL_CHAIN);
                        entries.add(ModBlocks.MOONSTEEL_LANTERN);

                        entries.add(ModBlocks.CORRUPT_ORE);
                        entries.add(ModItems.CORRUPT_DROPLET);
                        entries.add(ModItems.CORRUPT_MASS);
                        entries.add(ModBlocks.CORRUPT_ROOTS);
                        entries.add(ModBlocks.HANGING_CORRUPT_ROOTS);

                        entries.add(ModItems.CERILLE_NUGGET);
                        entries.add(ModItems.CERILLE_INGOT);
                        entries.add(ModBlocks.CERILLE_BLOCK);
                        entries.add(ModItems.FORBIDDEN_MECHANISM);

                        entries.add(ModBlocks.CERILLE_BRICKS);
                        entries.add(ModBlocks.CHISELED_CERILLE_BRICKS);
                        entries.add(ModBlocks.CERILLE_BULB);
                        entries.add(ModBlocks.CERILLE_BRICKS_SLAB);
                        entries.add(ModBlocks.CERILLE_BRICKS_STAIRS);
                        entries.add(ModBlocks.CERILLE_BRICKS_WALL);
                        entries.add(ModBlocks.CERILLE_CHAIN);
                        entries.add(ModBlocks.CERILLE_LANTERN);
                        entries.add(ModBlocks.CORRUPT_CAULDRON);

                        entries.add(ModItems.SUNGAZE_NUGGET);
                        entries.add(ModItems.SUNGAZE);
                        entries.add(ModBlocks.STYXIAN_SUNGAZE_ORE);
                        entries.add(ModBlocks.COMPRESSED_STYXIAN_SUNGAZE_ORE);
                        entries.add(ModBlocks.SUNGAZE_BLOCK);

                        entries.add(ModBlocks.SUNGAZE_BRICKS);
                        entries.add(ModBlocks.CHISELED_SUNGAZE_BRICKS);
                        entries.add(ModBlocks.SUNGAZE_BULB);
                        entries.add(ModBlocks.SUNGAZE_BRICKS_SLAB);
                        entries.add(ModBlocks.SUNGAZE_BRICKS_STAIRS);
                        entries.add(ModBlocks.SUNGAZE_BRICKS_WALL);

                        entries.add(ModItems.MEMORY_SHARD);
                        entries.add(ModBlocks.MEMORY_BRICKS);
                        entries.add(ModBlocks.CHISELED_MEMORY_BRICKS);
                        entries.add(ModBlocks.MEMORY_BULB);
                        entries.add(ModBlocks.MEMORY_BRICKS_SLAB);
                        entries.add(ModBlocks.MEMORY_BRICKS_STAIRS);
                        entries.add(ModBlocks.MEMORY_BRICKS_WALL);

                        entries.add(ModBlocks.STYXIAN_LAPIS_ORE);
                        entries.add(ModBlocks.COMPRESSED_STYXIAN_LAPIS_ORE);

                        entries.add(ModBlocks.STYXIA_PORTAL_FRAME);

                        entries.add(ModBlocks.AMETHYST_PARTERS);
                        entries.add(ModBlocks.KUNZITE_LOVELILY);
                        entries.add(ModBlocks.ELYSIAN_SKYBERRY);
                        entries.add(ModBlocks.THERMIUM_WILTBORN);
                        entries.add(ModBlocks.MEMORIA_BOURPEER);

                        entries.add(ModBlocks.SMALL_END_GRASS);
                        entries.add(ModBlocks.MEDIUM_END_GRASS);
                        entries.add(ModBlocks.LARGE_END_GRASS);
                        entries.add(ModBlocks.CHORUS_LILY);
                        entries.add(ModBlocks.STYXGRASS);
                        entries.add(ModBlocks.HANGING_STYXGRASS);
                        entries.add(ModBlocks.HANGING_STYXMOSS);
                        entries.add(ModBlocks.STYXMOSS_VINE);
                        entries.add(ModBlocks.DEATH_FLOWERS);
                        entries.add(ModItems.CORRUPT_SPROUTS);
                        entries.add(ModItems.COTTON_SEEDS);
                        entries.add(ModItems.COTTON);
                        entries.add(ModBlocks.BLUE_MUSHROOM);
                        entries.add(ModBlocks.BLUE_MUSHROOM_BLOCK);

                        entries.add(ModBlocks.PINK_ICE);

                        entries.add(ModBlocks.CRYSTAL_CHERRY_LOG);
                        entries.add(ModBlocks.CRYSTAL_CHERRY_WOOD);
                        entries.add(ModBlocks.STRIPPED_CRYSTAL_CHERRY_LOG);
                        entries.add(ModBlocks.STRIPPED_CRYSTAL_CHERRY_WOOD);
                        entries.add(ModBlocks.CRYSTAL_CHERRY_PLANKS);
                        entries.add(ModBlocks.CRYSTAL_CHERRY_LEAVES);
                        entries.add(ModBlocks.GLOWING_CHERRY_LEAVES);
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

                        entries.add(ModBlocks.ASHEN_LOG);
                        entries.add(ModBlocks.ASHEN_WOOD);
                        entries.add(ModBlocks.STRIPPED_ASHEN_LOG);
                        entries.add(ModBlocks.STRIPPED_ASHEN_WOOD);
                        entries.add(ModBlocks.ASHEN_PLANKS);

                        entries.add(ModBlocks.ASHEN_SLAB);
                        entries.add(ModBlocks.ASHEN_STAIRS);
                        entries.add(ModBlocks.ASHEN_FENCE);
                        entries.add(ModBlocks.ASHEN_FENCE_GATE);
                        entries.add(ModBlocks.ASHEN_DOOR);
                        entries.add(ModBlocks.ASHEN_TRAPDOOR);
                        entries.add(ModBlocks.ASHEN_PRESSURE_PLATE);
                        entries.add(ModBlocks.ASHEN_BUTTON);

                        entries.add(ModBlocks.KEAPHE_LOG);
                        entries.add(ModBlocks.KEAPHE_WOOD);
                        entries.add(ModBlocks.STRIPPED_KEAPHE_LOG);
                        entries.add(ModBlocks.STRIPPED_KEAPHE_WOOD);
                        entries.add(ModBlocks.KEAPHE_PLANKS);
                        entries.add(ModBlocks.KEAPHE_LEAVES);
                        entries.add(ModBlocks.FLOWERING_KEAPHE_LEAVES);
                        entries.add(ModBlocks.KEAPHE_SAPLING);

                        entries.add(ModBlocks.KEAPHE_SLAB);
                        entries.add(ModBlocks.KEAPHE_STAIRS);
                        entries.add(ModBlocks.KEAPHE_FENCE);
                        entries.add(ModBlocks.KEAPHE_FENCE_GATE);
                        entries.add(ModBlocks.KEAPHE_DOOR);
                        entries.add(ModBlocks.KEAPHE_TRAPDOOR);
                        entries.add(ModBlocks.KEAPHE_PRESSURE_PLATE);
                        entries.add(ModBlocks.KEAPHE_BUTTON);

                        entries.add(ModBlocks.WASTEWOOD_LOG);
                        entries.add(ModBlocks.WASTEWOOD_WOOD);
                        entries.add(ModBlocks.STRIPPED_WASTEWOOD_LOG);
                        entries.add(ModBlocks.STRIPPED_WASTEWOOD_WOOD);
                        entries.add(ModBlocks.WASTEWOOD_PLANKS);

                        entries.add(ModBlocks.WASTEWOOD_SLAB);
                        entries.add(ModBlocks.WASTEWOOD_STAIRS);
                        entries.add(ModBlocks.WASTEWOOD_FENCE);
                        entries.add(ModBlocks.WASTEWOOD_FENCE_GATE);
                        entries.add(ModBlocks.WASTEWOOD_DOOR);
                        entries.add(ModBlocks.WASTEWOOD_TRAPDOOR);
                        entries.add(ModBlocks.WASTEWOOD_PRESSURE_PLATE);
                        entries.add(ModBlocks.WASTEWOOD_BUTTON);

                        entries.add(ModBlocks.CORRERIE_LOG);
                        entries.add(ModBlocks.CORRERIE_WOOD);
                        entries.add(ModBlocks.STRIPPED_CORRERIE_LOG);
                        entries.add(ModBlocks.STRIPPED_CORRERIE_WOOD);
                        entries.add(ModBlocks.CORRERIE_PLANKS);

                        entries.add(ModBlocks.CORRERIE_SLAB);
                        entries.add(ModBlocks.CORRERIE_STAIRS);
                        entries.add(ModBlocks.CORRERIE_FENCE);
                        entries.add(ModBlocks.CORRERIE_FENCE_GATE);
                        entries.add(ModBlocks.CORRERIE_DOOR);
                        entries.add(ModBlocks.CORRERIE_TRAPDOOR);
                        entries.add(ModBlocks.CORRERIE_PRESSURE_PLATE);
                        entries.add(ModBlocks.CORRERIE_BUTTON);

                        entries.add(ModBlocks.SNOWY_SPRUCE_LEAVES);
                        entries.add(ModBlocks.SNOWY_SPRUCE_SAPLING);

                        entries.add(ModItems.GLAZED_CHORUS_FRUIT);
                        entries.add(ModItems.COAL_MEAL);
                        entries.add(ModItems.GELATINOUS_BUD);
                        entries.add(ModItems.ELYSIUM_APPLE);
                        entries.add(ModItems.GODFRUIT);
                        entries.add(ModItems.CRYSTAL_CARROT);
                        entries.add(ModItems.GEM_BERRY);
                        entries.add(ModItems.CHARMBERRY);
                        entries.add(ModItems.BERRY_SALAD);
                        entries.add(ModItems.FLESHY_STEW);
                        entries.add(ModItems.HAZEWEAVER);
                        entries.add(ModItems.RAW_FAIRY_MEAT);
                        entries.add(ModItems.COOKED_FAIRY_MEAT);
                        entries.add(ModItems.MATURE_SPROUT);
                        entries.add(ModItems.DEAD_SPROUT);

                        entries.add(ModItems.BLOOM_SMITHING_TEMPLATE);
                        entries.add(ModItems.CHERRY_SMITHING_TEMPLATE);
                        entries.add(ModItems.SWORDMASTER_SMITHING_TEMPLATE);
                        entries.add(ModItems.SHATTER_SMITHING_TEMPLATE);
                        entries.add(ModItems.CREEPER_SMITHING_TEMPLATE);
                        entries.add(ModItems.CHESS_SMITHING_TEMPLATE);
                        entries.add(ModItems.WANDERER_SMITHING_TEMPLATE);
                        entries.add(ModItems.SHELL_SMITHING_TEMPLATE);
                        entries.add(ModItems.WINGFLAP_SMITHING_TEMPLATE);
                        entries.add(ModItems.OVERGROWTH_SMITHING_TEMPLATE);
                        entries.add(ModItems.CORRUPTION_SMITHING_TEMPLATE);
                        entries.add(ModItems.FORBIDDEN_SMITHING_TEMPLATE);
                        entries.add(ModItems.FAIRYTALE_SMITHING_TEMPLATE);

                        entries.add(ModItems.NETHERITE_MULTITOOL);

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

                        entries.add(ModItems.MOONSTEEL_SWORD);
                        entries.add(ModItems.MOONSTEEL_PICKAXE);
                        entries.add(ModItems.MOONSTEEL_AXE);
                        entries.add(ModItems.MOONSTEEL_SHOVEL);
                        entries.add(ModItems.MOONSTEEL_HOE);
                        entries.add(ModItems.MOONSTEEL_HELMET);
                        entries.add(ModItems.MOONSTEEL_CHESTPLATE);
                        entries.add(ModItems.MOONSTEEL_LEGGINGS);
                        entries.add(ModItems.MOONSTEEL_BOOTS);

                        entries.add(ModItems.CERILLE_SWORD);
                        entries.add(ModItems.CERILLE_PICKAXE);
                        entries.add(ModItems.CERILLE_AXE);
                        entries.add(ModItems.CERILLE_SHOVEL);
                        entries.add(ModItems.CERILLE_HOE);
                        entries.add(ModItems.CERILLE_HELMET);
                        entries.add(ModItems.CERILLE_CHESTPLATE);
                        entries.add(ModItems.CERILLE_LEGGINGS);
                        entries.add(ModItems.CERILLE_BOOTS);

                        entries.add(ModItems.SUNBLAZE_SWORD);
                        entries.add(ModItems.SUNBLAZE_PICKAXE);
                        entries.add(ModItems.SUNBLAZE_AXE);
                        entries.add(ModItems.SUNBLAZE_SHOVEL);
                        entries.add(ModItems.SUNBLAZE_HOE);
                        entries.add(ModItems.SUNBLAZE_MULTITOOL);
                        entries.add(ModItems.SUNBLAZE_HELMET);
                        entries.add(ModItems.SUNBLAZE_CHESTPLATE);
                        entries.add(ModItems.SUNBLAZE_LEGGINGS);
                        entries.add(ModItems.SUNBLAZE_BOOTS);

                        entries.add(ModItems.PINLINE_SWORD);
                        entries.add(ModItems.PINLINE_PICKAXE);
                        entries.add(ModItems.PINLINE_AXE);
                        entries.add(ModItems.PINLINE_SHOVEL);
                        entries.add(ModItems.PINLINE_HOE);
                        entries.add(ModItems.BEDROCK_BREAKER);
                        entries.add(ModItems.PINLINE_HELMET);
                        entries.add(ModItems.PINLINE_CHESTPLATE);
                        entries.add(ModItems.PINLINE_LEGGINGS);
                        entries.add(ModItems.PINLINE_BOOTS);

                        entries.add(ModItems.DAWNBLOOMER);
                        entries.add(ModItems.SUNSHADE);
                    })
                    .build());

    public static void registerItemGroups() {
        JirniysPinkStuff.LOGGER.info("Registering Item Groups for " + JirniysPinkStuff.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.SULFUR_BLOCK);
            entries.add(ModBlocks.STYXCOAL_BLOCK);
            entries.add(ModBlocks.RAW_KUNZITE_BLOCK);
            entries.add(ModBlocks.KUNZITE_BLOCK);
            entries.add(ModBlocks.ELYSIUM_BLOCK);
            entries.add(ModBlocks.RAW_PINLINE_BLOCK);
            entries.add(ModBlocks.PINLINE_BLOCK);
            entries.add(ModBlocks.RAW_THERMIUM_BLOCK);
            entries.add(ModBlocks.THERMIUM_BLOCK);
            entries.add(ModBlocks.ENERGIZED_THERMIUM_BLOCK);
            entries.add(ModBlocks.RAW_MOONSTEEL_BLOCK);
            entries.add(ModBlocks.MOONSTEEL_BLOCK);
            entries.add(ModBlocks.CERILLE_BLOCK);
            entries.add(ModBlocks.SUNGAZE_BLOCK);

            entries.add(ModBlocks.PINK_SANDSTONE);
            entries.add(ModBlocks.PINK_SANDSTONE_SLAB);
            entries.add(ModBlocks.PINK_SANDSTONE_STAIRS);
            entries.add(ModBlocks.PINK_SANDSTONE_WALL);
            entries.add(ModBlocks.SMOOTH_PINK_SANDSTONE);
            entries.add(ModBlocks.SMOOTH_PINK_SANDSTONE_SLAB);
            entries.add(ModBlocks.SMOOTH_PINK_SANDSTONE_STAIRS);
            entries.add(ModBlocks.CUT_PINK_SANDSTONE);
            entries.add(ModBlocks.CUT_PINK_SANDSTONE_SLAB);
            entries.add(ModBlocks.CHISELED_PINK_SANDSTONE);
            entries.add(ModBlocks.PACKED_ASH);
            entries.add(ModBlocks.ASH_BRICKS);
            entries.add(ModBlocks.ASH_BRICKS_SLAB);
            entries.add(ModBlocks.ASH_BRICKS_STAIRS);
            entries.add(ModBlocks.ASH_BRICKS_WALL);

            entries.add(ModBlocks.POLISHED_STYXSTONE);
            entries.add(ModBlocks.POLISHED_STYXSTONE_SLAB);
            entries.add(ModBlocks.POLISHED_STYXSTONE_STAIRS);
            entries.add(ModBlocks.POLISHED_STYXSTONE_WALL);
            entries.add(ModBlocks.STYXSTONE_BRICKS);
            entries.add(ModBlocks.STYXSTONE_BRICKS_SLAB);
            entries.add(ModBlocks.STYXSTONE_BRICKS_STAIRS);
            entries.add(ModBlocks.STYXSTONE_BRICKS_WALL);
            entries.add(ModBlocks.COBBLED_STYXSTONE);
            entries.add(ModBlocks.COBBLED_STYXSTONE_SLAB);
            entries.add(ModBlocks.COBBLED_STYXSTONE_STAIRS);
            entries.add(ModBlocks.COBBLED_STYXSTONE_WALL);
            entries.add(ModBlocks.MOSSY_COBBLED_STYXSTONE);
            entries.add(ModBlocks.MOSSY_COBBLED_STYXSTONE_SLAB);
            entries.add(ModBlocks.MOSSY_COBBLED_STYXSTONE_STAIRS);
            entries.add(ModBlocks.MOSSY_COBBLED_STYXSTONE_WALL);
            entries.add(ModBlocks.POLISHED_COMPRESSED_STYXSTONE);
            entries.add(ModBlocks.POLISHED_COMPRESSED_STYXSTONE_SLAB);
            entries.add(ModBlocks.POLISHED_COMPRESSED_STYXSTONE_STAIRS);
            entries.add(ModBlocks.POLISHED_COMPRESSED_STYXSTONE_WALL);
            entries.add(ModBlocks.COMPRESSED_STYXSTONE_BRICKS);
            entries.add(ModBlocks.COMPRESSED_STYXSTONE_BRICKS_SLAB);
            entries.add(ModBlocks.COMPRESSED_STYXSTONE_BRICKS_STAIRS);
            entries.add(ModBlocks.COMPRESSED_STYXSTONE_BRICKS_WALL);
            entries.add(ModBlocks.POLISHED_MABRIZE);
            entries.add(ModBlocks.POLISHED_MABRIZE_SLAB);
            entries.add(ModBlocks.POLISHED_MABRIZE_STAIRS);
            entries.add(ModBlocks.POLISHED_MABRIZE_WALL);
            entries.add(ModBlocks.MABRIZE_BRICKS);
            entries.add(ModBlocks.MABRIZE_BRICKS_SLAB);
            entries.add(ModBlocks.MABRIZE_BRICKS_STAIRS);
            entries.add(ModBlocks.MABRIZE_BRICKS_WALL);
            entries.add(ModBlocks.POLISHED_AMETANE);
            entries.add(ModBlocks.POLISHED_AMETANE_SLAB);
            entries.add(ModBlocks.POLISHED_AMETANE_STAIRS);
            entries.add(ModBlocks.POLISHED_AMETANE_WALL);
            entries.add(ModBlocks.AMETANE_BRICKS);
            entries.add(ModBlocks.AMETANE_BRICKS_SLAB);
            entries.add(ModBlocks.AMETANE_BRICKS_STAIRS);
            entries.add(ModBlocks.AMETANE_BRICKS_WALL);
            entries.add(ModBlocks.POLISHED_WASTEROCK);
            entries.add(ModBlocks.POLISHED_WASTEROCK_SLAB);
            entries.add(ModBlocks.POLISHED_WASTEROCK_STAIRS);
            entries.add(ModBlocks.POLISHED_WASTEROCK_WALL);
            entries.add(ModBlocks.WASTEROCK_BRICKS);
            entries.add(ModBlocks.WASTEROCK_BRICKS_SLAB);
            entries.add(ModBlocks.WASTEROCK_BRICKS_STAIRS);
            entries.add(ModBlocks.WASTEROCK_BRICKS_WALL);
            entries.add(ModBlocks.POLISHED_CORESTONE);
            entries.add(ModBlocks.POLISHED_CORESTONE_SLAB);
            entries.add(ModBlocks.POLISHED_CORESTONE_STAIRS);
            entries.add(ModBlocks.POLISHED_CORESTONE_WALL);
            entries.add(ModBlocks.CORESTONE_BRICKS);
            entries.add(ModBlocks.CORESTONE_BRICKS_SLAB);
            entries.add(ModBlocks.CORESTONE_BRICKS_STAIRS);
            entries.add(ModBlocks.CORESTONE_BRICKS_WALL);
            entries.add(ModBlocks.COMPRESSED_END_STONE);
            entries.add(ModBlocks.COMPRESSED_END_STONE_BRICKS);
            entries.add(ModBlocks.COMPRESSED_END_STONE_BRICKS_SLAB);
            entries.add(ModBlocks.COMPRESSED_END_STONE_BRICKS_STAIRS);
            entries.add(ModBlocks.COMPRESSED_END_STONE_BRICKS_WALL);
            entries.add(ModBlocks.POLISHED_AMETHYST_BLOCK);
            entries.add(ModBlocks.POLISHED_AMETHYST_SLAB);
            entries.add(ModBlocks.POLISHED_AMETHYST_STAIRS);
            entries.add(ModBlocks.POLISHED_AMETHYST_WALL);
            entries.add(ModBlocks.AMETHYST_TILES);
            entries.add(ModBlocks.AMETHYST_TILES_SLAB);
            entries.add(ModBlocks.AMETHYST_TILES_STAIRS);
            entries.add(ModBlocks.AMETHYST_TILES_WALL);
            entries.add(ModBlocks.AMETHYST_BRICKS);
            entries.add(ModBlocks.CHISELED_AMETHYST_BRICKS);
            entries.add(ModBlocks.AMETHYST_BULB);
            entries.add(ModBlocks.AMETHYST_BRICKS_SLAB);
            entries.add(ModBlocks.AMETHYST_BRICKS_STAIRS);
            entries.add(ModBlocks.AMETHYST_BRICKS_WALL);
            entries.add(ModBlocks.KUNZITE_BRICKS);
            entries.add(ModBlocks.CHISELED_KUNZITE_BRICKS);
            entries.add(ModBlocks.KUNZITE_BULB);
            entries.add(ModBlocks.KUNZITE_BRICKS_SLAB);
            entries.add(ModBlocks.KUNZITE_BRICKS_STAIRS);
            entries.add(ModBlocks.KUNZITE_BRICKS_WALL);
            entries.add(ModBlocks.ELYSIUM_BRICKS);
            entries.add(ModBlocks.CHISELED_ELYSIUM_BRICKS);
            entries.add(ModBlocks.ELYSIUM_BULB);
            entries.add(ModBlocks.ELYSIUM_BRICKS_SLAB);
            entries.add(ModBlocks.ELYSIUM_BRICKS_STAIRS);
            entries.add(ModBlocks.ELYSIUM_BRICKS_WALL);
            entries.add(ModBlocks.THERMIUM_BRICKS);
            entries.add(ModBlocks.CHISELED_THERMIUM_BRICKS);
            entries.add(ModBlocks.THERMIUM_BULB);
            entries.add(ModBlocks.THERMIUM_BRICKS_SLAB);
            entries.add(ModBlocks.THERMIUM_BRICKS_STAIRS);
            entries.add(ModBlocks.THERMIUM_BRICKS_WALL);
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
            entries.add(ModBlocks.MOONSTEEL_BRICKS);
            entries.add(ModBlocks.CHISELED_MOONSTEEL_BRICKS);
            entries.add(ModBlocks.MOONSTEEL_BULB);
            entries.add(ModBlocks.MOONSTEEL_BRICKS_SLAB);
            entries.add(ModBlocks.MOONSTEEL_BRICKS_STAIRS);
            entries.add(ModBlocks.MOONSTEEL_BRICKS_WALL);
            entries.add(ModBlocks.MOONSTEEL_CHAIN);
            entries.add(ModBlocks.MOONSTEEL_LANTERN);
            entries.add(ModBlocks.CERILLE_BRICKS);
            entries.add(ModBlocks.CHISELED_CERILLE_BRICKS);
            entries.add(ModBlocks.CERILLE_BULB);
            entries.add(ModBlocks.CERILLE_BRICKS_SLAB);
            entries.add(ModBlocks.CERILLE_BRICKS_STAIRS);
            entries.add(ModBlocks.CERILLE_BRICKS_WALL);
            entries.add(ModBlocks.CERILLE_CHAIN);
            entries.add(ModBlocks.CERILLE_LANTERN);
            entries.add(ModBlocks.SUNGAZE_BRICKS);
            entries.add(ModBlocks.CHISELED_SUNGAZE_BRICKS);
            entries.add(ModBlocks.SUNGAZE_BULB);
            entries.add(ModBlocks.SUNGAZE_BRICKS_SLAB);
            entries.add(ModBlocks.SUNGAZE_BRICKS_STAIRS);
            entries.add(ModBlocks.SUNGAZE_BRICKS_WALL);
            entries.add(ModBlocks.MEMORY_BRICKS);
            entries.add(ModBlocks.CHISELED_MEMORY_BRICKS);
            entries.add(ModBlocks.MEMORY_BULB);
            entries.add(ModBlocks.MEMORY_BRICKS_SLAB);
            entries.add(ModBlocks.MEMORY_BRICKS_STAIRS);
            entries.add(ModBlocks.MEMORY_BRICKS_WALL);

            entries.add(ModBlocks.MOONSTEEL_CHAIN);

            entries.add(ModBlocks.AMETHYST_ROD);
            entries.add(ModBlocks.KUNZITE_ROD);
            entries.add(ModBlocks.ELYSIUM_ROD);
            entries.add(ModBlocks.THERMIUM_ROD);
            entries.add(ModBlocks.RAW_PINLINE_ROD);
            entries.add(ModBlocks.PINLINE_ROD);

            entries.add(ModBlocks.PINK_ICE);
            entries.add(ModBlocks.SNOWY_SPRUCE_LEAVES);
            entries.add(ModBlocks.SNOWY_SPRUCE_SAPLING);
            entries.add(ModBlocks.CRYSTAL_CHERRY_LOG);
            entries.add(ModBlocks.CRYSTAL_CHERRY_WOOD);
            entries.add(ModBlocks.STRIPPED_CRYSTAL_CHERRY_LOG);
            entries.add(ModBlocks.STRIPPED_CRYSTAL_CHERRY_WOOD);
            entries.add(ModBlocks.CRYSTAL_CHERRY_PLANKS);
            entries.add(ModBlocks.CRYSTAL_CHERRY_LEAVES);
            entries.add(ModBlocks.GLOWING_CHERRY_LEAVES);
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
            entries.add(ModBlocks.ASHEN_LOG);
            entries.add(ModBlocks.ASHEN_WOOD);
            entries.add(ModBlocks.STRIPPED_ASHEN_LOG);
            entries.add(ModBlocks.STRIPPED_ASHEN_WOOD);
            entries.add(ModBlocks.ASHEN_PLANKS);
            entries.add(ModBlocks.ASHEN_SLAB);
            entries.add(ModBlocks.ASHEN_STAIRS);
            entries.add(ModBlocks.ASHEN_FENCE);
            entries.add(ModBlocks.ASHEN_FENCE_GATE);
            entries.add(ModBlocks.ASHEN_DOOR);
            entries.add(ModBlocks.ASHEN_TRAPDOOR);
            entries.add(ModBlocks.ASHEN_PRESSURE_PLATE);
            entries.add(ModBlocks.ASHEN_BUTTON);
            entries.add(ModBlocks.KEAPHE_LOG);
            entries.add(ModBlocks.KEAPHE_WOOD);
            entries.add(ModBlocks.STRIPPED_KEAPHE_LOG);
            entries.add(ModBlocks.STRIPPED_KEAPHE_WOOD);
            entries.add(ModBlocks.KEAPHE_PLANKS);
            entries.add(ModBlocks.KEAPHE_SLAB);
            entries.add(ModBlocks.KEAPHE_STAIRS);
            entries.add(ModBlocks.KEAPHE_FENCE);
            entries.add(ModBlocks.KEAPHE_FENCE_GATE);
            entries.add(ModBlocks.KEAPHE_DOOR);
            entries.add(ModBlocks.KEAPHE_TRAPDOOR);
            entries.add(ModBlocks.KEAPHE_PRESSURE_PLATE);
            entries.add(ModBlocks.KEAPHE_BUTTON);
            entries.add(ModBlocks.WASTEWOOD_LOG);
            entries.add(ModBlocks.WASTEWOOD_WOOD);
            entries.add(ModBlocks.STRIPPED_WASTEWOOD_LOG);
            entries.add(ModBlocks.STRIPPED_WASTEWOOD_WOOD);
            entries.add(ModBlocks.WASTEWOOD_PLANKS);
            entries.add(ModBlocks.WASTEWOOD_SLAB);
            entries.add(ModBlocks.WASTEWOOD_STAIRS);
            entries.add(ModBlocks.WASTEWOOD_FENCE);
            entries.add(ModBlocks.WASTEWOOD_FENCE_GATE);
            entries.add(ModBlocks.WASTEWOOD_DOOR);
            entries.add(ModBlocks.WASTEWOOD_TRAPDOOR);
            entries.add(ModBlocks.WASTEWOOD_PRESSURE_PLATE);
            entries.add(ModBlocks.WASTEWOOD_BUTTON);
            entries.add(ModBlocks.CORRERIE_LOG);
            entries.add(ModBlocks.CORRERIE_WOOD);
            entries.add(ModBlocks.STRIPPED_CORRERIE_LOG);
            entries.add(ModBlocks.STRIPPED_CORRERIE_WOOD);
            entries.add(ModBlocks.CORRERIE_PLANKS);
            entries.add(ModBlocks.CORRERIE_SLAB);
            entries.add(ModBlocks.CORRERIE_STAIRS);
            entries.add(ModBlocks.CORRERIE_FENCE);
            entries.add(ModBlocks.CORRERIE_FENCE_GATE);
            entries.add(ModBlocks.CORRERIE_DOOR);
            entries.add(ModBlocks.CORRERIE_TRAPDOOR);
            entries.add(ModBlocks.CORRERIE_PRESSURE_PLATE);
            entries.add(ModBlocks.CORRERIE_BUTTON);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(ModItems.GLAZED_CHORUS_FRUIT);
            entries.add(ModItems.COAL_MEAL);
            entries.add(ModItems.GELATINOUS_BUD);
            entries.add(ModItems.ELYSIUM_APPLE);
            entries.add(ModItems.GODFRUIT);
            entries.add(ModItems.CRYSTAL_CARROT);
            entries.add(ModItems.GEM_BERRY);
            entries.add(ModItems.CHARMBERRY);
            entries.add(ModItems.BERRY_SALAD);
            entries.add(ModItems.FLESHY_STEW);
            entries.add(ModItems.HAZEWEAVER);
            entries.add(ModItems.RAW_FAIRY_MEAT);
            entries.add(ModItems.COOKED_FAIRY_MEAT);
            entries.add(ModItems.MATURE_SPROUT);
            entries.add(ModItems.DEAD_SPROUT);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> {
            entries.add(ModBlocks.AMETHYST_LAMP);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ModItems.QUARTZ_NUGGET);
            entries.add(ModItems.DIAMOND_NUGGET);
            entries.add(ModItems.EMERALD_NUGGET);
            entries.add(ModItems.NETHERITE_NUGGET);
            entries.add(ModItems.AMETHYST_NUGGET);
            entries.add(ModItems.STYXCOAL);
            entries.add(ModItems.SULFUR);
            entries.add(ModItems.RAW_KUNZITE);
            entries.add(ModItems.KUNZITE_NUGGET);
            entries.add(ModItems.KUNZITE);
            entries.add(ModItems.PINK_BITS);
            entries.add(ModItems.MAGIC_GLITTER);
            entries.add(ModItems.CRYSTAL_GLITTER);
            entries.add(ModItems.ELYSIUM_NUGGET);
            entries.add(ModItems.ELYSIUM_INGOT);
            entries.add(ModItems.ELYSIAN_REDSTONE_CORE);
            entries.add(ModItems.RAW_THERMIUM);
            entries.add(ModItems.THERMIUM_WASTE);
            entries.add(ModItems.THERMIUM_NUGGET);
            entries.add(ModItems.THERMIUM);
            entries.add(ModItems.ENERGIZED_THERMIUM);
            entries.add(ModItems.RAW_PINLINE);
            entries.add(ModItems.PREPARED_PINLINE);
            entries.add(ModItems.PINLINE_NUGGET);
            entries.add(ModItems.PINLINE_INGOT);
            entries.add(ModItems.MEMORY_SHARD);
            entries.add(ModItems.CORRUPT_DROPLET);
            entries.add(ModItems.CORRUPT_MASS);
            entries.add(ModItems.RAW_MOONSTEEL);
            entries.add(ModItems.MOONSTEEL_NUGGET);
            entries.add(ModItems.MOONSTEEL_INGOT);
            entries.add(ModItems.CERILLE_NUGGET);
            entries.add(ModItems.CERILLE_INGOT);
            entries.add(ModItems.FORBIDDEN_MECHANISM);
            entries.add(ModItems.SUNGAZE_NUGGET);
            entries.add(ModItems.SUNGAZE);

            entries.add(ModItems.COTTON);

            entries.add(ModItems.AMETHYST_BLAZE_ROD);

            entries.add(ModItems.BLOOM_SMITHING_TEMPLATE);
            entries.add(ModItems.CHERRY_SMITHING_TEMPLATE);
            entries.add(ModItems.SWORDMASTER_SMITHING_TEMPLATE);
            entries.add(ModItems.SHATTER_SMITHING_TEMPLATE);
            entries.add(ModItems.CREEPER_SMITHING_TEMPLATE);
            entries.add(ModItems.CHESS_SMITHING_TEMPLATE);
            entries.add(ModItems.WANDERER_SMITHING_TEMPLATE);
            entries.add(ModItems.SHELL_SMITHING_TEMPLATE);
            entries.add(ModItems.WINGFLAP_SMITHING_TEMPLATE);
            entries.add(ModItems.OVERGROWTH_SMITHING_TEMPLATE);
            entries.add(ModItems.CORRUPTION_SMITHING_TEMPLATE);
            entries.add(ModItems.FORBIDDEN_SMITHING_TEMPLATE);
            entries.add(ModItems.FAIRYTALE_SMITHING_TEMPLATE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(ModItems.KUNZITE_SWORD);
            entries.add(ModItems.KUNZITE_AXE);
            entries.add(ModItems.KUNZITE_HELMET);
            entries.add(ModItems.KUNZITE_CHESTPLATE);
            entries.add(ModItems.KUNZITE_LEGGINGS);
            entries.add(ModItems.KUNZITE_BOOTS);

            entries.add(ModItems.ELYSIUM_SWORD);
            entries.add(ModItems.ELYSIUM_AXE);
            entries.add(ModItems.ELYSIUM_HELMET);
            entries.add(ModItems.ELYSIUM_CHESTPLATE);
            entries.add(ModItems.ELYSIUM_LEGGINGS);
            entries.add(ModItems.ELYSIUM_BOOTS);

            entries.add(ModItems.MOONSTEEL_SWORD);
            entries.add(ModItems.MOONSTEEL_AXE);
            entries.add(ModItems.MOONSTEEL_HELMET);
            entries.add(ModItems.MOONSTEEL_CHESTPLATE);
            entries.add(ModItems.MOONSTEEL_LEGGINGS);
            entries.add(ModItems.MOONSTEEL_BOOTS);

            entries.add(ModItems.CERILLE_SWORD);
            entries.add(ModItems.CERILLE_AXE);
            entries.add(ModItems.CERILLE_HELMET);
            entries.add(ModItems.CERILLE_CHESTPLATE);
            entries.add(ModItems.CERILLE_LEGGINGS);
            entries.add(ModItems.CERILLE_BOOTS);

            entries.add(ModItems.SUNBLAZE_SWORD);
            entries.add(ModItems.SUNBLAZE_AXE);
            entries.add(ModItems.SUNBLAZE_HELMET);
            entries.add(ModItems.SUNBLAZE_CHESTPLATE);
            entries.add(ModItems.SUNBLAZE_LEGGINGS);
            entries.add(ModItems.SUNBLAZE_BOOTS);

            entries.add(ModItems.PINLINE_SWORD);
            entries.add(ModItems.PINLINE_AXE);
            entries.add(ModItems.PINLINE_HELMET);
            entries.add(ModItems.PINLINE_CHESTPLATE);
            entries.add(ModItems.PINLINE_LEGGINGS);
            entries.add(ModItems.PINLINE_BOOTS);

            entries.add(ModItems.DAWNBLOOMER);
            entries.add(ModItems.SUNSHADE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(ModBlocks.KUNZITE_ORE);
            entries.add(ModBlocks.AMETHYST_KUNZITE_ORE);
            entries.add(ModBlocks.DEEPSLATE_KUNZITE_ORE);
            entries.add(ModBlocks.THERMIUM_ORE);
            entries.add(ModBlocks.DEEPSLATE_THERMIUM_ORE);
            entries.add(ModBlocks.STYXIAN_THERMIUM_ORE);
            entries.add(ModBlocks.COMPRESSED_STYXIAN_THERMIUM_ORE);
            entries.add(ModBlocks.NETHER_SULFUR_ORE);
            entries.add(ModBlocks.STYXIAN_SULFUR_ORE);
            entries.add(ModBlocks.COMPRESSED_STYXIAN_SULFUR_ORE);
            entries.add(ModBlocks.STYXIAN_MOONSTEEL_ORE);
            entries.add(ModBlocks.END_PINLINE_ORE);
            entries.add(ModBlocks.COMPRESSED_END_PINLINE_ORE);
            entries.add(ModBlocks.STYXIAN_STYXCOAL_ORE);
            entries.add(ModBlocks.COMPRESSED_STYXIAN_STYXCOAL_ORE);
            entries.add(ModBlocks.STYXIAN_MOONSTEEL_ORE);
            entries.add(ModBlocks.COMPRESSED_STYXIAN_MOONSTEEL_ORE);
            entries.add(ModBlocks.STYXIAN_SUNGAZE_ORE);
            entries.add(ModBlocks.COMPRESSED_STYXIAN_SUNGAZE_ORE);
            entries.add(ModBlocks.STYXIAN_LAPIS_ORE);
            entries.add(ModBlocks.COMPRESSED_STYXIAN_LAPIS_ORE);
            entries.add(ModBlocks.STYXIAN_AMETHYST_ORE);
            entries.add(ModBlocks.COMPRESSED_STYXIAN_AMETHYST_ORE);
            entries.add(ModBlocks.CORRUPT_ORE);

            entries.add(ModBlocks.PINK_SAND);
            entries.add(ModBlocks.PINK_SANDSTONE);
            entries.add(ModBlocks.ASH_BLOCK);
            entries.add(ModBlocks.BLACK_GOOP);
            entries.add(ModBlocks.CORESTONE);
            entries.add(ModBlocks.STYXSTONE);
            entries.add(ModBlocks.COMPRESSED_STYXSTONE);
            entries.add(ModBlocks.MABRIZE);
            entries.add(ModBlocks.AMETANE);
            entries.add(ModBlocks.WASTEROCK);
            entries.add(ModBlocks.STYXIAN_SOIL);
            entries.add(ModBlocks.ROOTED_STYXIAN_SOIL);
            entries.add(ModBlocks.STYXMOSS);
            entries.add(ModBlocks.STYXMOSS_CARPET);

            entries.add(ModBlocks.GLOWING_AMETHYST);
            entries.add(ModBlocks.FRAGILE_AMETHYST);

            entries.add(ModBlocks.COMPRESSED_END_STONE);
            entries.add(ModBlocks.SNOWY_SPRUCE_LEAVES);
            entries.add(ModBlocks.SNOWY_SPRUCE_SAPLING);

            entries.add(ModBlocks.CRYSTAL_CHERRY_LOG);
            entries.add(ModBlocks.CRYSTAL_CHERRY_LEAVES);
            entries.add(ModBlocks.GLOWING_CHERRY_LEAVES);
            entries.add(ModBlocks.CRYSTAL_CHERRY_SAPLING);

            entries.add(ModBlocks.CHORUS_LOG);
            entries.add(ModBlocks.CHORUS_LEAVES);
            entries.add(ModBlocks.CHORUS_SAPLING);

            entries.add(ModBlocks.KEAPHE_LOG);
            entries.add(ModBlocks.FLOWERING_KEAPHE_LEAVES);
            entries.add(ModBlocks.KEAPHE_LEAVES);
            entries.add(ModBlocks.KEAPHE_SAPLING);

            entries.add(ModBlocks.ASHEN_LOG);
            entries.add(ModBlocks.WASTEWOOD_LOG);
            entries.add(ModBlocks.CORRERIE_LOG);

            entries.add(ModBlocks.SMALL_END_GRASS);
            entries.add(ModBlocks.MEDIUM_END_GRASS);
            entries.add(ModBlocks.LARGE_END_GRASS);
            entries.add(ModBlocks.CHORUS_LILY);
            entries.add(ModItems.HAZEWEAVER);
            entries.add(ModBlocks.AMETHYST_PARTERS);
            entries.add(ModBlocks.KUNZITE_LOVELILY);
            entries.add(ModBlocks.ELYSIAN_SKYBERRY);
            entries.add(ModBlocks.THERMIUM_WILTBORN);
            entries.add(ModBlocks.MEMORIA_BOURPEER);
            entries.add(ModBlocks.STYXGRASS);
            entries.add(ModBlocks.HANGING_STYXGRASS);
            entries.add(ModBlocks.HANGING_STYXMOSS);
            entries.add(ModBlocks.STYXMOSS_VINE);
            entries.add(ModBlocks.DEATH_FLOWERS);
            entries.add(ModBlocks.CORRUPT_ROOTS);
            entries.add(ModBlocks.HANGING_CORRUPT_ROOTS);
            entries.add(ModItems.CORRUPT_SPROUTS);
            entries.add(ModItems.COTTON_SEEDS);
            entries.add(ModItems.COTTON);
            entries.add(ModBlocks.BLUE_MUSHROOM);
            entries.add(ModBlocks.BLUE_MUSHROOM_BLOCK);

            entries.add(ModBlocks.AMETHYST_CLUMP);
            entries.add(ModBlocks.DIAMOND_CLUMP);
            entries.add(ModBlocks.EMERALD_CLUMP);
            entries.add(ModBlocks.QUARTZ_CLUMP);
            entries.add(ModBlocks.KUNZITE_CLUMP);
            entries.add(ModBlocks.THERMIUM_CLUMP);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> {
            entries.add(ModItems.CRAWLER_SPAWN_EGG);
            entries.add(ModItems.EXOFAIRY_SPAWN_EGG);
            entries.add(ModItems.CORRUPTED_ZOMBIE_SPAWN_EGG);
            entries.add(ModItems.CORRUPTED_SKELETON_SPAWN_EGG);
            entries.add(ModItems.AMETHYST_BLAZE_SPAWN_EGG);
            entries.add(ModItems.CORRUPTION_BLAZE_SPAWN_EGG);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(ModBlocks.MOONSTEEL_CHAIN);
            entries.add(ModBlocks.MOONSTEEL_LANTERN);
            entries.add(ModBlocks.STYXIA_PORTAL_FRAME);
            entries.add(ModBlocks.THERMIUM_BLASTER);
            entries.add(ModBlocks.CORRUPT_CAULDRON);
            entries.add(ModBlocks.DISPLAY);

            entries.add(ModBlocks.CRAWLER_STONE);
            entries.add(ModBlocks.CRAWLER_DEEPSLATE);
            entries.add(ModBlocks.CRAWLER_NETHERRACK);
            entries.add(ModBlocks.CRAWLER_STYXSTONE);
            entries.add(ModBlocks.CRAWLER_COMPRESSED_STYXSTONE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(ModItems.NETHERITE_MULTITOOL);
            entries.add(ModItems.KUNZITE_PICKAXE);
            entries.add(ModItems.KUNZITE_AXE);
            entries.add(ModItems.KUNZITE_SHOVEL);
            entries.add(ModItems.KUNZITE_HOE);
            entries.add(ModItems.ELYSIUM_PICKAXE);
            entries.add(ModItems.ELYSIUM_AXE);
            entries.add(ModItems.ELYSIUM_SHOVEL);
            entries.add(ModItems.ELYSIUM_HOE);
            entries.add(ModItems.ELYSIUM_HAMMER);
            entries.add(ModItems.ELYSIUM_MULTITOOL);
            entries.add(ModItems.MOONSTEEL_PICKAXE);
            entries.add(ModItems.MOONSTEEL_AXE);
            entries.add(ModItems.MOONSTEEL_SHOVEL);
            entries.add(ModItems.MOONSTEEL_HOE);
            entries.add(ModItems.CERILLE_PICKAXE);
            entries.add(ModItems.CERILLE_AXE);
            entries.add(ModItems.CERILLE_SHOVEL);
            entries.add(ModItems.CERILLE_HOE);
            entries.add(ModItems.SUNBLAZE_PICKAXE);
            entries.add(ModItems.SUNBLAZE_AXE);
            entries.add(ModItems.SUNBLAZE_SHOVEL);
            entries.add(ModItems.SUNBLAZE_HOE);
            entries.add(ModItems.SUNBLAZE_MULTITOOL);
            entries.add(ModItems.PINLINE_PICKAXE);
            entries.add(ModItems.PINLINE_AXE);
            entries.add(ModItems.PINLINE_SHOVEL);
            entries.add(ModItems.PINLINE_HOE);
            entries.add(ModItems.BEDROCK_BREAKER);
        });
    }
}
