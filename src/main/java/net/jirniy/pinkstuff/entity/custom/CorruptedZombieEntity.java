package net.jirniy.pinkstuff.entity.custom;

import net.jirniy.pinkstuff.effect.ModEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class CorruptedZombieEntity extends ZombieEntity {
    public CorruptedZombieEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public boolean isInvulnerableTo(ServerWorld world, DamageSource source) {
        if (source == world.getDamageSources().wither()) {
            return true;
        }
        return super.isInvulnerableTo(world, source);
    }

    public boolean tryAttack(ServerWorld world, Entity target) {
        boolean bl = super.tryAttack(world, target);
        if (bl && this.getMainHandStack().isEmpty() && target instanceof LivingEntity) {
            float f = this.getWorld().getLocalDifficulty(this.getBlockPos()).getLocalDifficulty();
            ((LivingEntity)target).addStatusEffect(new StatusEffectInstance(ModEffects.DEATH_GRIP, 80 * (int)f, 1), this);
        }

        return bl;
    }


    @Override
    protected int getBurningDuration() {
        return 0;
    }
    @Override
    public boolean isOnFire() {
        return false;
    }
    protected boolean burnsInDaylight() {
        return false;
    }
    protected boolean canConvertInWater() {
        return false;
    }

    public static boolean canSpawn(EntityType<? extends HostileEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return world.getDifficulty() != Difficulty.PEACEFUL && (SpawnReason.isAnySpawner(spawnReason) || world.getLightLevel(LightType.BLOCK, pos) <= 0) && canMobSpawn(type, world, spawnReason, pos, random);
    }
}
