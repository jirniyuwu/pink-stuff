package net.jirniy.pinkstuff;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.block.entity.ModBlockEntities;
import net.jirniy.pinkstuff.block.entity.renderer.DisplayBlockEntityRenderer;
import net.jirniy.pinkstuff.screen.ModScreenHandlers;
import net.jirniy.pinkstuff.screen.custom.DisplayScreen;
import net.jirniy.pinkstuff.screen.custom.ThermiumBlasterScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class JirniysPinkStuffClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CRYSTAL_CHERRY_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CRYSTAL_CHERRY_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CRYSTAL_CHERRY_TRAPDOOR, RenderLayer.getCutout());

        BlockEntityRendererFactories.register(ModBlockEntities.DISPLAY_BE, DisplayBlockEntityRenderer::new);

        HandledScreens.register(ModScreenHandlers.DISPLAY_SCREEN_HANDLER, DisplayScreen::new);
        HandledScreens.register(ModScreenHandlers.THERMIUM_BLASTER_SCREEN_HANDLER, ThermiumBlasterScreen::new);
    }
}
