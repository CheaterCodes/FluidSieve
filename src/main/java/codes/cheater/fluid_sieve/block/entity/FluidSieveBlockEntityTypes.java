package codes.cheater.fluid_sieve.block.entity;

import codes.cheater.fluid_sieve.FluidSieve;
import codes.cheater.fluid_sieve.block.FluidSieveBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class FluidSieveBlockEntityTypes {
    public static final BlockEntityType<BaseBlockEntity> BASE =
            BlockEntityType.Builder.create(BaseBlockEntity::new, FluidSieveBlocks.BASE).build(null);

    public static void register() {
        Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(FluidSieve.MOD_ID, "base"), BASE);
    }
}
