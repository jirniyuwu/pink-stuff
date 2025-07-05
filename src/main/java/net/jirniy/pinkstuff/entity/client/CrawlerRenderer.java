package net.jirniy.pinkstuff.entity.client;

import com.google.common.collect.Maps;
import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.entity.custom.CrawlerEntity;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.Vec3d;

import java.util.Map;

public class CrawlerRenderer extends MobEntityRenderer<CrawlerEntity, CrawlerRenderState, CrawlerModel> {
    public CrawlerRenderer(EntityRendererFactory.Context context) {
        super(context, new CrawlerModel(context.getPart(CrawlerModel.CRAWLER)), 0.3f);
    }
    @Override
    public Identifier getTexture(CrawlerRenderState state) {
        return Identifier.of(JirniysPinkStuff.MOD_ID, "textures/entity/crawler/crawler_diamond.png");
    }

    @Override
    public void render(CrawlerRenderState state, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(state.baby) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);

        } else {
            matrixStack.scale(1f, 1f, 1f);
            
        }

        super.render(state, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public CrawlerRenderState createRenderState() {
        return new CrawlerRenderState();
    }

    @Override
    public void updateRenderState(CrawlerEntity livingEntity, CrawlerRenderState livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);
        livingEntityRenderState.idleAnimationState.copyFrom(livingEntity.idleAnimationState);
    }
}
