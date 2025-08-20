package net.jirniy.pinkstuff.entity.client;

import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.minecraft.client.render.entity.BlazeEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ZombieEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.render.entity.state.ZombieEntityRenderState;
import net.minecraft.util.Identifier;

public class AmethystBlazeRenderer extends BlazeEntityRenderer {
    private static final Identifier TEXTURE = Identifier.of(JirniysPinkStuff.MOD_ID, "textures/entity/blaze/amethyst_blaze.png");

    public AmethystBlazeRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(LivingEntityRenderState state) {
        return TEXTURE;
    }
}
