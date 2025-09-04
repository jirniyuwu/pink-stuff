package net.jirniy.pinkstuff.item.custom;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Pair;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.util.ModTags;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.*;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MultitoolItem extends Item {
    protected static final Map<Block, BlockState> PATH_STATES;
    protected static final Map<Block, Pair<Predicate<ItemUsageContext>, Consumer<ItemUsageContext>>> TILLING_ACTIONS;
    protected static final Map<Block, Block> STRIPPED_BLOCKS;

    public MultitoolItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(settings.tool(material, ModTags.Blocks.ALL_MINEABLE, attackDamage, attackSpeed, 0.0f));
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (context.getWorld().getBlockState(context.getBlockPos()).isIn(BlockTags.LOGS) || context.getWorld().getBlockState(context.getBlockPos()).isIn(BlockTags.LOGS_THAT_BURN)) {
            return axeUseOnBlock(context);
        } else if (!context.getPlayer().isSneaking()) {
            return shovelUseOnBlock(context);
        } else if (context.getPlayer().isSneaking()) {
            return hoeUseOnBlock(context);
        }
        return ActionResult.PASS;
    }

    public ActionResult shovelUseOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        if (context.getSide() == Direction.DOWN) {
            return ActionResult.PASS;
        } else {
            PlayerEntity playerEntity = context.getPlayer();
            BlockState blockState2 = (BlockState)PATH_STATES.get(blockState.getBlock());
            BlockState blockState3 = null;
            if (blockState2 != null && world.getBlockState(blockPos.up()).isAir()) {
                world.playSound(playerEntity, blockPos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
                blockState3 = blockState2;
            } else if (blockState.getBlock() instanceof CampfireBlock && (Boolean)blockState.get(CampfireBlock.LIT)) {
                if (!world.isClient()) {
                    world.syncWorldEvent((Entity)null, 1009, blockPos, 0);
                }

                CampfireBlock.extinguish(context.getPlayer(), world, blockPos, blockState);
                blockState3 = (BlockState)blockState.with(CampfireBlock.LIT, false);
            }

            if (blockState3 != null) {
                if (!world.isClient) {
                    world.setBlockState(blockPos, blockState3, 11);
                    world.emitGameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Emitter.of(playerEntity, blockState3));
                    if (playerEntity != null) {
                        context.getStack().damage(1, playerEntity, LivingEntity.getSlotForHand(context.getHand()));
                    }
                }

                return ActionResult.SUCCESS;
            } else {
                return ActionResult.PASS;
            }
        }
    }

    public ActionResult hoeUseOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        Pair<Predicate<ItemUsageContext>, Consumer<ItemUsageContext>> pair = (Pair)TILLING_ACTIONS.get(world.getBlockState(blockPos).getBlock());
        if (pair == null) {
            return ActionResult.PASS;
        } else {
            Predicate<ItemUsageContext> predicate = (Predicate)pair.getFirst();
            Consumer<ItemUsageContext> consumer = (Consumer)pair.getSecond();
            if (predicate.test(context)) {
                PlayerEntity playerEntity = context.getPlayer();
                world.playSound(playerEntity, blockPos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
                if (!world.isClient) {
                    consumer.accept(context);
                    if (playerEntity != null) {
                        context.getStack().damage(1, playerEntity, LivingEntity.getSlotForHand(context.getHand()));
                    }
                }

                return ActionResult.SUCCESS;
            } else {
                return ActionResult.PASS;
            }
        }
    }

    public ActionResult axeUseOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        PlayerEntity playerEntity = context.getPlayer();
        if (shouldCancelStripAttempt(context)) {
            return ActionResult.PASS;
        } else {
            Optional<BlockState> optional = this.tryStrip(world, blockPos, playerEntity, world.getBlockState(blockPos));
            if (optional.isEmpty()) {
                return ActionResult.PASS;
            } else {
                ItemStack itemStack = context.getStack();
                if (playerEntity instanceof ServerPlayerEntity) {
                    Criteria.ITEM_USED_ON_BLOCK.trigger((ServerPlayerEntity)playerEntity, blockPos, itemStack);
                }

                world.setBlockState(blockPos, (BlockState)optional.get(), 11);
                world.emitGameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Emitter.of(playerEntity, (BlockState)optional.get()));
                if (playerEntity != null) {
                    itemStack.damage(1, playerEntity, LivingEntity.getSlotForHand(context.getHand()));
                }

                return ActionResult.SUCCESS;
            }
        }
    }

    public static Consumer<ItemUsageContext> createTillAction(BlockState result) {
        return (context) -> {
            context.getWorld().setBlockState(context.getBlockPos(), result, 11);
            context.getWorld().emitGameEvent(GameEvent.BLOCK_CHANGE, context.getBlockPos(), GameEvent.Emitter.of(context.getPlayer(), result));
        };
    }

    public static Consumer<ItemUsageContext> createTillAndDropAction(BlockState result, ItemConvertible droppedItem) {
        return (context) -> {
            context.getWorld().setBlockState(context.getBlockPos(), result, 11);
            context.getWorld().emitGameEvent(GameEvent.BLOCK_CHANGE, context.getBlockPos(), GameEvent.Emitter.of(context.getPlayer(), result));
            Block.dropStack(context.getWorld(), context.getBlockPos(), context.getSide(), new ItemStack(droppedItem));
        };
    }

    public static boolean canTillFarmland(ItemUsageContext context) {
        return context.getSide() != Direction.DOWN && context.getWorld().getBlockState(context.getBlockPos().up()).isAir();
    }

    private static boolean shouldCancelStripAttempt(ItemUsageContext context) {
        PlayerEntity playerEntity = context.getPlayer();
        return context.getHand().equals(Hand.MAIN_HAND) && playerEntity.getOffHandStack().contains(DataComponentTypes.BLOCKS_ATTACKS) && !playerEntity.shouldCancelInteraction();
    }

    private Optional<BlockState> tryStrip(World world, BlockPos pos, @Nullable PlayerEntity player, BlockState state) {
        Optional<BlockState> optional = this.getStrippedState(state);
        if (optional.isPresent()) {
            world.playSound(player, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            return optional;
        } else {
            Optional<BlockState> optional2 = Oxidizable.getDecreasedOxidationState(state);
            if (optional2.isPresent()) {
                world.playSound(player, pos, SoundEvents.ITEM_AXE_SCRAPE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                world.syncWorldEvent(player, 3005, pos, 0);
                return optional2;
            } else {
                Optional<BlockState> optional3 = Optional.ofNullable((Block)((BiMap)HoneycombItem.WAXED_TO_UNWAXED_BLOCKS.get()).get(state.getBlock())).map((block) -> block.getStateWithProperties(state));
                if (optional3.isPresent()) {
                    world.playSound(player, pos, SoundEvents.ITEM_AXE_WAX_OFF, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    world.syncWorldEvent(player, 3004, pos, 0);
                    return optional3;
                } else {
                    return Optional.empty();
                }
            }
        }
    }

    private Optional<BlockState> getStrippedState(BlockState state) {
        return Optional.ofNullable((Block)STRIPPED_BLOCKS.get(state.getBlock())).map((block) -> (BlockState)block.getDefaultState().with(PillarBlock.AXIS, (Direction.Axis)state.get(PillarBlock.AXIS)));
    }

    static {
        PATH_STATES = Maps.newHashMap((new ImmutableMap.Builder())
                .put(Blocks.GRASS_BLOCK, Blocks.DIRT_PATH.getDefaultState())
                .put(Blocks.DIRT, Blocks.DIRT_PATH.getDefaultState())
                .put(Blocks.PODZOL, Blocks.DIRT_PATH.getDefaultState())
                .put(Blocks.COARSE_DIRT, Blocks.DIRT_PATH.getDefaultState())
                .put(Blocks.MYCELIUM, Blocks.DIRT_PATH.getDefaultState())
                .put(Blocks.ROOTED_DIRT, Blocks.DIRT_PATH.getDefaultState()).build());
        TILLING_ACTIONS = Maps.newHashMap(ImmutableMap
                .of(Blocks.GRASS_BLOCK, Pair.of(HoeItem::canTillFarmland, createTillAction(Blocks.FARMLAND.getDefaultState())),
                        Blocks.DIRT_PATH, Pair.of(HoeItem::canTillFarmland, createTillAction(Blocks.FARMLAND.getDefaultState())),
                        Blocks.DIRT, Pair.of(HoeItem::canTillFarmland, createTillAction(Blocks.FARMLAND.getDefaultState())),
                        Blocks.COARSE_DIRT, Pair.of(HoeItem::canTillFarmland, createTillAction(Blocks.DIRT.getDefaultState())),
                        Blocks.ROOTED_DIRT, Pair.of((Predicate)(itemUsageContext) -> true,
                                createTillAndDropAction(Blocks.DIRT.getDefaultState(), Items.HANGING_ROOTS))));
        STRIPPED_BLOCKS = (new ImmutableMap.Builder())
                .put(Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD)
                .put(Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG)
                .put(Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD)
                .put(Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG)
                .put(Blocks.PALE_OAK_WOOD, Blocks.STRIPPED_PALE_OAK_WOOD)
                .put(Blocks.PALE_OAK_LOG, Blocks.STRIPPED_PALE_OAK_LOG)
                .put(Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD)
                .put(Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG)
                .put(Blocks.CHERRY_WOOD, Blocks.STRIPPED_CHERRY_WOOD)
                .put(Blocks.CHERRY_LOG, Blocks.STRIPPED_CHERRY_LOG)
                .put(Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD)
                .put(Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG)
                .put(Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD)
                .put(Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG)
                .put(Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD)
                .put(Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG)
                .put(Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM)
                .put(Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE)
                .put(Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM)
                .put(Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE)
                .put(Blocks.MANGROVE_WOOD, Blocks.STRIPPED_MANGROVE_WOOD)
                .put(Blocks.MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_LOG)
                .put(Blocks.BAMBOO_BLOCK, Blocks.STRIPPED_BAMBOO_BLOCK)
                .put(ModBlocks.CRYSTAL_CHERRY_LOG, ModBlocks.STRIPPED_CRYSTAL_CHERRY_LOG)
                .put(ModBlocks.CRYSTAL_CHERRY_WOOD, ModBlocks.STRIPPED_CRYSTAL_CHERRY_WOOD)
                .put(ModBlocks.CHORUS_LOG, ModBlocks.STRIPPED_CHORUS_LOG)
                .put(ModBlocks.CHORUS_WOOD, ModBlocks.STRIPPED_CHORUS_WOOD)
                .put(ModBlocks.ASHEN_LOG, ModBlocks.STRIPPED_ASHEN_LOG)
                .put(ModBlocks.ASHEN_WOOD, ModBlocks.STRIPPED_ASHEN_WOOD)
                .put(ModBlocks.KEAPHE_LOG, ModBlocks.STRIPPED_KEAPHE_LOG)
                .put(ModBlocks.KEAPHE_WOOD, ModBlocks.STRIPPED_KEAPHE_WOOD)
                .put(ModBlocks.WASTEWOOD_LOG, ModBlocks.STRIPPED_WASTEWOOD_LOG)
                .put(ModBlocks.WASTEWOOD_WOOD, ModBlocks.STRIPPED_WASTEWOOD_WOOD)
                .put(ModBlocks.CORRERIE_LOG, ModBlocks.STRIPPED_CORRERIE_LOG)
                .put(ModBlocks.CORRERIE_WOOD, ModBlocks.STRIPPED_CORRERIE_WOOD).build();
    }
}