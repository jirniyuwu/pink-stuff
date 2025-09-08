package net.jirniy.pinkstuff.item.custom;

import net.jirniy.pinkstuff.effect.ModEffects;
import net.jirniy.pinkstuff.particle.ModParticles;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Box;
import net.minecraft.world.GameMode;
import net.minecraft.world.World;
import org.jetbrains.annotations.Async;

import java.util.List;

public class SunshadeItem extends Item {
    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!attacker.getWorld().isClient()) {
            ServerWorld serverWorld = (ServerWorld) attacker.getWorld();
            serverWorld.spawnParticles(ModParticles.CORRUPTION_POP_PARTICLE,
                    target.getX(), target.getY() + (target.getHeight())/2, target.getZ(),
                    10, 0.5, 0.5, 0.5, 0.1);
            handleStatusEffect(target, new StatusEffectInstance(ModEffects.DEATH_GRIP, 60, 0));
        }
        super.postHit(stack, target, attacker);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        world.playSound(user, user.getBlockPos(), SoundEvents.BLOCK_HONEY_BLOCK_PLACE, SoundCategory.PLAYERS);
        if (!world.isClient()) {
            ItemStack itemStack = user.getStackInHand(hand);
            ServerWorld serverWorld = (ServerWorld) world;
            List<LivingEntity> list = serverWorld.getNonSpectatingEntities(LivingEntity.class, Box.from(user.getPos()).expand(4, 2, 4));
            if (!list.isEmpty()) {
                for(LivingEntity livingEntity : list) {
                    if (livingEntity.getUuid() == user.getUuid()) {
                        continue;
                    }
                    livingEntity.damage(serverWorld, serverWorld.getDamageSources().create(DamageTypes.MAGIC, user), 2);
                    handleStatusEffect(livingEntity, new StatusEffectInstance(ModEffects.DEATH_GRIP, 160, 1));
                }
            }
            serverWorld.spawnParticles(ModParticles.CORRUPTION_POP_PARTICLE,
                    user.getX(), user.getY() + (user.getHeight())/2, user.getZ(),
                    200, 2.5, 1.5, 2.5, 0.1);
            serverWorld.spawnParticles(ModParticles.CERILLE_SLASH_PARTICLE,
                    user.getX(), user.getY() + (user.getHeight())/2, user.getZ(),
                    50, 2, 1, 2, 0);
            itemStack.damage(5, user);
            itemStack.finishUsing(world, user);
            return ActionResult.SUCCESS;
        }
        return super.use(world, user, hand);
    }

    protected void handleStatusEffect(LivingEntity livingEntity, StatusEffectInstance effect) {
        if (livingEntity instanceof PlayerEntity playerEntity) {
            if (playerEntity.getGameMode() == GameMode.SPECTATOR) {
                return;
            }
        }
        if (livingEntity.hasStatusEffect(effect.getEffectType())) {
            if ((livingEntity.getStatusEffect(effect.getEffectType()).getDuration() < effect.getDuration()) ||
                    livingEntity.getStatusEffect(effect.getEffectType()).getAmplifier() > effect.getAmplifier()) {
                livingEntity.addStatusEffect(effect);
            }
        } else {
            livingEntity.addStatusEffect(effect);
        }
    }

    public SunshadeItem(Settings settings) {
        super(settings);
    }
}