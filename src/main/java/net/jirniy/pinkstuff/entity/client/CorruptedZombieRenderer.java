package net.jirniy.pinkstuff.entity.client;

import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ZombieEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.state.ZombieEntityRenderState;
import net.minecraft.util.Identifier;

public class CorruptedZombieRenderer extends ZombieEntityRenderer {
    private static final Identifier TEXTURE = Identifier.of(JirniysPinkStuff.MOD_ID, "textures/entity/zombie/corrupted_zombie.png");

    public CorruptedZombieRenderer(EntityRendererFactory.Context context) {
        super(context, EntityModelLayers.HUSK, EntityModelLayers.HUSK_BABY, EntityModelLayers.HUSK_INNER_ARMOR, EntityModelLayers.HUSK_OUTER_ARMOR, EntityModelLayers.HUSK_BABY_INNER_ARMOR, EntityModelLayers.HUSK_BABY_OUTER_ARMOR);
    }

    public Identifier getTexture(ZombieEntityRenderState zombieEntityRenderState) {
        return TEXTURE;
    }
}
