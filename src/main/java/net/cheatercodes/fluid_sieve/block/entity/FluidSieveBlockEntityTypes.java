package net.cheatercodes.fluid_sieve.block.entity;

import net.cheatercodes.fluid_sieve.FluidSieve;
import net.cheatercodes.fluid_sieve.block.FluidSieveBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FluidSieveBlockEntityTypes {
    public static final BlockEntityType<BaseBlockEntity> BASE = BlockEntityType.Builder.create(BaseBlockEntity::new, FluidSieveBlocks.BASE).build(null);

    public static void register() {
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(FluidSieve.MOD_ID, "base"), BASE);
    }
}
