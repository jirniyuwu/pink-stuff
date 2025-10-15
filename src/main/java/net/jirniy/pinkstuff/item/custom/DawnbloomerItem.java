package net.jirniy.pinkstuff.item.custom;

import net.jirniy.pinkstuff.effect.ModEffects;
import net.jirniy.pinkstuff.particle.ModParticles;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.random.Random;

public class DawnbloomerItem extends Item {
    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Random random = attacker.getRandom();
        if (random.nextBetween(1, 10) == 1) {
            attacker.addStatusEffect(new StatusEffectInstance(
                    ModEffects.DAWNBREAKER, 80, 1));
        }
        if (!attacker.getEntityWorld().isClient()) {
            ServerWorld serverWorld = (ServerWorld) attacker.getEntityWorld();
            serverWorld.spawnParticles(ModParticles.RIFT_PARTICLE,
                    target.getX(), target.getY() + (target.getEyeHeight(target.getPose()) / 1.5),
                    target.getZ(), 1, 0, 0, 0, 0);
        }
        super.postHit(stack, target, attacker);
    }

    public DawnbloomerItem(Settings settings) {
        super(settings);
    }
}