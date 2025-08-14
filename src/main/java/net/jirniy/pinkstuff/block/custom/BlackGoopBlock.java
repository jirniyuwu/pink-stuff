package net.jirniy.pinkstuff.block.custom;

import com.mojang.serialization.MapCodec;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.effect.ModEffects;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.TranslucentBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BlackGoopBlock extends TranslucentBlock {
    public static final MapCodec<BlackGoopBlock> CODEC = createCodec(BlackGoopBlock::new);

    public MapCodec<BlackGoopBlock> getCodec() {
        return CODEC;
    }

    public BlackGoopBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected void onBlockBreakStart(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        applyStatusEffect(player);
        super.onBlockBreakStart(state, world, pos, player);
    }

    @Override
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        if (!world.isClient() && state.getBlock() == ModBlocks.CORRUPT_ORE) {
            dropExperience((ServerWorld) world, pos, 10);
        }
        super.afterBreak(world, player, pos, state, blockEntity, tool);
    }

    @Override
    public void onEntityLand(BlockView world, Entity entity) {
        applyStatusEffect(entity);
        super.onEntityLand(world, entity);
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, EntityCollisionHandler handler) {
        applyStatusEffect(entity);
        super.onEntityCollision(state, world, pos, entity, handler);
    }

    protected void applyStatusEffect(Entity entity) {
        if (entity.getType() == EntityType.PLAYER) {
            final LivingEntity livingEntity = (LivingEntity) entity;
            if (livingEntity.hasStatusEffect(ModEffects.DEATH_GRIP)) {
                if ((livingEntity.getStatusEffect(ModEffects.DEATH_GRIP).getDuration() < 40) || livingEntity.getStatusEffect(ModEffects.DEATH_GRIP).getAmplifier() > 0) {
                    livingEntity.addStatusEffect(new StatusEffectInstance(ModEffects.DEATH_GRIP, 40, 0, false, false, true));
                }
            } else {
                livingEntity.addStatusEffect(new StatusEffectInstance(ModEffects.DEATH_GRIP, 40, 0, false, false, true));
            }
        }
    }

    protected void applyStatusEffect(PlayerEntity entity) {
        final LivingEntity livingEntity = (LivingEntity) entity;
        if (livingEntity.hasStatusEffect(ModEffects.DEATH_GRIP)) {
            if ((livingEntity.getStatusEffect(ModEffects.DEATH_GRIP).getDuration() < 40) || livingEntity.getStatusEffect(ModEffects.DEATH_GRIP).getAmplifier() > 0) {
                livingEntity.addStatusEffect(new StatusEffectInstance(ModEffects.DEATH_GRIP, 40, 0, false, false, true));
            }
        } else {
            livingEntity.addStatusEffect(new StatusEffectInstance(ModEffects.DEATH_GRIP, 40, 0, false, false, true));
        }
    }
}
