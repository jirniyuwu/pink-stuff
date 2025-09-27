package net.jirniy.pinkstuff.block.entity.custom;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.block.custom.CorruptCauldronBlock;
import net.jirniy.pinkstuff.block.entity.ImplementedInventory;
import net.jirniy.pinkstuff.block.entity.ModBlockEntities;
import net.jirniy.pinkstuff.item.ModItems;
import net.jirniy.pinkstuff.screen.ModScreenHandlers;
import net.jirniy.pinkstuff.screen.custom.CorruptCauldronScreenHandler;
import net.jirniy.pinkstuff.util.ModTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CorruptCauldronBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory<BlockPos>, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);
    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 20;

    public CorruptCauldronBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CORRUPT_CAULDRON_BE, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> CorruptCauldronBlockEntity.this.progress;
                    case 1 -> CorruptCauldronBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: CorruptCauldronBlockEntity.this.progress = value;
                    case 1: CorruptCauldronBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public BlockPos getScreenOpeningData(ServerPlayerEntity serverPlayerEntity) {
        return this.pos;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("item.pinkstuff.corrupt_cauldron");
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new CorruptCauldronScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if(hasRecipe()) {
            setState(true);
            increaseCraftingProgress();
            markDirty(world, pos, state);

            if(hasCraftingFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
            setState(false);
        }
    }

    private void setState(boolean value) {
        if (world != null && !world.isClient()) {
            world.setBlockState(pos, getCachedState().with(CorruptCauldronBlock.LIT, value));
        }
    }

    private void craftItem() {
        ItemStack input = inventory.get(INPUT_SLOT);

        ItemStack output = getOutputFromItem(input);
        this.removeStack(INPUT_SLOT, 1);
        this.setStack(OUTPUT_SLOT, new ItemStack(output.getItem(),
                this.getStack(OUTPUT_SLOT).getCount() + output.getCount()));
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private boolean hasCraftingFinished() {
        return this.progress == this.maxProgress;
    }

    private void increaseCraftingProgress() {
        this.progress += 1;
    }

    private boolean hasRecipe() {
        ItemStack input = inventory.get(INPUT_SLOT);
        if(input.isEmpty()) {
            return false;
        }

        ItemStack output = getOutputFromItem(input);
        return canInsertAmountIntoOutputSlot(output.getCount()) && canInsertItemIntoOutputSlot(output);
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getItem() == output.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        int maxCount = this.getStack(OUTPUT_SLOT).isEmpty() ? 64 : this.getStack(OUTPUT_SLOT).getMaxCount();
        int currentCount = this.getStack(OUTPUT_SLOT).getCount();

        return maxCount >= currentCount + count;
    }

    private ItemStack getOutputFromItem(ItemStack input) {
        if (input.isIn(ModTags.Items.CORRUPT_MASS_CONVERTIBLE)) {
            return new ItemStack(ModItems.CORRUPT_MASS, 1);
        } else if (input.isIn(ItemTags.LOGS) || input.isIn(ItemTags.LOGS_THAT_BURN)) {
            return new ItemStack(ModBlocks.CORRERIE_LOG, 1);
        } else if (input.isIn(ModTags.Items.BRICKS_CRAFTABLE)) {
            return new ItemStack(ModBlocks.CORESTONE, 1);
        } else if (input.isIn(ItemTags.VILLAGER_PLANTABLE_SEEDS) || input.isIn(ModTags.Items.BERRIES)) {
            return new ItemStack(ModItems.CORRUPT_SPROUTS, 1);
        } else if (input.isIn(ItemTags.PLANKS)) {
            return new ItemStack(ModBlocks.CORRERIE_PLANKS, 1);
        } else if (input.getItem() instanceof BlockItem) {
            return new ItemStack(ModBlocks.BLACK_GOOP, 1);
        } else {
            return new ItemStack(ModItems.CORRUPT_DROPLET);
        }
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction side) {
        return slot == OUTPUT_SLOT;
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        return slot == INPUT_SLOT;
    }

    @Override
    protected void writeData(WriteView view) {
        super.writeData(view);
        Inventories.writeData(view, inventory);
        view.putInt("corrupt_cauldron.progress", progress);
        view.putInt("corrupt_cauldron.max_progress", maxProgress);
    }

    @Override
    protected void readData(ReadView view) {
        Inventories.readData(view, inventory);
        progress = view.getInt("corrupt_cauldron.progress", 0);
        maxProgress = view.getInt("corrupt_cauldron.max_progress", 20);
        super.readData(view);
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