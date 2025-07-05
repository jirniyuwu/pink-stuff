package net.jirniy.pinkstuff.entity.client;

import net.jirniy.pinkstuff.entity.custom.CrawlerVariant;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.AnimationState;

public class CrawlerRenderState extends LivingEntityRenderState {
    public final AnimationState idleAnimationState = new AnimationState();
    public CrawlerVariant variant;
}