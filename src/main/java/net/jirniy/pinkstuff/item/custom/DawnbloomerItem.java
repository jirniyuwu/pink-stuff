package net.jirniy.pinkstuff.item.custom;

import net.jirniy.pinkstuff.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.random.Random;

public class DawnbloomerItem extends Item {
    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Random random = Random.create();
        if (random.nextBetween(1, 10) == 1) {
            attacker.addStatusEffect(new StatusEffectInstance(
                    ModEffects.DAWNBREAKER, 30, 1));
        }
        super.postHit(stack, target, attacker);
    }

    public DawnbloomerItem(Settings settings) {
        super(settings);
    }
}