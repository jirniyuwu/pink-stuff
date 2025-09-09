package net.jirniy.pinkstuff;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.*;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.block.entity.ModBlockEntities;
import net.jirniy.pinkstuff.component.ModDataComponentTypes;
import net.jirniy.pinkstuff.effect.ModEffects;
import net.jirniy.pinkstuff.enchantment.ModEnchantmentEffects;
import net.jirniy.pinkstuff.entity.ModEntities;
import net.jirniy.pinkstuff.entity.custom.AmethystBlazeEntity;
import net.jirniy.pinkstuff.entity.custom.CorruptionBlazeEntity;
import net.jirniy.pinkstuff.entity.custom.CrawlerEntity;
import net.jirniy.pinkstuff.entity.custom.ExofairyEntity;
import net.jirniy.pinkstuff.item.ModItemGroups;
import net.jirniy.pinkstuff.item.ModItems;
import net.jirniy.pinkstuff.particle.ModParticles;
import net.jirniy.pinkstuff.recipe.ModRecipes;
import net.jirniy.pinkstuff.screen.ModScreenHandlers;
import net.jirniy.pinkstuff.util.*;
import net.jirniy.pinkstuff.world.dimension.ModBiomes;
import net.jirniy.pinkstuff.world.dimension.ModDimensions;
import net.jirniy.pinkstuff.world.features.ModFeatures;
import net.jirniy.pinkstuff.world.features.ModTreeDecorators;
import net.jirniy.pinkstuff.world.gen.ModWorldGeneration;
import net.kyrptonaught.customportalapi.CustomPortalBlock;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;
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
		ModParticles.registerParticles();
		ModEffects.registerEffects();
		ModPotions.registerPotions();
		ModMapDecorations.registerMapDecorations();
		ModBiomes.registerBiomes();
		ModDimensions.registerDimensions();
		ModFeatures.registerFeatures();
		ModTreeDecorators.registerTreeDecorators();
		ModGamerules.registerGamerules();

		StrippableBlockRegistry.register(ModBlocks.CRYSTAL_CHERRY_LOG, ModBlocks.STRIPPED_CRYSTAL_CHERRY_LOG);
		StrippableBlockRegistry.register(ModBlocks.CRYSTAL_CHERRY_WOOD, ModBlocks.STRIPPED_CRYSTAL_CHERRY_WOOD);
		StrippableBlockRegistry.register(ModBlocks.CHORUS_LOG, ModBlocks.STRIPPED_CHORUS_LOG);
		StrippableBlockRegistry.register(ModBlocks.CHORUS_WOOD, ModBlocks.STRIPPED_CHORUS_WOOD);
		StrippableBlockRegistry.register(ModBlocks.ASHEN_LOG, ModBlocks.STRIPPED_ASHEN_LOG);
		StrippableBlockRegistry.register(ModBlocks.ASHEN_WOOD, ModBlocks.STRIPPED_ASHEN_WOOD);
		StrippableBlockRegistry.register(ModBlocks.KEAPHE_LOG, ModBlocks.STRIPPED_KEAPHE_LOG);
		StrippableBlockRegistry.register(ModBlocks.KEAPHE_WOOD, ModBlocks.STRIPPED_KEAPHE_WOOD);
		StrippableBlockRegistry.register(ModBlocks.WASTEWOOD_LOG, ModBlocks.STRIPPED_WASTEWOOD_LOG);
		StrippableBlockRegistry.register(ModBlocks.WASTEWOOD_WOOD, ModBlocks.STRIPPED_WASTEWOOD_WOOD);
		StrippableBlockRegistry.register(ModBlocks.CORRERIE_LOG, ModBlocks.STRIPPED_CORRERIE_LOG);
		StrippableBlockRegistry.register(ModBlocks.CORRERIE_WOOD, ModBlocks.STRIPPED_CORRERIE_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CRYSTAL_CHERRY_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CRYSTAL_CHERRY_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_CRYSTAL_CHERRY_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_CRYSTAL_CHERRY_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CRYSTAL_CHERRY_LEAVES, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.GLOWING_CHERRY_LEAVES, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CRYSTAL_CHERRY_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHORUS_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHORUS_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_CHORUS_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_CHORUS_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHORUS_LEAVES, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHORUS_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.KEAPHE_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.KEAPHE_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_KEAPHE_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_KEAPHE_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.KEAPHE_LEAVES, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.FLOWERING_KEAPHE_LEAVES, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.KEAPHE_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.WASTEWOOD_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.WASTEWOOD_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_WASTEWOOD_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_WASTEWOOD_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.WASTEWOOD_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CORRERIE_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CORRERIE_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_CORRERIE_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_CORRERIE_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CORRERIE_PLANKS, 5, 20);

		FuelRegistryEvents.BUILD.register((builder, context) -> {
			builder.add(ModItems.THERMIUM, 32000);
			builder.add(ModItems.THERMIUM_NUGGET, 3200);
			builder.add(ModItems.COAL_MEAL, 4400);
			builder.add(ModItems.SULFUR, 400);
			builder.add(ModBlocks.SULFUR_BLOCK, 3600);
			builder.add(ModItems.STYXCOAL, 1600);
			builder.add(ModBlocks.STYXCOAL_BLOCK, 16000);
			builder.add(ModItems.COTTON, 40);
		});

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
		AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			if (entity.isLiving() && !world.isClient()) {
				LivingEntity livingEntity = (LivingEntity) entity;
				ServerWorld serverWorld = (ServerWorld) world;
				if (player.hasStatusEffect(ModEffects.DAWNBREAKER)) {
					serverWorld.spawnParticles(ModParticles.DAWNBREAK_PARTICLE,
							entity.getX(), entity.getY() + (entity.getEyeHeight(entity.getPose()) / 1.5),
							entity.getZ(), 1, 0, 0, 0, 0);
					float healthAfter = livingEntity.getHealth() - (2 + player.getStatusEffect(ModEffects.DAWNBREAKER).getAmplifier());
					if (healthAfter <= 0) {
						livingEntity.setHealth(0.001f);
					} else {
						livingEntity.setHealth(healthAfter);
					}
					player.removeStatusEffect(ModEffects.DAWNBREAKER);
				}
			}
			return ActionResult.PASS;
		});
		AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			if (entity.isLiving() && !world.isClient()) {
				LivingEntity livingEntity = (LivingEntity) entity;
				ServerWorld serverWorld = (ServerWorld) world;
				if (player.hasStatusEffect(ModEffects.LIFE_TRADE)) {
					float damage = 1 + player.getStatusEffect(ModEffects.LIFE_TRADE).getAmplifier();
					float healthAfter = livingEntity.getHealth() - damage;
					if (healthAfter <= 0) {
						player.heal(damage * 4);
						livingEntity.setHealth(0.001f);
					} else {
						livingEntity.setHealth(healthAfter);
					}
					player.damage(serverWorld, serverWorld.getDamageSources().generic(), damage / 2);
				}
			}
			return ActionResult.PASS;
		});

		FabricDefaultAttributeRegistry.register(ModEntities.CRAWLER, CrawlerEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.EXOFAIRY, ExofairyEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.CORRUPTED_ZOMBIE, ZombieEntity.createZombieAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.CORRUPTED_SKELETON, SkeletonEntity.createAbstractSkeletonAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.AMETHYST_BLAZE, AmethystBlazeEntity.createAmethystBlazeAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.CORRUPTION_BLAZE, CorruptionBlazeEntity.createCorruptionBlazeAttributes());

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, ModItems.PREPARED_PINLINE, ModPotions.GROUNDED);
			builder.registerPotionRecipe(ModPotions.GROUNDED, Items.GLOWSTONE_DUST, ModPotions.STRONG_GROUNDED);

			builder.registerPotionRecipe(Potions.AWKWARD, ModItems.ELYSIUM_INGOT, ModPotions.LIFE_TRADE);
			builder.registerPotionRecipe(ModPotions.LIFE_TRADE, Items.GLOWSTONE_DUST, ModPotions.STRONG_LIFE_TRADE);
			builder.registerPotionRecipe(ModPotions.LIFE_TRADE, Items.REDSTONE, ModPotions.LONG_LIFE_TRADE);

			builder.registerPotionRecipe(Potions.AWKWARD, ModItems.MAGIC_GLITTER, ModPotions.FAIRY_SUPPORT);
			builder.registerPotionRecipe(ModPotions.FAIRY_SUPPORT, Items.GLOWSTONE_DUST, ModPotions.STRONG_FAIRY_SUPPORT);
			builder.registerPotionRecipe(ModPotions.FAIRY_SUPPORT, Items.REDSTONE, ModPotions.LONG_FAIRY_SUPPORT);

			builder.registerPotionRecipe(Potions.AWKWARD, ModItems.CERILLE_NUGGET, ModPotions.HEARTBREAK);
			builder.registerPotionRecipe(ModPotions.HEARTBREAK, Items.GLOWSTONE_DUST, ModPotions.STRONG_HEARTBREAK);
			builder.registerPotionRecipe(ModPotions.HEARTBREAK, Items.REDSTONE, ModPotions.LONG_HEARTBREAK);

			builder.registerPotionRecipe(Potions.AWKWARD, ModItems.RAW_MOONSTEEL, ModPotions.VULNERABILITY);
			builder.registerPotionRecipe(ModPotions.VULNERABILITY, Items.GLOWSTONE_DUST, ModPotions.STRONG_VULNERABILITY);
			builder.registerPotionRecipe(ModPotions.VULNERABILITY, Items.REDSTONE, ModPotions.LONG_VULNERABILITY);

			builder.registerPotionRecipe(Potions.AWKWARD, ModItems.CORRUPT_MASS, ModPotions.CORRUPT);
			builder.registerPotionRecipe(ModPotions.CORRUPT, Items.GLOWSTONE_DUST, ModPotions.STRONG_CORRUPT);

			builder.registerPotionRecipe(Potions.SLOW_FALLING, Items.FERMENTED_SPIDER_EYE, ModPotions.GROUNDED);
		});

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
					new TradedItem(Items.EMERALD, 1),
					new ItemStack(ModItems.SULFUR, 2), 3, 7, 0.04f));
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
			factories.addOffersToPool(TradeOfferHelper.WanderingTraderOffersBuilder.BUY_ITEMS_POOL, (entity, random) -> new TradeOffer(
					new TradedItem(ModItems.HAZEWEAVER, 1),
					new ItemStack(Items.EMERALD, 1), 10, 7, 0.04f));
			factories.addOffersToPool(TradeOfferHelper.WanderingTraderOffersBuilder.SELL_SPECIAL_ITEMS_POOL,
					(entity, random) -> new TradeOffers.SellMapFactory(
							5, ModTags.Structures.STYXIAN_PORTAL, "filled_map.pinkstuff.styxian_portal", ModMapDecorations.STYXIAN_PORTAL, 3, 12
			).create(entity, random));
		});
		TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 2, factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.GEM_BERRY, random.nextBetween(10, 30)),
					new ItemStack(Items.EMERALD, 1), 16, 7, 0.04f));
		});
		TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 3, factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.COTTON, random.nextBetween(3, 6)),
					new ItemStack(Items.EMERALD, 1), 16, 7, 0.06f));
		});
		TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 3, factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, random.nextBetween(20, 30)),
					new ItemStack(ModItems.ELYSIUM_APPLE, 1), 4, 7, 0.08f));
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, random.nextBetween(20, 30)),
					new ItemStack(ModItems.CRYSTAL_CARROT, 4), 4, 7, 0.08f));
		});
		TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 2, factories -> {
			factories.add((entity, random) -> new TradeOffers.SellMapFactory(
					15, ModTags.Structures.STYXIAN_PORTAL, "filled_map.pinkstuff.styxian_portal", ModMapDecorations.STYXIAN_PORTAL, 3, 12
			).create(entity, random));
		});
		TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER, 3, factories -> {
			factories.add((entity, random) -> new TradeOffers.SellMapFactory(
					30, ModTags.Structures.CHAMBERS, "filled_map.pinkstuff.chambers", ModMapDecorations.CHAMBERS, 3, 12
			).create(entity, random));
		});

		CustomPortalBuilder.beginPortal().flatPortal().forcedSize(3, 3).tintColor(0x341411)
				.frameBlock(ModBlocks.STYXIA_PORTAL_FRAME).lightWithItem(ModItems.MEMORY_SHARD).onlyLightInOverworld()
				.destDimID(Identifier.of(JirniysPinkStuff.MOD_ID, "styxia")).customPortalBlock((CustomPortalBlock) ModBlocks.STYXIA_PORTAL)
				.registerPortal();

		CompostingChanceRegistry.INSTANCE.add(ModItems.COTTON, 0.5F);
		CompostingChanceRegistry.INSTANCE.add(ModItems.COTTON_SEEDS, 0.25F);
	}
}