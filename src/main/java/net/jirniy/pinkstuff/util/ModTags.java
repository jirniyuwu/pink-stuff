package net.jirniy.pinkstuff.util;

import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_KUNZITE_TOOL = createTag("needs_kunzite_tool");
        public static final TagKey<Block> INCORRECT_FOR_KUNZITE_TOOL = createTag("incorrect_for_kunzite_tool");
        public static final TagKey<Block> NEEDS_ELYSIUM_TOOL = createTag("needs_elysium_tool");
        public static final TagKey<Block> INCORRECT_FOR_ELYSIUM_TOOL = createTag("incorrect_for_elysium_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(JirniysPinkStuff.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> KUNZITE_REPAIR = createTag("kunzite_repair");
        public static final TagKey<Item> ELYSIUM_REPAIR = createTag("elysium_repair");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(JirniysPinkStuff.MOD_ID, name));
        }
    }
}
