package net.jirniy.pinkstuff.block.custom;

import net.jirniy.pinkstuff.effect.ModEffects;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CorruptRootsBlock extends ModGrassBlock {
    public CorruptRootsBlock(TagKey<Block> block, Settings settings) {
        super(block, settings, 1, 1, 15, 10, 15);
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, EntityCollisionHandler handler) {
        applyStatusEffect(entity);
        super.onEntityCollision(state, world, pos, entity, handler);
    }

    @Override
    protected void onBlockBreakStart(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        applyStatusEffect(player);
        super.onBlockBreakStart(state, world, pos, player);
    }

    protected void applyStatusEffect(Entity entity) {
        if (entity instanceof LivingEntity livingEntity) {
            applyStatusEffect(livingEntity);
        }
    }

    protected void applyStatusEffect(LivingEntity livingEntity) {
        if (livingEntity.hasStatusEffect(ModEffects.DEATH_GRIP)) {
            if ((livingEntity.getStatusEffect(ModEffects.DEATH_GRIP).getDuration() < 40) || livingEntity.getStatusEffect(ModEffects.DEATH_GRIP).getAmplifier() > 0) {
                livingEntity.addStatusEffect(new StatusEffectInstance(ModEffects.DEATH_GRIP, 40, 0, false, false, true));
            }
        } else {
            livingEntity.addStatusEffect(new StatusEffectInstance(ModEffects.DEATH_GRIP, 40, 0, false, false, true));
        }
    }
}