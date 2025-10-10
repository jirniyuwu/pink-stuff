package net.jirniy.pinkstuff.block.custom;

import com.mojang.serialization.MapCodec;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.effect.ModEffects;
import net.jirniy.pinkstuff.util.ModGamerules;
import net.jirniy.pinkstuff.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.TranslucentBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.GameMode;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class FragileBlock extends Block {
    public final int BREAK_CHANCE;

    public FragileBlock(int breakChance, Settings settings) {
        super(settings);
        this.BREAK_CHANCE = breakChance;
    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, double fallDistance) {
        if (!world.isClient() && entity instanceof LivingEntity livingEntity && fallDistance >= 0.5) {
            if (!livingEntity.hasStatusEffect(StatusEffects.SLOW_FALLING) && (livingEntity.getRandom().nextBetween(1, this.BREAK_CHANCE) == 1 || fallDistance >= 3)) {
                world.breakBlock(pos, true, livingEntity);
                world.playSound(livingEntity, pos, SoundEvents.ENTITY_SPLASH_POTION_BREAK, SoundCategory.BLOCKS);
            }
        }
        super.onLandedUpon(world, state, pos, entity, fallDistance);
    }
}
