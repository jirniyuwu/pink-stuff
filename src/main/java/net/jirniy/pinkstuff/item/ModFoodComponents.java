package net.jirniy.pinkstuff.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

import static net.minecraft.component.type.ConsumableComponents.food;

public class ModFoodComponents {
    public static final FoodComponent GELATINOUS_BUD = new FoodComponent.Builder().nutrition(4).saturationModifier(0.2f).build();
    public static final ConsumableComponent GELATINOUS_BUD_EFFECT = food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 400, 0), 1f)).build();

    public static final FoodComponent ELYSIUM_APPLE = new FoodComponent.Builder().nutrition(7).saturationModifier(0.8f).alwaysEdible().build();
    public static final ConsumableComponent ELYSIUM_APPLE_EFFECT = food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 0), 1f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 200, 0), 1f)).build();

    public static final FoodComponent CRYSTAL_CARROT = new FoodComponent.Builder().nutrition(7).saturationModifier(1.2f).build();
    public static final ConsumableComponent CRYSTAL_CARROT_EFFECT = food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 80, 0), 1f)).build();

    public static final FoodComponent GEM_BERRY = new FoodComponent.Builder().nutrition(3).saturationModifier(0.4f).build();
    public static final ConsumableComponent GEM_BERRY_EFFECT = food().consumeSeconds(0.8F).build();
}
