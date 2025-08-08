package net.jirniy.pinkstuff.block;

import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.block.custom.*;
import net.jirniy.pinkstuff.particle.ModParticles;
import net.jirniy.pinkstuff.util.ModTags;
import net.jirniy.pinkstuff.world.tree.ModSaplingGenerator;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import java.util.function.Function;

public class ModBlocks {

    public static final Block PINK_ICE = registerBlock("pink_ice",
            properties -> new TranslucentBlock(properties.strength(8f).slipperiness(1.01f).nonOpaque()
                    .sounds(BlockSoundGroup.GLASS).mapColor(MapColor.DULL_PINK)));
    public static final Block DIAMOND_CLUMP = registerBlock("diamond_clump",
            properties -> new ModMultifaceBlock(properties.breakInstantly().nonOpaque()
                    .sounds(BlockSoundGroup.AMETHYST_CLUSTER).mapColor(MapColor.DIAMOND_BLUE)));
    public static final Block EMERALD_CLUMP = registerBlock("emerald_clump",
            properties -> new ModMultifaceBlock(properties.breakInstantly().nonOpaque()
                    .sounds(BlockSoundGroup.AMETHYST_CLUSTER).mapColor(MapColor.EMERALD_GREEN)));
    public static final Block AMETHYST_CLUMP = registerBlock("amethyst_clump",
            properties -> new ModMultifaceBlock(properties.breakInstantly().nonOpaque()
                    .sounds(BlockSoundGroup.AMETHYST_CLUSTER).mapColor(MapColor.PURPLE)));
    public static final Block QUARTZ_CLUMP = registerBlock("quartz_clump",
            properties -> new ModMultifaceBlock(properties.breakInstantly().nonOpaque()
                    .sounds(BlockSoundGroup.NETHER_ORE).mapColor(MapColor.TERRACOTTA_WHITE)));

    public static final Block COMPRESSED_END_STONE = registerBlock("compressed_end_stone",
            properties -> new Block(properties.strength(10f)
                    .requiresTool().sounds(BlockSoundGroup.DEEPSLATE).mapColor(MapColor.PALE_YELLOW)));

    public static final Block KUNZITE_BLOCK = registerBlock("kunzite_block",
        properties -> new Block(properties.strength(4f)
                .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PURPLE)));
    public static final Block RAW_KUNZITE_BLOCK = registerBlock("raw_kunzite_block",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.STONE).mapColor(MapColor.PALE_PURPLE)));
    public static final Block KUNZITE_ORE = registerBlock("kunzite_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(1, 1),
                    properties.strength(3f).requiresTool().mapColor(MapColor.PALE_PURPLE)));
    public static final Block DEEPSLATE_KUNZITE_ORE = registerBlock("deepslate_kunzite_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(1, 1),
                    properties.strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE).mapColor(MapColor.DARK_DULL_PINK)));
    public static final Block AMETHYST_KUNZITE_ORE = registerBlock("amethyst_kunzite_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(1, 1),
                    properties.strength(3f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PURPLE)));
    public static final Block KUNZITE_CLUMP = registerBlock("kunzite_clump",
            properties -> new ModMultifaceBlock(properties.breakInstantly().nonOpaque()
                    .sounds(BlockSoundGroup.AMETHYST_CLUSTER).mapColor(MapColor.PURPLE)));
    public static final Block ELYSIUM_BLOCK = registerBlock("elysium_block",
            properties -> new Block(properties.strength(5f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PINK)));

    public static final Block KUNZITE_ROD = registerBlock("kunzite_rod",
            properties -> new ModRodBlock(null, properties.breakInstantly().luminance(state -> 15)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PURPLE)));

    public static final Block THERMIUM_BLOCK = registerBlock("thermium_block",
            properties -> new Block(properties.strength(5f)
                    .requiresTool().sounds(BlockSoundGroup.IRON).luminance(state -> 11).mapColor(MapColor.LIME)));
    public static final Block ENERGIZED_THERMIUM_BLOCK = registerBlock("energized_thermium_block",
            properties -> new PillarBlock(properties.strength(30f)
                    .requiresTool().sounds(BlockSoundGroup.IRON).luminance(state -> 15).mapColor(MapColor.LIME)));
    public static final Block RAW_THERMIUM_BLOCK = registerBlock("raw_thermium_block",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.STONE).luminance(state -> 7).mapColor(MapColor.TERRACOTTA_LIME)));
    public static final Block THERMIUM_ORE = registerBlock("thermium_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(1, 1),
                    properties.strength(5f).requiresTool().luminance(state -> 3).mapColor(MapColor.PALE_GREEN)));
    public static final Block DEEPSLATE_THERMIUM_ORE = registerBlock("deepslate_thermium_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(1, 1),
                    properties.strength(6f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE).luminance(state -> 2).mapColor(MapColor.DARK_GREEN)));
    public static final Block THERMIUM_CLUMP = registerBlock("thermium_clump",
            properties -> new ModMultifaceBlock(properties.breakInstantly().nonOpaque()
                    .luminance(state -> ModMultifaceBlock.luminanceSupplier(state, 1))
                    .sounds(BlockSoundGroup.IRON).mapColor(MapColor.LIME)));

    public static final Block THERMIUM_ROD = registerBlock("thermium_rod",
            properties -> new ModRodBlock(null, properties.breakInstantly().luminance(state -> 15)
                    .requiresTool().sounds(BlockSoundGroup.IRON).mapColor(MapColor.LIME)));

    public static final Block NETHER_SULFUR_ORE = registerBlock("nether_sulfur_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(1, 3),
                    properties.strength(3f).requiresTool().mapColor(MapColor.DULL_RED).sounds(BlockSoundGroup.NETHER_ORE)));
    public static final Block SULFUR_BLOCK = registerBlock("sulfur_block",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.BASALT).mapColor(MapColor.PALE_YELLOW)));

    public static final Block PINLINE_BLOCK = registerBlock("pinline_block",
            properties -> new Block(properties.strength(7f)
                    .requiresTool().sounds(BlockSoundGroup.HEAVY_CORE).mapColor(MapColor.PURPLE)));
    public static final Block RAW_PINLINE_BLOCK = registerBlock("raw_pinline_block",
            properties -> new Block(properties.strength(5f)
                    .requiresTool().sounds(BlockSoundGroup.NETHER_ORE).mapColor(MapColor.PALE_GREEN)));
    public static final Block END_PINLINE_ORE = registerBlock("end_pinline_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(4, 6),
                    properties.strength(8f).requiresTool().mapColor(MapColor.PALE_GREEN)));
    public static final Block COMPRESSED_END_PINLINE_ORE = registerBlock("compressed_end_pinline_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(5, 7),
                    properties.strength(13f).sounds(BlockSoundGroup.DEEPSLATE).requiresTool().mapColor(MapColor.PALE_GREEN)));

    public static final Block PINLINE_ROD = registerBlock("pinline_rod",
            properties -> new ModRodBlock(null, properties.breakInstantly().luminance(state -> 15)
                    .requiresTool().sounds(BlockSoundGroup.IRON).mapColor(MapColor.PURPLE)));
    public static final Block RAW_PINLINE_ROD = registerBlock("raw_pinline_rod",
            properties -> new ModRodBlock(null, properties.breakInstantly().luminance(state -> 11)
                    .requiresTool().sounds(BlockSoundGroup.NETHER_ORE).mapColor(MapColor.PALE_GREEN)));

    public static final Block CRYSTAL_CHERRY_LOG = registerBlock("crystal_cherry_log",
            properties -> new PillarBlock(properties
                    .strength(2.0F).luminance(state -> 4).sounds(BlockSoundGroup.CHERRY_WOOD).burnable().mapColor(MapColor.DARK_DULL_PINK)));
    public static final Block CRYSTAL_CHERRY_WOOD = registerBlock("crystal_cherry_wood",
            properties -> new PillarBlock(properties
                    .strength(2.0F).luminance(state -> 4).sounds(BlockSoundGroup.CHERRY_WOOD).burnable().mapColor(MapColor.DARK_DULL_PINK)));
    public static final Block STRIPPED_CRYSTAL_CHERRY_LOG = registerBlock("stripped_crystal_cherry_log",
            properties -> new PillarBlock(properties
                    .strength(2.0F).luminance(state -> 7).sounds(BlockSoundGroup.CHERRY_WOOD).burnable().mapColor(MapColor.PALE_PURPLE)));
    public static final Block STRIPPED_CRYSTAL_CHERRY_WOOD = registerBlock("stripped_crystal_cherry_wood",
            properties -> new PillarBlock(properties
                    .strength(2.0F).luminance(state -> 7).sounds(BlockSoundGroup.CHERRY_WOOD).burnable().mapColor(MapColor.PALE_PURPLE)));

    public static final Block CRYSTAL_CHERRY_PLANKS = registerBlock("crystal_cherry_planks",
            properties -> new Block(properties.strength(2f).luminance(state -> 3).sounds(BlockSoundGroup.CHERRY_WOOD).mapColor(MapColor.PALE_PURPLE)));
    public static final Block CRYSTAL_CHERRY_LEAVES = registerBlock("crystal_cherry_leaves",
            properties -> new UntintedParticleLeavesBlock(0.1f, ParticleTypes.CHERRY_LEAVES, properties
                    .mapColor(MapColor.PINK).strength(0.2F).ticksRandomly().luminance(state -> 3)
                    .sounds(BlockSoundGroup.CHERRY_LEAVES).nonOpaque()
                    .allowsSpawning(Blocks::canSpawnOnLeaves).suffocates(Blocks::never)
                    .blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY)
                    .solidBlock(Blocks::never)));

    public static final Block CRYSTAL_CHERRY_SAPLING = registerBlock("crystal_cherry_sapling",
            properties -> new ModSaplingBlock(ModSaplingGenerator.CRYSTAL_CHERRY, properties.mapColor(MapColor.PINK)
                    .noCollision().ticksRandomly().breakInstantly().luminance(state -> 4)
                    .sounds(BlockSoundGroup.CHERRY_LEAVES).pistonBehavior(PistonBehavior.DESTROY), BlockTags.DIRT));


    public static final Block CHORUS_LOG = registerBlock("chorus_log",
            properties -> new PillarBlock(properties
                    .strength(2.0F).sounds(BlockSoundGroup.CHERRY_WOOD).burnable().mapColor(MapColor.DARK_DULL_PINK)));
    public static final Block CHORUS_WOOD = registerBlock("chorus_wood",
            properties -> new PillarBlock(properties
                    .strength(2.0F).sounds(BlockSoundGroup.CHERRY_WOOD).burnable().mapColor(MapColor.DARK_DULL_PINK)));
    public static final Block STRIPPED_CHORUS_LOG = registerBlock("stripped_chorus_log",
            properties -> new PillarBlock(properties
                    .strength(2.0F).sounds(BlockSoundGroup.CHERRY_WOOD).burnable().mapColor(MapColor.PALE_PURPLE)));
    public static final Block STRIPPED_CHORUS_WOOD = registerBlock("stripped_chorus_wood",
            properties -> new PillarBlock(properties
                    .strength(2.0F).sounds(BlockSoundGroup.CHERRY_WOOD).burnable().mapColor(MapColor.PALE_PURPLE)));

    public static final Block CHORUS_PLANKS = registerBlock("chorus_planks",
            properties -> new Block(properties.strength(2f).sounds(BlockSoundGroup.CHERRY_WOOD).mapColor(MapColor.PALE_PURPLE)));
    public static final Block CHORUS_LEAVES = registerBlock("chorus_leaves",
            properties -> new UntintedParticleLeavesBlock(0.16f, ModParticles.CHORUS_PETAL_PARTICLE, properties
                    .mapColor(MapColor.PALE_PURPLE).strength(0.4F).ticksRandomly()
                    .sounds(BlockSoundGroup.CHERRY_LEAVES).nonOpaque()
                    .allowsSpawning(Blocks::canSpawnOnLeaves).suffocates(Blocks::never)
                    .blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY)
                    .solidBlock(Blocks::never)));

    public static final Block CHORUS_SAPLING = registerBlock("chorus_sapling",
            properties -> new ModSaplingBlock(ModSaplingGenerator.CHORUS, properties.mapColor(MapColor.PALE_PURPLE)
                    .noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CHERRY_LEAVES)
                    .pistonBehavior(PistonBehavior.DESTROY), ModTags.Blocks.END_STONE));

    public static final Block SNOWY_SPRUCE_LEAVES = registerBlock("snowy_spruce_leaves",
            properties -> new UntintedParticleLeavesBlock(0.1f, ParticleTypes.SNOWFLAKE, properties
                    .mapColor(MapColor.WHITE).strength(0.2F).ticksRandomly()
                    .sounds(BlockSoundGroup.GRASS).nonOpaque()
                    .allowsSpawning(Blocks::canSpawnOnLeaves).suffocates(Blocks::never)
                    .blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY)
                    .solidBlock(Blocks::never)));

    public static final Block SNOWY_SPRUCE_SAPLING = registerBlock("snowy_spruce_sapling",
            properties -> new ModSaplingBlock(ModSaplingGenerator.SNOWY_SPRUCE, properties.mapColor(MapColor.WHITE)
                    .noCollision().ticksRandomly().breakInstantly()
                    .sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY), ModTags.Blocks.SNOWY_SPRUCE_PLACEABLE));

    public static final Block ASHEN_LOG = registerBlock("ashen_log",
            properties -> new PillarBlock(properties
                    .strength(1.5F).sounds(BlockSoundGroup.BASALT).mapColor(MapColor.DEEPSLATE_GRAY)));
    public static final Block ASHEN_WOOD = registerBlock("ashen_wood",
            properties -> new PillarBlock(properties
                    .strength(1.5F).sounds(BlockSoundGroup.BASALT).mapColor(MapColor.DEEPSLATE_GRAY)));
    public static final Block STRIPPED_ASHEN_LOG = registerBlock("stripped_ashen_log",
            properties -> new PillarBlock(properties
                    .strength(1.2F).sounds(BlockSoundGroup.BASALT).mapColor(MapColor.BLACK)));
    public static final Block STRIPPED_ASHEN_WOOD = registerBlock("stripped_ashen_wood",
            properties -> new PillarBlock(properties
                    .strength(1.2F).sounds(BlockSoundGroup.BASALT).mapColor(MapColor.BLACK)));
    public static final Block ASHEN_PLANKS = registerBlock("ashen_planks",
            properties -> new Block(properties.strength(1.3f).sounds(BlockSoundGroup.BASALT).mapColor(MapColor.BLACK)));

    public static final Block AMETHYST_ROD = registerBlock("amethyst_rod",
            properties -> new ModRodBlock(null, properties.breakInstantly().luminance(state -> 15)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_CLUSTER).mapColor(MapColor.PURPLE)));
    public static final Block ELYSIUM_ROD = registerBlock("elysium_rod",
            properties -> new ModRodBlock(null, properties.breakInstantly().luminance(state -> 15)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PINK)));

    public static final Block AMETHYST_BRICKS = registerBlock("amethyst_bricks",
            properties -> new Block(properties.strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PURPLE)));
    public static final Block POLISHED_AMETHYST_BLOCK = registerBlock("polished_amethyst_block",
            properties -> new Block(properties.strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PURPLE)));
    public static final Block CHISELED_AMETHYST_BRICKS = registerBlock("chiseled_amethyst_bricks",
            properties -> new Block(properties.strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PURPLE)));
    public static final Block AMETHYST_BULB = registerBlock("amethyst_bulb",
            properties -> new Block(properties.strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).luminance(state -> 8).mapColor(MapColor.PURPLE)));
    public static final Block KUNZITE_BRICKS = registerBlock("kunzite_bricks",
            properties -> new Block(properties.strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PINK)));
    public static final Block CHISELED_KUNZITE_BRICKS = registerBlock("chiseled_kunzite_bricks",
            properties -> new Block(properties.strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PINK)));
    public static final Block KUNZITE_BULB = registerBlock("kunzite_bulb",
            properties -> new Block(properties.strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).luminance(state -> 10).mapColor(MapColor.PINK)));
    public static final Block ELYSIUM_BRICKS = registerBlock("elysium_bricks",
            properties -> new Block(properties.strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PINK)));
    public static final Block CHISELED_ELYSIUM_BRICKS = registerBlock("chiseled_elysium_bricks",
            properties -> new Block(properties.strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PINK)));
    public static final Block ELYSIUM_BULB = registerBlock("elysium_bulb",
            properties -> new Block(properties.strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).luminance(state -> 15).mapColor(MapColor.PINK)));
    public static final Block THERMIUM_BRICKS = registerBlock("thermium_bricks",
            properties -> new Block(properties.strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.IRON).luminance(state -> 7).mapColor(MapColor.LIME)));
    public static final Block CHISELED_THERMIUM_BRICKS = registerBlock("chiseled_thermium_bricks",
            properties -> new Block(properties.strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.IRON).luminance(state -> 8).mapColor(MapColor.LIME)));
    public static final Block THERMIUM_BULB = registerBlock("thermium_bulb",
            properties -> new Block(properties.strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.IRON).luminance(state -> 14).mapColor(MapColor.LIME)));
    public static final Block MEMORY_BRICKS = registerBlock("memory_bricks",
            properties -> new Block(properties.strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.GILDED_BLACKSTONE).luminance(state -> 1).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final Block CHISELED_MEMORY_BRICKS = registerBlock("chiseled_memory_bricks",
            properties -> new Block(properties.strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.GILDED_BLACKSTONE).luminance(state -> 1).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final Block MEMORY_BULB = registerBlock("memory_bulb",
            properties -> new Block(properties.strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.GILDED_BLACKSTONE).luminance(state -> 15).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final Block PINLINE_BRICKS = registerBlock("pinline_bricks",
            properties -> new Block(properties.strength(6f)
                    .requiresTool().sounds(BlockSoundGroup.IRON).mapColor(MapColor.PALE_PURPLE)));
    public static final Block PINLINE_BULB = registerBlock("pinline_bulb",
            properties -> new Block(properties.strength(6f).luminance(state -> 12)
                    .requiresTool().sounds(BlockSoundGroup.IRON).mapColor(MapColor.PALE_PURPLE)));
    public static final Block CHISELED_PINLINE_BRICKS = registerBlock("chiseled_pinline_bricks",
            properties -> new Block(properties.strength(6f)
                    .requiresTool().sounds(BlockSoundGroup.IRON).mapColor(MapColor.PALE_PURPLE)));
    public static final Block RAW_PINLINE_BRICKS = registerBlock("raw_pinline_bricks",
            properties -> new Block(properties.strength(5f)
                    .requiresTool().sounds(BlockSoundGroup.NETHER_ORE).mapColor(MapColor.PALE_GREEN)));
    public static final Block RAW_PINLINE_BULB = registerBlock("raw_pinline_bulb",
            properties -> new Block(properties.strength(5f).luminance(state -> 8)
                    .requiresTool().sounds(BlockSoundGroup.NETHER_ORE).mapColor(MapColor.PALE_GREEN)));
    public static final Block CHISELED_RAW_PINLINE_BRICKS = registerBlock("chiseled_raw_pinline_bricks",
            properties -> new Block(properties.strength(5f)
                    .requiresTool().sounds(BlockSoundGroup.NETHER_ORE).mapColor(MapColor.PALE_GREEN)));
    public static final Block COMPRESSED_END_STONE_BRICKS = registerBlock("compressed_end_stone_bricks",
            properties -> new Block(properties.strength(11f)
                    .requiresTool().sounds(BlockSoundGroup.DEEPSLATE_BRICKS).mapColor(MapColor.PALE_YELLOW)));

    public static final Block COMPRESSED_END_STONE_BRICKS_STAIRS = registerBlock("compressed_end_stone_bricks_stairs",
            properties -> new StairsBlock(ModBlocks.COMPRESSED_END_STONE_BRICKS.getDefaultState(),
                    properties.strength(11f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE_BRICKS).mapColor(MapColor.PALE_PURPLE)));
    public static final Block COMPRESSED_END_STONE_BRICKS_SLAB = registerBlock("compressed_end_stone_bricks_slab",
            properties -> new SlabBlock(properties.strength(11f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE_BRICKS).mapColor(MapColor.PALE_YELLOW)));
    public static final Block COMPRESSED_END_STONE_BRICKS_WALL = registerBlock("compressed_end_stone_bricks_wall",
            properties -> new WallBlock(properties.strength(11f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE_BRICKS).mapColor(MapColor.PALE_YELLOW)));

    public static final Block PINLINE_BRICKS_STAIRS = registerBlock("pinline_bricks_stairs",
            properties -> new StairsBlock(ModBlocks.PINLINE_BRICKS.getDefaultState(),
                    properties.strength(6f).requiresTool().sounds(BlockSoundGroup.IRON).mapColor(MapColor.PALE_PURPLE)));
    public static final Block PINLINE_BRICKS_SLAB = registerBlock("pinline_bricks_slab",
            properties -> new SlabBlock(properties.strength(6f).requiresTool().sounds(BlockSoundGroup.IRON).mapColor(MapColor.PALE_PURPLE)));
    public static final Block PINLINE_BRICKS_WALL = registerBlock("pinline_bricks_wall",
            properties -> new WallBlock(properties.strength(6f).requiresTool().sounds(BlockSoundGroup.IRON).mapColor(MapColor.PALE_PURPLE)));

    public static final Block RAW_PINLINE_BRICKS_STAIRS = registerBlock("raw_pinline_bricks_stairs",
            properties -> new StairsBlock(ModBlocks.RAW_PINLINE_BRICKS.getDefaultState(),
                    properties.strength(5f).requiresTool().sounds(BlockSoundGroup.NETHER_ORE).mapColor(MapColor.PALE_GREEN)));
    public static final Block RAW_PINLINE_BRICKS_SLAB = registerBlock("raw_pinline_bricks_slab",
            properties -> new SlabBlock(properties.strength(5f).requiresTool().sounds(BlockSoundGroup.NETHER_ORE).mapColor(MapColor.PALE_GREEN)));
    public static final Block RAW_PINLINE_BRICKS_WALL = registerBlock("raw_pinline_bricks_wall",
            properties -> new WallBlock(properties.strength(5f).requiresTool().sounds(BlockSoundGroup.NETHER_ORE).mapColor(MapColor.PALE_GREEN)));

    public static final Block POLISHED_AMETHYST_STAIRS = registerBlock("polished_amethyst_stairs",
            properties -> new StairsBlock(ModBlocks.POLISHED_AMETHYST_BLOCK.getDefaultState(),
                    properties.strength(3f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PURPLE)));
    public static final Block POLISHED_AMETHYST_SLAB = registerBlock("polished_amethyst_slab",
            properties -> new SlabBlock(properties.strength(3f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PURPLE)));
    public static final Block POLISHED_AMETHYST_WALL = registerBlock("polished_amethyst_wall",
            properties -> new WallBlock(properties.strength(3f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PURPLE)));

    public static final Block AMETHYST_BRICKS_STAIRS = registerBlock("amethyst_bricks_stairs",
            properties -> new StairsBlock(ModBlocks.AMETHYST_BRICKS.getDefaultState(),
                    properties.strength(3f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PURPLE)));
    public static final Block AMETHYST_BRICKS_SLAB = registerBlock("amethyst_bricks_slab",
            properties -> new SlabBlock(properties.strength(3f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PURPLE)));
    public static final Block AMETHYST_BRICKS_WALL = registerBlock("amethyst_bricks_wall",
            properties -> new WallBlock(properties.strength(3f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PURPLE)));

    public static final Block KUNZITE_BRICKS_STAIRS = registerBlock("kunzite_bricks_stairs",
            properties -> new StairsBlock(ModBlocks.KUNZITE_BRICKS.getDefaultState(),
                    properties.strength(3f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PINK)));
    public static final Block KUNZITE_BRICKS_SLAB = registerBlock("kunzite_bricks_slab",
            properties -> new SlabBlock(properties.strength(3f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PINK)));
    public static final Block KUNZITE_BRICKS_WALL = registerBlock("kunzite_bricks_wall",
            properties -> new WallBlock(properties.strength(3f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PINK)));

    public static final Block ELYSIUM_BRICKS_STAIRS = registerBlock("elysium_bricks_stairs",
            properties -> new StairsBlock(ModBlocks.ELYSIUM_BRICKS.getDefaultState(),
                    properties.strength(3f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PINK)));
    public static final Block ELYSIUM_BRICKS_SLAB = registerBlock("elysium_bricks_slab",
            properties -> new SlabBlock(properties.strength(3f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PINK)));
    public static final Block ELYSIUM_BRICKS_WALL = registerBlock("elysium_bricks_wall",
            properties -> new WallBlock(properties.strength(3f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PINK)));

    public static final Block THERMIUM_BRICKS_STAIRS = registerBlock("thermium_bricks_stairs",
            properties -> new StairsBlock(ModBlocks.THERMIUM_BRICKS.getDefaultState(),
                    properties.strength(3f).requiresTool().luminance(state -> 11).sounds(BlockSoundGroup.IRON).mapColor(MapColor.LIME)));
    public static final Block THERMIUM_BRICKS_SLAB = registerBlock("thermium_bricks_slab",
            properties -> new SlabBlock(properties.strength(3f).luminance(state -> 11).requiresTool().sounds(BlockSoundGroup.IRON).mapColor(MapColor.LIME)));
    public static final Block THERMIUM_BRICKS_WALL = registerBlock("thermium_bricks_wall",
            properties -> new WallBlock(properties.strength(3f).luminance(state -> 11).requiresTool().sounds(BlockSoundGroup.IRON).mapColor(MapColor.LIME)));

    public static final Block MEMORY_BRICKS_STAIRS = registerBlock("memory_bricks_stairs",
            properties -> new StairsBlock(ModBlocks.MEMORY_BRICKS.getDefaultState(),
                    properties.strength(3f).requiresTool().luminance(state -> 1).sounds(BlockSoundGroup.GILDED_BLACKSTONE).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final Block MEMORY_BRICKS_SLAB = registerBlock("memory_bricks_slab",
            properties -> new SlabBlock(properties.strength(3f).luminance(state -> 1).requiresTool().sounds(BlockSoundGroup.GILDED_BLACKSTONE).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final Block MEMORY_BRICKS_WALL = registerBlock("memory_bricks_wall",
            properties -> new WallBlock(properties.strength(3f).luminance(state -> 1).requiresTool().sounds(BlockSoundGroup.GILDED_BLACKSTONE).mapColor(MapColor.TERRACOTTA_BLACK)));

    public static final Block CRYSTAL_CHERRY_STAIRS = registerBlock("crystal_cherry_stairs",
            properties -> new StairsBlock(ModBlocks.CRYSTAL_CHERRY_PLANKS.getDefaultState(),
                    properties.strength(2f).luminance(state -> 3).sounds(BlockSoundGroup.CHERRY_WOOD).mapColor(MapColor.PALE_PURPLE)));
    public static final Block CRYSTAL_CHERRY_SLAB = registerBlock("crystal_cherry_slab",
            properties -> new SlabBlock(properties.strength(2f).luminance(state -> 3).sounds(BlockSoundGroup.CHERRY_WOOD).mapColor(MapColor.PALE_PURPLE)));
    public static final Block CRYSTAL_CHERRY_BUTTON = registerBlock("crystal_cherry_button",
            properties -> new ButtonBlock(BlockSetType.CHERRY, 6, properties.strength(2f).noCollision().luminance(state -> 3).sounds(BlockSoundGroup.CHERRY_WOOD).mapColor(MapColor.PALE_PURPLE)));
    public static final Block CRYSTAL_CHERRY_PRESSURE_PLATE = registerBlock("crystal_cherry_pressure_plate",
            properties -> new PressurePlateBlock(BlockSetType.CHERRY, properties.strength(2f).luminance(state -> 3).sounds(BlockSoundGroup.CHERRY_WOOD).mapColor(MapColor.PALE_PURPLE)));
    public static final Block CRYSTAL_CHERRY_FENCE = registerBlock("crystal_cherry_fence",
            properties -> new FenceBlock(properties.strength(2f).luminance(state -> 3).sounds(BlockSoundGroup.CHERRY_WOOD)));
    public static final Block CRYSTAL_CHERRY_FENCE_GATE = registerBlock("crystal_cherry_fence_gate",
            properties -> new FenceGateBlock(WoodType.CHERRY, properties.strength(2f).luminance(state -> 3).sounds(BlockSoundGroup.CHERRY_WOOD).mapColor(MapColor.PALE_PURPLE)));
    public static final Block CRYSTAL_CHERRY_DOOR = registerBlock("crystal_cherry_door",
            properties -> new DoorBlock(BlockSetType.CHERRY, properties.strength(2f).luminance(state -> 3).sounds(BlockSoundGroup.CHERRY_WOOD).nonOpaque()));
    public static final Block CRYSTAL_CHERRY_TRAPDOOR = registerBlock("crystal_cherry_trapdoor",
            properties -> new TrapdoorBlock(BlockSetType.CHERRY, properties.strength(2f).luminance(state -> 3).sounds(BlockSoundGroup.CHERRY_WOOD).nonOpaque()));

    public static final Block CHORUS_STAIRS = registerBlock("chorus_stairs",
            properties -> new StairsBlock(ModBlocks.CHORUS_PLANKS.getDefaultState(),
                    properties.strength(2f).sounds(BlockSoundGroup.CHERRY_WOOD).mapColor(MapColor.PALE_PURPLE)));
    public static final Block CHORUS_SLAB = registerBlock("chorus_slab",
            properties -> new SlabBlock(properties.strength(2f).sounds(BlockSoundGroup.CHERRY_WOOD).mapColor(MapColor.PALE_PURPLE)));
    public static final Block CHORUS_BUTTON = registerBlock("chorus_button",
            properties -> new ButtonBlock(BlockSetType.CHERRY, 6, properties.strength(2f).noCollision().sounds(BlockSoundGroup.CHERRY_WOOD).mapColor(MapColor.PALE_PURPLE)));
    public static final Block CHORUS_PRESSURE_PLATE = registerBlock("chorus_pressure_plate",
            properties -> new PressurePlateBlock(BlockSetType.CHERRY, properties.strength(2f).sounds(BlockSoundGroup.CHERRY_WOOD).mapColor(MapColor.PALE_PURPLE)));
    public static final Block CHORUS_FENCE = registerBlock("chorus_fence",
            properties -> new FenceBlock(properties.strength(2f).sounds(BlockSoundGroup.CHERRY_WOOD)));
    public static final Block CHORUS_FENCE_GATE = registerBlock("chorus_fence_gate",
            properties -> new FenceGateBlock(WoodType.CHERRY, properties.strength(2f).sounds(BlockSoundGroup.CHERRY_WOOD).mapColor(MapColor.PALE_PURPLE)));
    public static final Block CHORUS_DOOR = registerBlock("chorus_door",
            properties -> new DoorBlock(BlockSetType.CHERRY, properties.strength(2f).sounds(BlockSoundGroup.CHERRY_WOOD).nonOpaque()));
    public static final Block CHORUS_TRAPDOOR = registerBlock("chorus_trapdoor",
            properties -> new TrapdoorBlock(BlockSetType.CHERRY, properties.strength(2f).sounds(BlockSoundGroup.CHERRY_WOOD).nonOpaque()));

    public static final Block ASHEN_STAIRS = registerBlock("ashen_stairs",
            properties -> new StairsBlock(ModBlocks.ASHEN_PLANKS.getDefaultState(),
                    properties.strength(1.2f).sounds(BlockSoundGroup.BASALT).mapColor(MapColor.BLACK)));
    public static final Block ASHEN_SLAB = registerBlock("ashen_slab",
            properties -> new SlabBlock(properties.strength(1.2f).sounds(BlockSoundGroup.BASALT).mapColor(MapColor.BLACK)));
    public static final Block ASHEN_BUTTON = registerBlock("ashen_button",
            properties -> new ButtonBlock(BlockSetType.CRIMSON, 6, properties.strength(1.2f).noCollision().sounds(BlockSoundGroup.BASALT).mapColor(MapColor.BLACK)));
    public static final Block ASHEN_PRESSURE_PLATE = registerBlock("ashen_pressure_plate",
            properties -> new PressurePlateBlock(BlockSetType.CRIMSON, properties.strength(1.2f).sounds(BlockSoundGroup.BASALT).mapColor(MapColor.BLACK)));
    public static final Block ASHEN_FENCE = registerBlock("ashen_fence",
            properties -> new FenceBlock(properties.strength(1.2f).sounds(BlockSoundGroup.BASALT)));
    public static final Block ASHEN_FENCE_GATE = registerBlock("ashen_fence_gate",
            properties -> new FenceGateBlock(WoodType.CRIMSON, properties.strength(1.2f).sounds(BlockSoundGroup.BASALT).mapColor(MapColor.BLACK)));
    public static final Block ASHEN_DOOR = registerBlock("ashen_door",
            properties -> new DoorBlock(BlockSetType.CRIMSON, properties.strength(1.2f).sounds(BlockSoundGroup.BASALT).nonOpaque()));
    public static final Block ASHEN_TRAPDOOR = registerBlock("ashen_trapdoor",
            properties -> new TrapdoorBlock(BlockSetType.CRIMSON, properties.strength(1.2f).sounds(BlockSoundGroup.BASALT).nonOpaque()));

    public static final Block DISPLAY = registerBlock("display",
            properties -> new DisplayBlock(properties.strength(2f).luminance(state -> 4).nonOpaque().mapColor(MapColor.STONE_GRAY)));
    public static final Block THERMIUM_BLASTER = registerBlock("thermium_blaster",
            properties -> new ThermiumBlasterBlock(properties.strength(2f).requiresTool().sounds(BlockSoundGroup.IRON).luminance(state -> 6).mapColor(MapColor.PURPLE)));

    public static final Block AMETHYST_PARTERS = registerBlock("amethyst_parters",
            properties -> new FlowerBlock(StatusEffects.STRENGTH, 5, properties.strength(0f)
                    .offset(AbstractBlock.OffsetType.XZ).noCollision().nonOpaque().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block KUNZITE_LOVELILY = registerBlock("kunzite_lovelily",
            properties -> new FlowerBlock(StatusEffects.ABSORPTION, 20, properties
                    .strength(0f).offset(AbstractBlock.OffsetType.XZ).noCollision().nonOpaque().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block ELYSIAN_SKYBERRY = registerBlock("elysian_skyberry",
            properties -> new FlowerBlock(StatusEffects.HEALTH_BOOST, 20, properties
                    .strength(0f).offset(AbstractBlock.OffsetType.XZ).noCollision().nonOpaque().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block THERMIUM_WILTBORN = registerBlock("thermium_wiltborn",
            properties -> new FlowerBlock(StatusEffects.POISON, 60, properties
                    .strength(0f).offset(AbstractBlock.OffsetType.XZ).luminance(state -> 3).noCollision().nonOpaque().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block MEMORIA_BOURPEER = registerBlock("memoria_bourpeer",
            properties -> new FlowerBlock(StatusEffects.CONDUIT_POWER, 60, properties
                    .strength(0f).offset(AbstractBlock.OffsetType.XZ).luminance(state -> 7).noCollision().nonOpaque().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block POTTED_AMETHYST_PARTERS = registerBlockWithoutBlockItem("potted_amethyst_parters",
            properties -> new FlowerPotBlock(ModBlocks.AMETHYST_PARTERS, properties.strength(0f).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block POTTED_KUNZITE_LOVELILY = registerBlockWithoutBlockItem("potted_kunzite_lovelily",
            properties -> new FlowerPotBlock(ModBlocks.KUNZITE_LOVELILY, properties.strength(0f).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block POTTED_ELYSIAN_SKYBERRY = registerBlockWithoutBlockItem("potted_elysian_skyberry",
            properties -> new FlowerPotBlock(ModBlocks.ELYSIAN_SKYBERRY, properties.strength(0f).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block POTTED_THERMIUM_WILTBORN = registerBlockWithoutBlockItem("potted_thermium_wiltborn",
            properties -> new FlowerPotBlock(ModBlocks.THERMIUM_WILTBORN, properties.strength(0f).nonOpaque().luminance(state -> 3).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block POTTED_MEMORIA_BOURPEER = registerBlockWithoutBlockItem("potted_memoria_bourpeer",
            properties -> new FlowerPotBlock(ModBlocks.MEMORIA_BOURPEER, properties.strength(0f).nonOpaque().luminance(state -> 7).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block POTTED_CRYSTAL_CHERRY_SAPLING = registerBlockWithoutBlockItem("potted_crystal_cherry_sapling",
            properties -> new FlowerPotBlock(ModBlocks.CRYSTAL_CHERRY_SAPLING, properties.strength(0f).nonOpaque().luminance(state -> 4).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block POTTED_CHORUS_SAPLING = registerBlockWithoutBlockItem("potted_chorus_sapling",
            properties -> new FlowerPotBlock(ModBlocks.CHORUS_SAPLING, properties.strength(0f).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block POTTED_SNOWY_SPRUCE_SAPLING = registerBlockWithoutBlockItem("potted_snowy_spruce_sapling",
            properties -> new FlowerPotBlock(ModBlocks.SNOWY_SPRUCE_SAPLING, properties.strength(0f).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block SMALL_END_GRASS = registerBlock("small_end_grass",
            properties -> new ModGrassBlock(ModTags.Blocks.END_STONE, properties.strength(0f).replaceable()
                    .offset(AbstractBlock.OffsetType.XZ).noCollision().nonOpaque().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY),
                    2, 2, 14, 3, 14));
    public static final Block MEDIUM_END_GRASS = registerBlock("medium_end_grass",
            properties -> new ModGrassBlock(ModTags.Blocks.END_STONE, properties.strength(0f).replaceable()
                    .offset(AbstractBlock.OffsetType.XZ).noCollision().nonOpaque().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY),
                    3, 3, 13, 7, 13));
    public static final Block LARGE_END_GRASS = registerBlock("large_end_grass",
            properties -> new ModGrassBlock(ModTags.Blocks.END_STONE, properties.strength(0f).replaceable()
                    .offset(AbstractBlock.OffsetType.XZ).noCollision().nonOpaque().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY),
                    2, 2, 14, 10, 14));
    public static final Block CHORUS_LILY = registerBlock("chorus_lily",
            properties -> new ModGrassBlock(ModTags.Blocks.END_STONE, properties.strength(0f)
                    .offset(AbstractBlock.OffsetType.XZ).noCollision().nonOpaque().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY),
                    5, 5, 11, 13, 11));

    public static final Block GEM_BERRY_BUSH = registerBlockWithoutBlockItem("gem_berry_bush",
            properties -> new GemBerryBushBlock(properties.mapColor(MapColor.DARK_GREEN).ticksRandomly()
                    .noCollision().nonOpaque().sounds(BlockSoundGroup.SWEET_BERRY_BUSH).luminance(GemBerryBushBlock::getLuminance).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block HAZEWEAVER_PLANT = registerBlockWithoutBlockItem("hazeweaver_plant",
            properties -> new FlowerBlock(StatusEffects.SATURATION, 2, properties.mapColor(MapColor.GREEN)
                    .noCollision().nonOpaque().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).luminance(state -> 1).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block POTTED_HAZEWEAVER_PLANT = registerBlockWithoutBlockItem("potted_hazeweaver_plant",
            properties -> new FlowerPotBlock(ModBlocks.HAZEWEAVER_PLANT, properties.strength(0f).nonOpaque().luminance(state -> 1).pistonBehavior(PistonBehavior.DESTROY)));


    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> function) {
        Block toRegister = function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(JirniysPinkStuff.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(Registries.BLOCK, Identifier.of(JirniysPinkStuff.MOD_ID, name), toRegister);
    }

    private static Block registerBlockWithoutBlockItem(String name, Function<AbstractBlock.Settings, Block> function) {
        return Registry.register(Registries.BLOCK, Identifier.of(JirniysPinkStuff.MOD_ID, name),
                function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(JirniysPinkStuff.MOD_ID, name)))));
    }

    private static void registerBlockItem(String name, Block block) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(JirniysPinkStuff.MOD_ID, name));
        BlockItem item = new BlockItem(block, new Item.Settings().registryKey(key));
        Registry.register(Registries.ITEM, key, item);
    }

    public static void registerModBlocks() {
        JirniysPinkStuff.LOGGER.info("Registering Mod Blocks for " + JirniysPinkStuff.MOD_ID);
    }
}
