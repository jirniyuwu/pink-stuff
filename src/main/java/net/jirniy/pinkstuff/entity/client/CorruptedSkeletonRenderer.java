package net.jirniy.pinkstuff.entity.client;

import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.SkeletonEntityRenderer;
import net.minecraft.client.render.entity.state.SkeletonEntityRenderState;
import net.minecraft.util.Identifier;

public class CorruptedSkeletonRenderer extends SkeletonEntityRenderer {
    private static final Identifier TEXTURE = Identifier.of(JirniysPinkStuff.MOD_ID, "textures/entity/skeleton/corrupted_skeleton.png");
    private static final Identifier OVERLAY_TEXTURE = Identifier.of(JirniysPinkStuff.MOD_ID, "textures/entity/skeleton/corrupted_skeleton_overlay.png");

    public CorruptedSkeletonRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    public Identifier getTexture(SkeletonEntityRenderState skeletonEntityRenderState) {
        return TEXTURE;
    }
}
