package net.jirniy.pinkstuff.entity.custom;

import net.jirniy.pinkstuff.entity.ModEntities;
import net.jirniy.pinkstuff.item.ModItems;
import net.jirniy.pinkstuff.util.ModTags;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.biome.BiomeKeys;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CrawlerEntity extends AnimalEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    private int loveTicks = 0;

    private static final TrackedData<Integer> DATA_ID_TYPE_VARIANT =
            DataTracker.registerData(CrawlerEntity.class, TrackedDataHandlerRegistry.INTEGER);

    public CrawlerEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new AnimalMateGoal(this, 1.15D));
        this.goalSelector.add(1, new EscapeSunlightGoal(this, 1.2D));
        this.goalSelector.add(2, new TemptGoal(this, 1.1D, Ingredient.ofItems(ModItems.COAL_MEAL), false));
        this.goalSelector.add(3, new AvoidSunlightGoal(this));
        this.goalSelector.add(4, new FollowParentGoal(this, 1.1D));
        this.goalSelector.add(5, new LookAroundGoal(this));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 4.0F));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(8, new SwimGoal(this));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 80)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.1)
                .add(EntityAttributes.ATTACK_DAMAGE, 0)
                .add(EntityAttributes.FOLLOW_RANGE, 20)
                .add(EntityAttributes.TEMPT_RANGE, 12)
                .add(EntityAttributes.JUMP_STRENGTH, 0.4)
                .add(EntityAttributes.KNOCKBACK_RESISTANCE, 0.4)
                .add(EntityAttributes.STEP_HEIGHT, 0.5);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 40;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getEntityWorld().isClient()) {
            this.setupAnimationStates();
        }
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(ModItems.COAL_MEAL);
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        CrawlerEntity crawler = (CrawlerEntity) entity;
        CrawlerEntity baby = ModEntities.CRAWLER.create(world, SpawnReason.BREEDING);
        CrawlerVariant variant = Util.getRandom(List.of(
                this.getVariant(), crawler.getVariant()), this.random);
        baby.setVariant(variant);
        if (random.nextBetween(0, 50) == 50) {
            baby.setVariant(CrawlerVariant.THERMIUM);
        } else if (random.nextBetween(0, 100) == 100) {
            baby.setVariant(getVariantFromBiome(world));
        }
        return baby;
    }

    protected void mobTick(ServerWorld world) {
        if (this.getBreedingAge() != 0) {
            this.loveTicks = 0;
        }
        if (this.getVariant() == CrawlerVariant.THERMIUM && !this.isBaby()) {
            if (random.nextBetween(0, 4000) == 4000) {
                AreaEffectCloudEntity area = EntityType.AREA_EFFECT_CLOUD.spawn(world, this.getBlockPos(), SpawnReason.TRIGGERED);
                area.addEffect(new StatusEffectInstance(StatusEffects.POISON, 60, 0));
                area.setRadius(1.0F);
                area.setOwner(this);
                area.setDuration(20);
            }
        }
        super.mobTick(world);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(DATA_ID_TYPE_VARIANT, 0);
    }

    public CrawlerVariant getVariant() {
        return CrawlerVariant.byId(this.getTypeVariant() & 255);
    }

    private int getTypeVariant() {
        return this.dataTracker.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(CrawlerVariant variant) {
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    @Override
    public void writeData(WriteView view) {
        super.writeData(view);
        view.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public void readData(ReadView view) {
        super.readData(view);
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, view.getInt("Variant", 0));
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason,
                                 @Nullable EntityData entityData) {
        CrawlerVariant variant;
        if (spawnReason == SpawnReason.SPAWN_ITEM_USE) {
            variant = Util.getRandom(CrawlerVariant.values(), this.random);
            setVariant(variant);
            return super.initialize(world, difficulty, spawnReason, entityData);
        } else if (this.getVariant() == null) {
            return super.initialize(world, difficulty, spawnReason, entityData);
        }
        setVariant(getVariantFromBiome(world));
        return super.initialize(world, difficulty, spawnReason, entityData);
    }

    private CrawlerVariant getVariantFromBiome(ServerWorldAccess world) {
        if (world.getBiome(this.getBlockPos()).getKey().get() == BiomeKeys.DEEP_DARK) {
            return CrawlerVariant.DIAMOND;
        } else if (world.getBiome(this.getBlockPos()).getKey().get() == BiomeKeys.PALE_GARDEN) {
            return CrawlerVariant.RESIN;
        } else if (world.getBiome(this.getBlockPos()).getKey().get() == BiomeKeys.CHERRY_GROVE ||
                world.getBiome(this.getBlockPos()).getKey().get() == BiomeKeys.LUSH_CAVES) {
            return CrawlerVariant.KUNZITE;
        } else if (world.getBiome(this.getBlockPos()).isIn(ModTags.Biomes.IS_STYXIA)) {
            return CrawlerVariant.SUNGAZE;
        } else if (world.getBiome(this.getBlockPos()).isIn(BiomeTags.IS_MOUNTAIN)) {
            return CrawlerVariant.EMERALD;
        } else if (world.getBiome(this.getBlockPos()).isIn(BiomeTags.IS_NETHER)) {
            return CrawlerVariant.QUARTZ;
        } else if (world.getBiome(this.getBlockPos()).isIn(BiomeTags.VILLAGE_SNOWY_HAS_STRUCTURE) ||
                world.getBiome(this.getBlockPos()).getKey().get() == BiomeKeys.FROZEN_OCEAN ||
                world.getBiome(this.getBlockPos()).getKey().get() == BiomeKeys.DEEP_FROZEN_OCEAN ||
                world.getBiome(this.getBlockPos()).getKey().get() == BiomeKeys.FROZEN_RIVER) {
            return CrawlerVariant.ICE;
        } else {
            return CrawlerVariant.DEFAULT;
        }
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_FOX_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_BAT_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_BAT_DEATH;
    }

    public static boolean canSpawn(EntityType<CrawlerEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return world.getBlockState(pos.down()).isIn(ModTags.Blocks.CRAWLER_SPAWNABLE_ON);
    }
}
