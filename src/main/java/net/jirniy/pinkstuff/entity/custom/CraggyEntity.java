package net.jirniy.pinkstuff.entity.custom;

import net.jirniy.pinkstuff.util.ModDamageTypes;
import net.minecraft.entity.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.*;
import org.jetbrains.annotations.Nullable;

public class CraggyEntity extends ZombieEntity {
    public CraggyEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public boolean isInvulnerableTo(ServerWorld world, DamageSource source) {
        if (source.isOf(ModDamageTypes.SPIKE_TRAP)) {
            return true;
        }
        return super.isInvulnerableTo(world, source);
    }

    public boolean tryAttack(ServerWorld world, Entity target) {
        boolean bl = super.tryAttack(world, target);
        if (bl && this.getMainHandStack().isEmpty() && target instanceof LivingEntity) {
            float f = world.getLocalDifficulty(this.getBlockPos()).getLocalDifficulty();
            ((LivingEntity)target).addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 80 * (int)f, 1), this);
        }

        return bl;
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.FOLLOW_RANGE, (double)25.0F)
                .add(EntityAttributes.MOVEMENT_SPEED, (double)0.33F)
                .add(EntityAttributes.ATTACK_DAMAGE, (double)4.0F)
                .add(EntityAttributes.ARMOR, (double)4.0F)
                .add(EntityAttributes.SCALE, (double)0.7F)
                .add(EntityAttributes.SPAWN_REINFORCEMENTS);
    }

    @Override
    public float getSoundPitch() {
        return (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.3F;
    }

    @Override
    protected void initEquipment(Random random, LocalDifficulty localDifficulty) {}

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
