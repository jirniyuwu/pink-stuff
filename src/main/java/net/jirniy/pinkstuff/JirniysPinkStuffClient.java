package net.jirniy.pinkstuff;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.block.entity.ModBlockEntities;
import net.jirniy.pinkstuff.block.entity.renderer.DisplayBlockEntityRenderer;
import net.jirniy.pinkstuff.block.entity.renderer.GrowingChamberEntityRenderer;
import net.jirniy.pinkstuff.block.entity.renderer.ShelfBlockEntity2Renderer;
import net.jirniy.pinkstuff.entity.ModEntities;
import net.jirniy.pinkstuff.entity.client.*;
import net.jirniy.pinkstuff.particle.*;
import net.jirniy.pinkstuff.screen.ModScreenHandlers;
import net.jirniy.pinkstuff.screen.custom.CorruptCauldronScreen;
import net.jirniy.pinkstuff.screen.custom.DisplayScreen;
import net.jirniy.pinkstuff.screen.custom.GrowingChamberScreen;
import net.jirniy.pinkstuff.screen.custom.ThermiumBlasterScreen;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.particle.SculkChargePopParticle;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.entity.EntityRendererFactories;

public class JirniysPinkStuffClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(ModBlocks.CRYSTAL_CHERRY_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.CRYSTAL_CHERRY_DOOR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.CRYSTAL_CHERRY_TRAPDOOR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.CHORUS_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.MAPLE_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.GEM_BERRY_BUSH, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.CHARMBERRY_BUSH, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.HAZEWEAVER_PLANT, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.ASHEN_DOOR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.ASHEN_TRAPDOOR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.MAPLE_DOOR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.MAPLE_TRAPDOOR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.MAPLE_LEAF_LITTER, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.CORRERIE_TRAPDOOR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.SNOWY_SPRUCE_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.KEAPHE_SAPLING, BlockRenderLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(ModBlocks.AMETHYST_PARTERS, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.KUNZITE_LOVELILY, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.ELYSIAN_SKYBERRY, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.THERMIUM_WILTBORN, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.MEMORIA_BOURPEER, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.BROWN_EVERBUD, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.LOTUS, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.DEATH_FLOWERS, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.STYXGRASS, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.HANGING_STYXGRASS, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.HANGING_STYXMOSS, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.HANGING_CORRUPT_ROOTS, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.STYXMOSS_VINE, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.END_VINES_PLANT, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.END_VINES, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.CORRUPT_ROOTS, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.COTTON, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.CORRUPT_SPROUTS, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.BLUE_MUSHROOM, BlockRenderLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(ModBlocks.AMETHYST_CLUMP, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.KUNZITE_CLUMP, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.THERMIUM_CLUMP, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.QUARTZ_CLUMP, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.DIAMOND_CLUMP, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.EMERALD_CLUMP, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.CORRUPTION_CLUMP, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.MAPLE_SAP, BlockRenderLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(ModBlocks.MOONSTEEL_CHAIN, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.MOONSTEEL_LANTERN, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.CERILLE_CHAIN, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.CERILLE_LANTERN, BlockRenderLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(ModBlocks.SMALL_END_GRASS, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.MEDIUM_END_GRASS, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.LARGE_END_GRASS, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.AURIC_GRASS, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.CHORUS_LILY, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.TURF_BLOCK, BlockRenderLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(ModBlocks.POTTED_CRYSTAL_CHERRY_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.POTTED_CHORUS_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.POTTED_MAPLE_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.POTTED_SNOWY_SPRUCE_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.POTTED_AMETHYST_PARTERS, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.POTTED_KUNZITE_LOVELILY, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.POTTED_ELYSIAN_SKYBERRY, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.POTTED_THERMIUM_WILTBORN, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.POTTED_MEMORIA_BOURPEER, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.POTTED_HAZEWEAVER_PLANT, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.POTTED_KEAPHE_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.POTTED_LOTUS, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.POTTED_BROWN_EVERBUD, BlockRenderLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(ModBlocks.SOFT_CLOUD, BlockRenderLayer.TRANSLUCENT);
        BlockRenderLayerMap.putBlock(ModBlocks.GROWING_CHAMBER, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.ANCIENT_SPIKE_TRAP, BlockRenderLayer.CUTOUT);

        EntityModelLayerRegistry.registerModelLayer(CrawlerModel.CRAWLER, CrawlerModel::getTexturedModelData);
        EntityRendererFactories.register(ModEntities.CRAWLER, CrawlerRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ExofairyModel.EXOFAIRY, ExofairyModel::getTexturedModelData);
        EntityRendererFactories.register(ModEntities.EXOFAIRY, ExofairyRenderer::new);
        EntityRendererFactories.register(ModEntities.CORRUPTED_ZOMBIE, CorruptedZombieRenderer::new);
        EntityRendererFactories.register(ModEntities.CRAGGY, CraggyRenderer::new);
        EntityRendererFactories.register(ModEntities.CORRUPTED_SKELETON, CorruptedSkeletonRenderer::new);
        EntityRendererFactories.register(ModEntities.AMETHYST_BLAZE, AmethystBlazeRenderer::new);
        EntityRendererFactories.register(ModEntities.CORRUPTION_BLAZE, CorruptionBlazeRenderer::new);
        EntityRendererFactories.register(ModEntities.AMETHYST_FIREBALL, AmethystFireballRenderer::new);
        EntityRendererFactories.register(ModEntities.CORRUPTION_FIREBALL, CorruptionFireballRenderer::new);

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
            if (view == null || pos == null) return -1;
            return BiomeColors.getGrassColor(view, pos);
        }, ModBlocks.TURF_BLOCK);

        BlockEntityRendererFactories.register(ModBlockEntities.DISPLAY_BE, DisplayBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.GROWING_CHAMBER_BE, GrowingChamberEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.SHELF_BE, ShelfBlockEntity2Renderer::new);

        HandledScreens.register(ModScreenHandlers.DISPLAY_SCREEN_HANDLER, DisplayScreen::new);
        HandledScreens.register(ModScreenHandlers.THERMIUM_BLASTER_SCREEN_HANDLER, ThermiumBlasterScreen::new);
        HandledScreens.register(ModScreenHandlers.CORRUPT_CAULDRON_SCREEN_HANDLER, CorruptCauldronScreen::new);;
        HandledScreens.register(ModScreenHandlers.GROWING_CHAMBER_SCREEN_HANDLER, GrowingChamberScreen::new);

        ParticleFactoryRegistry.getInstance().register(ModParticles.RIFT_PARTICLE, RiftParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.DAWNBREAK_PARTICLE, DawnbreakParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.SPARKLE_PARTICLE, SparkleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.CHORUS_PETAL_PARTICLE, ChorusPetalParticle.ChorusPetalFactory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.STYXIAN_FLAME_PARTICLE, FlameParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.CORRUPTION_POP_PARTICLE, SculkChargePopParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.CERILLE_SLASH_PARTICLE, CerilleSlashParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.RED_MAPLE_LEAF_PARTICLE, ChorusPetalParticle.ChorusPetalFactory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.ORANGE_MAPLE_LEAF_PARTICLE, ChorusPetalParticle.ChorusPetalFactory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.YELLOW_MAPLE_LEAF_PARTICLE, ChorusPetalParticle.ChorusPetalFactory::new);
    }
}
