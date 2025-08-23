package net.jirniy.pinkstuff.block.custom;

import com.mojang.serialization.MapCodec;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.effect.ModEffects;
import net.jirniy.pinkstuff.util.ModGamerules;
import net.jirniy.pinkstuff.util.ModTags;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.TranslucentBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.GameMode;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BlackGoopBlock extends TranslucentBlock {
    public static final MapCodec<BlackGoopBlock> CODEC = createCodec(BlackGoopBlock::new);
    public static final BooleanProperty SPREADABLE = BooleanProperty.of("spreadable");

    public MapCodec<BlackGoopBlock> getCodec() {
        return CODEC;
    }

    public BlackGoopBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected void onBlockBreakStart(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        applyStatusEffect(player);
        super.onBlockBreakStart(state, world, pos, player);
    }

    @Override
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        if (!world.isClient() && state.getBlock() == ModBlocks.CORRUPT_ORE) {
            dropExperience((ServerWorld) world, pos, 10);
        }
        super.afterBreak(world, player, pos, state, blockEntity, tool);
    }

    @Override
    public void onEntityLand(BlockView world, Entity entity) {
        applyStatusEffect(entity);
        super.onEntityLand(world, entity);
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, EntityCollisionHandler handler) {
        applyStatusEffect(entity);
        super.onEntityCollision(state, world, pos, entity, handler);
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!world.getGameRules().getBoolean(ModGamerules.DISABLE_CORRUPTION_SPREAD) && state.get(SPREADABLE)) {
            spread(world, pos, random);
        }
        super.randomTick(state, world, pos, random);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (placer != null && placer.isPlayer()) {
            world.setBlockState(pos, state.with(SPREADABLE, false));
        }
        super.onPlaced(world, pos, state, placer, itemStack);
    }

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (stack.isOf(Items.SHEARS)) {
            if (state.get(SPREADABLE) == true) {
                world.setBlockState(pos, state.with(SPREADABLE, false));
                stack.damage(1, player);
                world.playSoundAtBlockCenterClient(pos, SoundEvents.ITEM_SHEARS_SNIP, SoundCategory.BLOCKS, 1, 1, true);
                world.addBlockBreakParticles(pos, state);
            } else if (state.get(SPREADABLE) == false) {
                world.setBlockState(pos, state.with(SPREADABLE, true));
                stack.damage(1, player);
                world.playSoundAtBlockCenterClient(pos, SoundEvents.ITEM_SHEARS_SNIP, SoundCategory.BLOCKS, 1, 1, true);
                world.addBlockBreakParticles(pos, state);
            }
        }
        return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(SPREADABLE);
    }

    protected void spread(ServerWorld world, BlockPos pos, Random random) {
        if (random.nextBetween(1, world.getGameRules().getInt(ModGamerules.CORRUPTION_SPREAD_CHANCE)) == 1) {
            if (!world.isAir(pos.down())) {
                if (world.getBlockState(pos.down()).isIn(ModTags.Blocks.CORRUPTABLE_BLOCKS)) {
                    world.setBlockState(pos.down(), ModBlocks.BLACK_GOOP.getDefaultState());
                    world.playSoundAtBlockCenterClient(pos.south(), SoundEvents.BLOCK_HONEY_BLOCK_SLIDE,
                            SoundCategory.BLOCKS, 1f, 1, true);
                }
            }
        }
        if (random.nextBetween(1, world.getGameRules().getInt(ModGamerules.CORRUPTION_SPREAD_CHANCE)) == 1) {
            if (!world.isAir(pos.up())) {
                if (world.getBlockState(pos.up()).isIn(ModTags.Blocks.CORRUPTABLE_BLOCKS)) {
                    world.setBlockState(pos.up(), ModBlocks.BLACK_GOOP.getDefaultState());
                    world.playSoundAtBlockCenterClient(pos.south(), SoundEvents.BLOCK_HONEY_BLOCK_SLIDE,
                            SoundCategory.BLOCKS, 1f, 1, true);
                }
            } else if (random.nextInt(20) == 1) {
                world.setBlockState(pos.up(), ModBlocks.CORRUPT_ROOTS.getDefaultState());
                world.playSoundAtBlockCenterClient(pos.south(), SoundEvents.BLOCK_HONEY_BLOCK_SLIDE,
                        SoundCategory.BLOCKS, 1f, 1, true);
            }
        }
        if (random.nextBetween(1, world.getGameRules().getInt(ModGamerules.CORRUPTION_SPREAD_CHANCE)) == 1) {
            if (!world.isAir(pos.east())) {
                if (world.getBlockState(pos.east()).isIn(ModTags.Blocks.CORRUPTABLE_BLOCKS)) {
                    world.setBlockState(pos.east(), ModBlocks.BLACK_GOOP.getDefaultState());
                    world.playSoundAtBlockCenterClient(pos.south(), SoundEvents.BLOCK_HONEY_BLOCK_SLIDE,
                            SoundCategory.BLOCKS, 1f, 1, true);
                }
            }
        }
        if (random.nextBetween(1, world.getGameRules().getInt(ModGamerules.CORRUPTION_SPREAD_CHANCE)) == 1) {
            if (!world.isAir(pos.west())) {
                if (world.getBlockState(pos.west()).isIn(ModTags.Blocks.CORRUPTABLE_BLOCKS)) {
                    world.setBlockState(pos.west(), ModBlocks.BLACK_GOOP.getDefaultState());
                    world.playSoundAtBlockCenterClient(pos.south(), SoundEvents.BLOCK_HONEY_BLOCK_SLIDE,
                            SoundCategory.BLOCKS, 1f, 1, true);
                }
            }
        }
        if (random.nextBetween(1, world.getGameRules().getInt(ModGamerules.CORRUPTION_SPREAD_CHANCE)) == 1) {
            if (!world.isAir(pos.north())) {
                if (world.getBlockState(pos.north()).isIn(ModTags.Blocks.CORRUPTABLE_BLOCKS)) {
                    world.setBlockState(pos.north(), ModBlocks.BLACK_GOOP.getDefaultState());
                    world.playSoundAtBlockCenterClient(pos.south(), SoundEvents.BLOCK_HONEY_BLOCK_SLIDE,
                            SoundCategory.BLOCKS, 1f, 1, true);
                }
            }
        }
        if (random.nextBetween(1, world.getGameRules().getInt(ModGamerules.CORRUPTION_SPREAD_CHANCE)) == 1) {
            if (!world.isAir(pos.south())) {
                if (world.getBlockState(pos.south()).isIn(ModTags.Blocks.CORRUPTABLE_BLOCKS)) {
                    world.setBlockState(pos.south(), ModBlocks.BLACK_GOOP.getDefaultState());
                    world.playSoundAtBlockCenterClient(pos.south(), SoundEvents.BLOCK_HONEY_BLOCK_SLIDE,
                            SoundCategory.BLOCKS, 1f, 1, true);
                }
            }
        }
    }

    protected void applyStatusEffect(Entity entity) {
        if (entity instanceof LivingEntity livingEntity) {
            applyStatusEffect(livingEntity);
        }
    }

    protected void applyStatusEffect(LivingEntity livingEntity) {
        if (livingEntity instanceof PlayerEntity playerEntity) {
            if (playerEntity.getGameMode() == GameMode.SPECTATOR) {
                return;
            }
        }
        if (livingEntity.hasStatusEffect(ModEffects.DEATH_GRIP)) {
            if ((livingEntity.getStatusEffect(ModEffects.DEATH_GRIP).getDuration() < 40) || livingEntity.getStatusEffect(ModEffects.DEATH_GRIP).getAmplifier() > 0) {
                livingEntity.addStatusEffect(new StatusEffectInstance(ModEffects.DEATH_GRIP, 40, 0, false, false, true));
            }
        } else {
            livingEntity.addStatusEffect(new StatusEffectInstance(ModEffects.DEATH_GRIP, 40, 0, false, false, true));
        }
    }
}
