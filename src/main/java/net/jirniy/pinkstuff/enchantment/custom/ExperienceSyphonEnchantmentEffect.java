package net.jirniy.pinkstuff.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityType;
import net.jirniy.pinkstuff.effect.ModEffects;
import net.jirniy.pinkstuff.util.ModTags;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.MannequinEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public record ExperienceSyphonEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<ExperienceSyphonEnchantmentEffect> CODEC = MapCodec.unit(ExperienceSyphonEnchantmentEffect::new);

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity target, Vec3d pos) {
        if (target instanceof PlayerEntity victim) {
            if (context.owner() != null && context.owner() instanceof PlayerEntity player) {
                if (victim.totalExperience >= level) {
                    victim.addExperience(-level);
                    player.addExperience(level);
                } else if (victim.totalExperience > 0) {
                    int xp = victim.totalExperience;
                    victim.addExperience(-xp);
                    player.addExperience(xp);
                }
            }
        } else if (target instanceof LivingEntity victim) {
            if (context.owner() != null && context.owner() instanceof PlayerEntity player) {
                player.addExperience(1);
            }
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
