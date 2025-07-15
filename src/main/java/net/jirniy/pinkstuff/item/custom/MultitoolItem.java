package net.jirniy.pinkstuff.item.custom;

import net.jirniy.pinkstuff.util.ModTags;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import java.util.ArrayList;
import java.util.List;

public class MultitoolItem extends Item {
    public MultitoolItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(settings.tool(material, ModTags.Blocks.ALL_MINEABLE, attackDamage, attackSpeed, 0.0f));
    }
}