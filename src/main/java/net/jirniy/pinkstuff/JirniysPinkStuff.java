package net.jirniy.pinkstuff;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.block.entity.ModBlockEntities;
import net.jirniy.pinkstuff.component.ModDataComponentTypes;
import net.jirniy.pinkstuff.effect.ModEffects;
import net.jirniy.pinkstuff.enchantment.ModEnchantmentEffects;
import net.jirniy.pinkstuff.entity.ModEntities;
import net.jirniy.pinkstuff.entity.custom.CrawlerEntity;
import net.jirniy.pinkstuff.item.ModItemGroups;
import net.jirniy.pinkstuff.item.ModItems;
import net.jirniy.pinkstuff.particle.ModParticles;
import net.jirniy.pinkstuff.recipe.ModRecipes;
import net.jirniy.pinkstuff.screen.ModScreenHandlers;
import net.jirniy.pinkstuff.util.HammerUsageEvent;
import net.jirniy.pinkstuff.world.gen.ModWorldGeneration;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.ServerWorldAccess;
import org.apache.logging.log4j.core.jmx.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.jar.Attributes;

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
		ModParticles.registerParticles();
		ModEffects.registerEffects();

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
		AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			if (player.getMainHandStack().getItem() == ModItems.DAWNBLOOMER && !world.isClient()) {
				ServerWorld serverWorld = (ServerWorld) world;
				serverWorld.spawnParticles(ModParticles.RIFT_PARTICLE,
						entity.getX(), entity.getY() + (entity.getEyeHeight(entity.getPose()) / 1.5),
						entity.getZ(), 1, 0, 0, 0, 0);
			}
			if (player.hasStatusEffect(ModEffects.DAWNBREAKER) && !world.isClient()) {
				ServerWorld serverWorld = (ServerWorld) world;
				serverWorld.spawnParticles(ModParticles.DAWNBREAK_PARTICLE,
						entity.getX(), entity.getY() + (entity.getEyeHeight(entity.getPose()) / 1.5),
						entity.getZ(), 1, 0, 0, 0, 0);
				entity.damage((ServerWorld) world, world.getDamageSources().magic(),
						2 + player.getStatusEffect(ModEffects.DAWNBREAKER).getAmplifier());
				player.removeStatusEffect(ModEffects.DAWNBREAKER);
			}
			return ActionResult.PASS;
		});

		FabricDefaultAttributeRegistry.register(ModEntities.CRAWLER, CrawlerEntity.createAttributes());

		TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 3, factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, random.nextBetween(40, 60)),
					new ItemStack(ModItems.SWORDMASTER_SMITHING_TEMPLATE, 1), 2, 7, 0.04f));
		});
		TradeOfferHelper.registerWanderingTraderOffers(factories -> {
			factories.addOffersToPool(TradeOfferHelper.WanderingTraderOffersBuilder.SELL_COMMON_ITEMS_POOL, (entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, random.nextBetween(3, 5)),
					new ItemStack(ModItems.KUNZITE, random.nextBetween(3, 10)), 5, 7, 0.04f));
			factories.addOffersToPool(TradeOfferHelper.WanderingTraderOffersBuilder.SELL_COMMON_ITEMS_POOL, (entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 1),
					new ItemStack(ModBlocks.CRYSTAL_CHERRY_LOG, 8), 2, 7, 0.04f));
			factories.addOffersToPool(TradeOfferHelper.WanderingTraderOffersBuilder.SELL_COMMON_ITEMS_POOL, (entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 2),
					new ItemStack(ModItems.PINK_BITS, random.nextBetween(2, 18)), 17, 7, 0.04f));
			factories.addOffersToPool(TradeOfferHelper.WanderingTraderOffersBuilder.SELL_COMMON_ITEMS_POOL, (entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 2),
					new ItemStack(ModItems.GEM_BERRY, random.nextBetween(1, 4)), 5, 7, 0.04f));
			factories.addOffersToPool(TradeOfferHelper.WanderingTraderOffersBuilder.SELL_SPECIAL_ITEMS_POOL, (entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, random.nextBetween(30, 50)),
					new ItemStack(ModItems.CHESS_SMITHING_TEMPLATE, 1), 1, 7, 0.04f));
			factories.addOffersToPool(TradeOfferHelper.WanderingTraderOffersBuilder.SELL_SPECIAL_ITEMS_POOL, (entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, random.nextBetween(50, 64)),
					new ItemStack(ModItems.WANDERER_SMITHING_TEMPLATE, 1), 1, 7, 0.04f));
			factories.addOffersToPool(TradeOfferHelper.WanderingTraderOffersBuilder.SELL_SPECIAL_ITEMS_POOL, (entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, random.nextBetween(40, 64)),
					new ItemStack(ModItems.SWORDMASTER_SMITHING_TEMPLATE, 1), 1, 7, 0.04f));
			factories.addOffersToPool(TradeOfferHelper.WanderingTraderOffersBuilder.SELL_SPECIAL_ITEMS_POOL, (entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, random.nextBetween(20, 30)),
					new ItemStack(ModItems.ELYSIUM_APPLE, 1), 5, 7, 0.04f));
			factories.addOffersToPool(TradeOfferHelper.WanderingTraderOffersBuilder.BUY_ITEMS_POOL, (entity, random) -> new TradeOffer(
					new TradedItem(ModItems.GELATINOUS_BUD, 3),
					new ItemStack(Items.EMERALD, 1), 7, 7, 0.04f));
			factories.addOffersToPool(TradeOfferHelper.WanderingTraderOffersBuilder.BUY_ITEMS_POOL, (entity, random) -> new TradeOffer(
					new TradedItem(ModItems.ENERGIZED_THERMIUM, 1),
					new ItemStack(Items.EMERALD, random.nextBetween(20, 50)), 2, 7, 0.04f));
		});
	}
}