package net.jirniy.pinkstuff.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block KUNZITE_BLOCK = registerBlock("kunzite_block",
            AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK));
    public static final Block KUNZITE_ORE = registerBlock("kunzite_ore",
            AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.STONE));
    public static final Block RAW_KUNZITE_BLOCK = registerBlock("raw_kunzite_block",
            AbstractBlock.Settings.create().strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.STONE));
    public static final Block DEEPSLATE_KUNZITE_ORE = registerBlock("deepslate_kunzite_ore",
            AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.DEEPSLATE));

    private static Block registerBlock(String name, AbstractBlock.Settings blockSettings) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(JirniysPinkStuff.MOD_ID, name));
        Block block = new Block(blockSettings.registryKey(key));
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, key, block);
    }

    private static void registerBlockItem(String name, Block block) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(JirniysPinkStuff.MOD_ID, name));
        BlockItem item = new BlockItem(block, new Item.Settings().registryKey(key));
        Registry.register(Registries.ITEM, key, item);
    }

    public static void registerModBlocks() {
        JirniysPinkStuff.LOGGER.info("Registering Mod Blocks for " + JirniysPinkStuff.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.KUNZITE_BLOCK);
            entries.add(ModBlocks.KUNZITE_ORE);
            entries.add(ModBlocks.DEEPSLATE_KUNZITE_ORE);
            entries.add(ModBlocks.RAW_KUNZITE_BLOCK);
        });
    }
}
