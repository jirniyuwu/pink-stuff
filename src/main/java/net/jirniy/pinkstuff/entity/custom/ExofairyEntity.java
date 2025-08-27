package net.jirniy.pinkstuff.entity.custom;

import net.jirniy.pinkstuff.effect.ModEffects;
import net.jirniy.pinkstuff.entity.ModEntities;
import net.jirniy.pinkstuff.item.ModItems;
import net.jirniy.pinkstuff.util.ModTags;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.AboveGroundTargeting;
import net.minecraft.entity.ai.NoPenaltySolidTargeting;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class ExofairyEntity extends AnimalEntity {

    public ExofairyEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
        this.moveControl = new FlightMoveControl(this, 20, true);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 20)
                .add(EntityAttributes.FOLLOW_RANGE, 30)
                .add(EntityAttributes.TEMPT_RANGE, 40)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.1)
                .add(EntityAttributes.JUMP_STRENGTH, 0.1)
                .add(EntityAttributes.FLYING_SPEED, 0.1)
                .add(EntityAttributes.SAFE_FALL_DISTANCE, 100);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new AnimalMateGoal(this, 1.15D));
        this.goalSelector.add(1, new FlyAwayFromDangerGoal(this, (double)1.25F));
        this.goalSelector.add(2, new TemptGoal(this, 1.1D, Ingredient.ofItems(ModItems.CHARMBERRY), false));
        this.goalSelector.add(3, new FollowParentGoal(this, 1.1D));
        this.goalSelector.add(4, new FlyGoal(this, 1.0D));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 4.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isIn(ModTags.Items.BERRIES);
    }

    protected EntityNavigation createNavigation(World world) {
        BirdNavigation birdNavigation = new BirdNavigation(this, world);
        birdNavigation.setCanOpenDoors(false);
        birdNavigation.setCanSwim(true);
        birdNavigation.setMaxFollowRange(48.0F);
        return birdNavigation;
    }
    public void travel(Vec3d movementInput) {
        this.travelFlying(movementInput, this.getMovementSpeed());
    }
    public boolean isFlappingWings() {
        return !this.isOnGround();
    }
    public void tickMovement() {
        super.tickMovement();
        if (!this.getWorld().isClient && this.isAlive() && this.age % 10 == 0) {
            PlayerEntity player = this.getWorld().getClosestPlayer(this, 5);
            if (player != null && !this.isInDanger()) {
                if (player.hasStatusEffect(ModEffects.FAIRY_SUPPORT)) {
                    if ((player.getStatusEffect(ModEffects.FAIRY_SUPPORT).getDuration() < 40) || player.getStatusEffect(ModEffects.FAIRY_SUPPORT).getAmplifier() > 0) {
                        player.addStatusEffect(new StatusEffectInstance(ModEffects.FAIRY_SUPPORT, 80, 0, true, false, true));
                    }
                } else {
                    player.addStatusEffect(new StatusEffectInstance(ModEffects.FAIRY_SUPPORT, 80, 0, true, false, true));
                }
            }
            this.heal(1.0F);
        }
    }

    protected boolean isInDanger() {
        return this.getRecentDamageSource() != null && this.getRecentDamageSource().isIn(DamageTypeTags.PANIC_CAUSES);
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.EXOFAIRY.create(world, SpawnReason.BREEDING);
    }

    public static boolean canSpawn(EntityType<ExofairyEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return world.getBlockState(pos.down()).isIn(BlockTags.DIRT);
    }

    private class FlyAwayFromDangerGoal extends Goal {
        protected final PathAwareEntity mob;
        protected final double speed;
        protected double targetX;
        protected double targetY;
        protected double targetZ;
        protected boolean active;

        public FlyAwayFromDangerGoal(PathAwareEntity mob, double speed) {
            this.mob = mob;
            this.speed = speed;
        }

        public boolean canStart() {
            if (!this.isInDanger()) {
                return false;
            }
            return this.findTarget();
        }
        protected boolean isInDanger() {
            return this.mob.getRecentDamageSource() != null && this.mob.getRecentDamageSource().isIn(DamageTypeTags.PANIC_CAUSES);
        }
        protected boolean findTarget() {
            PlayerEntity nearestPlayer = this.mob.getWorld().getClosestPlayer(this.mob, 10);
            Vec3d mobPos = this.mob.getRotationVec(0.0F);
            Vec3d vec3d;
            vec3d = AboveGroundTargeting.find(this.mob, 10, 6, mobPos.x, mobPos.z, ((float)Math.PI / 2F), 5, 1);
            if (vec3d == null) {
                vec3d = NoPenaltySolidTargeting.find(this.mob, 10, 6, -2, mobPos.x, mobPos.z, (double)((float)Math.PI / 2F));
            }
            if (vec3d == null) {
                return false;
            } else {
                this.targetX = vec3d.x;
                this.targetY = vec3d.y;
                this.targetZ = vec3d.z;
                return true;
            }
        }
        public void start() {
            this.mob.getNavigation().startMovingTo(this.targetX, this.targetY, this.targetZ, this.speed);
            this.active = true;
        }
        public boolean shouldContinue() {
            return !this.mob.getNavigation().isIdle();
        }
        public void stop() {
            this.active = false;
        }
    }
}
