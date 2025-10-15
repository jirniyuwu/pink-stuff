package net.jirniy.pinkstuff.entity.custom;

import net.jirniy.pinkstuff.entity.ModEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ProjectileDeflection;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.EnumSet;

public class AmethystBlazeEntity extends BlazeEntity {
    public AmethystBlazeEntity(EntityType<? extends BlazeEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public boolean isOnFire() {
        return false;
    }

    protected void initGoals() {
        this.goalSelector.add(4, new ShootGoal(this));
        this.goalSelector.add(5, new GoToWalkTargetGoal(this, (double)1.0F));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, (double)1.0F, 0.0F));
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(1, (new RevengeGoal(this, new Class[0])).setGroupRevenge(new Class[0]));
        this.targetSelector.add(2, new ActiveTargetGoal(this, PlayerEntity.class, true));
    }

    @Override
    public boolean isInvulnerableTo(ServerWorld world, DamageSource source) {
        if (source.getAttacker() != null && source.getAttacker().getType() == ModEntities.AMETHYST_BLAZE
        || source.isOf(DamageTypes.INDIRECT_MAGIC) || source.isOf(DamageTypes.MAGIC)) {
            return true;
        }
        return super.isInvulnerableTo(world, source);
    }

    public static DefaultAttributeContainer.Builder createAmethystBlazeAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.SCALE, 1.2F)
                .add(EntityAttributes.MAX_HEALTH, 40.0F)
                .add(EntityAttributes.ATTACK_DAMAGE, (double)8.0F)
                .add(EntityAttributes.MOVEMENT_SPEED, (double)0.3F)
                .add(EntityAttributes.FOLLOW_RANGE, (double)64.0F)
                .add(EntityAttributes.FALL_DAMAGE_MULTIPLIER, 0.0F);
    }

    @Override
    public ProjectileDeflection getProjectileDeflection(ProjectileEntity projectile) {
        return ProjectileDeflection.REDIRECTED;
    }

    static class ShootGoal extends Goal {
        private final AmethystBlazeEntity blaze;
        private int fireballsFired;
        private int fireballCooldown;
        private int targetNotVisibleTicks;

        public ShootGoal(AmethystBlazeEntity blaze) {
            this.blaze = blaze;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
        }

        public boolean canStart() {
            LivingEntity livingEntity = this.blaze.getTarget();
            return livingEntity != null && livingEntity.isAlive() && this.blaze.canTarget(livingEntity);
        }

        public void start() {
            this.fireballsFired = 0;
        }

        public void stop() {
            this.targetNotVisibleTicks = 0;
        }

        public boolean shouldRunEveryTick() {
            return true;
        }

        public void tick() {
            --this.fireballCooldown;
            LivingEntity livingEntity = this.blaze.getTarget();
            if (livingEntity != null) {
                boolean bl = this.blaze.getVisibilityCache().canSee(livingEntity);
                if (bl) {
                    this.targetNotVisibleTicks = 0;
                } else {
                    ++this.targetNotVisibleTicks;
                }

                double d = this.blaze.squaredDistanceTo(livingEntity);
                if (d < (double)4.0F) {
                    if (!bl) {
                        return;
                    }

                    if (this.fireballCooldown <= 0) {
                        this.fireballCooldown = 20;
                        this.blaze.tryAttack(getServerWorld(this.blaze), livingEntity);
                    }

                    this.blaze.getMoveControl().moveTo(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), (double)1.0F);
                } else if (d < this.getFollowRange() * this.getFollowRange() && bl) {
                    double e = livingEntity.getX() - this.blaze.getX();
                    double f = livingEntity.getBodyY((double)1.5F) - this.blaze.getBodyY((double)0.5F);
                    double g = livingEntity.getZ() - this.blaze.getZ();
                    if (this.fireballCooldown <= 0) {
                        ++this.fireballsFired;
                        if (this.fireballsFired == 1) {
                            this.fireballCooldown = 60;
                        } else if (this.fireballsFired <= 4) {
                            this.fireballCooldown = 6;
                        } else {
                            this.fireballCooldown = 100;
                            this.fireballsFired = 0;
                        }

                        if (this.fireballsFired > 1) {
                            double h = Math.sqrt(Math.sqrt(d)) * (double)0.5F;
                            if (!this.blaze.isSilent()) {
                                this.blaze.getEntityWorld().syncWorldEvent((Entity)null, 1018, this.blaze.getBlockPos(), 0);
                            }

                            for(int i = 0; i < 1; ++i) {
                                Vec3d vec3d = new Vec3d(this.blaze.getRandom().nextTriangular(e, 2.297 * h), f, this.blaze.getRandom().nextTriangular(g, 2.297 * h));
                                AmethystFireballEntity smallFireballEntity = new AmethystFireballEntity(ModEntities.AMETHYST_FIREBALL, blaze.getEntityWorld());
                                smallFireballEntity.setVelocityWithAcceleration(vec3d.normalize(), 0.1f);
                                smallFireballEntity.setRotation(blaze.getYaw(), blaze.getPitch());
                                smallFireballEntity.setPosition(blaze.getX(), this.blaze.getBodyY((double)0.5F) + (double)0.5F, blaze.getZ());
                                smallFireballEntity.refreshPosition();
                                smallFireballEntity.setOwner(blaze);
                                this.blaze.getEntityWorld().spawnEntity(smallFireballEntity);
                            }
                        }
                    }

                    this.blaze.getLookControl().lookAt(livingEntity, 10.0F, 10.0F);
                } else if (this.targetNotVisibleTicks < 5) {
                    this.blaze.getMoveControl().moveTo(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), (double)1.0F);
                }

                super.tick();
            }
        }

        private double getFollowRange() {
            return this.blaze.getAttributeValue(EntityAttributes.FOLLOW_RANGE);
        }
    }
}
