package net.jirniy.pinkstuff.block.entity.custom;

import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.block.entity.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class LavaGeyserBlockEntity extends BlockEntity {
    private int cooldown = 0;
    private int maxCooldown = 400;
    private int duration = 80;
    private int fireTicks = 160;
    private float burnDamage = 1f;

    public LavaGeyserBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.LAVA_GEYSER_BE, pos, state);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if (!world.isClient()) {
            ServerWorld serverWorld = (ServerWorld) world;
            if (this.cooldown >= this.maxCooldown) {
                burn(serverWorld, pos);
                if (this.cooldown >= this.maxCooldown + this.duration) {
                    stopBurning(world);
                }
            } else {
                this.cooldown += world.isRaining() ? world.getRandom().nextBetween(1, 4) : 1;
                if (this.cooldown >= 0.8 * this.maxCooldown) {
                    serverWorld.spawnParticles(ParticleTypes.SMOKE, pos.getX() + 0.5, pos.getY() + 0.2, pos.getZ() + 0.5,
                            1, 0.1, 0.1, 0.1, 0.02);
                }
            }
        }
    }

    private void stopBurning(World world) {
        this.cooldown = 0;
        world.playSound(null, pos, SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.BLOCKS, 1f, 1f);
    }

    private void burn(ServerWorld serverWorld, BlockPos pos) {
        if (burnDamage != 0) {
            List<LivingEntity> entitiesHit = serverWorld.getNonSpectatingEntities(LivingEntity.class,
                    Box.of(new Vec3d(pos.getX() + 0.5, pos.getY() + 0.9, pos.getZ() + 0.5), 0.6, 1.8, 0.6));
            if (!entitiesHit.isEmpty()) {
                for(LivingEntity livingEntity : entitiesHit) {
                    if (!livingEntity.isInvulnerableTo(serverWorld, serverWorld.getDamageSources().lava())) {
                        livingEntity.damage(serverWorld, serverWorld.getDamageSources().lava(), burnDamage);
                    }
                    livingEntity.setOnFireForTicks(fireTicks);
                }
            }
        }
        if (fireTicks > 0) {
            List<LivingEntity> entitiesFire = serverWorld.getNonSpectatingEntities(LivingEntity.class,
                    Box.of(new Vec3d(pos.getX() + 0.5, pos.getY() + 1.4, pos.getZ() + 0.5), 1.5, 2.8, 1.5));
            if (!entitiesFire.isEmpty()) {
                for(LivingEntity livingEntity : entitiesFire) {
                    livingEntity.setOnFireForTicks(fireTicks/2);
                }
            }

        }
        serverWorld.spawnParticles(ParticleTypes.LAVA, pos.getX() + 0.5, pos.getY() + 0.2, pos.getZ() + 0.5,
                2, 0, 0.1, 0, 1);
        if (serverWorld.getRandom().nextBetween(0, 8) == 0) {
            serverWorld.playSound(null, pos, SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.BLOCKS, 0.4f, 1f);
        }
        this.cooldown++;
    }

    @Override
    protected void writeData(WriteView view) {
        super.writeData(view);
        view.putInt("cooldown", cooldown);
        view.putInt("max_cooldown", maxCooldown);
        view.putInt("duration", duration);
        view.putInt("fire_ticks", fireTicks);
        view.putFloat("burn_damage", burnDamage);
    }

    @Override
    protected void readData(ReadView view) {
        cooldown = view.getInt("cooldown", 0);
        maxCooldown = view.getInt("max_cooldown", 400);
        duration = view.getInt("duration", 80);
        fireTicks = view.getInt("fire_ticks", 160);
        burnDamage = view.getFloat("burn_damage", 1f);
        super.readData(view);
    }
}