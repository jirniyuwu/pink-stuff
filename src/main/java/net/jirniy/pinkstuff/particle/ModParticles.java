package net.jirniy.pinkstuff.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
    public static final SimpleParticleType RIFT_PARTICLE =
            registerParticle("rift_particle", FabricParticleTypes.simple(true));
    public static final SimpleParticleType DAWNBREAK_PARTICLE =
            registerParticle("dawnbreak_particle", FabricParticleTypes.simple(true));
    public static final SimpleParticleType SPARKLE_PARTICLE =
            registerParticle("sparkle_particle", FabricParticleTypes.simple(false));
    public static final SimpleParticleType CHORUS_PETAL_PARTICLE =
            registerParticle("chorus_petal_particle", FabricParticleTypes.simple(false));
    public static final SimpleParticleType STYXIAN_FLAME_PARTICLE =
            registerParticle("styxian_flame_particle", FabricParticleTypes.simple(true));
    public static final SimpleParticleType CORRUPTION_POP_PARTICLE =
            registerParticle("corruption_pop_particle", FabricParticleTypes.simple(true));
    public static final SimpleParticleType CERILLE_SLASH_PARTICLE =
            registerParticle("cerille_slash_particle", FabricParticleTypes.simple(false));

    private static SimpleParticleType registerParticle(String name, SimpleParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(JirniysPinkStuff.MOD_ID, name), particleType);
    }

    public static void registerParticles() {
        JirniysPinkStuff.LOGGER.info("Registering Particles for " + JirniysPinkStuff.MOD_ID);
    }
}
