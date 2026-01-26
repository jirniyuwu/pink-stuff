package net.jirniy.pinkstuff.mixin;

import com.google.common.collect.Maps;
import net.jirniy.pinkstuff.JirniysPinkStuff;
import net.jirniy.pinkstuff.util.ModVillagers;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.village.VillagerType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static net.minecraft.village.VillagerType.*;

@Mixin(VillagerType.class)
public class VillagerTypeMixin {
	@Unique
	private static final Map<RegistryKey<Biome>, RegistryKey<VillagerType>> BIOME_TO_TYPE =
			Util.make(Maps.newHashMap(), (map) -> {
		map.put(BiomeKeys.BADLANDS, DESERT);
		map.put(BiomeKeys.DESERT, DESERT);
		map.put(BiomeKeys.ERODED_BADLANDS, DESERT);
		map.put(BiomeKeys.WOODED_BADLANDS, DESERT);
		map.put(BiomeKeys.BAMBOO_JUNGLE, JUNGLE);
		map.put(BiomeKeys.JUNGLE, JUNGLE);
		map.put(BiomeKeys.SPARSE_JUNGLE, JUNGLE);
		map.put(BiomeKeys.SAVANNA_PLATEAU, SAVANNA);
		map.put(BiomeKeys.SAVANNA, SAVANNA);
		map.put(BiomeKeys.WINDSWEPT_SAVANNA, SAVANNA);
		map.put(BiomeKeys.DEEP_FROZEN_OCEAN, SNOW);
		map.put(BiomeKeys.FROZEN_OCEAN, SNOW);
		map.put(BiomeKeys.FROZEN_RIVER, SNOW);
		map.put(BiomeKeys.ICE_SPIKES, SNOW);
		map.put(BiomeKeys.SNOWY_BEACH, SNOW);
		map.put(BiomeKeys.SNOWY_TAIGA, SNOW);
		map.put(BiomeKeys.SNOWY_PLAINS, SNOW);
		map.put(BiomeKeys.GROVE, SNOW);
		map.put(BiomeKeys.SNOWY_SLOPES, SNOW);
		map.put(BiomeKeys.FROZEN_PEAKS, SNOW);
		map.put(BiomeKeys.JAGGED_PEAKS, SNOW);
		map.put(BiomeKeys.SWAMP, SWAMP);
		map.put(BiomeKeys.MANGROVE_SWAMP, SWAMP);
		map.put(BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA, TAIGA);
		map.put(BiomeKeys.OLD_GROWTH_PINE_TAIGA, TAIGA);
		map.put(BiomeKeys.WINDSWEPT_GRAVELLY_HILLS, TAIGA);
		map.put(BiomeKeys.WINDSWEPT_HILLS, TAIGA);
		map.put(BiomeKeys.TAIGA, TAIGA);
		map.put(BiomeKeys.WINDSWEPT_FOREST, TAIGA);
		map.put(BiomeKeys.CHERRY_GROVE, RegistryKey.of(RegistryKeys.VILLAGER_TYPE, Identifier.of(JirniysPinkStuff.MOD_ID, "cherry")));});

	/**
	 * @author jirniyuwu
	 * @reason adding custom villager type to the biome_to_type map
	 */

	@Overwrite
	public static RegistryKey<VillagerType> forBiome(RegistryEntry<Biome> biomeEntry) {
		Optional var10000 = biomeEntry.getKey();
		Map var10001 = BIOME_TO_TYPE;
		Objects.requireNonNull(var10001);
		return (RegistryKey)var10000.map(var10001::get).orElse(PLAINS);
	}
}