package net.jirniy.pinkstuff.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import org.jetbrains.annotations.Nullable;

public class ChorusPetalParticle extends SpriteBillboardParticle {
    private static final float SPEED_SCALE = 0.0025F;
    private static final int field_43373 = 300;
    private static final int field_43366 = 300;
    private float angularVelocity;
    private final float field_43370;
    private final float angularAcceleration;
    private final float field_55127;
    private boolean field_55128;
    private boolean field_55129;
    private double field_55130;
    private double field_55131;
    private double field_55132;

    protected ChorusPetalParticle(ClientWorld world, double x, double y, double z, SpriteProvider spriteProvider, float gravity, float f, boolean bl, boolean bl2, float size, float initialYVelocity) {
        super(world, x, y, z);
        this.setSprite(spriteProvider.getSprite(this.random.nextInt(12), 12));
        this.angularVelocity = (float)Math.toRadians(this.random.nextBoolean() ? (double)-30.0F : (double)30.0F);
        this.field_43370 = this.random.nextFloat();
        this.angularAcceleration = (float)Math.toRadians(this.random.nextBoolean() ? (double)-5.0F : (double)5.0F);
        this.field_55127 = f;
        this.field_55128 = bl;
        this.field_55129 = bl2;
        this.maxAge = 300;
        this.gravityStrength = gravity * 1.2F * 0.0025F;
        float g = size * (this.random.nextBoolean() ? 0.05F : 0.075F);
        this.scale = g;
        this.setBoundingBoxSpacing(g, g);
        this.velocityMultiplier = 1.0F;
        this.velocityY = (double)(-initialYVelocity);
        this.field_55130 = Math.cos(Math.toRadians((double)(this.field_43370 * 60.0F))) * (double)this.field_55127;
        this.field_55131 = Math.sin(Math.toRadians((double)(this.field_43370 * 60.0F))) * (double)this.field_55127;
        this.field_55132 = Math.toRadians((double)(1000.0F + this.field_43370 * 3000.0F));
    }

    public void tick() {
        this.lastX = this.x;
        this.lastY = this.y;
        this.lastZ = this.z;
        if (this.maxAge-- <= 0) {
            this.markDead();
        }

        if (!this.dead) {
            float f = (float)(300 - this.maxAge);
            float g = Math.min(f / 300.0F, 1.0F);
            double d = (double)0.0F;
            double e = (double)0.0F;
            if (this.field_55129) {
                d += this.field_55130 * Math.pow((double)g, (double)1.25F);
                e += this.field_55131 * Math.pow((double)g, (double)1.25F);
            }

            if (this.field_55128) {
                d += (double)g * Math.cos((double)g * this.field_55132) * (double)this.field_55127;
                e += (double)g * Math.sin((double)g * this.field_55132) * (double)this.field_55127;
            }

            this.velocityX += d * (double)0.0025F;
            this.velocityZ += e * (double)0.0025F;
            this.velocityY -= (double)this.gravityStrength;
            this.angularVelocity += this.angularAcceleration / 20.0F;
            this.lastAngle = this.angle;
            this.angle += this.angularVelocity / 20.0F;
            this.move(this.velocityX, this.velocityY, this.velocityZ);
            if (this.onGround || this.maxAge < 299 && (this.velocityX == (double)0.0F || this.velocityZ == (double)0.0F)) {
                this.markDead();
            }

            if (!this.dead) {
                this.velocityX *= (double)this.velocityMultiplier;
                this.velocityY *= (double)this.velocityMultiplier;
                this.velocityZ *= (double)this.velocityMultiplier;
            }
        }
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
    }

    @Environment(EnvType.CLIENT)
    public static class ChorusPetalFactory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider spriteProvider;

        public ChorusPetalFactory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        public Particle createParticle(SimpleParticleType simpleParticleType, ClientWorld clientWorld, double d, double e, double f, double g, double h, double i) {
            return new ChorusPetalParticle(clientWorld, d, e, f, this.spriteProvider, 0.25F, 2.0F, false, true, 1.0F, 0.0F);
        }
    }
}
