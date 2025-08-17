package net.jirniy.pinkstuff.block.entity.custom;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.block.entity.ImplementedInventory;
import net.jirniy.pinkstuff.block.entity.ModBlockEntities;
import net.jirniy.pinkstuff.item.ModItems;
import net.jirniy.pinkstuff.recipe.ModRecipes;
import net.jirniy.pinkstuff.recipe.ThermiumBlasterRecipe;
import net.jirniy.pinkstuff.recipe.ThermiumBlasterRecipeInput;
import net.jirniy.pinkstuff.screen.custom.ThermiumBlasterScreenHandler;
import net.jirniy.pinkstuff.util.ModTags;
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
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class ThermiumBlasterBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory<BlockPos>, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);

    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;

    private static final int FUEL_SLOT = 2;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 4;

    private int fuel = 0;
    private int maxFuel = 8192;

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction side) {
        return slot == OUTPUT_SLOT;
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        if (side != null) {
            if (stack.isIn(ModTags.Items.THERMIUM_FUEL_INSERTABLE)) {
                return slot == FUEL_SLOT;
            } else {
                return slot == INPUT_SLOT;
            }
        }
        return false;
    }

    public ThermiumBlasterBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.THERMIUM_BLASTER_BE, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> ThermiumBlasterBlockEntity.this.progress;
                    case 1 -> ThermiumBlasterBlockEntity.this.maxProgress;
                    case 2 -> ThermiumBlasterBlockEntity.this.fuel;
                    case 3 -> ThermiumBlasterBlockEntity.this.maxFuel;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: ThermiumBlasterBlockEntity.this.progress = value;
                    case 1: ThermiumBlasterBlockEntity.this.maxProgress = value;
                    case 2: ThermiumBlasterBlockEntity.this.fuel = value;
                    case 3: ThermiumBlasterBlockEntity.this.maxFuel = value;
                }
            }

            @Override
            public int size() {
                return 4;
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
        view.putInt("THERMIUM_BLASTER.fuel", fuel);
        view.putInt("THERMIUM_BLASTER.max_fuel", maxFuel);
    }

    @Override
    protected void readData(ReadView view) {
        Inventories.readData(view, inventory);
        progress = view.getInt("THERMIUM_BLASTER.progress", 0);
        maxProgress = view.getInt("THERMIUM_BLASTER.max_progress", 4);
        fuel = view.getInt("THERMIUM_BLASTER.fuel", 0);
        maxFuel = view.getInt("THERMIUM_BLASTER.max_fuel", 8192);
        super.readData(view);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        addFuel();
        if(hasRecipe() && isFuelEnoughToCraft()) {
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
        this.maxProgress = 4;
    }

    private void craftItem() {
        Optional<RecipeEntry<ThermiumBlasterRecipe>> recipe = getCurrentRecipe();

        ItemStack output = recipe.get().value().output();
        int fuelCost = recipe.get().value().fuelCost();
        this.removeStack(INPUT_SLOT, 1);
        this.setStack(OUTPUT_SLOT, new ItemStack(output.getItem(),
                this.getStack(OUTPUT_SLOT).getCount() + output.getCount()));
        decreaseFuel(fuelCost);
    }

    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProgress() {
        this.progress++;
    }

    private void addFuel() {
        ItemStack fuelStack = this.getStack(FUEL_SLOT);
        if (!fuelStack.isEmpty()) {
            if (fuelStack.getItem() == ModItems.THERMIUM && ableToAddFuel(128)) {
                this.removeStack(FUEL_SLOT, 1);
                this.fuel += 128;
            } else if (fuelStack.getItem() == ModItems.THERMIUM_NUGGET && ableToAddFuel(16)) {
                this.removeStack(FUEL_SLOT, 1);
                this.fuel += 16;
            } else if (fuelStack.getItem() == ModBlocks.THERMIUM_BLOCK.asItem() && ableToAddFuel(1024)) {
                this.removeStack(FUEL_SLOT, 1);
                this.fuel += 1024;
            } else if (fuelStack.getItem() == ModItems.ENERGIZED_THERMIUM && this.fuel <= this.maxFuel / 8) {
                this.removeStack(FUEL_SLOT, 1);
                this.fuel = this.maxFuel;
            }
        }
    }

    private boolean ableToAddFuel(int value) {
        return (this.fuel + value) <= this.maxFuel;
    }

    private void decreaseFuel(int fuelCost) {
        this.fuel = this.fuel - fuelCost;
    }

    private boolean hasRecipe() {
        Optional<RecipeEntry<ThermiumBlasterRecipe>> recipe = getCurrentRecipe();
        if(recipe.isEmpty()) {
            return false;
        }

        ItemStack output = recipe.get().value().output();
        return canInsertAmountIntoOutputSlot(output.getCount()) && canInsertItemIntoOutputSlot(output);
    }

    private boolean isFuelEnoughToCraft() {
        if (this.fuel <= 0) {
            return false;
        }
        Optional<RecipeEntry<ThermiumBlasterRecipe>> recipe = getCurrentRecipe();
        int fuelCost = recipe.get().value().fuelCost();
        return this.fuel >= fuelCost;
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