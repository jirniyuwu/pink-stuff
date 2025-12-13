package net.jirniy.pinkstuff.block.custom;

import net.jirniy.pinkstuff.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootWorldContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.rule.GameRules;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public interface EndVines {
    VoxelShape SHAPE = Block.createColumnShape((double)14.0F, (double)0.0F, (double)16.0F);
    BooleanProperty BERRIES = Properties.BERRIES;

    static ActionResult pickBerries(Entity picker, BlockState state, World world, BlockPos pos) {
        if ((Boolean)state.get(BERRIES)) {
            if (world instanceof ServerWorld) {
                ServerWorld serverWorld = (ServerWorld)world;
                dropStack(world, pos, new ItemStack(ModItems.PEARLISCINE, world.getRandom().nextBetween(1, 3)));
                float f = MathHelper.nextBetween(serverWorld.random, 0.8F, 1.2F);
                serverWorld.playSound((Entity)null, pos, SoundEvents.BLOCK_CAVE_VINES_PICK_BERRIES, SoundCategory.BLOCKS, 1.0F, f);
                BlockState blockState = (BlockState)state.with(BERRIES, false);
                serverWorld.setBlockState(pos, blockState, 2);
                serverWorld.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(picker, blockState));
            }

            return ActionResult.SUCCESS;
        } else {
            return ActionResult.PASS;
        }
    }

    static boolean hasBerries(BlockState state) {
        return state.contains(BERRIES) && (Boolean)state.get(BERRIES);
    }

    static ToIntFunction<BlockState> getLuminanceSupplier(int luminance) {
        return (state) -> (Boolean)state.get(Properties.BERRIES) ? luminance : 0;
    }

    public static List<ItemStack> getDroppedStacks(BlockState state, ServerWorld world, BlockPos pos, @Nullable BlockEntity blockEntity) {
        LootWorldContext.Builder builder = (new LootWorldContext.Builder(world)).add(LootContextParameters.ORIGIN, Vec3d.ofCenter(pos)).add(LootContextParameters.TOOL, ItemStack.EMPTY).addOptional(LootContextParameters.BLOCK_ENTITY, blockEntity);
        return state.getDroppedStacks(builder);
    }

    public static List<ItemStack> getDroppedStacks(BlockState state, ServerWorld world, BlockPos pos, @Nullable BlockEntity blockEntity, @Nullable Entity entity, ItemStack stack) {
        LootWorldContext.Builder builder = (new LootWorldContext.Builder(world)).add(LootContextParameters.ORIGIN, Vec3d.ofCenter(pos)).add(LootContextParameters.TOOL, stack).addOptional(LootContextParameters.THIS_ENTITY, entity).addOptional(LootContextParameters.BLOCK_ENTITY, blockEntity);
        return state.getDroppedStacks(builder);
    }

    public static void dropStacks(BlockState state, World world, BlockPos pos) {
        if (world instanceof ServerWorld) {
            getDroppedStacks(state, (ServerWorld)world, pos, (BlockEntity)null).forEach((stack) -> dropStack(world, pos, stack));
            state.onStacksDropped((ServerWorld)world, pos, ItemStack.EMPTY, true);
        }

    }

    public static void dropStacks(BlockState state, WorldAccess world, BlockPos pos, @Nullable BlockEntity blockEntity) {
        if (world instanceof ServerWorld) {
            getDroppedStacks(state, (ServerWorld)world, pos, blockEntity).forEach((stack) -> dropStack((ServerWorld)world, pos, stack));
            state.onStacksDropped((ServerWorld)world, pos, ItemStack.EMPTY, true);
        }

    }

    public static void dropStacks(BlockState state, World world, BlockPos pos, @Nullable BlockEntity blockEntity, @Nullable Entity entity, ItemStack tool) {
        if (world instanceof ServerWorld) {
            getDroppedStacks(state, (ServerWorld)world, pos, blockEntity, entity, tool).forEach((stack) -> dropStack(world, pos, stack));
            state.onStacksDropped((ServerWorld)world, pos, tool, true);
        }

    }

    public static void dropStack(World world, BlockPos pos, ItemStack stack) {
        double d = (double) EntityType.ITEM.getHeight() / (double)2.0F;
        double e = (double)pos.getX() + (double)0.5F + MathHelper.nextDouble(world.random, (double)-0.25F, (double)0.25F);
        double f = (double)pos.getY() + (double)0.5F + MathHelper.nextDouble(world.random, (double)-0.25F, (double)0.25F) - d;
        double g = (double)pos.getZ() + (double)0.5F + MathHelper.nextDouble(world.random, (double)-0.25F, (double)0.25F);
        dropStack(world, (Supplier)(() -> new ItemEntity(world, e, f, g, stack)), stack);
    }

    public static void dropStack(World world, BlockPos pos, Direction direction, ItemStack stack) {
        int i = direction.getOffsetX();
        int j = direction.getOffsetY();
        int k = direction.getOffsetZ();
        double d = (double)EntityType.ITEM.getWidth() / (double)2.0F;
        double e = (double)EntityType.ITEM.getHeight() / (double)2.0F;
        double f = (double)pos.getX() + (double)0.5F + (i == 0 ? MathHelper.nextDouble(world.random, (double)-0.25F, (double)0.25F) : (double)i * ((double)0.5F + d));
        double g = (double)pos.getY() + (double)0.5F + (j == 0 ? MathHelper.nextDouble(world.random, (double)-0.25F, (double)0.25F) : (double)j * ((double)0.5F + e)) - e;
        double h = (double)pos.getZ() + (double)0.5F + (k == 0 ? MathHelper.nextDouble(world.random, (double)-0.25F, (double)0.25F) : (double)k * ((double)0.5F + d));
        double l = i == 0 ? MathHelper.nextDouble(world.random, -0.1, 0.1) : (double)i * 0.1;
        double m = j == 0 ? MathHelper.nextDouble(world.random, (double)0.0F, 0.1) : (double)j * 0.1 + 0.1;
        double n = k == 0 ? MathHelper.nextDouble(world.random, -0.1, 0.1) : (double)k * 0.1;
        dropStack(world, (Supplier)(() -> new ItemEntity(world, f, g, h, stack, l, m, n)), stack);
    }

    private static void dropStack(World world, Supplier<ItemEntity> itemEntitySupplier, ItemStack stack) {
        if (world instanceof ServerWorld serverWorld) {
            if (!stack.isEmpty() && serverWorld.getGameRules().getValue(GameRules.DO_TILE_DROPS)) {
                ItemEntity itemEntity = (ItemEntity)itemEntitySupplier.get();
                itemEntity.setToDefaultPickupDelay();
                world.spawnEntity(itemEntity);
                return;
            }
        }

    }
}
