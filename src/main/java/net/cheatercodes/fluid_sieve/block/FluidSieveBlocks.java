package net.cheatercodes.fluid_sieve.block;

import net.cheatercodes.fluid_sieve.FluidSieve;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FluidSieveBlocks {
    public static FluidSieveBlocks INSTANCE = new FluidSieveBlocks();

    public final BaseBlock BASE;
    public final NetBlock NET;
    public final NetBlock DENSE_NET;

    private FluidSieveBlocks() {
        BASE = register("base", new BaseBlock(Block.Settings.copy(Blocks.OAK_PLANKS)));
        NET = register("net", new NetBlock(Block.Settings.copy(BASE)));
        DENSE_NET = register("dense_net", new NetBlock(Block.Settings.copy(NET)));
    }

    private static <T extends Block> T register(String name, T block) {
        return Registry.register(Registry.BLOCK, new Identifier(FluidSieve.ID, name), block);
    }
}
