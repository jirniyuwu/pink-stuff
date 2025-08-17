package net.jirniy.pinkstuff.util;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.minecraft.world.GameRules;

public class ModGamerules {
    public static final GameRules.Key<GameRules.BooleanRule> DISABLE_CORRUPTION_SPREAD =
            GameRuleRegistry.register("disableCorruptionSpread", GameRules.Category.UPDATES, GameRuleFactory.createBooleanRule(false));
    public static final GameRules.Key<GameRules.IntRule> CORRUPTION_SPREAD_CHANCE =
            GameRuleRegistry.register("corruptionSpreadChance", GameRules.Category.UPDATES, GameRuleFactory.createIntRule(60));


    public static void registerGamerules() {
        JirniysPinkStuff.LOGGER.info("Registering Gamerules for " + JirniysPinkStuff.MOD_ID);
    }
}
