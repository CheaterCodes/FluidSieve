package net.cheatercodes.waterstrainer.block;

import net.cheatercodes.waterstrainer.WaterStrainer;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class WaterStrainerBlocks {
    public static WaterStrainerBlocks INSTANCE = new WaterStrainerBlocks();

    public final WaterStrainerBaseBlock WATER_STRAINER_BASE;
    public final WaterStrainerNetBlock WATER_STRAINER_NET;
    public final WaterStrainerNetBlock DENSE_WATER_STRAINER_NET;

    private WaterStrainerBlocks() {
        WATER_STRAINER_BASE = register("water_strainer_base", new WaterStrainerBaseBlock(Block.Settings.copy(Blocks.OAK_PLANKS)));
        WATER_STRAINER_NET = register("water_strainer_net", new WaterStrainerNetBlock(Block.Settings.copy(WATER_STRAINER_BASE)));
        DENSE_WATER_STRAINER_NET = register("dense_water_strainer_net", new WaterStrainerNetBlock(Block.Settings.copy(WATER_STRAINER_NET)));
    }

    private static <T extends Block> T register(String name, T block) {
        return Registry.register(Registry.BLOCK, new Identifier(WaterStrainer.ID, name), block);
    }
}
