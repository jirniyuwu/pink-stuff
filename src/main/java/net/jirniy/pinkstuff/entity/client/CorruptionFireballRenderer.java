package net.jirniy.pinkstuff.entity.client;

import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.entity.custom.CorruptionFireballEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.DragonFireballEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class CorruptionFireballRenderer extends EntityRenderer<CorruptionFireballEntity, EntityRenderState> {
    private static final Identifier TEXTURE = Identifier.of(JirniysPinkStuff.MOD_ID, "textures/entity/corruption_fireball.png");
    private static final RenderLayer LAYER;

    public CorruptionFireballRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    protected int getBlockLight(CorruptionFireballEntity corruptionFireballEntity, BlockPos blockPos) {
        return 15;
    }

    public void render(EntityRenderState renderState, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraState) {
        matrices.push();
        matrices.scale(2.0F, 2.0F, 2.0F);
        matrices.multiply(cameraState.orientation);
        queue.submitCustom(matrices, LAYER, (entry, vertexConsumer) -> {
            produceVertex(vertexConsumer, entry, renderState.light, 0.0F, 0, 0, 1);
            produceVertex(vertexConsumer, entry, renderState.light, 1.0F, 0, 1, 1);
            produceVertex(vertexConsumer, entry, renderState.light, 1.0F, 1, 1, 0);
            produceVertex(vertexConsumer, entry, renderState.light, 0.0F, 1, 0, 0);
        });
        matrices.pop();
        super.render(renderState, matrices, queue, cameraState);
    }

    private static void produceVertex(VertexConsumer vertexConsumer, MatrixStack.Entry matrix, int light, float x, int z, int textureU, int textureV) {
        vertexConsumer.vertex(matrix, x - 0.5F, (float)z - 0.25F, 0.0F).color(-1).texture((float)textureU, (float)textureV).overlay(OverlayTexture.DEFAULT_UV).light(light).normal(matrix, 0.0F, 1.0F, 0.0F);
    }

    public EntityRenderState createRenderState() {
        return new EntityRenderState();
    }

    static {
        LAYER = RenderLayer.getEntityCutoutNoCull(TEXTURE);
    }
}
