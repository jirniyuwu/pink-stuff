package net.jirniy.pinkstuff.enchantment.custom;

import com.mojang.serialization.MapCodec;
import jdk.jshell.Snippet;
import net.jirniy.pinkstuff.effect.ModEffects;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public record CloudPiercerEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<CloudPiercerEnchantmentEffect> CODEC = MapCodec.unit(CloudPiercerEnchantmentEffect::new);

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity target, Vec3d pos) {
        LivingEntity owner = context.owner();
        if (owner != null) {
            if (owner.hasStatusEffect(ModEffects.CLOUD_PIERCER)) {
                StatusEffectInstance effectInstance = owner.getStatusEffect(ModEffects.CLOUD_PIERCER);
                owner.setStatusEffect(new StatusEffectInstance(ModEffects.CLOUD_PIERCER, 20, Math.min(effectInstance.getAmplifier() + 1, 9)), owner);
            } else {
                owner.setStatusEffect(new StatusEffectInstance(ModEffects.CLOUD_PIERCER, 20, 0), owner);
            }
            if (owner.hasVehicle() && owner.getVehicle().isLiving()) {
                LivingEntity vehicle = (LivingEntity) owner.getVehicle();
                if (vehicle.canHaveStatusEffect(new StatusEffectInstance(ModEffects.CLOUD_PIERCER))) {
                    if (vehicle.hasStatusEffect(ModEffects.CLOUD_PIERCER)) {
                        StatusEffectInstance effectInstance = vehicle.getStatusEffect(ModEffects.CLOUD_PIERCER);
                        vehicle.setStatusEffect(new StatusEffectInstance(ModEffects.CLOUD_PIERCER, 20, Math.min(effectInstance.getAmplifier() + 1, 9)), owner);
                    } else {
                        vehicle.setStatusEffect(new StatusEffectInstance(ModEffects.CLOUD_PIERCER, 20, 0), owner);
                    }
                }
            }
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
