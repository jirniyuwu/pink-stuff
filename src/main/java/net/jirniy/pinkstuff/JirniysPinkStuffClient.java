package net.jirniy.pinkstuff;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.block.entity.ModBlockEntities;
import net.jirniy.pinkstuff.block.entity.renderer.DisplayBlockEntityRenderer;
import net.jirniy.pinkstuff.entity.ModEntities;
import net.jirniy.pinkstuff.entity.client.*;
import net.jirniy.pinkstuff.particle.*;
import net.jirniy.pinkstuff.screen.ModScreenHandlers;
import net.jirniy.pinkstuff.screen.custom.DisplayScreen;
import net.jirniy.pinkstuff.screen.custom.ThermiumBlasterScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.particle.SculkChargePopParticle;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class JirniysPinkStuffClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(ModBlocks.CRYSTAL_CHERRY_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.CRYSTAL_CHERRY_DOOR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.CRYSTAL_CHERRY_TRAPDOOR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.CHORUS_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.GEM_BERRY_BUSH, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.CHARMBERRY_BUSH, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.HAZEWEAVER_PLANT, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.ASHEN_DOOR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.ASHEN_TRAPDOOR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.CORRERIE_TRAPDOOR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.SNOWY_SPRUCE_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.KEAPHE_SAPLING, BlockRenderLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(ModBlocks.AMETHYST_PARTERS, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.KUNZITE_LOVELILY, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.ELYSIAN_SKYBERRY, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.THERMIUM_WILTBORN, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.MEMORIA_BOURPEER, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.DEATH_FLOWERS, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.STYXGRASS, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.HANGING_STYXGRASS, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.HANGING_STYXMOSS, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.HANGING_CORRUPT_ROOTS, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.STYXMOSS_VINE, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.CORRUPT_ROOTS, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.COTTON, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.CORRUPT_SPROUTS, BlockRenderLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(ModBlocks.AMETHYST_CLUMP, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.KUNZITE_CLUMP, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.THERMIUM_CLUMP, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.QUARTZ_CLUMP, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.DIAMOND_CLUMP, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.EMERALD_CLUMP, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.CORRUPTION_CLUMP, BlockRenderLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(ModBlocks.MOONSTEEL_CHAIN, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.MOONSTEEL_LANTERN, BlockRenderLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(ModBlocks.SMALL_END_GRASS, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.MEDIUM_END_GRASS, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.LARGE_END_GRASS, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.CHORUS_LILY, BlockRenderLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(ModBlocks.POTTED_CRYSTAL_CHERRY_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.POTTED_CHORUS_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.POTTED_SNOWY_SPRUCE_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.POTTED_AMETHYST_PARTERS, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.POTTED_KUNZITE_LOVELILY, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.POTTED_ELYSIAN_SKYBERRY, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.POTTED_THERMIUM_WILTBORN, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.POTTED_MEMORIA_BOURPEER, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.POTTED_HAZEWEAVER_PLANT, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.POTTED_KEAPHE_SAPLING, BlockRenderLayer.CUTOUT);

        EntityModelLayerRegistry.registerModelLayer(CrawlerModel.CRAWLER, CrawlerModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.CRAWLER, CrawlerRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ExofairyModel.EXOFAIRY, ExofairyModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.EXOFAIRY, ExofairyRenderer::new);
        EntityRendererRegistry.register(ModEntities.CORRUPTED_ZOMBIE, CorruptedZombieRenderer::new);
        EntityRendererRegistry.register(ModEntities.CORRUPTED_SKELETON, CorruptedSkeletonRenderer::new);
        EntityRendererRegistry.register(ModEntities.AMETHYST_BLAZE, AmethystBlazeRenderer::new);
        EntityRendererRegistry.register(ModEntities.CORRUPTION_BLAZE, CorruptionBlazeRenderer::new);
        EntityRendererRegistry.register(ModEntities.AMETHYST_FIREBALL, AmethystFireballRenderer::new);
        EntityRendererRegistry.register(ModEntities.CORRUPTION_FIREBALL, CorruptionFireballRenderer::new);

        BlockEntityRendererFactories.register(ModBlockEntities.DISPLAY_BE, DisplayBlockEntityRenderer::new);

        HandledScreens.register(ModScreenHandlers.DISPLAY_SCREEN_HANDLER, DisplayScreen::new);
        HandledScreens.register(ModScreenHandlers.THERMIUM_BLASTER_SCREEN_HANDLER, ThermiumBlasterScreen::new);

        ParticleFactoryRegistry.getInstance().register(ModParticles.RIFT_PARTICLE, RiftParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.DAWNBREAK_PARTICLE, DawnbreakParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.SPARKLE_PARTICLE, SparkleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.CHORUS_PETAL_PARTICLE, ChorusPetalParticle.ChorusPetalFactory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.STYXIAN_FLAME_PARTICLE, FlameParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.CORRUPTION_POP_PARTICLE, SculkChargePopParticle.Factory::new);
    }
}
