package net.jirniy.pinkstuff.entity.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.AllayEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.ModelWithArms;
import net.minecraft.client.render.entity.state.ArmedEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Arm;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

@Environment(EnvType.CLIENT)
public class ExofairyModel extends EntityModel<ExofairyRenderState> implements ModelWithArms {
    public static final EntityModelLayer EXOFAIRY = new EntityModelLayer(Identifier.of(JirniysPinkStuff.MOD_ID, "exofairy"), "main");
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart rightArm;
    private final ModelPart leftArm;
    private final ModelPart rightWing;
    private final ModelPart leftWing;
    private static final float field_38999 = ((float)Math.PI / 4F);
    private static final float field_39000 = -1.134464F;
    private static final float field_39001 = (-(float)Math.PI / 3F);

    public ExofairyModel(ModelPart modelPart) {
        super(modelPart.getChild("root"), RenderLayer::getEntityTranslucent);
        this.head = this.root.getChild("head");
        this.body = this.root.getChild("body");
        this.rightArm = this.body.getChild("right_arm");
        this.leftArm = this.body.getChild("left_arm");
        this.rightWing = this.body.getChild("right_wing");
        this.leftWing = this.body.getChild("left_wing");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData modelPartData2 = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.origin(0.0F, 23.5F, 0.0F));
        modelPartData2.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-2.5F, -5.0F, -2.5F, 5.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, -3.99F, 0.0F));
        ModelPartData modelPartData3 = modelPartData2.addChild("body", ModelPartBuilder.create().uv(0, 10).cuboid(-1.5F, 0.0F, -1.0F, 3.0F, 4.0F, 2.0F, new Dilation(0.0F)).uv(0, 16).cuboid(-1.5F, 0.0F, -1.0F, 3.0F, 5.0F, 2.0F, new Dilation(-0.2F)), ModelTransform.origin(0.0F, -4.0F, 0.0F));
        modelPartData3.addChild("right_arm", ModelPartBuilder.create().uv(23, 0).cuboid(-0.75F, -0.5F, -1.0F, 1.0F, 4.0F, 2.0F, new Dilation(-0.01F)), ModelTransform.origin(-1.75F, 0.5F, 0.0F));
        modelPartData3.addChild("left_arm", ModelPartBuilder.create().uv(23, 6).cuboid(-0.25F, -0.5F, -1.0F, 1.0F, 4.0F, 2.0F, new Dilation(-0.01F)), ModelTransform.origin(1.75F, 0.5F, 0.0F));
        modelPartData3.addChild("right_wing", ModelPartBuilder.create().uv(16, 14).cuboid(0.0F, 1.0F, 0.0F, 0.0F, 5.0F, 8.0F, new Dilation(0.0F)), ModelTransform.origin(-0.5F, 0.0F, 0.6F));
        modelPartData3.addChild("left_wing", ModelPartBuilder.create().uv(16, 14).cuboid(0.0F, 1.0F, 0.0F, 0.0F, 5.0F, 8.0F, new Dilation(0.0F)), ModelTransform.origin(0.5F, 0.0F, 0.6F));
        return TexturedModelData.of(modelData, 32, 32);
    }

    public void setAngles(ExofairyRenderState exofairyRenderState) {
        super.setAngles(exofairyRenderState);
        float f = exofairyRenderState.limbSwingAmplitude;
        float g = exofairyRenderState.limbSwingAnimationProgress;
        float h = exofairyRenderState.age * 20.0F * ((float)Math.PI / 180F) + g;
        float i = MathHelper.cos(h) * (float)Math.PI * 0.15F + f;
        float j = exofairyRenderState.age * 9.0F * ((float)Math.PI / 180F);
        float k = Math.min(f / 0.3F, 1.0F);
        float l = 1.0F - k;
        float m = exofairyRenderState.itemHoldAnimationTicks;
        if (exofairyRenderState.dancing) {
            float n = exofairyRenderState.age * 8.0F * ((float)Math.PI / 180F) + f;
            float o = MathHelper.cos(n) * 16.0F * ((float)Math.PI / 180F);
            float p = exofairyRenderState.spinningAnimationTicks;
            float q = MathHelper.cos(n) * 14.0F * ((float)Math.PI / 180F);
            float r = MathHelper.cos(n) * 30.0F * ((float)Math.PI / 180F);
            this.root.yaw = exofairyRenderState.spinning ? 12.566371F * p : this.root.yaw;
            this.root.roll = o * (1.0F - p);
            this.head.yaw = r * (1.0F - p);
            this.head.roll = q * (1.0F - p);
        } else {
            this.head.pitch = exofairyRenderState.pitch * ((float)Math.PI / 180F);
            this.head.yaw = exofairyRenderState.relativeHeadYaw * ((float)Math.PI / 180F);
        }

        this.rightWing.pitch = 0.43633232F * (1.0F - k);
        this.rightWing.yaw = (-(float)Math.PI / 4F) + i;
        this.leftWing.pitch = 0.43633232F * (1.0F - k);
        this.leftWing.yaw = ((float)Math.PI / 4F) - i;
        this.body.pitch = k * ((float)Math.PI / 4F);
        float n = m * MathHelper.lerp(k, (-(float)Math.PI / 3F), -1.134464F);
        ModelPart var10000 = this.root;
        var10000.originY += (float)Math.cos((double)j) * 0.25F * l;
        this.rightArm.pitch = n;
        this.leftArm.pitch = n;
        float o = l * (1.0F - m);
        float p = 0.43633232F - MathHelper.cos(j + ((float)Math.PI * 1.5F)) * (float)Math.PI * 0.075F * o;
        this.leftArm.roll = -p;
        this.rightArm.roll = p;
        this.rightArm.yaw = 0.27925268F * m;
        this.leftArm.yaw = -0.27925268F * m;
    }

    public void setArmAngle(Arm arm, MatrixStack matrices) {
        float f = 1.0F;
        float g = 3.0F;
        this.root.applyTransform(matrices);
        this.body.applyTransform(matrices);
        matrices.translate(0.0F, 0.0625F, 0.1875F);
        matrices.multiply(RotationAxis.POSITIVE_X.rotation(this.rightArm.pitch));
        matrices.scale(0.7F, 0.7F, 0.7F);
        matrices.translate(0.0625F, 0.0F, 0.0F);
    }
}