package net.jirniy.pinkstuff.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.block.entity.custom.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.ShelfBlockEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<ThermiumBlasterBlockEntity> THERMIUM_BLASTER_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(JirniysPinkStuff.MOD_ID, "thermium_blaster_be"),
                    FabricBlockEntityTypeBuilder.create(ThermiumBlasterBlockEntity::new, ModBlocks.THERMIUM_BLASTER).build(null));

    public static final BlockEntityType<CorruptCauldronBlockEntity> CORRUPT_CAULDRON_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(JirniysPinkStuff.MOD_ID, "corrupt_cauldron_be"),
                    FabricBlockEntityTypeBuilder.create(CorruptCauldronBlockEntity::new, ModBlocks.CORRUPT_CAULDRON).build(null));

    public static final BlockEntityType<DisplayBlockEntity> DISPLAY_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(JirniysPinkStuff.MOD_ID, "display_be"),
                    FabricBlockEntityTypeBuilder.create(DisplayBlockEntity::new, ModBlocks.DISPLAY).build(null));

    public static final BlockEntityType<ShelfBlockEntity2> SHELF_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(JirniysPinkStuff.MOD_ID, "shelf_be"),
                    FabricBlockEntityTypeBuilder.create(ShelfBlockEntity2::new,
                            ModBlocks.CRYSTAL_CHERRY_SHELF, ModBlocks.ASHEN_SHELF, ModBlocks.CHORUS_SHELF,
                            ModBlocks.KEAPHE_SHELF, ModBlocks.WASTEWOOD_SHELF, ModBlocks.CORRERIE_SHELF).build(null));

    public static final BlockEntityType<LavaGeyserBlockEntity> LAVA_GEYSER_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(JirniysPinkStuff.MOD_ID, "lava_geyser_be"),
                    FabricBlockEntityTypeBuilder.create(LavaGeyserBlockEntity::new, ModBlocks.LAVA_GEYSER).build(null));

    public static void registerBlockEntities() {
        JirniysPinkStuff.LOGGER.info("Registering Block Entities for " + JirniysPinkStuff.MOD_ID);
    }
}
