package net.jirniy.pinkstuff.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.jirniy.pinkstuff.entity.ModEntities;
import net.jirniy.pinkstuff.util.ModTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.EntityTypeTags;

import java.util.concurrent.CompletableFuture;

public class ModEntityTagProvider extends FabricTagProvider.EntityTypeTagProvider {
    public ModEntityTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ModTags.Entities.CLEANSE_APPLICABLE)
                .add(ModEntities.CORRUPTED_SKELETON)
                .add(ModEntities.CORRUPTED_ZOMBIE)
                .add(ModEntities.CORRUPTION_BLAZE);
        valueLookupBuilder(EntityTypeTags.SENSITIVE_TO_BANE_OF_ARTHROPODS)
                .add(ModEntities.CRAWLER);
        valueLookupBuilder(EntityTypeTags.SKELETONS)
                .add(ModEntities.CORRUPTED_SKELETON);
        valueLookupBuilder(EntityTypeTags.ZOMBIES)
                .add(ModEntities.CORRUPTED_ZOMBIE);
        valueLookupBuilder(EntityTypeTags.INVERTED_HEALING_AND_HARM)
                .add(ModEntities.CORRUPTED_SKELETON)
                .add(ModEntities.CORRUPTED_ZOMBIE);
    }
}