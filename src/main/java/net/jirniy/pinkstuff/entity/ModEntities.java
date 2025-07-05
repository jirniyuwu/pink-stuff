package net.jirniy.pinkstuff.entity;

import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.entity.custom.CrawlerEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModEntities {
    private static final RegistryKey<EntityType<?>> CRAWLER_KEY =
            RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(JirniysPinkStuff.MOD_ID, "crawler"));

    public static final EntityType<CrawlerEntity> CRAWLER = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(JirniysPinkStuff.MOD_ID, "crawler"),
            EntityType.Builder.create(CrawlerEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.6f, 0.4f).build(CRAWLER_KEY));


    public static void registerModEntities() {
        JirniysPinkStuff.LOGGER.info("Registering Mod Entities for " + JirniysPinkStuff.MOD_ID);
    }
}
