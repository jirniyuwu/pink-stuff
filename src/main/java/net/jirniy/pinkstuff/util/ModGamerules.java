package net.jirniy.pinkstuff.util;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleBuilder;
import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Identifier;
import net.minecraft.world.rule.*;
import org.jspecify.annotations.Nullable;

import java.util.Objects;
import java.util.function.ToIntFunction;

public class ModGamerules {
    public static final GameRule<Boolean> ENABLE_CORRUPTION_SPREAD =
            GameRuleBuilder.forBoolean(true).category(GameRuleCategory.UPDATES)
                    .buildAndRegister(Identifier.of(JirniysPinkStuff.MOD_ID, "spreadable_corruption"));
    public static final GameRule<Integer> CORRUPTION_SPREAD_CHANCE =
            GameRuleBuilder.forInteger(60).range(1, 65536).category(GameRuleCategory.UPDATES)
                    .buildAndRegister(Identifier.of(JirniysPinkStuff.MOD_ID, "corruption_spread_chance"));

    public static void registerGamerules() {
        JirniysPinkStuff.LOGGER.info("Registering Gamerules for " + JirniysPinkStuff.MOD_ID);
    }
}
