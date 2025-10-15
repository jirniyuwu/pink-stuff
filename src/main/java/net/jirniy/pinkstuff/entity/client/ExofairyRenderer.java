package net.jirniy.pinkstuff.entity.client;

import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.entity.custom.ExofairyEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.client.render.entity.state.ArmedEntityRenderState;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ExofairyRenderer extends MobEntityRenderer<ExofairyEntity, ExofairyRenderState, ExofairyModel> {
    private static final Identifier TEXTURE = Identifier.of(JirniysPinkStuff.MOD_ID, "textures/entity/exofairy/exofairy.png");

    public ExofairyRenderer(EntityRendererFactory.Context context) {
        super(context, new ExofairyModel(context.getPart(ExofairyModel.EXOFAIRY)), 0.4F);
        this.addFeature(new HeldItemFeatureRenderer(this));
    }

    public Identifier getTexture(ExofairyRenderState exofairyEntityRenderState) {
        return TEXTURE;
    }

    @Override
    public void render(ExofairyRenderState state, MatrixStack matrixStack, OrderedRenderCommandQueue orderedRenderCommandQueue, CameraRenderState cameraRenderState) {
        if(state.baby) {
                matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
                matrixStack.scale(1f, 1f, 1f);
        }
        super.render(state, matrixStack, orderedRenderCommandQueue, cameraRenderState);
    }

    public ExofairyRenderState createRenderState() {
        return new ExofairyRenderState();
    }

    public void updateRenderState(ExofairyEntity exofairyEntity, ExofairyRenderState exofairyEntityRenderState, float f) {
        super.updateRenderState(exofairyEntity, exofairyEntityRenderState, f);
        ArmedEntityRenderState.updateRenderState(exofairyEntity, exofairyEntityRenderState, this.itemModelResolver);
    }

    protected int getBlockLight(ExofairyEntity exofairyEntity, BlockPos blockPos) {
        return 15;
    }
}
