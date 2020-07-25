package net.cheatercodes.fluid_sieve;

import com.google.common.collect.ImmutableSet;
import net.cheatercodes.fluid_sieve.block.FluidSieveBlocks;
import net.cheatercodes.fluid_sieve.block.entity.FluidSieveBlockEntityTypes;
import net.cheatercodes.fluid_sieve.item.FluidSieveItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import virtuoel.statement.api.StateRefresher;
import virtuoel.towelette.api.FluidProperties;

public class FluidSieve implements ModInitializer {
	public static String MOD_ID = "fluid_sieve";

	@Override
	public void onInitialize() {
		FluidSieveBlocks.register();
		FluidSieveBlockEntityTypes.register();
		FluidSieveItems.register();

		Identifier flowingWater = Registry.FLUID.getId(Fluids.FLOWING_WATER);
		if (!FluidProperties.FLUID.contains(flowingWater)) {
			StateRefresher.INSTANCE.refreshBlockStates(FluidProperties.FLUID, ImmutableSet.of(flowingWater), ImmutableSet.of());
		}
		Identifier flowingLava = Registry.FLUID.getId(Fluids.FLOWING_LAVA);
		if (!FluidProperties.FLUID.contains(flowingLava)) {
			StateRefresher.INSTANCE.refreshBlockStates(FluidProperties.FLUID, ImmutableSet.of(flowingLava), ImmutableSet.of());
		}
	}
}
