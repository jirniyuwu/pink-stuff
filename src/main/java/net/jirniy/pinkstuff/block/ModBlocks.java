package net.jirniy.pinkstuff.block;

import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.block.custom.*;
import net.jirniy.pinkstuff.particle.ModParticles;
import net.jirniy.pinkstuff.util.ModTags;
import net.jirniy.pinkstuff.world.ModConfiguredFeatures;
import net.jirniy.pinkstuff.world.features.ModSaplingGenerator;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.ColorCode;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import java.util.function.Function;

public class ModBlocks {
    public static final Block STYXIA_PORTAL = registerBlockWithoutBlockItem("styxia_portal",
            properties -> new StyxiaPortalBlock(properties.strength(-1).noCollision().nonOpaque().pistonBehavior(PistonBehavior.BLOCK)
                    .luminance(state -> 15).sounds(BlockSoundGroup.GLASS).mapColor(DyeColor.BLACK)));
    public static final Block STYXIA_PORTAL_FRAME = registerBlock("styxia_portal_frame",
            properties -> new StyxiaPortalFrameBlock(properties.strength(100, -1).nonOpaque().pistonBehavior(PistonBehavior.BLOCK)
                    .sounds(BlockSoundGroup.GLASS).mapColor(DyeColor.BLACK)));

    public static final Block CRAWLER_STONE = registerBlock("crawler_stone",
            properties -> new CrawlerBlock(properties.strength(0.8f).pistonBehavior(PistonBehavior.DESTROY)
                    .sounds(BlockSoundGroup.SUSPICIOUS_GRAVEL).mapColor(MapColor.STONE_GRAY)));
    public static final Block CRAWLER_DEEPSLATE = registerBlock("crawler_deepslate",
            properties -> new CrawlerBlock(properties.strength(1.2f).pistonBehavior(PistonBehavior.DESTROY)
                    .sounds(BlockSoundGroup.SUSPICIOUS_GRAVEL).mapColor(MapColor.DEEPSLATE_GRAY)));
    public static final Block CRAWLER_NETHERRACK = registerBlock("crawler_netherrack",
            properties -> new CrawlerBlock(properties.strength(0.6f).pistonBehavior(PistonBehavior.DESTROY)
                    .sounds(BlockSoundGroup.SUSPICIOUS_GRAVEL).mapColor(MapColor.DULL_RED)));
    public static final Block CRAWLER_STYXSTONE = registerBlock("crawler_styxstone",
            properties -> new CrawlerBlock(properties.strength(1f).pistonBehavior(PistonBehavior.DESTROY)
                    .sounds(BlockSoundGroup.SUSPICIOUS_GRAVEL).mapColor(MapColor.PALE_PURPLE)));
    public static final Block CRAWLER_COMPRESSED_STYXSTONE = registerBlock("crawler_compressed_styxstone",
            properties -> new CrawlerBlock(properties.strength(1.4f).pistonBehavior(PistonBehavior.DESTROY)
                    .sounds(BlockSoundGroup.SUSPICIOUS_GRAVEL).mapColor(MapColor.PURPLE)));

    public static final Block PINK_ICE = registerBlock("pink_ice",
            properties -> new TranslucentBlock(properties.strength(8f).slipperiness(1.01f).nonOpaque()
                    .sounds(BlockSoundGroup.GLASS).mapColor(MapColor.DULL_PINK)));
    public static final Block BLACK_GOOP = registerBlock("black_goop",
            properties -> new BlackGoopBlock(properties.strength(4f).ticksRandomly()
                    .sounds(BlockSoundGroup.HONEY).mapColor(MapColor.BLACK)));
    public static final Block CORRUPT_ORE = registerBlock("corrupt_ore",
            properties -> new BlackGoopBlock(properties.strength(9f).ticksRandomly()
                    .sounds(BlockSoundGroup.HONEY).mapColor(MapColor.BLACK)));
    public static final Block STYXIAN_SOIL = registerBlock("styxian_soil",
            properties -> new Block(properties.strength(0.8f)
                    .sounds(BlockSoundGroup.SOUL_SOIL).mapColor(MapColor.DARK_AQUA)));
    public static final Block STYXMOSS = registerBlock("styxmoss",
            properties -> new StyxmossBlock(ModConfiguredFeatures.STYXMOSS_PATCH_BONEMEAL_KEY, properties.strength(0.7f)
                    .sounds(BlockSoundGroup.MOSS_BLOCK).mapColor(MapColor.DARK_AQUA)));
    public static final Block STYXMOSS_CARPET = registerBlock("styxmoss_carpet",
            properties -> new CarpetBlock(properties.strength(0.3f)
                    .sounds(BlockSoundGroup.MOSS_BLOCK).mapColor(MapColor.DARK_AQUA)));
    public static final Block STYXSTONE = registerBlock("styxstone",
            properties -> new Block(properties.strength(1.7f).requiresTool()
                    .sounds(BlockSoundGroup.POLISHED_DEEPSLATE).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final Block POLISHED_STYXSTONE = registerBlock("polished_styxstone",
            properties -> new Block(properties.strength(1.7f).requiresTool()
                    .sounds(BlockSoundGroup.POLISHED_DEEPSLATE).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final Block MABRIZE = registerBlock("mabrize",
            properties -> new Block(properties.strength(1.4f).requiresTool()
                    .sounds(BlockSoundGroup.POLISHED_TUFF).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block POLISHED_MABRIZE = registerBlock("polished_mabrize",
            properties -> new Block(properties.strength(1.4f).requiresTool()
                    .sounds(BlockSoundGroup.POLISHED_TUFF).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block AMETANE = registerBlock("ametane",
            properties -> new Block(properties.strength(1.4f).requiresTool()
                    .sounds(BlockSoundGroup.POLISHED_TUFF).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block POLISHED_AMETANE = registerBlock("polished_ametane",
            properties -> new Block(properties.strength(1.4f).requiresTool()
                    .sounds(BlockSoundGroup.POLISHED_TUFF).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block COBBLED_STYXSTONE = registerBlock("cobbled_styxstone",
            properties -> new Block(properties.strength(2f).requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final Block MOSSY_COBBLED_STYXSTONE = registerBlock("mossy_cobbled_styxstone",
            properties -> new Block(properties.strength(2f).requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final Block COMPRESSED_STYXSTONE = registerBlock("compressed_styxstone",
            properties -> new Block(properties.strength(4f).requiresTool()
                    .sounds(BlockSoundGroup.POLISHED_DEEPSLATE).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final Block POLISHED_COMPRESSED_STYXSTONE = registerBlock("polished_compressed_styxstone",
            properties -> new Block(properties.strength(4f).requiresTool()
                    .sounds(BlockSoundGroup.POLISHED_DEEPSLATE).mapColor(MapColor.TERRACOTTA_BLACK)));

    public static final Block ASH_BLOCK = registerBlock("ash_block",
            properties -> new SandBlock(new ColorCode(0x494E52), properties.strength(0.6f)
                    .sounds(BlockSoundGroup.SOUL_SAND).mapColor(MapColor.STONE_GRAY)));

    public static final Block PINK_SAND = registerBlock("pink_sand",
            properties -> new SandBlock(new ColorCode(0xB561B5), properties.strength(1f)
                    .sounds(BlockSoundGroup.SOUL_SAND).mapColor(MapColor.PALE_PURPLE)));
    public static final Block PINK_SANDSTONE = registerBlock("pink_sandstone",
            properties -> new Block(properties.strength(2f).requiresTool()
                    .sounds(BlockSoundGroup.NETHERRACK).mapColor(MapColor.PALE_PURPLE)));
    public static final Block CUT_PINK_SANDSTONE = registerBlock("cut_pink_sandstone",
            properties -> new Block(properties.strength(2f).requiresTool()
                    .sounds(BlockSoundGroup.NETHERRACK).mapColor(MapColor.PALE_PURPLE)));
    public static final Block CHISELED_PINK_SANDSTONE = registerBlock("chiseled_pink_sandstone",
            properties -> new Block(properties.strength(2f).requiresTool()
                    .sounds(BlockSoundGroup.NETHERRACK).mapColor(MapColor.PALE_PURPLE)));
    public static final Block SMOOTH_PINK_SANDSTONE = registerBlock("smooth_pink_sandstone",
            properties -> new Block(properties.strength(2f).requiresTool()
                    .sounds(BlockSoundGroup.NETHERRACK).mapColor(MapColor.PALE_PURPLE)));
    public static final Block PINK_SANDSTONE_STAIRS = registerBlock("pink_sandstone_stairs",
            properties -> new StairsBlock(ModBlocks.PINK_SANDSTONE.getDefaultState(),
                    properties.strength(2f).requiresTool().sounds(BlockSoundGroup.NETHERRACK).mapColor(MapColor.PALE_PURPLE)));
    public static final Block PINK_SANDSTONE_SLAB = registerBlock("pink_sandstone_slab",
            properties -> new SlabBlock(properties.strength(2f).requiresTool().sounds(BlockSoundGroup.NETHERRACK).mapColor(MapColor.PALE_PURPLE)));
    public static final Block PINK_SANDSTONE_WALL = registerBlock("pink_sandstone_wall",
            properties -> new WallBlock(properties.strength(2f).requiresTool().sounds(BlockSoundGroup.NETHERRACK).mapColor(MapColor.PALE_PURPLE)));
    public static final Block SMOOTH_PINK_SANDSTONE_STAIRS = registerBlock("smooth_pink_sandstone_stairs",
            properties -> new StairsBlock(ModBlocks.SMOOTH_PINK_SANDSTONE.getDefaultState(),
                    properties.strength(2f).requiresTool().sounds(BlockSoundGroup.NETHERRACK).mapColor(MapColor.PALE_PURPLE)));
    public static final Block SMOOTH_PINK_SANDSTONE_SLAB = registerBlock("smooth_pink_sandstone_slab",
            properties -> new SlabBlock(properties.strength(2f).requiresTool().sounds(BlockSoundGroup.NETHERRACK).mapColor(MapColor.PALE_PURPLE)));
    public static final Block CUT_PINK_SANDSTONE_SLAB = registerBlock("cut_pink_sandstone_slab",
            properties -> new SlabBlock(properties.strength(2f).requiresTool().sounds(BlockSoundGroup.NETHERRACK).mapColor(MapColor.PALE_PURPLE)));

    public static final Block STYXGRASS = registerBlock("styxgrass",
            properties -> new ModGrassBlock(BlockTags.DIRT, properties.strength(0f).replaceable()
                    .offset(AbstractBlock.OffsetType.XZ).noCollision().nonOpaque().sounds(BlockSoundGroup.MOSS_CARPET).pistonBehavior(PistonBehavior.DESTROY),
                    2, 2, 14, 8, 14));
    public static final Block HANGING_STYXGRASS = registerBlock("hanging_styxgrass",
            properties -> new HangingStyxgrassBlock(properties.strength(0f).replaceable()
                    .noCollision().nonOpaque().sounds(BlockSoundGroup.MOSS_CARPET).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block HANGING_STYXMOSS = registerBlock("hanging_styxmoss",
            properties -> new HangingStyxgrassBlock(properties.strength(0f).replaceable()
                    .noCollision().nonOpaque().sounds(BlockSoundGroup.MOSS_CARPET).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block STYXMOSS_VINE = registerBlock("styxmoss_vine",
            properties -> new VineBlock(properties.mapColor(MapColor.PALE_PURPLE).replaceable().noCollision()
                    .ticksRandomly().strength(0.2F).sounds(BlockSoundGroup.MOSS_CARPET).burnable().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block CORRUPT_ROOTS = registerBlock("corrupt_roots",
            properties -> new CorruptRootsBlock(ModTags.Blocks.CORRUPT_BLOCKS, properties.strength(0f).replaceable()
                    .offset(AbstractBlock.OffsetType.XZ).noCollision().nonOpaque().sounds(BlockSoundGroup.HONEY).pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block STYXIAN_AMETHYST_ORE = registerBlock("styxian_amethyst_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(1, 3),
                    properties.strength(3f).requiresTool().sounds(BlockSoundGroup.POLISHED_DEEPSLATE).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block COMPRESSED_STYXIAN_AMETHYST_ORE = registerBlock("compressed_styxian_amethyst_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(1, 3),
                    properties.strength(5f).requiresTool().sounds(BlockSoundGroup.POLISHED_DEEPSLATE).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block STYXIAN_STYXCOAL_ORE = registerBlock("styxian_styxcoal_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(1, 3),
                    properties.strength(2.8f).requiresTool().sounds(BlockSoundGroup.POLISHED_DEEPSLATE).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block COMPRESSED_STYXIAN_STYXCOAL_ORE = registerBlock("compressed_styxian_styxcoal_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(1, 3),
                    properties.strength(4.8f).requiresTool().sounds(BlockSoundGroup.POLISHED_DEEPSLATE).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block STYXIAN_LAPIS_ORE = registerBlock("styxian_lapis_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(3, 5),
                    properties.strength(4.8f).requiresTool().sounds(BlockSoundGroup.POLISHED_DEEPSLATE).mapColor(MapColor.LAPIS_BLUE)));
    public static final Block COMPRESSED_STYXIAN_LAPIS_ORE = registerBlock("compressed_styxian_lapis_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(3, 5),
                    properties.strength(6.8f).requiresTool().sounds(BlockSoundGroup.POLISHED_DEEPSLATE).mapColor(MapColor.LAPIS_BLUE)));
    public static final Block STYXIAN_SUNGAZE_ORE = registerBlock("styxian_sungaze_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(5, 7),
                    properties.strength(5.8f).requiresTool().sounds(BlockSoundGroup.POLISHED_DEEPSLATE).mapColor(MapColor.YELLOW)));
    public static final Block COMPRESSED_STYXIAN_SUNGAZE_ORE = registerBlock("compressed_styxian_sungaze_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(5, 7),
                    properties.strength(7.8f).requiresTool().sounds(BlockSoundGroup.POLISHED_DEEPSLATE).mapColor(MapColor.YELLOW)));
    public static final Block STYXCOAL_BLOCK = registerBlock("styxcoal_block",
            properties -> new Block(properties.strength(5f).requiresTool()
                    .sounds(BlockSoundGroup.NETHERRACK).mapColor(MapColor.DARK_DULL_PINK)));
    public static final Block SUNGAZE_BLOCK = registerBlock("sungaze_block",
            properties -> new Block(properties.strength(6f).requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.YELLOW)));

    public static final Block DIAMOND_CLUMP = registerBlock("diamond_clump",
            properties -> new ModMultifaceBlock(properties.breakInstantly().nonOpaque().noCollision()
                    .sounds(BlockSoundGroup.AMETHYST_CLUSTER).mapColor(MapColor.DIAMOND_BLUE)));
    public static final Block EMERALD_CLUMP = registerBlock("emerald_clump",
            properties -> new ModMultifaceBlock(properties.breakInstantly().nonOpaque().noCollision()
                    .sounds(BlockSoundGroup.AMETHYST_CLUSTER).mapColor(MapColor.EMERALD_GREEN)));
    public static final Block AMETHYST_CLUMP = registerBlock("amethyst_clump",
            properties -> new ModMultifaceBlock(properties.breakInstantly().nonOpaque().noCollision()
                    .sounds(BlockSoundGroup.AMETHYST_CLUSTER).mapColor(MapColor.PURPLE)));
    public static final Block QUARTZ_CLUMP = registerBlock("quartz_clump",
            properties -> new ModMultifaceBlock(properties.breakInstantly().nonOpaque().noCollision()
                    .sounds(BlockSoundGroup.NETHER_ORE).mapColor(MapColor.TERRACOTTA_WHITE)));
    public static final Block CORRUPTION_CLUMP = registerBlockWithoutBlockItem("corruption_clump",
            properties -> new ModMultifaceBlock(properties.breakInstantly().nonOpaque().noCollision()
                    .sounds(BlockSoundGroup.HONEY).mapColor(MapColor.DARK_RED)));

    public static final Block COMPRESSED_END_STONE = registerBlock("compressed_end_stone",
            properties -> new Block(properties.strength(10f)
                    .requiresTool().sounds(BlockSoundGroup.DEEPSLATE).mapColor(MapColor.PALE_YELLOW)));

    public static final Block MOONSTEEL_BLOCK = registerBlock("moonsteel_block",
            properties -> new Block(properties.strength(7f)
                    .requiresTool().sounds(BlockSoundGroup.IRON).mapColor(MapColor.DARK_AQUA)));
    public static final Block RAW_MOONSTEEL_BLOCK = registerBlock("raw_moonsteel_block",
            properties -> new Block(properties.strength(6f)
                    .requiresTool().sounds(BlockSoundGroup.NETHERRACK).mapColor(MapColor.DARK_AQUA)));
    public static final Block STYXIAN_MOONSTEEL_ORE = registerBlock("styxian_moonsteel_ore",
            properties -> new Block(properties.strength(3.2f).requiresTool()
                    .sounds(BlockSoundGroup.POLISHED_DEEPSLATE).mapColor(MapColor.BLACK)));
    public static final Block COMPRESSED_STYXIAN_MOONSTEEL_ORE = registerBlock("compressed_styxian_moonsteel_ore",
            properties -> new Block(properties.strength(5.2f).requiresTool()
                    .sounds(BlockSoundGroup.POLISHED_DEEPSLATE).mapColor(MapColor.BLACK)));

    public static final Block CERILLE_BLOCK = registerBlock("cerille_block",
            properties -> new Block(properties.strength(12f)
                    .requiresTool().sounds(BlockSoundGroup.IRON).mapColor(MapColor.DARK_CRIMSON)));

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
            properties -> new ModMultifaceBlock(properties.breakInstantly().nonOpaque().noCollision()
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
            properties -> new ModMultifaceBlock(properties.breakInstantly().nonOpaque().noCollision()
                    .luminance(state -> ModMultifaceBlock.luminanceSupplier(state, 1))
                    .sounds(BlockSoundGroup.IRON).mapColor(MapColor.LIME)));

    public static final Block THERMIUM_ROD = registerBlock("thermium_rod",
            properties -> new ModRodBlock(null, properties.breakInstantly().luminance(state -> 15)
                    .requiresTool().sounds(BlockSoundGroup.IRON).mapColor(MapColor.LIME)));

    public static final Block NETHER_SULFUR_ORE = registerBlock("nether_sulfur_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(1, 3),
                    properties.strength(3f).requiresTool().mapColor(MapColor.DULL_RED).sounds(BlockSoundGroup.NETHER_ORE)));
    public static final Block STYXIAN_SULFUR_ORE = registerBlock("styxian_sulfur_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(1, 3),
                    properties.strength(2.4f).requiresTool().mapColor(MapColor.PALE_PURPLE).sounds(BlockSoundGroup.POLISHED_DEEPSLATE)));
    public static final Block COMPRESSED_STYXIAN_SULFUR_ORE = registerBlock("compressed_styxian_sulfur_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(1, 3),
                    properties.strength(4.6f).requiresTool().mapColor(MapColor.PURPLE).sounds(BlockSoundGroup.POLISHED_DEEPSLATE)));
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
    public static final Block GLOWING_CHERRY_LEAVES = registerBlock("glowing_cherry_leaves",
            properties -> new UntintedParticleLeavesBlock(0.1f, ParticleTypes.CHERRY_LEAVES, properties
                    .mapColor(MapColor.PINK).strength(0.2F).ticksRandomly().luminance(state -> 8)
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

    public static final Block KEAPHE_LOG = registerBlock("keaphe_log",
            properties -> new PillarBlock(properties
                    .strength(2.0F).sounds(BlockSoundGroup.CHERRY_WOOD).burnable().mapColor(MapColor.DARK_DULL_PINK)));
    public static final Block KEAPHE_WOOD = registerBlock("keaphe_wood",
            properties -> new PillarBlock(properties
                    .strength(2.0F).sounds(BlockSoundGroup.CHERRY_WOOD).burnable().mapColor(MapColor.DARK_DULL_PINK)));
    public static final Block STRIPPED_KEAPHE_LOG = registerBlock("stripped_keaphe_log",
            properties -> new PillarBlock(properties
                    .strength(2.0F).sounds(BlockSoundGroup.CHERRY_WOOD).burnable().mapColor(MapColor.PALE_GREEN)));
    public static final Block STRIPPED_KEAPHE_WOOD = registerBlock("stripped_keaphe_wood",
            properties -> new PillarBlock(properties
                    .strength(2.0F).sounds(BlockSoundGroup.CHERRY_WOOD).burnable().mapColor(MapColor.PALE_GREEN)));

    public static final Block KEAPHE_PLANKS = registerBlock("keaphe_planks",
            properties -> new Block(properties.strength(2f).sounds(BlockSoundGroup.CHERRY_WOOD).mapColor(MapColor.PALE_GREEN)));
    public static final Block KEAPHE_LEAVES = registerBlock("keaphe_leaves",
            properties -> new UntintedParticleLeavesBlock(0.1f, ModParticles.CHORUS_PETAL_PARTICLE, properties
                    .mapColor(MapColor.PALE_PURPLE).strength(0.2F).ticksRandomly()
                    .sounds(BlockSoundGroup.CHERRY_LEAVES).nonOpaque()
                    .allowsSpawning(Blocks::canSpawnOnLeaves).suffocates(Blocks::never)
                    .blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY)
                    .solidBlock(Blocks::never)));
    public static final Block FLOWERING_KEAPHE_LEAVES = registerBlock("flowering_keaphe_leaves",
            properties -> new UntintedParticleLeavesBlock(0.1f, ModParticles.CHORUS_PETAL_PARTICLE, properties
                    .mapColor(MapColor.PALE_PURPLE).strength(0.2F).ticksRandomly()
                    .sounds(BlockSoundGroup.CHERRY_LEAVES).nonOpaque()
                    .allowsSpawning(Blocks::canSpawnOnLeaves).suffocates(Blocks::never)
                    .blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY)
                    .solidBlock(Blocks::never)));

    public static final Block KEAPHE_SAPLING = registerBlock("keaphe_sapling",
            properties -> new ModSaplingBlock(ModSaplingGenerator.KEAPHE, properties.mapColor(MapColor.DARK_DULL_PINK)
                    .noCollision().ticksRandomly().breakInstantly()
                    .sounds(BlockSoundGroup.CHERRY_LEAVES).pistonBehavior(PistonBehavior.DESTROY), BlockTags.DIRT));

    public static final Block AMETHYST_ROD = registerBlock("amethyst_rod",
            properties -> new ModRodBlock(null, properties.breakInstantly().luminance(state -> 15)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_CLUSTER).mapColor(MapColor.PURPLE)));
    public static final Block ELYSIUM_ROD = registerBlock("elysium_rod",
            properties -> new ModRodBlock(null, properties.breakInstantly().luminance(state -> 15)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PINK)));

    public static final Block AMETHYST_LAMP = registerBlock("amethyst_lamp",
            properties -> new AmethystLampBlock(properties.strength(2.5f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PURPLE).luminance(AmethystLampBlock::getLuminance)));
    public static final Block GLOWING_AMETHYST = registerBlock("glowing_amethyst",
            properties -> new Block(properties.strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PURPLE).luminance(state -> 4)));
    public static final Block AMETHYST_BRICKS = registerBlock("amethyst_bricks",
            properties -> new Block(properties.strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PURPLE)));
    public static final Block POLISHED_AMETHYST_BLOCK = registerBlock("polished_amethyst_block",
            properties -> new Block(properties.strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PURPLE)));
    public static final Block AMETHYST_TILES = registerBlock("amethyst_tiles",
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
    public static final Block MOONSTEEL_BRICKS = registerBlock("moonsteel_bricks",
            properties -> new Block(properties.strength(6f)
                    .requiresTool().sounds(BlockSoundGroup.IRON).mapColor(MapColor.DARK_AQUA)));
    public static final Block MOONSTEEL_BULB = registerBlock("moonsteel_bulb",
            properties -> new Block(properties.strength(6f).luminance(state -> 13)
                    .requiresTool().sounds(BlockSoundGroup.IRON).mapColor(MapColor.DARK_AQUA)));
    public static final Block CHISELED_MOONSTEEL_BRICKS = registerBlock("chiseled_moonsteel_bricks",
            properties -> new Block(properties.strength(6f)
                    .requiresTool().sounds(BlockSoundGroup.IRON).mapColor(MapColor.DARK_AQUA)));
    public static final Block CERILLE_BRICKS = registerBlock("cerille_bricks",
            properties -> new Block(properties.strength(6f)
                    .requiresTool().sounds(BlockSoundGroup.IRON).mapColor(MapColor.DARK_CRIMSON)));
    public static final Block CERILLE_BULB = registerBlock("cerille_bulb",
            properties -> new Block(properties.strength(6f).luminance(state -> 15)
                    .requiresTool().sounds(BlockSoundGroup.IRON).mapColor(MapColor.DARK_CRIMSON)));
    public static final Block CHISELED_CERILLE_BRICKS = registerBlock("chiseled_cerille_bricks",
            properties -> new Block(properties.strength(6f)
                    .requiresTool().sounds(BlockSoundGroup.IRON).mapColor(MapColor.DARK_CRIMSON)));
    public static final Block COMPRESSED_END_STONE_BRICKS = registerBlock("compressed_end_stone_bricks",
            properties -> new Block(properties.strength(11f)
                    .requiresTool().sounds(BlockSoundGroup.DEEPSLATE_BRICKS).mapColor(MapColor.PALE_YELLOW)));
    public static final Block STYXSTONE_BRICKS = registerBlock("styxstone_bricks",
            properties -> new Block(properties.strength(2f).requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE_TILES).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final Block COMPRESSED_STYXSTONE_BRICKS = registerBlock("compressed_styxstone_bricks",
            properties -> new Block(properties.strength(5f).requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE_TILES).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final Block MABRIZE_BRICKS = registerBlock("mabrize_bricks",
            properties -> new Block(properties.strength(2f).requiresTool()
                    .sounds(BlockSoundGroup.TUFF_BRICKS).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block AMETANE_BRICKS = registerBlock("ametane_bricks",
            properties -> new Block(properties.strength(2f).requiresTool()
                    .sounds(BlockSoundGroup.TUFF_BRICKS).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block SUNGAZE_BRICKS = registerBlock("sungaze_bricks",
            properties -> new Block(properties.strength(6f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.YELLOW)));
    public static final Block SUNGAZE_BULB = registerBlock("sungaze_bulb",
            properties -> new Block(properties.strength(6f).luminance(state -> 15)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.YELLOW)));
    public static final Block CHISELED_SUNGAZE_BRICKS = registerBlock("chiseled_sungaze_bricks",
            properties -> new Block(properties.strength(6f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.YELLOW)));

    public static final Block COBBLED_STYXSTONE_STAIRS = registerBlock("cobbled_styxstone_stairs",
            properties -> new StairsBlock(ModBlocks.COBBLED_STYXSTONE.getDefaultState(),
                    properties.strength(2f).requiresTool().sounds(BlockSoundGroup.POLISHED_DEEPSLATE).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final Block COBBLED_STYXSTONE_SLAB = registerBlock("cobbled_styxstone_slab",
            properties -> new SlabBlock(properties.strength(2f).requiresTool().sounds(BlockSoundGroup.POLISHED_DEEPSLATE).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final Block COBBLED_STYXSTONE_WALL = registerBlock("cobbled_styxstone_wall",
            properties -> new WallBlock(properties.strength(2f).requiresTool().sounds(BlockSoundGroup.POLISHED_DEEPSLATE).mapColor(MapColor.TERRACOTTA_BLACK)));

    public static final Block MOSSY_COBBLED_STYXSTONE_STAIRS = registerBlock("mossy_cobbled_styxstone_stairs",
            properties -> new StairsBlock(ModBlocks.MOSSY_COBBLED_STYXSTONE.getDefaultState(),
                    properties.strength(2f).requiresTool().sounds(BlockSoundGroup.POLISHED_DEEPSLATE).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final Block MOSSY_COBBLED_STYXSTONE_SLAB = registerBlock("mossy_cobbled_styxstone_slab",
            properties -> new SlabBlock(properties.strength(2f).requiresTool().sounds(BlockSoundGroup.POLISHED_DEEPSLATE).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final Block MOSSY_COBBLED_STYXSTONE_WALL = registerBlock("mossy_cobbled_styxstone_wall",
            properties -> new WallBlock(properties.strength(2f).requiresTool().sounds(BlockSoundGroup.POLISHED_DEEPSLATE).mapColor(MapColor.TERRACOTTA_BLACK)));

    public static final Block STYXSTONE_BRICKS_STAIRS = registerBlock("styxstone_bricks_stairs",
            properties -> new StairsBlock(ModBlocks.STYXSTONE_BRICKS.getDefaultState(),
                    properties.strength(2f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE_TILES).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final Block STYXSTONE_BRICKS_SLAB = registerBlock("styxstone_bricks_slab",
            properties -> new SlabBlock(properties.strength(2f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE_TILES).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final Block STYXSTONE_BRICKS_WALL = registerBlock("styxstone_bricks_wall",
            properties -> new WallBlock(properties.strength(2f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE_TILES).mapColor(MapColor.TERRACOTTA_BLACK)));

    public static final Block POLISHED_STYXSTONE_STAIRS = registerBlock("polished_styxstone_stairs",
            properties -> new StairsBlock(ModBlocks.POLISHED_STYXSTONE.getDefaultState(),
                    properties.strength(2f).requiresTool().sounds(BlockSoundGroup.POLISHED_DEEPSLATE).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final Block POLISHED_STYXSTONE_SLAB = registerBlock("polished_styxstone_slab",
            properties -> new SlabBlock(properties.strength(2f).requiresTool().sounds(BlockSoundGroup.POLISHED_DEEPSLATE).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final Block POLISHED_STYXSTONE_WALL = registerBlock("polished_styxstone_wall",
            properties -> new WallBlock(properties.strength(2f).requiresTool().sounds(BlockSoundGroup.POLISHED_DEEPSLATE).mapColor(MapColor.TERRACOTTA_BLACK)));

    public static final Block COMPRESSED_STYXSTONE_BRICKS_STAIRS = registerBlock("compressed_styxstone_bricks_stairs",
            properties -> new StairsBlock(ModBlocks.COMPRESSED_STYXSTONE_BRICKS.getDefaultState(),
                    properties.strength(5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE_TILES).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final Block COMPRESSED_STYXSTONE_BRICKS_SLAB = registerBlock("compressed_styxstone_bricks_slab",
            properties -> new SlabBlock(properties.strength(5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE_TILES).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final Block COMPRESSED_STYXSTONE_BRICKS_WALL = registerBlock("compressed_styxstone_bricks_wall",
            properties -> new WallBlock(properties.strength(5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE_TILES).mapColor(MapColor.TERRACOTTA_BLACK)));

    public static final Block POLISHED_COMPRESSED_STYXSTONE_STAIRS = registerBlock("polished_compressed_styxstone_stairs",
            properties -> new StairsBlock(ModBlocks.POLISHED_COMPRESSED_STYXSTONE.getDefaultState(),
                    properties.strength(5f).requiresTool().sounds(BlockSoundGroup.POLISHED_DEEPSLATE).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final Block POLISHED_COMPRESSED_STYXSTONE_SLAB = registerBlock("polished_compressed_styxstone_slab",
            properties -> new SlabBlock(properties.strength(5f).requiresTool().sounds(BlockSoundGroup.POLISHED_DEEPSLATE).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static final Block POLISHED_COMPRESSED_STYXSTONE_WALL = registerBlock("polished_compressed_styxstone_wall",
            properties -> new WallBlock(properties.strength(5f).requiresTool().sounds(BlockSoundGroup.POLISHED_DEEPSLATE).mapColor(MapColor.TERRACOTTA_BLACK)));

    public static final Block MABRIZE_BRICKS_STAIRS = registerBlock("mabrize_bricks_stairs",
            properties -> new StairsBlock(ModBlocks.MABRIZE_BRICKS.getDefaultState(),
                    properties.strength(2f).requiresTool().sounds(BlockSoundGroup.TUFF_BRICKS).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block MABRIZE_BRICKS_SLAB = registerBlock("mabrize_bricks_slab",
            properties -> new SlabBlock(properties.strength(2f).requiresTool().sounds(BlockSoundGroup.TUFF_BRICKS).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block MABRIZE_BRICKS_WALL = registerBlock("mabrize_bricks_wall",
            properties -> new WallBlock(properties.strength(2f).requiresTool().sounds(BlockSoundGroup.TUFF_BRICKS).mapColor(MapColor.TERRACOTTA_PURPLE)));

    public static final Block POLISHED_MABRIZE_STAIRS = registerBlock("polished_mabrize_stairs",
            properties -> new StairsBlock(ModBlocks.POLISHED_MABRIZE.getDefaultState(),
                    properties.strength(2f).requiresTool().sounds(BlockSoundGroup.POLISHED_TUFF).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block POLISHED_MABRIZE_SLAB = registerBlock("polished_mabrize_slab",
            properties -> new SlabBlock(properties.strength(2f).requiresTool().sounds(BlockSoundGroup.POLISHED_TUFF).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block POLISHED_MABRIZE_WALL = registerBlock("polished_mabrize_wall",
            properties -> new WallBlock(properties.strength(2f).requiresTool().sounds(BlockSoundGroup.POLISHED_TUFF).mapColor(MapColor.TERRACOTTA_PURPLE)));

    public static final Block AMETANE_BRICKS_STAIRS = registerBlock("ametane_bricks_stairs",
            properties -> new StairsBlock(ModBlocks.AMETANE_BRICKS.getDefaultState(),
                    properties.strength(2f).requiresTool().sounds(BlockSoundGroup.TUFF_BRICKS).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block AMETANE_BRICKS_SLAB = registerBlock("ametane_bricks_slab",
            properties -> new SlabBlock(properties.strength(2f).requiresTool().sounds(BlockSoundGroup.TUFF_BRICKS).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block AMETANE_BRICKS_WALL = registerBlock("ametane_bricks_wall",
            properties -> new WallBlock(properties.strength(2f).requiresTool().sounds(BlockSoundGroup.TUFF_BRICKS).mapColor(MapColor.TERRACOTTA_PURPLE)));

    public static final Block POLISHED_AMETANE_STAIRS = registerBlock("polished_ametane_stairs",
            properties -> new StairsBlock(ModBlocks.POLISHED_AMETANE.getDefaultState(),
                    properties.strength(2f).requiresTool().sounds(BlockSoundGroup.POLISHED_TUFF).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block POLISHED_AMETANE_SLAB = registerBlock("polished_ametane_slab",
            properties -> new SlabBlock(properties.strength(2f).requiresTool().sounds(BlockSoundGroup.POLISHED_TUFF).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block POLISHED_AMETANE_WALL = registerBlock("polished_ametane_wall",
            properties -> new WallBlock(properties.strength(2f).requiresTool().sounds(BlockSoundGroup.POLISHED_TUFF).mapColor(MapColor.TERRACOTTA_PURPLE)));

    public static final Block MOONSTEEL_BRICKS_STAIRS = registerBlock("moonsteel_bricks_stairs",
            properties -> new StairsBlock(ModBlocks.MOONSTEEL_BRICKS.getDefaultState(),
                    properties.strength(6f).requiresTool().sounds(BlockSoundGroup.IRON).mapColor(MapColor.DARK_AQUA)));
    public static final Block MOONSTEEL_BRICKS_SLAB = registerBlock("moonsteel_bricks_slab",
            properties -> new SlabBlock(properties.strength(6f).requiresTool().sounds(BlockSoundGroup.IRON).mapColor(MapColor.DARK_AQUA)));
    public static final Block MOONSTEEL_BRICKS_WALL = registerBlock("moonsteel_bricks_wall",
            properties -> new WallBlock(properties.strength(6f).requiresTool().sounds(BlockSoundGroup.IRON).mapColor(MapColor.DARK_AQUA)));

    public static final Block CERILLE_BRICKS_STAIRS = registerBlock("cerille_bricks_stairs",
            properties -> new StairsBlock(ModBlocks.CERILLE_BRICKS.getDefaultState(),
                    properties.strength(6f).requiresTool().sounds(BlockSoundGroup.IRON).mapColor(MapColor.DARK_CRIMSON)));
    public static final Block CERILLE_BRICKS_SLAB = registerBlock("cerille_bricks_slab",
            properties -> new SlabBlock(properties.strength(6f).requiresTool().sounds(BlockSoundGroup.IRON).mapColor(MapColor.DARK_CRIMSON)));
    public static final Block CERILLE_BRICKS_WALL = registerBlock("cerille_bricks_wall",
            properties -> new WallBlock(properties.strength(6f).requiresTool().sounds(BlockSoundGroup.IRON).mapColor(MapColor.DARK_CRIMSON)));

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

    public static final Block AMETHYST_TILES_STAIRS = registerBlock("amethyst_tiles_stairs",
            properties -> new StairsBlock(ModBlocks.AMETHYST_TILES.getDefaultState(),
                    properties.strength(3f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PURPLE)));
    public static final Block AMETHYST_TILES_SLAB = registerBlock("amethyst_tiles_slab",
            properties -> new SlabBlock(properties.strength(3f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PURPLE)));
    public static final Block AMETHYST_TILES_WALL = registerBlock("amethyst_tiles_wall",
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

    public static final Block SUNGAZE_BRICKS_STAIRS = registerBlock("sungaze_bricks_stairs",
            properties -> new StairsBlock(ModBlocks.SUNGAZE_BRICKS.getDefaultState(),
                    properties.strength(6f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.YELLOW)));
    public static final Block SUNGAZE_BRICKS_SLAB = registerBlock("sungaze_bricks_slab",
            properties -> new SlabBlock(properties.strength(6f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.YELLOW)));
    public static final Block SUNGAZE_BRICKS_WALL = registerBlock("sungaze_bricks_wall",
            properties -> new WallBlock(properties.strength(6f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.YELLOW)));

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

    public static final Block KEAPHE_STAIRS = registerBlock("keaphe_stairs",
            properties -> new StairsBlock(ModBlocks.KEAPHE_PLANKS.getDefaultState(),
                    properties.strength(2f).sounds(BlockSoundGroup.CHERRY_WOOD).mapColor(MapColor.PALE_GREEN)));
    public static final Block KEAPHE_SLAB = registerBlock("keaphe_slab",
            properties -> new SlabBlock(properties.strength(2f).sounds(BlockSoundGroup.CHERRY_WOOD).mapColor(MapColor.PALE_GREEN)));
    public static final Block KEAPHE_BUTTON = registerBlock("keaphe_button",
            properties -> new ButtonBlock(BlockSetType.CHERRY, 20, properties.strength(2f).noCollision().sounds(BlockSoundGroup.CHERRY_WOOD).mapColor(MapColor.PALE_GREEN)));
    public static final Block KEAPHE_PRESSURE_PLATE = registerBlock("keaphe_pressure_plate",
            properties -> new PressurePlateBlock(BlockSetType.CHERRY, properties.strength(2f).sounds(BlockSoundGroup.CHERRY_WOOD).mapColor(MapColor.PALE_GREEN)));
    public static final Block KEAPHE_FENCE = registerBlock("keaphe_fence",
            properties -> new FenceBlock(properties.strength(2f).sounds(BlockSoundGroup.CHERRY_WOOD)));
    public static final Block KEAPHE_FENCE_GATE = registerBlock("keaphe_fence_gate",
            properties -> new FenceGateBlock(WoodType.CHERRY, properties.strength(2f).sounds(BlockSoundGroup.CHERRY_WOOD).mapColor(MapColor.PALE_GREEN)));
    public static final Block KEAPHE_DOOR = registerBlock("keaphe_door",
            properties -> new DoorBlock(BlockSetType.CHERRY, properties.strength(2f).sounds(BlockSoundGroup.CHERRY_WOOD).nonOpaque()));
    public static final Block KEAPHE_TRAPDOOR = registerBlock("keaphe_trapdoor",
            properties -> new TrapdoorBlock(BlockSetType.CHERRY, properties.strength(2f).sounds(BlockSoundGroup.CHERRY_WOOD).nonOpaque()));

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
    public static final Block DEATH_FLOWERS = registerBlock("death_flowers",
            properties -> new FlowerbedBlock(properties.strength(0f)
                    .noCollision().nonOpaque().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY)));

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
    public static final Block POTTED_KEAPHE_SAPLING = registerBlockWithoutBlockItem("potted_keaphe_sapling",
            properties -> new FlowerPotBlock(ModBlocks.KEAPHE_SAPLING, properties.strength(0f).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
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

    public static final Block MOONSTEEL_LANTERN = registerBlock("moonsteel_lantern",
            properties -> new LanternBlock(properties.strength(1).nonOpaque()
                    .sounds(BlockSoundGroup.LANTERN).pistonBehavior(PistonBehavior.DESTROY).luminance(state -> 15)));
    public static final Block MOONSTEEL_CHAIN = registerBlock("moonsteel_chain",
            properties -> new ChainBlock(properties.strength(1).nonOpaque().sounds(BlockSoundGroup.CHAIN)));

    public static final Block GEM_BERRY_BUSH = registerBlockWithoutBlockItem("gem_berry_bush",
            properties -> new GemBerryBushBlock(properties.mapColor(MapColor.DARK_GREEN).ticksRandomly()
                    .noCollision().nonOpaque().sounds(BlockSoundGroup.SWEET_BERRY_BUSH).luminance(GemBerryBushBlock::getLuminance).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block CHARMBERRY_BUSH = registerBlockWithoutBlockItem("charmberry_bush",
            properties -> new CharmberryBushBlock(properties.mapColor(MapColor.PALE_PURPLE).ticksRandomly()
                    .noCollision().nonOpaque().sounds(BlockSoundGroup.SWEET_BERRY_BUSH).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block HAZEWEAVER_PLANT = registerBlockWithoutBlockItem("hazeweaver_plant",
            properties -> new FlowerBlock(StatusEffects.SATURATION, 2, properties.mapColor(MapColor.GREEN)
                    .noCollision().nonOpaque().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).luminance(state -> 1).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block POTTED_HAZEWEAVER_PLANT = registerBlockWithoutBlockItem("potted_hazeweaver_plant",
            properties -> new FlowerPotBlock(ModBlocks.HAZEWEAVER_PLANT, properties.strength(0f).nonOpaque().luminance(state -> 1).pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block COTTON = registerBlockWithoutBlockItem("cotton",
            properties -> new CottonCropBlock(properties.mapColor(MapColor.TERRACOTTA_BROWN).ticksRandomly().breakInstantly()
                    .noCollision().nonOpaque().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)));

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
