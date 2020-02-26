package net.cheatercodes.fluid_sieve.block.entity;

import net.cheatercodes.fluid_sieve.FluidSieve;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public class FluidSieveBlockEntityTypes {
    public static FluidSieveBlockEntityTypes INSTANCE = new FluidSieveBlockEntityTypes();

    public final BlockEntityType<BaseBlockEntity> BASE;

    private FluidSieveBlockEntityTypes() {
        BASE = register(BaseBlockEntity::new, FluidSieve.BLOCKS.BASE);
    }

    private static <T extends BlockEntity> BlockEntityType<T> register(Supplier<T> blockEntitySupplier, Block block) {
        BlockEntityType<T> type = BlockEntityType.Builder.create(blockEntitySupplier, block).build(null);
        Identifier id = Registry.BLOCK.getId(block);
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, id, type);
    }
}
