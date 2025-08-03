package net.jirniy.pinkstuff.util;

import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.minecraft.item.map.MapDecorationType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModMapDecorations {
    public static final RegistryEntry<MapDecorationType> END_TEMPLE = register("end_temple", "end_temple", true, 0x2F4D48, false, true);
    public static final RegistryEntry<MapDecorationType> END_CITY = register("end_city", "end_city", true, 0x704F6F, false, true);
    public static final RegistryEntry<MapDecorationType> CHAMBERS = register("chambers", "chambers", true, 0x64459F, false, true);

    private static RegistryEntry<MapDecorationType> register(String id, String assetId, boolean showOnItemFrame, int mapColor, boolean trackCount, boolean explorationMapElement) {
        MapDecorationType mapDecorationType = new MapDecorationType(Identifier.of(JirniysPinkStuff.MOD_ID, assetId), showOnItemFrame, mapColor, explorationMapElement, trackCount);
        return Registry.registerReference(Registries.MAP_DECORATION_TYPE, Identifier.of(JirniysPinkStuff.MOD_ID, id), mapDecorationType);
    }

    public static void registerMapDecorations() {
        JirniysPinkStuff.LOGGER.info("Registering Mod Map Decorations for " + JirniysPinkStuff.MOD_ID);
    }
}
