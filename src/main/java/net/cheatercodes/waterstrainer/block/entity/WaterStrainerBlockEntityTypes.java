package net.cheatercodes.waterstrainer.block.entity;

import net.cheatercodes.waterstrainer.WaterStrainer;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public class WaterStrainerBlockEntityTypes {
    public static WaterStrainerBlockEntityTypes INSTANCE = new WaterStrainerBlockEntityTypes();

    public final BlockEntityType<WaterStrainerBaseBlockEntity> WATER_STRAINER_BASE;

    private WaterStrainerBlockEntityTypes() {
        WATER_STRAINER_BASE = register(WaterStrainerBaseBlockEntity::new, WaterStrainer.BLOCKS.WATER_STRAINER_BASE);
    }

    private static <T extends BlockEntity> BlockEntityType<T> register(Supplier<T> blockEntitySupplier, Block block) {
        BlockEntityType<T> type = BlockEntityType.Builder.create(blockEntitySupplier, block).build(null);
        Identifier id = Registry.BLOCK.getId(block);
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, id, type);
    }
}
