package net.jirniy.pinkstuff.item.custom;

import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import org.jetbrains.annotations.Nullable;

public class NetheriteElytraItem extends Item {

    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        if (entity instanceof PlayerEntity player && player.isGliding() && slot == EquipmentSlot.CHEST) {
            if (player.getMovement().length() >= 1) {
                world.spawnParticles(ParticleTypes.FLAME, player.getX(), player.getY() + player.getHeight() / 2, player.getZ(),
                        2, 0.1, 0.1, 0.1, 0.1
                );
            }
        }
        super.inventoryTick(stack, world, entity, slot);
    }

    public NetheriteElytraItem(Settings settings) {
        super(settings);
    }
}