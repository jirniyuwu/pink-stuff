package net.jirniy.pinkstuff.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.world.ServerWorld;

public class GroundedEffect extends StatusEffect {
    public GroundedEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        if (entity.isGliding()) {
            entity.stopGliding();
        }
        if (entity.hasStatusEffect(StatusEffects.LEVITATION)) {
            entity.removeStatusEffect(StatusEffects.LEVITATION);
            entity.removeStatusEffect(ModEffects.GROUNDED);
        }
        return super.applyUpdateEffect(world, entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
