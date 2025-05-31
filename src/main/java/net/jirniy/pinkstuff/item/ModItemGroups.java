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
                        entries.add(ModItems.CRYSTAL_GLITTER);
                        entries.add(ModItems.ELYSIUM_INGOT);
                        entries.add(ModItems.ELYSIAN_REDSTONE_CORE);

                        entries.add(ModBlocks.KUNZITE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_KUNZITE_ORE);
                        entries.add(ModBlocks.AMETHYST_KUNZITE_ORE);
                        entries.add(ModBlocks.RAW_KUNZITE_BLOCK);
                        entries.add(ModBlocks.KUNZITE_BLOCK);
                        entries.add(ModBlocks.ELYSIUM_BLOCK);

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
                    })
                    .build());

    public static void registerItemGroups() {
        JirniysPinkStuff.LOGGER.info("Registering Item Groups for " + JirniysPinkStuff.MOD_ID);
    }
}
