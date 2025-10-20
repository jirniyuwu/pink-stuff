package net.jirniy.pinkstuff.block.entity.renderer;

import it.unimi.dsi.fastutil.HashCommon;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jirniy.pinkstuff.block.entity.custom.ShelfBlockEntity2;
import net.minecraft.block.ShelfBlock;
import net.minecraft.client.item.ItemModelManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.block.entity.state.ShelfBlockEntityRenderState;
import net.minecraft.client.render.command.ModelCommandRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.item.ItemRenderState;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

// copied code from source ShelfBlockEntity

@Environment(EnvType.CLIENT)
public class ShelfBlockEntity2Renderer implements BlockEntityRenderer<ShelfBlockEntity2, ShelfBlockEntityRenderState> {
    private static final float ITEM_SCALE = 0.25F;
    private static final float BOTTOM_ALIGNED_OFFSET = -0.25F;
    private final ItemModelManager itemModelManager;

    public ShelfBlockEntity2Renderer(BlockEntityRendererFactory.Context context) {
        this.itemModelManager = context.itemModelManager();
    }

    public ShelfBlockEntityRenderState createRenderState() {
        return new ShelfBlockEntityRenderState();
    }

    public void updateRenderState(ShelfBlockEntity2 shelfBlockEntity, ShelfBlockEntityRenderState shelfBlockEntityRenderState, float f, Vec3d vec3d, @Nullable ModelCommandRenderer.CrumblingOverlayCommand crumblingOverlayCommand) {
        BlockEntityRenderer.super.updateRenderState(shelfBlockEntity, shelfBlockEntityRenderState, f, vec3d, crumblingOverlayCommand);
        shelfBlockEntityRenderState.alignItemsToBottom = shelfBlockEntity.shouldAlignItemsToBottom();
        DefaultedList<ItemStack> defaultedList = shelfBlockEntity.getHeldStacks();
        int i = HashCommon.long2int(shelfBlockEntity.getPos().asLong());

        for(int j = 0; j < defaultedList.size(); ++j) {
            ItemStack itemStack = (ItemStack)defaultedList.get(j);
            if (!itemStack.isEmpty()) {
                ItemRenderState itemRenderState = new ItemRenderState();
                this.itemModelManager.clearAndUpdate(itemRenderState, itemStack, ItemDisplayContext.ON_SHELF, shelfBlockEntity.getEntityWorld(), shelfBlockEntity, i + j);
                shelfBlockEntityRenderState.itemRenderStates[j] = itemRenderState;
            }
        }

    }

    public void render(ShelfBlockEntityRenderState shelfBlockEntityRenderState, MatrixStack matrixStack, OrderedRenderCommandQueue orderedRenderCommandQueue, CameraRenderState cameraRenderState) {
        Direction direction = (Direction)shelfBlockEntityRenderState.blockState.get(ShelfBlock.FACING);
        float f = direction.getAxis().isHorizontal() ? -direction.getPositiveHorizontalDegrees() : 180.0F;

        for(int i = 0; i < shelfBlockEntityRenderState.itemRenderStates.length; ++i) {
            ItemRenderState itemRenderState = shelfBlockEntityRenderState.itemRenderStates[i];
            if (itemRenderState != null) {
                this.renderItem(shelfBlockEntityRenderState, itemRenderState, matrixStack, orderedRenderCommandQueue, i, f);
            }
        }

    }

    private void renderItem(ShelfBlockEntityRenderState state, ItemRenderState itemRenderState, MatrixStack matrices, OrderedRenderCommandQueue queue, int overlay, float rotationDegrees) {
        float f = (float)(overlay - 1) * 0.3125F;
        Vec3d vec3d = new Vec3d((double)f, state.alignItemsToBottom ? (double)-0.25F : (double)0.0F, (double)-0.25F);
        matrices.push();
        matrices.translate(0.5F, 0.5F, 0.5F);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotationDegrees));
        matrices.translate(vec3d);
        matrices.scale(0.25F, 0.25F, 0.25F);
        Box box = itemRenderState.getModelBoundingBox();
        double d = -box.minY;
        if (!state.alignItemsToBottom) {
            d += -(box.maxY - box.minY) / (double)2.0F;
        }

        matrices.translate((double)0.0F, d, (double)0.0F);
        itemRenderState.render(matrices, queue, state.lightmapCoordinates, OverlayTexture.DEFAULT_UV, 0);
        matrices.pop();
    }
}
