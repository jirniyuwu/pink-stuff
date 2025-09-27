package net.jirniy.pinkstuff.util;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {
    public static final RegistryKey<PointOfInterestType> CORRUPT_POI_KEY = registerPoiKey("corrupt_poi");
    public static final PointOfInterestType CORRUPT_POI = registerPOI("corrupt_poi", ModBlocks.CORRUPT_CAULDRON);

    public static final RegistryKey<VillagerProfession> CORRUPT_FORGER_KEY =
            RegistryKey.of(RegistryKeys.VILLAGER_PROFESSION, Identifier.of(JirniysPinkStuff.MOD_ID, "corrupt_forger"));
    public static final VillagerProfession CORRUPT_FORGER = registerProfession("corrupt_forger", CORRUPT_POI_KEY,
            "entity.minecraft.villager.pinkstuff.corrupt_forger", SoundEvents.ENTITY_VILLAGER_WORK_WEAPONSMITH);

    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type, String translateableKey, SoundEvent sound) {
        return Registry.register(Registries.VILLAGER_PROFESSION, Identifier.of(JirniysPinkStuff.MOD_ID, name),
                new VillagerProfession(Text.translatable(translateableKey), entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), sound));
    }

    private static PointOfInterestType registerPOI(String name, Block block) {
        return PointOfInterestHelper.register(Identifier.of(JirniysPinkStuff.MOD_ID, name),
                1, 1, block);
    }

    private static RegistryKey<PointOfInterestType> registerPoiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, Identifier.of(JirniysPinkStuff.MOD_ID, name));
    }

    public static void registerVillagers() {
        JirniysPinkStuff.LOGGER.info("Registering Villagers for " + JirniysPinkStuff.MOD_ID);
    }
}
