package net.cheatercodes.fluid_sieve;

import net.cheatercodes.fluid_sieve.block.FluidSieveBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class FluidSieveClient implements ClientModInitializer {
    static {
        BlockRenderLayerMap.INSTANCE.putBlock(FluidSieveBlocks.NET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FluidSieveBlocks.DENSE_NET, RenderLayer.getCutout());
    }

    @Override
    public void onInitializeClient() {
    }
}
