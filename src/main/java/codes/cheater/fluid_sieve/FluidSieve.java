package codes.cheater.fluid_sieve;

import codes.cheater.fluid_sieve.block.FluidSieveBlocks;
import codes.cheater.fluid_sieve.block.entity.FluidSieveBlockEntityTypes;
import codes.cheater.fluid_sieve.item.FluidSieveItems;
import com.google.common.collect.ImmutableSet;
import net.minecraft.fluid.Fluids;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import virtuoel.statement.api.StateRefresher;
import virtuoel.towelette.api.FluidProperties;

public class FluidSieve implements ModInitializer {
    public static String MOD_ID = "fluid_sieve";

    @Override
    public void onInitialize(ModContainer mod) {
        FluidSieveBlocks.register();
        FluidSieveBlockEntityTypes.register();
        FluidSieveItems.register();

        Identifier flowingWater = Registries.FLUID.getId(Fluids.FLOWING_WATER);
        if (!FluidProperties.FLUID.getValues().contains(flowingWater)) {
            StateRefresher.INSTANCE.refreshBlockStates(FluidProperties.FLUID, ImmutableSet.of(flowingWater),
                    ImmutableSet.of());
        }
        Identifier flowingLava = Registries.FLUID.getId(Fluids.FLOWING_LAVA);
        if (!FluidProperties.FLUID.getValues().contains(flowingLava)) {
            StateRefresher.INSTANCE.refreshBlockStates(FluidProperties.FLUID, ImmutableSet.of(flowingLava),
                    ImmutableSet.of());
        }
    }
}
