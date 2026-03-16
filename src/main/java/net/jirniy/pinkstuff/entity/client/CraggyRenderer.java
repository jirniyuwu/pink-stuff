package net.jirniy.pinkstuff.entity.client;

import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ZombieEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.state.ZombieEntityRenderState;
import net.minecraft.util.Identifier;

public class CraggyRenderer extends ZombieEntityRenderer {
    private static final Identifier TEXTURE = Identifier.of(JirniysPinkStuff.MOD_ID, "textures/entity/zombie/craggy.png");

    public CraggyRenderer(EntityRendererFactory.Context context) {
        super(context, EntityModelLayers.HUSK, EntityModelLayers.HUSK_BABY, EntityModelLayers.HUSK_EQUIPMENT, EntityModelLayers.HUSK_BABY_EQUIPMENT);
    }

    public Identifier getTexture(ZombieEntityRenderState zombieEntityRenderState) {
        return TEXTURE;
    }
}
