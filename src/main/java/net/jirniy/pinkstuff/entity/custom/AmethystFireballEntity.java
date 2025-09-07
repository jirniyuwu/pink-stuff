package net.jirniy.pinkstuff.entity.custom;

import net.jirniy.pinkstuff.particle.ModParticles;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.ExplosiveProjectileEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class AmethystFireballEntity extends ExplosiveProjectileEntity {
    public AmethystFireballEntity(EntityType<? extends AmethystFireballEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void setRotation(float yaw, float pitch) {
        super.setRotation(yaw, pitch);
    }

    @Override
    public void refreshPosition() {
        super.refreshPosition();
    }

    public void setVelocityWithAcceleration(Vec3d velocity, double accelerationPower) {
        this.setVelocity(velocity.normalize().multiply(accelerationPower));
        this.velocityDirty = true;
    }

    @Override
    public void tick() {
        this.tickInitialBubbleColumnCollision();
        this.applyGravity();
        this.applyDrag();

        super.tick();
    }
    private void tickInitialBubbleColumnCollision() {
        if (this.firstUpdate) {
            for(BlockPos blockPos : BlockPos.iterate(this.getBoundingBox())) {
                BlockState blockState = this.getWorld().getBlockState(blockPos);
                if (blockState.isOf(Blocks.BUBBLE_COLUMN)) {
                    blockState.onEntityCollision(this.getWorld(), blockPos, this, EntityCollisionHandler.DUMMY);
                }
            }
        }
    }
    private void applyDrag() {
        Vec3d vec3d = this.getVelocity();
        Vec3d vec3d2 = this.getPos();
        float g;
        if (this.isTouchingWater()) {
            for(int i = 0; i < 4; ++i) {
                float f = 0.25F;
                this.getWorld().addParticleClient(ParticleTypes.BUBBLE, vec3d2.x - vec3d.x * (double)0.25F, vec3d2.y - vec3d.y * (double)0.25F, vec3d2.z - vec3d.z * (double)0.25F, vec3d.x, vec3d.y, vec3d.z);
            }
            g = 0.8F;
        } else {
            g = 0.99F;
        }
        this.setVelocity(vec3d.multiply((double)g));
    }

    protected double getGravity() {
        return 0.01;
    }

    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (hitResult.getType() != HitResult.Type.ENTITY || !this.isOwner(((EntityHitResult)hitResult).getEntity())) {
            if (!this.getWorld().isClient) {
                List<LivingEntity> list = this.getWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand((double)2.0F, (double)2.0F, (double)2.0F));
                AreaEffectCloudEntity areaEffectCloudEntity = new AreaEffectCloudEntity(this.getWorld(), this.getX(), this.getY(), this.getZ());
                Entity entity = this.getOwner();
                if (entity instanceof LivingEntity) {
                    areaEffectCloudEntity.setOwner((LivingEntity)entity);
                }

                areaEffectCloudEntity.setParticleType(ModParticles.STYXIAN_FLAME_PARTICLE);
                areaEffectCloudEntity.setRadius(1.5F);
                areaEffectCloudEntity.setDuration(100);
                areaEffectCloudEntity.setPotionDurationScale(0.25F);
                areaEffectCloudEntity.addEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 0));
                if (!list.isEmpty()) {
                    for(LivingEntity livingEntity : list) {
                        World world = livingEntity.getWorld();
                        if (!world.isClient()) {
                            livingEntity.damage((ServerWorld) world, world.getDamageSources().magic(), 4);
                        }
                        double d = this.squaredDistanceTo(livingEntity);
                        if (d < (double)16.0F) {
                            areaEffectCloudEntity.setPosition(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ());
                            break;
                        }
                    }
                }
                this.getWorld().spawnEntity(areaEffectCloudEntity);
                this.discard();
            }

        }
    }

    protected ParticleEffect getParticleType() {
        return ModParticles.STYXIAN_FLAME_PARTICLE;
    }

    protected boolean isBurning() {
        return false;
    }
}
