package net.jirniy.pinkstuff.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.block.entity.custom.CorruptCauldronBlockEntity;
import net.jirniy.pinkstuff.block.entity.custom.DisplayBlockEntity;
import net.jirniy.pinkstuff.block.entity.custom.ThermiumBlasterBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
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

    public static void registerBlockEntities() {
        JirniysPinkStuff.LOGGER.info("Registering Block Entities for " + JirniysPinkStuff.MOD_ID);
    }
}
