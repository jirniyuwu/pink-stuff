package net.jirniy.pinkstuff.entity;

import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.entity.custom.*;
import net.minecraft.entity.Entity;
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
    private static final RegistryKey<EntityType<?>> CORRUPTED_ZOMBIE_KEY =
            RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(JirniysPinkStuff.MOD_ID, "corrupted_zombie"));
    private static final RegistryKey<EntityType<?>> CORRUPTED_SKELETON_KEY =
            RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(JirniysPinkStuff.MOD_ID, "corrupted_skeleton"));
    private static final RegistryKey<EntityType<?>> AMETHYST_BLAZE_KEY =
            RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(JirniysPinkStuff.MOD_ID, "amethyst_blaze"));
    private static final RegistryKey<EntityType<?>> AMETHYST_FIREBALL_KEY =
            RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(JirniysPinkStuff.MOD_ID, "amethyst_fireball"));

    public static final EntityType<CrawlerEntity> CRAWLER = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(JirniysPinkStuff.MOD_ID, "crawler"),
            EntityType.Builder.create(CrawlerEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.5f, 0.25f).build(CRAWLER_KEY));

    public static final EntityType<CorruptedZombieEntity> CORRUPTED_ZOMBIE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(JirniysPinkStuff.MOD_ID, "corrupted_zombie"),
            EntityType.Builder.create(CorruptedZombieEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6f, 2.1f).build(CORRUPTED_ZOMBIE_KEY));

    public static final EntityType<CorruptedSkeletonEntity> CORRUPTED_SKELETON = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(JirniysPinkStuff.MOD_ID, "corrupted_skeleton"),
            EntityType.Builder.create(CorruptedSkeletonEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6f, 1.85f).build(CORRUPTED_SKELETON_KEY));

    public static final EntityType<AmethystBlazeEntity> AMETHYST_BLAZE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(JirniysPinkStuff.MOD_ID, "amethyst_blaze"),
            EntityType.Builder.create(AmethystBlazeEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.7f, 1.8f).build(AMETHYST_BLAZE_KEY));

    public static final EntityType<AmethystFireballEntity> AMETHYST_FIREBALL = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(JirniysPinkStuff.MOD_ID, "amethyst_fireball"),
            EntityType.Builder.create(AmethystFireballEntity::new, SpawnGroup.MISC)
                    .dimensions(1f, 1f).build(AMETHYST_FIREBALL_KEY));

    public static void registerModEntities() {
        JirniysPinkStuff.LOGGER.info("Registering Mod Entities for " + JirniysPinkStuff.MOD_ID);
    }
}
