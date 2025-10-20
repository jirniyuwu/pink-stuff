package net.jirniy.pinkstuff.block.entity.custom;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.jirniy.pinkstuff.block.ModBlocks;
import net.jirniy.pinkstuff.block.custom.CorruptCauldronBlock;
import net.jirniy.pinkstuff.block.entity.ImplementedInventory;
import net.jirniy.pinkstuff.block.entity.ModBlockEntities;
import net.jirniy.pinkstuff.item.ModItems;
import net.jirniy.pinkstuff.screen.custom.CorruptCauldronScreenHandler;
import net.jirniy.pinkstuff.util.ModTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
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

import com.mojang.logging.LogUtils;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShelfBlock;
import net.minecraft.component.ComponentMap;
import net.minecraft.component.ComponentsAccess;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ContainerComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.ListInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.storage.NbtWriteView;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.ErrorReporter;
import net.minecraft.util.HeldItemContext;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.event.GameEvent.Emitter;
import org.slf4j.Logger;

// copied code from source ShelfBlockEntity

public class ShelfBlockEntity2 extends BlockEntity implements HeldItemContext, ListInventory {
    public static final int SLOT_COUNT = 3;
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final String ALIGN_ITEMS_TO_BOTTOM_KEY = "align_items_to_bottom";
    private final DefaultedList<ItemStack> heldStacks;
    private boolean alignItemsToBottom;

    public ShelfBlockEntity2(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SHELF_BE, pos, state);
        this.heldStacks = DefaultedList.ofSize(3, ItemStack.EMPTY);
    }

    protected void readData(ReadView view) {
        super.readData(view);
        this.heldStacks.clear();
        Inventories.readData(view, this.heldStacks);
        this.alignItemsToBottom = view.getBoolean("align_items_to_bottom", false);
    }

    protected void writeData(WriteView view) {
        super.writeData(view);
        Inventories.writeData(view, this.heldStacks, true);
        view.putBoolean("align_items_to_bottom", this.alignItemsToBottom);
    }

    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registries) {
        try (ErrorReporter.Logging logging = new ErrorReporter.Logging(this.getReporterContext(), LOGGER)) {
            NbtWriteView nbtWriteView = NbtWriteView.create(logging, registries);
            Inventories.writeData(nbtWriteView, this.heldStacks, true);
            nbtWriteView.putBoolean("align_items_to_bottom", this.alignItemsToBottom);
            return nbtWriteView.getNbt();
        }
    }

    public DefaultedList<ItemStack> getHeldStacks() {
        return this.heldStacks;
    }

    public boolean canPlayerUse(PlayerEntity player) {
        return Inventory.canPlayerUse(this, player);
    }

    public ItemStack swapStackNoMarkDirty(int slot, ItemStack stack) {
        ItemStack itemStack = this.removeStack(slot);
        this.setStackNoMarkDirty(slot, stack);
        return itemStack;
    }

    public void markDirty(RegistryEntry.Reference<GameEvent> gameEvent) {
        super.markDirty();
        if (this.world != null) {
            this.world.emitGameEvent(gameEvent, this.pos, Emitter.of(this.getCachedState()));
            this.getWorld().updateListeners(this.getPos(), this.getCachedState(), this.getCachedState(), 3);
        }

    }

    public void markDirty() {
        this.markDirty(GameEvent.BLOCK_ACTIVATE);
    }

    protected void readComponents(ComponentsAccess components) {
        super.readComponents(components);
        ((ContainerComponent)components.getOrDefault(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT)).copyTo(this.heldStacks);
    }

    protected void addComponents(ComponentMap.Builder builder) {
        super.addComponents(builder);
        builder.add(DataComponentTypes.CONTAINER, ContainerComponent.fromStacks(this.heldStacks));
    }

    public void removeFromCopiedStackData(WriteView view) {
        view.remove("Items");
    }

    public World getEntityWorld() {
        return this.world;
    }

    public Vec3d getEntityPos() {
        return this.getPos().toCenterPos();
    }

    public float getBodyYaw() {
        return ((Direction)this.getCachedState().get(ShelfBlock.FACING)).getOpposite().getPositiveHorizontalDegrees();
    }

    public boolean shouldAlignItemsToBottom() {
        return this.alignItemsToBottom;
    }
}