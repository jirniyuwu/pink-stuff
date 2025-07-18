package net.jirniy.pinkstuff.item.custom;

import net.jirniy.pinkstuff.util.ModTags;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

public class MultitoolItem extends Item {
    public MultitoolItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(settings.tool(material, ModTags.Blocks.ALL_MINEABLE, attackDamage, attackSpeed, 0.0f));
    }
}