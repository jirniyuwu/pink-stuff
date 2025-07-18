package net.jirniy.pinkstuff.block.entity.custom;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.jirniy.pinkstuff.block.entity.ImplementedInventory;
import net.jirniy.pinkstuff.block.entity.ModBlockEntities;
import net.jirniy.pinkstuff.recipe.ModRecipes;
import net.jirniy.pinkstuff.recipe.ThermiumBlasterRecipe;
import net.jirniy.pinkstuff.recipe.ThermiumBlasterRecipeInput;
import net.jirniy.pinkstuff.screen.custom.ThermiumBlasterScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.text.Text;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class ThermiumBlasterBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory<BlockPos>, ImplementedInventory {
        private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);

        private static final int INPUT_SLOT = 0;
        private static final int OUTPUT_SLOT = 1;

        protected final PropertyDelegate propertyDelegate;
        private int progress = 0;
        private int maxProgress = 20;

        public ThermiumBlasterBlockEntity(BlockPos pos, BlockState state) {
            super(ModBlockEntities.THERMIUM_BLASTER_BE, pos, state);
            this.propertyDelegate = new PropertyDelegate() {
                @Override
                public int get(int index) {
                    return switch (index) {
                        case 0 -> ThermiumBlasterBlockEntity.this.progress;
                        case 1 -> ThermiumBlasterBlockEntity.this.maxProgress;
                        default -> 0;
                    };
                }

                @Override
                public void set(int index, int value) {
                    switch (index) {
                        case 0: ThermiumBlasterBlockEntity.this.progress = value;
                        case 1: ThermiumBlasterBlockEntity.this.maxProgress = value;
                    }
                }

                @Override
                public int size() {
                    return 2;
                }
            };
        }

        @Override
        public BlockPos getScreenOpeningData(ServerPlayerEntity player) {
            return this.pos;
        }

        @Override
        public DefaultedList<ItemStack> getItems() {
            return inventory;
        }

        @Override
        public Text getDisplayName() {
            return Text.translatable("block.pinkstuff.thermium_blaster");
        }

        @Nullable
        @Override
        public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
            return new ThermiumBlasterScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
        }

        @Override
        public void onBlockReplaced(BlockPos pos, BlockState oldState) {
            ItemScatterer.spawn(world, pos, (this));
            super.onBlockReplaced(pos, oldState);
        }

        @Override
            protected void writeData(WriteView view) {
            super.writeData(view);
            Inventories.writeData(view, inventory);
            view.putInt("THERMIUM_BLASTER.progress", progress);
            view.putInt("THERMIUM_BLASTER.max_progress", maxProgress);
        }

        @Override
        protected void readData(ReadView view) {
            Inventories.readData(view, inventory);
            progress = view.getInt("THERMIUM_BLASTER.progress", 0);
            maxProgress = view.getInt("THERMIUM_BLASTER.max_progress", 20);
            super.readData(view);
        }

        public void tick(World world, BlockPos pos, BlockState state) {
            if(hasRecipe()) {
                increaseCraftingProgress();
                markDirty(world, pos, state);

                if(hasCraftingFinished()) {
                    craftItem();
                    resetProgress();
                }
            } else {
                resetProgress();
            }
        }

        private void resetProgress() {
            this.progress = 0;
            this.maxProgress = 20;
        }

        private void craftItem() {
            Optional<RecipeEntry<ThermiumBlasterRecipe>> recipe = getCurrentRecipe();

            ItemStack output = recipe.get().value().output();
            this.removeStack(INPUT_SLOT, 1);
            this.setStack(OUTPUT_SLOT, new ItemStack(output.getItem(),
                    this.getStack(OUTPUT_SLOT).getCount() + output.getCount()));
        }

        private boolean hasCraftingFinished() {
            return this.progress >= this.maxProgress;
        }

        private void increaseCraftingProgress() {
            this.progress++;
        }

        private boolean hasRecipe() {
            Optional<RecipeEntry<ThermiumBlasterRecipe>> recipe = getCurrentRecipe();
            if(recipe.isEmpty()) {
                return false;
            }

            ItemStack output = recipe.get().value().output();
            return canInsertAmountIntoOutputSlot(output.getCount()) && canInsertItemIntoOutputSlot(output);
        }

        private Optional<RecipeEntry<ThermiumBlasterRecipe>> getCurrentRecipe() {
            return ((ServerWorld) this.getWorld()).getRecipeManager()
                    .getFirstMatch(ModRecipes.THERMIUM_BLASTER_TYPE, new ThermiumBlasterRecipeInput(inventory.get(INPUT_SLOT)), this.getWorld());
        }

        private boolean canInsertItemIntoOutputSlot(ItemStack output) {
            return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getItem() == output.getItem();
        }

        private boolean canInsertAmountIntoOutputSlot(int count) {
            int maxCount = this.getStack(OUTPUT_SLOT).isEmpty() ? 64 : this.getStack(OUTPUT_SLOT).getMaxCount();
            int currentCount = this.getStack(OUTPUT_SLOT).getCount();

            return maxCount >= currentCount + count;
        }

        @Nullable
        @Override
        public Packet<ClientPlayPacketListener> toUpdatePacket() {
            return BlockEntityUpdateS2CPacket.create(this);
        }

        @Override
        public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
            return createNbt(registryLookup);
        }
    }