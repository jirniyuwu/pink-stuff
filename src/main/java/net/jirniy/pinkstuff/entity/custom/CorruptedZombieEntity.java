package net.jirniy.pinkstuff.entity.custom;

import net.jirniy.pinkstuff.effect.ModEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class CorruptedZombieEntity extends ZombieEntity {
    public CorruptedZombieEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    public boolean tryAttack(ServerWorld world, Entity target) {
        boolean bl = super.tryAttack(world, target);
        if (bl && this.getMainHandStack().isEmpty() && target instanceof LivingEntity) {
            float f = this.getWorld().getLocalDifficulty(this.getBlockPos()).getLocalDifficulty();
            ((LivingEntity)target).addStatusEffect(new StatusEffectInstance(ModEffects.DEATH_GRIP, 80 * (int)f, 1), this);
        }

        return bl;
    }

    protected boolean burnsInDaylight() {
        return false;
    }
    protected boolean canConvertInWater() {
        return false;
    }
}
