package net.jirniy.pinkstuff.entity.client;

import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class CrawlerModel extends EntityModel<CrawlerRenderState> {
    public static final EntityModelLayer CRAWLER = new EntityModelLayer(Identifier.of(JirniysPinkStuff.MOD_ID, "crawler"), "main");
    private final ModelPart crawler;
    private final ModelPart body;
    private final ModelPart body2;
    private final ModelPart leg1;
    private final ModelPart leg2;
    private final ModelPart leg3;
    private final ModelPart leg4;
    private final ModelPart leg5;
    private final ModelPart leg6;
    private final ModelPart head;
    private final ModelPart tail;

    private final Animation walkingAnimation;
    private final Animation idlingAnimation;

    public CrawlerModel(ModelPart root) {
        super(root);
        this.crawler = root.getChild("crawler");
        this.body = this.crawler.getChild("body");
        this.body2 = this.body.getChild("body2");
        this.leg1 = this.body.getChild("leg1");
        this.leg2 = this.body.getChild("leg2");
        this.leg3 = this.body.getChild("leg3");
        this.leg4 = this.body.getChild("leg4");
        this.leg5 = this.body.getChild("leg5");
        this.leg6 = this.body.getChild("leg6");
        this.head = this.crawler.getChild("head");
        this.tail = this.crawler.getChild("tail");

        this.walkingAnimation = CrawlerAnimations.ANIM_CRAWLER_WALK.createAnimation(crawler);
        this.idlingAnimation = CrawlerAnimations.ANIM_CRAWLER_IDLE.createAnimation(crawler);
    }

    @Override
    public void setAngles(CrawlerRenderState state) {
        super.setAngles(state);
        this.setHeadAngles(state.relativeHeadYaw, state.pitch);

        this.walkingAnimation.applyWalking(state.limbSwingAnimationProgress, state.limbSwingAmplitude, 2f, 2.5f);
        this.idlingAnimation.apply(state.idleAnimationState, state.age, 1f);
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData crawler = modelPartData.addChild("crawler", ModelPartBuilder.create(), ModelTransform.of(0.0F, 23.7F, 0.0F, 0.0F, 0.0F, 0.0F));

        ModelPartData body = crawler.addChild("body", ModelPartBuilder.create(), ModelTransform.rotation(0.0F, 0.0F, -2.0F));

        ModelPartData body2 = body.addChild("body2", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -3.0F, -4.0F, 4.0F, 2.0F, 9.0F, new Dilation(0.0F)), ModelTransform.rotation(0.0F, 0.0F, 2.0F));

        ModelPartData cube_r1 = body2.addChild("cube_r1", ModelPartBuilder.create().uv(20, 11).cuboid(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -2.0F, -2.0F, -3.0386F, -1.0847F, -2.9231F));

        ModelPartData cube_r2 = body2.addChild("cube_r2", ModelPartBuilder.create().uv(0, 16).cuboid(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -2.0F, -2.0F, -2.4939F, -0.2753F, 2.5605F));

        ModelPartData cube_r3 = body2.addChild("cube_r3", ModelPartBuilder.create().uv(16, 17).cuboid(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.75F, -2.0F, 3.0F, -2.3864F, -0.2755F, -3.1002F));

        ModelPartData cube_r4 = body2.addChild("cube_r4", ModelPartBuilder.create().uv(12, 11).cuboid(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 2.0F, -2.4825F, 0.3237F, 3.0049F));

        ModelPartData cube_r5 = body2.addChild("cube_r5", ModelPartBuilder.create().uv(8, 17).cuboid(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -2.0F, 0.0F, -2.5268F, -0.6426F, 2.7413F));

        ModelPartData leg1 = body.addChild("leg1", ModelPartBuilder.create(), ModelTransform.rotation(0.0F, 0.0F, 2.0F));

        ModelPartData cube_r6 = leg1.addChild("cube_r6", ModelPartBuilder.create().uv(0, 22).cuboid(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.2929F, -1.0F, -2.5F, 0.0F, 0.0F, -0.7854F));

        ModelPartData leg2 = body.addChild("leg2", ModelPartBuilder.create(), ModelTransform.rotation(0.0F, 0.0F, 2.0F));

        ModelPartData cube_r7 = leg2.addChild("cube_r7", ModelPartBuilder.create().uv(8, 22).cuboid(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.2929F, -1.0F, 3.5F, 0.0F, 0.0F, -0.7854F));

        ModelPartData leg3 = body.addChild("leg3", ModelPartBuilder.create(), ModelTransform.rotation(0.0F, 0.0F, 2.0F));

        ModelPartData cube_r8 = leg3.addChild("cube_r8", ModelPartBuilder.create().uv(4, 22).cuboid(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.2929F, -1.0F, 0.5F, 0.0F, 0.0F, -0.7854F));

        ModelPartData leg4 = body.addChild("leg4", ModelPartBuilder.create(), ModelTransform.rotation(0.0F, 0.0F, 2.0F));

        ModelPartData cube_r9 = leg4.addChild("cube_r9", ModelPartBuilder.create().uv(20, 22).cuboid(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.2071F, -1.0F, 3.5F, 0.0F, 0.0F, -2.3562F));

        ModelPartData leg5 = body.addChild("leg5", ModelPartBuilder.create(), ModelTransform.rotation(0.0F, 0.0F, 2.0F));

        ModelPartData cube_r10 = leg5.addChild("cube_r10", ModelPartBuilder.create().uv(12, 22).cuboid(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.2071F, -1.0F, -2.5F, 0.0F, 0.0F, -2.3562F));

        ModelPartData leg6 = body.addChild("leg6", ModelPartBuilder.create(), ModelTransform.rotation(0.0F, 0.0F, 2.0F));

        ModelPartData cube_r11 = leg6.addChild("cube_r11", ModelPartBuilder.create().uv(16, 22).cuboid(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.2071F, -1.0F, 0.5F, 0.0F, 0.0F, -2.3562F));

        ModelPartData head = crawler.addChild("head", ModelPartBuilder.create().uv(0, 11).cuboid(-1.5F, -3.0F, -7.5F, 3.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.rotation(0.0F, 0.0F, 0.0F));

        ModelPartData tail = crawler.addChild("tail", ModelPartBuilder.create(), ModelTransform.rotation(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r12 = tail.addChild("cube_r12", ModelPartBuilder.create().uv(0, 26).cuboid(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -1.0F, 5.25F, -0.3927F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }
}
