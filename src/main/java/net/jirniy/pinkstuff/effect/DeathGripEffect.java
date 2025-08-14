package net.jirniy.pinkstuff.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;

public class DeathGripEffect extends StatusEffect {
    int COOLDOWN;
    int TIME;

    public DeathGripEffect(int cooldown, StatusEffectCategory category, int color) {
        super(category, color);
        this.COOLDOWN = cooldown;
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        entity.damage(world, entity.getDamageSources().wither(), 1.0f);
        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        this.TIME += (1 + amplifier);
        if (this.TIME >= this.COOLDOWN) {
            this.TIME = 0;
            return true;
        }
        return false;
    }
}
