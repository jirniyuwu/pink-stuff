package net.jirniy.pinkstuff;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.component.ModDataComponentTypes;
import net.jirniy.pinkstuff.item.ModItemGroups;
import net.jirniy.pinkstuff.item.ModItems;
import net.jirniy.pinkstuff.util.HammerUsageEvent;
import net.jirniy.pinkstuff.world.gen.ModWorldGeneration;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.FireBlock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JirniysPinkStuff implements ModInitializer {
	public static final String MOD_ID = "pinkstuff";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModDataComponentTypes.registerDataComponentTypes();
		ModWorldGeneration.generateModWorldGen();

		StrippableBlockRegistry.register(ModBlocks.CRYSTAL_CHERRY_LOG, ModBlocks.STRIPPED_CRYSTAL_CHERRY_LOG);
		StrippableBlockRegistry.register(ModBlocks.CRYSTAL_CHERRY_WOOD, ModBlocks.STRIPPED_CRYSTAL_CHERRY_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CRYSTAL_CHERRY_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CRYSTAL_CHERRY_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_CRYSTAL_CHERRY_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_CRYSTAL_CHERRY_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CRYSTAL_CHERRY_LEAVES, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CRYSTAL_CHERRY_PLANKS, 5, 20);

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
	}
}