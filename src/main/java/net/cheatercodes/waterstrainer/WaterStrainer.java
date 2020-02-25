package net.cheatercodes.waterstrainer;

import com.google.common.collect.ImmutableSet;
import net.cheatercodes.waterstrainer.block.WaterStrainerBlocks;
import net.cheatercodes.waterstrainer.block.entity.WaterStrainerBlockEntityTypes;
import net.cheatercodes.waterstrainer.item.WaterStrainerItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import virtuoel.statement.api.StateRefresher;
import virtuoel.towelette.api.FluidProperties;

public class WaterStrainer implements ModInitializer {
	public static String ID = "waterstrainer";

	public static WaterStrainerBlocks BLOCKS = WaterStrainerBlocks.INSTANCE;
	public static WaterStrainerBlockEntityTypes BLOCK_ENTITY_TYPES = WaterStrainerBlockEntityTypes.INSTANCE;
	public static WaterStrainerItems ITEMS = WaterStrainerItems.INSTANCE;

	@Override
	public void onInitialize() {
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
