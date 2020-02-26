package net.cheatercodes.fluid_sieve;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class FluidSieveClient implements ClientModInitializer {
    static {
        BlockRenderLayerMap.INSTANCE.putBlock(FluidSieve.BLOCKS.NET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FluidSieve.BLOCKS.DENSE_NET, RenderLayer.getCutout());
    }

    @Override
    public void onInitializeClient() {
    }
}
