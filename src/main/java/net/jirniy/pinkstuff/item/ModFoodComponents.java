package net.jirniy.pinkstuff.item;

import net.jirniy.pinkstuff.effect.ModEffects;
import net.minecraft.component.type.ConsumableComponent;
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

    public static final FoodComponent GEM_BERRY = new FoodComponent.Builder().nutrition(2).saturationModifier(0.2f).build();
    public static final ConsumableComponent GEM_BERRY_EFFECT = food().consumeSeconds(0.8F).build();

    public static final FoodComponent CHARMBERRY = new FoodComponent.Builder().nutrition(2).saturationModifier(0.5f).build();
    public static final ConsumableComponent CHARMBERRY_EFFECT = food().consumeSeconds(1F)
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20, 0), 0.8f)).build();

    public static final FoodComponent BERRY_SALAD = new FoodComponent.Builder().nutrition(5).saturationModifier(0.7f).build();
    public static final ConsumableComponent BERRY_SALAD_EFFECT = food().consumeEffect(new ApplyEffectsConsumeEffect(
            new StatusEffectInstance(StatusEffects.REGENERATION, 100, 0), 1f)).build();
    public static final FoodComponent FLESHY_STEW = new FoodComponent.Builder().nutrition(7).saturationModifier(0.3f).build();
    public static final ConsumableComponent FLESHY_STEW_EFFECT = food().consumeEffect(new ApplyEffectsConsumeEffect(
            new StatusEffectInstance(StatusEffects.HUNGER, 200, 0), 0.6f)).build();

    public static final FoodComponent RAW_FAIRY_MEAT = new FoodComponent.Builder().nutrition(2).saturationModifier(0.5f).build();
    public static final ConsumableComponent RAW_FAIRY_MEAT_EFFECT = food().build();
    public static final FoodComponent COOKED_FAIRY_MEAT = new FoodComponent.Builder().nutrition(5).saturationModifier(0.8f).build();
    public static final ConsumableComponent COOKED_FAIRY_MEAT_EFFECT = food().consumeEffect(new ApplyEffectsConsumeEffect(
            new StatusEffectInstance(StatusEffects.REGENERATION, 160, 0), 0.8f)).build();


    public static final FoodComponent MATURE_SPROUT = new FoodComponent.Builder().nutrition(2).saturationModifier(0.4f).build();
    public static final ConsumableComponent MATURE_SPROUT_EFFECT = food().consumeEffect(new ApplyEffectsConsumeEffect(
            new StatusEffectInstance(ModEffects.DEATH_GRIP, 160, 1), 0.8f)).build();
    public static final FoodComponent DEAD_SPROUT = new FoodComponent.Builder().nutrition(6).saturationModifier(0.2f).build();
    public static final ConsumableComponent DEAD_SPROUT_EFFECT = food().build();

    public static final FoodComponent COAL_MEAL = new FoodComponent.Builder().nutrition(1).saturationModifier(0.2f).build();
    public static final ConsumableComponent COAL_MEAL_EFFECT = food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.POISON, 80, 0), 1f)).build();

    public static final FoodComponent HAZEWEAVER = new FoodComponent.Builder().nutrition(4).saturationModifier(0f).build();
    public static final ConsumableComponent HAZEWEAVER_EFFECT = food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.POISON, 40, 0), 0.6f)).build();

    public static final FoodComponent GODFRUIT = new FoodComponent.Builder().nutrition(20).saturationModifier(2.8f).alwaysEdible().build();
    public static final ConsumableComponent GODFRUIT_EFFECT = food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 0), 1f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 200, 0), 1f)).build();

    public static final FoodComponent GLAZED_CHORUS_FRUIT = new FoodComponent.Builder().nutrition(7).saturationModifier(0.6f).build();
    public static final ConsumableComponent GLAZED_CHORUS_FRUIT_EFFECT = food().consumeSeconds(2).build();
}
