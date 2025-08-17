package net.jirniy.pinkstuff.effect;

import net.jirniy.pinkstuff.item.ModArmorMaterials;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.server.world.ServerWorld;

public class DeathGripEffect extends StatusEffect {
    int COOLDOWN;
    int TIME;

    public DeathGripEffect(int cooldown, StatusEffectCategory category, int color) {
        super(category, color);
        this.COOLDOWN = cooldown;
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        if (hasFullSuitOfArmorOn(entity.isPlayer() ? (PlayerEntity) entity : null)) {
            if (hasCorrectArmorOn(ModArmorMaterials.CERILLE_ARMOR_MATERIAL, (PlayerEntity) entity)) {
                entity.removeStatusEffect(ModEffects.DEATH_GRIP);
                return true;
            }
        }
        entity.damage(world, entity.getDamageSources().wither(), 1.0f);
        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        this.TIME += (1 + amplifier);
        if (this.TIME >= this.COOLDOWN) {
            this.TIME = 0;
            return true;
        }
        return false;
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        if (player == null) {
            return false;
        }
        ItemStack boots = player.getEquippedStack(EquipmentSlot.FEET);
        ItemStack leggings = player.getEquippedStack(EquipmentSlot.LEGS);
        ItemStack chestplate = player.getEquippedStack(EquipmentSlot.CHEST);
        ItemStack helmet = player.getEquippedStack(EquipmentSlot.HEAD);

        return !helmet.isEmpty() && !chestplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
        ItemStack boots = player.getEquippedStack(EquipmentSlot.FEET);
        ItemStack leggings = player.getEquippedStack(EquipmentSlot.LEGS);
        ItemStack chestplate = player.getEquippedStack(EquipmentSlot.CHEST);
        ItemStack helmet = player.getEquippedStack(EquipmentSlot.HEAD);

        EquippableComponent equippableComponentBoots = boots.getComponents().get(DataComponentTypes.EQUIPPABLE);
        EquippableComponent equippableComponentLeggings = leggings.getComponents().get(DataComponentTypes.EQUIPPABLE);
        EquippableComponent equippableComponentBreastplate = chestplate.getComponents().get(DataComponentTypes.EQUIPPABLE);
        EquippableComponent equippableComponentHelmet = helmet.getComponents().get(DataComponentTypes.EQUIPPABLE);

        return equippableComponentBoots.assetId().get().equals(material.assetId()) && equippableComponentLeggings.assetId().get().equals(material.assetId()) &&
                equippableComponentBreastplate.assetId().get().equals(material.assetId()) && equippableComponentHelmet.assetId().get().equals(material.assetId());
    }
}
