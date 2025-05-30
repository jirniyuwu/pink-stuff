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
                        entries.add(ModItems.KUNZITE);
                        entries.add(ModItems.RAW_KUNZITE);
                        entries.add(ModItems.CRYSTAL_GLITTER);
                        entries.add(ModItems.ELYSIUM_INGOT);
                        entries.add(ModBlocks.KUNZITE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_KUNZITE_ORE);
                        entries.add(ModBlocks.KUNZITE_BLOCK);
                        entries.add(ModBlocks.RAW_KUNZITE_BLOCK);
                        entries.add(ModBlocks.ELYSIUM_BLOCK);
                    })
                    .build());

    public static void registerItemGroups() {
        JirniysPinkStuff.LOGGER.info("Registering Item Groups for " + JirniysPinkStuff.MOD_ID);
    }
}
