package net.jirniy.pinkstuff.entity.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jirniy.pinkstuff.entity.custom.CrawlerVariant;
import net.minecraft.client.render.entity.state.AllayEntityRenderState;
import net.minecraft.client.render.entity.state.ArmedEntityRenderState;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.AnimationState;

@Environment(EnvType.CLIENT)
public class ExofairyRenderState extends ArmedEntityRenderState {
    public boolean dancing;
    public boolean spinning;
    public float spinningAnimationTicks;
    public float itemHoldAnimationTicks;
}