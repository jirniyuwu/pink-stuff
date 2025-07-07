package net.jirniy.pinkstuff.entity.client;

import com.google.common.collect.Maps;
import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.entity.custom.CrawlerEntity;

import net.jirniy.pinkstuff.entity.custom.CrawlerVariant;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.Vec3d;

import java.util.Map;

public class CrawlerRenderer extends MobEntityRenderer<CrawlerEntity, CrawlerRenderState, CrawlerModel> {
    private static final Map<CrawlerVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(CrawlerVariant.class), map -> {
                map.put(CrawlerVariant.DEFAULT,
                        Identifier.of(JirniysPinkStuff.MOD_ID, "textures/entity/crawler/crawler_amethyst.png"));
                map.put(CrawlerVariant.DIAMOND,
                        Identifier.of(JirniysPinkStuff.MOD_ID, "textures/entity/crawler/crawler_diamond.png"));
                map.put(CrawlerVariant.EMERALD,
                        Identifier.of(JirniysPinkStuff.MOD_ID, "textures/entity/crawler/crawler_emerald.png"));
                map.put(CrawlerVariant.QUARTZ,
                        Identifier.of(JirniysPinkStuff.MOD_ID, "textures/entity/crawler/crawler_quartz.png"));
                map.put(CrawlerVariant.KUNZITE,
                        Identifier.of(JirniysPinkStuff.MOD_ID, "textures/entity/crawler/crawler_kunzite.png"));
                map.put(CrawlerVariant.THERMIUM,
                        Identifier.of(JirniysPinkStuff.MOD_ID, "textures/entity/crawler/crawler_thermium.png"));
                map.put(CrawlerVariant.RESIN,
                        Identifier.of(JirniysPinkStuff.MOD_ID, "textures/entity/crawler/crawler_resin.png"));
                map.put(CrawlerVariant.ICE,
                        Identifier.of(JirniysPinkStuff.MOD_ID, "textures/entity/crawler/crawler_ice.png"));
            });
    
    public CrawlerRenderer(EntityRendererFactory.Context context) {
        super(context, new CrawlerModel(context.getPart(CrawlerModel.CRAWLER)), 0.3f);
    }
    @Override
    public Identifier getTexture(CrawlerRenderState state) {
        return LOCATION_BY_VARIANT.get(state.variant);
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
        livingEntityRenderState.variant = livingEntity.getVariant();
    }
}
