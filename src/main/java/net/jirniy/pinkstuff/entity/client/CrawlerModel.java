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
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart legs;
    private final ModelPart bone;
    private final ModelPart bone2;
    private final ModelPart bone3;
    private final ModelPart bone4;
    private final ModelPart bone5;
    private final ModelPart bone6;
    private final ModelPart gem;
    private final ModelPart tail;
    private final Animation walkingAnimation;
    private final Animation idlingAnimation;

    public CrawlerModel(ModelPart root) {
        super(root);
        this.crawler = root.getChild("crawler");
        this.head = this.crawler.getChild("head");
        this.body = this.crawler.getChild("body");
        this.legs = this.body.getChild("legs");
        this.bone = this.legs.getChild("bone");
        this.bone2 = this.legs.getChild("bone2");
        this.bone3 = this.legs.getChild("bone3");
        this.bone4 = this.legs.getChild("bone4");
        this.bone5 = this.legs.getChild("bone5");
        this.bone6 = this.legs.getChild("bone6");
        this.gem = this.body.getChild("gem");
        this.tail = this.body.getChild("tail");

        this.walkingAnimation = CrawlerAnimations.ANIM_CRAWLER_WALK.createAnimation(root);
        this.idlingAnimation = CrawlerAnimations.ANIM_CRAWLER_IDLE.createAnimation(root);
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
        ModelPartData crawler = modelPartData.addChild("crawler", ModelPartBuilder.create(), ModelTransform.rotation(0.0F, 24.0F, 0.0F));

        ModelPartData head = crawler.addChild("head", ModelPartBuilder.create().uv(0, 11).cuboid(-1.5F, -1.0F, -1.5F, 3.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.rotation(0.0F, -2.0F, -6.0F));

        ModelPartData body = crawler.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -3.0F, 4.0F, 2.0F, 9.0F, new Dilation(0.0F)), ModelTransform.rotation(-1.0F, -1.0F, -1.0F));

        ModelPartData legs = body.addChild("legs", ModelPartBuilder.create(), ModelTransform.rotation(3.2929F, 0.0F, -1.5F));

        ModelPartData bone = legs.addChild("bone", ModelPartBuilder.create(), ModelTransform.rotation(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r1 = bone.addChild("cube_r1", ModelPartBuilder.create().uv(0, 22).cuboid(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

        ModelPartData bone2 = legs.addChild("bone2", ModelPartBuilder.create(), ModelTransform.rotation(-4.5F, 0.0F, 3.0F));

        ModelPartData cube_r2 = bone2.addChild("cube_r2", ModelPartBuilder.create().uv(16, 22).cuboid(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.3562F));

        ModelPartData bone3 = legs.addChild("bone3", ModelPartBuilder.create(), ModelTransform.rotation(-4.5F, 0.0F, 0.0F));

        ModelPartData cube_r3 = bone3.addChild("cube_r3", ModelPartBuilder.create().uv(12, 22).cuboid(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.3562F));

        ModelPartData bone4 = legs.addChild("bone4", ModelPartBuilder.create(), ModelTransform.rotation(-4.5F, 0.0F, 6.0F));

        ModelPartData cube_r4 = bone4.addChild("cube_r4", ModelPartBuilder.create().uv(20, 22).cuboid(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.3562F));

        ModelPartData bone5 = legs.addChild("bone5", ModelPartBuilder.create(), ModelTransform.rotation(0.0F, 0.0F, 3.0F));

        ModelPartData cube_r5 = bone5.addChild("cube_r5", ModelPartBuilder.create().uv(4, 22).cuboid(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

        ModelPartData bone6 = legs.addChild("bone6", ModelPartBuilder.create(), ModelTransform.rotation(0.0F, 0.0F, 6.0F));

        ModelPartData cube_r6 = bone6.addChild("cube_r6", ModelPartBuilder.create().uv(8, 22).cuboid(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

        ModelPartData gem = body.addChild("gem", ModelPartBuilder.create(), ModelTransform.rotation(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r7 = gem.addChild("cube_r7", ModelPartBuilder.create().uv(20, 11).cuboid(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(1.5F, -1.0F, -1.0F, -3.0386F, -1.0847F, -2.9231F));

        ModelPartData cube_r8 = gem.addChild("cube_r8", ModelPartBuilder.create().uv(0, 16).cuboid(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -1.0F, -1.0F, -2.4939F, -0.2753F, 2.5605F));

        ModelPartData cube_r9 = gem.addChild("cube_r9", ModelPartBuilder.create().uv(16, 17).cuboid(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(1.75F, -1.0F, 4.0F, -2.3864F, -0.2755F, -3.1002F));

        ModelPartData cube_r10 = gem.addChild("cube_r10", ModelPartBuilder.create().uv(12, 11).cuboid(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -1.0F, 3.0F, -2.4825F, 0.3237F, 3.0049F));

        ModelPartData cube_r11 = gem.addChild("cube_r11", ModelPartBuilder.create().uv(8, 17).cuboid(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(1.5F, -1.0F, 1.0F, -2.5268F, -0.6426F, 2.7413F));

        ModelPartData tail = body.addChild("tail", ModelPartBuilder.create(), ModelTransform.rotation(1.0F, -0.0793F, 7.3652F));

        ModelPartData cube_r12 = tail.addChild("cube_r12", ModelPartBuilder.create().uv(0, 26).cuboid(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 0.0793F, -1.1152F, -0.3927F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }
}
