package net.jirniy.pinkstuff;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.block.entity.ModBlockEntities;
import net.jirniy.pinkstuff.block.entity.renderer.DisplayBlockEntityRenderer;
import net.jirniy.pinkstuff.entity.ModEntities;
import net.jirniy.pinkstuff.entity.client.CrawlerModel;
import net.jirniy.pinkstuff.entity.client.CrawlerRenderer;
import net.jirniy.pinkstuff.item.ModItems;
import net.jirniy.pinkstuff.screen.ModScreenHandlers;
import net.jirniy.pinkstuff.screen.custom.DisplayScreen;
import net.jirniy.pinkstuff.screen.custom.ThermiumBlasterScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.util.Identifier;

public class JirniysPinkStuffClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(ModBlocks.CRYSTAL_CHERRY_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.CRYSTAL_CHERRY_DOOR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.CRYSTAL_CHERRY_TRAPDOOR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.GEM_BERRY_BUSH, BlockRenderLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(ModBlocks.AMETHYST_PARTERS, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.KUNZITE_LOVELILY, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.ELYSIAN_SKYBERRY, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.THERMIUM_WILTBORN, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.MEMORIA_BOURPEER, BlockRenderLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(ModBlocks.POTTED_CRYSTAL_CHERRY_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.POTTED_AMETHYST_PARTERS, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.POTTED_KUNZITE_LOVELILY, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.POTTED_ELYSIAN_SKYBERRY, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.POTTED_THERMIUM_WILTBORN, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.POTTED_MEMORIA_BOURPEER, BlockRenderLayer.CUTOUT);

        EntityModelLayerRegistry.registerModelLayer(CrawlerModel.CRAWLER, CrawlerModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.CRAWLER, CrawlerRenderer::new);

        BlockEntityRendererFactories.register(ModBlockEntities.DISPLAY_BE, DisplayBlockEntityRenderer::new);

        HandledScreens.register(ModScreenHandlers.DISPLAY_SCREEN_HANDLER, DisplayScreen::new);
        HandledScreens.register(ModScreenHandlers.THERMIUM_BLASTER_SCREEN_HANDLER, ThermiumBlasterScreen::new);
    }
}
