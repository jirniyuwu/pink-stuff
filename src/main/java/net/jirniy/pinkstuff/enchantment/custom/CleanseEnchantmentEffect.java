package net.jirniy.pinkstuff.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.jirniy.pinkstuff.effect.ModEffects;
import net.jirniy.pinkstuff.util.ModTags;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public record CleanseEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<CleanseEnchantmentEffect> CODEC = MapCodec.unit(CleanseEnchantmentEffect::new);

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity target, Vec3d pos) {
        if (target instanceof LivingEntity victim) {
            if (context.owner() != null && context.owner() instanceof PlayerEntity player && victim.getType().isIn(ModTags.Entities.CLEANSE_APPLICABLE)) {
                player.heal((float) level / 4);
                if (player.hasStatusEffect(ModEffects.DEATH_GRIP) && player.getStatusEffect(ModEffects.DEATH_GRIP).getAmplifier() <= level / 2) {
                    player.removeStatusEffect(ModEffects.DEATH_GRIP);
                }
            }
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
