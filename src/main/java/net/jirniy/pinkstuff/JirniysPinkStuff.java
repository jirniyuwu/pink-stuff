package net.jirniy.pinkstuff;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.block.entity.ModBlockEntities;
import net.jirniy.pinkstuff.component.ModDataComponentTypes;
import net.jirniy.pinkstuff.enchantment.ModEnchantmentEffects;
import net.jirniy.pinkstuff.entity.ModEntities;
import net.jirniy.pinkstuff.entity.custom.CrawlerEntity;
import net.jirniy.pinkstuff.item.ModItemGroups;
import net.jirniy.pinkstuff.item.ModItems;
import net.jirniy.pinkstuff.recipe.ModRecipes;
import net.jirniy.pinkstuff.screen.ModScreenHandlers;
import net.jirniy.pinkstuff.util.HammerUsageEvent;
import net.jirniy.pinkstuff.world.gen.ModWorldGeneration;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;
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
		ModEnchantmentEffects.registerEnchantmentEffects();
		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();
		ModRecipes.registerRecipes();
		ModEntities.registerModEntities();

		StrippableBlockRegistry.register(ModBlocks.CRYSTAL_CHERRY_LOG, ModBlocks.STRIPPED_CRYSTAL_CHERRY_LOG);
		StrippableBlockRegistry.register(ModBlocks.CRYSTAL_CHERRY_WOOD, ModBlocks.STRIPPED_CRYSTAL_CHERRY_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CRYSTAL_CHERRY_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CRYSTAL_CHERRY_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_CRYSTAL_CHERRY_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_CRYSTAL_CHERRY_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CRYSTAL_CHERRY_LEAVES, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CRYSTAL_CHERRY_PLANKS, 5, 20);

		FuelRegistryEvents.BUILD.register((builder, context) -> {
			builder.add(ModItems.THERMIUM, 32000);
			builder.add(ModItems.THERMIUM_NUGGET, 3200);
		});

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());

		FabricDefaultAttributeRegistry.register(ModEntities.CRAWLER, CrawlerEntity.createAttributes());

		TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 3, factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 34),
					new ItemStack(ModItems.SWORDMASTER_SMITHING_TEMPLATE, 8), 2, 7, 0.08f));
		});
		TradeOfferHelper.registerWanderingTraderOffers(factories -> {
			factories.addAll(Identifier.of(JirniysPinkStuff.MOD_ID, "emerald_for_kunzite"), (entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 10),
					new ItemStack(ModItems.KUNZITE, 4), 5, 7, 0.04f));
			factories.addAll(Identifier.of(JirniysPinkStuff.MOD_ID, "emerald_for_pink_bits"), (entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 2),
					new ItemStack(ModItems.PINK_BITS, 3), 17, 7, 0.04f));
		});
	}
}