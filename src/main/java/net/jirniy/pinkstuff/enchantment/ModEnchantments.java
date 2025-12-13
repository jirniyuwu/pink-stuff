package net.jirniy.pinkstuff.enchantment;

import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.enchantment.custom.CleanseEnchantmentEffect;
import net.jirniy.pinkstuff.enchantment.custom.ExperienceSyphonEnchantmentEffect;
import net.jirniy.pinkstuff.enchantment.custom.LightningEnchantmentEffect;
import net.jirniy.pinkstuff.util.ModTags;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.enchantment.effect.value.AddEnchantmentEffect;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.predicate.entity.EntityTypePredicate;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

public class ModEnchantments {

    public static final RegistryKey<Enchantment> LIGHTNING = RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(JirniysPinkStuff.MOD_ID, "lightning"));
    public static final RegistryKey<Enchantment> CLEANSE = RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(JirniysPinkStuff.MOD_ID, "cleanse"));
    public static final RegistryKey<Enchantment> XP_SYPHON = RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(JirniysPinkStuff.MOD_ID, "xp_syphon"));

    public static void bootstrap(Registerable<Enchantment> registerable) {
        var enchantments = registerable.getRegistryLookup(RegistryKeys.ENCHANTMENT);
        var items = registerable.getRegistryLookup(RegistryKeys.ITEM);

        register(registerable, LIGHTNING, new Enchantment.Builder(Enchantment.definition(
                items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                items.getOrThrow(ItemTags.MELEE_WEAPON_ENCHANTABLE),
                2,
                2,
                Enchantment.leveledCost(10, 10),
                Enchantment.leveledCost(27, 15),
                2,
                AttributeModifierSlot.MAINHAND
        ))
                .exclusiveSet(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK,
                        EnchantmentEffectTarget.ATTACKER, EnchantmentEffectTarget.VICTIM,
                        new LightningEnchantmentEffect()));

        register(registerable, XP_SYPHON, new Enchantment.Builder(Enchantment.definition(
                items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                items.getOrThrow(ItemTags.MELEE_WEAPON_ENCHANTABLE),
                6,
                5,
                Enchantment.leveledCost(13, 19),
                Enchantment.leveledCost(29, 25),
                3,
                AttributeModifierSlot.MAINHAND
        ))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK,
                        EnchantmentEffectTarget.ATTACKER, EnchantmentEffectTarget.VICTIM,
                        new ExperienceSyphonEnchantmentEffect()));

        register(registerable, CLEANSE, new Enchantment.Builder(Enchantment.definition(
                items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                items.getOrThrow(ItemTags.MELEE_WEAPON_ENCHANTABLE),
                5,
                4,
                Enchantment.leveledCost(4, 12),
                Enchantment.leveledCost(19, 9),
                2,
                AttributeModifierSlot.MAINHAND
        ))
                .exclusiveSet(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET))
                .addEffect(EnchantmentEffectComponentTypes.DAMAGE,
                        new AddEnchantmentEffect(EnchantmentLevelBasedValue.linear(2.5F)),
                        EntityPropertiesLootCondition.builder(LootContext.EntityReference.THIS,
                                net.minecraft.predicate.entity.EntityPredicate.Builder.create()
                                        .type(EntityTypePredicate.create(registerable.getRegistryLookup(RegistryKeys.ENTITY_TYPE),
                                                ModTags.Entities.CLEANSE_APPLICABLE))))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK,
                        EnchantmentEffectTarget.ATTACKER, EnchantmentEffectTarget.VICTIM,
                        new CleanseEnchantmentEffect()));
    }

    private static void register(Registerable<Enchantment> registry, RegistryKey<Enchantment> key, Enchantment.Builder builder) {
        registry.register(key, builder.build(key.getValue()));
    }
}
