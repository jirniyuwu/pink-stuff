package net.jirniy.pinkstuff.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item KUNZITE = registerItem(new Item.Settings(), "kunzite");
    public static final Item RAW_KUNZITE = registerItem(new Item.Settings(), "raw_kunzite");
    public static final Item CRYSTAL_GLITTER = registerItem(new Item.Settings(), "crystal_glitter");
    public static final Item ELYSIUM_INGOT = registerItem(new Item.Settings(), "elysium_ingot");

    private static Item registerItem(Item.Settings itemSettings, String name) {
        Identifier id = Identifier.of(JirniysPinkStuff.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        Item.Settings settings = itemSettings.registryKey(key);

        return Registry.register(Registries.ITEM, key, new Item(settings));
    }

    public static void registerModItems() {
        JirniysPinkStuff.LOGGER.info("Registering Mod Items for " + JirniysPinkStuff.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(KUNZITE);
            entries.add(RAW_KUNZITE);
            entries.add(CRYSTAL_GLITTER);
            entries.add(ELYSIUM_INGOT);
        });
    }
}
