package net.jirniy.pinkstuff.entity.custom;

import net.jirniy.pinkstuff.effect.ModEffects;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CorruptedSkeletonEntity extends SkeletonEntity {
    public CorruptedSkeletonEntity(EntityType<? extends CorruptedSkeletonEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public boolean isInvulnerableTo(ServerWorld world, DamageSource source) {
        if (source == world.getDamageSources().wither()) {
            return true;
        }
        return super.isInvulnerableTo(world, source);
    }

    protected PersistentProjectileEntity createArrowProjectile(ItemStack arrow, float damageModifier, @Nullable ItemStack shotFrom) {
        PersistentProjectileEntity persistentProjectileEntity = super.createArrowProjectile(arrow, damageModifier, shotFrom);
        if (persistentProjectileEntity instanceof ArrowEntity) {
            float f = this.getWorld().getLocalDifficulty(this.getBlockPos()).getLocalDifficulty();
            ((ArrowEntity)persistentProjectileEntity).addEffect(new StatusEffectInstance(ModEffects.DEATH_GRIP, 80 * (int)f, 1));
        }

        return persistentProjectileEntity;
    }

    @Override
    protected int getBurningDuration() {
        return 0;
    }

    @Override
    public boolean isOnFire() {
        return false;
    }
}
