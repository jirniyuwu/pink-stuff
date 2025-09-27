package net.jirniy.pinkstuff.screen.custom;

import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.tooltip.TooltipSubmenuHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class CorruptCauldronScreen extends HandledScreen<CorruptCauldronScreenHandler> {
    private static final Identifier GUI_TEXTURE =
            Identifier.of(JirniysPinkStuff.MOD_ID, "textures/gui/corrupt_cauldron/corrupt_cauldron_gui.png");
    private static final Identifier ARROW_TEXTURE =
            Identifier.of(JirniysPinkStuff.MOD_ID, "textures/gui/arrow_progress.png");

    public CorruptCauldronScreen(CorruptCauldronScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    private void renderProgressArrow(DrawContext context, int x, int y) {
        if(handler.isCrafting()) {
            context.drawTexture(RenderPipelines.GUI_TEXTURED, ARROW_TEXTURE, x + 73, y + 35, 0, 0,
                    handler.getScaledArrowProgress(), 16, 24, 16);
        }
    }

    @Override
    protected void drawBackground(DrawContext context, float deltaTicks, int mouseX, int mouseY) {
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        context.drawTexture(RenderPipelines.GUI_TEXTURED, GUI_TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight, 256, 256);

        renderProgressArrow(context, x, y);
    }

    @Override
    protected void addTooltipSubmenuHandler(TooltipSubmenuHandler handler) {
        super.addTooltipSubmenuHandler(handler);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
