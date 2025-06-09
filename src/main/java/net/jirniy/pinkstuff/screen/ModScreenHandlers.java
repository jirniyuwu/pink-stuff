package net.jirniy.pinkstuff.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.screen.custom.DisplayScreenHandler;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {
    public static final ScreenHandlerType<DisplayScreenHandler> DISPLAY_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(JirniysPinkStuff.MOD_ID, "display_screen_handler"),
                    new ExtendedScreenHandlerType<>(DisplayScreenHandler::new, BlockPos.PACKET_CODEC));

    public static void registerScreenHandlers() {
        JirniysPinkStuff.LOGGER.info("Registering Screen Handlers for " + JirniysPinkStuff.MOD_ID);
    }
}
