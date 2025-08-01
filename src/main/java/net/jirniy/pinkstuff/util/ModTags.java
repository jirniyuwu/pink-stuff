package net.jirniy.pinkstuff.util;

import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_KUNZITE_TOOL = createTag("needs_kunzite_tool");
        public static final TagKey<Block> INCORRECT_FOR_KUNZITE_TOOL = createTag("incorrect_for_kunzite_tool");
        public static final TagKey<Block> NEEDS_ELYSIUM_TOOL = createTag("needs_elysium_tool");
        public static final TagKey<Block> INCORRECT_FOR_ELYSIUM_TOOL = createTag("incorrect_for_elysium_tool");
        public static final TagKey<Block> NEEDS_PINLINE_TOOL = createTag("needs_pinline_tool");
        public static final TagKey<Block> INCORRECT_FOR_PINLINE_TOOL = createTag("incorrect_for_pinline_tool");
        public static final TagKey<Block> NEEDS_SPECIAL_TOOL = createTag("needs_special_tool");
        public static final TagKey<Block> INCORRECT_FOR_SPECIAL_TOOL = createTag("incorrect_for_special_tool");
        public static final TagKey<Block> ALL_MINEABLE = createTag("all_mineable");
        public static final TagKey<Block> CRAWLER_SPAWNABLE_ON = createTag("crawler_spawnable_on");
        public static final TagKey<Block> CRYSTAL_CHERRY_LOGS = createTag("crystal_cherry_logs");
        public static final TagKey<Block> CHORUS_LOGS = createTag("chorus_logs");
        public static final TagKey<Block> ASHEN_LOGS = createTag("ashen_logs");
        public static final TagKey<Block> END_STONE = createTag("end_stone");
        public static final TagKey<Block> GLASS = createTag("glass");
        public static final TagKey<Block> GLASS_PANES = createTag("glass_panes");
        public static final TagKey<Block> SNOWY_SPRUCE_PLACEABLE = createTag("snowy_spruce_placeable");
        public static final TagKey<Block> BREAKER_BREAKABLE = createTag("breaker_breakable");
        public static final TagKey<Block> KUNZITE_GEODE_IRREPLACEABLE = createTag("kunzite_geode_irreplaceable");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(JirniysPinkStuff.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> KUNZITE_REPAIR = createTag("kunzite_repair");
        public static final TagKey<Item> ELYSIUM_REPAIR = createTag("elysium_repair");
        public static final TagKey<Item> PINLINE_REPAIR = createTag("pinline_repair");
        public static final TagKey<Item> SPECIAL_REPAIR = createTag("special_repair");
        public static final TagKey<Item> CRYSTAL_CHERRY_LOGS = createTag("crystal_cherry_logs");
        public static final TagKey<Item> CHORUS_LOGS = createTag("chorus_logs");
        public static final TagKey<Item> ASHEN_LOGS = createTag("ashen_logs");
        public static final TagKey<Item> BRICKS_CRAFTABLE = createTag("bricks_craftable");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(JirniysPinkStuff.MOD_ID, name));
        }
    }
}
