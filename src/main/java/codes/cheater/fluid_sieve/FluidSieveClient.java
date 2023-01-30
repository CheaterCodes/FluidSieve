package codes.cheater.fluid_sieve;

import codes.cheater.fluid_sieve.block.FluidSieveBlocks;
import net.minecraft.client.render.RenderLayer;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.block.extensions.api.client.BlockRenderLayerMap;

public class FluidSieveClient implements ClientModInitializer {
    @Override
    public void onInitializeClient(ModContainer mod) {
        BlockRenderLayerMap.put(RenderLayer.getCutout(),
                FluidSieveBlocks.NET,
                FluidSieveBlocks.DENSE_NET
        );
    }
}
