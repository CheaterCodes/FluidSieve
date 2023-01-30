package codes.cheater.fluid_sieve.block;

import codes.cheater.fluid_sieve.FluidSieve;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class FluidSieveBlocks {
    public static final BaseBlock BASE = new BaseBlock(Block.Settings.copy(Blocks.OAK_PLANKS));
    public static final NetBlock NET = new NetBlock(Block.Settings.copy(BASE));
    public static final NetBlock DENSE_NET = new NetBlock(Block.Settings.copy(NET));

    public static void register() {
        Registry.register(Registries.BLOCK, new Identifier(FluidSieve.MOD_ID, "base"), BASE);
        Registry.register(Registries.BLOCK, new Identifier(FluidSieve.MOD_ID, "net"), NET);
        Registry.register(Registries.BLOCK, new Identifier(FluidSieve.MOD_ID, "dense_net"), DENSE_NET);
    }
}
