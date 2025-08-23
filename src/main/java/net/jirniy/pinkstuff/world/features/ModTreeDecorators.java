package net.jirniy.pinkstuff.world.features;

import com.mojang.serialization.MapCodec;
import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class ModTreeDecorators<P extends TreeDecorator> {
    public static final TreeDecoratorType<HangingStyxgrassDecorator> HANGING_STYXGRASS = register("hanging_styxgrass", HangingStyxgrassDecorator.CODEC);
    public static final TreeDecoratorType<StyxmossVineDecorator> STYXMOSS_VINE = register("styxmoss_vine", StyxmossVineDecorator.CODEC);

    private static <P extends TreeDecorator> TreeDecoratorType<P> register(String id, MapCodec<P> codec) {
        return Registry.register(Registries.TREE_DECORATOR_TYPE, id, new TreeDecoratorType<P>(codec));
    }

    public ModTreeDecorators(MapCodec<P> codec) {
        this.codec = codec;
    }
    private final MapCodec<P> codec;
    public MapCodec<P> getCodec() {
        return this.codec;
    }
    public static void registerTreeDecorators() {
        JirniysPinkStuff.LOGGER.info("Registering Tree Decorators for " + JirniysPinkStuff.MOD_ID);
    }
}
