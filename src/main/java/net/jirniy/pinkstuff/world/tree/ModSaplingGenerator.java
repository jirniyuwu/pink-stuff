package net.jirniy.pinkstuff.world.tree;

import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModSaplingGenerator {
    public static final SaplingGenerator GEM_TREE = new SaplingGenerator(JirniysPinkStuff.MOD_ID + ":gem_tree",
            Optional.empty(), Optional.of(ModConfiguredFeatures.GEM_TREE_KEY), Optional.empty());
}
