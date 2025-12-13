package net.jirniy.pinkstuff.effect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.server.world.ServerWorld;

public class CloudPiercerStatusEffect extends StatusEffect {
    public CloudPiercerStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        entity.setStatusEffect(new StatusEffectInstance(ModEffects.CLOUD_PIERCER, 19, amplifier - 1), entity);
        return true;
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration <= 2 && amplifier >= 1;
    }
}
