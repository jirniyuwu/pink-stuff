package net.jirniy.pinkstuff.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.block.custom.ModSaplingBlock;
import net.jirniy.pinkstuff.world.tree.ModSaplingGenerator;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import java.util.function.Function;

public class ModBlocks {

    public static final Block KUNZITE_BLOCK = registerBlock("kunzite_block",
        properties -> new Block(properties.strength(4f)
                .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RAW_KUNZITE_BLOCK = registerBlock("raw_kunzite_block",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block KUNZITE_ORE = registerBlock("kunzite_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(1, 1),
                    properties.strength(3f).requiresTool()));
    public static final Block DEEPSLATE_KUNZITE_ORE = registerBlock("deepslate_kunzite_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(1, 1),
                    properties.strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block AMETHYST_KUNZITE_ORE = registerBlock("amethyst_kunzite_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(1, 1),
                    properties.strength(3f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block ELYSIUM_BLOCK = registerBlock("elysium_block",
            properties -> new Block(properties.strength(5f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block CRYSTAL_CHERRY_LOG = registerBlock("crystal_cherry_log",
            properties -> new PillarBlock(properties
                    .strength(2.0F).luminance(state -> 4).sounds(BlockSoundGroup.CHERRY_WOOD).burnable()));
    public static final Block CRYSTAL_CHERRY_WOOD = registerBlock("crystal_cherry_wood",
            properties -> new PillarBlock(properties
                    .strength(2.0F).luminance(state -> 4).sounds(BlockSoundGroup.CHERRY_WOOD).burnable()));
    public static final Block STRIPPED_CRYSTAL_CHERRY_LOG = registerBlock("stripped_crystal_cherry_log",
            properties -> new PillarBlock(properties
                    .strength(2.0F).luminance(state -> 7).sounds(BlockSoundGroup.CHERRY_WOOD).burnable()));
    public static final Block STRIPPED_CRYSTAL_CHERRY_WOOD = registerBlock("stripped_crystal_cherry_wood",
            properties -> new PillarBlock(properties
                    .strength(2.0F).luminance(state -> 7).sounds(BlockSoundGroup.CHERRY_WOOD).burnable()));

    public static final Block CRYSTAL_CHERRY_PLANKS = registerBlock("crystal_cherry_planks",
            properties -> new Block(properties.strength(3f).luminance(state -> 3).sounds(BlockSoundGroup.CHERRY_WOOD)));
    public static final Block CRYSTAL_CHERRY_LEAVES = registerBlock("crystal_cherry_leaves",
            properties -> new UntintedParticleLeavesBlock(0.02f, ParticleTypes.CHERRY_LEAVES, properties
                    .mapColor(MapColor.PINK).strength(0.2F).ticksRandomly().luminance(state -> 3)
                    .sounds(BlockSoundGroup.CHERRY_LEAVES).nonOpaque()
                    .allowsSpawning(Blocks::canSpawnOnLeaves).suffocates(Blocks::never)
                    .blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY)
                    .solidBlock(Blocks::never)));

    public static final Block CRYSTAL_CHERRY_SAPLING = registerBlock("crystal_cherry_sapling",
            properties -> new ModSaplingBlock(ModSaplingGenerator.CRYSTAL_CHERRY, properties.mapColor(MapColor.PINK)
                    .noCollision().ticksRandomly().breakInstantly().luminance(state -> 4)
                    .sounds(BlockSoundGroup.CHERRY_LEAVES).pistonBehavior(PistonBehavior.DESTROY), Blocks.GRASS_BLOCK));

    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> function) {
        Block toRegister = function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(JirniysPinkStuff.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(Registries.BLOCK, Identifier.of(JirniysPinkStuff.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(JirniysPinkStuff.MOD_ID, name));
        BlockItem item = new BlockItem(block, new Item.Settings().registryKey(key));
        Registry.register(Registries.ITEM, key, item);
    }

    public static void registerModBlocks() {
        JirniysPinkStuff.LOGGER.info("Registering Mod Blocks for " + JirniysPinkStuff.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.ELYSIUM_BLOCK);
            entries.add(ModBlocks.KUNZITE_BLOCK);
            entries.add(ModBlocks.KUNZITE_ORE);
            entries.add(ModBlocks.DEEPSLATE_KUNZITE_ORE);
            entries.add(ModBlocks.AMETHYST_KUNZITE_ORE);
            entries.add(ModBlocks.RAW_KUNZITE_BLOCK);
        });
    }
}
