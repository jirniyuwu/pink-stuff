package net.jirniy.pinkstuff.item.custom;

import net.jirniy.pinkstuff.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SunblazeSwordItem extends Item {
    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.setOnFireForTicks(80);
        if (attacker.isPlayer()) {
            if (attacker.getRandom().nextInt(10) == 1) {
                attacker.addStatusEffect(new StatusEffectInstance(ModEffects.DAWNBREAKER, 80, 0));
            }
        }
        super.postHit(stack, target, attacker);
    }

    public SunblazeSwordItem(Settings settings) {
        super(settings);
    }
}