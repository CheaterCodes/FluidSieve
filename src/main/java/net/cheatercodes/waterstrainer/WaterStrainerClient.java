package net.cheatercodes.waterstrainer;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class WaterStrainerClient implements ClientModInitializer {
    static {
        BlockRenderLayerMap.INSTANCE.putBlock(WaterStrainer.BLOCKS.WATER_STRAINER_NET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WaterStrainer.BLOCKS.DENSE_WATER_STRAINER_NET, RenderLayer.getCutout());
    }

    @Override
    public void onInitializeClient() {
    }
}
